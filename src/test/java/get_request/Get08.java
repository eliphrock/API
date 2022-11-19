package get_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get08 extends JsonPlaceHolderBaseUrl {

    /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
     */
    @Test
    public void get08(){
        //set the url
        spec.pathParams("first","todos","second",2);

        //set the expected data

        JsonPlaceHolderTestData obj=new JsonPlaceHolderTestData();
        Map<String,Object> expectedData=obj.expectedDataJPH(1,"quis ut nam facilis et officia qui",false);
        System.out.println("expectedData=" + expectedData);


        //send the request get the response
        Response response= given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //do assertion

        Map<String,Object> actualData=response.as(HashMap.class);

        System.out.println("actualData =" +actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("userId"),actualData.get("userId"));

        assertEquals("1.1 vegur",response.getHeader("via"));

        assertEquals("cloudflare",response.getHeader("Server"));
    }
}
