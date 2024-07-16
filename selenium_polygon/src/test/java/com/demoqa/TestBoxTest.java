package com.demoqa;

import com.demoqa.base.BaseTest;
import com.demoqa.model.ItemTextBox;
import com.demoqa.page_object.TextBoxPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.TestUtil;
import util.TypeBrowser;
import util.Color;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBoxTest extends BaseTest implements TestUtil {
    public final String FILE_SCREENSHOTS = "./Screenshots/%s.png";
    private final String START_URL = "https://demoqa.com/text-box";
    Logger logger = LoggerFactory.getLogger(TestBoxTest.class);
    private TextBoxPage textBoxPage;



    private void setUpTest(int delta, TypeBrowser browser) {
        init(delta, browser);
        driver.get(START_URL);
        textBoxPage = new TextBoxPage(driver);
        logger.info(Color.GREEN.value() + "Before each !" + Color.RESET.value());
    }

    @ParameterizedTest(name = "1.1 I should type valid name= {0}, valid email= {1}, valid currentAddress= {2},valid permanentAddress= {3} and submit ")
    @MethodSource("dataList")
    @DisplayName("Positive tests")
    public void testBase(String fullName, String email, String currentAddress, String permanentAddress, TestInfo testInfo) {
        setUpTest(0, TypeBrowser.CHROME);
        ItemTextBox itemTextBox = new ItemTextBox(fullName, email, currentAddress, permanentAddress);
        textBoxPage.typeName(itemTextBox.fullName());
        textBoxPage.typeEmail(itemTextBox.email());
        textBoxPage.typeCurrentAddress(itemTextBox.currentAddress());
        textBoxPage.typePermanentAddress(itemTextBox.permanentAddress());
        textBoxPage.submitForm();
        makeScreenshot(FILE_SCREENSHOTS.formatted(testInfo.getDisplayName()), driver);
        Assertions.assertEquals(itemTextBox, textBoxPage.getTotalInfo());

    }

    public static Stream<Arguments> dataList() {
        return Stream.of(
                Arguments.of("FullName", "qwe@qwe.com", "Ukraine", "Lviv"),
                Arguments.of("", "qwe12@qwe.com", "Ukraine", "Lviv"),
                Arguments.of("FullName", "", "Ukraine", "Lviv"),
                Arguments.of("FullName", "qwe@qwe.com", "", "Lviv"),
                Arguments.of("FullName", "qwe@qwe.com", "Ukraine", ""),
                Arguments.of("", "qwe@qwe.com", "", ""),
                Arguments.of("", "", "", ""),
                Arguments.of(new TestUtil() {
                }.repeat("fullName", 550), "qwe@wer.com", "rfdfddf", "dfdfdfdf")

        );

    }
    @Test
    @DisplayName("1.2 I should correct validate email after submit if  email is invalid")
    public void testBase() {

        setUpTest(0, TypeBrowser.CHROME);
        ItemTextBox item = new ItemTextBox("fullName", "invalid email.com", "currentAddress", "permanentAddress");
        textBoxPage.typeName(item.fullName());
        textBoxPage.typeEmail(item.email());
        textBoxPage.typeCurrentAddress(item.currentAddress());
        textBoxPage.typePermanentAddress(item.permanentAddress());
        textBoxPage.submitForm();
        assertAll("Check a validation invalid email!",
                () -> assertEquals(textBoxPage.getCssClassInputEmail(), "mr-sm-2 field-error form-control", "Problem with attribute  class for inputEmail !"),
                () -> Assertions.assertEquals(new ItemTextBox("", "", "", ""),
                        textBoxPage.getTotalInfo(), "Problem with totalInfo for invalid email")
        );

    }

}

