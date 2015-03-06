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

import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import artcitlocator.wikipedia.crawling.control.data.Entity;

public class StanfordNER {
	private AbstractSequenceClassifier<?> classifier;
	private String serializedClassifier;

	public StanfordNER(String clfFilename)
	{
		serializedClassifier = clfFilename;
		classifier = CRFClassifier.getClassifierNoExceptions(serializedClassifier);
	}

	public ArrayList<Entity> extractEntities(String text) throws IOException, ParserConfigurationException, SAXException{

		ArrayList<Entity> entities = new ArrayList<Entity>();
		String resultInXml = classifier.classifyToString(text, "xml", false);
		StringBuffer buffer = new StringBuffer("<root>");
		buffer.append(resultInXml);
		buffer.append("</root>");
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(buffer.toString()));
		
		Document doc = db.parse(is);
		NodeList nodes = doc.getElementsByTagName("wi");
		
		for (int i = 0; i < nodes.getLength(); i++){
			Element element = (Element) nodes.item(i);
			
			if(!element.getAttribute("entity").equals("O")){
				entities.add(new Entity(element.getNodeValue(), element.getAttribute("entity")));
			}
			
		}
		
		return entities;
	}
	
	/**
	 * returns the actual serialized Classifier
	 * @return serializedClassifier
	 */
	public String getSerializedClassifier()
	{
		return serializedClassifier;
	}

	/**
	 * sets the current serializedClassifier
	 * @param serializedClassifier
	 */
	public void setSerializedClassifier(String serializedClassifier)
	{
		this.serializedClassifier = serializedClassifier;
	}
	
	/**
	 * returns the current CRFClassifier
	 * @return CRFClassifier<?>
	 */
	public CRFClassifier<?> getClassifier(){
		return (CRFClassifier<?>) classifier;
	}
}
