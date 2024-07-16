package tests;

import baseUrl.BaseUrlHerokuApp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Base64;

import static io.restassured.RestAssured.given;

public class P17_baseUrlHeroKuAppQueryParam extends BaseUrlHerokuApp {

     /*

        "https://restful-booker.herokuapp.com"/booking endpointine
        gerekli Query parametrelerini yazarak
            “firstname” degeri “Susan” olan rezervasyon oldugunu
        test edecek bir GET request gonderdigimizde,
        donen response’un
            status code’unun 200 oldugunu
            ve “Susan” ismine sahip 2 booking oldugunu test edin

         */

    @Test
    public void test01(){

        specHerOkuApp.pathParam("pp1","booking").queryParam("firstname","Susan");
     // https://restful-booker.herokuapp.com/booking?firstname=Susan

        Response response=given().when().spec(specHerOkuApp).get("/{pp1}");
        //Query Parametresi olarak eklediklerimizi otomatik algılıyor. Bu nedenle get/Put/Post() içine eklenmez
       // response.prettyPrint();
        response.then().assertThat()
                                  .statusCode(200)
                                  .body("bookingid", Matchers.hasSize(4));
    }

      /*
            https://restful-booker.herokuapp.com/booking endpointine
            gerekli Query parametrelerini yazarak
                “firstname” degeri “Susan”
                ve “lastname” degeri “Ericson” olan
            rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
            donen response’un
                status code’unun 200 oldugunu
                ve “Susan Ericson” ismine sahip en az bir booking oldugunu test edin

               Not: İsim değişiyor kontrol ediniz
         */

    @Test
    public void test02(){
        specHerOkuApp.pathParam("pp1","booking").queryParams("firstname","Sally","lastname","Jones");

        Response response=given().when().spec(specHerOkuApp).get("/{pp1}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).body("bookingid",Matchers.hasSize(3));
    }

}
