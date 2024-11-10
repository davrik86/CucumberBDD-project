package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.SeleniumUtils;

public class UserAccess_StepDef {
    WebDriver driver= Driver.getDriver();
    LoginPage loginP= new LoginPage();
    @Given("user is navigated to Crater login page")
    public void user_is_navigated_to_crater_login_page() throws InterruptedException {
        driver.get(ConfigurationReader.getPropertyValue("craterURL"));


    }
    @When("user enters valid username and valid password")
    public void user_enters_valid_username_and_valid_password() throws InterruptedException {
        SeleniumUtils.sendkeysWithActionsClass(loginP.emailInput,ConfigurationReader.getPropertyValue("userName" ));

        SeleniumUtils.sendkeysWithActionsClass(loginP.passwordInput,ConfigurationReader.getPropertyValue("userPassword" ));

    }
    @And("user clicks on login button")
    public void user_clicks_on_login_button() throws InterruptedException {
        loginP.loginButton.click();



    }
    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        Assert.assertTrue(loginP.dashboardTab.isDisplayed());
    }



    // Second scenario

    @When("user enters invalid username and valid password")
    public void user_enters_invalid_username_and_valid_password() throws InterruptedException {
        SeleniumUtils.sendkeysWithActionsClass(loginP.emailInput,"e1233@primetechschool.com" );

        SeleniumUtils.sendkeysWithActionsClass(loginP.passwordInput,"primetech@school");


    }
    @Then("user should see an error message {string} displayed")
    public void user_should_see_an_error_message_displayed(String string) {
        Assert.assertTrue(loginP.errorPop.isDisplayed());
    }
    @And("user should not be logged in")
    public void user_should_not_be_logged_in() {
        Assert.assertTrue(loginP.emailInput.isDisplayed());
        Assert.assertTrue(loginP.passwordInput.isDisplayed());


    }




}
