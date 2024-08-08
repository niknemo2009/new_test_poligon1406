package exercises;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;

@WireMockTest(httpPort = 9876)
public class RestAssuredExercises3Test {

    private RequestSpecification requestSpec;

    @BeforeEach
    public void createRequestSpecification() {

        requestSpec = new RequestSpecBuilder().
                setBaseUri("http://localhost").
                setPort(9876).
                build();
        stubFor(get(urlPathEqualTo("/token/"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""
                                					{
                                  "customer": {
                                    "id": "12212",
                                    "firstName": "John",
                                    "surname": "Doe",
                                    "age": 30,
                                    "accounts": {
                                      "id": [
                                       "12345",
                                       "123455",
                                       "123345"
                                     ]
                                    },
                                    "address": {
                                      "street": "Main Street",
                                      "city": "Beverly Hills",
                                      "zip": "10044"
                                    }
                                  }
                                }		
                                								""")));

    }

    /*******************************************************
     * Perform a GET request to /token and pass in basic
     * authentication details with username 'john' and
     * password 'demo'.
     *
     * Extract the value of the 'token' element in the
     * response into a String variable.
     *
     * Use the token to authenticate using OAuth2 when sending
     * a GET request to /secure/customer/12212
     *
     * Verify that the status code of this response is equal to HTTP 200
     ******************************************************/

    @Test
    public void getTokenUsingBasicAuth_extractFromResponse_thenReuseAsOAuthToken() {

        given().
                spec(requestSpec).
                when().
                then();

        given().
                spec(requestSpec).
                auth().basic("john", "demo").
                when().
                get("/token").
                then();

    }
}