package org.example.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginActions  {
    LoginWebElement loginWebElements;
    public LoginActions (){
        Base.BaseTest();
        loginWebElements = new LoginWebElement(Base.driver);
    }
    public void sendUsername (String username){
        loginWebElements.userNameElement.sendKeys(username);
    }
    public String getUserName (){
        return loginWebElements.userNameElement.getAttribute("value");
    }
    public void sendPassword (String password){
        loginWebElements.passwordElement.sendKeys(password);
    }
    public String getPassword (){
       return loginWebElements.passwordElement.getAttribute("value");
    }
    public boolean clickOnLoginBtn(){
        loginWebElements.loginBtnElement.click();
        Base.wait.until(ExpectedConditions.visibilityOf(loginWebElements.authElement));
        return loginWebElements.authElement.isDisplayed();
    }
    public void clickOnSkipBtn(){
        loginWebElements.skipBtnElemnt.click();
        Base.wait.until(ExpectedConditions.visibilityOf(loginWebElements.eventPageElemnt));
    }
    public boolean checkVisibiltyOfEventPage(){
        return loginWebElements.eventPageElemnt.isDisplayed();
    }


}
