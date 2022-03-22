package runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/lms_ui_features",
					 glue = {"RecouceandRecord" },
					 tags = "@ResourceandRecord",
					 //tags = "@check",
monochrome=true,
dryRun = false,
plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class ResourceandRecordrunner {

}
