package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductQunPage extends BasePage {

	public ProductQunPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
@FindBy(xpath="//div[6]//div[1]//div[2]//ul[1]//li[1]//a[1]")
WebElement viewProd;
@FindBy(xpath="//h2[normalize-space()='Winter Top']")
WebElement ProdName;
@FindBy(xpath="//input[@id='quantity']")
WebElement ProdQun;
@FindBy(xpath="//button[@type='button']//i[@class='fa fa-shopping-cart']")
WebElement AddToCart;
@FindBy(xpath="//u[normalize-space()='View Cart']")
WebElement ViewCart;
@FindBy(xpath="//button[@class='disabled']")
WebElement CheckCart;

public void clickviewproduct() {
	viewProd.click();
}
public String productname() {
	return ProdName.getText();
}
public void setquentity(String qnt) {
	ProdQun.sendKeys(qnt);
}
public void removesetquentity() {
	ProdQun.clear();
}
public void clickaddtocart() {
	AddToCart.click();
}
public void clickviewcart() {
	ViewCart.click();
}
public String productqnt() {
	return CheckCart.getText();
}
}
