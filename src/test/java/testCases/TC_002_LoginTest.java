package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	@Test(groups = {"Sanity", "Master"})
	public void verifyLogin()
	{
		logger.info("****Started Executing TC_002_LoginTest ******");
		logger.debug("Debug log for troubleshooting");
		try
		{
			//HomePage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("clicked on myaccount link on the home page..");
			hp.clickLogin();
			logger.info("clicked on login link under myaccount..");
			
			//LoginPage
		    LoginPage lp = new LoginPage(driver);
		    logger.info("Entering valid email and password..");
		    lp.setEmail(p.getProperty("email1"));
		    lp.setPassword(p.getProperty("password1"));
		    lp.clickLogin();
		    logger.info("clicked on login button..");
		    
		    //MyAccountPage
		    MyAccountPage myActPage = new MyAccountPage(driver);
		    boolean targetPage = myActPage.isMyAccountPageExists();
		    if(targetPage)
		    {
		    	logger.info("Login Successful.., MyAccountPage is Exists");
		    	logger.info("Test Passed");
		    }
		    else
		    {
		    	logger.error("Login Failed.., MyAccountPage is Not Exists");
		    	logger.error("Test Failed");
		    }
//		    if (!targetPage) {
//	            logger.error("Login failed: My Account page not displayed.");
//	        }
	        Assert.assertEquals(targetPage, true, "Login Failed");
		}
		catch(Throwable t)
		{
			logger.error("Test failed due to error: " + t.getMessage(), t);
			Assert.fail();
		}
	    finally
	    {
	    	logger.info("****Finished Executing TC_002_LoginTest ******");
	    }
		
		
	}

}
