package post_request;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Post02 extends HerOkuAppBaseUrl {


/*
    Given
            1) https://restful-booker.herokuapp.com/booking
            2) {
        "firstname": "John",
                "lastname": "Doe",
                "totalprice": 11111,
                "depositpaid": true,
                "bookingdates": {
            "checkin": "2021-09-09",
                    "checkout": "2021-09-21"
        },
        "additionalneeds": "Breakfast"
    }
    When
    I send POST Request to the Url
            Then
    Status code is 200
    And response body should be like {
        "bookingid": 5315,
                "booking": {
            "firstname": "John",
                    "lastname": "Doe",
                    "totalprice": 11111,
                    "depositpaid": true,
                    "bookingdates": {
                "checkin": "2021-09-09",
                        "checkout": "2021-09-21"
            }
            "additionalneeds": "Breakfast"
        }
    }
*/

    @Test
    public void posto2(){

        //set the url

        spec.pathParam("first","booking");

        // set the expected data ==>Payload

        HerOkuAppTestData obj=new HerOkuAppTestData();
        Map<String,String> bookingdatesMap=obj.bookingdatesMapSetUp("2021-09-09","2021-09-21");

       Map<String,Object> expectedData=obj.expectedDataSetUp("John","Doe",11111,true,bookingdatesMap,"Breakfast");
        System.out.println("expectedData = "+ expectedData);


        // send the request and get the response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        //do assertion

       Map<String,Object> actualData= response.as(HashMap.class);
        System.out.println("actualData =" + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("firstname"),((Map)(actualData.get("booking"))).get("firstname"));
        assertEquals(expectedData.get("lastname"),((Map)(actualData.get("booking"))).get("lastname"));
        assertEquals(expectedData.get("totalprice"),((Map)(actualData.get("booking"))).get("totalprice"));
        assertEquals(expectedData.get("deposited"),((Map)(actualData.get("booking"))).get("deposited"));
        assertEquals(bookingdatesMap.get("checkin"),((Map)(((Map)(actualData.get("booking"))).get("bookingdates"))).get("checkin"));
        assertEquals(bookingdatesMap.get("checkout"),((Map)(((Map)(actualData.get("booking"))).get("bookingdates"))).get("checkout"));



    }
}
