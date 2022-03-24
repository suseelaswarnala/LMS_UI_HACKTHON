package stepdef;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import LMS_UI_Utils.lms_excelreader;
import LMS_UI_Utils.PropertiesReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login 


{
	
	Launch launch=new Launch();
	public WebDriver driver=launch.driver;
	
	lms_excelreader excelreader;
	Properties properties;
	String sheetAdmin=properties.getProperty("sheetAdmin");
	//finding web elements
	WebElement name=driver.findElement(By.name("txtUserLoginName"));
	WebElement password=driver.findElement(By.name("txtUserPassword"));
	//finding email id element
	WebElement email_id=driver.findElement(By.name("txtUserEmailAddress"));
	public Login() throws Exception {
		super();
			
		PropertiesReader propUtil = new PropertiesReader();
	properties = propUtil.loadProperties();
	
	}
	
	@Given("Admin\\/User is on LMS Log-In Screen")
	public void admin_user_is_on_lms_log_in_screen() {
		
		String login=properties.getProperty("login");
		driver.get(login);
	  
	}

	@When("Admin\\/User enters Login Name and Password")
	public void admin_user_enters_login_name_and_password() throws Exception {
				
		//reading name and password from excel file
		name.sendKeys(excelreader.getcelldata(sheetAdmin, 1, 0));
		password.sendKeys(excelreader.getcelldata(sheetAdmin,1, 1));
		//clicking on login button
		driver.findElement(By.name("btnLoginSubmit")).click();
	    
	}

	@Then("Admin\\/user navigates to LMS Home Page")
	public void admin_user_navigates_to_lms_home_page() {
		String home=properties.getProperty("home");
		driver.get(home);
	    driver.close();
	    driver.quit();
	}

	@When("Admin\\/User enters Invalid Login Name and Password")
	public void admin_user_enters_invalid_login_name_and_password() throws Exception {
		
		name.sendKeys(excelreader.getcelldata(sheetAdmin, 2, 0));
		password.sendKeys(excelreader.getcelldata(sheetAdmin,2, 1));
		//clicking on login button
		driver.findElement(By.name("btnLoginSubmit")).click();
	    
	}

	@Then("Admin\\/user will not login successfully with invalid credentials error message")
	public void admin_user_will_not_login_successfully_with_invalid_credentials_error_message() {
		//setting error Message
		    String message =name.getAttribute("validationMessage");
		    String expectedmsg = "Please fill out valid Name and Password";
		    Assert.assertEquals(message, expectedmsg );
		
	   
	}
	@Given("Admin\\/User is on Answer Security Question page by clikcing on Forgot password link")
	public void admin_user_is_on_answer_security_question_page_by_clikcing_on_forgot_password_link() {
	
		//finding element forgotpassword button
		WebElement forgotpassword=driver.findElement(By.name("btnForgotPassword"));
		forgotpassword.click();
		driver.get(properties.getProperty("forgotpassword"));
		
	   
	}

	@When("Admin\\/User enters Email Address and clicks on Next button.Admin\\/User enters the Answer for security Question")
	public void admin_user_enters_email_address_and_clicks_on_next_button_admin_user_enters_the_answer_for_security_question() throws Exception {
		
	
		email_id.sendKeys("email");
		//finding email id submit button element
		WebElement submit=driver.findElement(By.name("btnForgotPassSubmit"));
		submit.click();
		//finding element security question
		WebElement securityA=driver.findElement(By.name("txtSecurityAnswer"));
	    //sending answer
		securityA.sendKeys(excelreader.getcelldata(sheetAdmin, 1, 3));
		//finding securityAnswer submit button element
		WebElement submitAnswer=driver.findElement(By.name("btnSecurityAnswer"));
		submitAnswer.click();
	   
	}

	@Then("Message will be displayed")
	public void message_like_will_be_displayed() {
		//password reset link message 
		String message =email_id.getAttribute("validationMessage");
	    String expectedmsg = "Password Reset Link has been sent to Email Address";
	    Assert.assertEquals(message, expectedmsg );  
	}
	@Then("Error Message will be displayed")
	public void error_message_will_be_displayed() {
		//getting error message
		String message =email_id.getAttribute("validationMessage");
	    String expectedmsg = "Provided Email Id is not registered";
	    Assert.assertEquals(message, expectedmsg );  
	}


}
