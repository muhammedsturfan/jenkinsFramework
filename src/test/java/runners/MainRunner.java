package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"stepDefinitions"},
        tags = "@regression",
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})
public class MainRunner extends AbstractTestNGCucumberTests {
}
