package Assignment;

import base_urls.RegrestBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.RegrestTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;

public class Asssignment03 extends RegrestBaseUrl {
        /*
       Given
           https://reqres.in/api/users/2
       When
           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response format should be “application/json”
       And
           “email” is “janet.weaver@reqres.in”,
       And
           “first_name” is "Janet"
       And
           “last_name” is "Weaver"
       And
           "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
    */

    @Test
    public void assignment03(){

        //set the url

        spec.pathParams("first","users","second",2);

        //send the request get the response

        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        RegrestTestData obj=new RegrestTestData();
        Map<String,String> data=obj.regrestDataMap("janet.weaver@reqres.in","Janet","Weaver","https://reqres.in/img/faces/2-image.jpg");
        Map<String,String> support=obj.supportDataMap("https://reqres.in/#support-heading","To keep ReqRes free, contributions towards server costs are appreciated!");
        Map<Object,Object> expectedData=obj.expectedDataMapSetUp(data,support);


        //do assertion

        Map<String,Object> actualData= response.as(HashMap.class);
        System.out.println("actualData =" + actualData);

        response.then().assertThat().statusCode(200).contentType("application/json");
        assertEquals(data.get("email"),((Map)(actualData.get("data"))).get("email"));
        assertEquals(data.get("first_name"),((Map)(actualData.get("data"))).get("first_name"));
        assertEquals(data.get("last_name"),((Map)(actualData.get("data"))).get("last_name"));
        assertEquals(support.get("text"),((Map)(actualData.get("support"))).get("text"));


    }


}
