package artcitlocator.wikipedia.crawling.control;

import artcitlocator.data.GraphDatabase.NeoJHandler;
import artcitlocator.wikipedia.crawling.calculation.Calculator;
import artcitlocator.wikipedia.crawling.calculation.ECalculator;
import artcitlocator.wikipedia.crawling.control.worker.GraphDBWorker;
import artcitlocator.wikipedia.crawling.control.worker.WikiDBWorker;
import artcitlocator.wikipedia.crawling.rational.database.RationalDatabaseHandler;
import artcitlocator.wikipedia.xml.parser.WikiParser;

public class Controller {

	protected boolean RUNNING = true;

	public Controller() {
		
	}
	
	private void saveWikiInDatabase(String path){
		RationalDatabaseHandler dbhandler = new RationalDatabaseHandler();
		WorkerFactory factory = new WorkerFactory(dbhandler, 8, new WikiDBWorker());
		
		Thread t = new Thread(factory);
		t.start();
		
		WikiParser parser = new WikiParser(factory);
		
		System.out.println("Starte Parsing");
		parser.saxParsing(path);
//		parser.domParsing(path);
		
		factory.join();
	}
	
	private void crawlWikiDatabase(){
		NeoJHandler dbhandler = NeoJHandler.getInstance();
		
		WorkerFactory factory = new WorkerFactory(dbhandler, 8, new GraphDBWorker());
		
		Thread t = new Thread(factory);
		t.start();
		
		WikiCrawler crawler = new WikiCrawler(factory, new RationalDatabaseHandler());
		
		crawler.crawlDatabase();
		
		factory.join();
	}
	
	private void calculate(){
		NeoJHandler dbhandler = NeoJHandler.getInstance();
		
		Calculator calc = new ECalculator(dbhandler);
		
		System.out.println("starte calculation");
		calc.calculate();
		
	}
	
	public void doWork(String path){
//		saveWikiInDatabase(path);
		
		crawlWikiDatabase();
		
//		calculate();
		
//		NeoJHandler dbhandler = NeoJHandler.getInstance();
		
//		dbhandler.shutdown();
		System.out.println("fertig");
	}
	
	public static void main(String[] args) {
		Controller main = new Controller();
		main.doWork("E:/Projekt/workspace/enwiki-20150205-pages-articles.xml.bz2");
	}
}
