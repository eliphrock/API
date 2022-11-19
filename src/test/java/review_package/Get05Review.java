package review_package;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get05Review extends HerOkuAppBaseUrl {

        /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends get request to the URL
    Then
        Status code is 200
And
   Among the data there should be someone whose firstname is "James" and lastname is "Brown"
 */

    @Test

    public void get05review(){

        //set the url

        spec.pathParam("first","booking").
        queryParams("firstname","James","lastname","Brown");


        //set the expected data

        //send the request get the response

        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();


        //do assertion

        response.then().assertThat().statusCode(200);


        //2nd way

        assertEquals(200,response.statusCode());

        //  Among the data there should be someone whose firstname is "James" and lastname is "Brown"
        assertTrue(response.asString().contains("bookingid"));





    }
}
