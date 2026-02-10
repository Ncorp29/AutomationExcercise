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
		sp.setName(getTestData("signup.name"));
		sp.setEmail(getTestData("signup.email"));
		sp.clicksignupbtn();
		
		validateText("signup",sp.isConfirmationMessageDisplayed(),"Text Mismatched");

	}

	private String getTestData(String key) {
		String value = System.getProperty(key);
		if (value == null || value.isBlank()) {
			value = System.getenv(key.toUpperCase().replace('.', '_'));
		}
		Assert.assertNotNull(value, "Test data for '" + key + "' must be provided through system properties or environment variables");
		return value;
	}

}