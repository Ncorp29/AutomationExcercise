package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContactUs extends BasePage{

private WebElement TextMessage;
private WebElement Name;
private WebElement Email;
private WebElement Subject;
private WebElement Message;
private WebElement UploadFile;
//WebElement fileInput =driver.findElement(By.cssSelector("input[name='upload_file']"));
private WebElement Submit;
private WebElement Success;

public ContactUs(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
@FindBy(xpath="//h2[normalize-space()='Get In Touch']")
private WebElement TextMessage;
@FindBy(xpath="//input[@placeholder='Name']")
private WebElement Name;
@FindBy(xpath="//input[@placeholder='Email']")
private WebElement Email;
@FindBy(xpath="//input[@placeholder='Subject']")
private WebElement Subject;
@FindBy(xpath="//textarea[@id='message']")
private WebElement Message;
@FindBy(xpath="//input[@name='upload_file']")
private WebElement UploadFile;
//WebElement fileInput =driver.findElement(By.cssSelector("input[name='upload_file']"));
@FindBy(xpath="//input[@name='submit']")
private WebElement Submit;
@FindBy(xpath="//div[@class='status alert alert-success']")
private WebElement Success;

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