package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AddNewInvocesPage;
import pages.ViewInvocesPage;
import utilities.SeleniumUtils;

public class AddNewInvoces {
    AddNewInvocesPage newInvoces= new AddNewInvocesPage();
    ViewInvocesPage invoiceP= new ViewInvocesPage();

    String newInvoceNumber;
    @Given("user lick on the Add New Invoice button.")
    public void user_lick_on_the_add_new_invoice_button() throws InterruptedException {
        newInvoces.newInvoceBttn.click();
    }
    @And("user selects a client from New Customer dropdown, and Item from Item dropdown")
    public void user_selects_a_client_from_new_customer_dropdown_and_item_from_item_dropdown() throws InterruptedException {
        newInvoces.SelectCustomerBttn.click();
        newInvoces.NewCustomerdropdown.click();
        newInvoces.InvoiceSelctCustomer.click();
    }
    @And("enter a quantity of {string} , enter price {string}")
    public void enter_a_quantity_of_enter_price(String qnt, String price) throws InterruptedException {
        newInvoces.invoiceQuantity.sendKeys(qnt);
        newInvoces.InvoiceItemsfield.click();

        newInvoces.selectCofemug.click();
        newInvoces.invocePrice.sendKeys(price);


    }
    @When("clicks on Save Invoce button")
    public void clicks_on_save_invoce_button() throws InterruptedException {
        newInvoces.InvoiceSavetBttn.click();


    }
    @Then("verify teh invoce is saved in invoces list")
    public void verify_teh_invoce_is_saved_in_invoces_list() throws InterruptedException {
        newInvoceNumber=newInvoces.NewInvoiceNumber.getText();
        System.out.println("this is invoce number "+newInvoces.NewInvoiceNumber.getText());
        invoiceP.invocesBttn.click();

        Assert.assertTrue(SeleniumUtils.isItemInTable(newInvoces.InvoiceWebElements, newInvoceNumber ));
    }
    @And("total matches to added items and their quantities")
    public void total_matches_to_added_items_and_their_quantities() {

    }

}
