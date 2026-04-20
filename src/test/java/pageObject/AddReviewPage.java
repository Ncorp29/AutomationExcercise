package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddReviewPage extends BasePage {

	public AddReviewPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

@FindBy(css="h2.title.text-center")
WebElement AllProd;
@FindBy(css=".col-sm-9.padding-right .product-image-wrapper:nth-of-type(2) .single-products .productinfo ~ ul li a")
WebElement ViewProd;
@FindBy(linkText="Write Your Review")
WebElement WriteReviewText;
@FindBy(id="name")
WebElement SetName;
@FindBy(id="email")
WebElement SetEmail;
@FindBy(id="review")
WebElement EnterReview;
@FindBy(id="button-review")
WebElement SubmitReview;
@FindBy(css=".col-md-12.form-group .alert-success.alert")
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