package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage {

	public SignupPage(WebDriver driver) {
		super(driver);
	}

@FindBy(xpath="//input[@placeholder='Name']")
WebElement signupName;

@FindBy(xpath="//input[@data-qa='signup-email']")
WebElement signupemail;

@FindBy(xpath="//button[normalize-space()='Signup']")
WebElement signup_btn;

@FindBy(xpath = "//b[contains(text(),'Enter Account Information')]")
WebElement confirmationMessage;


public void setName(String Name) {
	signupName.sendKeys(Name);
}

public void setEmail(String Email) {
	signupemail.sendKeys(Email);
}

public void clicksignupbtn() {
	signup_btn.click();
}
	
public String isConfirmationMessageDisplayed() {
    return confirmationMessage.getText();
}
	

}
