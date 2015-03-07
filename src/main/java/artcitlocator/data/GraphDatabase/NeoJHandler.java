package artcitlocator.data.GraphDatabase;

import java.util.ArrayList;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.index.Index;
import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.graphdb.index.IndexManager;
import org.neo4j.graphdb.index.RelationshipIndex;
import org.neo4j.graphdb.schema.Schema;
import org.neo4j.rest.graphdb.RestGraphDatabase;
import org.neo4j.tooling.GlobalGraphOperations;

import artcitlocator.wikipedia.crawling.control.data.City;
import artcitlocator.wikipedia.crawling.control.data.ConnectionCityEntity;
import artcitlocator.wikipedia.crawling.control.data.Entity;

public class NeoJHandler {

	public static String HOST = "localhost";
	public static int PORT = 7474;
	public static String DATABASE = "db";

	private static NeoJHandler instance;

	private GraphDatabaseService gds;
	private Label cityLabel = DynamicLabel.label("City");
	private Label entityLabel = DynamicLabel.label("Entity");
	private Index<Node> entities;
	private Index<Node> cities;
	private RelationshipIndex relationships;

	private NeoJHandler() {
		gds = new RestGraphDatabase("http://localhost:7474/db/data");
// 		gds = new RestGraphDatabase("http://localhost:7474/db/data",username,password);

		Schema schema;
		Transaction tx = gds.beginTx();

		schema = gds.schema();
		IndexManager index = gds.index();
		entities = index.forNodes(entityLabel.name());
		cities = index.forNodes(cityLabel.name());
		relationships = index.forRelationships(RelationshipTypes.IN.name());
		try {
			schema.indexFor(entityLabel).on("nameType").create();
		} catch (Exception e) {
			e.printStackTrace();
		}

		tx.success();
		tx.close();
	}

	public void saveCity(City city) {
		Transaction tx = gds.beginTx();
		Node cityNode;

		cityNode = gds.createNode(cityLabel);
		cityNode.setProperty("name", city.getName());
		cityNode.setProperty("latitude", city.getLati());
		cityNode.setProperty("longitude", city.getLongi());

		cities.add(cityNode, cityLabel.name(), city.getName());

		tx.success();
		tx.close();

		for (Entity entity : city.getEntities()) {
			saveEntity(entity, cityNode);
		}
	}

	private void saveEntity(Entity entity, Node cityNode) {
		Transaction tx = gds.beginTx();
		int counter;
		Node entityNode = null;
		IndexHits<Node> entHit;

		entHit = entities.get("name, type", entity.getName() + ", " + entity.getType());
		entityNode = entHit.getSingle();

		if (entityNode == null) {
			entityNode = gds.createNode(entityLabel);
			entityNode.setProperty("name", entity.getName());
			entityNode.setProperty("type", entity.getType());
			entityNode.setProperty("counter", 1);
			entityNode.setProperty("idf", entity.getIdf());
			
			createConnection(cityNode, entityNode);
		} else {
			counter = Integer.valueOf((String) entityNode.getProperty("counter"));
			entityNode.removeProperty("counter");
			++counter;
			entityNode.setProperty("counter", counter);
			
			updateConnection(cityNode, entityNode);
		}

		entities.add(entityNode, "name, type", entity.getName() + ", " + entity.getType());

		tx.success();
		tx.close();
	}

	private void updateConnection(Node cityNode, Node entityNode) {
		Transaction tx = gds.beginTx();	
		
		for (Relationship rel : entityNode.getRelationships()) {
			if(rel.getOtherNode(entityNode).equals(cityNode)){
				int count = Integer.valueOf((String)rel.getProperty("count"));
				rel.removeProperty("count");
				count = count + 1;
				rel.setProperty("count", count);
				break;
			}
		}
		
		tx.success();
		tx.close();
	}

	private void createConnection(Node cityNode, Node entityNode) {
		Transaction tx = gds.beginTx();	
		Relationship relationship;
		
		relationship = entityNode.createRelationshipTo(cityNode, RelationshipTypes.IN);
		relationship.setProperty("count", 1);
		relationships.add(relationship, "entity -> city", entityNode.getProperty("name") + " -> " + cityNode.getProperty("name"));
		
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
		
		rc.setCounterConnection((int) rel.getProperty("count"));
		rc.setCounterEntity((int) entity.getProperty("counter"));
		
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
}
