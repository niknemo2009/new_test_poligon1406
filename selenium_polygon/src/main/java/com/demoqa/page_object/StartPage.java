package com.demoqa.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StartPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    @FindBy(id = "userName-value")
    WebElement labelNameUser;

    public StartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public String getNameSignInUser() {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(labelNameUser));
        return element.getText();
    }
}
