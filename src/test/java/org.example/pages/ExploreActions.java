package org.example.pages;

import org.example.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ExploreActions {
    ExploreWebElements exploreWebElements;
    public ExploreActions(){
        exploreWebElements = new ExploreWebElements(Base.driver);
    }

    public void clickOnContentOption() {
        exploreWebElements.contentArrowElement.click();
    }

    public void clickOnExploreOption() {
        exploreWebElements.exploreOptionElement.click();
        Base.wait.until(ExpectedConditions.visibilityOf(exploreWebElements.groupsHeaderElement));
    }

    public void clickOnAddAGroupBtn() {
        exploreWebElements.addGroupBtn.click();
        Base.wait.until(ExpectedConditions.visibilityOf(exploreWebElements.newGroupFormTitle));
    }

    public void uploadGroupPhoto(String photoPath) {
        exploreWebElements.uploadGroupPhoto.sendKeys(Helper.convertRelativePathToAbs(photoPath));
        Base.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='flex flex-col w-full relative w-full h-64 cursor-pointer']")));
    }

    public String sendTheGroupTitle(String groupTitle) {
        exploreWebElements.groupTitleTextBox.sendKeys(groupTitle);
        return exploreWebElements.groupTitleTextBox.getAttribute("value");
    }

    public void clickOnSaveGroup() {
        exploreWebElements.groupSaveBtn.click();
    }

    public boolean checkGroupAdding(String groupName) {
        String groupXpath = "//span[contains(text(),\'" +groupName+ "\')]";
        Base.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(groupXpath)));
        return Base.driver.findElement(By.xpath(groupXpath)).isDisplayed();
    }
}
