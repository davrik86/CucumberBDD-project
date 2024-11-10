package API_Tests;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class CraterAPIItems {

    String baseURL="http://crater.primetech-apps.com/";
    String token;
    Response response;
    int itemID;
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
    public void create_an_Item(){
        String endpoint="api/v1/items";
        Faker faker= new Faker();
        String itemName= faker.commerce().productName();
        String description= faker.commerce().material();
        int price= new Random().nextInt(100-10)+100;

        Map<String,String> requestHeaders= new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("Accept", "application/json");
        requestHeaders.put("Authorization", "Bearer "+token);

        Map<String, Object> payload= new HashMap<>();
        payload.put("name", itemName);
        payload.put("description", description);
        payload.put("price",price*100);

         response= RestAssured.given()
                .headers(requestHeaders)
                .body(payload)
                .when()
                 .post(baseURL+endpoint);

         response.then().statusCode(200);
         response.prettyPrint();
         itemID =response.path("data.id");
    }

    @Test(dependsOnMethods ={"loginToCraterAPP","create_an_Item"})
    public void UpdateAnItem(){
        String endpoint="api/v1/items/"+itemID;

        Faker faker= new Faker();
        String itemName= faker.commerce().productName();
        String description= faker.commerce().material();
        int price= new Random().nextInt(100-10)+100;

        Map<String,String> requestHeaders= new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("Accept", "application/json");
        requestHeaders.put("Authorization", "Bearer "+token);

        Map<String, Object> payload= new HashMap<>();
        payload.put("name", itemName);
        payload.put("description", description);
        payload.put("price",price*100);

        response= RestAssured.given()
                .headers(requestHeaders)
                .body(payload)
                .when()
                .put(baseURL+endpoint);

        response.then().statusCode(200);


    }
}
