package post_request;

import base_urls.JsonPlaceHolderBaseUrl;
import org.junit.Test;

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


    }
}
