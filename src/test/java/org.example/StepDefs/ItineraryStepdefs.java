package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Base;
import org.example.pages.ItineraryActions;
import org.testng.Assert;

public class ItineraryStepdefs {
    ItineraryActions itineraryActions;
    public ItineraryStepdefs(){
        itineraryActions = new ItineraryActions();
    }
    @And("I click on itinerary option")
    public void iClickOnItineraryOption(){
        itineraryActions.clickOnItineraryOption();
    }

    @And("I choose the date {string} {string}")
    public void iChooseTheTime(String month, String date) {
        itineraryActions.chooseDate(month, date);
    }

    @And("I select  the start time {string} and the end time {string}")
    public void iSendTheTime(String startTime, String endTime) {
        itineraryActions.chooseTime(startTime, endTime);
    }

    @And("I upload a {string} cover image")
    public void iUploadACoverImage(String location) {
        itineraryActions.uploadCoverImage(location);
    }

    @And("I enter the {string} in activity title")
    @When("I update the activity title by {string}")
    public void iEnterTheInActivityTitle(String activityTitle) {
        itineraryActions.sendActivityTitle(activityTitle);
    }

    @And("I click on save the activity")
    public void iClickOnSaveTheActivity() {
        itineraryActions.clickOnSaveActivity();
    }



    @Then("I see the {string} activity is created")
    @Then ("I see {string} activity is updated")
    public void iSeeTheActivityIsCreated(String activityTitle) {
        Assert.assertTrue(itineraryActions.checkActivityCreation(activityTitle));
    }

    @And("I open the {string} event in {string} {string}")
    public void iOpenTheEventIn(String eventTitle, String month, String day) {
        itineraryActions.OpenTheEventToEdit(eventTitle,month,day);
    }

    @And("I click on the update button")
    public void iClickOnTheUpdateButton() {
        itineraryActions.clickOnUpdateBtn();
    }



    @When("I click on delete icon")
    public void iClickOnDeleteIcon() {
        itineraryActions.clickOnDeleteIcon();
    }

    @And("I confrim the deletion")
    public void iConfrimTheDeletion() {
        itineraryActions.clickOnConfirmDelete();
    }

    @Then("The {string} event is deleted")
    public void theEventIsDeleted(String eventTitle) {
        Assert.assertTrue(itineraryActions.checkActivityDeletion(eventTitle));
    }
}
