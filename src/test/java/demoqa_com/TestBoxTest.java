package demoqa_com;

import base.BaseTest;
import demoqa_com.model.ItemTextBox;
import demoqa_com.page_object.TextBoxPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBoxTest extends BaseTest {
    public final String FILE_SCREENSHOTS = "./Screenshots/%s.png";
    private TextBoxPage textBoxPage;



    @BeforeEach
    public void init(TestInfo testInfo) {
        super.init(testInfo);
        driver.get("https://demoqa.com/text-box");
        textBoxPage = new TextBoxPage(driver);
    }

    @ParameterizedTest(name = "1.1 I should type valid name= {0}, valid email= {1}, valid currentAddress= {2},valid permanentAddress= {3} and submit ")
    @MethodSource("dataList")
    @DisplayName("Positive tests")
    public void testBase(String fullName, String email, String currentAddress, String permanentAddress) throws Exception {
        ItemTextBox item = new ItemTextBox(fullName, email, currentAddress, permanentAddress);
        textBoxPage.typeName(item.fullName());
        textBoxPage.typeEmail(item.email());
        textBoxPage.typeCurrentAddress(item.currentAddress());
        textBoxPage.typePermanentAddress(item.permanentAddress());
        textBoxPage.submit.click();
        makeScreenshot(FILE_SCREENSHOTS.formatted(testInfo.getDisplayName()), driver);
        Assertions.assertEquals(item, textBoxPage.getTotalInfo());


    }


    @Test
    @DisplayName("1.2 I should correct validate email after submit if  email is invalid")
    public void testBase( ) throws Exception {
        ItemTextBox item = new ItemTextBox("fullName", "invalid email.com", "currentAddress", "permanentAddress");
        textBoxPage.typeName(item.fullName());
        textBoxPage.typeEmail(item.email());
        textBoxPage.typeCurrentAddress(item.currentAddress());
        textBoxPage.typePermanentAddress(item.permanentAddress());
        textBoxPage.submit.click();
        assertAll("Check a validation invalid email!",
                () -> assertEquals(textBoxPage.getCssClassInputEmail(), "mr-sm-2 field-error form-control", "Problem with attribute  class for inputEmail !"),
                () -> Assertions.assertEquals(new ItemTextBox("","","",""),
                        textBoxPage.getTotalInfo(),"Problem with totalInfo for invalid email")
        );


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
                Arguments.of(repeat("fullName",550), "qwe@wer.com", "rfdfddf", "dfdfdfdf")

        );
    }





}

