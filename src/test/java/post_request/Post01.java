package post_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Post01 extends JsonPlaceHolderBaseUrl {
/*
    Given
           1) https://jsonplaceholder.typicode.com/todos
            2)  {
        "userId": 55,
                "title": "Tidy your room",
                "completed": false
    }
    When
    I send POST Request to the Url
            Then
    Status code is 201
    And
    response body is like {
        "userId": 55,
                "title": "Tidy your room",
                "completed": false,
                "id": 201


 */

    @Test

    public void post01() {

        //set the url

        spec.pathParam("first","todos");

        //set the expected data

        Map<String,Object> expectedData=new HashMap<>();
        expectedData.put("userId",55);
        expectedData.put("title","Tidy your room");
        expectedData.put("completed",false);
        expectedData.put("id",201);

        System.out.println("expectedData =" +expectedData);


        //send the request and get the respond


       Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");

       response.prettyPrint();
    }

}
