package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProductPage extends BasePage {

	public SearchProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//h2[@class='title text-center']")
	WebElement AllProducts;
	@FindBy(xpath="//input[@id='search_product']")
	WebElement SetSearch;
	@FindBy(xpath="//button[@id='submit_search']")
	WebElement SubmitSearch;
	@FindBy(xpath="//h2[@class='title text-center']")
	WebElement SearchItem;
	private By productList = By.className("product-image-wrapper");	
public String isallproductDisplayed() {
	return AllProducts.getText();
}
public void setsearch(String search) {
	SetSearch.sendKeys(search);
}
public void clicksearch() {
	SubmitSearch.click();
	}
public String issearcheditemsDisplayed() {
	return SearchItem.getText();
}
public boolean areSearchResultsDisplayed() {
    List<?> products = driver.findElements(productList);
    return !products.isEmpty();
}
	
}
