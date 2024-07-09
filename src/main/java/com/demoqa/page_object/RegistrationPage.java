package com.demoqa.page_object;

import com.demoqa.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    private final WebDriver driver;
    protected WebDriverWait wait;
    @FindBy(id="firstname")
    WebElement inputFirstName;
    @FindBy(id="lastname")
    WebElement inputLastName;
    @FindBy(id="userName")
    WebElement inputUserName;
    @FindBy(id="password")
    WebElement inputPassword;
    @FindBy(id="register")
    WebElement buttonRegister;
    @FindBy(id="gotologin")
    WebElement buttonBackupLogin;
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void registerUser(User newUser){
        typeFistName(newUser.firstName()).
                typeLastName(newUser.lastName()).
                typeUserName(newUser.userName()).
                typePassword(newUser.password()).
                clickCaptcha().clickRegister();

    }
    private RegistrationPage typeFistName(String firstName){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(inputFirstName));
        element.sendKeys(firstName);
        return this;

    }
    private RegistrationPage typeLastName(String lastName){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(inputLastName));
        element.sendKeys(lastName);
        return this;

    }
    private RegistrationPage typeUserName(String userName){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(inputUserName));
        element.sendKeys(userName);
        return this;

    }

    private RegistrationPage typePassword(String password){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(inputPassword));
        element.sendKeys(password);
        return this;

    }
    private RegistrationPage clickRegister(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(buttonRegister));
        element.click();
        return this;

    }

    private LoginRegistryPage clickButtonBackupLogin(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(buttonBackupLogin));
        element.click();
        return new LoginRegistryPage(driver);
    }

    private RegistrationPage clickCaptcha(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-checkmark"))).click();
    return this;
    }
}


