package exercises;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static io.restassured.RestAssured.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

@WireMockTest(httpPort = 9876)
public class RestAssuredExercises4Test {

    private RequestSpecification requestSpec;
   private  String customerId = "12212";
    @BeforeEach
    public void createRequestSpecification() {
        WireMock.reset();
        requestSpec = new RequestSpecBuilder().
                setBaseUri("http://localhost").
                setPort(9876).
                build();
        String xmlData= """
                <?xml version="1.0" encoding="UTF-8" ?>
                <accounts>
                	<account>
                		<id>12345</id>
                		<type>checking</type>
                		<balance>1234.56</balance>
                	</account>
                	<account>
                		<id>54321</id>
                		<type>checking</type>
                		<balance>98.76</balance>
                	</account>
                	<account>
                		<id>55555</id>
                		<type>checking</type>
                		<balance>43.21</balance>
                	</account>
                	<account>
                		<id>98765</id>
                		<type>savings</type>
                		<balance>10123.00</balance>
                	</account>
                </accounts>
                """;

        givenThat(get(urlPathEqualTo("/xml/customer/"+customerId+""+"/accounts"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/xml")
                        .withBody(xmlData)));
    }

    /*******************************************************
     * Perform a GET request to /xml/customer/12212/accounts
     * to get the list of accounts associated with customer
     * 12212 in XML format
     *
     * Assert that the ID of the first account equals 12345
     * What do you notice about comparing integer element values?
     *
     * Use "accounts.account[0].id" as the XmlPath
     * expression to extract the required value from the response
     ******************************************************/

    @Test
    public void getAccountsForCustomer12212AsXml_checkIdOfFirstAccount_shouldBe12345() {

       given().
            spec(requestSpec).
        when().
       get("/xml/customer/{customerId}/accounts" , customerId)
                .then()
                .assertThat()
                .statusCode(200).contentType("application/xml")
                .and()
               .body("accounts.account[0].id", equalTo("12345"));

    }

    @Test
    public void getAccountsForCustomer12212AsXml_checkIdOfFirstAccount_shouldBe12345_() {

        given().
                spec(requestSpec).
                when().
                get("/xml/customer/{customerId}/accounts" , customerId)
                .then()
                .assertThat()
                .statusCode(200).and().extract().xmlPath().get("accounts.account[0].id").equals("12345");

    }

    /*******************************************************
     * Perform a GET request to /xml/customer/12212/accounts
     * to get the list of accounts associated with customer
     * 12212 in XML format
     *
     * Assert that the balance for the third account in the
     * list is equal to 43.21
     *
     * Can you create the correct XmlPath expression yourself,
     * using the examples as shown in the slides?
     ******************************************************/

    @Test
    public void getAccountsForCustomer12212AsXml_checkBalanceOfThirdAccount_shouldBe4321() {
        given().
                spec(requestSpec).
                when().
                get("/xml/customer/{customerId}/accounts" , customerId)
                .then()
                .assertThat()
                .statusCode(200).contentType("application/xml")
                .and()
                .body("accounts.account[2].balance", equalTo("43.21"));

    }

    /*******************************************************
     * Perform a GET request to /xml/customer/12212/accounts
     * to get the list of accounts associated with customer
     * 12212 in XML format
     *
     * Assert that the list contains 3 accounts of type 'checking'
     *
     * Can you create the correct XmlPath expression yourself,
     * using the examples as shown in the slides?
     ******************************************************/

    @Test
    public void getAccountsForCustomer12212AsXml_checkNumberOfCheckingAccounts_shouldBe3() {
        List list=given().
                spec(requestSpec).
                when().
                get("/xml/customer/{customerId}/accounts" , customerId)
                .then()
                .statusCode(200).contentType("application/xml")
                .extract().xmlPath().get("accounts.account.findAll{it.type=='checking'}");
        assertThat(list.size(),equalTo(3));
    }


    /*******************************************************
     * Perform a GET request to /xml/customer/12212/accounts
     * to get the list of accounts associated with customer
     * 12212 in XML format
     *
     * Assert that the list contains 2 accounts that have an
     * id starting with a '5'
     *
     * Can you create the correct XmlPath expression yourself,
     * using the examples as shown in the slides?
     ******************************************************/

    @Test
    public void getAccountsForCustomer12212AsXml_checkNumberOfAccountIdsStartingWith5_shouldBe2() {

        List list=given().
                spec(requestSpec).
                when().
                get("/xml/customer/{customerId}/accounts" , customerId)
                .then()
                .statusCode(200).contentType("application/xml")
                .extract().xmlPath().get("accounts.account.findAll{it.id.text().startsWith(\"5\")}");
        assertThat(list.size(),equalTo(2));
    }
}