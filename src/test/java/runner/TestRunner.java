package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//You are telling Junit to run test runner class as Cucumber class
@CucumberOptions(features = "src/test/resources/features/",
                glue={"step_definitions","hooks"},
                plugin = {"pretty" ,"html:target/primetech-report.html",
                          "json:target/primetech-report.json"},

               // monochrome= true-- is to prettyfy the console output
//                tags= "(@smoke) and (not @SauseDemo)"
                tags= "@Crater and @smoke"
                )

public class TestRunner {



}

/**
 * This Class will allow us to execute and run our feature files/step definitions
 */
