package myListener;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = {"src/test/resources/features"},
        glue = {"myStepDefs"},
        tags = "@Register",
        monochrome = true,
        plugin = {
                "pretty",
//                ,"json:target/cucumber-report/Cucumber.json"
//                ,"html:target/cucumber-report/cucumber.html"
                "json:target/Cucumber.json"
        },
        dryRun = false
)

public class runnerTest {
}
