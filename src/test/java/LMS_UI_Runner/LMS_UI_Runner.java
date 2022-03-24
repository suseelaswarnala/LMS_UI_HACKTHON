package LMS_UI_Runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/lms_ui_features",
					 glue = {"stepdef"},
					 //tags = "@Launch",
					 //tags = "@check",
monochrome=true,
dryRun = false,
plugin = {"pretty","html:Reports/report.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class LMS_UI_Runner {

}
