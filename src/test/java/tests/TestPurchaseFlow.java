package tests;

import org.junit.Test;
import pages.Login;
import pages.PurchaseFlow;

import static junit.framework.TestCase.assertTrue;

public class TestPurchaseFlow extends Setup {

    /**

     * The test cases will reach http://automationpractice.com

     * Add item to the cart
     * Confirm Item
     * Confirm Authentication
     * Confirm Address
     * Confirm Shipping
     * and Payment method

     */

    PurchaseFlow purchase = new PurchaseFlow(browser);
    Login login = new Login(browser);

    @Test
    public void testPurchase() {
        browser.get("http://automationpractice.com");

        // Added item to the cart
        purchase.addToCart();
        String titleConfirmation = purchase.titleConfirmingCart().getText();
        assertTrue(titleConfirmation.contains("Product successfully added to your shopping cart"));

        //Proceed with the checkout
        purchase.setBtnProceedCheckout().click();
        purchase.setBtnProceedCheckoutStd().click();

        //Authentication required
        login.loginToSite("aaa@jjj.com","12345");

        // Confirm address
        purchase.setBtnProcessAddress();

        // confirm shipping
        purchase.setCheckbox();
        purchase.setBtnPProcessCarrier();

        // Confirm pay method
        purchase.setPayMethod();

        // Confirming order
        purchase.setConfirmOrder();
        String confirmation = purchase.setOrderConfirmation();
        assertTrue(confirmation.contains("Your order on My Store is complete."));
    }

}
