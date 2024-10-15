package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ExpensesPage {

    public ExpensesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //************ ELEMENTS *************

    @FindBy(xpath = "//a[@href='/admin/expenses']")
    public WebElement expensesTab;

    @FindBy(xpath = "//h3")
    public WebElement ExpansesLabel;

    @FindBy(xpath = "(//a[@href='/admin/dashboard'])[2]")
    public WebElement homeLabelExpenses;

    @FindBy(xpath = "//a[@href='/admin/expenses#']")
    public WebElement expensesLabelExpenses;






}
