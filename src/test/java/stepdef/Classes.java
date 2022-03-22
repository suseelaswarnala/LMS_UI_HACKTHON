package stepdef;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Classes extends Login {

	
	public Classes() throws Exception {
		super();
		
	}

	@Given("Admin is on Manage Classes Page\\(admin) by clicking on Manage Classes tab")
	public void admin_is_on_manage_classes_page_admin_by_clicking_on_manage_classes_tab() {
		
		driver.findElement(By.linkText("Manage Classes")).click();
	  
	}

	@When("Admin Add a Class to Existing Batch")
	public void admin_add_a_class_to_existing_batch() {
		
		
	  driver.findElement(By.id("btnAddClass")).click();
	}

	@Then("Newly Added Class details should display in Manage Classes Page\\(Admin)")
	public void newly_added_class_details_should_display_in_manage_classes_page_admin() {
		
		
		
		
		driver.findElement(By.name("txtClassTopic")).sendKeys("BDD Cucumber");
		
		//instance of element is datebox
		
		   WebElement dateBox = driver.findElement(By.xpath("//form//input[@name='dateClassDate']"));

	        //Fill date as mm/dd/yyyy as 03/20/2022
           dateBox.sendKeys("03202022");
           
        Select staffname = new Select(driver.findElement(By.name("selClassStaffname")));
   		staffname.selectByVisibleText("Staff1");
		driver.findElement(By.name("TxtClassDesc")).sendKeys("  ");
		driver.findElement(By.name("TxtClassComments")).sendKeys(" ");
		
		driver.findElement(By.linkText("btnEditClass")).click();
		
	  
	}

	@When("Admin Edit an existing Class")
	public void admin_edit_an_existing_class() {
		
		
		driver.findElement(By.id("btnEdit")).click();
		
		
	    
	}

	@Then("Updated class details should display in Manage Classes Page\\(Admin)")
	public void updated_class_details_should_display_in_manage_classes_page_admin() {
		
		
	driver.findElement(By.id("txtClassTopic")).sendKeys("Selenium");
		
		//instance of element is datebox
		
		   WebElement dateBox = driver.findElement(By.xpath("//form//input[@name='dateClassDate']"));

	        //Fill date as mm/dd/yyyy as 03/20/2022
           dateBox.sendKeys("09162021");
           
        Select staffname = new Select(driver.findElement(By.name("selClassStaffname")));
   		staffname.selectByVisibleText("Staff1");
		//driver.findElement(By.id("TxtClassDesc")).sendKeys("  ");
		//driver.findElement(By.id("TxtClassComments")).sendKeys(" ");
		
	
		
	    
	}

	@When("Admin Delete an existing Class")
	public void admin_delete_an_existing_class() {
		driver.findElement(By.linkText("Manage Classes")).click();
		driver.findElement(By.linkText("delbtn")).click();
		
		
	    
	}

	@Then("Deleted Class details will be removed from Manage Classes Page\\(Admin)")
	public void deleted_class_details_will_be_removed_from_manage_classes_page_admin() {
		
		WebElement Del =driver.findElement(By.linkText("Manage Classes page\\(Admin View"));
		   
			Assert.assertEquals(Del,"Deleted Class details will be removed from Manage Classes Page\\\\(Admin)");
	    
	}

	@When("Admin try to view exisiting Class details")
	public void admin_try_to_view_exisiting_class_details() {
	driver.findElement(By.linkText("Manage Classes")).click();
	    
	}

	@Then("All the existing Classes details are displayed in Manage Classes Page\\(Admin)")
	public void all_the_existing_classes_details_are_displayed_in_manage_classes_page_admin() {
		
		WebElement Dis =driver.findElement(By.linkText("Manage Classes page\\(Admin View"));
		  
		Assert.assertEquals(Dis,"All the existing Classes details are displayed in Manage Classes Page\\\\(Admin)");
	    
	}

	@Given("Admin is on Add tab of Add\\/Edit Classes Page\\(Admin) by clicking on Add Class in Manage Classes page\\(admin)")
	public void admin_is_on_add_tab_of_add_edit_classes_page_admin_by_clicking_on_add_class_in_manage_classes_page_admin() {
		 driver.findElement(By.linkText("Add")).click();
	    
	}

	@When("Admin clicks on submit button after entering the details")
	public void admin_clicks_on_submit_button_after_entering_the_details() {
		
		driver.findElement(By.linkText("btnEditClassSubmit")).click();
	   
	}

	@Then("Created Classwill be displayed in Manage Classes Page\\(admin)")
	public void created_classwill_be_displayed_in_manage_classes_page_admin() {
		
		WebElement clasDis =driver.findElement(By.linkText("Manage Classes page\\(Admin View"));
		  
		Assert.assertEquals(clasDis,"All the existing Classes details are displayed in Manage Classes Page\\\\(Admin)");
		
	}

	@Given("Admin is on Edit tab of Add\\/Edit Classes Page by cliking on Edit icon in Manage Classes page\\(admin)")
	public void admin_is_on_edit_tab_of_add_edit_classes_page_by_cliking_on_edit_icon_in_manage_classes_page_admin() {
		driver.findElement(By.id("btnEdit")).click();
	    
	}

	@When("Admin clicks on submit button after updating class details")
	public void admin_clicks_on_submit_button_after_updating_class_details() {
		
		driver.findElement(By.id("txtClassTopic")).sendKeys("BDD Cucumber");
	   
	}

	@Then("Updated Class details will be displayedin Manage Classes Page\\(admin)")
	public void updated_class_details_will_be_displayedin_manage_classes_page_admin() {
		
		
	WebElement Displaydet =driver.findElement(By.linkText( "Manage Classes page"));
	Displaydet.click();
	//	WebElement displaydet=Displaydet;
	   // Assert.assertEquals(displaydet,"Updated Class details will be displayedin Manage Classes Page\\\\(admin)");
	
	}

	@Given("Admin is on Manage Classes Page\\(admin)")
	public void admin_is_on_manage_classes_page_admin() {
		
		
		driver.findElement(By.linkText("Manage Classes Page")).click();
		
	    
	}

	@When("Admin clicks on Trash icon of existing Class for particular Batch")
	public void admin_clicks_on_trash_icon_of_existing_class_for_particular_batch() {
		driver.findElement(By.linkText("Manage Classes")).click();
		driver.findElement(By.linkText("delbtn")).click();
	   
	}

	@Then("Deleted Class will be removed from Manage Classes Page\\(admin)")
	public void deleted_class_will_be_removed_from_manage_classes_page_admin() {
		WebElement det =driver.findElement(By.linkText("Manage Classes"));
		//WebElement displaydet=Displaydet;
	    Assert.assertEquals(det,"Deleted Class will be removed from Manage Classes Page admin");
		
		
	
	    
	}
}
