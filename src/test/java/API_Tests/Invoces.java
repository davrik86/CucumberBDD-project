package API_Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Invoces {

    String baseURL="http://crater.primetech-apps.com/";
    String token;
    Response response;
    int itemID;
    List<Integer> InvoceID;

    @Test
    public  void loginToCraterAPP(){
        String endpoint="api/v1/auth/login";
        String userEmail="dummy@primetechschool.com";
        String userPass="primetech@school";

        Map<String,String> requestHeaders= new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("Accept", "application/json");
        requestHeaders.put("company", "1");

        Map<String, String> requstBody= new HashMap<>();
        requstBody.put("username", userEmail);
        requstBody.put("password", userPass);
        requstBody.put("device_name", "mobile_app");


        response= RestAssured.given()
                .headers(requestHeaders)
                .body(requstBody)
                .when()
                .post(baseURL+endpoint);
        response.then().statusCode(200);
        response.prettyPrint();
        token= response.path("token");
        System.out.println(token);


    }

    @Test(dependsOnMethods = "loginToCraterAPP")
    public void listAllInvoces() {
        String endpoint = "api/v1/invoices/";

        Map<String,String> requestHeaders= new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("Accept", "application/json");
        requestHeaders.put("Authorization", "Bearer "+token);

        response= RestAssured.given()
                .headers(requestHeaders)
                .when()
                .get(baseURL+endpoint);

        response.then().statusCode(200);
//        response.prettyPrint();
        InvoceID= response.jsonPath().getList("data.id");
        System.out.println(InvoceID);
    }

    @Test(dependsOnMethods = "listAllInvoces")
    public void getSpesificInvoice(){
        String endpoint="api/v1/invoices/"+InvoceID.get(0);//to get 1st one from the List
        System.out.println(" Full endpoint is "+endpoint);

        Map<String,String> requestHeaders= new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("Accept", "application/json");
        requestHeaders.put("Authorization", "Bearer "+token);

        response= RestAssured.given()
                .headers(requestHeaders)
                .when()
                .get(baseURL+endpoint);

        response.then().statusCode(200);
        response.prettyPrint();

    }
}
