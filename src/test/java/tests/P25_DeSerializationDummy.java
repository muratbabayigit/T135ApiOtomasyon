package tests;

import baseUrl.BaseUrlDummyExample;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testDatas.DummyTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class P25_DeSerializationDummy extends BaseUrlDummyExample {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine
    bir GET request gonderdigimizde
    donen response’un status code’unun 200,
    content Type’inin application/json
    ve body’sinin asagidaki gibi oldugunu test edin.
         Response Body (expBody)
        {
            "status":"success",
            "data":{
                    "id":3,
                    "employee_name":"Ashton Cox",
                    "employee_salary":86000,
                    "employee_age":66
                    "profile_image":""
                    },
            "message":"Successfully! Record has been fetched."
        }
     */
    @Test
    public void test(){
        specDummy.pathParams("pp1","employee","pp2","3");

        Map<String,Object> expMAPBody= DummyTestData.MapDataOlustur(3.0,"Ashton Cox",86000.0,66.0,"");

        Response response=given().spec(specDummy).when().get("/{pp1}/{pp2}");
        Map<String, Object> resMAP=response.as(HashMap.class);
        assertEquals(expMAPBody.get("status"),resMAP.get("status"));
        assertEquals(((Map)(expMAPBody.get("data"))).get("id"),((Map)(resMAP.get("data"))).get("id"));
        assertEquals(((Map)(expMAPBody.get("data"))).get("employee_name"),((Map)(resMAP.get("data"))).get("employee_name"));
        assertEquals(((Map)(expMAPBody.get("data"))).get("employee_salary"),((Map)(resMAP.get("data"))).get("employee_salary"));
        assertEquals(((Map)(expMAPBody.get("data"))).get("employee_age"),((Map)(resMAP.get("data"))).get("employee_age"));
        assertEquals(((Map)(expMAPBody.get("data"))).get("profile_image"),((Map)(resMAP.get("data"))).get("profile_image"));





    }
}

