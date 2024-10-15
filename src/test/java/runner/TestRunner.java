package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//You telling junit to run the TestRunner class as a cucumber test
@CucumberOptions(features = "src/test/resources/features/" ,
                glue = {"stepdefinitions","Hooks"},
                plugin = {"pretty", "html:target/primetech-report.html",
                        "json:target/primetech-report.json"
                        , "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                        "rerun:target/failed_scenario.txt"
                },




                //strict was decommissioned from 6.0.0 but it forces the test to fail is the step is not defined in the step definition
                //monochrome = true -- is to prettify the console output but it was deprecated in version 7.0
                tags="@addItem"
                )
public class TestRunner {

}


/**
 * This class will allow us to execute and run our feature files/step definitions
 */
