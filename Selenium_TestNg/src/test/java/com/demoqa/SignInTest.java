package com.demoqa;

import com.demoqa.base.BaseTest;
import com.demoqa.model.User;
import com.demoqa.page_object.ErrorLoginPage;
import com.demoqa.page_object.LoginRegistryPage;
import com.demoqa.page_object.StartPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import util.Color;
import util.TestUtil;
import util.TypeBrowser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.time.LocalDateTime;
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

   @AfterMethod
    public void afterMetod(final ITestResult result){
     if(!result.isSuccess()){
         makeScreenshot(PATH_SCREENSHOTS.formatted(result.getName() + LocalDateTime.now().toString()), driver);

     }
    }

    @Test(description = "2.1 As registered user I should sign In with my credentials")
    public void testSigniInWithExistedUsers() {
        setUpTest(5, TypeBrowser.FIREFOX);
        StartPage expectedResult = loginRegistryPage.signInExistsUser(USER_LOGIN, USER_PASSWORD);
        assertEquals(USER_LOGIN, expectedResult.getNameSignInUser(), "Problem with name expected user !");

    }

    @Test(dataProvider = "test1",description = "2.2 As unregistered user I should Not sign In with any credentials")
        public void testSigniInWithNotExistedUsers(User unregisteredUser, TypeBrowser currentBrowser, Integer deltaVersion) {
        setUpTest(deltaVersion, currentBrowser);
        ErrorLoginPage errorLoginPage = loginRegistryPage.signInNotExistsUser(unregisteredUser.userName(), unregisteredUser.password());
        assertEquals("Invalid username or password!", errorLoginPage.getErrorMessage());

        }



    @DataProvider(name = "test1")
    public Object[][] generateTestData1() {
        return new Object[][] {
                { new User("", "", "user1", "1234567"), TypeBrowser.CHROME, 0 },
                { new User("", "", "user33", "1234567"), TypeBrowser.CHROME, 0},
                {new User("", "", "user1", "LkHQA*eyN6nPTiM"), TypeBrowser.CHROME, 0},
                {new User("", "", "user1", "1234567"), TypeBrowser.CHROME, 5},
                {new User("", "", "user33", "1234567"), TypeBrowser.CHROME, 5},
                {new User("", "", "user1", "LkHQA*eyN6nPTiM"), TypeBrowser.CHROME, 5},
                {new User("", "", "user1", "1234567"), TypeBrowser.FIREFOX, 0},
                {new User("", "", "user33", "1234567"), TypeBrowser.FIREFOX, 0},
                {new User("", "", "user1", "LkHQA*eyN6nPTiM"), TypeBrowser.FIREFOX, 0},
                {new User("", "", "user1", "1234567"), TypeBrowser.FIREFOX, 5},
                {new User("", "", "user33", "1234567"), TypeBrowser.FIREFOX, 5},
                {new User("", "", "user1", "LkHQA*eyN6nPTiM"), TypeBrowser.FIREFOX, 5}
        };
    }


}



