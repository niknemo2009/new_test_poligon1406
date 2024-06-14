package demoqa_com.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TextBoxPage {
    private final WebDriver driver;
    @FindBy(css = "")
    WebElement inputFullName;
    @FindBy(css = "")
    private WebElement inputEmail;

    @FindBy(id = "")
    private WebElement inputCurrentAdress;

    @FindBy(id = "")
    private WebElement inputPermamentAdress;
    @FindBy(id = "")
    private WebElement submit;
    @FindBy(id = "")
    private WebElement totalInfoText;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


}
