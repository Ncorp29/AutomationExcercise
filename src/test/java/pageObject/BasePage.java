package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver;
	
	public BasePage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
}


// TODO: AI fix suggestion (qb08apun): Review and improve: BasePage stores WebDriver in a package-private field and provides no helper methods for waits, safe clicks, or common synchronization. This encourages duplicated logic across page objects and increases flakiness in UI tests.
