package stepdef;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

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
		
		Select prog = new Select(driver.findElement(By.xpath("//select[@name=’Program Name’]")));
	      //getting the list of options in the dropdown with getOptions()
	      List <WebElement> op = prog.getOptions();
	      int size = op.size();
	      for(int i =0; i<size ; i++){
	         String options = op.get(i).getText();
	         System.out.println(options);
	      }
	      
	      //admin enters Hackathon Name
	      WebElement h = driver.findElement(By.name("q"));
	      String st = h.getAttribute("Hackathon Name");
	      
	    //admin enters Hackathon Description
	      WebElement desc = driver.findElement(By.name("d"));
	      String st1 = desc.getAttribute("Hackathon Description");
	      
	      //admin selects date from date picker
	      WebElement datepick = driver.findElement(By.xpath("//form//input[@name='hackathonDate']"));
	      datepick.sendKeys("03242022");
	      
	    //admin enters Hackathon Comments
	      WebElement hComment = driver.findElement(By.name("comment"));
	      String st2 = hComment.getAttribute("Hackathon Description");
	      
	      //admin hits the submit button
	      driver.findElement(By.id("submit1")).submit();
		
		
	}

	@Then("Notifications will be submitted successfully")
	public void notifications_will_be_submitted_successfully() {
	    
		//notification will be submitted successfully
System.out.println("Notifications will be submitted successfully");	
		
		WebElement NotificationMessage = driver.findElement(By.cssSelector("//h4[contains(text(),'Notifications will be submitted successfully'"));
		String successfulMessage = NotificationMessage.getText();
		Assert.assertEquals(successfulMessage, "Notifications will be submitted successfully");
		}
	}


