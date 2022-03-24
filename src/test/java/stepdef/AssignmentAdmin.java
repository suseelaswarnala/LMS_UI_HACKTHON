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

public class AssignmentAdmin {

	WebDriver driver;
	public AssignmentAdmin() throws Exception {
		Login login=new Login();
		login.driver=driver;
		}
	Actions actions = new Actions();
	WebElement Assignment = driver.findElement(By.linkText("Manage Assignment"));

	@Given("Admin is on Manage Assignments Page admin by clicking on Manage Assignments tab")
	public void admin_is_on_manage_assignments_page_admin_by_clicking_on_manage_assignments_tab() {

		// Manage Assignment is being clicked
		Assignment.click();

	}

	@When("Admin Add an Assignment")
	public void admin_add_an_assignment_to_existing_batch() {

		// Admin clicks on Batch and gives the batch
		// no.,AssignmentName,AssignmentDetails,AssignmentDueDate and clicks on submit
		// button
		driver.findElement(By.xpath("//*[text()='AssignmentBatch']")).sendKeys("SDET_01");
		driver.findElement(By.xpath("//Select[@name='AssignmentName']")).sendKeys("Selenium_1");
		driver.findElement(By.xpath("//Select[@name='Adetails']")).sendKeys("Locators");
		driver.findElement(By.xpath("//Select[@name='ADueDate']")).sendKeys("03-24-2022");
		driver.findElement(By.id("Submit")).click();
	}

	@Then("Newly Added assignment Details will be displayed in Manage Assignments Page Admin")
	public void newly_added_assignment_details_will_be_displayed_in_manage_assignments_page_admin() {

		// Newly added Assignment Name should be displayed
		WebElement aName = driver.findElement(By.xpath("//*[text()='AssignmentName']"));
		String name = aName.getAttribute("value");
		Assert.assertEquals(name, "Selenium_1");

		// Newly Entered Assignment Details should be displayed
		WebElement aDetails = driver.findElement(By.xpath("//*[text()='Adetails']"));
		String details = aDetails.getAttribute("value");
		Assert.assertEquals(details, "Locators");

		// Newly Entered Assignment DueDate should be displayed
		WebElement aDueDate = driver.findElement(By.xpath("//*[text()='3-24-2022']"));
		Assert.assertEquals(aDueDate, "3-24-2022");
	}

