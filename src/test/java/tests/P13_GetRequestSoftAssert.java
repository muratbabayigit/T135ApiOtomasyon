package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class P13_GetRequestSoftAssert {

         /*
   http://dummy.restapiexample.com/api/v1/employee/3 url'ine
   bir GET request gonderdigimizde donen response'un asagidaki gibi oldugunu test edin.

        Response Body
       {
           "status":"success",
           "data":{
                     "id": 12,
                     "employee_name": "Quinn Flynn",
                     "employee_salary": 342000,
                     "employee_age": 22,
                     "profile_image": ""
                   },
           "message":"Successfully! Record has been fetched."
           Not: Veriler değişebiliyor. Kontrol ediniz
       }
*/

  @Test
    public void test(){
      //1-EndPoint Hazırlama
      String url="http://dummy.restapiexample.com/api/v1/employee/3";

      //2-ExpData
      JSONObject expData=new JSONObject();
      JSONObject datas=new JSONObject();
      datas.put("id",3);
      datas.put("employee_name","Ashtonm Cox");
      datas.put("employee_salary", 86000);
      datas.put("employee_age", 661);
      datas.put("profile_image", "");

      expData.put("status","success");
      expData.put("data",datas);
      expData.put("message","Successfully! Record has been fetched.");

      //3-Reponse Kayıt etme
      Response response=given().when().get(url);

      //4-Assertion işlemi
      SoftAssert softAssert=new SoftAssert();
    JsonPath resJP=response.jsonPath();
      softAssert.assertEquals(resJP.get("status"),expData.get("status"));
      softAssert.assertEquals(resJP.get("data.id"),expData.getJSONObject("data").get("id"));
      softAssert.assertEquals(resJP.get("data.employee_name"),expData.getJSONObject("data").get("employee_name"));
      softAssert.assertEquals(resJP.get("data.employee_salary"),expData.getJSONObject("data").get("employee_salary"));
      softAssert.assertEquals(resJP.get("data.employee_age"),expData.getJSONObject("data").get("employee_age"));
      softAssert.assertEquals(resJP.get("data.profile_image"),expData.getJSONObject("data").get("profile_image"));
      softAssert.assertEquals(resJP.get("message"),expData.get("message"));

     softAssert.assertAll();

  }
}
