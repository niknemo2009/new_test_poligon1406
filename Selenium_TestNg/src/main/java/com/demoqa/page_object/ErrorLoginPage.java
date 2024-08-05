package com.demoqa.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ErrorLoginPage {
    private final WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "name")
    WebElement errorMessage;

    public ErrorLoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public String getErrorMessage() {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return element.getText();
    }
}
