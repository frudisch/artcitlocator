package artcitlocator.wikipedia.crawling.rational.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import artcitlocator.wikipedia.crawling.control.worker.DatabaseHandler;
import artcitlocator.wikipedia.crawling.rational.database.entity.WikiEntry;
import artcitlocator.wikipedia.crawling.rational.database.entity.WikiEntry_;

public class RationalDatabaseHandler implements DatabaseHandler{

	private EntityManagerFactory emf;

	public RationalDatabaseHandler() {
		emf = Persistence.createEntityManagerFactory("artcitlocator_temp");
	}
	
	public void saveEntry(String title, String text){
		EntityManager em = emf.createEntityManager(); 
		WikiEntry entry = new WikiEntry();
		
		entry.setText(text);
		entry.setTitle(title);
		
		em.getTransaction().begin();
		
		em.persist(entry);

		em.getTransaction().commit();
		em.close();
	}

	public long[] getAllIds() {
		long[] rc;
		
		Session session = (Session) emf.createEntityManager().getDelegate();
		
		Criteria query = session.createCriteria(WikiEntry.class)
				.setProjection(Projections.projectionList().add(Projections.property(WikiEntry_.id.getName())));
		
		List<?> list = query.list();
		rc = new long[list.size()];
		int i = 0;
		for (Object id : list) {
			rc[i++] = (long) id;
		}
		
		session.close();
		return rc;
	}

	public WikiEntry getEntry(long l) {
		Session session = (Session) emf.createEntityManager().getDelegate();
		
		Criteria query = session.createCriteria(WikiEntry.class)
				.add(Restrictions.eq(WikiEntry_.id.getName(), l));
		
		WikiEntry rc = (WikiEntry) query.uniqueResult();
		
		session.close();
		return rc;
	}
	
	public void shutdown(){
		emf.close();
	}
	
	public static void main(String[] args) {
		RationalDatabaseHandler test = new RationalDatabaseHandler();
		
		long[] ids = test.getAllIds();
		
		System.out.println(ids.length);
		
		test.shutdown();
		
//		for (long l : ids) {
//			System.out.println(l);
//		}
//		
//		WikiEntry entry = test.getEntry(10000);
//		
//		System.out.println(entry.getTitle());
	}
}
