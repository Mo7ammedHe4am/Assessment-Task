package restassured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testdata.CatFactsDataReader;
import testdata.JsonDataReader;
import java.io.IOException;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CatFactsApi {

    private RequestSpecification requestSpecification;

    CatFactsDataReader catFactsDataReader = new CatFactsDataReader();

    JsonDataReader Reader = new JsonDataReader();

    private Response response;


    @BeforeTest
    public void setUp() throws IOException, ParseException {
        catFactsDataReader.readJsonData();
        Reader.jsonReader();
        System.out.println(catFactsDataReader.url);
        response = given().baseUri(catFactsDataReader.url).contentType(ContentType.JSON)
                .when().get(catFactsDataReader.endpoint);
        requestSpecification = given().baseUri(catFactsDataReader.url).contentType(ContentType.JSON);
    }


    @Test
    public void validateThatResponseHaveBody() {
        response.then().assertThat().body(not(empty()));
    }

    @Test
    public void validateCatInfoContainsCatsWord() {
        response.then().assertThat().body("data[0].fact", containsString("cats"));
    }

    @Test
    public void validateThatFirstItemHasLength() {
        response.then().assertThat().body("data.length", hasItem(114));
    }

    @Test
    public void validateThatResponseCodeIs200() {
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void validateThatResponseCodeIs404WhenMethodIsPost() {
        requestSpecification.body(Reader).post(Reader.toString())
                .then().assertThat().statusCode(404);
    }


}
