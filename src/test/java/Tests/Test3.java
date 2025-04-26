package Tests;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Test3 {
	
	
	


		
		
	public	WebDriver driver;
	   @Parameters("browser")
		@BeforeClass
		public void set(String browser) {
			if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
			driver.get("https://www.facebook.com/");
			}
			else if (browser.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				
				driver = new FirefoxDriver();
			
				
			
			driver.get("https://www.globalsqa.com/demo-site/datepicker/");}}
			
			
		
		@Test
		public void test() {
			
			driver.findElement(By.id("email")).sendKeys("munnabhai mbbs ");
			driver.findElement(By.id("pass")).sendKeys("mahindra");
			
		}
		@AfterClass
		public void down() {
			
		}
		

	}



