package stepdef;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Submitnotification {
	WebDriver driver;
	public Submitnotification() throws Exception {
		Login login=new Login();
		login.driver=driver;
		}
	@Given("Admin is on  Notification page")
	public void admin_is_on_notification_page() {
		
	    //admin is on notification page
		driver.findElement(By.linkText("Notifications")).click();
		System.out.println("Admin is on notificcation page");
	}

	@When("Admin clicks on submit button after selectingProgram Name from dropdown and enter details  Hackathon Name,hackathon description,Hackathon date and Hackathon comments")
	public void admin_clicks_on_submit_button_after_selecting_program_name_from_dropdown_and_enter_details_hackathon_name_hackathon_description_hackathon_date_and_hackathon_comments() {
	    
		//admin selects Program Name from dropdown
		
		Select prog = new Select(driver.findElement(By.xpath("//select[@name=’selNotificationPgmName’]")));
	      //getting the list of options in the dropdown with getOptions()
	      List <WebElement> programs = prog.getOptions();
	      int size = programs.size();
	      for(int i =0; i<size ; i++){
	         String options = programs.get(i).getText();
	         System.out.println(options);
	      }
	      
	      //admin enters Hackathon Name
	      driver.findElement(By.name("txtHackthonName")).sendKeys("Hackthon");
	          
	    //admin enters Hackathon Description
	       driver.findElement(By.name("txtHackthonDesc")).sendKeys("Nov Hackthon");
	         
	      //admin selects date from date picker
	       driver.findElement(By.name("txtHackathonDate")).sendKeys("3/24/2022");
	      
	      
	    //admin enters Hackathon Comments
	       driver.findElement(By.name("txtHackthonComments")).sendKeys("Comments");
	           
	      //admin hits the submit button
	      driver.findElement(By.id("bthSaveNotification")).click();
		
		
	}

	@Then("Notifications will be submitted successfully")
	public void notifications_will_be_submitted_successfully() {
	    
		//notification will be submitted successfully
		driver.findElement(By.linkText("Notifications")).click();
	}
	}


