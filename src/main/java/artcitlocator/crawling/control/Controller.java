package artcitlocator.crawling.control;

import artcitlocator.crawling.wikipedia.xml.parser.WikiParser;
import artcitlocator.data.graphDatabase.NeoJHandler;

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
