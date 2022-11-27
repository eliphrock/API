package delete_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utils.AuthenticationHerOkuApp;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Delete02 extends HerOkuAppBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking/{bookingId}
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is "Created"
     */

    @Test
    public void delete02(){

        //set the url
        spec.pathParams("first","booking","second",862);

        //set the expected data

        String expectedData="Created";

        //send the request and get the response

        Response response=given().spec(spec).headers("Cookie","token="+ AuthenticationHerOkuApp.generateToken()).
                contentType(ContentType.JSON).when().delete("/{first}/{second}");
        response.prettyPrint();

        // do assertion
        assertEquals(201,response.statusCode());
        assertEquals(expectedData,response.asString());


    }
}
