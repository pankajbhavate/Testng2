package Tests2;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class hh {
	
	
	
	public WebDriver driver;
	
	@BeforeClass
	public void set() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Windows.html");
		
		
	}
	
	
	@Test
	public void tt() {
		
	}
	
	@AfterClass
	public void down() {
	}
}
