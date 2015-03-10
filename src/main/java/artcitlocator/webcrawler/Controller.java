package artcitlocator.webcrawler;

import java.util.List;

import artcitlocator.webcrawler.config.Configuration;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class Controller {
	
	private final String STORAGE_DIR = "./data/crawl/";
	private final int THREAD_COUNT = 10;
	
	public void startCrawl(String crawlerName, Class<? extends WebCrawler> crawlerClass) throws Exception{
		Configuration conf = new Configuration();
		CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(STORAGE_DIR);
        config.setPolitenessDelay(200); //default
        /*
         * Instantiate the controller for this crawl.
         */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        /*
         * For each crawl, you need to add some seed urls. These are the first
         * URLs that are fetched and then the crawler starts following links
         * which are found in these pages
         */
        List<String> seeds = conf.getSeedsByName(crawlerName);
        for(String seed : seeds){
        	controller.addSeed(seed);
        }

        /*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
        controller.start(crawlerClass, THREAD_COUNT);
	}
	
	public static void main(String[] args) throws Exception {
        Controller control = new Controller();
        control.startCrawl("NYT", NYTCrawler.class);
    }

}
