package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterWhileCheckoutPage extends BasePage {

    public RegisterWhileCheckoutPage(WebDriver driver) {
        super(driver);
    }

    // Add to Cart Elements
    @FindBy(xpath = "//a[contains(text(),'Add to cart')]") 
    private WebElement addToCart1;
    
//    @FindBy(xpath = "//div[5]//div[1]//div[1]//div[2]//div[1]//a[1]") 
//    private WebElement addToCart2;

    @FindBy(xpath = "//button[contains(text(),'Continue Shopping')]") 
    private WebElement continueShoppingButton;

    // Cart Page Elements
    @FindBy(xpath = "//li[@class='active']") 
    private WebElement cartPageText;
    
    @FindBy(xpath = "//a[@class='btn btn-default check_out']") 
    private WebElement checkoutButton;

    // Login/Register
    @FindBy(xpath = "//u[normalize-space()='Register / Login']") 
    private WebElement loginOrRegisterButton;
    
//    @FindBy(xpath = "//a[@class='btn btn-default check_out']") 
//    private WebElement loginOrRegisterButton;

    // Address Details
    @FindBy(xpath = "//div[h2[normalize-space()='YOUR DELIVERY ADDRESS']]") 
    private WebElement deliveryAddress;
    
    @FindBy(xpath = "//div[h2[normalize-space()='YOUR BILLING ADDRESS']]") 
    private WebElement billingAddress;

    // Order Comment & Checkout
    @FindBy(xpath = "//textarea[@name='message']") 
    private WebElement commentField;
    
    @FindBy(xpath = "//a[@class='btn btn-default check_out']") 
    private WebElement placeOrderButton;

    // Payment Fields
    @FindBy(xpath = "//input[@name='name_on_card']") 
    private WebElement cardNameField;
    
    @FindBy(xpath = "//input[@name='card_number']") 
    private WebElement cardNumberField;
    
    @FindBy(xpath = "//input[@placeholder='ex. 311']") 
    private WebElement cvvField;
    
    @FindBy(xpath = "//input[@placeholder='MM']") 
    private WebElement monthField;
    
    @FindBy(xpath = "//input[@placeholder='YYYY']") 
    private WebElement yearField;
    
    @FindBy(xpath = "//button[@id='submit']") 
    private WebElement submitOrderButton;

    // Order Confirmation
    @FindBy(xpath = "//h2[@class='title text-center']") 
    private WebElement orderConfirmationMessage;

    // Delete Account
    @FindBy(xpath = "//a[normalize-space()='Delete Account']") 
    private WebElement deleteAccountButton;
    
    @FindBy(xpath = "//h2[@class='title text-center']") 
    private WebElement deleteConfirmationMessage;
    
    @FindBy(xpath = "//a[@class='btn btn-primary']") 
    private WebElement continueAfterDeleteButton;

    // Methods for Cart Actions
    public void clickAddToCart1() {
        addToCart1.click();
    }

//    public void clickAddToCart2() {
//        addToCart2.click();
//    }

    public void clickContinueShopping() {
        continueShoppingButton.click();
    }

    public String getShoppingCartText() {
        return cartPageText.getText();
    }

    public void clickCheckout() {
        checkoutButton.click();
    }

    public void clickLoginOrRegister() {
        loginOrRegisterButton.click();
    }

    public String getDeliveryAddress() {
        return deliveryAddress.getText();
    }

    public String getBillingAddress() {
        return billingAddress.getText();
    }

    public void setOrderComment(String comment) {
        commentField.sendKeys(comment);
    }

    public void clickPlaceOrder() {
        placeOrderButton.click();
    }

    // Consolidated method to enter card details
    public void addCardDetails(String name, String number, String cvv, String month, String year) {
        cardNameField.sendKeys(name);
        cardNumberField.sendKeys(number);
        cvvField.sendKeys(cvv);
        monthField.sendKeys(month);
        yearField.sendKeys(year);
    }

    public void clickSubmitOrder() {
        submitOrderButton.click();
    }

    public String getOrderConfirmationMessage() {
        return orderConfirmationMessage.getText();
    }

    public void clickDeleteAccount() {
        deleteAccountButton.click();
    }

    public String getDeleteConfirmationMessage() {
        return deleteConfirmationMessage.getText();
    }

    public void clickContinueAfterDelete() {
        continueAfterDeleteButton.click();
    }
}
