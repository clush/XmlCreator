package xml;

import java.io.File;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlWriter {
	
	public void schreibeAnfang(Calendar cal, String name){
	
	try {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("Values");
		doc.appendChild(rootElement);

		Element type = doc.createElement("Type");
		type.appendChild(doc.createTextNode("Second Values"));
		rootElement.appendChild(type);
		
		Element protocoll = doc.createElement("ProtocollVersion");
		protocoll.appendChild(doc.createTextNode("1.34"));
		rootElement.appendChild(protocoll);
		
		Element comp = doc.createElement("Company");
		comp.appendChild(doc.createTextNode("DRALLE Systementwicklungen"));
		rootElement.appendChild(comp);		
		
		Element loc = doc.createElement("Location");
		loc.appendChild(doc.createTextNode("0013_AkuMon"));
		rootElement.appendChild(loc);
		
		Element datum = doc.createElement("StartDate");
		datum.appendChild(doc.createTextNode(Funktion.getDatum(cal)));
		rootElement.appendChild(datum);
		
		Element zeit = doc.createElement("StartTime");
		zeit.appendChild(doc.createTextNode(Funktion.getZeit(cal)));
		rootElement.appendChild(zeit);

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(name));

		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);

		System.out.println("File saved!");

	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
}
}
