package tests;

import baseUrl.BaseUrlHerokuApp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
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
        public void test01(){
                //1-Endpoint hazırlanır
                specHerOkuApp.pathParam("pp1","booking");

                //2-Verilmişse expData hazırlanır.

                //3-Dönen Response kaydedilir
                Response response=given().when().spec(specHerOkuApp).get("/{pp1}");

                //.....Kontrol işlemi
                response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasItem(133));





        }
}
