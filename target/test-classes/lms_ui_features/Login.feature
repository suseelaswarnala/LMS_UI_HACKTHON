@Login
Feature: Login functions(Admin/User)
  @tag1
Scenario: Check whether Admin/user could able to login with valid Credentialse
    Given Admin/User is on LMS Log-In Screen
    When  Admin/User enters Login Name and Password 
    Then  Admin/user navigates to LMS Home Page
   @tag2
Scenario: Check whether Admin/user could able to login with Invalid Credentialse
    Given Admin/User is on LMS Log-In Screen
    When  Admin/User enters Invalid Login Name and Password 
    Then  Admin/user will not login successfully with invalid credentials error message
Scenario: Check whether Admin/User could able to receive reset password link for the Registered Email Address
    Given Admin/User is on Answer Security Question page by clikcing on Forgot password link
    When  Admin/User enters Email Address and clicks on Next button.Admin/User enters the Answer for security Question 
    Then  Message will be displayed
Scenario: Check whether Admin/User could able to receive reset password link for  Unregistered Email ID
    Given Admin/User is on Answer Security Question page by clikcing on Forgot password link
    When  Admin/User enters Email Address and clicks on Next button.Admin/User enters the Answer for security Question 
    Then  Error Message will be displayed   
