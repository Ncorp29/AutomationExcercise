package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewcardBrandPage extends BasePage{

	public ViewcardBrandPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

@FindBy(xpath="//h2[normalize-space()='Brands']")
WebElement BrandsText;
@FindBy(xpath="//a[@href='/brand_products/Biba']")
WebElement BrandName;
@FindBy(xpath="//h2[@class='title text-center']")
WebElement BrandProducts;
@FindBy(xpath="//a[@href='/brand_products/Polo']")
WebElement Polo;
@FindBy(xpath="//h2[@class='title text-center']")
WebElement PoloProucts;

public String getbrandtext() {
	return BrandsText.getText();
}
public void clickbrandname() {
  BrandName.click();
 
}
public String getbrandproductsbiba() {
	return BrandProducts.getText();
}
public void clickpolobrand() {
	Polo.click();
}
public String getbrandproductspolo() {
	return PoloProucts.getText();
	
}

}