package stepdef;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Pagination {
	WebDriver driver;
	Properties properties;
	List<WebElement> Students = driver.findElements(By.cssSelector("User Email"));
    List<String> names = new ArrayList<String>();
    
	public Pagination() throws Exception {
		Login login=new Login();
		login.driver=driver;
		}

	@Given("Admin is on Manage users admin page of User list Unregistered")
	
	public void admin_is_on_manage_users_admin_page_of_user_list_unregistered() {
	//Admin is on manage user list unregistered page
		driver.get(properties.getProperty("manage_user"));
	    
	}

	@When("result is containing many  Student records")
	public void result_is_containing_many_student_records() throws Exception {
		// didplay records of student by User email
		
		   //Adding column1 elements to the list
		   for (WebElement nameEle : Students) {
		    names.add(nameEle.getText());
		   }
		   //Displaying the list elements on console
		   for (WebElement s : Students) {
			   System.out.println(s.getText());
		      }
		  	  
	}

	
	@Then("Large number of Student records will be divided into smaller discrete pages")
	public void large_number_of_student_records_will_be_divided_into_smaller_discrete_pages() throws Exception {
		 //locating next button
		 String nextButtonClass = driver.findElement(By.id("example_next")).getAttribute("class");
		 //traversing through the table until the last button and adding names to the list defined about
		   while (!nextButtonClass.contains("disabled")) {
		    driver.findElement(By.id("example_next")).click();
		    Thread.sleep(1000);
		    Students = driver.findElements(By.cssSelector(""));
		    for (WebElement nameEle : Students) {
		     names.add(nameEle.getText());
		    }
		    nextButtonClass = driver.findElement(By.id("example_next")).getAttribute("class");
		   }
	   
	}

	@Given("Admin is on  Manage Attendance Admin and Class Staff page ogf Manage Attendance admin")
	public void admin_is_on_manage_attendance_admin_and_class_staff_page_ogf_manage_attendance_admin() {
		
	      driver.get(properties.getProperty("manage_attendence"));
		

		
	   
	}
}
