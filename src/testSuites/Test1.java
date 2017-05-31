package testSuites;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import configurations.Connections;

public class Test1 {

	public Connections con;
	public WebDriver driver;
	public String txtBusqueda = "q"; 
	
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
	public void test() {
        driver.get("http://www.google.com");
        //WebElement element = driver.findElement(By.name("q"));
        WebElement element = driver.findElement(By.name(txtBusqueda));
        element.sendKeys("Cheese!");
        element.submit();
        System.out.println("Page title now is: " + driver.getTitle());
        assertEquals("Google", driver.getTitle());
	}
	
	@Test
	public void testTitle() {
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Page title now is: " + driver.getTitle());
        assertEquals("Cheese! - Buscar con Google", driver.getTitle());
	}
	
}
