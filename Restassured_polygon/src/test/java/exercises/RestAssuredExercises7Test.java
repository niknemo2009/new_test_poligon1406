package exercises;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
//import dataentities.Photo;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@WireMockTest(httpPort = 9876)
public class RestAssuredExercises7Test {

    private RequestSpecification requestSpec;

    @BeforeEach
    public void createRequestSpecification() {
        WireMock.reset();
        requestSpec = new RequestSpecBuilder().
                setBaseUri("http://localhost").
                setPort(9876).
                setContentType(ContentType.JSON).
                build();


    }

    @Test
    public void fromUserId_findPhotoTitle_expectPariaturSuntEveniet() {

        /*******************************************************
         * Perform a GET to /users and extract the user id
         * that corresponds to the user with username 'Karianne'
         *
         * Hint: use extract().path() and a 'find' filter to do this.
         *
         * Store the user id in a variable of type int
         ******************************************************/

		String jsonData1= """ 
				{
				  "users": [
				    {
				      "id": 1,
				      "username": "Bret",
				      "email": "qwe@gmail.com"
				    },
				    {
				      "id": 2,
				      "username": "Antonette",
				      "email": "qaz@gmail.com"
				    },
				    {
				      "id": 3,
				      "username": "Samantha",
				      "email": "zxc@gmail.com"
				    },
				    {
				      "id": 4,
				      "username": "Karianne",
				      "email": "dfg@gmal.com"
				    },
				    {
				      "id": 5,
				      "username": "Kamren",
				      "email": "adg@gmail.com"
				    }
				  ]
				}
         """;
		stubFor(get(urlPathEqualTo("/users/" ))
				.willReturn(aResponse()
						.withStatus(200)
						.withHeader("Content-Type", "application/json")
						.withBody(jsonData1)));

            given().
                spec(requestSpec).
            when().
            then();
     List<Map<String,?>> listMap =
				given()
                .spec(requestSpec)
                .when()
                .get("/users/")
                .then()
                .extract().body().jsonPath().getList("users");
		int userId = (int) listMap.stream().filter( userMap -> userMap.get("username").equals("Karianne")).findFirst().get().get("id");
	    assertEquals(4, userId);
        /*******************************************************
         * Use a JUnit assertEquals to verify that the userId
         * is equal to 4
         ******************************************************/



        /*******************************************************
         * Perform a GET to /albums and extract all albums that
         * are associated with the previously retrieved user id.
         *
         * Hint: use extract().path() and a 'findAll' to do this.
         *
         * Store these in a variable of type List<Integer>.
         ******************************************************/

            given().
                spec(requestSpec).
            when().
            then();

        /*******************************************************
         * Use a JUnit assertEquals to verify that the list has
         * exactly 10 items (hint: use the size() method)
         ******************************************************/



        /*******************************************************
         * Perform a GET to /albums/XYZ/photos, where XYZ is the
         * id of the fifth album in the previously extracted list
         * of album IDs (hint: use get(index) on the list).
         *
         * Deserialize the list of photos returned into a variable
         * of type List<Photo>.
         *
         * Hint: see
         * https://stackoverflow.com/questions/21725093/rest-assured-deserialize-response-json-as-listpojo
         * (the accepted answer should help you solve this one).
         ******************************************************/

            given().
                spec(requestSpec).
            when();

        /*******************************************************
         * Use a JUnit assertEquals to verify that the title of
         * the 32nd photo in the list equals 'pariatur sunt eveniet'
         *
         * Hint: use the get() method to retrieve an object with a
         * specific index from a List
         ******************************************************/


    }
}

