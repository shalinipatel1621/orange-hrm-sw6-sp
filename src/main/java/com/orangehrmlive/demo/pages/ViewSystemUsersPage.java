package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ViewSystemUsersPage extends Utility {

    private static final Logger log = LogManager.getLogger(ViewSystemUsersPage.class.getName());

    public ViewSystemUsersPage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    WebElement username;

    @CacheLookup
    @FindBy(xpath="(//span[contains(text(),'Admin')])[1]")
    WebElement admin;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeName;
    @CacheLookup
    @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")
    WebElement statusField;

    @CacheLookup
    @FindBy(xpath="(//div[@class='oxd-select-text-input'][normalize-space()='-- Select --'])[1]")
    WebElement searchText;

    @CacheLookup
    @FindBy(xpath="(//button[normalize-space()='Search'])[1]")
    WebElement searchButton;

    @CacheLookup
    @FindBy(xpath="//div[contains(text(),'johnsmith1234567')]")
    WebElement lauris;

    @CacheLookup
    @FindBy(xpath="(//i[@class='oxd-icon bi-check oxd-checkbox-input-icon'])[2]")
    WebElement checkBox;

    @CacheLookup
    @FindBy(xpath="(//button[normalize-space()='Delete Selected'])[1]")
    WebElement deleteButton;

    @CacheLookup
    @FindBy(xpath="(//button[normalize-space()='Yes, Delete'])[1]")
    WebElement yesDelete;

    @CacheLookup
    @FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
    WebElement deleted;

    @CacheLookup
    @FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
    WebElement noRecordFound;
    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Lisa  Andrews')]")
    WebElement  verifyName;
    @CacheLookup
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
    WebElement resetTab;

    public void enterUsername(String name) {
        log.info("Enter username " + name + " to User Name field " + name.toString());
        sendTextToElement(username, name);
    }
    public void enterEmployeeNameField(String employee) {
        sendTextToElement(employeeName, employee);
    }
    public void selectStatusDropDown() {
        clickOnElement(statusField);
    }
    public void selectUserRoleFromDropDown() {
        sendTextToElement(searchText, "Admin");

        List<WebElement> suggList = driver.findElements(By.xpath("(//span[contains(text(),'Admin')])[1]"));
        for (WebElement element : suggList) {
            System.out.println(element.getText());
        }
        mouseHoverToElementAndClick(admin);
    }

    public void clickOnSearchButton() {
        log.info("Clicking on Search Button ");
        clickOnElement(searchButton);
    }

    public String getUserShouldBeInListText() {
        log.info("Get Text From List Text ");
        return getTextFromElement(lauris);
    }

    public void clickOnCheckBox() {
        log.info("Click On Check Box");
        clickOnElement(checkBox);
    }

    public void clickOnDeleteButton() {
        log.info("Click On delete Button");
        clickOnElement(deleteButton);
    }

    public void clickOnYesDeleteButton() {
        log.info("Click On Yes delete Button");
        clickOnElement(yesDelete);
    }

    public String getSuccessfullyDeletedText() {
        log.info("Get Text Delete from Delete Text");
        return getTextFromElement(deleted);
    }

    public String getNoRecordFoundText() {
        log.info("Get No Record Found Text");
        return getTextFromElement(noRecordFound);
    }
    public String verifyUserName() {
        return getTextFromElement(verifyName);
    }
    public void clickOnResetButton(){
        clickOnElement(resetTab);
    }
}