package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Acc_InfoPage;
import pageObject.HomePage;
import pageObject.SignupPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_Acc_Info extends BaseClass {
	
	@Test (dataProvider="TestData2",dataProviderClass=DataProviders.class)
public void Verify_Acc_info(String username,String email,String password) throws InterruptedException {
		
		HomePage hp = new HomePage(driver);
		hp.clicksignup();
		SignupPage sp = new SignupPage(driver);
		sp.setName(username);
		sp.setEmail(email);
		sp.clicksignupbtn();
		Acc_InfoPage ap = new Acc_InfoPage(driver);
		ap.setPassword(password);
		ap.selectDOB("15", "4", "1995");
		ap.selectCountry("United States");
		ap.checkNewsletter();
		ap.clickOption();
		ap.setFirstName("Nisha");
		ap.setLastName("gupta");
		ap.setAddress("Ranchi");
        ap.setState("jharkhand");
        ap.setCity("ranchi");
        ap.setZipCode("124354");
        ap.setMobileNo("1234546");
        ap.clickCreateAcc();
		validateText("Acc_cre",ap.isConfirmationMessageDisplayed(),"Text Mismatched");
	
	}
}
