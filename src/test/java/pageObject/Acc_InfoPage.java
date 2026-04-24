package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class Acc_InfoPage extends BasePage {

    public Acc_InfoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='id_gender1']")
    private WebElement title;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//select[@id='days']")
    private WebElement dayDropdown;

    @FindBy(xpath = "//select[@id='months']")
    private WebElement monthDropdown;

    @FindBy(xpath = "//select[@id='years']")
    private WebElement yearDropdown;

    @FindBy(xpath = "//input[@id='newsletter']")
    private WebElement newsletter;

    @FindBy(xpath = "//input[@id='optin']")
    private WebElement option;

    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='last_name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='address1']")
    private WebElement address;

    @FindBy(xpath = "//select[@id='country']")
    private WebElement countryDropdown;

    @FindBy(xpath = "//input[@id='state']")
    private WebElement state;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement city;

    @FindBy(xpath = "//input[@id='zipcode']")
    private WebElement zipcode;

    @FindBy(xpath = "//input[@id='mobile_number']")
    private WebElement mobNo;

    @FindBy(xpath = "//button[normalize-space()='Create Account']")
    private WebElement createAcc;

    @FindBy(xpath = "//h2[@class='title text-center']")
    private WebElement accountCreated;

    public void selectTitle() {
        title.click();
    }

    public void setPassword(String password) {
        this.password.clear();
        this.password.sendKeys(password);
    }

    public void selectDOB(String day, String month, String year) {
    	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
       // wait.until(ExpectedConditions.elementToBeClickable(dayDropdown));
        Select selectDay = new Select(dayDropdown);
        selectDay.selectByValue(day);

       // wait.until(ExpectedConditions.elementToBeClickable(monthDropdown));
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByValue(month);

        //wait.until(ExpectedConditions.elementToBeClickable(yearDropdown));
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByValue(year);
    }

    public void checkNewsletter() {
        newsletter.click();
    }

    public void clickOption() {
        option.click();
    }

    public void setFirstName(String firstName) {
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
    }

    public void setAddress(String address) {
        this.address.clear();
        this.address.sendKeys(address);
    }

    public void selectCountry(String countryName) {
        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByVisibleText(countryName);
    }

    public void setZipCode(String zipCode) {
        zipcode.clear();
        zipcode.sendKeys(zipCode);
    }

    public void setState(String state) {
        this.state.clear();
        this.state.sendKeys(state);
    }

    public void setCity(String city) {
        this.city.clear();
        this.city.sendKeys(city);
    }

    public void setMobileNo(String mob_no) {
        mobNo.clear();
        mobNo.sendKeys(mob_no);
    }

    public void clickCreateAcc() {
        createAcc.click();
    }

    public String isConfirmationMessageDisplayed() {
        return accountCreated.getText();
    }
}