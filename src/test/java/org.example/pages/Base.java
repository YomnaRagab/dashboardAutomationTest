package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.Stack;

public class Base {
    static WebDriver driver;
    static WebDriverWait wait ;
    static BaseElements baseElements;
    static JavascriptExecutor js ;
    public static void BaseTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        baseElements = new BaseElements(driver);
        js = (JavascriptExecutor) driver;
        driver.get("https://qa-test-frontend-ce07bae316f3.herokuapp.com/");
        wait.until(ExpectedConditions.visibilityOf(baseElements.loginImageElement));

    }
    public static void scrollingToElement(WebElement element){
        new Actions(driver)
                .scrollToElement(element)
                .perform();
    }
    public static void scrollingToElementJs(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public static void tearDown(){
        driver.quit();
    }
//    public void openWebSite(){
//        driver.get("https://qa-test-frontend-ce07bae316f3.herokuapp.com/");
//        wait.until(ExpectedConditions.visibilityOf(baseElements.loginImageElement));
//
//    }
}
