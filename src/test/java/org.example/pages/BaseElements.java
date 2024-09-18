package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaseElements {
    WebDriver driver;
    public BaseElements(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver, this);    }
    @FindBy(xpath = "//img[@class='mt-5']")
    WebElement loginImageElement;
    @FindBy (xpath = "//span[contains(text(),\"Content\")]")
    WebElement contentArrowElement;

}
