package com.demoqa.page_object;

import com.demoqa.model.ItemTextBox;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TextBoxPage {
    private final WebDriver driver;
    protected WebDriverWait wait;
    @FindBy(css = "button#submit")
    private WebElement submit;
    @FindBy(css = "input#userName")
    private WebElement inputFullName;
    @FindBy(css = "input#userEmail")
    private WebElement inputEmail;
    @FindBy(css = "textarea#currentAddress")
    private WebElement inputCurrentAdress;
    @FindBy(css = "textarea#permanentAddress")
    private WebElement inputPermamentAdress;
    @FindBy(css = ".border.col-md-12.col-sm-12 p#name")
    private WebElement totalInfoNameText;
    @FindBy(css = ".border.col-md-12.col-sm-12 p#email")
    private WebElement totalInfoEmailText;
    @FindBy(css = ".border.col-md-12.col-sm-12 p#currentAddress")
    private WebElement totalInfoCurrentAddressText;
    @FindBy(css = ".border.col-md-12.col-sm-12 p#permanentAddress")
    private WebElement totalInfoPermanentAddressText;


    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);

    }

    public void typeName(String fullName) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(inputFullName));
        //  element.click();
        element.sendKeys(fullName);
    }

    public void typeEmail(String email) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(inputEmail));
        //  element.click();
        element.sendKeys(email);
    }

    public void typeCurrentAddress(String currentAddress) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(inputCurrentAdress));
        //  element.click();
        element.sendKeys(currentAddress);
    }

    public void typePermanentAddress(String permanentAddress) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(inputPermamentAdress));
        // element.click();
        element.sendKeys(permanentAddress);
    }

    public void submitForm() {
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();
    }


    public ItemTextBox getTotalInfo() {
        String _fullName;
        String _email;
        String _currentAddress;
        String _permanentAddress;
        try {
            _fullName = totalInfoNameText.isDisplayed() ? totalInfoNameText.getText() : "";
        } catch (org.openqa.selenium.NoSuchElementException e) {
            _fullName = "";
        }
        try {
            _email = totalInfoEmailText.isDisplayed() ? totalInfoEmailText.getText() : "";
        } catch (org.openqa.selenium.NoSuchElementException e) {
            _email = "";
        }
        try {
            _currentAddress = totalInfoCurrentAddressText.isDisplayed() ? totalInfoCurrentAddressText.getText() : "";
        } catch (org.openqa.selenium.NoSuchElementException e) {
            _currentAddress = "";
        }

        try {
            _permanentAddress = totalInfoPermanentAddressText.isDisplayed() ? totalInfoPermanentAddressText.getText() : "";
        } catch (org.openqa.selenium.NoSuchElementException e) {
            _permanentAddress = "";
        }


        return new ItemTextBox(_fullName.substring(_fullName.indexOf(":") + 1), _email.substring(_email.indexOf(":") + 1),
                _currentAddress.substring(_currentAddress.indexOf(":") + 1), _permanentAddress.substring(_permanentAddress.indexOf(":") + 1));
    }

    public String getCssClassInputEmail() {
        return inputEmail.getAttribute("class");
    }
}
