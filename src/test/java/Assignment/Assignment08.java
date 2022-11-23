package Assignment;

import base_urls.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.SwaggerTestData;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertTrue;

public class Assignment08 extends PetStoreBaseUrl {
    //Homework8:

   /*
    Type automation code to create a 'user' by using "https://petstore.swagger.io/"" documantation.
    */



   //

    @Test
            public void as08(){

        String url = "https://petstore.swagger.io/v2/user/elif";

        spec.pathParams("first","user","second","elif");

        SwaggerTestData obj=new SwaggerTestData();
        Map<String,Object> expectedData=obj.expectedDataSetUp("elif","elif kaya","atsiz","elifkaya@gmail.com","string","string",1);
        System.out.println("expectedData =" + expectedData);




        Response response1=given().contentType(ContentType.JSON).body(expectedData).when().post("/{first}/{second}");
        response1.prettyPrint();


    }
/*
   "id": 1234567,
    "username": "elif",
    "firstName": "elif kaya",
    "lastName": "atsiz",
    "email": "elifkaya@gmail.com",
    "password": "string",
    "phone": "string",
    "userStatus": 1
 */

}




