package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDemo {
	
	
	WebDriver driver;
	@BeforeClass
	public void set() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
	}
	@Test
	public void test() {
		
		driver.findElement(By.id("email")).sendKeys("anadraj");
		driver.findElement(By.id("pass")).sendKeys("mahindra");
		
	}
	@AfterClass
	public void down() {
		
	}
	

}
