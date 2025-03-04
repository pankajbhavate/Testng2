package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	WebDriver driver;
	 public String takeScreenshot(WebDriver driver, String testName) {

		 
	        // ✅ Timestamp for Unique Filename
	        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.").format(new Date());

	        // ✅ Screenshot Folder Ka Absolute Path
	        String screenshotDir = System.getProperty("user.dir") + "/target/Screenshots/";
	        
	
	   
	        String screenshotPath = screenshotDir + testName + "_" + timestamp + ".png";

	   
	        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        File destFile = new File(screenshotPath);
	     
	        try {
	            FileUtils.copyFile(srcFile, destFile);
	            System.out.println("✅ Screenshot saved at: " + screenshotPath);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	     
	        return screenshotPath;  // ✅ Absolute Path Return Karo
	    }
	}



