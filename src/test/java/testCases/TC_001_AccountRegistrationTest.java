package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	
	@Test(groups = {"Regression", "Master"})
	public void verifytAccountRegistation()
	{
		logger.info("********* Started Executing TC_001_AccountRegistrationTest ***********");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link....");
		hp.clickRegister();
		logger.info("Clicked on Register Link....");
		
		AccountRegistrationPage arp = new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details...");
		arp.setFirstName(randomString().toUpperCase());
		arp.setLastName(randomString().toUpperCase());
		arp.setEmail(randomString()+"@gmail.com");
		arp.setPhone(randomNumber());
		String password = randomAlphaNumeric();
		arp.setPassword(password);
		arp.setConfirmPassword(password);
		arp.clickAgree();
		arp.clickContinue();
		String confMsg = arp.getConfirmationMessage();
		if(confMsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed..");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		finally 
		{
		logger.info("***** Finished Executing TC001_AccountRegistrationTest *****");
		}

	}
	
}
