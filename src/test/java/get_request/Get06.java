package get_request;
import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get06 extends HerOkuAppBaseUrl {


/*
   Given
       https://restful-booker.herokuapp.com/booking/2
   When
       User send a GET request to the URL
   Then
       HTTP Status Code should be 200
   And
       Response content type is "application/json"
   And
       Response body should be like;
     {
    "firstname": "Mark",
    "lastname": "Jackson",
    "totalprice": 554,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2017-09-11",
        "checkout": "2021-03-14"
    },
    "additionalneeds": "Breakfast"
   }
*/

    @Test
    public void get06(){

        //set the url
        spec.pathParams("first","booking","second",2);

        //set the expected data



        //send the request and get the response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //do assertion

        response.then().
                assertThat().statusCode(200).
                contentType(ContentType.JSON).
                body("firstname",equalTo("Mark"),
                        "lastname",equalTo("Jackson"),
                        "totalprice",equalTo(554),
                        "depositpaid",equalTo(false),
                        "bookingdates.checkin",equalTo("2017-09-11"),
                        "bookingdates.checkout",equalTo("2021-03-14"),
                        "additionalneeds",equalTo("Breakfast"));




        //2nd way:we will use JsonPath Class

        JsonPath jsonPath=response.jsonPath();
        //hard assertion
        assertEquals("Mark",jsonPath.getString("firstname"));
        assertEquals("Jackson",jsonPath.getString("lastname"));
        assertEquals(554,jsonPath.getInt("totalprice"));
        assertEquals(false,jsonPath.getBoolean("depositpaid"));
        assertEquals("2017-09-11",jsonPath.getString("bookingdates.checkin"));
        assertEquals("2021-03-14",jsonPath.getString("bookingdates.checkout"));
        assertEquals("Breakfast",jsonPath.getString("additionalneeds"));


    //do soft assertion
    //1: create soft assertion object

    SoftAssert softAssert=new SoftAssert();


    //2:do  assertion
    softAssert.assertEquals(jsonPath.getString("firstname"),"Mark","firstname did not match !");
    softAssert.assertEquals(jsonPath.getString("lastname"),"Jackson","lastname did not match !");
    softAssert.assertEquals(jsonPath.getInt("totalprice"),554,"totalprice did not match !");
    softAssert.assertEquals(jsonPath.getBoolean("depositpaid"),false,"depositpaid did not match !");
    softAssert.assertEquals(jsonPath.getString("bookingdates.checkin"),"2017-09-11","checkin did not match !");
    softAssert.assertEquals(jsonPath.getString("bookingdates.checkout"),"2021-03-14","checkout did not match !");
    softAssert.assertEquals(jsonPath.getString("additionalneeds"),"Breakfast","additionalneeds did not match !");






    //3:use assertAll() method.(otherwise soft assertion will pass in every scenario)
        softAssert.assertAll();




    }
}
