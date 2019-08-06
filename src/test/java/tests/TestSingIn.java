package tests;

/**
 * Test using Page Object Model (this test calls package pages).
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static junit.framework.TestCase.*;
import pages.Login;


public class TestSingIn {
    static WebDriver browser;
    Login login = new Login(browser);

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        browser = new ChromeDriver();
        browser.get("http://automationpractice.com");
    }

    /**

     * The test cases will reach http://automationpractice.com

     * Login
     * Logout
     * and close the browser

     */

    @Test
    public void testLogin() {
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

    @AfterClass
    public static void teardown(){
        browser.quit();
    }


}
