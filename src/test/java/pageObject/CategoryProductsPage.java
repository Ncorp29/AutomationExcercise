package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryProductsPage extends BasePage{

	public CategoryProductsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

@FindBy(xpath="//h2[normalize-space()='Category']")
WebElement Category;
@FindBy(xpath="//a[normalize-space()='Women']//i[@class='fa fa-plus']")
WebElement Women;
@FindBy(xpath="//div[@id='Women']//a[contains(text(),'Dress')]")
WebElement Dress;
@FindBy(xpath="//h2[@class='title text-center']")
WebElement WomenConMess;
@FindBy(xpath="//a[normalize-space()='Men']//i[@class='fa fa-plus']")
WebElement SubCatMen;
@FindBy(xpath="//a[normalize-space()='Tshirts']")
WebElement SubCatTshirt;
@FindBy(xpath="//h2[@class='title text-center']")
WebElement mencatcon;

public String getcategorytext() {
	return Category.getText();
}

public void clickwomencategory() {
	Women.click();
}
public void clickdresscategory() {
	Dress.click();
}
public void clickmencategory() {
	SubCatMen.click();
}
public void clicktshirtcategory() {
	SubCatTshirt.click();
}
public String getmenconfirmation() {
 return mencatcon.getText();
}
}
