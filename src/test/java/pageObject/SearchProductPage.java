package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchProductPage extends BasePage {

	public SearchProductPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
	private WebDriverWait wait;
	
	public String isallproductDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(AllProducts));
		return AllProducts.getText();
	}
	public void setsearch(String search) {
		wait.until(ExpectedConditions.visibilityOf(SetSearch));
		SetSearch.sendKeys(search);
	}
	public void clicksearch() {
		wait.until(ExpectedConditions.elementToBeClickable(SubmitSearch)).click();
	}
	public String issearcheditemsDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(SearchItem));
		return SearchItem.getText();
	}
	public boolean areSearchResultsDisplayed() {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productList));
		List<WebElement> products = driver.findElements(productList);
		return !products.isEmpty();
	}
	
}