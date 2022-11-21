package Assignment;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.AssertJUnit;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Assignment04 extends HerOkuAppBaseUrl {
     /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Brandon&lastname=Wilson
        When
            User sends get request to the URL
        Then
            Status code is 200
        And
            Among the data there should be someone whose firstname is "Brandon" and lastname is "Wilson"

 */

    @Test

    public void assigment04(){

        //set the url
        spec.pathParam("first","booking").
                queryParams("firstname","Brandon","Wilson","");


       // send the response get the request

        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //do assertion

        response.then().assertThat().statusCode(200);
        assertTrue(response.asString().contains("bookingid"));

    }


}
