package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.ExpensesPage;
import utilities.Driver;

public class Expenses {
        ExpensesPage expenP= new ExpensesPage();
    @Given("User is on Expenses page")
    public void user_is_on_expenses_page() throws InterruptedException {
        expenP.expensesTab.click();

    }
    @Then("User should view Expenses Label , and {string} label are displayed on the page")
    public void user_should_view_expenses_label_and_label_are_displayed_on_the_page(String homeAndExp) {
         Assert.assertTrue(expenP.ExpansesLabel.isDisplayed());
         if((expenP.homeLabelExpenses.getText()+"/"+expenP.expensesLabelExpenses.getText()).contains(homeAndExp)){
             System.out.println("Web element is dispaleyed : "+ " and text is "+
                     homeAndExp);
         }else{
             System.out.println("text did not match "+expenP.homeLabelExpenses.getText()+"/ "+expenP.expensesLabelExpenses.getText());
         }
    }
    @Then("URL should end with {string}")
    public void url_should_end_with(String expenses) {
        String url=Driver.getDriver().getCurrentUrl();
        if(url.contains(expenses)){
            System.out.println("URL ends with " +expenses);
        }else{
            System.out.println("URL did not match");
        }

    }


}
