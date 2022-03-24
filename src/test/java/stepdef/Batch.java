package stepdef;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Batch {
	WebDriver driver;
	public Batch() throws Exception {
		Login login=new Login();
		login.driver=driver;
		}

	WebElement Batches = driver.findElement(By.linkText("Batches"));

	WebElement activeStatus = driver.findElement(By.name("radBatchActiveStatus"));
	WebElement inactiveStatus = driver.findElement(By.name("radBatchInActiveStatus"));

	public int bcount() {
		List<WebElement> BatchesList = driver.findElements(By.linkText("Batches"));
		int count = BatchesList.size();
		return count;

	}

	@Given("Admin is on Manage Batches Page admin screen by clicking on batches tab")
	public void admin_is_on_manage_batches_page_admin_screen_by_clicking_on_batches_tab() {
		{
			// Clicking on batches
			Batches.click();
		}
	}

	@When("Admin Adds Batch to Existing Batch")
	public void admin_adds_batch_to_existing_batch() {
		driver.findElement(By.id("btnAddBatch")).click();
		// Admin enters Batch name, Batch Description, Status
		driver.findElement(By.id("txtBatchName")).sendKeys("SDET 1");
		driver.findElement(By.id("txtBatchDescription")).sendKeys("xyz");
		driver.findElement(By.id(" Active")).click();
		// Admin selects Batch status
		boolean status = activeStatus.isSelected();

		if (status == true) {
			activeStatus.click();
		} else {
			inactiveStatus.click();
		}
		// Admin selects BatchNo.of classes
		driver.findElement(By.id("txtBatchNoClasses")).sendKeys("5");

		// Admin clicks on Submit Button
		driver.findElement(By.id("btnSubmit")).click();

	}

	@Then("Newly Added Batch Details will be displayed in Manage Batches Page Admin")
	public void newly_added_batch_details_will_be_displayed_in_manage_batches_page_admin() {

		int actualcount = bcount();
		Batches.click();
		int expcount = bcount();
		// Asserting Batches List program
		Assert.assertEquals(actualcount + 1, expcount);
	}

	@When("Admin Edits an existing Batch")
	public void admin_edits_an_existing_batch() {

		driver.findElement(By.id("btnEditBatch")).click();
		// Admin enters Batch name
		WebElement Batchno = driver.findElement(By.id("SDET1"));
		Batchno.clear();
		Batchno.sendKeys("SDET 2");

		// Admin selects Batch Description
		WebElement BatchDescription = driver.findElement(By.id("txtBatchDescription"));
		BatchDescription.clear();
		BatchDescription.sendKeys("gsdf");

		// Admin selects Status
		driver.findElement(By.id(" Active")).click();

		// Admin selects Batch status
		boolean status = activeStatus.isSelected();

		if (status == true) {
			activeStatus.click();
		} else {
			inactiveStatus.click();
		}
		// Admin selects BatchNo.of classes
		WebElement noOfClasses = driver.findElement(By.id("txtBatchNoClasses"));
		noOfClasses.clear();
		noOfClasses.sendKeys("5");

		// Admin clicks on Submit Button
		driver.findElement(By.id("btnSubmit")).click();
	}

	@Then("Updated Batch details will be displayed in Manage Batches Page Admin")
	public void updated_batch_details_will_be_displayed_in_manage_batches_page_admin() {
		int actualcount = bcount();
		Batches.click();
		int expcount = bcount();
		// Asserting Batches
		Assert.assertEquals(actualcount, expcount);
	}

	@When("Admin Delete an existing Batch")
	public void admin_delete_an_existing_batch() {

		driver.findElement(By.id("btnDelBatch")).click();
	}

	@Then("Deleted Batch details will be removed from Manage Batches Page Admin")
	public void deleted_batch_details_will_be_removed_from_manage_batches_page_admin() {

		int actualcount = bcount();
		Batches.click();
		int expcount = bcount();
		// Asserting Batches List program
		Assert.assertEquals(actualcount - 1, expcount);
	}

	@When("Admin tries to view exisiting Batch details")
	public void admin_tries_to_view_exisiting_batch_details() {
		driver.findElement(By.linkText("Existing Batch Details")).getText();
	}

	@Then("All the existing Batch details details will be displayed in Manage Batches Page Admin")
	public void all_the_existing_batch_details_details_will_be_displayed_in_manage_batches_page_admin() {
		WebElement SuccessfulMessage = driver.findElement(By.linkText("All Existing Batches Details"));
		String successfulMessage = SuccessfulMessage.getText();
		Assert.assertEquals(successfulMessage, "All Existing Batches Details");
	}

	@Given("Admin is on Add tab of ADD Edit batches page admin by clicking on Add Batch in Manage Batches Page admin")
	public void admin_is_on_add_tab_of_add_edit_batches_page_admin_by_clicking_on_add_batch_in_manage_batches_page_admin() {
		driver.findElement(By.id("Add)")).click();
	}

	@When("Admin clicks on submit button after entering Batch Name Batch Description select Batch Status enters BatchNo. of classes")
	public void admin_clicks_on_submit_button_after_entering_batch_name_batch_description_select_batch_status_enters_batch_no_of_classes() {

		// Admin enters Batch name, Batch Description, Status, BatchNo.of classes and
		// submit Button
		driver.findElement(By.id("txtBatchName")).sendKeys("SDET 1");
		driver.findElement(By.id("txtBatchDescription")).sendKeys("xyz");
		driver.findElement(By.id(" Active")).click();
		boolean status = activeStatus.isSelected();
		if (status == true) {
			activeStatus.click();
		} else {
			inactiveStatus.click();
		}
		driver.findElement(By.id("txtBatchNoClasses")).sendKeys("5");
		driver.findElement(By.id("btnSubmit")).click();

	}

	@Then("Created Batch details will be displayed in Manage Batches Page Admin with auto generated Created Date and Modified date in MM\\\\/DD\\\\/YY format")
	public void created_batch_details_will_be_displayed_in_manage_batches_page_admin_with_auto_generated_created_date_and_modified_date_in_mm_dd_yy_format() {

		int actualcount = bcount();
		Batches.click();
		int expcount = bcount();
		// Asserting Batches List program
		Assert.assertEquals(actualcount + 1, expcount);
	}

	@Given("Admin is on Edit tab of ADD Edit batches page admin by clicking on edit icon")
	public void admin_is_on_edit_tab_of_add_edit_batches_page_admin_by_clicking_on_edit_icon() {
		driver.findElement(By.id("Edit")).click();
	}

	@When("Admin clicks on submit button after updating Batch Name Batch Description select Batch Status Baych No. of classes")
	public void admin_clicks_on_submit_button_after_updating_batch_name_batch_description_select_batch_status_baych_no_of_classes() {

		// Admin enters Batch name, Batch Description, Batch status, BatchNo.of classes,
		// Submit Button

		WebElement Batchname = driver.findElement(By.id("Batch Name"));
		Batchname.clear();
		Batchname.sendKeys("SDET02");

		WebElement batchDescription = driver.findElement(By.id("'BatchDesription"));
		batchDescription.clear();
		batchDescription.sendKeys("asdgvfd");

		boolean status = activeStatus.isSelected();

		if (status == true) {
			activeStatus.click();
		} else {
			inactiveStatus.click();
		}
		driver.findElement(By.id("txtBatchNoClasses")).sendKeys("8");
		driver.findElement(By.id("btnSubmit")).click();

	}

	@Then("Updated Batch details will be displayed in Manage Batches Page Admin screen with same autogenerated creation date and  different Modified date in MM\\/DD\\/YY format")
	public void updated_batch_details_will_be_displayed_in_manage_batches_page_admin_screen_with_same_autogenerated_creation_date_and_different_modified_date_in_mm_dd_yy_format() {
		// Edited Batch Name should be displayed
		boolean isElementDisplayed = driver.findElement(By.xpath("//*[text()='SDET02']")).isDisplayed();
		Assert.assertEquals(isElementDisplayed, "Selenium_1");
	}

	@Given("Admin is on Manage Batches Page admin screen")
	public void admin_is_on_manage_batches_page_admin_screen() {
		{
			Batches.click();

		}
	}

	@When("Admin clicks on particular batch trash icon")
	public void admin_clicks_on_particular_batch_trash_icon() {
		driver.findElement(By.id("btnDelBatch")).click();
	}

	@Then("Batch will be deleted from the Batches List in Manage Batches Page admin")
	public void batch_will_be_deleted_from_the_batches_list_in_manage_batches_page_admin() {

		int actualcount = bcount();
		Batches.click();
		int expcount = bcount();
		// Asserting Batches List program
		Assert.assertEquals(actualcount - 1, expcount);
	}
	
	}