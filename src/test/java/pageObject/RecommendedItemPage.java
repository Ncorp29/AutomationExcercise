package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecommendedItemPage extends BasePage {

	public RecommendedItemPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

@FindBy(xpath="//h2[normalize-space()='recommended items']")
WebElement RecItem;
@FindBy(xpath="//div[@class='item active']//div[1]//div[1]//div[1]//div[1]//a[1]")
WebElement AddToCart;
@FindBy(xpath="//u[normalize-space()='View Cart']")
WebElement ViewCart;
//@FindBy(xpath="//img[@alt='Product Image']")
//WebElement DisplayImage;
private By imageLocator = By.xpath("//img[@alt='Product Image']");

public String getrecommendeditem() {
	return RecItem.getText();
}
public void clickaddtocart() {
	AddToCart.click();
}
public void clickviewcart() {
	ViewCart.click();
}
public boolean isImageDisplayed() {
    WebElement imageElement = driver.findElement(imageLocator);
    return imageElement.isDisplayed();
}

}
