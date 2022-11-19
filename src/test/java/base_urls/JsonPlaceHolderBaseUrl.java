package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {
    protected RequestSpecification spec;
    @Before// if you use @before annotation at the top of a method,it will be executed before every test method
    public void setUp(){
        spec= new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();

    }
}
