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
