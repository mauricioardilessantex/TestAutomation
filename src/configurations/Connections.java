package configurations;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Connections {

	public AppConfigs config = new AppConfigs();
	public WebDriver driver;
	
	public WebDriver connect()
	{
		String myBrowser = config.getBrowser();
		String path =  new File("").getAbsolutePath();
		System.out.println(path);
		
		switch (myBrowser){
			case "FireFox":
				//System.setProperty("webdriver.gecko.driver","C:\\Users\\usuario\\workspace\\TestAutomation\\src\\configurations\\geckodriver.exe");
				System.setProperty("webdriver.gecko.driver",path + "\\src\\configurations\\geckodriver.exe");
				driver = new FirefoxDriver();
				//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				break;	
		}
		
		return driver;
	}
	
}
