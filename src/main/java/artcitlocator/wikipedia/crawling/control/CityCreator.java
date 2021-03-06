package artcitlocator.wikipedia.crawling.control;

import java.util.ArrayList;

import artcitlocator.control.POSAnalyze;
import artcitlocator.wikipedia.crawling.control.data.City;
import artcitlocator.wikipedia.crawling.control.data.Entity;

public class CityCreator {

//	private static final String clfFilename = "./classifiers/english.muc.7class.distsim.crf.ser.gz";
	private LatitudeLongitudeParser llp;
//	private NERAnalyze ner;
	private WikiTextCleaner cleaner;
	private POSAnalyze pos;
	
	public CityCreator() {
		this.llp = new LatitudeLongitudeParser();
//		this.ner = new NERAnalyze(clfFilename);
		this.pos = new POSAnalyze();
		this.cleaner = new WikiTextCleaner();
	}

	public City extractCity(String title, String text) {
		ArrayList<Entity> entities;
		double[] coords;
		City city = null;
		
//		if(!checkIfCity(text)) return null;
	
//		entities = ner.extractEntities(cleaner.cleanText(text));
		try{
			entities = pos.tagText(cleaner.cleanText(text));
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(text);
			return null;
		}
		
		coords = llp.parseLatLon(text);
		
		if(coords == null){
			return null;
		}else if((coords[0] == 0.0 && coords[1] == 0.0)){
			return null;
		}
		
		if(coords != null){
			city = new City(0, title, coords[0], coords[1]);
			city.setEntities(entities);
		}
		
		return city;
	}

}
