package com.demoqa.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginRegistryPage {
    private final WebDriver driver;
    private WebDriverWait wait;
    @FindBy(id = "userName-label")
    private WebElement labelUser;
    @FindBy(id = "userName")
    private WebElement inputUserName;
    @FindBy(id = "password-label")
    private WebElement labelPassword;
    @FindBy(id = "password")
    private WebElement inputPassword;
    @FindBy(id = "login")
    private WebElement buttonLogin;
    @FindBy(id = "newUser")
    private WebElement buttonRegistry;
    @FindBys({@FindBy(tagName = "h1"),
            @FindBy(linkText = "Login")})
    private WebElement header1;
    @FindBys({@FindBy(tagName = "h2"),
            @FindBy(linkText = "Welcome,")})
    private WebElement header2;
    @FindBys({@FindBy(tagName = "h5"),
            @FindBy(linkText = "Login in Book Store")})
    private WebElement header3;

    public LoginRegistryPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    private LoginRegistryPage typeLogin(String login) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(inputUserName));
        element.sendKeys(login);
        return this;

    }

    private LoginRegistryPage typePassword(String password) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(inputPassword));
        element.sendKeys(password);
        return this;
    }

    private void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonLogin)).click();
    }


    public StartPage signInExistsUser(String login, String password) {
        typeLogin(login).typePassword(password).clickLogin();
        return new StartPage(driver);
    }

    public ErrorLoginPage signInNotExistsUser(String login, String password) {
        typeLogin(login).typePassword(password).clickLogin();
        return new ErrorLoginPage(driver);
    }

    public RegistrationPage registrationClick() {
        wait.until(ExpectedConditions.visibilityOf(buttonRegistry)).click();
        return new RegistrationPage(driver);
    }

}
