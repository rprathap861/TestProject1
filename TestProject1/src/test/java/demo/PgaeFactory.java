package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PgaeFactory {
	WebDriver driver;
	
	public PgaeFactory(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "username")
	WebElement usernameField;
	@FindBy(id = "password")
	WebElement passwordField;
	@FindBy(id = "login")
	WebElement loginBtn;
	
	public void Login(String user, String pass) {
		usernameField.sendKeys(user);
		passwordField.sendKeys(pass);
		loginBtn.click();
	}

}
