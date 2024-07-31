package rest_assured;

import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import static com.github.fge.jsonschema.SchemaVersion.DRAFTV4;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class HelloWorldRestAssured {

    @Test
    public void makeSureThatGoogleIsUp() throws IOException, InterruptedException {

        given().log().all().when().get("http://www.google.com").then().statusCode(200);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://booking-com15.p.rapidapi.com/api/v1/hotels/searchHotelsByCoordinates?latitude=19.24232736426361&longitude=72.85841985686734&adults=1&children_age=0%2C17&room_qty=1&units=metric&page_number=1&temperature_unit=c&languagecode=en-us&currency_code=EUR"))
                .header("x-rapidapi-key", "13191e1b0bmsh4366ba770a416c7p1bd732jsn6ce87b51a470")
                .header("x-rapidapi-host", "booking-com15.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        // given().when().get("/price").then().body("price", is(12.12f));
      //  int lottoId = from("").getInt("lotto.lottoId");
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder().setValidationConfiguration(ValidationConfiguration.newBuilder().setDefaultVersion(DRAFTV4).freeze()).freeze();
        Map<String,String>  map=Map.of("x-rapidapi-key","13191e1b0bmsh4366ba770a416c7p1bd732jsn6ce87b51a470","x-rapidapi-host", "booking-com15.p.rapidapi.com");
//       given().headers(map).when().get(URI.create("https://booking-com15.p.rapidapi.com/api/v1/hotels/searchHotelsByCoordinates?latitude=19.24232736426361&longitude=72.85841985686734&adults=1&children_age=0%2C17&room_qty=1&units=metric&page_number=1&temperature_unit=c&languagecode=en-us&currency_code=EUR")).
//               then().body("status", equalTo(false)).body("message[0].arrival_date",equalTo("Invalid value")).
//               assertThat().body(matchesJsonSchemaInClasspath("my-schema.json").using(jsonSchemaFactory));;
      var response1=  given().when().get(URI.create("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json")).then().assertThat().body(matchesJsonSchemaInClasspath("my-schema.json").using(jsonSchemaFactory));
       // System.out.println(response1.asString());
    }

}