package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
@FindBy(xpath="//input[@data-qa='login-email']")
WebElement loginemail;
@FindBy(xpath="//input[@placeholder='Password']")
WebElement loginPassword;
@FindBy(xpath="//button[normalize-space()='Login']")
WebElement clickLogin;
@FindBy(xpath="//li[10]//a[1]")
WebElement Loggedin;
@FindBy(xpath="//a[normalize-space()='Delete Account']")
WebElement Delete_Acc;
@FindBy(xpath = "//b[normalize-space()='Account Deleted!']")
WebElement AccountDeleted;
public void setemail(String email) {
	loginemail.sendKeys(email);
}
public void setpassword(String password) {
	loginPassword.sendKeys(password);
}
public void clicklogin() {
	clickLogin.click();
}
public boolean isLoggedInTextVisible() {
    return Loggedin.isDisplayed();
}
public void clickdeleteacc() {
	Delete_Acc.click();
}

public boolean isConfirmationMessageDisplayed() {
    return AccountDeleted.isDisplayed();
}
}
