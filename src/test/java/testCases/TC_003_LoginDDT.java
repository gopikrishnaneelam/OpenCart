package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/


public class TC_003_LoginDDT extends BaseClass{
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "DataDriven")
	public void verify_loginDDT(String email, String password, String exp)
	{
		logger.info("**** Starting TC_003_LoginDDT *****");
		try
		{
			//Home Page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			//Login Page
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLogin();
			
			//MyAccount PAge
			MyAccountPage myActPage = new MyAccountPage(driver);
			boolean targetPage = myActPage.isMyAccountPageExists();
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true)
				{
					myActPage.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==true)
				{
					myActPage.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
			
		logger.info("**** Finished TC_003_LoginDDT *****");

		

		
	}
 
}
