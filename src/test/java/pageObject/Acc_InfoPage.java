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
    WebElement Title;

    @FindBy(xpath = "//input[@id='password']")
    WebElement Password;

    @FindBy(xpath = "//select[@id='days']")
    WebElement dayDropdown;

    @FindBy(xpath = "//select[@id='months']")
    WebElement monthDropdown;

    @FindBy(xpath = "//select[@id='years']")
    WebElement yearDropdown;

    @FindBy(xpath = "//input[@id='newsletter']")
    WebElement newsletter;

    @FindBy(xpath = "//input[@id='optin']")
    WebElement option;

    @FindBy(xpath = "//input[@id='first_name']")
    WebElement Firstname;

    @FindBy(xpath = "//input[@id='last_name']")
    WebElement Lastname;

    @FindBy(xpath = "//input[@id='address1']")
    WebElement Address;

    @FindBy(xpath = "//select[@id='country']")
    WebElement countryDropdown;

    @FindBy(xpath = "//input[@id='state']")
    WebElement State;

    @FindBy(xpath = "//input[@id='city']")
    WebElement City;

    @FindBy(xpath = "//input[@id='zipcode']")
    WebElement zipcode;

    @FindBy(xpath = "//input[@id='mobile_number']")
    WebElement Mob_no;

    @FindBy(xpath = "//button[normalize-space()='Create Account']")
    WebElement Create_acc;

    @FindBy(xpath = "//h2[@class='title text-center']")
    WebElement AccountCreated;

    public void selectTitle() {
        Title.click();
    }

    public void setPassword(String password) {
        Password.clear();
        Password.sendKeys(password);
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
        Firstname.clear();
        Firstname.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        Lastname.clear();
        Lastname.sendKeys(lastName);
    }

    public void setAddress(String address) {
        Address.clear();
        Address.sendKeys(address);
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
        State.clear();
        State.sendKeys(state);
    }

    public void setCity(String city) {
        City.clear();
        City.sendKeys(city);
    }

    public void setMobileNo(String mob_no) {
        Mob_no.clear();
        Mob_no.sendKeys(mob_no);
    }

    public void clickCreateAcc() {
        Create_acc.click();
    }

    public String isConfirmationMessageDisplayed() {
        return AccountCreated.getText();
    }
}
