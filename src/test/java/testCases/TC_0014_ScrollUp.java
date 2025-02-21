package testCases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.ScrollUpPage;
import pageObject.SubscriptionPage;
import pageObject.ViewcardBrandPage;
import testBase.BaseClass;
import utilities.FileReaderUtil;

public class TC_0014_ScrollUp extends BaseClass {
	private SubscriptionPage sp;
	private ScrollUpPage sup;
	
	 @BeforeClass
	    public void setupTest() {
	        sp = new SubscriptionPage(driver);
	        sup = new ScrollUpPage(driver);
	         }
	 @Test
	 public void verify_scrollup() throws InterruptedException {
	  validateText("PageTitle", driver.getTitle(), "Page title mismatch");
	 
      validateText("subs",sp.getSubscriptionText(), " NAME MISMATCHED");
      Thread.sleep(5000);   
      sup.clickuparrow();
      validateText("scrollup",sup.getconfmess(), " NAME MISMATCHED");

		 
	 }
	}
	
