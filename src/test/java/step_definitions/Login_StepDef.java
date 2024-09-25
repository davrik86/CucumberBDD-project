package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login_StepDef {
    WebDriver driver= new FirefoxDriver();
    @Given("User is navigated to saucedemo.com")
    public void user_is_navigated_to_saucedemo_com() {

        driver.get("https://www.saucedemo.com/");
    }
    @When("User enters {string} in the username field")
    public void user_enters_in_the_username_field(String userName) {
        WebElement username= driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys(userName);
    }
    @And("User enters {string} in the password field")
    public void user_enters_in_the_password_field(String userPass) {
        WebElement pass= driver.findElement(By.xpath("//input[@id='password']"));
        System.out.println("The pass is "+userPass);
        pass.sendKeys(userPass);

    }
    @And("User clicks on Login Button")
    public void user_clicks_on_login_button() {
        WebElement buttn= driver.findElement(By.xpath("//input[@id='login-button']"));
        buttn.click();
    }
    @Then("User is able to verify the {string} label is displayed")
    public void user_is_able_to_verify_the_label_is_displayed(String productsLabel) {
        WebElement actualElement=driver.findElement(By.xpath("//span[@data-test='title']"));
      String actualLabel=actualElement.getText();
      boolean isDisplayed= actualElement.isDisplayed();
//       if (productsLabel.equals(actualElement.getText())){
//           System.out.println("Theay are equal");
//       }else{
//           System.out.println("They are not");
//       }
    // Assertion

        Assert.assertEquals(productsLabel, actualElement.getText());
        Assert.assertTrue(isDisplayed);
        driver.quit();
    }

}
