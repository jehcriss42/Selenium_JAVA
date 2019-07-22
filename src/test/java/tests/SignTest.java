package tests;

import static junit.framework.TestCase.assertEquals;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SignTest {
    @Test
    public void testLogin() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

        WebDriver browser = new ChromeDriver();

        browser.get("http://automationpractice.com/");
        browser.findElement(By.className("login")).click();
        browser.findElement(By.id("email")).sendKeys("aaa@jjj.com");
        browser.findElement(By.id("passwd")).sendKeys("12345");
        browser.findElement(By.id("SubmitLogin")).click();

        String checklogin = browser.findElement(By.className("account")).getText();
        assertEquals("Jessica Tavares", checklogin);
    }

}