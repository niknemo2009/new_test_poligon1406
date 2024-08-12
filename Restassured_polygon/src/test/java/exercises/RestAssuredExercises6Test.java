package exercises;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import io.github.nilwurtz.GraphqlBodyMatcher;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@WireMockTest(httpPort = 9876)
public class RestAssuredExercises6Test {

    private RequestSpecification requestSpec;

    @BeforeEach
    public void createRequestSpecification() {

        requestSpec = new RequestSpecBuilder().
                setBaseUri("http://localhost").
                setPort(9876).
                setContentType(ContentType.JSON).
                build();
    }

    /*******************************************************
     * Create a new payload for a GraphQL query using a
     * HashMap and the specified query (with hardcoded ID)
     *
     * POST this object to /graphql
     *
     * Assert that the name of the fruit is equal to "Apple"
     * Use "data.fruit.fruit_name" as the GPath
     * expression to extract the required value from the response
     *
     * Also, assert that the tree name is equal to "Malus"
     * Use "data.fruit.tree_name" as the GPath
     * expression to extract the required value from the response
     ******************************************************/

    @Test
    public void getFruitData_checkFruitAndTreeName_shouldBeAppleAndMalus() {

        String queryString = """                
                query fruit($id: Int) {
                  fruit(id: $id) {
                          id
                          fruit_name
                          tree_name
                          }
                         }                
                  """;
        var expectedVariables = Map.of("id", 1);

        stubFor(WireMock.post(WireMock.urlEqualTo("/graphql/"))
                .andMatching(GraphqlBodyMatcher.extensionName, GraphqlBodyMatcher.parameters(queryString, expectedVariables))
                .willReturn(WireMock.okJson("""
                        {
                            "data": {
                                "fruit": {
                                    "id": 1,
                                    "fruit_name": "Apple",
                                    "tree_name": "Malus"
                                }
                            }
                        }""")));
        given().spec(requestSpec).body(Map.of("query", queryString, "variables", expectedVariables))
                .when().post("/graphql/")
                .then().statusCode(200)
                .body("data.fruit.fruit_name", equalTo("Apple")).body("data.fruit.tree_name", equalTo("Malus"));
    }


    /*******************************************************
     * Transform this Test into a ParameterizedTest, using
     * a CsvSource data source with three test data rows:
     * ---------------------------------
     * fruit id | fruit name | tree name
     * ---------------------------------
     *        1 |      Apple |     Malus
     *        2 |       Pear |     Pyrus
     *        3 |     Banana |      Musa
     *
     * Parameterize the test
     *
     * Create a new GraphQL query from the given query string
     * Pass in the fruit id as a variable value
     *
     * POST this object to /graphql
     *
     * Assert that the HTTP response status code is 200
     *
     * Assert that the name of the fruit is equal to the value in the data source
     * Use "data.fruit.fruit_name" as the GPath
     * expression to extract the required value from the response
     *
     * Also, assert that the tree name is equal to the value in the data source
     * Use "data.fruit.tree_name" as the GPath
     * expression to extract the required value from the response
     ******************************************************/

    @ParameterizedTest
    @CsvSource(value = {"1:Apple:Malus", "2:Pear:Pyrus", "3:Banana:Musa"}, delimiter = ':')
    public void getFruitDataById_checkFruitNameAndTreeName(int id, String fruitName, String treeName) {
        String queryString = """
                query GetFruit($id: Int)
                {
                    fruit(id: $id) {
                        id
                        fruit_name
                        tree_name
                    }
                }
                """;
        var expectedVariables = Map.of("id", id);
        stubFor(WireMock.post(WireMock.urlEqualTo("/graphql/"))
                .andMatching(GraphqlBodyMatcher.extensionName, GraphqlBodyMatcher.parameters(queryString, expectedVariables))
                .willReturn(WireMock.okJson(String.format("""
                                {
                                    "data": {
                                        "fruit": {
                                            "id": %d,
                                            "fruit_name": "%s",
                                            "tree_name": "%s"
                                        }
                                    }
                                }""", id, fruitName
                        , treeName))));

        var asd = given().spec(requestSpec).body(Map.of("query", queryString, "variables", expectedVariables))
                .when().post("/graphql/")
                .then().statusCode(200)
                .body("data.fruit.fruit_name", equalTo(fruitName)).body("data.fruit.tree_name", equalTo(treeName));

    }


}