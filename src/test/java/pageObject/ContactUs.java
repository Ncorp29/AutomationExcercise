package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class ContactUs extends BasePage{

public ContactUs(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
@FindBy(xpath="//h2[normalize-space()='Get In Touch']")
WebElement TextMessage;
@FindBy(xpath="//input[@placeholder='Name']")
WebElement Name;
@FindBy(xpath="//input[@placeholder='Email']")
WebElement Email;
@FindBy(xpath="//input[@placeholder='Subject']")
WebElement Subject;
@FindBy(xpath="//textarea[@id='message']")
WebElement Message;
@FindBy(xpath="//input[@name='upload_file']")
WebElement UploadFile;
//WebElement fileInput =driver.findElement(By.cssSelector("input[name='upload_file']"));
@FindBy(xpath="//input[@name='submit']")
WebElement Submit;
@FindBy(xpath="//div[@class='status alert alert-success']")
WebElement Success;

public String isContactUsMessageDisplayed() {
return TextMessage.getText();
}
public void entername(String name) {
	Name.sendKeys(name);
}
public void enteremail(String email) {
	Email.sendKeys(email);
}
public void entersubject(String subject) {
	Subject.sendKeys(subject);
}
public void enetermessage(String message) {
	Message.sendKeys(message);
}
public void uploadfile() {
    Actions actions = new Actions(driver);
    actions.moveToElement(UploadFile).click().perform();
}

public void clicksubmit() {
	Submit.click();
	
}
public String isSuccessMessageDisplayed() {
return Success.getText();
}
//public void uploadfileclick() {
//	fileInput.
//}
}
