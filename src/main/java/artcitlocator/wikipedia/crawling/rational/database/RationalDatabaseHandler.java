package artcitlocator.wikipedia.crawling.rational.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

import artcitlocator.wikipedia.crawling.control.worker.DatabaseHandler;
import artcitlocator.wikipedia.crawling.rational.database.entity.WikiEntry;

public class RationalDatabaseHandler implements DatabaseHandler{

	private EntityManagerFactory emf;

	public RationalDatabaseHandler() {
		emf = Persistence.createEntityManagerFactory("artcitlocator_temp");
	}
	
	public void saveEntry(String title, String text){
		EntityManager em = emf.createEntityManager(); 
		WikiEntry entry = new WikiEntry();
		
		Session session = (Session) em.getDelegate();
		
		entry.setText(text);
		entry.setTitle(title);
		
		em.persist(entry);
		session.persist(entry);

		session.flush();
		session.close();
	}

	public long[] getAllIds() {
		// TODO Auto-generated method stub
		return null;
	}

	public WikiEntry getEntry(long l) {
		// TODO Auto-generated method stub
		return null;
	}
}
