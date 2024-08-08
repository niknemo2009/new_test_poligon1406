package exercises;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
//import dataentities.Account;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@WireMockTest(httpPort = 9876)
public class RestAssuredExercises5Test {
    String jsonData= """
                {
                      "id": "3567",
                      "type": "savings",
                      "balance": 1073.00
                    }
                """;
    String customerId = "12212";
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

    /*******************************************************
     * Create a new Account object with 'savings' as the account
     * type
     *
     * POST this object to /customer/12212/accounts
     *
     * Verify that the response HTTP status code is equal to 201
     ******************************************************/

    @Test
    public void postAccountObject_checkResponseHttpStatusCode_expect201() {
        stubFor(post(urlPathEqualTo("/customer/" + customerId+"/accounts"))
                .withRequestBody(matchingJsonPath("$.id").and(matchingJsonPath("$.type").and(matchingJsonPath("$.balance"))))
                .willReturn(aResponse()
                        .withStatus(201)));

        given().
                spec(requestSpec).
                body(jsonData).
                when().
                post("/customer/{customerId}/accounts", customerId)
                .then()
                .assertThat()
                .statusCode(201);

    }

    /*******************************************************
     * Perform an HTTP GET to /customer/12212/accounts and
     * deserialize the response into an object of type
     * AccountResponse
     *
     * Using a JUnit assertEquals() method, verify that the
     * number of account in the response (in other words,
     * the size() of the accounts property) is equal to 3
     ******************************************************/

    @Test
    public void getAccountsForCustomer12212_deserializeIntoList_checkListSize_shouldEqual3() {
        stubFor(get(urlPathEqualTo("/customer/" + customerId+"/accounts"))
                        .willReturn(okJson("""
                                {
                                  "accounts": [
                                    {
                                      "id": "12345",
                                      "type": "checking",
                                      "balance": 1234.56
                                    },
                                    {
                                      "id": "54321",
                                      "type": "checking",
                                      "balance": 98.76
                                    },
                                    {
                                      "id": "55555",
                                      "type": "checking",
                                      "balance": 43.21
                                    }
                                  ]
                                }
                                """)));
       List<AccountResponse> list= given().
                spec(requestSpec).
                when().
                get("/customer/{customerId}/accounts", customerId)
                .then()
                .assertThat()
                .statusCode(200)
                .body("accounts.size()", equalTo(3)).extract()
                .jsonPath().getList("accounts", AccountResponse.class);
        assertEquals(list.get(0), new AccountResponse("12345", "checking", 1234.56));




    }

    /*******************************************************
     * Create a new Customer object by using the constructor
     * that takes a first name and last name as its parameters
     *
     * Use a first name and a last name of your own choosing
     *
     * POST this object to /customer
     *
     * Deserialize the response into another object of type
     * Customer and use JUnit assertEquals() assertions to
     * check that the first name and last name returned by
     * the API are the same as those you passed into the
     * constructor of the Customer method you POSTed
     ******************************************************/

    @Test
    public void postCustomerObject_checkReturnedFirstAndLastName_expectSuppliedValues() {
        stubFor(post(urlPathEqualTo("/customer/"))
                .withRequestBody(matchingJsonPath("$.firstName").and(matchingJsonPath("$.lastName")))
                .willReturn(aResponse()
                        .withStatus(200)));
        stubFor(get(urlPathEqualTo("/customer/121212"))
                .willReturn(okJson("""
                                {
                                  "id": "121212",
                                  "firstName": "John",
                                  "lastName": "Doe",
                                 "email": "qwe@qwe.com",
                                    "phone": "123456789"
                                }
                                """)));

        given().spec(requestSpec).
                body(new Customer("John", "Doe")).log().all().
                when().
                post("/customer/").
                then().assertThat().statusCode(200);

        Customer customer= given().spec(requestSpec).
                when().get("/customer/121212").then().extract().as(Customer.class);
        assertTrue(customer.equals(new Customer("121212", "John", "Doe", "qwe@qwe.com","123456789")));
    }
}