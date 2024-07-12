import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class P10_GetResponseBodyListTest {
    /*
    http://dummy.restapiexample.com/api/v1/employees url'ine
        bir GET request yolladigimizda
        donen Response'in
        status code'unun 200,
        ve content type'inin Aplication.JSON,
        ve response body'sindeki
        employees sayisinin 24
        ve employee'lerden birinin "Ashton Cox"
        ve girilen yaslar icinde 61,21 ve 35 degerinin oldugunu test edin.
   */

    @Test
    public void test() {
        String url="http://dummy.restapiexample.com/api/v1/employees";

        Response response=given().when().get(url);

        //response.prettyPrint();

        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("data.id", hasSize(24),
                        "data[2].employee_name",equalTo("Ashton Cox"),
                        "data[2].employee_age",equalTo(66),
                        "data.employee_name",hasItem("Doris Wilder"),
                        "data.employee_age",hasItems(61,21,35));
    }
}
