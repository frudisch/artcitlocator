package artcitlocator.wikipedia.crawling.control;

import artcitlocator.data.GraphDatabase.NeoJHandler;
import artcitlocator.wikipedia.crawling.calculation.Calculator;
import artcitlocator.wikipedia.crawling.calculation.ECalculator;
import artcitlocator.wikipedia.xml.parser.WikiParser;

public class Controller {

	public Controller() {
		
	}
	
	public void doWork(String path){
		NeoJHandler dbhandler = NeoJHandler.getInstance();
		
		Worker worker = new Worker(dbhandler);
		
		WikiParser parser = new WikiParser(worker);
		
		System.out.println("Starte Parsing");
		parser.saxParsing(path);
		
		Calculator calc = new ECalculator(dbhandler);
		
		System.out.println("starte calculation");
		calc.calculate();
		
		System.out.println("fertig");
	}
	
	public static void main(String[] args) {
		Controller main = new Controller();
		main.doWork("E:/Projekt/workspace/enwiki-20150205-pages-articles.xml.bz2");
	}
}
