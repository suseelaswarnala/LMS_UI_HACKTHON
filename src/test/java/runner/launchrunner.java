package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/lms_ui_features",
					 glue = {"Launch"},
					// tags = "@Launch",
					 //tags = "@check",
monochrome=true,
dryRun = false,
plugin = {"pretty","html:Reports/report.html"}
)



public class launchrunner {
	

}
