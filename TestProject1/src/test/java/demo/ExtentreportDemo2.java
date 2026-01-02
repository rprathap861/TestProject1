package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentreportDemo2 {
	
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	
	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void setupReport() {
		ExtentHtmlReporter htmlreport = new ExtentHtmlReporter("extentHtmlreport1.html");
		extent=new ExtentReports();
		extent.attachReporter(htmlreport);
	}
	@BeforeTest
	public void setupDriver() {
		driver = new ChromeDriver();
	}
	
	@Test
	public void LoginTest() {
		test = extent.createTest("Login Test", "Verify Home Page");
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		String url = driver.getCurrentUrl();
		System.out.println("URL : " + url);
		String title= driver.getTitle();
		if(title.contains("Lab")) {
			test.pass("Title contains Swag Labs");
		}else {
			test.fail("Title not contains Swag Labs");
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