	@When("Admin Edit an assignment on Manage Assignment Page")
	public void admin_edit_an_existing_assignment() {

		// Clicking on Edit button on ManageAssignmentPage
		driver.findElement(By.id("EditAssignment")).click();

		// Editing the Existing AssignmentName
		WebElement EditAssignment = driver.findElement(By.id("RestAssured"));
		EditAssignment.clear();
		EditAssignment.sendKeys("Restful");

		// Editing the Existing AssignmentDetails
		WebElement EditAdetails = driver.findElement(By.id("API"));
		EditAdetails.clear();
		EditAdetails.sendKeys("Services");

		// Admin Editing the Existing AssignmentDueDate
		driver.findElement(By.id("AssignmentDate")).click();
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h4[contains(text(),'Calender'")));

		actions.selectDate("30", "March", "2022");
	}

	@Then("Updated assignment details will be displayed in Manage Assignments Page Admin")
	public void updated_assignment_details_will_be_displayed_in_manage_assignments_page_admin() throws IOException {

		// Edited Assignment Name should be displayed
		boolean isElementDisplayed = driver.findElement(By.xpath("//*[text()='Restful']")).isDisplayed();
		Assert.assertEquals(isElementDisplayed, "Restful");

		// Edited Assignment Details should be displayed
		boolean isElementDisplayed1 = driver.findElement(By.xpath("//*[text()='Services']")).isDisplayed();
		Assert.assertEquals(isElementDisplayed1, "Services");

		// Edited Assignment DueDate should be displayed
		boolean isElementDisplayed2 = driver.findElement(By.xpath("//*[text()='3-30-2022']")).isDisplayed();
		Assert.assertEquals(isElementDisplayed2, "3-30-2022");

		actions.takeScreenshot("UpdatedAssignment_Submitted");
	}

	// Admin clicks on delete an existing assignment
	@When("Admin Delete an existing assignment")
	public void admin_delete_an_existing_assignment() {

		driver.findElement(By.cssSelector("//*[text(),'DeleteAssignment']")).click();

	}

	@Then("Deleted assignment details will be removed from Manage Assignments Page Admin")
	public void deleted_assignment_details_will_be_removed_from_manage_assignments_page_admin() {

		// Deleted Assignment should be removed
		int actualcount = actions.acount();
		Assignment.click();
		int expcount = actions.acount();
		Assert.assertEquals(actualcount - 1, expcount);
	}

	@When("Admin tries to view exisiting assignment details")
	public void admin_tries_to_view_exisiting_assignment_details() {

		// Admin clicks View on Manage Assignment Page
		Assignment.click();

	}

	@Then("All the existing assignment details will be displayed in Manage Assignments Page Admin")
	public void all_the_existing_assignment_details_will_be_displayed_in_manage_assignments_page_admin()
			throws IOException {

		// All Existing Assignment should be displayed

		int actualcount = actions.acount();
		Assignment.click();
		int expcount = actions.acount();
		Assert.assertEquals(actualcount, expcount);

	}

	@Given("Admin is on Add tab of manage Assignments page admin view by clicking on Add Assignment in Manage Assignments Page admin")
	public void admin_is_on_add_tab_of_manage_assignments_page_admin_view_by_clicking_on_add_assignment_in_manage_assignments_page_admin() {

		driver.findElement(By.id("AddProgram")).click();
	}

	@When("Admin clicks on submit button after selecting Batch and enters Assignment name, Assignment Description , Assignment Due, Upload assignments")
	public void admin_clicks_on_submit_button_after_selecting_batch_and_enters_assignment_name_assignment_description_assignment_due_upload_assignments() {

		// Selecting AssignmentBatch from Dropdown
		WebElement Batchno = driver.findElement(By.id("selAssignmentBatch"));
		Select Batchnumber = new Select(Batchno);
		Batchnumber.selectByVisibleText("SDET01");

		// Admin Entering Assignment Name, Assignment Description
		driver.findElement(By.id("txtAssignmentName")).sendKeys("Locators");
		driver.findElement(By.id("txtAssignmentDesc")).sendKeys("WebElement Locator");

		// Admin selecting the AssignmentDueDate
		driver.findElement(By.id("txtAssignmentDate")).click();
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h4[contains(text(),'Calender'")));

		actions.selectDate("26", "March", "2022");

		// Admin Uploading assignment File and click on submit button
		driver.findElement(By.linkText("AssignmentFile1"))
				.sendKeys("C:\\Learnings\\Java\\NumpyNinja.LMSUI\\Assignment.txt");
		driver.findElement(By.id("Submit")).click();
	}

	@Then("Created assignments will be displayed in Manage Assignments Page admin and Manage Assignment page User View")
	public void created_assignments_will_be_displayed_in_manage_assignments_page_admin_and_manage_assignment_page_user_view()
			throws IOException {

		// Admin Entered Assignment Name should be displayed
		WebElement aName = driver.findElement(By.xpath("//*[text()='AssignmentName']"));
		String name = aName.getAttribute("value");
		Assert.assertEquals(name, "Locators");

		// Admin Entered Assignment aDescription should be displayed
		WebElement aDescription = driver.findElement(By.xpath("//*[text()='Adetails']"));
		String description = aDescription.getAttribute("value");
		Assert.assertEquals(description, "WebElement Locator");

		// Admin Entered Assignment DueDate should be displayed
		WebElement aDueDate = driver.findElement(By.xpath("//*[text()='3-24-2022']"));
		Assert.assertEquals(aDueDate, "3-26-2022");

		// Admin Uploaded Assignment File should be Displayed
		WebElement aFile = driver.findElement(By.xpath("//*[text()='AssignmentFile1']"));
		String File = aFile.getAttribute("value");
		Assert.assertEquals(File, "AssignmentFile1");
		actions.takeScreenshot("CreatedAssignment");

	}

	@Given("Admin is on Edit tab of manage Assignments page admin view by clicking on Add Assignment in Manage Assignments Page admin")
	public void admin_is_on_edit_tab_of_manage_assignments_page_admin_view_by_clicking_on_add_assignment_in_manage_assignments_page_admin() {

		// Admin clicks on the add asignment on edit tab of assignment page
		driver.findElement(By.linkText("Edit")).click();

	}

	@When("Admin clicks on submit button after updating one or more assignment details")
	public void admin_clicks_on_submit_button_after_updating_one_or_more_assignment_details() {

		// Admin Adds an AssignmentName on edit tab of manage Assignments page
		WebElement AddAssignmentName = driver.findElement(By.xpath("//Select[@name='Locators']"));
		AddAssignmentName.clear();
		AddAssignmentName.sendKeys("Selenium_1");

		// Admin adds AssignmentDetails on edit tab of manage Assignments page
		WebElement AddAdetails = driver.findElement(By.xpath("//Select[@name='WebElement Locator']"));
		AddAdetails.clear();
		AddAdetails.sendKeys("Locators");

		// Admin adds AssignmentDueDate on edit tab of manage Assignments page and
		// clicks on submit button
		driver.findElement(By.xpath("//Select[@name='ADueDate']")).sendKeys("03-24-2022");
		driver.findElement(By.id("Submit")).click();
	}

	@Then("Updated assignment details will be displayed in Manage Assignments Page admin and Manage Assignment page User View")
	public void updated_assignment_details_will_be_displayed_in_manage_assignments_page_admin_and_manage_assignment_page_user_view()
			throws IOException {

		// added Assignment Name should be displayed edit tab of manage Assignments page
		WebElement aName = driver.findElement(By.xpath("//*[text()='AssignmentName']"));
		String name = aName.getAttribute("value");
		Assert.assertEquals(name, "Selenium_1");

		// Entered Assignment Details should be displayed edit tab of manage Assignments
		// page
		WebElement aDescription = driver.findElement(By.xpath("//*[text()='Adetails']"));
		String description = aDescription.getAttribute("value");
		Assert.assertEquals(description, "Locators");

		// Entered Assignment DueDate should be displayed edit tab of manage Assignments
		// page
		WebElement aDueDate = driver.findElement(By.xpath("//*[text()='3-24-2022']"));
		Assert.assertEquals(aDueDate, "3-26-2022");

		// Entered Assignment DueDate should be displayed edit tab of manage Assignments
		// page
		WebElement aFile = driver.findElement(By.xpath("//*[text()='AssignmentFile1']"));
		String File = aFile.getAttribute("value");
		Assert.assertEquals(File, "AssignmentFile1");

		actions.takeScreenshot("UpdatedAssignment_Submitted");
	}

	@Given("Admin is on Manage Assignments Page admin")
	public void admin_is_on_manage_assignments_page_admin() {

		// Clicking on Manage Assignment
		driver.findElement(By.linkText("Manage Assignment")).click();
	}

	@When("Admin clicks on Trash icon after selecting existing assignments")
	public void admin_clicks_on_trash_icon_after_selecting_existing_assignments() {

		// clicking on Trash button on the existing assignments
		driver.findElement(By.cssSelector("//*[text(),'DeleteAssignment']")).click();

	}

	@Then("Deleted assignment will be removed from Admin View in Manage Assignments Page admin and Manage Assignment page User View")
	public void deleted_assignment_will_be_removed_from_admin_view_in_manage_assignments_page_admin_and_manage_assignment_page_user_view() {

		// Deleted Assignment should be removed

		int actualcount = actions.acount();
		Assignment.click();
		int expcount = actions.acount();
		Assert.assertEquals(actualcount - 1, expcount);
	}

	@Given("Admin is on Manage Submissions Admin page by clicking on Manage button in Manage assignments page admin")
	public void admin_is_on_manage_submissions_admin_page_by_clicking_on_manage_button_in_manage_assignments_page_admin() {

		driver.findElement(By.id("ManageGrades")).click();
	}

	@When("Admin clicks on submit button after selecting all th details like Batch,Assignment Name,Assignment Date ,Grade By ,Grade ,Make Garde Visible and add comments")
	public void admin_clicks_on_submit_button_after_selecting_all_th_details_like_batch_assignment_name_assignment_date_grade_by_grade_make_garde_visible_and_add_comments() {

		// Admin Selects BatchName on manage submission page
		WebElement Batchno = driver.findElement(By.id("GradeBatch"));
		Select batchno = new Select(Batchno);
		batchno.selectByVisibleText("SDET01");

		// Admin selects AssignmentName on manage submission page
		WebElement AssignmentName = driver.findElement(By.id("AssignmentName"));
		Select assignmentName = new Select(AssignmentName);
		assignmentName.selectByVisibleText("SDET01");

		// Admin selecting the AssignmentDueDate on manage submission page
		driver.findElement(By.id("AssignmentDate")).click();
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h4[contains(text(),'Calender'")));

		actions.selectDate("27", "March", "2022");

		// Adding comment in the comment box and uploading 5 assignment files
		driver.findElement(By.id("SubComments")).sendKeys("Excellent Performance");
		driver.findElement(By.linkText("SubmissionFile1"))
				.sendKeys("C:\\Learnings\\Java\\NumpyNinja.LMSUI\\Assignment1.txt");
		driver.findElement(By.linkText("SubmissionFile2"))
				.sendKeys("C:\\Learnings\\Java\\NumpyNinja.LMSUI\\Assignment2.txt");
		driver.findElement(By.linkText("SubmissionFile1"))
				.sendKeys("C:\\Learnings\\Java\\NumpyNinja.LMSUI\\Assignment3.txt");
		driver.findElement(By.linkText("SubmissionFile2"))
				.sendKeys("C:\\Learnings\\Java\\NumpyNinja.LMSUI\\Assignment4.txt");
		driver.findElement(By.linkText("SubmissionFile1"))
				.sendKeys("C:\\Learnings\\Java\\NumpyNinja.LMSUI\\Assignment5.txt");

		// Assignment graded by
		WebElement gradedby = driver.findElement(By.id("GradedBy"));
		Select Gradedby = new Select(gradedby);
		Gradedby.selectByVisibleText("Staff");

		// Assignment grade
		WebElement grade = driver.findElement(By.xpath("//Select[@name='Grade']"));
		Select Grade = new Select(grade);
		Grade.selectByVisibleText("A");

		// Check on GradesVisible Checkbox and click on submit button
		driver.findElement(By.id("GradesVisible")).click();
		driver.findElement(By.name("Submit")).click();
	}

	@Then("Grade Details will be visible to both Admin and User View")
	public void grade_details_will_be_visible_to_both_admin_and_user_view() throws IOException {

		// Selected Batch Name should be displayed on manage Assignments submission page
		WebElement BatchNameElement = driver.findElement(By.xpath("//*[text()='SDET01']"));
		String bname = BatchNameElement.getAttribute("value");
		Assert.assertEquals(bname, "SDET01");

		// Selected Assignment Name should be displayed on manage Assignments submission
		// page
		boolean ANameElement = driver.findElement(By.xpath("//*[text()='Selenium_2']")).isDisplayed();
		Assert.assertEquals(ANameElement, "Selenium_2");

		// Selected Assignment Date should be displayed on manage Assignment submissions
		// page
		WebElement ADateElement = driver.findElement(By.xpath("//*[text()='03-27-2022']"));
		String Adate = ADateElement.getAttribute("value");
		Assert.assertEquals(Adate, "03-27-2022");

		// Uploading assignment1 File should be displayed on manage Assignment
		// submissions
		// page
		WebElement assignment1File1 = driver.findElement(By.xpath("//*[text()='Assignment1']"));
		String aF1 = assignment1File1.getAttribute("value");
		Assert.assertEquals(aF1, "Assignment1");

		// Uploading assignment2 File should be displayed on manage Assignment
		// submissions
		// page
		WebElement assignment1File2 = driver.findElement(By.xpath("//*[text()='Assignment1']"));
		String aF2 = assignment1File2.getAttribute("value");
		Assert.assertEquals(aF2, "Assignment1");

		// Uploading assignment3 File should be displayed on manage Assignment
		// submissions
		// page
		WebElement assignment1File3 = driver.findElement(By.xpath("//*[text()='Assignment1']"));
		String aF3 = assignment1File3.getAttribute("value");
		Assert.assertEquals(aF3, "Assignment1");

		// Uploading assignment4 File should be displayed on manage Assignment
		// submissions
		// page
		WebElement assignment1File4 = driver.findElement(By.xpath("//*[text()='Assignment1']"));
		String aF4 = assignment1File4.getAttribute("value");
		Assert.assertEquals(aF4, "Assignment1");

		// Uploading assignment5 File should be displayed on manage Assignment
		// submissions
		// page
		WebElement assignment1File5 = driver.findElement(By.xpath("//*[text()='Assignment1']"));
		String aF5 = assignment1File5.getAttribute("value");
		Assert.assertEquals(aF5, "Assignment1");

		// Selected Assignment GradedBy should be displayed on manage Assignment
		// submissions page
		WebElement AGradedBy = driver.findElement(By.xpath("//*[text()='Staff']"));
		String Agrby = AGradedBy.getAttribute("value");
		Assert.assertEquals(Agrby, "AGradedBy");

		// Selected Assignment Grades should be displayed on manage Assignment
		// submissions page
		WebElement AGrade = driver.findElement(By.xpath("//*[text()='A']"));
		String grade = AGrade.getAttribute("value");
		Assert.assertEquals(grade, "A");

		// added comments should be displayed on manage Assignment submissions page
		WebElement comments = driver.findElement(By.xpath("//*[text()='Excellent Performance']"));
		String commm = comments.getAttribute("value");
		Assert.assertEquals(commm, "Excellent Performance");
		actions.takeScreenshot("Graded_details");

	}

	@When("Admin clicks on Submit button after selecting all the details like Batch,Assignment Name,Assignment Date ,Grade By ,Grade ,add comments")
	public void admin_clicks_on_submit_button_after_selecting_all_the_details_like_batch_assignment_name_assignment_date_grade_by_grade_add_comments() {

		// Admin clicks on submit button
		driver.findElement(By.id("Submit")).click();
	}

	@Then("Grade Details will be visible only to Admin")
	public void grade_details_will_be_visible_only_to_admin() throws IOException {

		// Selected Assignment Grades should be displayed on manage Assignment
		// submissions page
		WebElement AGrade = driver.findElement(By.xpath("//*[text()='A']"));
		String grade = AGrade.getAttribute("value");
		Assert.assertEquals(grade, "A");
		actions.takeScreenshot("GradedDetailsAdminview");

	}
}

