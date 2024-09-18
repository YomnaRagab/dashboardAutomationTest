package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PackagesActions {
    PackagesElements packagesElements;
    public PackagesActions(){
        packagesElements = new PackagesElements(Base.driver);
    }


    public void clickOnPlanningOption() {
        packagesElements.planningOptionElement.click();
    }

    public boolean clickOnPackagesOption() {
        packagesElements.packagesOptionElement.click();
        Base.wait.until(ExpectedConditions.visibilityOf(packagesElements.packageTitleElement));
        return packagesElements.packageTitleElement.isDisplayed();
    }

    public boolean clickOnAddAnewPackagebtn() {
        packagesElements.addNewPackageElement.click();
        Base.wait.until(ExpectedConditions.visibilityOf(packagesElements.newPackagePopUpElement));
        return (packagesElements.newPackagePopUpElement.isDisplayed());
    }

    public void enterThePriority(String priority) {
        Base.scrollingToElementJs(packagesElements.packagePriorityTextBox);
//        Base.wait.until(ExpectedConditions.visibilityOf(packagesElements.packagePriorityTextBox));
        packagesElements.packagePriorityTextBox.sendKeys(priority);
    }

    public void enterPackageTitle(String pkgTitle) {
        Base.wait.until(ExpectedConditions.visibilityOf(packagesElements.packageTitleTextBox));
        packagesElements.packageTitleTextBox.clear();
        packagesElements.packageTitleTextBox.sendKeys(pkgTitle);

    }

    public void chooseTheIcon(String iconNumber) {

        Base.scrollingToElementJs(packagesElements.featureIconArrow);
        Base.wait.until(ExpectedConditions.elementToBeClickable(packagesElements.featureIconArrow)).click();
        List<WebElement> listItems = packagesElements.featureIconMenu.findElements(By.tagName("li"));
        WebElement selectedElement = listItems.get(Integer.parseInt(iconNumber));
        Base.wait.until(ExpectedConditions.elementToBeClickable(selectedElement)).click();

    }

    public void enterFeatureName(String featureName) {
        Base.scrollingToElementJs(packagesElements.featureNameTextBox);
        Base.wait.until(ExpectedConditions.visibilityOf(packagesElements.featureNameTextBox));
        packagesElements.featureNameTextBox.sendKeys(featureName);
    }

    public void chooseFeatureType(String typeOption) {
        Base.scrollingToElementJs(packagesElements.packageTypeMenu);
        Select featureTypeMenu = new Select(packagesElements.packageTypeMenu);
        featureTypeMenu.selectByVisibleText(typeOption);
    }

    public void clickOnSavePackage() {
        Base.scrollingToElementJs(packagesElements.savePackageBtn);
        packagesElements.savePackageBtn.click();
    }

    public boolean checkThePackageGeneration(String pkgName) {
        String pkgNameXpath = "(//h4[contains(text(),\""+pkgName+"\")])[2]";
         Base.wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(pkgNameXpath))));
        return Base.driver.findElement(By.xpath(pkgNameXpath)).isDisplayed();
    }

    public boolean clickOnEditPkg(String pkgName) {
        String pkgNameEditXpath = "(//h4[contains(text(),\'"+pkgName+"\')])[2]/preceding::button[1]";
        Base.wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(pkgNameEditXpath))));
        Base.driver.findElement(By.xpath(pkgNameEditXpath)).click();
        return packagesElements.editPkgHeaderElement.isDisplayed();
    }

    public void clickOnUpdateBtn() {
        Base.scrollingToElementJs(packagesElements.updateBtn);
        packagesElements.updateBtn.click();
    }

    public void clickOnDeletePkgBtn() {
        packagesElements.deletePkgBtn.click();
        Base.wait.until(ExpectedConditions.visibilityOf(packagesElements.deleteMsg));
    }

    public void clickOnConfirmDelete() {
        packagesElements.confirmDeleteBtn.click();
    }

    public boolean checkThePackageDeletion(String pkgName) {
        String pkgNameXpath = "(//h4[contains(text(),\""+pkgName+"\")])[2]";
        WebElement pkg;
        try {
            Thread.sleep(5000);
            return Base.driver.findElement(By.xpath(pkgNameXpath)).isDisplayed();
        }
        catch (Exception e)
        {
            return false;
        }

    }
}
