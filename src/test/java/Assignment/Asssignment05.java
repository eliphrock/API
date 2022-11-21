package Assignment;

import base_urls.RegrestBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import test_data.RegresTestData01;
import test_data.RegrestTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

public class Asssignment05 extends RegrestBaseUrl {
       /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
      */


    @Test
    public void assignment05(){
        //set the url

        spec.pathParams("first","unknown","second",3);

        //set the expected data

        RegresTestData01 obj=new RegresTestData01();
        Map<String,Object> data=obj.regrestDataMap("true red",2002,"#BF1932","19-1664");
        Map<String,String> support=obj.supportDataMap("https://reqres.in/#support-heading","To keep ReqRes free, contributions towards server costs are appreciated!");
        Map<Object,Object> expectedData=obj.expectedDataMapSetUp(data,support);

        System.out.println("expected data =" + expectedData);

        //send the request get the response

        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();


        //do assertion

        JsonPath jsonPath=response.jsonPath();
        //hard assertion
        Assert.assertEquals("true red",jsonPath.getString("data.name"));
        Assert.assertEquals(2002,jsonPath.getInt("data.year"));
        Assert.assertEquals("#BF1932",jsonPath.getString("data.color"));
        Assert.assertEquals("19-1664",jsonPath.getString("data.pantone_value"));
        Assert.assertEquals("https://reqres.in/#support-heading",jsonPath.getString("support.url"));
        Assert.assertEquals("To keep ReqRes free, contributions towards server costs are appreciated!",jsonPath.getString("support.text"));

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(jsonPath.getString("data.name"),"true red");
        softAssert.assertEquals(jsonPath.getInt("data.year"),2002);
        softAssert.assertEquals(jsonPath.getString("data.color"),"#BF1932");
        softAssert.assertEquals(jsonPath.getString("data.pantone_value"),"19-1664");
        softAssert.assertEquals(jsonPath.getString("support.url"),"https://reqres.in/#support-heading");
        softAssert.assertEquals(jsonPath.getString("support.text"),"To keep ReqRes free, contributions towards server costs are appreciated!");

        softAssert.assertAll();




    }
}
