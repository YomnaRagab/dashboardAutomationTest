package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EventWebElements extends BaseElements{
    public EventWebElements(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//p[contains(text(),'Event')]")
    WebElement newEventAddButton;
    @FindBy (xpath = "//p[contains(text(),\"Scratch\")]")
    WebElement startFromScratchElement;
    @FindBy (xpath = "//h2[contains(text(),\"Scratch\")]")
    WebElement startFromScratchPageElement;
    @FindBy (xpath = "//input[@class='Input_root__fi0ZK'][1]")
    WebElement eventNameTextBox;
    @FindBy (xpath = "//select[@class='Input_root__fi0ZK Input_selectInput__aHlvF'][1]")
    WebElement eventTypeMenu;
    @FindBy (xpath = "(//input[@class='Input_root__fi0ZK'])[2]")
    WebElement eventSlungTextBox;
    @FindBy (xpath = "(//input[@class='Input_root__fi0ZK'])[3]")
    WebElement startDateTextBox;
    @FindBy (xpath = "(//input[@class='Input_root__fi0ZK'])[4]")
    WebElement startTimeTextBox;
    @FindBy (xpath = "(//input[@class='Input_root__fi0ZK'])[5]")
    WebElement endDateTextBox;
    @FindBy (xpath = "(//input[@class='Input_root__fi0ZK'])[6]")
    WebElement endTimeTextBox;
    @FindBy (xpath = "(//select[@class='Input_root__fi0ZK Input_selectInput__aHlvF'])[2]")
    WebElement timeZoneMenu;
    @FindBy (xpath = "(//input[@class='Input_root__fi0ZK'])[7]")
    WebElement latitudeTextBox;
    @FindBy (xpath = "(//input[@class='Input_root__fi0ZK'])[8]")
    WebElement longitudeTextBox;
    @FindBy (xpath = "//button[contains(text(),\"Create\")]")
    WebElement createEventBtn;
    @FindBy (xpath = "(//td[@id=\"col-1\"])[1]/div")
    WebElement newEventHeaderElement;
    @FindBy (xpath = "//h2[contains(text(),\"Dashboard\")]")
    WebElement dashBoardElement;
}
