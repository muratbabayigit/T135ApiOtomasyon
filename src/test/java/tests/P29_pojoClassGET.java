package tests;

import baseUrl.BaseUrlDummyExample;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.POJO_Dummy;
import pojos.POJO_DummyDATA;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class P29_pojoClassGET extends BaseUrlDummyExample {

     /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine
    bir GET request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

	Response Body
	// expected data
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

        POJO_DummyDATA data= new POJO_DummyDATA(3,"Ashton Cox",86000,66,"");
        POJO_Dummy expBody= new POJO_Dummy("success","Successfully! Record has been fetched.",data);

        Response response=given().spec(specDummy).when().get("/{pp1}/{pp2}");

        POJO_Dummy resPOJO=response.as(POJO_Dummy.class);
        assertEquals(expBody.getStatus(),resPOJO.getStatus());
        assertEquals(expBody.getData().getId(),resPOJO.getData().getId());
        assertEquals(expBody.getData().getEmployee_name(),resPOJO.getData().getEmployee_name());
        assertEquals(expBody.getData().getEmployee_salary(),resPOJO.getData().getEmployee_salary());
        assertEquals(expBody.getData().getEmployee_age(),resPOJO.getData().getEmployee_age());
        assertEquals(expBody.getData().getProfile_image(),resPOJO.getData().getProfile_image());
        assertEquals(expBody.getMessage(),resPOJO.getMessage());



    }
}
