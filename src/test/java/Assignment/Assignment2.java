package Assignment;

import base_urls.RegrestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.*;

public class Assignment2 extends RegrestBaseUrl {

        /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty

     */

    @Test
    public void assignment2(){

        //set the url

        spec.pathParams("first","users","second",23);


        //send the request the the response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //do assertion

        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
        assertEquals("cloudflare",response.getHeader("Server"));
        assertFalse(response.asString().isEmpty());
    }
}
