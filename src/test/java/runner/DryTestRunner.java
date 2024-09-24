package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//You are telling Junit to run test runner class as Cucumber class
@CucumberOptions(features = "target/test-classes/features/User_Access.feature",
                glue="step_definitions",
                plugin = {"pretty" ,"html:target/primetech-report.html",
                          "json:target/primetech-report.json"},
                dryRun = true // to find  if there missing the step when dryRun= true
               // monochrome= true-- is to prettyfy the console output
                )

public class DryTestRunner {



}

/**
 * This Class will allow us to execute and run our feature files/step definitions
 */
