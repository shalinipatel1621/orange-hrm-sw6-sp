package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Utility {

    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(name="username")
    WebElement username;

    @CacheLookup
    @FindBy(name="password")
    WebElement password;

    @CacheLookup
    @FindBy(xpath="//button[normalize-space()='Login']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath="//div[@class='orangehrm-login-logo']//img[@alt='orangehrm-logo']")
    WebElement HRLogo;

    @CacheLookup
    @FindBy(xpath="(//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon'])[1]")
    WebElement profileLogo;


    @CacheLookup
    @FindBy(xpath="//a[normalize-space()='Logout']")
    WebElement logout;


    @CacheLookup
    @FindBy(tagName="h5")
    WebElement login;

    @CacheLookup
    @FindBy(xpath = "//p[text()='Invalid credentials']")
    WebElement invalidCredentials;

    public String verifyErrorMessage(){
        return getTextFromElement(invalidCredentials);
    }


    public void enterUsername(String name) {
        log.info("Enter username " + name + " to User Name field " + name.toString());
        sendTextToElement(username,name);
    }
    public void enterPassword(String passWord)
    {
        log.info("Enter Password " + passWord + " to Password field " + passWord.toString());

        sendTextToElement(password,passWord);
    }
    public void clickOnLoginButton() {
        log.info("Click On Login Button");
        clickOnElement(loginButton);
    }
    public void verifyLogoIsDisplayed() {
        WebElement logo = driver.findElement((By) HRLogo);  //By.cssSelector("div#divLogo img")
        if (logo.isDisplayed()) {
            System.out.println("Logo is displayed on the login page");
        } else {
            System.out.println("Logo is not displayed on the login page");
        }
    }
    public void clickOnUserProfileLogo() {
        log.info("Click On Profile Logo");
        mouseHoverToElementAndClick(profileLogo);
    }
    public void mouseHoverAndClickOnLogout() {
        log.info("Click On LogOut");
        mouseHoverToElementAndClick(logout);
    }


    public String getLoginText() {
        log.info("Get Login Text");
        return getTextFromElement(login);
    }

}