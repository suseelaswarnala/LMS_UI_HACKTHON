package stepdef;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
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
	WebElement present=driver.findElement(By.name("radPresent"));
	WebElement Absent=driver.findElement(By.name("radAbsent"));
	WebElement Late=driver.findElement(By.name("radLate"));
	WebElement Excused=driver.findElement(By.name("radExcused"));
	WebElement Unknown=driver.findElement(By.name("radUnknown"));
	@Given("Admin is on Manage Attendance Admin and Class Staff page")
	public void admin_is_on_manage_attendance_admin_and_class_staff_page() {
		// Admin and Class Staff both can access Attendence page
		
		driver.findElement(By.linkText("Manage Attendance")).click();
		System.out.println("Admin & class staff is accessible to this page");

		
	}

	@When("Admin Selects Batch,Class and Class Date")
	public void admin_selects_batch_class_and_class_date() {
		
		      // Admin Selects Batch on manage Attendence page
				WebElement Batchno = driver.findElement(By.xpath("//Select[@name='selAttendanceBatch']"));
				Select batch = new Select(Batchno);
				batch.selectByVisibleText("SDET01");
				
				//Admin selects Class on manage Attendence page
				WebElement Classno = driver.findElement(By.xpath("//Select[@name='selAttendanceClass']"));
				Select cls = new Select(Classno);
				cls.selectByVisibleText("Selenium");
				
				// Admin selects Class Date on manage Attendence page
				WebElement AssignmentDate = driver.findElement(By.xpath("//Select[@name='txtClassDate']"));
				AssignmentDate.sendKeys("03-24-2022");
				
				//Admin selects radio button on Attendence page
				boolean presentbutton =present.isSelected(); 
				boolean Absentbutton=Absent.isSelected();
				boolean Latebutton=Late.isSelected(); 
				boolean Excusedbutton=Excused.isSelected();
				if(presentbutton == true)
				{
					present.click(); 
				}
				else if(Absentbutton == true)
				{
					Absent.click(); 
					
				}
				else if(Latebutton == true)
				{
					Late.click();
				}
				else if(Excusedbutton == true)
				{
					Excused.click();
				}
				else
				{
					Unknown.click();
				}
				
				
				
	}

	@Then("Student attendance can be viewed succesfully based on the selected criteria")
	public void student_attendance_can_be_viewed_succesfully_based_on_the_selected_criteria() throws IOException {

		//Admin can view student's attendence 
		driver.findElement(By.linkText("Manage Attendance")).click();
		
		
		}
		
	


	@When("Admin clicks on save button after selecting batch and class and marks the student as either Present , Absent , Late, Excused , Unknown")
	public void admin_clicks_on_save_button_after_selecting_batch_and_class_and_marks_the_student_as_either(String string) {
		
		// clicking on the save button
		driver.findElement(By.id("btnSaveAttendance")).click();
	}

	@Then("Student attendance details will be saved  succeesfully")
	public void student_attendance_details_will_be_saved_succeesfully() {
		//Admin can save student's attendence 
		driver.findElement(By.linkText("Manage Attendance")).click();	
	}

	@When("Admin clicks on reset button after selecting batch , class and class date")
	public void admin_clicks_on_reset_button_after_selecting_batch_class_and_class_date() {
		WebElement Batchno = driver.findElement(By.xpath("//Select[@name='selAttendanceBatch']"));
		Select batch = new Select(Batchno);
		batch.selectByVisibleText("SDET01");
		
		//Admin selects Class on manage Attendence page
		WebElement Classno = driver.findElement(By.xpath("//Select[@name='selAttendanceClass']"));
		Select cls = new Select(Classno);
		cls.selectByVisibleText("Selenium");
		driver.findElement(By.id("btnResetAttendance")).click();
		
		
	}

	@Then("Default radio button Unknown will be selected for all the displayed students")
	public void default_radio_button_will_be_selected_for_all_the_displayed_students(String string) {
		
		WebElement Batchno = driver.findElement(By.xpath("//Select[@name='selAttendanceBatch']"));
		Select batch = new Select(Batchno);
		batch.selectByVisibleText("SDET01");
		
		//Admin selects Class on manage Attendence page
		WebElement Classno = driver.findElement(By.xpath("//Select[@name='selAttendanceClass']"));
		Select cls = new Select(Classno);
		cls.selectByVisibleText("Selenium");
		
		// Admin selects Class Date on manage Attendence page
		WebElement AssignmentDate = driver.findElement(By.xpath("//Select[@name='txtClassDate']"));
		AssignmentDate.sendKeys("03-24-2022");
		Unknown.isSelected();
		
	}
	


}
