package testCases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.AddReviewPage;
import pageObject.HomePage;
import pageObject.ViewcardBrandPage;
import testBase.BaseClass;
import utilities.FileReaderUtil;

public class TC_0012_AddReview extends BaseClass{
	private AddReviewPage arp;
	private HomePage hp;
	
	@BeforeClass
    public void setupTest() {
        arp = new AddReviewPage(driver);
        hp = new HomePage(driver);
         }
	@Test
public void verify_Review_Page() {
		
		hp.clickproducts();
		validateText("prod",arp.getallproductmesasage(),"text is not matched");
		arp.clickviewproduct();
		validateText("review",arp.getWriteReviewText(),"text is not matched");
		
		arp.entername("xyz");
		arp.enteremail("abc@123");
		arp.enterreview("Very good product");
		arp.clicksubmitreview();
		
		validateText("reviewsuccess",arp.getreviewsuccessmess(),"text is not matched");
	}


}
