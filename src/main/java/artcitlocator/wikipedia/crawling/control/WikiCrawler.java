package artcitlocator.wikipedia.crawling.control;

import edu.jhu.nlp.wikipedia.WikiPage;
import artcitlocator.wikipedia.crawling.rational.database.RationalDatabaseHandler;
import artcitlocator.wikipedia.crawling.rational.database.entity.WikiEntry;

public class WikiCrawler {
	
	private WorkerFactory factory;
	private RationalDatabaseHandler dbHandler;

	public WikiCrawler(WorkerFactory factory, RationalDatabaseHandler dbHandler) {
		this.factory = factory;
		this.dbHandler = dbHandler;
	}

	public void crawlDatabase(){
		long[] ids = dbHandler.getAllIds();
		
		for (long l : ids) {
			WikiEntry entry = dbHandler.getEntry(l);
			
			WikiPage page = new WikiPage();
			
			page.setTitle(entry.getTitle());
			page.setWikiText(entry.getText());
			
			factory.addPage(page);
			sleep();
		}
	}

	private void sleep() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
