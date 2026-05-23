package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-report.html",
                "json:target/cucumber-reports/cucumber-report.json",
                "junit:target/cucumber-reports/cucumber-report.xml"
        },
        dryRun = false,
        monochrome = true
)
public class RunCucumberTest {
}
