package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver, this);

    }
    @FindBy(xpath = "//input[@name='email']")
    WebElement emaailInput;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//button[text()='Login']")
    WebElement loginButton;

    @FindBy(xpath="//p[contains(text(),'These credentials')]")
    WebElement errorMessage;
}
