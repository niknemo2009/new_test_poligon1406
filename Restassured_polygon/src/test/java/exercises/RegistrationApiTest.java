package exercises;

import exercises.helpers.ApiHelpers;
import exercises.model.User;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.hamcrest.Matchers.equalTo;

public class RegistrationApiTest {


    @Test
    @DisplayName("3.1 as User I want to register with a unique username and valid password ")
    public void testRegistration1() {

        String validPassword = "R3uvSzNO6bIkv_3c@";
        User newUser = new User(getUserName(), validPassword);

        Response response = ApiHelpers.registrationUser(newUser);

        response.then().statusCode(201);
        response.then().body("username", equalTo(newUser.getUserName()));
        Response responseLogin = ApiHelpers.login(newUser.getUserName(), validPassword);
        responseLogin.then().statusCode(200);

        String idUser = response.jsonPath().getString("userID");
        newUser.setId(idUser);
        ApiHelpers.deleteUser(newUser).then().statusCode(204);

    }

    @ParameterizedTest
    @DisplayName("3.2 as User I can NOT to register with a unique username and invalid password")
    @ValueSource(strings = {"R3Sv_c@", "R3uvSzNO6bIkv_3c", "RuvzNObIkvc@", "RuvSzNObIkv_c@"})
    public void testRegistration2(String password) {

        User newUser = new User(getUserName(), password);
        Response response = ApiHelpers.registrationUser(newUser);

        response.then().statusCode(400);
        response.then().body("code", equalTo("1300")).body("message", equalTo("Passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer."));
        Response responseLogin = ApiHelpers.login(newUser.getUserName(), password);
        responseLogin.then().statusCode(404);


    }

    @Test
    @DisplayName("3.3 as User I can NOT to register user with a NotUnique username and valid password ")
    public void testRegistration3() {
        String userName = getUserName();
        String validPassword = "R3uvSzNO6bIkv_3c@";
        User user1 = new User(userName, validPassword);
        User user2 = new User(userName, validPassword);
        Response temp = ApiHelpers.registrationUser(user1);
        Response response = ApiHelpers.registrationUser(user2);

        response.then().statusCode(406);
        response.then().body("code", equalTo("1204")).body("message", equalTo("User exists!"));


        String idUser = temp.jsonPath().getString("userID");
        user1.setId(idUser);
        ApiHelpers.deleteUser(user1).then().statusCode(204);

    }


    public String getUserName() {
        Random random = new Random();
        return "user" + random.nextInt(100000);

    }

}
