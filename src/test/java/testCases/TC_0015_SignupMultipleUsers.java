package testCases;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.SignupPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_0015_SignupMultipleUsers extends BaseClass {
	private SignupPage sp;
	private HomePage hp;
	
	@BeforeClass
    public void setupTest() {
        sp = new SignupPage(driver);
        hp = new HomePage(driver);
         }
	@Test  (dataProvider = "SignupData", dataProviderClass = DataProviders.class)
	public void verify_multiplesignup(String Name, String Email) {
		
		hp.clicksignup();
		sp.setName(Name);
		sp.setEmail(Email);
		sp.clicksignupbtn();
		validateText("signup",sp.isConfirmationMessageDisplayed(),"Text Mismatched");
		driver.navigate().back();
	}
	

}


// TODO: AI fix suggestion (5tqc7sbj): Review and improve: The data-driven signup test blindly creates new user accounts on every run and never cleans up or guards against duplicate emails. This floods the application under test with redundant records, burns through backend resources, and will start failing once the signup endpoint rejects previously used data or throttles requests. Introduce a teardown/cleanup strategy, reuse existing accounts when possible, or add logic to verify if the test data already exists before creating another record.
