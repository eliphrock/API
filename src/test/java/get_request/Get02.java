package get_request;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class Get02 {
/*
   Given
       https://restful-booker.herokuapp.com/booking/1
   When
       User send a GET Request to the url
   Then
       HTTP Status code should be 404    (Negative Tes=> we are not expecting getting data)
   And
       Status Line should be HTTP/1.1 404 Not Found
   And
       Response body contains "Not Found"
   And
       Response body does not contain "TechProEd"
   And
       Server is "Cowboy"
*/

    @Test
    public void get02() {

        //Set the URL
        String url = "https://restful-booker.herokuapp.com/booking/0";

        //Set the expected data

        //Send the request and get the response
        Response response = given().when().get(url);
        response.prettyPrint();

        //Do Assertion
        response.then().
                assertThat().
                statusCode(404).
                statusLine("HTTP/1.1 404 Not Found");

        //How to assert if response body contains any data
        //response body contains "Not Found"
        //assertTrue(x) method passes if x is true
        assertTrue(response.asString().contains("Not Found")); //true==> response body contains "Not Found"
        //assertTrue() coming from "junit library"

        //response body does not contain "TechProEd"
        //assertFalse(x) method passes if x is false
        assertFalse(response.asString().contains("TechProEd"));


        //server is "Cowboy"
        //assertEquals(x,y) passes if x and y are equals
        assertEquals("Cowboy", response.getHeader("Server"));

    }


}

