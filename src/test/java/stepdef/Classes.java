package stepdef;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Classes {

	WebDriver driver;
	public Classes() throws Exception {
		Login login=new Login();
		login.driver=driver;
		}

	@Given("Admin is on Manage Classes Page\\(admin) by clicking on Manage Classes tab")
	public void admin_is_on_manage_classes_page_admin_by_clicking_on_manage_classes_tab() {
		
		driver.findElement(By.linkText("Manage Classes")).click();
	  
	}

	@When("Admin Add a Class to Existing Batch")
	public void admin_add_a_class_to_existing_batch() {
		
		
	  driver.findElement(By.id("Add")).click();
	  //entering class details
	  driver.findElement(By.xpath("//*[text()='txtClasstopic']")).sendKeys("SDET_01");
		
		driver.findElement(By.xpath("//Select[@name='dateClassDate']")).sendKeys("03-24-2022");
		driver.findElement(By.xpath("//Select[@name='selClassStaffname']")).sendKeys("vijaya");
		driver.findElement(By.xpath("//Select[@name='txtClassDescription']")).sendKeys("Locators");
		driver.findElement(By.xpath("//Select[@name='txtClassComments']")).sendKeys("firstclass");
		driver.findElement(By.id("btnEditclassSubmit")).click();
	}

	@Then("Newly Added Class details should display in Manage Classes Page\\(Admin)")
	public void newly_added_class_details_should_display_in_manage_classes_page_admin() {
		
		
	driver.findElement(By.linkText("Manage Classes")).click();
		  
	}

	@When("Admin Edit an existing Class")
	public void admin_edit_an_existing_class() {
		
		
		driver.findElement(By.id("Edit")).click();
        driver.findElement(By.xpath("//*[text()='txtClasstopic']")).sendKeys("SDET_01");
		driver.findElement(By.xpath("//Select[@name='dateClassDate']")).sendKeys("03-25-2022");
		driver.findElement(By.xpath("//Select[@name='selClassStaffname']")).sendKeys("vijaya");
		driver.findElement(By.xpath("//Select[@name='txtClassDescription']")).sendKeys("Locators");
		driver.findElement(By.xpath("//Select[@name='txtClassComments']")).sendKeys("secondclass");
		driver.findElement(By.id("btnEditclassSubmit")).click();
		
		
	    
	}

	@Then("Updated class details should display in Manage Classes Page\\(Admin)")
	public void updated_class_details_should_display_in_manage_classes_page_admin() {
		
		
		driver.findElement(By.linkText("Manage Classes")).click();
		
	
		
	    
	}

	@When("Admin Delete an existing Class")
	public void admin_delete_an_existing_class() {
		driver.findElement(By.linkText("Manage Classes")).click();
		driver.findElement(By.linkText("btnDelClass")).click();
		
		
	    
	}

	@Then("Deleted Class details will be removed from Manage Classes Page\\(Admin)")
	public void deleted_class_details_will_be_removed_from_manage_classes_page_admin() {
		
		driver.findElement(By.linkText("Manage Classes"));
		   
			
	    
	}

	@When("Admin try to view exisiting Class details")
	public void admin_try_to_view_exisiting_class_details() {
	driver.findElement(By.linkText("Manage Classes")).click();
	    
	}

	@Then("All the existing Classes details are displayed in Manage Classes Page\\(Admin)")
	public void all_the_existing_classes_details_are_displayed_in_manage_classes_page_admin() {
		
		driver.findElement(By.linkText("Manage Classes"));
		  
		
	    
	}

	@Given("Admin is on Add tab of Add\\/Edit Classes Page\\(Admin) by clicking on Add Class in Manage Classes page\\(admin)")
	public void admin_is_on_add_tab_of_add_edit_classes_page_admin_by_clicking_on_add_class_in_manage_classes_page_admin() {
		 driver.findElement(By.linkText("Add Class")).click();
		 driver.findElement(By.id("Add")).click();
		  //entering class details
		  driver.findElement(By.xpath("//*[text()='txtClasstopic']")).sendKeys("SDET_01");
			
			driver.findElement(By.xpath("//Select[@name='dateClassDate']")).sendKeys("03-24-2022");
			driver.findElement(By.xpath("//Select[@name='selClassStaffname']")).sendKeys("vijaya");
			driver.findElement(By.xpath("//Select[@name='txtClassDescription']")).sendKeys("Locators");
			driver.findElement(By.xpath("//Select[@name='txtClassComments']")).sendKeys("firstclass");
			
		 
	    
	}

	@When("Admin clicks on submit button after entering the details")
	public void admin_clicks_on_submit_button_after_entering_the_details() {
		
		driver.findElement(By.id("btnEditclassSubmit")).click();
	   
	}

	@Then("Created Classwill be displayed in Manage Classes Page\\(admin)")
	public void created_classwill_be_displayed_in_manage_classes_page_admin() {
		
		driver.findElement(By.linkText("Manage Classes"));
		
			
	}

	@Given("Admin is on Edit tab of Add\\/Edit Classes Page by cliking on Edit icon in Manage Classes page\\(admin)")
	public void admin_is_on_edit_tab_of_add_edit_classes_page_by_cliking_on_edit_icon_in_manage_classes_page_admin() {
		driver.findElement(By.id("btnEditClass")).click();
		
        driver.findElement(By.xpath("//*[text()='txtClasstopic']")).sendKeys("SDET_01");
		driver.findElement(By.xpath("//Select[@name='dateClassDate']")).sendKeys("03-25-2022");
		driver.findElement(By.xpath("//Select[@name='selClassStaffname']")).sendKeys("vijaya");
		driver.findElement(By.xpath("//Select[@name='txtClassDescription']")).sendKeys("Locators");
		driver.findElement(By.xpath("//Select[@name='txtClassComments']")).sendKeys("secondclass");
	
	    
	}

	@When("Admin clicks on submit button after updating class details")
	public void admin_clicks_on_submit_button_after_updating_class_details() {
		
		driver.findElement(By.id("btnEditclassSubmit")).click();
	   
	}

	@Then("Updated Class details will be displayedin Manage Classes Page\\(admin)")
	public void updated_class_details_will_be_displayedin_manage_classes_page_admin() {
		
		
	driver.findElement(By.linkText( "Manage Classes")).click();
		
	}

	@Given("Admin is on Manage Classes Page\\(admin)")
	public void admin_is_on_manage_classes_page_admin() {
		
		
		driver.findElement(By.linkText("Manage Classes")).click();
		
	    
	}

	@When("Admin clicks on Trash icon of existing Class for particular Batch")
	public void admin_clicks_on_trash_icon_of_existing_class_for_particular_batch() {
		driver.findElement(By.linkText("Manage Classes")).click();
		driver.findElement(By.linkText("btnDelClass")).click();
	   
	}

	@Then("Deleted Class will be removed from Manage Classes Page\\(admin)")
	public void deleted_class_will_be_removed_from_manage_classes_page_admin() {
        driver.findElement(By.linkText("Manage Classes"));
		
		
		
	
	    
	}
}
