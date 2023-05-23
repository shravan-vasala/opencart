package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups = {"Regression", "Master"})
	void testAccountRegistration() {
		
		logger.debug("Application logs....");
		logger.info("*** Starting TC_001_AccountRegistrationTest ***");	
		try {
			
			HomePage homepage = new HomePage(driver);
			homepage.clickMyAccount();
			logger.info("Clicked on my account link");
			homepage.clickRegister();
			logger.info("Clicked on register link");
			
			AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
			logger.info("Providing customer data");
			regPage.setFirstName("abc");
			regPage.setLastName("xyz");
			regPage.setEmail(randomString() + "@gmail.com");
			regPage.setTelephone(randomNumber());
			String password = randomAlphaNumeric();
			regPage.setPassword(password);
			regPage.setConfirmPassword(password);
			regPage.setPrivacyPolicy();
			regPage.clickContinue();
			logger.info("Clicked on continue");
			
			String confirmationMessage = regPage.getConfirmationMessage();
			
			logger.info("Validting expected message");
			Assert.assertEquals(confirmationMessage, "Your Account Has Been Created!", "Not getting expected message");
			
		} catch(Exception e) {
			logger.error("Test Failed");
			Assert.fail();
		}	
		
		logger.info("*** Finished TC_001_AccountRegistrationTest ***");
		
	}
		
}
