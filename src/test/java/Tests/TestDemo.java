package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDemo {
	
	
	public WebDriver driver;
	@BeforeClass(alwaysRun = true)
	public void set() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/");
		
	}
	@Test
	public void test() {
		
	driver.findElement(By.xpath("//a[text()=\"Tester’s Hub\"]")).click();
	
	}
	
	@Test(groups = "about")
	public void test1() {
		driver.findElement(By.xpath("//a[text()=\"About\"]")).click();
				
		
	}
	@AfterClass
	public void down() {
		
	}
	

}
