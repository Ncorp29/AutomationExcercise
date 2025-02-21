package testCases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.CategoryProductsPage;
import pageObject.HomePage;
import pageObject.ViewcardBrandPage;
import testBase.BaseClass;
import utilities.FileReaderUtil;

public class TC_0011_ViewCardBrands extends BaseClass {
 
	private ViewcardBrandPage vbp;
	private HomePage hp;

    @BeforeClass
    public void setupTest() {
        vbp = new ViewcardBrandPage(driver);
        hp = new HomePage(driver);
         }
    @Test
    public void Verify_BrandPage() {
    	
    	hp.clickproducts();
    	validateText("title", driver.getTitle(), "Page title mismatch");
        //validateText("brandtext",vbp.getbrandproductspolo(), "bRAND NAME MISMATCHED");
        vbp.clickbrandname();
        validateText("brandname",vbp.getbrandproductsbiba(), "BRAND name mismatched");
        vbp.clickpolobrand();
        validateText("polobrand",vbp.getbrandproductspolo(), "bRAND NAME MISMATCHED");
    }
    

}
