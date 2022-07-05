package myListener;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = {"src/test/resources/features"},
        glue = {"myStepDefs"},
        monochrome = true,
        plugin = {
                "pretty",
//                "json:target/cucumber-report/cucumber.json",
//                "html:target/cucumber-report/cucumber.html"
                "json:target/Cucumber.json"
        },
        dryRun = false
)

public class runner {
}
