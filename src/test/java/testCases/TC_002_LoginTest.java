package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	
	@Test(groups = {"Sanity", "Master"})
	public void testLogin() {
		
		try {
			logger.info("*** Starting TC_002_LoginTest***");
			HomePage page = new HomePage(driver);
			page.clickMyAccount();
			logger.info("Clicked on My Account");
			page.clickLogin();
			logger.info("Clicked on Login Link");
			
			
			LoginPage login = new LoginPage(driver);
			logger.info("Providing login details");
			login.setEmailAddress(rb.getString("email")); // Valid email, get it from config.properties
			login.setPassword(rb.getString("password")); // Valid password, get it from config.properties
			login.clickLogin();
			logger.info("Clicked on login button");
			
			MyAccountPage account = new MyAccountPage(driver);
			boolean status = account.isMyAccountPageExists();
			
			Assert.assertTrue(status, "Invalid login data");
			
		} catch (Exception e) {
			Assert.fail();
			
		}
		
		logger.info("*** Finished TC_002_LoginTest***");
		
		
	}
	
	
}
