package configurations;
import java.io.File;
import java.util.concurrent.TimeUnit;

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
		
		//No es para nada una buena practica un switch para una condicion unicamente, la idea es agregar los casos para los otros navegadores
		switch (myBrowser){
			case "FireFox":
				//No podia correr los test si no utilizaba este geckodriver.exe
				System.setProperty("webdriver.gecko.driver",path + "\\src\\configurations\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				break;	
		}
		
		return driver;
	}
	
}
