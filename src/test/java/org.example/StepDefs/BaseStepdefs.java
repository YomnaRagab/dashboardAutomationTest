package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.example.pages.LoginActions;
import org.testng.Assert;

public class BaseStepdefs {
    LoginActions loginActions;
    public BaseStepdefs(){
        loginActions = new LoginActions();
    }


    @Given("I am logged in with username {string} and password {string}")
    public void iAmLoggedInWithUsernameAndPassword(String username, String password) {
        loginActions.sendUsername(username);
        loginActions.sendPassword(password);
        Assert.assertTrue(loginActions.clickOnLoginBtn());
        loginActions.clickOnSkipBtn();
        Assert.assertTrue(loginActions.checkVisibiltyOfEventPage());
    }

}
