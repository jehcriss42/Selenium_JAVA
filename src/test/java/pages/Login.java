package pages;

/**
 * Test using Page Object Model
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

    WebDriver browser;

    By sectionLogin = By.className("login");
    By email = By.id("email");
    By sectionPassword = By.id("passwd");
    By nameLogin = By.className("account");
    By btnLogin = By.id("SubmitLogin");
    By btnLogout = By.className("logout");

    public Login(WebDriver browser){

        this.browser = browser;

    }

    public void accessLogin(){

        browser.findElement(sectionLogin).click();
    }

    public void setEmail(String userName){

        browser.findElement(email).sendKeys(userName);
    }

    public void setSectionPassword(String password){

        browser.findElement(sectionPassword).sendKeys(password);
    }

    public void setBtnLogin(){

        browser.findElement(btnLogin).click();
    }

    public void setBtnLogout(){

        browser.findElement(btnLogout).click();
    }

    public String loginTitleAccount(){

        return browser.findElement(nameLogin).getText();
    }

    public String loginTitleLogIn(){

        return browser.findElement(sectionLogin).getText();
    }

    /**

     * This POM method will be exposed in test case to login in the application

     * @param email

     * @param password

     */


    public void loginToSite(String email,String password){
//        this.accessLogin();
        this.setEmail(email);
        this.setSectionPassword(password);
        this.setBtnLogin();
    }

}