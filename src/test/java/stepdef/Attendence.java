package stepdef;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Attendence {

	WebDriver driver;

	public Attendence() throws Exception {
		Login login=new Login();
		login.driver=driver;
		}

	@Given("Admin is on Manage Attendance\\(Admin and Class Staff) page")
	public void admin_is_on_manage_attendance_admin_and_class_staff_page() {
		// Admin and Class Staff both can access Attendence page
		
		driver.findElement(By.linkText("Manage Assignment")).click();
		System.out.println("Admin & class staff is accessible to this page");

		
	}

	@When("Admin Selects Batch,Class and Class Date")
	public void admin_selects_batch_class_and_class_date() {
		
		      // Admin Selects Batch on manage Attendence page
				WebElement Batchno = driver.findElement(By.xpath("//Select[@name='Batch']"));
				Select batch = new Select(Batchno);
				batch.selectByVisibleText("SDET01");
				
				//Admin selects Class on manage Attendence page
				WebElement Classno = driver.findElement(By.xpath("//Select[@name='Class']"));
				Select cls = new Select(Classno);
				cls.selectByVisibleText("Selenium");
				
				// Admin selects Class Date on manage Attendence page
				WebElement AssignmentDate = driver.findElement(By.xpath("//Select[@name='AssignmentDate']"));
				AssignmentDate.sendKeys("03-24-2022");
				
				//Admin selects radio button on Attendence page
				
				
				
				
	}

	@Then("Student attendance can be viewed succesfully based on the selected criteria")
	public void student_attendance_can_be_viewed_succesfully_based_on_the_selected_criteria() throws IOException {

		//Admin can view student's attendence 
		System.out.println("Admin can view student's attendence successfully");	
		
		WebElement SuccessfulMessage = driver
		.findElement(By.cssSelector("//h4[contains(text(),'Admin can view student's attendence successfully'"));
		String successfulMessage = SuccessfulMessage.getText();
		Assert.assertEquals(successfulMessage, "Admin can view student's attendence successfully");
		}
		
	


	@When("Admin clicks on save button after selecting batch and class and marks the student as either {string}.")
	public void admin_clicks_on_save_button_after_selecting_batch_and_class_and_marks_the_student_as_either(String string) {
		
		// clicking on the save button
		driver.findElement(By.id("Save")).click();
	}

	@Then("Student attendance details will be saved  succeesfully .")
	public void student_attendance_details_will_be_saved_succeesfully() {
		//Admin can save student's attendence 
				System.out.println("Admin can save student's attendence successfully");	
	}

	@When("Admin clicks on reset button after selecting batch , class and class date")
	public void admin_clicks_on_reset_button_after_selecting_batch_class_and_class_date() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Default radio button {string} will be selected for all the displayed students.")
	public void default_radio_button_will_be_selected_for_all_the_displayed_students(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}


}
