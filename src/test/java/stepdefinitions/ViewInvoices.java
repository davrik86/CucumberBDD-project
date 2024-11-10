package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashbordPage;
import pages.ViewInvocesPage;
import utilities.SeleniumUtils;

public class ViewInvoices {
    DashbordPage dash= new DashbordPage();
    ViewInvocesPage invocesPage = new ViewInvocesPage();



    @And("user is on the Invoces page")
    public void user_is_on_the_invoces_page() throws InterruptedException {
        invocesPage.invocesBttn.click();
    }
    @Then("The Invoces label should be dispalyed")
    public void the_invoces_label_should_be_dispalyed() {
        Assert.assertTrue(invocesPage.InvocesLAbel.isDisplayed());
    }
    @And("the user clicks on a spesific invoce page")
    public void the_user_clicks_on_a_spesific_invoce_page() throws InterruptedException {
        invocesPage.firstInvoce.click();


    }
    @Then("the invoce should be dispalyed on right side")
    public void the_invoce_should_be_dispalyed_on_right_side() {
        Assert.assertTrue(invocesPage.InvoiceNumber.isDisplayed());

    }

}
