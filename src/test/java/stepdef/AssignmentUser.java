package stepdef;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import actions.Actions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AssignmentUser {
	WebDriver driver;
	public AssignmentUser() throws Exception {
		Login login=new Login();
		login.driver=driver;
		}
	Actions actions = new Actions();

	@Given("User is on Manage Submissions user page")
	public void user_is_on_manage_submissions_user_page() {
		// User clicks on the Manage Submission in the Manage Assignment Page
		driver.findElement(By.linkText("Manage Assignment")).click();
	}

	@When("User clicks on submit button after selecting Batch,Assignment Name,Assignment Date ,add comments")
	public void user_clicks_on_submit_button_after_selecting_batch_assignment_name_assignment_date_add_comments() {
		// User Selects BatchName on manage submission page
		WebElement Batchno = driver.findElement(By.id("selGradeBatch"));
		Select batch = new Select(Batchno);
		batch.selectByVisibleText("SDET01");

		// User selects AssignmentName on manage submission page
		WebElement AssignmentName = driver.findElement(By.id("selAssignmentName"));
		Select assignmentName = new Select(AssignmentName);
		assignmentName.selectByVisibleText("Selenium_2");

		// User Selecting the AssignmentDueDate
		driver.findElement(By.id("txtAssignmentDate")).click();
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h4[contains(text(),'Calender'")));
		actions.selectDate("24", "March", "2022");

		// Adding comment in the comment box
		driver.findElement(By.id("txtSubComments")).sendKeys("Good Job");

		// clicking on the submit button
		driver.findElement(By.id("btnGradesSubmit")).click();

	}

	@Then("Assignment will be submitted succesfully")
	public void assignment_will_be_submitted_succesfully() throws IOException {
		WebElement SuccessfulMessage = driver
				.findElement(By.cssSelector("//h4[contains(text(),'Assignment will be submitted succesfully'"));
		String successfulMessage = SuccessfulMessage.getText();
		actions.takeScreenshot("Assignment_Submitted");
		Assert.assertEquals(successfulMessage, "Assignment will be submitted succesfully");
	}

	@When("User clicks on submit button after clicking on Edit icon to edit the required details")
	public void user_clicks_on_submit_button_after_clicking_on_edit_icon_to_edit_the_required_details() {

		driver.findElement(By.id("edit")).click();

		// user Adds an AssignmentName on edit tab of manage Assignments page
		WebElement AssignmentName = driver.findElement(By.id("selAssignmentName"));
		Select assignmentName = new Select(AssignmentName);
		assignmentName.selectByVisibleText("Selenium_1");

		// User clicks on the assignment calendar and selects particular date on edit
		// tab of manage Assignments page
		driver.findElement(By.id("selAssignmentDate")).click();
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h4[contains(text(),'Calender'")));

		actions.selectDate("26", "March", "2022");

		// user clicks on submit button
		driver.findElement(By.id("btnGradesSubmit")).click();

	}

	@Then("Updated Assignment will be submitted successfully")
	public void updated_assignment_will_be_submitted_successfully() throws IOException {
		WebElement SuccessfulMessage = driver
				.findElement(By.xpath("//h4[contains(text(),'Updated Assignment will be submitted successfully'"));
		String updatedsuccessfulMessage = SuccessfulMessage.getText();
		actions.takeScreenshot("Assignment_Updated");
		Assert.assertEquals(updatedsuccessfulMessage, "Updated Assignment will be submitted successfully");
	}

	@When("User clicks on Trash icon after the assignment")
	public void user_clicks_on_trash_icon_after_the_assignment() {
		driver.findElement(By.linkText("Trash")).click();
	}

	@Then("Assignment will be deleted successfully")
	public void assignment_will_be_deleted_successfully() throws IOException {
		WebElement DeletedSuccessfulMessage = driver
				.findElement(By.xpath("//h4[contains(text(),'Assignment will be deleted successfully'"));
		String deletedSuccessfulMessage = DeletedSuccessfulMessage.getText();
		actions.takeScreenshot("Assignment_Deleted");
		Assert.assertEquals(deletedSuccessfulMessage, "Assignment will be deleted successfully");
	}
}