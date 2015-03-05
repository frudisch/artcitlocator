package artcitlocator.crawling.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import artcitlocator.crawling.wikipedia.database.entity.Text;

public class WikipediaDBHandler {
	private EntityManager em;
	private Session session;

	public WikipediaDBHandler() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("artcitlocator");

		em = emf.createEntityManager();
	}

	public int getAmountTextes() {
		session = (Session) em.getDelegate();

		Criteria criteria = session
				.createCriteria(Text.class)
				.setProjection(
						Projections.projectionList().add(
								Projections.property("oldId")))
				.addOrder(Order.desc("oldId"))
				.setMaxResults(1);
		
		int rc = (Integer) criteria.uniqueResult(); 
		
		return rc;
	}
	
	public Text getTextByID(int id){
		session = (Session) em.getDelegate();
		
		Criteria criteria = session
				.createCriteria(Text.class)
				.add(Restrictions.eq("oldId", id))
				;
		
		@SuppressWarnings("unchecked")
		List<Text> rc = criteria.list();
		
		if(rc.size() > 1){
			System.err.println("mehr als ein eintrag für id: " + id);
		}
		
		if(rc.size() == 0) {
			return null;
		}else{
			return rc.get(0);
		}
	}
	
	public void close(){
		session.close();
	}
	
	public static void main(String[] args) {
		WikipediaDBHandler test = new WikipediaDBHandler();
		
		System.out.println(test.getAmountTextes());
		
		System.out.println(new String(test.getTextByID(test.getAmountTextes()).getOldText()));
		
		test.close();
	}
}
