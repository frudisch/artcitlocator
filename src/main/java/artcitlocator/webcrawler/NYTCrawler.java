package artcitlocator.webcrawler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import artcitlocator.webcrawler.config.Configuration;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class NYTCrawler extends WebCrawler {

	private final String CRAWLER_NAME = "NYT";
	private List<Pattern> pattern;
	private String domain;
	
	public NYTCrawler() {
		super();
		Configuration conf = new Configuration();
		List<String> patternStrings = conf.getPatternByName(CRAWLER_NAME);
		pattern = new ArrayList<Pattern>();
		for(int i = 0; i < patternStrings.size(); i++){
			pattern.add(Pattern.compile(patternStrings.get(i)));
		}
		
		domain = conf.getCrawlerByName(CRAWLER_NAME).getUrl().toLowerCase();
	}

	@Override
	public boolean shouldVisit(Page referringPage, WebURL url) {
		String href = url.getURL().toLowerCase();
		if(!href.startsWith(domain)) return false;
		for(Pattern pat : pattern){
			if(!pat.matcher(href).matches()) return false;
		}
		
		return true;
	}

	/**
	 * This function is called when a page is fetched and ready to be processed
	 * by your program.
	 */
	@Override
	public void visit(Page page) {
		String url = page.getWebURL().getURL();
		System.out.println("URL: " + url);

		if (page.getParseData() instanceof HtmlParseData) {
			HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
			String text = htmlParseData.getText();
			String html = htmlParseData.getHtml();
			Set<WebURL> links = htmlParseData.getOutgoingUrls();

			System.out.println("Text length: " + text.length());
			System.out.println("Html length: " + html.length());
			System.out.println("Number of outgoing links: " + links.size());
		}
	}

}
