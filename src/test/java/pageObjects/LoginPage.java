package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "email")
	WebElement inputEmailAddress;
	
	@FindBy(name = "password")
	WebElement inputPassword;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement buttonLogin;
	
	
	
	
	// Action methods
	public void setEmailAddress(String email) {
		inputEmailAddress.sendKeys(email);
	}
	
	public void setPassword(String password) {
		inputPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		buttonLogin.click();	
	}
	
	
}
