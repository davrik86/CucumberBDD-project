package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//You are telling Junit to run test runner class as Cucumber class
@CucumberOptions(features = "src/test/resources/features/",
                glue="step_definitions",
                plugin = {"pretty" ,"html:target/primetech-report.html",
                          "json:target/primetech-report.json"},
                dryRun = false // to find  if there missing the step when dryRun= true
               // monochrome= true-- is to prettyfy the console output
                )

public class TestRunner {



}

/**
 * This Class will allow us to execute and run our feature files/step definitions
 */
