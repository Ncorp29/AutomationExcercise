package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;

import pageObject.HomePage;
import pageObject.SignupPage;
import testBase.BaseClass;

public class TC_001_SignUp extends BaseClass{
	
	@Test
	public void verify_signup() {
		
		//Home Page
		HomePage hp = new HomePage(driver);
		hp.clicksignup();
		SignupPage sp = new SignupPage(driver);
		sp.setName("NCtest");
		sp.setEmail("NCtest@gmail.com");
		sp.clicksignupbtn();
		
		validateText("signup",sp.isConfirmationMessageDisplayed(),"Text Mismatched");

	}

}
