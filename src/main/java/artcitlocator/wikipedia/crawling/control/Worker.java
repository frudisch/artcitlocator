package artcitlocator.wikipedia.crawling.control;

import edu.jhu.nlp.wikipedia.WikiPage;
import artcitlocator.data.GraphDatabase.NeoJHandler;
import artcitlocator.wikipedia.crawling.control.data.City;

public class Worker {

	private NeoJHandler dbHandler;
	private CityCreator cityCreator;
	private int counter = 0;

	public Worker(NeoJHandler dbHandler) {
		this.dbHandler = dbHandler;
		this.cityCreator = new CityCreator();
	}

	public void process(WikiPage page) {
		City temp = cityCreator.extractCity(page.getTitle(), page.getText());
		
		counter = counter + 1;
		System.out.println(counter);
		
		if(temp != null){
			dbHandler.saveCity(temp);
		}
	}

}
