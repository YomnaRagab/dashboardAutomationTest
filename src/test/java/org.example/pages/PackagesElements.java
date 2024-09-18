package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PackagesElements extends BaseElements{
    public PackagesElements(WebDriver driver) {
            super(driver);
        }
    @FindBy (xpath = "//span[contains(text(),\"Planning\")]")
    WebElement planningOptionElement;
    @FindBy (xpath = "//p[contains(text(),\"Packages\")]")
    WebElement packagesOptionElement;
    @FindBy (xpath = "//h2[contains(text(),\"Packages\")]")
    WebElement packageTitleElement;
    @FindBy (xpath = "//span[contains(text(),\"Package\")]")
    WebElement addNewPackageElement;
    @FindBy (xpath = "//h1[contains(text(),\"Package\")]")
    WebElement newPackagePopUpElement;
    @FindBy (id = "package_title")
    WebElement packageTitleTextBox;
    @FindBy (id = "package_priority")
    WebElement packagePriorityTextBox;
    @FindBy (id = "feature_name")
    WebElement featureNameTextBox;
    @FindBy (id = "package_type")
    WebElement packageTypeMenu;
    @FindBy (xpath = "//div[@class=\"Dropdown_root__lsKzD Dropdown_dark__sLn+X Dropdown_right__1rLfh overflow-y-auto list-unstyled z-[2]\"]")
    WebElement featureIconMenu;
    @FindBy (xpath = "//button[@class=\"Button_root__0RbKd Button_select__nucLd Button_xl__w2v80 min-h-[45px]\"]")
    WebElement featureIconArrow;
    @FindBy (xpath = "//button[contains(text(),\"Save\")]")
    WebElement savePackageBtn;
    @FindBy (xpath = "//h1[contains(text(),\"Update Package\")]")
    WebElement editPkgHeaderElement;
    @FindBy (xpath = "//button[contains(text(),\"Update\")]")
    WebElement updateBtn;
    @FindBy (xpath = "//button[@data-title=\"delete-Update Package\"]")
    WebElement deletePkgBtn;
    @FindBy (xpath = "//button[@label=\"Delete\"]")
    WebElement confirmDeleteBtn;
    @FindBy (xpath = "//h3[contains(text(),\"delete\")]")
    WebElement deleteMsg;

}
