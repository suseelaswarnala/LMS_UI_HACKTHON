package stepdef;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import LMS_UI_Utils.lms_excelreader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Programs {
	WebDriver driver;
	 lms_excelreader excelreader;
	
	 
		public Programs() throws Exception {
			Login login=new Login();
			login.driver=driver;
			}
	
	String programDate;
	WebElement program=driver.findElement(By.xpath("//Select[@name='Programs']"));
	WebElement programName=driver.findElement(By.name("txtProgramName"));
	WebElement programDescription=driver.findElement(By.name("txtProgramDescription"));
	WebElement activeStatus=driver.findElement(By.name("radPrgmActiveStatus"));
	WebElement inactiveStatus=driver.findElement(By.name("radPrgmInActiveStatus"));
	Properties properties;
	String sheetProgram=properties.getProperty("sheetProgram");
	
	@Given("Admin is on Manage Programs Page admin by clicking on Programs Tab")
	public void admin_is_on_manage_programs_page_admin_by_clicking_on_programs_tab() {
		//landing on programs page
		program.click();
		String programs=properties.getProperty("programs");
		driver.get(programs);
		    
	}

	@When("Admin Add a program to Existing programs list")
	public void admin_add_a_program_to_existing_programs_list() throws Exception {
		//finding and addprorogram button and clicking
		WebElement Addprogram=driver.findElement(By.name("btnAddProgram"));
		Addprogram.click();
		//admin land on Add/Edit program page
		driver.get(properties.getProperty("AddEditprograms"));
		WebElement Add=driver.findElement(By.linkText("Add"));
		Add.click();
		//admin entering program name
		programName.sendKeys(excelreader.getcelldata(sheetProgram, 1, 0));
		programDescription.sendKeys(excelreader.getcelldata(sheetProgram, 1, 1));
		//radio button selection
		boolean status ;      
		status = activeStatus.isSelected();   
		 
		if(status == true)
		{
			activeStatus.click(); 
		}
		else
		{
			inactiveStatus.click(); 
		}
		//admin clicks on submit button
		
		WebElement programSubmit=driver.findElement(By.name("btnProgramSubmit"));
		programSubmit.click();
	}

	@Then("Newly Added program details will be displayed in Manage Programs Page admin")
	public void newly_added_program_details_will_be_displayed_in_manage_programs_page_admin() {
		int actualcount=count();
		program.click();
		int expcount=count();
		//Asserting programlist  program
		Assert.assertEquals(actualcount+1, expcount);
	    
	}

	@When("Admin Edits an existing program")
	public void admin_edits_an_existing_program() throws Exception {
		WebElement Editprogram=driver.findElement(By.name("btnEditProgram"));
		Editprogram.click();
		//admin land on Add/Edit program page
		driver.get(properties.getProperty("AddEditprograms"));
		WebElement Edit=driver.findElement(By.linkText("Edit"));
		Edit.click();
		//admin entering program Details
		programName.sendKeys(excelreader.getcelldata(sheetProgram, 2, 0));
		programDescription.sendKeys(excelreader.getcelldata(sheetProgram, 2, 1));
		boolean status ;      
		status = activeStatus.isSelected();   
		 
		if(status == true)
		{
			activeStatus.click(); 
		}
		else
		{
			inactiveStatus.click(); 
		}
		
		WebElement programSubmit=driver.findElement(By.name("btnProgramSubmit"));
		programSubmit.click();
	   
	}

	@Then("Updated program details will be displayed in Manage Programs Page admin")
	public void updated_program_details_will_be_displayed_in_manage_programs_page_admin() {
		int actualcount=count();
		program.click();
		int expcount=count();
		//Asserting programlist  program
		Assert.assertEquals(actualcount, expcount);
	    
	}

	@When("Admin Delete an existing program")
	public void admin_delete_an_existing_program() {
		WebElement Deleteprogram=driver.findElement(By.name("btnDelProgram"));
		Deleteprogram.click();
		
	}

	@Then("Deleted program details will be removed from Manage Programs Page admin")
	public void deleted_program_details_will_be_removed_from_manage_programs_page_admin() {
		// getting programlist size by programName
		int actualcount=count();
		program.click();
		int expcount=count();
		//asserting count of programName list
		Assert.assertEquals(actualcount-1, expcount);
	}

	@When("Admin tries to view exisiting program  details")
	public void admin_tries_to_view_exisiting_program_details() {
		//admin clicking programs tab
		program.click();
	}

	@Then("All the existing program details will be displayed in Manage Programs Page admin")
	public void all_the_existing_program_details_will_be_displayed_in_manage_programs_page_admin() {
		//admin clicking programs tab
		program.click();
	    
	}

	@Given("Admin is on Add tab in Add Edit Programs page by clicking Add Program in Manage Programs Page admin")
	public void admin_is_on_add_tab_in_add_edit_programs_page_by_clicking_add_program_in_manage_programs_page_admin() throws Exception {
		WebElement Addprogram=driver.findElement(By.name("btnAddProgram"));
		Addprogram.click();
		//admin land on Add/Edit program page
		driver.get(properties.getProperty("AddEditprograms"));
		WebElement Add=driver.findElement(By.linkText("Add"));
		Add.click();
		//admin entering program name and program description
		programName.sendKeys(excelreader.getcelldata(sheetProgram, 1, 0));
		programDescription.sendKeys(excelreader.getcelldata(sheetProgram, 1, 1));
		//radio button selection
		boolean status ;      
		status = activeStatus.isSelected();   
		if(status == true)
		{
			activeStatus.click(); 
		}
		else
		{
			inactiveStatus.click(); 
			
		}
		//admin getting system date
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("MM/DD/YY HH:MM");  
		programDate = dateFormat.format(date); 
		excelreader.setcelldata(sheetProgram, 1, 2,programDate);
			
	}

	@When("Admin clicks on submit button after entering the Program Name Program Description Program Status")
	public void admin_clicks_on_submit_button_after_entering_the_program_name_program_description_program_status() {
		//admin clicks on SAubmit button
		WebElement programSubmit=driver.findElement(By.name("btnProgramSubmit"));
		programSubmit.click();
	}

	@Then("All the program details will be added to Programs List in Manage Programs Page admin with auto generated same ProgramCreationtime and ProgramModifiedtime in MM\\/DD\\/YY HH:MM format")
	public void all_the_program_details_will_be_added_to_programs_list_in_manage_programs_page_admin_with_auto_generated_same_program_creationtime_and_program_modifiedtime_in_mm_dd_yy_hh_mm_format() {
		int actualcount=count();
		program.click();
		int expcount=count();
		//Asserting programlist after adding new program
		Assert.assertEquals(actualcount+1, expcount);
		
	}

	@Given("Admin is on Edit tab in Add Edit Programs page by clicking Edit icon in Manage Programs Page admin")
	public void admin_is_on_edit_tab_in_add_edit_programs_page_by_clicking_edit_icon_in_manage_programs_page_admin() throws Exception {
		WebElement Editprogram=driver.findElement(By.name("btnEditProgram"));
		Editprogram.click();
		//admin land on Add/Edit program page
		driver.get(properties.getProperty("AddEditprograms"));
		WebElement Edit=driver.findElement(By.linkText("Edit"));
		Edit.click();
		//admin entering program Details
		programName.sendKeys(excelreader.getcelldata(sheetProgram, 2, 0));
		programDescription.sendKeys(excelreader.getcelldata(sheetProgram, 2, 1));
		//radio button selection
		boolean status ;      
		status = activeStatus.isSelected();   
		 
		if(status == true)
		{
			activeStatus.click(); 
		}
		else
		{
			inactiveStatus.click(); 
		}
		//admin getting system date as program creation time and program modified time
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("MM/DD/YY HH:MM");  
		programDate = dateFormat.format(date); 
		excelreader.setcelldata(sheetProgram, 1, 2,programDate);
	    
	}

	@When("Admin clicks on submit button after updating the required fields like Program Name Program Description Program Status")
	public void admin_clicks_on_submit_button_after_updating_the_required_fields_like_program_name_program_description_program_status() {
		//admin clicking submit button
		WebElement programSubmit=driver.findElement(By.name("btnProgramSubmit"));
		programSubmit.click();
	    
	}

	@Then("All the updated program details will be added to Programs List in Manage Programs Page admin with auto generated same ProgramCreationtime and modified Programtime MM\\/DD\\/YY HH:MM format")
	public void all_the_updated_program_details_will_be_added_to_programs_list_in_manage_programs_page_admin_with_auto_generated_same_program_creationtime_and_modified_programtime_mm_dd_yy_hh_mm_format() {
		int actualcount=count();
		program.click();
		int expcount=count();
		//Asserting programlist  program
		Assert.assertEquals(actualcount, expcount);
	}

	@When("Admin clicks on Trash icon for any program in Programs List")
	public void admin_clicks_on_trash_icon_for_any_program_in_programs_list() {
		// admin clicking on trash button
		WebElement Deleteprogram=driver.findElement(By.name("btnDelProgram"));
		Deleteprogram.click();
		
	    
	}

	@Then("Program will be deleted from the Programs List in Manage Programs Page admin")
	public void program_will_be_deleted_from_the_programs_list_in_manage_programs_page_admin() {
		int actualcount=count();
	    program.click();
	    int expcount=count();
	    //Asserting programlist  program Name after deleting
		Assert.assertEquals(actualcount-1, expcount);
	    
	}
	
	public int count()
	{
		List<WebElement> programlist = driver.findElements(By.className("ProgramName"));
		int count=programlist.size();
		return count;

		
	}
	
	

}
