package artcitlocator.wikipedia.crawling.control.worker;

import edu.jhu.nlp.wikipedia.WikiPage;

public interface Worker extends Runnable {

	public void process(WikiPage page);

	public void setID(int id);
	
	public void setHandler(DatabaseHandler dbHandler);

	public Worker newInstance();
}
