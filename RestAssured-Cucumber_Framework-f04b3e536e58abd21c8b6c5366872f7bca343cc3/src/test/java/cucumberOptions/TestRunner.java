package cucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/feature",
       plugin = {"pretty",

        "html:src/test/resources/CucumberReport.html"},
        glue = {"stepDefinition"},
        dryRun = false,
        publish = true



)
public class TestRunner {

}


