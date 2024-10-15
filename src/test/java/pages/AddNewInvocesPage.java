package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AddNewInvocesPage {

    public AddNewInvocesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//button[text()=' New Invoice']")
    public WebElement newInvoceBttn ;

    @FindBy (xpath="//div[@class='mt-1']")
    public WebElement SelectCustomerBttn;

    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement NewCustomerdropdown;

    @FindBy(xpath = "(//li[@href='#'])[1]")
    public WebElement InvoiceSelctCustomer;

    @FindBy(xpath = "(//input[@type='text'])[6]")
    public WebElement InvoiceItemsfield ;


    @FindBy(xpath = "(//ul/li)[5]")
    public WebElement selectCofemug;

    @FindBy(xpath = "(//input[@type='number'])[1]")
    public WebElement invoiceQuantity;

    @FindBy(xpath = "(//input[@type='tel'])[1]")
    public WebElement invocePrice;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement InvoiceSavetBttn;

    @FindBy(xpath = "//h3[contains(text(),'INV')]")
    public WebElement NewInvoiceNumber;

    @FindBy(xpath = "//a[@class='font-medium text-primary-500']")
    public List<WebElement> InvoiceWebElements;
//@FindBy(xpath = "")
//    public WebElement ;
}
