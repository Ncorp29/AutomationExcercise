package testCases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.AddReviewPage;
import pageObject.HomePage;
import pageObject.RecommendedItemPage;
import testBase.BaseClass;
import utilities.FileReaderUtil;

public class TC_0013_RecommendedItem extends BaseClass {
private RecommendedItemPage rp;

@BeforeClass
public void setupTest() {
    rp = new RecommendedItemPage(driver);
    
     }
@Test
public void verify_recommendedItem() {
	
	validateText("recommended",rp.getrecommendeditem(),"text is not displayed");
	rp.clickaddtocart();
	rp.clickviewcart();
    Assert.assertTrue(rp.isImageDisplayed(), "Image is not displayed on the webpage!");

}

	
}
