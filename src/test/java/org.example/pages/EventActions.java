package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class EventActions {
    EventWebElements eventWebElements;
    public EventActions (){
        eventWebElements = new EventWebElements(Base.driver);
    }
    public void clickOnAddNewEvent(){
        eventWebElements.newEventAddButton.click();
        Base.wait.until(ExpectedConditions.visibilityOf(eventWebElements.startFromScratchElement));
    }
    public boolean checkVisibilityOfStartFromScratchCard(){
       return eventWebElements.startFromScratchElement.isDisplayed();
    }
    public void clickOnStartfromScratchCrad(){
        eventWebElements.startFromScratchElement.click();
        Base.wait.until(ExpectedConditions.visibilityOf(eventWebElements.startFromScratchPageElement));
    }
    public void enterEventName (String eventName){
        eventWebElements.eventNameTextBox.sendKeys(eventName);
    }
    public String getEventName (){
        return eventWebElements.eventNameTextBox.getAttribute("value");
    }
    public void selectEventType(String eventTypeOption){
        Select eventTypeDropMenu = new Select(eventWebElements.eventTypeMenu);
        try{
        eventTypeDropMenu.selectByVisibleText(eventTypeOption);}
        catch (Exception e){
            System.out.println("Invalid Event Type is Entered");
        }
    }
    public void enterEventSlug(String link){
        eventWebElements.eventSlungTextBox.sendKeys(link);
    }
    public void sendStartDate(String startDate){
        eventWebElements.startDateTextBox.sendKeys(startDate);
    }
    public void sendStartTime(String startTime){
        eventWebElements.startTimeTextBox.sendKeys(startTime);
    }
    public void sendEndDate (String endDate){
        eventWebElements.endDateTextBox.sendKeys(endDate);
    }
    public void sendEndTime (String endTime){
        eventWebElements.endTimeTextBox.sendKeys(endTime);
    }
    public void selectTimeZone(String timeZone){
        Select timeZoneDropMenu = new Select(eventWebElements.timeZoneMenu);
        timeZoneDropMenu.selectByVisibleText(timeZone);
    }
    public void sendLatitude (String latitude){
        eventWebElements.latitudeTextBox.clear();
        eventWebElements.latitudeTextBox.sendKeys(latitude);
    }
    public void sendLongitude(String longitude){
        eventWebElements.longitudeTextBox.clear();
        eventWebElements.longitudeTextBox.sendKeys(longitude);
    }
    public void clickOnCreateEvent(){
//        Base.js.executeScript("window.scrollBy(0,-350)", "");
//        Base.js.executeScript("arguments[0].scrollIntoView();", eventWebElements.createEventBtn);
        new Actions(Base.driver)
                .scrollToElement(eventWebElements.createEventBtn)
                .perform();
        Base.wait.until(ExpectedConditions.visibilityOf(eventWebElements.createEventBtn));
        eventWebElements.createEventBtn.click();
    }
    public String checkCreationOfNewEvent(){

        Base.wait.until(ExpectedConditions.visibilityOf(eventWebElements.newEventHeaderElement));
        return eventWebElements.newEventHeaderElement.getText();

    }
    public boolean openEventCode(String eventCode) {

        String newPageNumber;
        String eventCodeXpath = "//div[contains(text(),\"" + eventCode + "\")]";
//        Base.wait.until(ExpectedConditions.visibilityOf(Base.driver.findElement(By.xpath("//div[@class=\"flex items-center space-x-1\"]"))));
        String nextPageArrowXpath = "//div[@class=\"flex items-center space-x-1\"]";
        String currentPageXpath = "//a[@aria-current=\"page\"]";
        WebElement nextArrow;
        String currentPageNumber;
        WebElement currentPageElement;
        while (true) {
            try {
                Base.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(eventCodeXpath)));
                Base.driver.findElement(By.xpath(eventCodeXpath)).click();
                Base.wait.until(ExpectedConditions.visibilityOf(eventWebElements.dashBoardElement));
                return true;

            } catch (Exception e) {
                //scroll to the next arrow
                nextArrow = Base.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(nextPageArrowXpath)));
                Base.scrollingToElement(nextArrow);
                //get the current page number
                currentPageElement = Base.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(currentPageXpath)));
                currentPageNumber = currentPageElement.getText();
                //click to next arrow to get the next page
                Base.driver.findElement(By.xpath(nextPageArrowXpath)).click();
                Base.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(currentPageXpath)));
                newPageNumber = Base.driver.findElement(By.xpath(currentPageXpath)).getText();
                //if the previous page is equal to the current page, then all pages do not include the event
                if (newPageNumber.equals(currentPageNumber)) {
                    System.out.println("Event Code is not exist");
                    return false;
                } else {
                    currentPageNumber = newPageNumber;
                }
            }

        }
    }
}
