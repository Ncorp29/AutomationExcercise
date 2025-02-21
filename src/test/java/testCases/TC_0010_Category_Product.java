package testCases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.CategoryProductsPage;

import testBase.BaseClass;
import utilities.FileReaderUtil;

public class TC_0010_Category_Product extends BaseClass {

    private CategoryProductsPage cpp;
    
    @BeforeClass
    public void setupTest() {
        cpp = new CategoryProductsPage(driver);
         }
	@Test
    public void verify_categoryproduct() {
		
		// Validate  Confirmation Message
        validateText("category", cpp.getcategorytext(), "Order confirmation message mismatch");
		cpp.clickwomencategory();
        cpp.clickdresscategory();
        cpp.clickmencategory();
        cpp.clicktshirtcategory();
     // Validate  Confirmation Message
        validateText("mensection", cpp.getmenconfirmation(), "Order confirmation message mismatch");
    }

}
