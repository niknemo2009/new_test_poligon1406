package demoqa_com.page_object;

import demoqa_com.model.ItemTextBox;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TextBoxPage {
    private final WebDriver driver;
    @FindBy(css = "input#userName")
   private WebElement inputFullName;
    @FindBy(css = "input#userEmail")
    private WebElement inputEmail;

    @FindBy(css = "textarea#currentAddress")
    private WebElement inputCurrentAdress;

    @FindBy(css= "textarea#permanentAddress")
    private WebElement inputPermamentAdress;
    @FindBy(id = "submit")
    public WebElement submit;
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
        PageFactory.initElements(driver, this);

    }

    public void typeName(String fullName){
        inputFullName.click();
        inputFullName.sendKeys(fullName);
    }
    public void typeEmail(String email){
        inputEmail.click();
        inputEmail.sendKeys(email);
    }

    public void typeCurrentAddress(String currentAddress){
        inputCurrentAdress.click();
        inputCurrentAdress.sendKeys(currentAddress);
    }
    public void typePermanentAddress(String permanentAddress){
        inputPermamentAdress.click();
        inputPermamentAdress.sendKeys(permanentAddress);
    }

    public ItemTextBox getTotalInfo(){
        String _fullName;
        String _email;
        String _currentAddress;
        String _permanentAddress;
        try{
             _fullName=totalInfoNameText.isDisplayed()?totalInfoNameText.getText():"";
        }catch(org.openqa.selenium.NoSuchElementException e){
            _fullName="";
        }
        try{
            _email=totalInfoEmailText.isDisplayed()?totalInfoEmailText.getText():"";
        }catch(org.openqa.selenium.NoSuchElementException e){
           _email="";
        }
        try{
            _currentAddress=totalInfoCurrentAddressText.isDisplayed()?totalInfoCurrentAddressText.getText():"";
        }catch(org.openqa.selenium.NoSuchElementException e){
            _currentAddress ="";
        }

        try{
            _permanentAddress=totalInfoPermanentAddressText.isDisplayed()?totalInfoPermanentAddressText.getText():"";
        }catch(org.openqa.selenium.NoSuchElementException e){
            _permanentAddress ="";
        }


        return new ItemTextBox(_fullName.substring(_fullName.indexOf(":")+1),_email.substring(_email.indexOf(":")+1),
                _currentAddress.substring(_currentAddress.indexOf(":")+1),_permanentAddress.substring(_permanentAddress.indexOf(":")+1));
    }

    public String getCssClassInputEmail(){
        return inputEmail.getAttribute("class");
    }
}
