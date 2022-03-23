package stepdef;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResourceandRecord {
	WebDriver driver;
	public ResourceandRecord() throws Exception {
		Login login=new Login();
		login.driver=driver;
		}

	@Given("Admin is on Manage Recording\\(Admin) page by clicking Manage Recordings tab")
	public void admin_is_on_manage_recording_admin_page_by_clicking_manage_recordings_tab() {
		
		
		driver.findElement(By.linkText("Manage Recordings")).click();
		
	    
	}

	@When("Admin upload recording after selecting Batch and topic")
	public void admin_upload_recording_after_selecting_batch_and_topic() {
		
		//batch selection 
		Select batchNo = new Select(driver.findElement(By.name("Batch")));
		batchNo.selectByVisibleText("SDET 02");
		//declare instance of select class 
		Select topic = new Select(driver.findElement(By.name("Topic")));
		batchNo.selectByVisibleText("Selenium");
		//for clicking recording 
		Select rec = new Select(driver.findElement(By.name("Recording")));
		driver.findElement(By.linkText("Upload")).click();
	    
	}

	@Then("Uploaded recording will be displayed in Manage Classes page\\(Admin View) for selected topic")
	public void uploaded_recording_will_be_displayed_in_manage_classes_page_admin_view_for_selected_topic() {
	   WebElement Display =driver.findElement(By.linkText("Manage Classes page\\(Admin View"));
	   //WebElement display=Display;
		Assert.assertEquals(Display,"Uploaded records will be displayed in manage classes page");
	}

	@When("Admin upload resources after selecting Batch and topic")
	public void admin_upload_resources_after_selecting_batch_and_topic() {
		
		//batch selection
		Select batchNo = new Select(driver.findElement(By.name("Batch")));
		batchNo.selectByVisibleText("SDET 02");
		//declare instance of select class 
		Select topic = new Select(driver.findElement(By.name("Topic")));
		topic.selectByVisibleText("Selenium");
		//declare instance of select class 
		Select res = new Select(driver.findElement(By.name("Resources")));
		driver.findElement(By.linkText("Upload")).click();

	   
	}

	@Then("Upload resources will be displayed in  for selected topic")
	public void upload_resources_will_be_displayed_in_manage_classes_page_admin_view_for_selected_topic() {
		  WebElement Display =driver.findElement(By.linkText("Manage Classes page\\(Admin View"));
		   //WebElement display=Display;
			Assert.assertEquals(Display,"Uploaded resources will be displayed in manage classes page");
		}

	    
	}
