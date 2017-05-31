package configurations;

import java.io.File;

public class AppConfigs {

	public String server;
	public String browser;

	public AppConfigs() {
		File myConfig = new File("app.config.xml");
		XmlReader myXMLFile = new XmlReader(myConfig);
		browser = myXMLFile.readFile("APP_CONFIG", "Browser");
	}


	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}
}
