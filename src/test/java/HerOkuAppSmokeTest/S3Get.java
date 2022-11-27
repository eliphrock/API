package HerOkuAppSmokeTest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static HerOkuAppSmokeTest.S1Post.bookingid;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static utils.JsonUtils.convertJsonToJavaObject;

public class S3Get extends HerOkuAppBaseUrl {
      /*
     Given
         https://restful-booker.herokuapp.com/booking/:id

     When
            User sends Get request

     Then

           Status code is 200

     And
          Response body is like {
                              "firstname" : "James",
                             "lastname" : "Brown",
                             "totalprice" : 500,
                             "depositpaid" : false,
                             "bookingdates" : {
                                 "checkin" : "2022-11-27",
                                 "checkout" : "2022-11-29"
                             },
                             "additionalneeds" : "Breakfast"
                             }
       */

    @Test
    public void get01(){
        spec.pathParams("first","booking","second",bookingid);

        //set hte expected data

        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2022-11-27","2022-11-29");
        BookingPojo expectedData=new BookingPojo("James","Brown",500,false,bookingDatesPojo,"Breakfast");
        System.out.println("expectedData="+expectedData);

        //send the request and get the response

        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();


    }
}
