package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Base;
import org.example.pages.LoginActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class LoginStepdefs {
    LoginActions loginActions;
    public LoginStepdefs(){
        loginActions = new LoginActions();
    }
//    @Given("I am on the login page")
//    public void iAmOnTheLoginPage() {
//        loginActions.openWebSite();
//    }

    @When("I eneter {string} in the username")
    public void iEneterInTheUsername(String username) {
        loginActions.sendUsername(username);
        Assert.assertEquals(loginActions.getUserName(),username);
    }

    @And("I enter {string} in the password text field")
    public void iEnterInThePasswordTextField(String password) {
        loginActions.sendPassword(password);
        Assert.assertEquals(loginActions.getPassword(),password);

    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        Assert.assertTrue(loginActions.clickOnLoginBtn());

    }

    @And("I click on the Skip button")
    public void iClickOnTheSkipButton() {
        loginActions.clickOnSkipBtn();
    }

    @Then("I land on my Events page")
    public void iLandOnMyEventsPage() {
        Assert.assertTrue(loginActions.checkVisibiltyOfEventPage());
        Base.tearDown();
    }
}
