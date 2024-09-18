package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Base;
import org.example.pages.ExploreActions;
import org.testng.Assert;

public class ExploreStepdefs {
    ExploreActions exploreActions;
    public ExploreStepdefs(){
        exploreActions = new ExploreActions();
    }
    @And("I click on content option")
    public void iClickOnContentOption(){
        exploreActions.clickOnContentOption();
    }

    @And("I click on Explore Option")
    public void iClickOnExploreOption() {
        exploreActions.clickOnExploreOption();
    }

    @When("I click on add a group button")
    public void iClickOnAddAGroupButton() {
        exploreActions.clickOnAddAGroupBtn();
    }

    @And("I upload a {string} photo")
    public void iUploadAPhoto(String photoPath) {
        exploreActions.uploadGroupPhoto(photoPath);
    }

    @And("I eneter the {string} in the group title")
    public void iEneterTheInTheGroupTitle(String groupTitle) {
        Assert.assertEquals(exploreActions.sendTheGroupTitle(groupTitle),groupTitle);
    }

    @And("I click on Save a group")
    public void iClickOnSaveAGroup() {
        exploreActions.clickOnSaveGroup();
    }

    @Then("The group {string} is added successfully")
    public void theGroupIsAddedSuccessfully(String groupName) {
        Assert.assertTrue(exploreActions.checkGroupAdding(groupName));
    }
}
