package exercises;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@WireMockTest(httpPort = 9876)
public class RestAssuredExercises2Test {

    private RequestSpecification requestSpec;

    @BeforeEach
    public  void createRequestSpecification() {
        requestSpec = new RequestSpecBuilder().
                setBaseUri("http://localhost").
                setPort(9876).
                build();
    }


    /*******************************************************
     * Transform these tests into a single ParameterizedTest,
     * using a CsvSource data source with three test data rows:
     * ------------------------------------
     * customer ID | first name | last name
     * ------------------------------------
     * 12212       | John       | Smith
     * 12323       | Susan      | Holmes
     * 14545       | Anna       | Grant
     *
     * Request user data for the given user IDs by sending
     * an HTTP GET to /customer/<customerID>.
     *
     * Use the test data collection created
     * above. Check that both the first name and the last name
     * for each of the customer IDs matches the expected values
     * listed in the table above
     *
     * Use the GPath expressions "firstName" and "lastName",
     * respectively, to extract the required response body elements
     ******************************************************/

    @ParameterizedTest
    @CsvSource(value = {"12212:John:Smith", "12323:Susan:Holmes", "14545:Anna:Grant"}, delimiter = ':')
    public void requestDataForCustomer12212_checkNames_expectJohnSmith(String id,String firstName,String lastName) {
        WireMock.reset();
		String body=String.format("""
													{
								  "customer": {
								    "id": "%s",
								    "firstName": "%s",
								    "lastName": "%s",
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
																""",id,firstName,lastName);
        stubFor(get(urlPathEqualTo("/customer/" + id))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(body)));
        given().
            spec(requestSpec).
        when().
            get("/customer/"+id).
        then().
            assertThat().
            body("customer.id", equalTo(id)).
            body("customer.firstName", equalTo(firstName)).
            body("customer.lastName", equalTo(lastName));
    }
}