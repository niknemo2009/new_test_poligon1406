package com.demoqa.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginRegistryPage {
    private final WebDriver driver;
    protected WebDriverWait wait;
    @FindBys({@FindBy(tagName = "h1"),
            @FindBy(linkText = "Login")})
    private WebElement header1;
    @FindBys({@FindBy(tagName = "h2"),
            @FindBy(linkText = "Welcome,")})
    private WebElement header2;
    @FindBys({@FindBy(tagName = "h5"),
            @FindBy(linkText = "Login in Book Store")})
    private WebElement header3;
    @FindBy(id="userName-label")
    WebElement labelUser;
    @FindBy(id="userName")
    WebElement inputUserName;
    @FindBy(id="password-label")
    WebElement labelPassword;
    @FindBy(id="password")
    WebElement inputPassword;
    @FindBy(id="login")
    WebElement buttonLogin;
    @FindBy(id="newUser")
    WebElement buttonRegistry;

    public LoginRegistryPage(WebDriver driver) {
        this.driver = driver;
    }

    private LoginRegistryPage typeLogin(String login){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(inputUserName));
        element.sendKeys(login);
        return this;

    }

    private LoginRegistryPage typePassword(String password){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(inputPassword));
        element.sendKeys(password);
        return this;
    }

    private void clickLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonLogin)).click();
    }


    public  StartPage  signInExistsUser(String login , String password){
                 typeLogin(login).typePassword(password).clickLogin();
                 return new StartPage(driver);
    }

    public  ErrorLoginPage  signInNotExistsUser(String login , String password){
        typeLogin(login).typePassword(password).clickLogin();
        return new ErrorLoginPage(driver);
    }
}