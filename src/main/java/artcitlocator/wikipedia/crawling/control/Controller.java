package artcitlocator.wikipedia.crawling.control;

import artcitlocator.data.GraphDatabase.NeoJHandler;
import artcitlocator.wikipedia.xml.parser.WikiParser;

public class Controller {

	public Controller() {
		
	}
	
	public void doWork(String path){
		NeoJHandler dbhandler = NeoJHandler.getInstance();
		
		Worker worker = new Worker(dbhandler);
		
		WikiParser parser = new WikiParser(worker);
		
		parser.saxParsing(path);
	}
}
