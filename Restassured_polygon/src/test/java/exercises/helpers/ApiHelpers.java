package exercises.helpers;

import exercises.model.User;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiHelpers {


    public static Response registrationUser(User user) {
        RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
        requestBuilder.setBaseUri("https://demoqa.com");
        requestBuilder.setBasePath("/Account/v1/User");
        requestBuilder.addHeader("Content-Type", "application/json");
        requestBuilder.addHeader("Accept", "application/json");
        requestBuilder.setBody("{\"userName\":\"" + user.getUserName() + "\",\"password\":\"" + user.getPassword() + "\"}");
        return given().spec(requestBuilder.build()).post().thenReturn();
    }

    public static Response login(String userName, String password) {
        RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
        requestBuilder.setBaseUri("https://demoqa.com");
        requestBuilder.setBasePath("/Account/v1/Authorized");
        requestBuilder.addHeader("Content-Type", "application/json");
        requestBuilder.addHeader("Accept", "application/json");
        requestBuilder.setBody("{\"userName\":\"" + userName + "\",\"password\":\"" + password + "\"}");
        return given().spec(requestBuilder.build()).post().thenReturn();
    }

    public static Response deleteUser(User user) {
        String token = generateToken(user).jsonPath().getString("token");
        RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
        requestBuilder.setBaseUri("https://demoqa.com");
        requestBuilder.setBasePath("/Account/v1/User/" + user.getId());
        requestBuilder.addHeader("Content-Type", "application/json");
        requestBuilder.addHeader("Authorization", "Bearer " + token);
        requestBuilder.addHeader("Accept", "application/json");
        return given().spec(requestBuilder.build()).delete().thenReturn();
    }

    public static Response generateToken(User user) {
        RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
        requestBuilder.setBaseUri("https://demoqa.com");
        requestBuilder.setBasePath("/Account/v1/GenerateToken");
        requestBuilder.addHeader("Content-Type", "application/json");
        requestBuilder.addHeader("Accept", "application/json");
        requestBuilder.setBody("{\"userName\":\"" + user.getUserName() + "\",\"password\":\"" + user.getPassword() + "\"}");
        return given().spec(requestBuilder.build()).post().thenReturn();
    }
}
