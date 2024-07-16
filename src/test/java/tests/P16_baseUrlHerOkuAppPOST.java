package tests;

import baseUrl.BaseUrlHerokuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class P16_baseUrlHerOkuAppPOST extends BaseUrlHerokuApp {
    /*
    https://restful-booker.herokuapp.com/booking endpointine
    asagidaki body’ye sahip bir POST request gonderdigimizde
    donen response’un status code’unun 200 oldugunu ve
    “firstname” degerinin “Ahmet” oldugunu test edin
    {
    "firstname" : "Ahmet",
    "lastname" : "Bulut",
    "totalprice" : 500,
    "depositpaid" : false,
    "bookingdates" : {
                         "checkin" : "2021-06-01",
                         "checkout" : "2021-06-10"
                      },
    "additionalneeds" : "wi-fi"
    }


     */
        @Test
        public void test01(){
            specHerOkuApp.pathParam("pp1","booking");
            JSONObject reqBody=new JSONObject();
            JSONObject bookingDates=new JSONObject();
            bookingDates.put("checkin" , "2021-06-01");
            bookingDates.put("checkout" , "2021-06-10");

            reqBody.put("firstname" , "Ahmet");
            reqBody.put("lastname" , "Bulut");
            reqBody.put("totalprice" , 500);
            reqBody.put("depositpaid" , false);
            reqBody.put("bookingdates",bookingDates);
            reqBody.put("additionalneeds" , "wi-fi");

            Response response=given().contentType(ContentType.JSON)
                                     .when().spec(specHerOkuApp).body(reqBody.toString()).post("/{pp1}");

            response.then().assertThat().statusCode(200).body("booking.firstname", Matchers.equalTo("Ahmet"));






        }

}
