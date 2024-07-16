package rest_assured;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class HelloWorldRestAssured {

    @Test
    public void makeSureThatGoogleIsUp() {
        given().when().get("http://www.google.com").then().statusCode(200);
    }

}