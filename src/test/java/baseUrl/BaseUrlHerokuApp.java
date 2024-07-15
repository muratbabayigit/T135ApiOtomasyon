package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlHerokuApp {
    protected RequestSpecification specHerokuApp;

    @Before
    public void setUP(){
    specHerokuApp=new RequestSpecBuilder()
                                        .setBaseUri("https://restful-booker.herokuapp.com")
                                        .build();
    }
}
