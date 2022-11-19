package get_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Get07 extends JsonPlaceHolderBaseUrl {

    /*
        Given
	   	    https://jsonplaceholder.typicode.com/todos
		When
			 I send GET Request to the URL
		Then
			 1)Status code is 200
			 2)Print all ids greater than 190 on the console
			   Assert that there are 10 ids greater than 190
			 3)Print all userIds whose ids are less than 5 on the console
			   Assert that the number of userIds whose ids are less than 5 is 4
			 4)Print all titles whose ids are less than 5
			   Assert that "delectus aut autem" is one of the titles whose id is less than 5
     */

    @Test

    public void get07() {
        //set the url

        spec.pathParam("first", "todos");

        // set the expexted data

        //send the request and get the response

        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //Do Assertion
        //1)Status code is 200
        assertEquals(200, response.statusCode());

        //2)Print all ids greater than 190 on the console
        //			   Assert that there are 10 ids greater than 190


        JsonPath jsonPath = response.jsonPath();
        List<Integer> ids = jsonPath.getList("id");
        System.out.println("ids =" + ids);

        List<Integer> idsGreaterThan190 = new ArrayList<>();
        for (int w : ids) {
            if (w > 190) {
                idsGreaterThan190.add(w);
            }

        }
        System.out.println("idsGreaterThan190 =" + idsGreaterThan190);

        assertEquals(10, idsGreaterThan190.size());


        //2.d way

        List<Integer> idsGreaterThan190Groavy = jsonPath.getList("findAll{it.id>190}.id");  //Groavy language // it is like lambda expression(t)
        System.out.println("idsGreaterThan190Groavy =" + idsGreaterThan190Groavy);

        assertEquals(10, idsGreaterThan190Groavy.size());


        // 3)Print all userIds whose ids are less than 5 on the console
        // Assert that the number of userIds whose ids are less than 5 is 4

        List<Integer> userIdLessThanFive = jsonPath.getList("findAll{it.id<5}.userId");  //Groavy language // it is like lambda expression(t)
        System.out.println("userIdLessThanFive=" + userIdLessThanFive);

        assertEquals(4, userIdLessThanFive.size());


        //4)Print all titles whose ids are less than 5
        // Assert that "delectus aut autem" is one of the titles whose id is less than 5

        List<String> titles = jsonPath.getList("findAll{it.id<5}.title");  //Groavy language // it is like lambda expression(t)
        System.out.println("titles" + titles);

        assertTrue(titles.contains("delectus aut autem"));


        //2nd way
        assertTrue("'delectus aut autem'does not exist",titles.stream().anyMatch(t-> t.equals("delectus aut autem")));
    }
}

