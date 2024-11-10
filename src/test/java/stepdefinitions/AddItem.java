package stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.ItemsPage;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.SeleniumUtils;

public class AddItem {

        WebDriver driver= Driver.getDriver();
        LoginPage loginP= new LoginPage();
        ItemsPage itemP= new ItemsPage();
    @Given("user is logged in successfully")
    public void user_is_logged_in_successfully() throws InterruptedException {
        driver.get(ConfigurationReader.getPropertyValue("craterURL"));
        SeleniumUtils.sendkeysWithActionsClass(loginP.emailInput,"dummy@primetechschool.com" );
        SeleniumUtils.sendkeysWithActionsClass(loginP.passwordInput,"primetech@school");
        loginP.loginButton.click();


        Assert.assertTrue(loginP.dashboardTab.isDisplayed());
        loginP.ItemButton.click();

    }
    @And("user is in item page")
    public void user_is_in_item_page() throws InterruptedException {
        Assert.assertTrue(itemP.Items.isDisplayed());


    }
    @When("the user clicks on the Add Item button")
    public void the_user_clicks_on_the_add_item_button() throws InterruptedException {
        itemP.AddItemsBttn.click();

    }
    @And("user fills out follwing Item Name, Item Description, Item price {string}, selects Unit {string}")
    public void user_fills_out_follwing_item_name_item_description_item_price_selects_unit(String price, String unit) {
        itemP.ItemName.sendKeys("coffeMug");
        itemP.description.sendKeys("just cool MUG");
        itemP.unitField.sendKeys(unit);
        itemP.unitField.sendKeys(Keys.ENTER);
        itemP.priceField.sendKeys(price);



    }
    @And("user clicks Save item button")
    public void user_clicks_save_item_button() {
        itemP.saveItemBttn.click();
    }
    @Then("the item should be listed in Items tabel")
    public void the_item_should_be_listed_in_items_tabel() throws InterruptedException {

        Assert.assertTrue(SeleniumUtils.isItemInTable(itemP.itemsList,"coffeMug"));


    }

}
