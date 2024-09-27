package hooks;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

import java.time.Duration;


public class Hooks {
    @Before
    public void BeforeScenario(){
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @After
    public void afterScenario(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screeShot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screeShot, "image/png",scenario.getName());
        }
        Driver.closeDriver();
    }
    @BeforeStep
    public void beforeStep(){
//        System.out.println("this line get printed after each step");

    }
    @AfterStep
    public void afterStep(){
//        System.out.println("This will be printed after each step");
    }
}
