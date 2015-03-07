package artcitlocator.wikipedia.crawling.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import artcitlocator.control.NERAnalyze;
import artcitlocator.wikipedia.crawling.control.data.City;
import artcitlocator.wikipedia.crawling.control.data.Entity;

public class CityCreator {

	private static final String clfFilename = null;
	private LatitudeLongitudeParser llp;
	private NERAnalyze ner;
	private WikiTextCleaner cleaner;
	
	public CityCreator() {
		this.llp = new LatitudeLongitudeParser();
		this.ner = new NERAnalyze(clfFilename);
		this.cleaner = new WikiTextCleaner();
	}

	public City extractCity(String title, String text) {
		ArrayList<Entity> entities;
		double[] coords;
		City city = null;
		
		if(!checkIfCity(text)) return null;
	
		try {
			entities = ner.extractEntities(cleaner.cleanText(text));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return null;
		} catch (SAXException e) {
			e.printStackTrace();
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

	public boolean checkIfCity(String text) {
		return text.replaceAll("\\s", "").contains("|population");
		
	}
}
