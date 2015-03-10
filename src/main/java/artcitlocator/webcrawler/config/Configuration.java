/**
 * 
 */
package artcitlocator.webcrawler.config;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import artcitlocator.tools.config.ConfigHandler;
import artcitlocator.tools.config.XMLConfigHandler;
import artcitlocator.webcrawler.config.CrawlerConfig.Crawler;

/**
 * @author Daniel
 *
 */
public class Configuration {
	
	private final String CONFIG_PATH = "./src/main/resources/webcrawling/configuration.xml";
	private ConfigHandler confHandler;
	
	private CrawlerConfig crawlerConfig;
	
	public Configuration(){
		reload();
	}
	
	public void reload(){
		this.confHandler = new XMLConfigHandler();
		confHandler.init(CrawlerConfig.class, CONFIG_PATH);
		crawlerConfig = (CrawlerConfig) confHandler.load();
	}
	
	public List<String> getPatternByName(String crawlerName){
		List<String> rc = new ArrayList<String>();
		List<Crawler> crawlers = crawlerConfig.getCrawler();
		Crawler crawler = null;
		for(Crawler tempCrawler : crawlers){
			if(tempCrawler.getName().equals(crawlerName)) crawler = tempCrawler;
		}
		
		if(crawler == null) return rc;
		
		List<Serializable> content = crawler.getContent();
		QName qname = new QName("", "pattern");
		for (Iterator<Serializable> iterator = content.iterator(); iterator.hasNext();) {
			Serializable s = iterator.next();
			if( s instanceof String ){
	            //doNothing
	        } else {
	            String tag = ((JAXBElement)s).getName().getLocalPart();
	            if(tag.equals("pattern")) {
	            	rc.add((String)((JAXBElement)s).getValue());
	            }
	        }
		}
		
		return rc;
	}
	
	public List<String> getSeedsByName(String crawlerName){
		List<String> rc = new ArrayList<String>();
		List<Crawler> crawlers = crawlerConfig.getCrawler();
		Crawler crawler = null;
		for(Crawler tempCrawler : crawlers){
			if(tempCrawler.getName().equals(crawlerName)) crawler = tempCrawler;
		}
		
		if(crawler == null) return rc;
		
		List<Serializable> content = crawler.getContent();
		for (Iterator<Serializable> iterator = content.iterator(); iterator.hasNext();) {
			Serializable s = iterator.next();
			if( s instanceof String ){
				//doNothing
	        } else {
	            String tag = ((JAXBElement)s).getName().getLocalPart();
	            if(tag.equals("seed")) {
	            	rc.add((String)((JAXBElement)s).getValue());
	            }
	        }
		}
		
		return rc;
	}
	
	public Crawler getCrawlerByName(String crawlerName){
		List<Crawler> crawlers = crawlerConfig.getCrawler();
		for(Crawler tempCrawler : crawlers){
			if(tempCrawler.getName().equals(crawlerName)) return tempCrawler;
		}
		
		return null;
	}

}
