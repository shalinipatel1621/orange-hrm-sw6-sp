package com.orangehrmlive.demo.steps;

import com.orangehrmlive.demo.pages.DashboardPage;
import com.orangehrmlive.demo.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {
    @Given("I am on Homepage")
    public void iAmOnHomepage() {

    }

    @When("I enter user name {string}")
    public void iEnterUserNameAdmin(String username) {
        new LoginPage().enterUsername(username);
    }

    @And("I enter password {string}")
    public void iEnterPasswordAdmin123(String password) {
        new LoginPage().enterPassword(password);
    }

    @And("I click on Login Button")
    public void iClickOnLoginButton() {
        new LoginPage().clickOnLoginButton();
    }

    @Then("Verify {string} Message on page")
    public void verifyMessageOnPage(String arg0) {
        Assert.assertEquals(new DashboardPage().getDashboardText(), "Dashboard", "Error message");
    }

    @Then("Verify Logo is Displayed")
    public void verifyLogoIsDisplayed() {
        new LoginPage().verifyLogoIsDisplayed();
    }
    @And("I Click on User Profile logo")
    public void iClickOnUserProfileLogo() {
        new LoginPage().clickOnUserProfileLogo();
    }

    @And("I Mouse hover on {string} and click")
    public void iMouseHoverOnLogoutAndClick() {
        new LoginPage().mouseHoverAndClickOnLogout();
    }

    @Then("Verify the text {string} is displayed")
    public void verifyTheTextLoginPanelIsDisplayed() {
        Assert.assertEquals(new LoginPage().getLoginText(), "Login Panel","Error message");
    }

    @Then("Verify the Error message {string}")
    public void verifyTheErrorMessageErrorMessage(String errormessage) {
        Assert.assertEquals(new LoginPage().verifyErrorMessage(),"error message", "Error message");
    }
}