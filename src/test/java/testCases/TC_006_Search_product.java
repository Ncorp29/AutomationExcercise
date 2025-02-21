package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.SearchProductPage;
import testBase.BaseClass;

public class TC_006_Search_product extends BaseClass {

	@Test
	
	public void verify_searchproduct() {
		HomePage hp = new HomePage(driver);
				hp.clickproducts();
		SearchProductPage sp = new SearchProductPage(driver);	
        validateText("prod",sp.isallproductDisplayed(),"Text Mismatched");
		sp.setsearch("T-shirt");
		sp.clicksearch();
        validateText("search_prod",sp.issearcheditemsDisplayed(),"Text Mismatched");
        Assert.assertTrue(sp.areSearchResultsDisplayed(), "No products found for the searched term");

	}
}
