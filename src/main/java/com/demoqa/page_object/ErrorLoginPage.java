package com.demoqa.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ErrorLoginPage {
    private final WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(id="name")
    WebElement errorMessage;
    public ErrorLoginPage(WebDriver driver) {
this.driver=driver;
    }
}
