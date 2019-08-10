package tests;

/**
 * Test using Page Object Model (this test calls package pages).
 */

import org.junit.Test;
import static junit.framework.TestCase.*;
import pages.Login;


public class TestSingIn extends Setup {
    /**

     * The test cases will reach http://automationpractice.com

     * Login
     * Logout
     * and close the browser

     */

    Login login = new Login(browser);

    @Test
    public void testLogin() {
        browser.get("http://automationpractice.com");
        login.accessLogin();
        login.loginToSite("aaa@jjj.com","12345");
        String checkLogin = login.loginTitleAccount();
        assertEquals("Jessica Tavares",checkLogin);
    }

    @Test
    public void testLogout(){
        login.setBtnLogout();
        String checkLogout = login.loginTitleLogIn();
        assertEquals("Sign in",checkLogout);
    }
}
