package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignTest {
    @Test
    public void testLogin(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver browser = new ChromeDriver();
        browser.get("http://automationpractice.com/");

    }
}
