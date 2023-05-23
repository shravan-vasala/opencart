package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {
	
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void testLoginDDT(String email, String password, String exp) throws IOException {
		
		try {
			
		logger.info("***Starting TC_003_LoginDDT ");
		HomePage home = new HomePage(driver);
		home.clickMyAccount();
		logger.info("Click on My Account");
		
		home.clickLogin();
		logger.info("Clicked on login");
		
		logger.info("Sending personal details");
		LoginPage login = new LoginPage(driver);
		login.setEmailAddress(email);
		login.setPassword(password);
		login.clickLogin();
		logger.info("Going to My account page");
		
		MyAccountPage account = new MyAccountPage(driver);
		boolean status = account.isMyAccountPageExists();
		
		if (exp.equals("Valid")) {
			if (status) {
				 account.clickLogout();
				 Assert.assertTrue(true);
			} else {
				Assert.fail();
			}
		} 
		
		if (exp.equals("Invalid")){
			if (status) {
				account.clickLogout();
				Assert.fail();
			} else {
				Assert.assertTrue(true);
			}
		}
		
		} catch (Exception e) {
			Assert.fail();
		}
				
		logger.info("Finished TC_003_LoginDDT");
	}
}
