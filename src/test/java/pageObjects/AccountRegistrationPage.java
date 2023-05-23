package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	WebDriver driver;
	
	// Constructor
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	// Elements
	
	@FindBy(name = "firstname")
	WebElement inputFirstName;
	
	@FindBy(name = "lastname")
	WebElement inputLastName;
	
	@FindBy(name = "email")
	WebElement inputEmail;
	
	@FindBy(name = "telephone")
	WebElement inputTelephone;
	
	@FindBy(name = "password")
	WebElement inputPassword;
	
	@FindBy(name = "confirm")
	WebElement inputConfirmPassword;
	
	@FindBy(name = "agree")
	WebElement checkPolicy;
	
	@FindBy(xpath = "//input[@value = 'Continue']")
	WebElement buttonContinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement messageConfirmation;
	
	public void setFirstName(String fname) {
		inputFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		inputLastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		inputEmail.sendKeys(email);
	}
	
	public void setTelephone(String phone) {
		inputTelephone.sendKeys(phone);
	}
	
	public void setPassword(String pwd) {
		inputPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd) {
		inputConfirmPassword.sendKeys(pwd);
	} 
	
	public void setPrivacyPolicy() {
		checkPolicy.click();
	}
	
	public void clickContinue() {
		buttonContinue.click();
	}
	
	public String getConfirmationMessage() {
		try {
			return (messageConfirmation.getText());
		} catch(Exception e) {
			return e.getMessage();
		}
	}
}
