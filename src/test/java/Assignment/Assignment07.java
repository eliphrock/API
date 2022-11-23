package Assignment;

import base_urls.RegrestBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import pojos.RegresPojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Assignment07 extends RegrestBaseUrl {

      /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": ""page": 1,
    "per_page": 6,
    "total": 12,
    "total_pages": 2,"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */

    @Test
    public void assignment07(){

  //set the url
        spec.pathParam("first","users");


        // set the expected data

        RegresPojo expectedData=new RegresPojo("morpheus","leader");
        System.out.println("expectedData =" + expectedData);

        //send the request get the response

        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        //do assertion

        RegresPojo actualData=response.as(RegresPojo.class); //de serialization
        System.out.println("actualData =" + actualData);

        assertEquals(201,response.statusCode());
        assertEquals(expectedData.getName(),actualData.getName());
        assertEquals(expectedData.getJob(),actualData.getJob());


    }

}
