package artcitlocator.tools.config;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

public class XMLConfigHandler implements ConfigHandler{

	private JAXBContext context;
	private String path;

	public void init(Class<?> clazz, String path) {
		 try {
			context = JAXBContext.newInstance(clazz);
		} catch (JAXBException e) {
			e.printStackTrace();
		}	
		 this.path = path;
	}

	public Object load() {
		Unmarshaller um;
		try {
			// instantiate unmarshaller
			um = context.createUnmarshaller();
			
			// Read from File
			return um.unmarshal(new File(path));
		} catch (JAXBException e) {
			e.printStackTrace();			
			return null;
		}
	}

	public boolean save(Object saveObj) {
	    try {
	    	// instantiate marshaller
		    Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		    // Write to File
		    m.marshal(saveObj, new File(path));
			return true;
		} catch (PropertyException e) {
			e.printStackTrace();
			return false;
		} catch (JAXBException e) {
			e.printStackTrace();
			return false;
		}
	}
}
