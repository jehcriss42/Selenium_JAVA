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
    Login login;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        browser = new ChromeDriver();
        browser.get("http://automationpractice.com");
    }

    /**

     * This test case will login in http://automationpractice.com

     * Login to application
     * and close the browser

     */

    @Test
    public void testLogin() {
        login = new Login(browser);
        login.loginToSite("aaa@jjj.com","12345");
        String checkLogin = login.loginTitle();
        assertEquals("Jessica Tavares",checkLogin);
    }

    @AfterClass
    public static void teardown(){
        browser.quit();
    }


}
