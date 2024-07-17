package tests;

import baseUrl.BaseUrlCollectApi;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class P23_CollectApiHavaDurumu extends BaseUrlCollectApi {
    //'https://api.collectapi.com/weather/getWeather?data.lang=tr&data.city=ankara'
    @Test
    public void test01(){
        String url="https://api.collectapi.com/weather/getWeather?data.lang=tr&data.city=üsküdar";
        Response response=given().when().header("content-type", "application/json")
                                        .header("authorization", "apikey 4p2V1MLa2aQfE9Uz7RLoNx:6butCjfNsQa4kJOnXD2RF6")
                                        .get(url);

        response.prettyPrint();

    }


}
