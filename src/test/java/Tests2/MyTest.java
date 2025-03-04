package Tests2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyTest {

	
	public WebDriver driver;
	
	@BeforeClass
	public void set() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/");
		
	}
	
	@Test
	public void te() {
		driver.findElement(By.id("menu-item-53896")).click();
	}
	
	
	@AfterClass
	public void down() {
		
		
	}
}
