package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ViewInvocesPage {

    //Constructor for the page
    public ViewInvocesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //************ ELEMENTS *************

    @FindBy(xpath = "//a[@href='/admin/invoices']")
    public WebElement invocesBttn;

    @FindBy(xpath = "//h3[text()='Invoices']")
    public WebElement InvocesLAbel;

    @FindBy(xpath = "(//a[contains(@href,'/admin/invoices')])[4]")
    public WebElement firstInvoce;

    @FindBy(xpath = "//h3")
    public WebElement InvoiceNumber;


//@FindBy(xpath = "")
//    public WebElement ;
//@FindBy(xpath = "")
//    public WebElement ;
//@FindBy(xpath = "")
//    public WebElement ;





}
