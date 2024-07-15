package tests;

import baseUrl.BaseUrlHerokuApp;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class P15_baseUrlHerokuApp extends BaseUrlHerokuApp {


           /*
        //1-  https://restful-booker.herokuapp.com/booking endpointine
    //    bir GET request gonderdigimizde
    //    donen response’un
    //          status code’unun 200 oldugunu
    //          ve Response’ta 133 booking oldugunu test edin

     */

        @Test
        public void test(){
            //1-Endpoint hazırlanır
                specHerokuApp.pathParam("pp1","booking");
            //2-expBody yok

            //3-Response kaydedilir

                Response response=given().spec(specHerokuApp).get("{/pp1}");

             //4-Assert işlemleri
                response.then().assertThat().statusCode(200).




        }
}
