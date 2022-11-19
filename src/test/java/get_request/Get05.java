package get_request;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Get05 extends HerOkuAppBaseUrl {

    /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends get request to the URL
    Then
        Status code is 200
And
   Among the data there should be someone whose firstname is "Adamz" and lastname is "Dear"
 */


    @Test
    public void get5(){

        //set the url

        spec.pathParam("first","booking").
                queryParams("firstname","Adamz","lastname","Dear");

        // set the expected data


        //send the request and get the response

        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //do assertion
        assertEquals(200,response.statusCode());


      //  Among the data there should be someone whose firstname is "Adamz" and lastname is "Dear"
        assertTrue(response.asString().contains("bookingid"));

    }
}
