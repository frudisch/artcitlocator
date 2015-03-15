package artcitlocator.wikipedia.crawling.control.worker;

import java.util.ArrayDeque;

import artcitlocator.wikipedia.crawling.rational.database.RationalDatabaseHandler;
import edu.jhu.nlp.wikipedia.WikiPage;

public class WikiDBWorker implements Worker{

	private boolean RUNNING = true;

	private ArrayDeque<WikiPage> toDo;
	private int id;
	private RationalDatabaseHandler dbHandler;
	
	public WikiDBWorker() {
		toDo = new ArrayDeque<WikiPage>();
	}
	
	public void run() {
		while (RUNNING) {
			if (toDo.peek() != null) {
				WikiPage page;
				synchronized(toDo){
					page = toDo.poll();
				}
				
				dbHandler.saveEntry(page.getTitle(), page.getText());
			} else {
				sleep();
			}
		}
		dbHandler.shutdown();
	}

	private void sleep() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void process(WikiPage page) {
		synchronized(toDo){
			toDo.add(page);
		}
	}

	public void setID(int id) {
		this.id = id;
	}
	
	public int getID(){
		return this.id;
	}

	public void setHandler(DatabaseHandler dbHandler) {
		this.dbHandler = (RationalDatabaseHandler) dbHandler;
	}

	public Worker newInstance() {
		return new WikiDBWorker();
	}

	
}
