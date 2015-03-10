package artcitlocator.wikipedia.xml.parser;

import artcitlocator.wikipedia.crawling.control.Worker;
import artcitlocator.wikipedia.crawling.control.WorkerFactory;
import edu.jhu.nlp.wikipedia.PageCallbackHandler;
import edu.jhu.nlp.wikipedia.WikiPage;
import edu.jhu.nlp.wikipedia.WikiPageIterator;
import edu.jhu.nlp.wikipedia.WikiXMLParser;
import edu.jhu.nlp.wikipedia.WikiXMLParserFactory;

public class WikiParser {

	private Worker worker;

	public WikiParser(Worker worker) {
		this.worker = worker;
	}

	/**
	 * scheiß variante => heap space ...
	 * 
	 * @param path
	 */
	public void domParsing(String path) {
		WikiXMLParser wxp = WikiXMLParserFactory.getDOMParser(path);
		try {
			wxp.parse();
			WikiPageIterator it = wxp.getIterator();
			while (it.hasMorePages()) {
				WikiPage page = it.nextPage();
				// worker.process(page);
				WorkerFactory.getInstance().addPage(page);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saxParsing(String path) {
		WikiXMLParser wxsp = WikiXMLParserFactory.getSAXParser(path);

		try {
			wxsp.setPageCallback(new PageCallbackHandler() {
				public void process(WikiPage page) {
					// worker.process(page);
					WorkerFactory.getInstance().addPage(page);
				}
			});

			wxsp.parse();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		WikiParser test = new WikiParser(null);
		test.saxParsing("E:/Projekt/workspace/enwiki-20150205-pages-articles.xml.bz2");
	}
}
