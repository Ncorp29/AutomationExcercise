package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ScrollUpPage extends BasePage {

	public ScrollUpPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//i[@class='fa fa-angle-up']")
	WebElement Arrow;
	@FindBy(xpath="//div[@class='item active']//h2[contains(text(),'Full-Fledged practice website for Automation Engin')]")
	WebElement Moveupcon;
	public void clickuparrow() {
		Arrow.click();

	}
	public String getconfmess() {
		return Moveupcon.getText();
		
	}
}
