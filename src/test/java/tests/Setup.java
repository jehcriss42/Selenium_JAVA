package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Setup {

    public static WebDriver browser;

    @BeforeClass
    public static void BrowserOpen() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
     
        options.setHeadless(true);
        options.addArguments("--no-sandbox");
        options.addArguments("windows-size=1920,1080");
     
        browser = new ChromeDriver(options);
    }

    @AfterClass
    public static void teardown(){
        browser.quit();
    }

}
