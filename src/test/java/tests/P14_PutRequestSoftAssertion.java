package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class P14_PutRequestSoftAssertion {
 /*
    https://dummy.restapiexample.com/api/v1/update/21 url’ine
    asagidaki body’ye sahip bir PUT request gonderdigimizde donen response’un
    asagidaki gibi oldugunu test edin.

    Request Body                        Response Body
 {                                  {
    "status": "success",                 "status": "success",
    "data": {                            "data": {
        "name": “Ahmet",                            "name": “Ahmet",
        "salary": "1230",                           "salary": "1230",
        "age": "44",                                "age": "44",
        "id": 40                                    "id": 40
    }                                             }
}                                       "message": "Successfully! Record has been updated."}


 */

    @Test
    public void test(){
        String url="https://dummy.restapiexample.com/api/v1/update/21";
        JSONObject reqBody=new JSONObject();
        reqBody.put("status","success");
        JSONObject datas=new JSONObject();
        datas.put("name","Ahmet");
        datas.put("salary","1230");
        datas.put("age","44");
        datas.put("id",40);
        reqBody.put("data",datas);


        JSONObject expData=new JSONObject();
        expData.put("status","success");
        expData.put("data",datas);
        expData.put("message", "Successfully! Record has been updated.");


        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).put(url);

        JsonPath resJP=response.jsonPath();
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(resJP.get("status"),expData.get("status"));
        softAssert.assertEquals(resJP.get("data.name"),expData.getJSONObject("data").get("name"));
        softAssert.assertEquals(resJP.get("data.salary"),expData.getJSONObject("data").get("salary"));
        softAssert.assertEquals(resJP.get("data.age"),expData.getJSONObject("data").get("age"));
        softAssert.assertEquals(resJP.get("data.id"),expData.getJSONObject("data").get("id"));
        softAssert.assertEquals(resJP.get("message"),expData.get("message"));

         softAssert.assertAll();


    }
}
