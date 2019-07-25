package tests;
/*
   Created by: Jessica Cristina Tavares
   Email: jeh_criss@hotmail.com
   2019
*/

import static junit.framework.TestCase.*;
import org.junit.Test;
import org.openqa.selenium.By;

public class SingIn extends Setup {

    @Test
    public void testLogin() {
        browser.get("http://automationpractice.com/");
        browser.findElement(By.className("login")).click();
        browser.findElement(By.id("email")).sendKeys("aaa@jjj.com");
        browser.findElement(By.id("passwd")).sendKeys("12345");
        browser.findElement(By.id("SubmitLogin")).click();
        String checklogin = browser.findElement(By.className("account")).getText();
        assertEquals("Jessica Tavares", checklogin);
        // Teardown - logout
        browser.findElement(By.className("logout")).click();
    }

    @Test
    public void testInvalidLogin() {
        browser.get("http://automationpractice.com/");
        browser.findElement(By.className("login")).click();
        browser.findElement(By.id("email")).sendKeys("invalid");
        browser.findElement(By.id("passwd")).sendKeys("12345");
        browser.findElement(By.id("SubmitLogin")).click();
        String checklogin = browser.findElement(By.cssSelector("div[class='alert alert-danger']")).getText();
        assertTrue(checklogin.contains("Invalid email address"));
    }
}