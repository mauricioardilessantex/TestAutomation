package testSuites;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import configurations.Connections;

public class TestMercadolibre {

	public Connections con;
	public WebDriver driver;
	public String txtBusqueda = "nav-search-input"; 
	public String btnBusqueda = "nav-search-btn";
	public String primerElemento = "//*/div[@class='section']/ol[@id='searchResults']/li[1]/h2[@class='list-view-item-title']";
	
	@Before	
	public void setUp() throws Exception {
		con = new Connections();
	    driver= con.connect();;
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
		
	
	@Test
	public void testIphone() {
        driver.get("http://www.mercadolibre.com.ar");
        WebElement element = driver.findElement(By.className(txtBusqueda));
        element.sendKeys("iphone");
        element.submit();
        
        WebElement element1 = driver.findElement(By.xpath(primerElemento));
        element1.click();
        
	}
	
	
}
