package tests;
/*
   Created by: Jessica Cristina Tavares
   Email: jeh_criss@hotmail.com
   Date: 24-jul-19
*/

import static junit.framework.TestCase.*;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingIn {

    /* TODO: initialize drivers and property in different class */

    private String url = "http://automationpractice.com/";
    private WebDriver browser = new ChromeDriver();

    static {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
    }

    @Test
    public void testLogin() {
        browser.get(url);
        browser.findElement(By.className("login")).click();
        browser.findElement(By.id("email")).sendKeys("aaa@jjj.com");
        browser.findElement(By.id("passwd")).sendKeys("12345");
        browser.findElement(By.id("SubmitLogin")).click();

        String checklogin = browser.findElement(By.className("account")).getText();
        assertEquals("Jessica Tavares", checklogin);
    }

    @Test
    public void testInvalidLogin(){
        browser.get(url);
        browser.findElement(By.className("login")).click();
        browser.findElement(By.id("email")).sendKeys("invalid");
        browser.findElement(By.id("passwd")).sendKeys("12345");
        browser.findElement(By.id("SubmitLogin")).click();

        String checklogin = browser.findElement(By.cssSelector("div[class='alert alert-danger']")).getText();
        assertTrue(checklogin.contains("Invalid email address"));
    }

    @After
    public void teardown(){
        browser.quit();
    }

}