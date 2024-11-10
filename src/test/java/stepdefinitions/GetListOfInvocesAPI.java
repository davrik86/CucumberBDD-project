package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetListOfInvocesAPI {
    String baseURL="http://crater.primetech-apps.com/";
    String token;
    Response response;
    @Given("I'm logged in Successfully")
    public void i_m_logged_in_successfully() {
            String endpoint = "api/v1/auth/login";
            String userEmail = "dummy@primetechschool.com";
            String userPass = "primetech@school";

            Map<String, String> requestHeaders = new HashMap<>();
            requestHeaders.put("Content-Type", "application/json");
            requestHeaders.put("Accept", "application/json");
            requestHeaders.put("company", "1");

            Map<String, String> requstBody = new HashMap<>();
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
    @When("I perform GET operation for {string} endpoint")
    public void i_perform_get_operation_for_endpoint(String endpoint) {

        Map<String,String> requestHeaders= new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("Accept", "application/json");
        requestHeaders.put("Authorization", "Bearer "+token);

        response= RestAssured.given()
                .headers(requestHeaders)
                .when()
                .get(baseURL+endpoint);


    }
    @Then("I should get {int} status code")
    public void i_should_get_status_code(Integer int1) {
       response.then().statusCode(200);
    }
    @And("I should get list of invoces")
    public void i_should_get_list_of_invoces() {
        List<String> listofID= response.jsonPath().getList("data.id");
        List<String> listofIDPath= response.path("data.id");
        System.out.println("Using JsonPath " +listofID);
        System.out.println("Using PAth "+listofIDPath);
        Assert.assertTrue(!listofID.isEmpty());
    }
}
