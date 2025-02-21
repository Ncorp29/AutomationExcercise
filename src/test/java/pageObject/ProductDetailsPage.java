package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
@FindBy(xpath="//h2[@class='title text-center']")
WebElement AllProduct;
WebElement ViewProduct = driver.findElement(By.cssSelector("a[href='/product_details/1']"));

@FindBy(xpath="//h2[normalize-space()='Blue Top']")
WebElement ProductName;
@FindBy(xpath="//p[normalize-space()='Category: Women > Tops']")
WebElement ProductCategory;
@FindBy(xpath="//span[normalize-space()='Rs. 500']")
WebElement ProductPrice;
@FindBy(xpath="//div[@class='product-details']//p[2]")
WebElement Availability;
@FindBy(xpath="//body//section//p[3]")
WebElement ProductCondition;
@FindBy(xpath="//body//section//p[4]")
WebElement ProductBrand;

public String isAllProductDisplayed() {
	return AllProduct.getText();
}
public void clickviewproduct() {
	ViewProduct.click();
}
public String isproductnameDisplayed() {
	return ProductName.getText();
	}
public String isproductcategoryuDisplayed() {
	return ProductCategory.getText();
}
public String isproductpriceDisplayed() {
	return ProductPrice.getText();
}
public String isavailibilityDisplayed() {
	return Availability.getText();
}
public String isconditionDisplayed() {
	return ProductCondition.getText();
}
public String isbrandDisplayed() {
	return ProductBrand.getText();
}

}
