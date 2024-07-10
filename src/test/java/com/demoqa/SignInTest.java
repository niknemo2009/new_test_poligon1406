package com.demoqa;

import com.demoqa.base.BaseTest;
import com.demoqa.base.Color;
import com.demoqa.base.TypeBrowser;
import com.demoqa.page_object.ErrorLoginPage;
import com.demoqa.page_object.LoginRegistryPage;
import com.demoqa.page_object.StartPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.opentest4j.AssertionFailedError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignInTest extends BaseTest {

    private LoginRegistryPage loginPage;
    Logger logger = LoggerFactory.getLogger(SignInTest.class);
    private final String START_URL= "https://demoqa.com/login";




    private void setUpTest(int delta, TypeBrowser browser) {
        init(testInfo, delta, browser);
        driver.get(START_URL);
        loginPage = new LoginRegistryPage(driver);
        logger.info(Color.GREEN.value() + "Before each !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + Color.RESET.value());
    }
    @Test
    @DisplayName("2.1 As registered user I should sign In with my credentials")
    public void testSigniInWithExistedUsers() throws Exception {
        setUpTest(0, TypeBrowser.CHROME);
        StartPage expectedResult = loginPage.signInExistsUser(USER_LOGIN, USER_PASSWORD);

        try {
            assertEquals(USER_LOGIN, expectedResult.getNameSignInUser(), "Problem with name expected user !");
        } catch (AssertionFailedError e) {
            makeScreenshot(PATH_SCREENSHOTS.formatted(testInfo.getDisplayName() + e.getMessage()), driver);
            throw new AssertionFailedError(e.getMessage());

        }


    }

    @Test
    @DisplayName("2.2 As unregistered user I should Not sign In with any credentials")
    public void testSigniInWithNotExistedUsers() throws Exception {
        setUpTest(0, TypeBrowser.CHROME);
        ErrorLoginPage expectedResult = loginPage.signInNotExistsUser("user333", "LkHQA*eyN6nPTiM");
        try {
            assertEquals("Invalid username or password!", expectedResult.getErrorMessage());
        } catch (AssertionFailedError e) {
            makeScreenshot(PATH_SCREENSHOTS.formatted(testInfo.getDisplayName() + e.getMessage()), driver);
            throw new AssertionFailedError(e.getMessage());

        }


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

