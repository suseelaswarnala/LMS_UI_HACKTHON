package runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/lms_ui_features",
					 glue = {"AssignmentUser" },
					 tags = "@AssignmentUser",
					 //tags = "@check",
monochrome=true,
dryRun = false,
plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class AssignmentUserrunner {

}
