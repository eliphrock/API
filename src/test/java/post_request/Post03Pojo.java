package post_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;

public class Post03Pojo extends JsonPlaceHolderBaseUrl {

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
                                    }
 */


    @Test
    public void post03(){
        //set the url

        spec.pathParam("first","todos");

        //set the expected data with Pojo Clas

        JsonPlaceHolderPojo expectedData=new JsonPlaceHolderPojo(55,"Tidy your room",false);
        System.out.println("expectedData =" + expectedData);


        //send the request get the response

        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        //do assertion

        JsonPlaceHolderPojo actualData=response.as(JsonPlaceHolderPojo.class); //de serialization
        System.out.println("actualData =" + actualData);

        assertEquals(201,response.statusCode());
        assertEquals(expectedData.getUserId(),actualData.getUserId());
        assertEquals(expectedData.getTitle(),actualData.getTitle());
        assertEquals(expectedData.getCompleted(),actualData.getCompleted());




    }
}
