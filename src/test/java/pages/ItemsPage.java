package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ItemsPage {
    public ItemsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //************ ELEMENTS *************

    @FindBy (xpath = "//a[@href='/admin/items']")
    public WebElement Items;

    @FindBy (xpath = " //button[text()=' Add Item']")
    public WebElement AddItemsBttn;

    @FindBy (xpath = "(//input[@type='text'])[2]")
    public  WebElement NameField;

    @FindBy (xpath = "(//input[@type='text'])[2]")
    public  WebElement ItemName;

    @FindBy(xpath = "//input[@type='tel']")
    public  WebElement priceField;

    @FindBy(xpath = "(//input[@type='text'])[3]")
    public  WebElement unitField;

    @FindBy(xpath = "//textarea[@name='description']")
    public  WebElement description;

    @FindBy (xpath = "//button[text()=' Save Item']")
    public  WebElement saveItemBttn;

    @FindBy(xpath = "//a[contains(@href,'/admin/items/')]")
    public List<WebElement> itemsList;



}
