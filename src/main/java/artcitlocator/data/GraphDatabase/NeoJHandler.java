package artcitlocator.data.GraphDatabase;

import java.util.ArrayList;
import java.util.Map;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import org.neo4j.rest.graphdb.RestAPI;
import org.neo4j.rest.graphdb.RestAPIFacade;
import org.neo4j.rest.graphdb.RestGraphDatabase;
import org.neo4j.rest.graphdb.query.RestCypherQueryEngine;
import org.neo4j.rest.graphdb.util.QueryResult;
import org.neo4j.tooling.GlobalGraphOperations;

import artcitlocator.wikipedia.crawling.control.data.City;
import artcitlocator.wikipedia.crawling.control.data.ConnectionCityEntity;
import artcitlocator.wikipedia.crawling.control.data.Entity;
import artcitlocator.wikipedia.crawling.control.worker.DatabaseHandler;

public class NeoJHandler implements DatabaseHandler{

	public static String HOST = "192.168.2.121";
	public static int PORT = 7474;
	public static String DATABASE = "db";
	
	public static String COUNT = "count";
	public static String NAME = "name";
	public static String LONGITUDE = "lon";
	public static String LATITUDE = "lat";
	public static String WEIGHT = "weight";

	private static NeoJHandler instance;

	private GraphDatabaseService gds;
	private Label cityLabel = DynamicLabel.label("City");
	private Label entityLabel = DynamicLabel.label("Entity");
	private RestCypherQueryEngine engine;

	private NeoJHandler() {
//		gds = new RestGraphDatabase("http://localhost:7474/");
// 		gds = new RestGraphDatabase("http://localhost:7474/db/data",username,password);
//		gds =  new GraphDatabaseFactory().newEmbeddedDatabase("E:/Projekt/workspace/graphdb");
		RestAPI api = new RestAPIFacade("http://" + HOST + ":" + PORT + "/db/data/");
		gds = new RestGraphDatabase(api);
		engine = new RestCypherQueryEngine(api);
	}

	public void saveCity(City city) {
		Transaction tx = gds.beginTx();
		Node cityNode;
		
		cityNode = gds.createNode(cityLabel);
		cityNode.setProperty(NAME, city.getName());
		cityNode.setProperty(LATITUDE, city.getLati());
		cityNode.setProperty(LONGITUDE, city.getLongi());

//		cities.add(cityNode, cityLabel.name(), city.getName());

		tx.success();
		tx.close();

		for (Entity entity : city.getEntities()) {
			saveEntity(entity, cityNode);
		}
	}

	private void saveEntity(Entity entity, Node cityNode) {
		Transaction tx = gds.beginTx();
		int count;
		Node entityNode = null;
//		IndexHits<Node> entHit;

//		entHit = entities.get("name, type", entity.getName() + ", " + entity.getType());
//		entityNode = entHit.getSingle();
		QueryResult<Map<String,Object>> result = engine.query("MATCH (node:" + entityLabel.name() + ") WHERE node." + NAME + " = \"" + entity.getName() + "\" RETURN node", null);

		for (Map<String, Object> row : result) {
			entityNode = (Node) row.get("node");
		}

		if (entityNode == null) {
			entityNode = gds.createNode(entityLabel);
			entityNode.setProperty(NAME, entity.getName());
			entityNode.setProperty(COUNT, 1);
			entityNode.setProperty(WEIGHT, entity.getIdf());
			
//			entities.add(entityNode, "name, type", entity.getName() + ", " + entity.getType());
			
			createConnection(cityNode, entityNode);
		} else {
			count = (int) entityNode.getProperty(COUNT);
			entityNode.removeProperty(COUNT);
			count = count + 1;
			entityNode.setProperty(COUNT, count);
			
			createConnection(cityNode, entityNode);
		}

		tx.success();
		tx.close();
	}

	private void createConnection(Node cityNode, Node entityNode) {
		Transaction tx = gds.beginTx();	
		Relationship relationship = null;
		
//		MATCH (entity { name:'?' })-[r]->(city { name: '?' })RETURN r
		QueryResult<Map<String,Object>> result = engine.query("MATCH (entity { " + NAME + ":'" + entityNode.getProperty(NAME) + "' })-[r:IN]->(city { " + NAME + ": '" + cityNode.getProperty(NAME) + "' })RETURN r", null);
		
		for (Map<String, Object> row : result) {
			relationship = (Relationship) row.get("r");
		}
		
		if(relationship == null){
			relationship = entityNode.createRelationshipTo(cityNode, RelationshipTypes.IN);
			relationship.setProperty(COUNT, 1);
		}else{
			int count = (int) relationship.getProperty(COUNT);
			relationship.removeProperty(COUNT);
			count = count + 1;
			relationship.setProperty(COUNT, count);
		}
		
		tx.success();
		tx.close();
	}

	public void shutdown() {
		gds.shutdown();
	}
	
	public static NeoJHandler getInstance() {
		if (instance == null) {
			instance = new NeoJHandler();
		}

		return instance;
	}

	public long[] getAllRelationIDs() {
		Transaction tx = gds.beginTx();	
		ArrayList<Long> list = new ArrayList<Long>();
		long[] rc;
		Iterable<Relationship> relationships = GlobalGraphOperations.at(gds).getAllRelationships();
		
		for (Relationship relationship : relationships) {
			list.add(relationship.getId());
		}
		
		rc = new long[list.size()];
		for (int i = 0; i < rc.length; i++) {
			rc[i] = list.get(i);
		}
		
		tx.success();
		tx.close();
		return rc;
	}

	public ConnectionCityEntity getRelationByID(long i) {
		Transaction tx = gds.beginTx();	
		ConnectionCityEntity rc = new ConnectionCityEntity();
		
		Relationship rel = gds.getRelationshipById(i);
		
		Node entity = rel.getStartNode();
		
		rc.setCounterConnection((int) rel.getProperty(COUNT));
		rc.setCounterEntity((int) entity.getProperty(COUNT));
		
		tx.success();
		tx.close();
		return rc;
	}

	public void storeRelationWeight(long i, double weight) {
		Transaction tx = gds.beginTx();	
		
		Relationship rel = gds.getRelationshipById(i);
		rel.setProperty("weight", weight);
		
		tx.success();
		tx.close();
	}
	
	public static void main(String[] args) {
		NeoJHandler test = new NeoJHandler();
		
		City city = new City("TESTStadt", 22.22, 33.33);
		City cityZwo = new City("stadt", 22.22, 33.33);
		
		for (int i = 0; i < 10; i++) {
			city.getEntities().add(new Entity("test", ""));
			cityZwo.getEntities().add(new Entity("test", ""));
			
			city.getEntities().add(new Entity("nomalo", ""));
			cityZwo.getEntities().add(new Entity("nomalo", ""));
		}
		
		test.saveCity(city);
		test.saveCity(cityZwo);
	}
}
