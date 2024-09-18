package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExploreWebElements extends BaseElements{

    public ExploreWebElements(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//p[contains(text(),\"Explore\")]")
    WebElement exploreOptionElement;
    @FindBy (xpath = "//h1[contains(text(),\"Groups\")]")
    WebElement groupsHeaderElement;
    @FindBy (xpath = "//span[contains(text(),\"Group\")]")
    WebElement addGroupBtn;
    @FindBy (xpath = "//h3[contains(text(),\"Group\")]")
    WebElement newGroupFormTitle;
    @FindBy (xpath = "//input[@accept=\"image/*\"]")
    WebElement uploadGroupPhoto;
    @FindBy (id = "title")
    WebElement groupTitleTextBox;
    @FindBy (xpath = "//button[@label=\"Save\"]")
    WebElement groupSaveBtn;
    @FindBy (xpath = "//button[@label=\"Cancel\"]")
    WebElement groupCancelBtn;

}
