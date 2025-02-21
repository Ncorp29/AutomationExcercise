package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubscriptionPage extends BasePage {

    

   

    public SubscriptionPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Locators using @FindBy annotation
    @FindBy(xpath = "//h2[normalize-space()='Subscription']")
    private WebElement subscriptionText;

    @FindBy(xpath = "//input[@id='susbscribe_email']")
    private WebElement emailInput;

    @FindBy(xpath = "//i[@class='fa fa-arrow-circle-o-right']")
    private WebElement subscribeButton;

    @FindBy(xpath = "//div[@class='alert-success alert']")
    private WebElement successMessage;

    /**
     * Get Subscription section text.
     * @return Subscription text
     */
    public String getSubscriptionText() {
        return subscriptionText.getText();
    }

    /**
     * Enter email in the subscription field.
     * @param email Email address to be entered
     */
    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    /**
     * Click the Subscribe button.
     */
    public void clickSubscribe() {
        subscribeButton.click();
    }

//    /**
//     * Verify if the success message is displayed.
//     * @return true if success message is displayed, false otherwise
//     */
//    public boolean isSuccessMessageDisplayed() {
//        return successMessage.isDisplayed();
//    }

    /**
     * Get the success message text.
     * @return Success message text
     */
    public String getSuccessMessageText() {
        return successMessage.getText();
    }

    /**
     * Get the success message WebElement (for explicit waits).
     * @return WebElement of the success message
     */
    public WebElement getSuccessMessageElement() {
        return successMessage;
    }
}
