package get_request;

import base_urls.GoRestBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.assertTrue;

public class Get11 extends GoRestBaseUrl {

/*
        Given
            https://gorest.co.in/public/v1/users
        When
            User send GET Request
        Then
            The value of "pagination limit" is 10
        And
            The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
        And
            The number of users should  be 10
        And
            We have at least one "active" status
        And
            "Msgr. Achintya Varrier", "Anaadi Menon", "Adheesh Tandon" are among the users
        And
            The female users are less than or equal to male users
     */

    @Test
    public void get11(){

        //set the url
        spec.pathParam("first","users");

        //set the expected data

        //send the request and get the response
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //do assertion

        response.then().assertThat().statusCode(200).
                body("meta.pagination.limit",equalTo(10),
        "meta.pagination.links.current",equalTo("https://gorest.co.in/public/v1/users?page=1"),
        "data.name",hasSize(10),
                        "data.status",hasItem("active"),"data.name",hasItems("Pres. Soma Adiga", "Ms. Anjushree Shah", "The Hon. Triloki Nath Verma"));

       //the female users are less than or equal to male users
        //I will compare number of female and male users
        //1st way: I will get all genders in a list then calculate the number of female then compare it with the list

        JsonPath jsonpath= response.jsonPath();
        List<String> genders=jsonpath.getList("data.gender");
        System.out.println("genders =" + genders);

        int numOfFemales=0;
        for(String w:genders){
            if(w.equals("female")){
                numOfFemales++;
            }
        }

        System.out.println("numOfFemales ="+ numOfFemales);

        int numOfMales=genders.size()-numOfFemales;
        assertTrue(numOfFemales<=numOfMales);


        //2nd way: I will get all females by using Groavy language then compare it with males

       List<String> femaleList=jsonpath.getList("data.findAll{it.gender=='female'}.gender");
        System.out.println("femaleList ="+ femaleList);


        List<String> maleList=jsonpath.getList("data.findAll{it.gender=='male'}.gender");
        System.out.println("maleList ="+ maleList);

        assertTrue(femaleList.size()<=maleList.size());
    }
}
