package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	public WebDriver driver;  
	
	public BasePage(WebDriver driver) 
	{
	    this.driver = driver;
	    //System.out.println("BasePage driver: " + driver);
	    PageFactory.initElements(driver, this);
	    
	}


}
