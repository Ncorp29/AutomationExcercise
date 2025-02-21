package testCases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.ProductQunPage;
import testBase.BaseClass;
import utilities.FileReaderUtil;

public class TC_008_ProductQun extends BaseClass {
	 private ProductQunPage pqp;
	 
	 @BeforeClass
	    public void setupTest() {
	        pqp = new ProductQunPage(driver);
	    }	
	@Test
	public void verify_productquentity(){
	// home page title verification	
	validateText("PageTitle", driver.getTitle(), "Title Mismatched");
	
	pqp.clickviewproduct();
	// Validating displaying productName
    validateText("productName",pqp.productname(),"productname mismatched");
	
    pqp.removesetquentity();
    pqp.setquentity("4");
    pqp.clickaddtocart();
    pqp.clickviewcart();
    String actualQuentity = pqp.productqnt();
Assert.assertEquals(actualQuentity, "4", "Quentity is not matched" );    
	}
	
}
