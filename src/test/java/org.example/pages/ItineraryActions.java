package org.example.pages;

import io.cucumber.java.an.E;
import org.example.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ItineraryActions {
    ItineraryWebElements itineraryWebElements;
    int dayIndex;
    public ItineraryActions(){
        itineraryWebElements = new ItineraryWebElements(Base.driver);
        dayIndex =-1;
    }

    public void clickOnItineraryOption() {
        Base.wait.until(ExpectedConditions.visibilityOf(itineraryWebElements.itineraryOption));
        itineraryWebElements.itineraryOption.click();
        Base.wait.until(ExpectedConditions.visibilityOf(itineraryWebElements.calendarBar));
    }
    public void chooseDate(String month, String date){
        String calenderDate = itineraryWebElements.calendarBar.getText();
        while (! calenderDate.contains(month)){
            itineraryWebElements.nextCalender.click();
            Base.wait.until(ExpectedConditions.visibilityOf(itineraryWebElements.calendarBar));
            calenderDate = itineraryWebElements.calendarBar.getText();
        }
        while (! checkDate(date)){
            itineraryWebElements.nextCalender.click();
            Base.wait.until(ExpectedConditions.visibilityOf(itineraryWebElements.calendarBar));
        }
        //chooseTime();
    }
    public boolean checkDate (String date){
        for (WebElement header: itineraryWebElements.daysHeader){
            dayIndex ++;
            String day = header.getText();
            if (day.contains(date)){
                return  true;
            }
        }
        dayIndex =-1;
        return false;
    }
    public void chooseTime(String startTime, String endTime) {
        //get the start and end offset to drag and drop the time
        String[] startTimeParts = startTime.split(":");
        String[] endTimeParts = endTime.split(":");
        int startHours = Integer.parseInt(startTimeParts[0]);
        int startMinutes = Integer.parseInt(startTimeParts[1]);
        int endHours = Integer.parseInt(endTimeParts[0]);
        int endMinutes = Integer.parseInt(endTimeParts[1]);
        int stratOffset = (((startHours - 00 ) * 60 + startMinutes )/15 ) *2;
        int endOffset =(((endHours - 00 ) * 60 + endMinutes )/15 ) *2;
        int startDateNumber = (dayIndex * 192) +193 + stratOffset;
        int endDateNumber = (dayIndex * 192) +192 + endOffset;

        Base.scrollingToElement(itineraryWebElements.allDaysCalendar.get(startDateNumber));
//        Base.wait.until(ExpectedConditions.visibilityOf(itineraryWebElements.allDaysCalendar.get(startDateNumber)));
        Actions actions = new Actions(Base.driver);
        actions.clickAndHold(itineraryWebElements.allDaysCalendar.get(startDateNumber))
                .moveToElement(itineraryWebElements.allDaysCalendar.get(endDateNumber))
                .release()
                .perform();

    }

    public void uploadCoverImage(String location) {
        itineraryWebElements.itineraryImgUpload.sendKeys(Helper.convertRelativePathToAbs(location));
    }

    public void sendActivityTitle(String activityTitle) {
        itineraryWebElements.activityTitle.clear();
        itineraryWebElements.activityTitle.sendKeys(activityTitle);
    }

    public void clickOnSaveActivity() {
        itineraryWebElements.activitySaveBtn.click();
    }

    public boolean checkActivityCreation(String activityTitle) {
        String activityXpath = "//strong[contains(text(),\""+activityTitle+"\")]";

        Base.scrollingToElementJs(Base.driver.findElement(By.xpath(activityXpath)));
        return Base.driver.findElement(By.xpath(activityXpath)).isDisplayed();
    }

    public void OpenTheEventToEdit(String eventTitle, String month, String day) {
        chooseDate(month,day);
        String activityXpath = "//strong[contains(text(),\""+eventTitle+"\")]";
        Base.scrollingToElement(Base.driver.findElement(By.xpath(activityXpath)));
        Base.driver.findElement(By.xpath(activityXpath)).click();


    }

    public void clickOnUpdateBtn() {
        itineraryWebElements.updateBtn.click();

    }

    public void clickOnDeleteIcon() {
        itineraryWebElements.deleteBtn.click();
    }

    public void clickOnConfirmDelete() {
        itineraryWebElements.deleteConfirmBtn.click();
    }

    public boolean checkActivityDeletion(String eventTitle) {
        String activityXpath = "//strong[contains(text(),\""+eventTitle+"\")]";
        try {
            Base.scrollingToElement(Base.driver.findElement(By.xpath(activityXpath)));
            Base.driver.findElement(By.xpath(activityXpath)).click();
            return false;
        }
        catch (Exception e){
            return true;
        }

    }
}
