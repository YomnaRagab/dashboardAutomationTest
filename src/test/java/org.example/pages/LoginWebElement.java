package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginWebElement extends BaseElements {
    @FindBy(id="username")
    WebElement userNameElement;
    @FindBy(id="password")
    WebElement passwordElement;
    @FindBy (xpath = "//button[@type='submit']")
    WebElement loginBtnElement;
    @FindBy (xpath = "//label[@for=\"authCode\"]")
    WebElement authElement;
    @FindBy (xpath = "//button[@type=\"button\"]")
    WebElement skipBtnElemnt;
    @FindBy (xpath = "//h2[contains(text(), \"Events\")]")
    WebElement eventPageElemnt;
    public LoginWebElement(WebDriver driver) {
        super(driver);
    }
}
