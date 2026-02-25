package testCases;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.SignupPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_001_DDT_SignUp extends BaseClass{
 
   
	@Test(dataProvider="SignupData",dataProviderClass=DataProviders.class)
	public void verify_DDT_SignUp(String username, String email) {

		HomePage hp = new HomePage(driver);
	    hp.clicksignup();
	    SignupPage sp = new SignupPage(driver);
	    String normalizedUsername = username.trim();
	    String normalizedEmail = email.trim();
	    String uniqueEmail = normalizedEmail;
	    int atIndex = normalizedEmail.indexOf('@');
	    if (atIndex > 0) {
	    	String localPart = normalizedEmail.substring(0, atIndex);
	    	String domainPart = normalizedEmail.substring(atIndex);
	    	uniqueEmail = localPart + "+" + System.currentTimeMillis() + domainPart;
	    }
	    sp.setName(normalizedUsername);
	    sp.setEmail(uniqueEmail);
	    sp.clicksignupbtn();
	    
		validateText("signup",sp.isConfirmationMessageDisplayed(),"Text Mismatched");

	}
	
	
}