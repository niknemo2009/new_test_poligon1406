package com.demoqa;

import com.demoqa.base.BaseTest;
import com.demoqa.model.User;
import com.demoqa.page_object.ErrorLoginPage;
import com.demoqa.page_object.LoginRegistryPage;
import com.demoqa.page_object.StartPage;
import io.restassured.builder.RequestSpecBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.Color;
import util.TestUtil;
import util.TypeBrowser;

import java.time.LocalDateTime;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiRegistrationTest extends BaseTest implements TestUtil {

    private final String START_URL = "https://demoqa.com/login";
    Logger logger = LoggerFactory.getLogger(ApiRegistrationTest.class);
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

    @Test(dataProvider = "test1",description = "2.1 As registered user I should sign In with my credentials")
    public void testSigniInWithExistedUsers(User registeredUser, TypeBrowser currentBrowser, Integer deltaVersion) {
        setUpTest(5, TypeBrowser.FIREFOX);
        StartPage expectedResult = loginRegistryPage.signInExistsUser(registeredUser.userName(), registeredUser.password());
        assertEquals(registeredUser.userName(), expectedResult.getNameSignInUser(), "Problem with name expected user !");

    }

    @Test(dataProvider = "test1",description = "2.2 As unregistered user I should Not sign In with any credentials")
        public void testSigniInWithNotExistedUsers(User unregisteredUser, TypeBrowser currentBrowser, Integer deltaVersion) {
        setUpTest(deltaVersion, currentBrowser);
        ErrorLoginPage errorLoginPage = loginRegistryPage.signInNotExistsUser(unregisteredUser.userName(), unregisteredUser.password());
        assertEquals("Invalid username or password!", errorLoginPage.getErrorMessage());

        }



    @DataProvider(name = "test1")
    public Object[][] generateTestData1() {
        User user1 = new User( getUserName(), "LkHQA*eyN6nPTiM");
        User user2 = new User(getUserName(), "LkHQA*eyN6nPTiM");
        createUser(user1.userName(), user1.password());
        createUser(user2.userName(), user2.password());
        Object[][] data ={
                { user1, TypeBrowser.CHROME, 0 },
                { user1, TypeBrowser.CHROME, 0},
                {user1, TypeBrowser.CHROME, 0},
                {user1, TypeBrowser.CHROME, 5},
                {user1, TypeBrowser.CHROME, 5},
                {user1, TypeBrowser.CHROME, 5},
                {user2, TypeBrowser.FIREFOX, 0},
                {user2, TypeBrowser.FIREFOX, 0},
                {user2, TypeBrowser.FIREFOX, 0},
                {user2, TypeBrowser.FIREFOX, 5},
                {user2, TypeBrowser.FIREFOX, 5},
                {user2, TypeBrowser.FIREFOX, 5}
        };
        return data;
    }

    public void createUser(String userName, String password) {
        User user = new User(userName, password);
         RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
        requestBuilder.setBaseUri("https://demoqa.com");
        requestBuilder.setBasePath("/Account/v1/User");
        requestBuilder.addHeader("Content-Type", "application/json");
        requestBuilder.addHeader("Accept", "application/json");
        requestBuilder.setBody("{\"userName\":\"" + userName + "\",\"password\":\"" + password + "\"}");
        given().spec(requestBuilder.build()).post().then().statusCode(201);
    }

    public String getUserName() {
        Random random = new Random();
        return "user" + random.nextInt(100000);

    }

}



