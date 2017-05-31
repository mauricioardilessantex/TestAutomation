package configurations;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlReader {

	File myConfig;

	public XmlReader(File myConfig){
		this.myConfig = myConfig;
	}

	public File getMyConfig() {
		return myConfig;
	}

	public void setMyConfig(File myConfig) {
		this.myConfig = myConfig;
	}

	public Document openFile(){
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(myConfig);
			doc.getDocumentElement().normalize();
			return doc;

		} catch (Exception ex) {
			 ex.printStackTrace();
			 return null;
		}
	}

	public String readFile(String tagParentName, String tag){
		Document doc = openFile();
		String fileValue = null;
		if (doc != null)
		{
			NodeList nodes = doc.getElementsByTagName(tagParentName);
			System.out.println("==========================");
			for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
					 Element element = (Element) node;
					 fileValue = getValue(tag, element);
					 System.out.println("read " + tag + ":" + fileValue);
				 }
			}
		}
		return fileValue;
	}

	private static String getValue(String tag, Element element) {
		 NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
		 Node node = (Node) nodes.item(0);
		 return node.getNodeValue();
	}

}
