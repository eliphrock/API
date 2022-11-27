package HerOkuAppSmokeTest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static HerOkuAppSmokeTest.S1Post.bookingid;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static utils.AuthenticationHerOkuApp.generateToken;

public class S4Delete extends HerOkuAppBaseUrl {

    /*
    given

    https://restful-booker.herokuapp.com/booking/:id

    when

     user send delete reqest

    then

    status code is 201

    And

    response body is "Created"
     */

    @Test
    public void delete01() {
        //set the url
        spec.pathParams("first", "booking", "second", bookingid);

        //set the expected data

        String expectedData = "Created";

        //send the request and get the response

        Response response = given().spec(spec).headers("Cookie", "token=" + generateToken()).
                contentType(ContentType.JSON).when().delete("/{first}/{second}");

        response.prettyPrint();

        //do assertion
        assertEquals(201,response.statusCode());
        assertEquals(expectedData,response.asString());
    }
}
