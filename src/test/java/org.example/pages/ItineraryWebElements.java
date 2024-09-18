package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ItineraryWebElements extends BaseElements{

    public ItineraryWebElements(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//p[contains(text(),\"Itinerary\")]")
    WebElement itineraryOption;
    @FindBy (xpath = "//div[@class=\"rbc-toolbar\"]")
    WebElement calendarBar;
    @FindBy (xpath = "//span[@role=\"columnheader\"]")
    List <WebElement> daysHeader;
    @FindBy (xpath = "//button[contains(text(),\"Next\")]")
    WebElement nextCalender;
    @FindBy(xpath = "//div[@class=\"rbc-time-slot\"]")
    List<WebElement> allDaysCalendar;
    @FindBy (xpath = "//input[@accept=\"image/*\"]")
    WebElement itineraryImgUpload;
    @FindBy (name = "activityTitle")
    WebElement activityTitle;
    @FindBy (xpath = "//button[contains(text(),\"Save\")]")
    WebElement activitySaveBtn;
    @FindBy (xpath = "//button[contains(text(),\"Update\")]")
    WebElement updateBtn;
    @FindBy (xpath = "//div[@class=\"px-1\"]")
    WebElement deleteBtn;
    @FindBy (xpath = "//button[@label=\"Delete\"]")
    WebElement deleteConfirmBtn;




}
