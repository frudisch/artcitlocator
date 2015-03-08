package artcitlocator.control;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import artcitlocator.wikipedia.crawling.control.data.Entity;
import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;

public class NERAnalyze {

	private AbstractSequenceClassifier<?> classifier;
	
	public NERAnalyze(String clfFilename)
	{
		classifier = CRFClassifier.getClassifierNoExceptions(clfFilename);
	}
	
	public ArrayList<Entity> extractEntities(String text) {

		ArrayList<Entity> entities = new ArrayList<Entity>();
		String resultInXml = classifier.classifyToString(text, "xml", false);
		StringBuffer buffer = new StringBuffer("<root>");
		buffer.append(resultInXml);
		buffer.append("</root>");
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return null;
		}
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(buffer.toString()));
		
		Document doc;
		try {
			doc = db.parse(is);
		} catch (SAXException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		NodeList nodes = doc.getElementsByTagName("wi");
		
		for (int i = 0; i < nodes.getLength(); i++){
			Element element = (Element) nodes.item(i);
			
			if(!element.getAttribute("entity").equals("O")){
				entities.add(new Entity(element.getNodeValue(), element.getAttribute("entity")));
			}
			
		}
		
		return entities;
	}
	
	public static void main(String[] args) {
		NERAnalyze test = new NERAnalyze("./classifiers/english.muc.7class.distsim.crf.ser.gz");
		test.extractEntities("HI");
	}
}
