package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlCollectApi {
    protected RequestSpecification specCollect;

    @Before
    public  void setUp(){
        specCollect=new RequestSpecBuilder()
                .setBaseUri("https://api.collectapi.com")
                .build();
    }
}
