package com.demoqa;

import com.demoqa.base.BaseTest;
import com.demoqa.model.ItemTextBox;
import com.demoqa.page_object.ErrorLoginPage;
import com.demoqa.page_object.LoginRegistryPage;
import com.demoqa.page_object.StartPage;
import com.demoqa.page_object.TextBoxPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignInTest extends BaseTest {
    public final String FILE_SCREENSHOTS = "./Screenshots/%s.png";
    private LoginRegistryPage loginPage;



    @BeforeEach
    public void init(TestInfo testInfo) {
        super.init(testInfo);
        driver.get("https://demoqa.com/login");
        loginPage = new LoginRegistryPage(driver);
    }

    @Test
    @DisplayName("Positive tests")
    public void testSigniInWithExistedUsers() throws Exception {
        StartPage expectedResult=loginPage.signInExistsUser("user33","LkHQA*eyN6nPTiM");
        makeScreenshot(FILE_SCREENSHOTS.formatted(testInfo.getDisplayName()), driver);
        assertEquals("user33",expectedResult.getNameSignInUser());


    }
    @Test
    @DisplayName("Positive tests")
    public void testSigniInWithNotExistedUsers() throws Exception {
        ErrorLoginPage expectedResult=loginPage.signInNotExistsUser("user333","LkHQA*eyN6nPTiM");
        makeScreenshot(FILE_SCREENSHOTS.formatted(testInfo.getDisplayName()), driver);
        assertEquals("Invalid username or password!",expectedResult.getErrorMessage());


    }

//
//    @Test
//    @DisplayName("1.2 I should correct validate email after submit if  email is invalid")
//    public void testBase( ) throws Exception {
//        ItemTextBox item = new ItemTextBox("fullName", "invalid email.com", "currentAddress", "permanentAddress");
//        textBoxPage.typeName(item.fullName());
//        textBoxPage.typeEmail(item.email());
//        textBoxPage.typeCurrentAddress(item.currentAddress());
//        textBoxPage.typePermanentAddress(item.permanentAddress());
//        textBoxPage.submit.click();
//        assertAll("Check a validation invalid email!",
//                () -> assertEquals(textBoxPage.getCssClassInputEmail(), "mr-sm-2 field-error form-control", "Problem with attribute  class for inputEmail !"),
//                () -> Assertions.assertEquals(new ItemTextBox("","","",""),
//                        textBoxPage.getTotalInfo(),"Problem with totalInfo for invalid email")
//        );
//
//
//    }
//    public static Stream<Arguments> dataList() {
//        return Stream.of(
//                Arguments.of("FullName", "qwe@qwe.com", "Ukraine", "Lviv"),
//                Arguments.of("", "qwe12@qwe.com", "Ukraine", "Lviv"),
//                Arguments.of("FullName", "", "Ukraine", "Lviv"),
//                Arguments.of("FullName", "qwe@qwe.com", "", "Lviv"),
//                Arguments.of("FullName", "qwe@qwe.com", "Ukraine", ""),
//                Arguments.of("", "qwe@qwe.com", "", ""),
//                Arguments.of("", "", "", ""),
//                Arguments.of(repeat("fullName",550), "qwe@wer.com", "rfdfddf", "dfdfdfdf")
//
//        );
//    }





}

