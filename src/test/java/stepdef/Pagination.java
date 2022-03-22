package stepdef;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination extends Login{
	public Pagination() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Given("Admin is on Manage users admin page of User list Unregistered")
	
	public void admin_is_on_manage_users_admin_page_of_user_list_unregistered() {
	//	WebDriver driver;
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.LMS-UI.com/login");
		
		driver.findElement(By.linkText("Manage Classes")).click();
		
	
		String nextButtonClassname = driver.findElement(By.id("example_next")).getAttribute("class");
		
		while(!nextButtonClassname.contains("disabled"))
			
		{
			driver.findElement(By.id("example_next")).click();
			
			
		}
		
	    
	}

	@When("result is containing many  Student records")
	public void result_is_containing_many_student_records() {
		  WebElement Studentrec =driver.findElement(By.linkText("Manage Classes"));
		   WebElement studentrec=Studentrec;
			Assert.assertEquals(studentrec,"result is containing many  Student records");
		}

	   
	

	@Then("Large number of Student records will be divided into smaller discrete pages")
	public void large_number_of_student_records_will_be_divided_into_smaller_discrete_pages() {
		
		WebElement Studentrec =driver.findElement(By.linkText("Manage Classes"));
	   // WebElement studentrec=Studentrec;
	    Assert.assertEquals(Studentrec,"Large number of Student records will be divided into smaller discrete pages");
	   
	}

	@Given("Admin is on  Manage Attendance Admin and Class Staff page ogf Manage Attendance admin")
	public void admin_is_on_manage_attendance_admin_and_class_staff_page_ogf_manage_attendance_admin() {
		
		
		driver.findElement(By.linkText("Manage Attendance (Admin and  Class Staff)\r\n"+ " ")).click();
		
        String nextButtonClassname = driver.findElement(By.id("example_next")).getAttribute("class");
		
		while(!nextButtonClassname.contains("disabled"))
			
		{
			driver.findElement(By.id("example_next")).click();
			
			
		}
		
	   
	}
}
