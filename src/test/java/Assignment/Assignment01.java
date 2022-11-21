package Assignment;

import base_urls.RegrestBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.RegrestTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Assignment01 extends RegrestBaseUrl {

       /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */


    @Test

    public void assignment02(){

        //set the url

        spec.pathParams("first","users","second",3);


        // set the expected data

        RegrestTestData obj=new RegrestTestData();
        Map<String,String> data=obj.regrestDataMap("emma.wong@reqres.in","Emma","Wong","https://reqres.in/img/faces/3-image.jpg");
        Map<String,String> support=obj.supportDataMap("https://reqres.in/#support-heading","To keep ReqRes free, contributions towards server costs are appreciated!");
        Map<Object,Object> expectedData=obj.expectedDataMapSetUp(data,support);

        System.out.println("expected data =" + expectedData);


        //send the request get the response

        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // do assertion

        Map<Object,Object> actualData= response.as(HashMap.class);
        System.out.println("actualData =" + actualData);

        assertEquals(200,response.statusCode());
        response.then().assertThat().contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");

    }

}
