package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import pages.AddNewExpensePage;
import utilities.Driver;
import utilities.SeleniumUtils;

public class AddNewExpenses {

    AddNewExpensePage newExp= new AddNewExpensePage();

    @Given("User clicks on Add Expenses button")
    public void user_clicks_on_add_expenses_button() throws InterruptedException {

        newExp.addExpensesBttn.click();


    }
    @When("Useer selectes category from the dropdown as {string} and customer {string}")
    public void useer_selectes_category_from_the_dropdown_as_and_customer(String categoryLabelPrime, String customerLabel) {

      newExp.newExpenseCategoryfield.click();
        System.out.println("This line for Primetechlabel matches "+newExp.primetechCategory.getText().contains(categoryLabelPrime));
      newExp.primetechCategory.click();
      newExp.customerCategory.click();
        System.out.println("This is selected customer matches expected " + newExp.customerSelect.getText().equals(customerLabel));
      newExp.customerSelect.click();
    }
    @And("enters the expense amount as “{int}”, and payment mode {string}")
    public void enters_the_expense_amount_as_and_payment_mode(Integer amount, String payment) {
        newExp.expenseAmount.clear();
        newExp.expenseAmount.sendKeys(amount.toString());
       newExp.expenceSelectPaymentType.click();
        Assert.assertTrue(newExp.selectCash.getText().equals(payment));
       newExp.selectCash.click();

    }
    @And("User enters a note {string} and clicks the Save button.")
    public void user_enters_a_note_and_clicks_the_save_button(String text) throws InterruptedException {
        newExp.expenseTextarea.sendKeys(text);
        newExp.SaveButtn.click();

    }
    @Then("User should verify that the expence is added")
    public void user_should_verify_that_the_expence_is_added() {
        Assert.assertTrue(newExp.validateExpensesSaved.isDisplayed());
        newExp.elipseMenuBttn.click();
        newExp.elipseDeliteBttn.click();
        newExp.elipseDeliteBttnOK.click();


    }

}
