package com.qa.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

    public static void waitForConditions(WebDriver driver, WebElement ele){
        WebDriverWait wait= new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOf(ele));

    }

    public static boolean apply(WebDriver driver) {
        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
    }

}