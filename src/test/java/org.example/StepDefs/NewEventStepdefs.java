package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Base;
import org.example.pages.EventActions;
import org.testng.Assert;

public class NewEventStepdefs {
   EventActions eventActions ;
   public NewEventStepdefs(){
       eventActions = new EventActions();
   }
   @When("I click on New Event button")
    public void WhenIclickonNewEventbutton(){
       eventActions.clickOnAddNewEvent();
       Assert.assertTrue(eventActions.checkVisibilityOfStartFromScratchCard());


   }


    @Then("I click on Start from scratch Card")
    public void iClickOnStartfromScratchCard() {
        eventActions.clickOnStartfromScratchCrad();
    }

    @And("I enter {string} in Event Name")
    public void iEnterInEventName(String eventName) {
       eventActions.enterEventName(eventName);
       Assert.assertEquals(eventActions.getEventName(),eventName);
    }

    @And("I enter {string} in Event Type")
    public void iEnterInEventType(String eventTypeOption) {
       eventActions.selectEventType(eventTypeOption);
    }

    @And("I enter {string} in Event Slung")
    public void iEnterInEventSlung(String link) {
       eventActions.enterEventSlug(link);
    }

    @And("I enter {string} in Start Date")
    public void iEnterInStartDate(String Date) {
       eventActions.sendStartDate(Date);

    }

    @And("I enter {string} in Start Time")
    public void iEnterInStartTime(String startTime) {
       eventActions.sendStartTime(startTime);
    }

    @And("I enter {string} in End Date")
    public void iEnterInEndDate(String endDate) {
       eventActions.sendEndDate(endDate);
    }

    @And("I enter {string} in End Time")
    public void iEnterInEndTime(String endTime) {
       eventActions.sendEndTime(endTime);
    }

    @And("I enter {string} in Timezone")
    public void iEnterInTimezone(String timeZone) {
       eventActions.selectTimeZone(timeZone);
    }

    @And("I enter {string} in Latitude")
    public void iEnterInLatitude(String latitude) {
       eventActions.sendLatitude(latitude);
    }

    @And("I enter {string} in Longitude")
    public void iEnterInLongitude(String longitude) {
       eventActions.sendLongitude(longitude);
    }

    @And("I click on create for the event")
    public void iClickOnCreateForTheEvent() {
       eventActions.clickOnCreateEvent();
    }

    @Then("The {string} event should be created successfully")
    public void theEventShouldBeCreatedSuccessfully(String eventName) {
       Assert.assertEquals(eventActions.checkCreationOfNewEvent(),eventName);

    }
}
