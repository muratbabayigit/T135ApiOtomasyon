package testDatas;

import org.json.JSONObject;

public class DummyTestData {

    /*
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

    public static int statusCode=200;
    public static String contentType="application/json";

    public static JSONObject responseDataOlustur(int id,String EmployeeName,int  EmployeeSalary,int EmployeeAge,String ProfileImage){

        JSONObject dataBody=new JSONObject();
        dataBody.put("id",id);
        dataBody.put("employee_name",EmployeeName);
        dataBody.put("employee_salary",EmployeeSalary);
        dataBody.put( "employee_age",EmployeeAge);
        dataBody.put( "profile_image",ProfileImage);

        JSONObject responseBody=new JSONObject();
        responseBody.put("status","success");
        responseBody.put("data",dataBody);
        responseBody.put("message","Successfully! Record has been fetched.");

        return responseBody;

    }
}
