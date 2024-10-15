package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    private static WebDriver driver;

    private Driver(){

    }

    /**
     * Static method to get the single instance of WebDriver
     */

    public static WebDriver getDriver(){
        String browserType=ConfigurationReader.getPropertyValue("browserType");

        if(driver == null){
            switch(browserType.toLowerCase()){//to lowercase all entries if entered with any capital letters
                case "chrome":
                    driver = new ChromeDriver(); //Instantiate only once
                    break;

                case "firefox":
                    driver=new FirefoxDriver();
                    break;
                case "edge":
                    driver=new EdgeDriver();
                    break;
                case "safari":
                    driver=new SafariDriver();
                    break;
                default:
                    System.out.println("using default browser");
                    driver = new ChromeDriver();
                    break;
                case "chrome-headless":
                    System.out.println("using chrome-headless");
                    ChromeOptions chromeOptions= new ChromeOptions();
                    chromeOptions.addArguments("--headless");
                    driver= new ChromeDriver(chromeOptions);
                    break;
                case "firefox-headless":
                    System.out.println("using firefox-headless");
                    FirefoxOptions firefoxOptions= new FirefoxOptions();
                    firefoxOptions.addArguments("--headless");
                    driver= new FirefoxDriver(firefoxOptions);
                    break;
            }

        }
        return driver;// this is an existing one that is not null ( driver this is alive)
    }

    /**
     * This method will quit the driver and set it to null
     */
    public static void closeDriver(){
        //We Check if the driver still alive then
        //quit the driver and set the driver object to null
        System.out.println("Closing the driver");
        if(driver != null){
            driver.quit();
            driver = null;
        }


    }



}
