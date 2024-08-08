package exercises;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.*;

@WireMockTest(httpPort = 9876)
public class RestAssuredExercises1Test {
    private final String customerId = "12212";
    private RequestSpecification requestSpec;

    @BeforeEach
    public void createRequestSpecification() {
        WireMock.reset();
        requestSpec = new RequestSpecBuilder().
                setBaseUri("http://localhost").
                setPort(9876).
                build();
        String customerId = "12212";
        stubFor(get(urlPathEqualTo("/customer/" + customerId))
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
     * Send a GET request to /customer/12212
     * and check that the response has HTTP status code 200
     ******************************************************/

    @Test
    public void requestDataForCustomer12212_checkResponseCode_expect200() {
        given()
                .spec(requestSpec)
                .when()
                .get("customer/{Id}", customerId)
                .then()
                .statusCode(200);

    }

    /*******************************************************
     * Send a GET request to /customer/99999
     * and check that the answer has HTTP status code 404
     ******************************************************/

    @Test
    public void requestDataForCustomer99999_checkResponseCode_expect404() {
        String notExistCustomerId = "99999";
        given()
                .spec(requestSpec)
                .when()
                .get("customer/{id}", notExistCustomerId)
                .then()
                .statusCode(404);
    }

    /*******************************************************
     * Send a GET request to /customer/12212
     * and check that the response is in JSON format
     ******************************************************/

    @Test
    public void requestDataForCustomer12212_checkContentType_expectApplicationJson() {

        given()
                .spec(requestSpec)
                .when()
                .get("customer/{id}", customerId)
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("customer.id", equalTo(customerId));
    }

    /***********************************************
     * Send a GET request to /customer/12212 and check
     * that the first name of the person associated with
     * this customer ID is 'John'.
     *
     * Use the GPath expression "firstName" to
     * extract the required response body element
     **********************************************/

    @Test
    public void requestDataForCustomer12212_checkFirstName_expectJohn() {
        given()
                .spec(requestSpec)
                .when()
                .get("customer/{id}", customerId)
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("customer.id", equalTo(customerId))
                .body("customer.firstName", equalTo("John"));
    }

    /***********************************************
     * Send a GET request to /customer/12212 and check
     * that the city where the person associated with
     * this customer ID is living is 'Beverly Hills'.
     *
     * Use the GPath expression "address.city" to
     * extract the required response body element
     **********************************************/

    @Test
    public void requestDataForCustomer12212_checkAddressCity_expectBeverlyHills() {
        given()
                .spec(requestSpec)
                .when()
                .get("customer/{id}", customerId)
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("customer.id", equalTo(customerId))
                .body("customer.address.city", equalTo("Beverly Hills"));

    }

    /***********************************************
     * Send a GET request to /customer/12212/accounts
     * and check that the list of accounts returned
     * includes an account with ID 12345
     *
     * Use the GPath expression "accounts.id" to
     * extract the required response body elements
     **********************************************/

    @Test
    public void requestAccountsForCustomer12212_checkListOfAccountsIDs_expectContains12345() {

        given()
                .spec(requestSpec)
                .when()
                .get("customer/{id}", customerId)
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("customer.id", equalTo(customerId))
                .body("customer.accounts.id", hasItem("12345"));
    }

    /***********************************************
     * Send a GET request to /customer/12212/accounts
     * and check that the list of accounts returned
     * does not include an account with ID 99999
     *
     * Use the GPath expression "accounts.id" to
     * extract the required response body elements
     **********************************************/

    @Test
    public void requestAccountsForCustomer12212_checkListOfAccountsIDs_expectDoesNotContain99999() {
        given()
                .spec(requestSpec)
                .when()
                .get("customer/{id}", customerId)
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("customer.id", equalTo(customerId))
                .body("customer.accounts.id", not(hasItem("99999")));
    }

    /***********************************************
     * Send a GET request to /customer/12212/accounts
     * and check that the list of account IDs returned
     * is a collection of size 3
     *
     * Use the GPath expression "accounts.id" to
     * extract the required response body elements
     **********************************************/

    @Test
    public void requestAccountsForCustomer12212_checkListOfAccountsIDs_expectSize3() {
        given()
                .spec(requestSpec)
                .when()
                .get("customer/{id}", customerId)
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("customer.id", equalTo(customerId))
                .body("customer.accounts.id", hasSize(3));
    }
}