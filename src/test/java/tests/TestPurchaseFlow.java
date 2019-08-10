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
    public void testPurchase(){
        browser.get("http://automationpractice.com");
        purchase.addToCart();
        Boolean titleConfirmation = purchase.titleConfirmingCart();
        System.out.println(titleConfirmation);
        assertTrue(titleConfirmation==Boolean.TRUE);
        purchase.setBtnProceedCheckout().click();
        purchase.setBtnProceedCheckoutStd().click();
        login.loginToSite("aaa@jjj.com","12345");
        purchase.setBtnProcessAddress();
        purchase.setCheckbox();
        purchase.setBtnPProcessCarrier();
        purchase.setPayMethod();
        purchase.setConfirmOrder();
        String confirmation = purchase.setOrderConfirmation();
        assertTrue(confirmation.contains("Your order on My Store is complete."));
    }

}
