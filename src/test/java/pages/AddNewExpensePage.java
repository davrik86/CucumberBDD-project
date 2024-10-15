package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AddNewExpensePage {
    public AddNewExpensePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //Elements*******************************

    @FindBy(xpath = "//button[text()=' Add Expense']")
    public WebElement addExpensesBttn;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement newExpenseCategoryfield;

    @FindBy(xpath = "//span[text()='primetech']")
    public WebElement primetechCategory;

    @FindBy(xpath = "(//input[@type='text'])[5]")
    public WebElement customerCategory;

    @FindBy (xpath = "//span[text()='Garfield']")
    public WebElement customerSelect;

    @FindBy(xpath = "//input[@type='tel']")
    public WebElement expenseAmount;

    @FindBy(xpath = "//textarea")
    public WebElement expenseTextarea ;

    @FindBy(xpath = "(//input[@type='text'])[6]")
    public WebElement expenceSelectPaymentType;


    @FindBy(xpath = "//span[text()='Cash']")
    public WebElement selectCash;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement SaveButtn;

    @FindBy(xpath = "//a[text()='primetech']")
    public WebElement validateExpensesSaved;

    @FindBy(xpath = "(//div[@class='relative inline-block h-full text-left'])[3]")
    public WebElement elipseMenuBttn;

    @FindBy(xpath = "(//a[@href='#'])[2]")
    public WebElement elipseDeliteBttn;

    @FindBy(xpath = "//button[text()='Ok']")
    public WebElement elipseDeliteBttnOK;




}
