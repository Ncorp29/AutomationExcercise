package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//a[normalize-space()='Signup / Login']")
	WebElement Signup;
	@FindBy(xpath="//a[normalize-space()='Contact us']")
	WebElement Contactus;
	@FindBy(xpath="//a[@href='/products']")
	WebElement Products;
	@FindBy(xpath="/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")
	WebElement Cart;
	
	public void clicksignup() {
		Signup.click();
	}
	public void clickcontactus() {
		Contactus.click();
	}
	public void clickproducts() {
		Products.click();
	}
	public void clickcart() {
		Cart.click();	}

}
