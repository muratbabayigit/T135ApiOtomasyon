package tests;

import baseUrl.BaseUrlDummyExample;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDatas.DummyTestData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class P21_TestDataDummy extends BaseUrlDummyExample {
  /*
        http://dummy.restapiexample.com/api/v1/employee/3 url’ine
        bir GET request gonderdigimizde
        donen response’un status code’unun 200,
        content Type’inin application/json
        ve body’sinin asagidaki gibi oldugunu test edin.

          Expected Response Body
            {
                "status":"success",
                "data":{
                        "id":3,
                        "employee_name":"Ashton Cox",
                        "employee_salary":86000,
                        "employee_age":66,
                        "profile_image":""
                        },
                "message":"Successfully! Record has been fetched."
            }
         */
    @Test
    public void test(){
        specDummy.pathParams("pp1","employee","pp2","3");
        JSONObject expBody= DummyTestData.responseDataOlustur(3,"Ashton Cox",86000,66,"");
        Response response=given().when().spec(specDummy).get("/{pp1}/{pp2}");

        JsonPath resJP=response.jsonPath();

        assertEquals(DummyTestData.statusCode,response.getStatusCode());
        assertEquals(DummyTestData.contentType,response.getContentType());
        assertEquals(expBody.getString("status"),resJP.getString("status"));
        assertEquals(expBody.getJSONObject("data").getInt("id"),resJP.getInt("data.id"));
        assertEquals(expBody.getJSONObject("data").getString("employee_name"),resJP.getString("data.employee_name"));
        assertEquals(expBody.getJSONObject("data").getInt("employee_salary"),resJP.getInt("data.employee_salary"));
        assertEquals(expBody.getJSONObject("data").getInt("employee_age"),resJP.getInt("data.employee_age"));
        assertEquals(expBody.getJSONObject("data").getString("profile_image"),resJP.getString("data.profile_image"));
        assertEquals(expBody.getString("message"),resJP.getString("message"));
    }





}
