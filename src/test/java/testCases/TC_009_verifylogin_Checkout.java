package testCases;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.Acc_InfoPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ProductQunPage;
import pageObject.RegisterWhileCheckoutPage;
import pageObject.SignupPage;
import testBase.BaseClass;
import utilities.DataProviders;
import utilities.FileReaderUtil;

public class TC_009_verifylogin_Checkout extends BaseClass {
    
    private HomePage hp;
    private SignupPage sp;
    private RegisterWhileCheckoutPage rcp;
    private LoginPage lp;

    @BeforeClass
    public void setupTest() {
        hp = new HomePage(driver);
        sp = new SignupPage(driver);
        rcp = new RegisterWhileCheckoutPage(driver);
        lp  = new LoginPage(driver);
    }

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void verifyCheckout(String email, String password) {
    	
    	hp.clicksignup();
        lp.setemail(email);
        lp.setpassword(password);
        lp.clicklogin();
        rcp.clickAddToCart1();
        rcp.clickContinueShopping();
//        rcp.clickAddToCart2();
//        rcp.clickContinueShopping();
        hp.clickcart();

        // Validate Cart Page Text
        validateText("CartText", rcp.getShoppingCartText(), "Cart page message mismatch");

        //rcp.clickCheckout();
        
        
        rcp.clickCheckout();

        // Validate Delivery Address
        //validateText("DeliveryAddress", rcp.getDeliveryAddress(), "Delivery address mismatch");

        // Validate Billing Address
       //validateText("BillingAddress", rcp.getBillingAddress(), "Billing address mismatch");

        // Place Order
        rcp.setOrderComment("Ranchi");
        rcp.clickPlaceOrder();
        rcp.addCardDetails("Anne", "1234", "05", "04", "2027");
        rcp.clickSubmitOrder();

        // Validate Order Confirmation Message
        validateText("ordercon", rcp.getOrderConfirmationMessage(), "Order confirmation message mismatch");

        // Delete Account
        rcp.clickDeleteAccount();
        validateText("Delacc", rcp.getDeleteConfirmationMessage(), "Delete account message mismatch");
        rcp.clickContinueAfterDelete();
    }

    /**
     * Utility method to validate text from UI against expected values.
     */
//    private void validateText(String key, String actual, String errorMessage) {
//        String expected = expectedValues.get(key);
//        Assert.assertNotNull(expected, "Expected value for key '" + key + "' is missing in expected_values.txt");
//        Assert.assertEquals(actual, expected, errorMessage);
//    }
}
