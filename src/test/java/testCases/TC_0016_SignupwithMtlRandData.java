package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.SignupPage;
import testBase.BaseClass;

public class TC_0016_SignupwithMtlRandData extends BaseClass{
    private HomePage hp;
    private SignupPage sp;
	
	
	@BeforeClass
    public void setupTest() {
        sp = new SignupPage(driver);
        hp = new HomePage(driver);
        
    }
	public String generateRandomName() {
        return "User" + RandomStringUtils.randomAlphabetic(5); // Example: UserXyz
    }

    public String generateRandomEmail() {
        return "test" + RandomStringUtils.randomAlphanumeric(6) + "@example.com"; // Example: test123xyz@example.com
    }
    @Test
    public void verify_multiplesignupwithrandomdata() {
int numberOfSignups = 5; // Specify how many signups you want to perform (e.g., 5 signups)
        
        for (int i = 0; i < numberOfSignups; i++) {
            String randomName = generateRandomName();
            String randomEmail = generateRandomEmail();

        hp.clicksignup();
        sp.setName(randomName);
        sp.setEmail(randomEmail);
        sp.clicksignupbtn();
        validateText("signup",sp.isConfirmationMessageDisplayed(),"Text Mismatched");
		driver.navigate().back();
    }
    }

    
}
