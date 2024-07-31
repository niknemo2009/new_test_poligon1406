package com.demoqa;

import com.demoqa.base.BaseTest;
import com.demoqa.model.User;
import com.demoqa.page_object.ErrorLoginPage;
import com.demoqa.page_object.LoginRegistryPage;
import com.demoqa.page_object.StartPage;
import util.Color;
import util.TestUtil;
import util.TypeBrowser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.opentest4j.AssertionFailedError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignInTest extends BaseTest implements TestUtil {

    private final String START_URL = "https://demoqa.com/login";
    Logger logger = LoggerFactory.getLogger(SignInTest.class);
    private LoginRegistryPage loginRegistryPage;


    private void setUpTest(int delta, TypeBrowser browser) {
        init(delta, browser);
        driver.get(START_URL);
        loginRegistryPage = new LoginRegistryPage(driver);
        logger.info(Color.GREEN.value() + "Before each !" + Color.RESET.value());
    }

    @Test
    @DisplayName("2.1 As registered user I should sign In with my credentials")
    public void testSigniInWithExistedUsers(TestInfo testInfo) {
        setUpTest(5, TypeBrowser.FIREFOX);
        StartPage expectedResult = loginRegistryPage.signInExistsUser(USER_LOGIN, USER_PASSWORD);
        try {
            assertEquals(USER_LOGIN, expectedResult.getNameSignInUser(), "Problem with name expected user !");
        } catch (AssertionFailedError e) {
            makeScreenshot(PATH_SCREENSHOTS.formatted(testInfo.getDisplayName() + e.getMessage()), driver);
            throw new AssertionFailedError(e.getMessage());

        }
    }

    @ParameterizedTest
    @MethodSource("generateTestData")
    @DisplayName("2.2 As unregistered user I should Not sign In with any credentials")
    public void testSigniInWithNotExistedUsers(User unregisteredUser, TypeBrowser currentBrowser, int deltaVersion, TestInfo testInfo) {
        setUpTest(deltaVersion, currentBrowser);
        ErrorLoginPage errorLoginPage = loginRegistryPage.signInNotExistsUser(unregisteredUser.userName(), unregisteredUser.password());
        try {
            assertEquals("Invalid username or password!", errorLoginPage.getErrorMessage());
        } catch (AssertionFailedError e) {
            makeScreenshot(PATH_SCREENSHOTS.formatted(testInfo.getDisplayName() + e.getMessage()), driver);
            throw new AssertionFailedError(e.getMessage());

        }

    }

    public static Stream<Arguments> generateTestData() {
        return Stream.of(
                Arguments.arguments(new User("", "", "user1", "1234567"), TypeBrowser.CHROME, 0),
                Arguments.arguments(new User("", "", "user33", "1234567"), TypeBrowser.CHROME, 0),
                Arguments.arguments(new User("", "", "user1", "LkHQA*eyN6nPTiM"), TypeBrowser.CHROME, 0),
                Arguments.arguments(new User("", "", "user1", "1234567"), TypeBrowser.CHROME, 5),
                Arguments.arguments(new User("", "", "user33", "1234567"), TypeBrowser.CHROME, 5),
                Arguments.arguments(new User("", "", "user1", "LkHQA*eyN6nPTiM"), TypeBrowser.CHROME, 5),
                Arguments.arguments(new User("", "", "user1", "1234567"), TypeBrowser.FIREFOX, 0),
                Arguments.arguments(new User("", "", "user33", "1234567"), TypeBrowser.FIREFOX, 0),
                Arguments.arguments(new User("", "", "user1", "LkHQA*eyN6nPTiM"), TypeBrowser.FIREFOX, 0),
                Arguments.arguments(new User("", "", "user1", "1234567"), TypeBrowser.FIREFOX, 5),
                Arguments.arguments(new User("", "", "user33", "1234567"), TypeBrowser.FIREFOX, 5),
                Arguments.arguments(new User("", "", "user1", "LkHQA*eyN6nPTiM"), TypeBrowser.FIREFOX, 5));
    }
}



