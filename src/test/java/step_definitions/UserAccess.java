package step_definitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.SettingsPage;
import utilities.Driver;

import java.time.Duration;

public class UserAccess {


    WebDriverWait wait= new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5000));
        Actions action= new Actions(Driver.getDriver());
        LoginPage logP= new LoginPage();
        SettingsPage setP= new SettingsPage();

    @Given("user is navigated to Crater login page")
    public void user_is_navigated_to_crater_login_page() throws InterruptedException {
        Driver.getDriver().get("http://crater.primetech-apps.com/login");
      // Thread.sleep(2000);

    }
    @When("user enters valid username and valid password")
    public void user_enters_valid_username_and_valid_password() {
        //action.sendKeys(logP.password,"primetech@school").build().perform();
        action.sendKeys(logP.emailInput,"entityadmin@primetechschool.com").build().perform();
        logP.password.sendKeys("primetech@school");
    }
    @And("user clicks on login button")
    public void user_clicks_on_login_button() throws InterruptedException {
    // action.click(logP.loginButton).build().perform();
       logP.loginButton.click();
       Thread.sleep(4000);


    }
    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        //Verify using URL that is different from login page and use Settings eliment
        String loginURL="http://crater.primetech-apps.com/login";
        String afterLoginURL= Driver.getDriver().getCurrentUrl();
        Assert.assertNotEquals(loginURL, afterLoginURL);
        System.out.println("Curent Url is "+afterLoginURL);
        Assert.assertTrue(setP.settingsLabel.isDisplayed());
        Driver.closeDriver();
    }

    @When("user enters invalid username and valid password")
    public void user_enters_invalid_username_and_valid_password() {
        action.sendKeys(logP.emailInput,"entityadmi2323n@primetechschool.com").build().perform();
        logP.password.sendKeys("primetech@school");
    }

    @Then("user should see an error message {string} displayed")
        public void user_should_see_an_error_message_displayed(String error) {

        Assert.assertTrue(logP.errorMessage.isDisplayed());

    }
    @And("user should not be logged in")
    public void user_should_not_be_logged_in() {
        String URL="http://crater.primetech-apps.com/login";
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals(URL));
        Driver.closeDriver();
    }

}
