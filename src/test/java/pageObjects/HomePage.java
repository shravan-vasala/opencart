package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	// Constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	// Locators or elements
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement linkMyAccount;
	
	@FindBy(linkText = "Register")
	WebElement linkRegister;
	
	@FindBy(xpath = "//ul[@class ='dropdown-menu dropdown-menu-right'] //a[text() = 'Login']")
	WebElement linkLogin;
	
	// Action methods
	public void clickMyAccount() {
		linkMyAccount.click();
	}
	
	public void clickRegister() {
		linkRegister.click();
	}
	
	public void clickLogin() {
		linkLogin.click();
	}
	
	
	
}
