package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddReviewPage extends BasePage {

	public AddReviewPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

@FindBy(xpath="//h2[@class='title text-center']")
WebElement AllProd;
@FindBy(xpath="//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]")
WebElement ViewProd;
@FindBy(xpath="//a[normalize-space()='Write Your Review']")
WebElement WriteReviewText;
@FindBy(xpath="//input[@id='name']")
WebElement SetName;
@FindBy(xpath="//input[@id='email']")
WebElement SetEmail;
@FindBy(xpath="//textarea[@id='review']")
WebElement EnterReview;
@FindBy(xpath="//button[@id='button-review']")
WebElement SubmitReview;
@FindBy(xpath="//div[@class='col-md-12 form-group']//div[@class='alert-success alert']")
WebElement Reviewmess;
public String getallproductmesasage() {
	return AllProd.getText();
}
public void clickviewproduct(){
	ViewProd.click();
	
}
public String getWriteReviewText() {
	return WriteReviewText.getText();
}
public void enteremail(String email) {
	SetEmail.sendKeys(email);
}
public void entername(String name) {
	SetName.sendKeys(name);
}
public void enterreview(String review) {
	EnterReview.sendKeys(review);
}
public void clicksubmitreview() {
	 SubmitReview.click();
}
public String getreviewsuccessmess() {
	return Reviewmess.getText();
	
}
	
}
