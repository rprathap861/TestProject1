package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.*;


public class ExtentReportDemo {
	
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	@BeforeSuite
	public void setUpReport() {
		@SuppressWarnings("deprecation")
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
	}
	@BeforeTest
	public void setupDriver() {
		driver = new ChromeDriver();
	}
	@Test
	public void testGooglrSearch() {
		test = extent.createTest("Google Search Test", "Verify Google Homepage loads");
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		if(title.contains("Google")) {
			test.pass("Title contains Google");
		}else {
			test.fail("Title does not contain Google");
		}
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	@AfterSuite
	public void flushReport() {
		extent.flush();
	}
}
