package Utilities;

import org.testng.ITestListener;
import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Listner implements ITestListener {
	
	
	  private ExtentReports extent;
	    private ExtentTest test;
	      WebDriver driver;

	    @Override
	    public void onStart(ITestContext context) {
	        // Setting up Extent Report
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("target/ExtentReport.html");
	        htmlReporter.config().setDocumentTitle("Automation Report");
	        htmlReporter.config().setReportName("Test Execution Report");
	        htmlReporter.config().setTheme(Theme.STANDARD);

	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("environment", "QA");
	        extent.setSystemInfo("QA", "Pankaj Bhavate");
	        extent.setSystemInfo("os","window");
	        extent.setSystemInfo("Testcases", "functional");
	        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.").format(new Date());
	        extent.setSystemInfo("date", timestamp);
	        driver = (WebDriver) context.getAttribute("WebDriver");
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	        test = extent.createTest(result.getName());
	        test.log(Status.INFO, "Test Started: " + result.getName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test.log(Status.PASS, "Test Passed: " + result.getName());
	        Object testObject = result.getInstance();
	   

	        try {
	           driver = (WebDriver) testObject.getClass().getField("driver").get(testObject);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
   
	        
	        Screenshot s = new Screenshot();
	  String screnns=      s.takeScreenshot(driver, result.getName());
    
		    test.addScreenCaptureFromPath("file://"+screnns);}
	     

	    @Override
	    public void onTestFailure(ITestResult result) {
	        test.log(Status.FAIL, "Test Failed: " + result.getName());
	        test.log(Status.FAIL, result.getThrowable());
	        Object testObject = result.getInstance();
	     

	        try {
	           driver = (WebDriver) testObject.getClass().getField("driver").get(testObject);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        Screenshot s = new Screenshot();
	  String screnns=      s.takeScreenshot(driver, result.getName());

		    test.addScreenCaptureFromPath("file:///"+screnns);}
	
		

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        test.log(Status.SKIP, "Test Skipped: " + result.getName());
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        extent.flush();
	    }
	}


