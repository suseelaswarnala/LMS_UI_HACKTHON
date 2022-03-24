package stepdef;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Users  {
	WebDriver driver;
	public Users() throws Exception {
		Login login=new Login();
		login.driver=driver;
		}
	@Given("Admin is on LMS Admin User Page")
	public void admin_is_on_lms_admin_user_page() {
		
		 { 
			 driver.findElement(By.linkText("LMS Admin User Page")).getText();
	     }
	}
	@When("Admin clicks on search button after entering Email or Batch or Skill or program")
	public void admin_clicks_on_search_button_after_entering_email_or_batch_or_skill_or_program() {
		
		// Admin entering  Email field
		WebElement txtUserEmail = driver.findElement(By.id("UserEmail"));
		txtUserEmail.sendKeys();
		
		// Admin clicks on search button after entering Batch 
		WebElement selUserBatch = driver.findElement(By.id("Batch"));
		Select Batch = new Select(selUserBatch);
		Batch.selectByVisibleText("04");

		//Admin clicks on search button after entering  Skill  
		WebElement selUserSkill= driver.findElement(By.id("Skill"));
		Select Skill = new Select(selUserSkill);
		Skill.selectByVisibleText("Python");
		
		//Admin clicks on search button after entering  program
		WebElement selUserProgram= driver.findElement(By.id("program"));
		Select program = new Select(selUserProgram);
		program.selectByVisibleText("SDET");
	
		//Admin clicks on search button 
		WebElement btnSearch =driver.findElement(By.id("Search"));
		btnSearch.click();		
	}

	@Then("Admin will be navigated to Manage users admin page and Registered User list will be displayed")
	public void admin_will_be_navigated_to_manage_users_admin_page_and_registered_user_list_will_be_displayed() {
	driver.findElement(By.linkText("Manage users admin Registered Users list")).getText();
		
	}
	@Given("Admin is on Manage users admin page Registered User list and clicks on edit icon")
	public void admin_is_on_manage_users_admin_page_registered_user_list_and_clicks_on_edit_icon() {
		 {
			 WebElement btnEditRegUsers = driver.findElement(By.id( "Edit"));
			 btnEditRegUsers.click();
	     }
	}

//	@When("Admin will be navigated to Manage user admin page Unregistered User list will be displayed")
//	public void admin_will_be_navigated_to_manage_users_admin_page_where_user_details_will_be_displayed() {
//		{
//			 driver.findElement(By.linkText("//a[contains(text(),'where User details displayed']")).getText();
//		}
//	}

//	@Then("Admin will be able to edit User details like Time zone User role batch Program and click on save")
//	public void admin_will_be_able_to_edit_user_details_like_time_zone_user_role_batch_program_and_click_on_save() {
//
//		//Admin selects Timezone from Manage user(Admin) page
//		WebElement selUserTimeZone= driver.findElement(By.name("'Timezone"));
//		Select se4 = new Select(selUserTimeZone);
//		se4.selectByVisibleText("EST");
//		
//		//Admin selectsUser role from Manage user(Admin) page
//				WebElement selUserRoleName= driver.findElement(By.name("User role"));
//				Select se5 = new Select(selUserRoleName);
//				se5.selectByVisibleText("User");
//		
//
//		//Admin selects Batch from Manage user(Admin) page
//						WebElement selBatchName= driver.findElement(By.name("Batch"));
//						Select se6 = new Select(selBatchName);
//						se6.selectByVisibleText("None");
//						
//		//Admin selects program from Manage user(Admin) page
//						WebElement selProgramName= driver.findElement(By.name("program"));
//						Select se7 = new Select(selProgramName);
//						se7.selectByVisibleText("None");
//		
//						
//		//Admin clicks on save button from Manage user(Admin) page
//						WebElement btnSave=driver.findElement(By.id("save"));
//						 btnSave.click();
//	}

	@Given("Admin is on Manage users admin page Registered Users list")
	public void admin_is_on_manage_users_admin_page_registered_users_list() {
		{
			 driver.findElement(By.linkText(" Manage Users admin registered Users list']")).getText();
		}
	}

	@When("Admin clicks on trash icon of particular registered user")
	public void admin_clicks_on_trash_icon_of_particular_registered_user() {
		{
			WebElement  btnDelRegUsers =driver.findElement(By.id( "delete"));
		 btnDelRegUsers.click();
		}
	}
	

	@Then("Deleted registered user will be removed from Registered users list")
	public void deleted_registered_user_will_be_removed_from_registered_users_list() {
			WebElement SuccessfulMessage = driver
					.findElement(By.linkText("Registered user is deleted succesfully"));
			String successfulMessage = SuccessfulMessage.getText();
			Assert.assertEquals(successfulMessage, "Registered user is deleted succesfully");

	}

	@When("Admin clicks on eye icon for particular user")
	public void admin_clicks_on_eye_icon_for_particular_user() {
		WebElement btnViewRegUsers =driver.findElement(By.id( "view"));
	  btnViewRegUsers.click();
	}

	@Then("Admin will be navigated to Manage users admin page and view the User details only in read only format")
	public void admin_will_be_navigated_to_manage_users_admin_page_and_view_the_user_details_only_in_read_only_format() {
		driver.findElement(By.linkText("Read Only Format")).getText();
	}

	@When("Admin clicks on New Unassigned User hyperlink")
	public void admin_clicks_on_new_unassigned_user_hyperlink() {
		
		 driver.findElement(By.linkText( "New Unassigned Users ")).click();
	    
	}

	@Then("Admin will be navigated to Manage user admin page Unregistered User list will be displayed")
	public void admin_will_be_navigated_to_manage_user_admin_page_unregistered_user_list_will_be_displayed() {
		driver.findElement(By.linkText("Unregistered Users list")).getText();
	
	}

	//@Given("Admin is on  Manage user\\(admin) page, Unregistered User list")
	//public void admin_is_on_manage_user_admin_page_unregistered_user_list() {}

	@When("Admin clicks on edit icon of particular unregistered user and admin will be navigated to manage users admin page")
	public void admin_clicks_on_edit_icon_of_particular_unregistered_user_and_admin_will_be_navigated_to_manage_users_admin_page() {
		WebElement btnEditUsers=driver.findElement(By.id("manage users"));
        btnEditUsers.click();
	}

	@Then("Admin will be able to edit User details like Time zone User role batch Program and click on save")
	public void admin_will_be_able_to_edit_user_details_like_time_zone_user_role_batch_program_and_click_on_save() {
		//Admin selects Timezone from Manage user(Admin) page
				WebElement selUserTimeZone= driver.findElement(By.id("Timezone"));
				Select se4 = new Select(selUserTimeZone);
				se4.selectByVisibleText("EST");
				
		//Admin selectsUser role from Manage user(Admin) page
				WebElement selUserRoleName= driver.findElement(By.id("User role"));
				Select se5 = new Select(selUserRoleName);
				se5.selectByVisibleText("User");
				

		//Admin selects Batch from Manage user(Admin) page
				WebElement selBatchName= driver.findElement(By.id("Batch"));
				Select se6 = new Select(selBatchName);
				se6.selectByVisibleText("None");
								
		//Admin selects program from Manage user(Admin) page
				WebElement selProgramName= driver.findElement(By.id("program"));
				Select se7 = new Select(selProgramName);
				se7.selectByVisibleText("None");
				
								
		//Admin clicks on save button from Manage user(Admin) page
				WebElement btnSave= driver.findElement(By.id("save"));
			     btnSave.click();
	}
	
	@When("Admin clicks on trash icon of particular unregistered user")
	public void admin_clicks_on_trash_icon_of_particular_unregistered_user() {
		WebElement btnDelUsers =driver.findElement(By.id( "delete"));
		 btnDelUsers.click();
	}

	@Then("Deleted unregistered user will be removed from Unregistered users list")
	public void deleted_unregistered_user_will_be_removed_from_unregistered_users_list() {
		WebElement SuccessfulMessage = driver
				.findElement(By.linkText("//h4[contains(text(),'Unregistered user is deleted succesfully'"));
		String successfulMessage = SuccessfulMessage.getText();
		Assert.assertEquals(successfulMessage, "Unregistered user is deleted succesfully");
	}	
	
	@When("Admin will be navigated to Manage users admin page where User details will be displayed")
	public void admin_will_be_navigated_to_manage_users_admin_page_where_user_details_will_be_displayed() {
		 driver.findElement(By.linkText("//a[contains(text(),'where User details displayed']")).getText();
	}

	@Given("Admin is on Manage user admin page Unregistered User list")
	public void admin_is_on_manage_user_admin_page_unregistered_user_list() {
		driver.findElement(By.linkText(" Manage Users admin unregistered Users list']")).getText();
	   
	}

	
	

	
}
