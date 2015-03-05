package artcitlocator.crawling.control;

import edu.jhu.nlp.wikipedia.WikiPage;
import artcitlocator.crawling.control.data.City;
import artcitlocator.data.graphDatabase.NeoJHandler;

public class Worker {

	private NeoJHandler dbHandler;
	private CityCreator cityCreator;

	public Worker(NeoJHandler dbHandler) {
		this.dbHandler = dbHandler;
		this.cityCreator = new CityCreator();
	}

	public void process(WikiPage page) {
		City temp = cityCreator.extractCity(page.getTitle(), page.getText());
		
		if(temp != null){
			dbHandler.saveCity(temp);
		}
	}

}
