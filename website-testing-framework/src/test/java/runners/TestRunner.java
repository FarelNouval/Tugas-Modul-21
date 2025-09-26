package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",  // Path ke .feature
        glue = {"stepdefinitions"},  // Package step definitions
        plugin = {
                "pretty",  // Output console yang bagus
                "html:build/cucumber-reports/cucumber.html",  // Laporan HTML
                "json:build/cucumber-reports/cucumber.json"   // Laporan JSON (bisa di-convert ke PDF dll)
        },
        monochrome = true  // Output monokrom untuk console
)
public class TestRunner {
}
