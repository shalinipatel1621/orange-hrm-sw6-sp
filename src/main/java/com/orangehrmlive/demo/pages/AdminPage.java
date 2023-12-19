package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends Utility {

    private static final Logger log = LogManager.getLogger(AdminPage.class.getName());

    public AdminPage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(xpath="//h5[normalize-space()='System Users']")
    WebElement systemUser;

    @CacheLookup
    @FindBy(xpath="//button[normalize-space()='Add']")
    WebElement add;


    @CacheLookup
    @FindBy(xpath="//h6[normalize-space()='Add User']")
    WebElement addUser;


    public String getSystemUserText() {
        log.info("Get System User Text");
        return getTextFromElement(systemUser);
    }
    public void clickOnAddButton() {
        log.info("Click On add Button");
        clickOnElement(add);
    }
    public String getAddUserText() {
        log.info("Get Add User Text");
        return getTextFromElement(addUser);
    }

}