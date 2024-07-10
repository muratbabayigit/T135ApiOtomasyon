import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class P07_GETBodyTekrarlariniKaldirma {
    /*
    https://restful-booker.herokuapp.com/booking/11 url’ine
    bir GET request gonderdigimizde donen Response’un,
            status code’unun 200,
            ve content type’inin application/json,
            ve response body’sindeki
            “firstname”in, “John”,
            ve “lastname”in, “Smith”,
            ve “totalprice”in, 111,
            ve “depositpaid”in, true,
	        ve “additionalneeds”in, “Extra pillows please” oldugunu test edin
	        NOT: Veriler değişiyor Postman'de dataları kontrol ediniz
     */

    @Test
    public void test() {

        String url="https://restful-booker.herokuapp.com/booking/11";

        Response response=given().when().get(url);

        response.prettyPrint();

        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("firstname", equalTo("John"),
                        "lastname",equalTo("Smith"),
                                 "totalprice",equalTo(111),
                                 "depositpaid",equalTo(true),
                                 "additionalneeds",equalTo("Breakfast"));



    }

}
