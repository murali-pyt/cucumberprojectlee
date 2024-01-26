package MyRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/Users/pyt/eclipse-workspace/cucumberProject/src/main/java/features/login.feature", glue = {
		"stepDefinitions" }, plugin = { "pretty", "html:target/Destination" }, monochrome = true, dryRun = false)



public class TestRunner {

}
