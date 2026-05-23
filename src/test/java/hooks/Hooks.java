package hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        System.out.println("========================================");
        System.out.println("Starting Scenario: " + scenario.getName());
        System.out.println("========================================");
        String browser = System.getProperty("browser", "chrome");
        WebDriver driver = DriverFactory.initDriver(browser);
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Scenario FAILED: " + scenario.getName() + " — capturing screenshot...");
            try {
                TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failure Screenshot - " + scenario.getName());
            } catch (Exception e) {
                System.err.println("Could not capture screenshot: " + e.getMessage());
            }
        } else {
            System.out.println("Scenario PASSED: " + scenario.getName());
        }

        System.out.println("========================================\n");
        DriverFactory.quitDriver();
    }
}
