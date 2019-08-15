package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Test using Page Object Model
 */

public class PurchaseFlow {

    WebDriver browser;

    By item = By.xpath("//*[@data-id-product = '1']");
    By confirmingCart = By.xpath("//h2[contains(., 'Product')]");
//    String confirmingCart = "Product successfully added to your shopping cart";
    By btnProceedCheckout = By.cssSelector("a.btn-default[title='Proceed to checkout']");
    By btnProceedCheckoutstd = By.cssSelector("a.standard-checkout[title='Proceed to checkout']");
    By btnProcessAddress = By.name("processAddress");
    By btnProcessCarrier = By.name("processCarrier");
    By checkbox = By.id("cgv");
    By payMethod = By.className("bankwire");
    By confirmOrder = By.cssSelector("p[id='cart_navigation'] > button[type='submit']");
    By orderConfirmation = By.id("order-confirmation");

    public PurchaseFlow(WebDriver browser){

        this.browser = browser;
    }

    public void addToCart(){
        browser.findElement(item).click();
    }

    public WebElement titleConfirmingCart(){
        WebDriverWait wait = new WebDriverWait(browser,10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(confirmingCart));
        return element;
    }

    public WebElement setBtnProceedCheckout(){
        WebDriverWait wait = new WebDriverWait(browser,10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnProceedCheckout));
        return element;
    }

    public WebElement setBtnProceedCheckoutStd(){
        WebDriverWait wait = new WebDriverWait(browser,10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnProceedCheckoutstd));
        return element;
    }

    public void setBtnProcessAddress(){

        browser.findElement(btnProcessAddress).click();
    }

    public void setBtnPProcessCarrier(){

        browser.findElement(btnProcessCarrier).click();
    }

    public void setCheckbox(){

        browser.findElement(checkbox).click();
    }

    public void setPayMethod(){

        browser.findElement(payMethod).click();
    }

    public void setConfirmOrder(){

        browser.findElement(confirmOrder).click();
    }

    public String setOrderConfirmation(){
       return browser.findElement(orderConfirmation).getText();

    }

     /** This POM method will be exposed in test case to login in the application */



}
