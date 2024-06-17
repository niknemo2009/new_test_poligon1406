package demoqa_com;

import base.BaseTest;
import demoqa_com.model.ItemTextBox;
import demoqa_com.page_object.TextBoxPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TestBoxTest extends BaseTest {
    public final String FILE_SCREENSHOTS = "./Screenshots/%s.png";
    private TextBoxPage textBoxPage;



    @BeforeEach
    public void init(TestInfo testInfo) {
        super.init(testInfo);
        driver.get("https://demoqa.com/text-box");
        textBoxPage = new TextBoxPage(driver);
    }

    @ParameterizedTest(name = "1.1 I should type name= {0}, email= {1}, currentAddress= {2}, permanentAddress= {3} and submit ")
    @MethodSource("dataList")
    public void testBase(String fullName, String email, String currentAddress, String permanentAddress) throws Exception {
        ItemTextBox item = new ItemTextBox(fullName, email, currentAddress, permanentAddress);
        textBoxPage.typeName(item.fullName());
        textBoxPage.typeEmail(item.email());
        textBoxPage.typeCurrentAddress(item.currentAddress());
        textBoxPage.typePermanentAddress(item.permanentAddress());
        textBoxPage.submit.click();
        Assertions.assertEquals(item, textBoxPage.getTotalInfo());
//        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//        String textInAlert = alert.getText();
//        alert.accept();
//        makeScreenshot(FILE_SCREENSHOTS.formatted(testInfo.getDisplayName()), driver);
//        assertEquals("I am an alert box!", textInAlert, "Problem with text in simple alert !");

    }

    public static Stream<Arguments> dataList() {
        return Stream.of(
                Arguments.of("FullName", "qwe@qwe.com", "Ukraine", "Lviv"),
                Arguments.of("", "qwe12@qwe.com", "Ukraine", "Lviv"),
                Arguments.of("FullName", "", "Ukraine", "Lviv"),
                Arguments.of("FullName", "qwe@qwe.com", "", "Lviv"),
                Arguments.of("FullName", "qwe@qwe.com", "Ukraine", ""),
                Arguments.of("", "qwe@qwe.com", "", ""),
                Arguments.of("", "", "", "")

        );
    }

}

