package delete_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.registerParser;
import static org.hamcrest.Matchers.hasSize;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Delete01 extends JsonPlaceHolderBaseUrl {

    /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is { }
     */

    @Test
    public void delete01(){
        //set the url

        spec.pathParams("first","todos","second",198);

        //set the expected data

        Map<String,Object> expectedData=new HashMap<>();
        System.out.println("expectedData="+expectedData);

        //send the request and get the response
        Response response=given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();

        //do assertion

       Map<String,Object> actualData=response.as(HashMap.class);
        System.out.println("actualData="+actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData,actualData);

        //or
        assertEquals(expectedData.size(),actualData.size());
        //or
        assertTrue(actualData.isEmpty());
        //or
        response.then().assertThat().body("isEmpty()", Matchers.is(true));

        //how to automate " Delete" request in API testing
        //1) create a new data by using "post request"
        //2)use "delete request" to delete new data.

        //Note: do not delete existing data, create a data to delete


    }
}
