@Users
Feature: LMS Admin  User page

  @tag1
  Scenario: Check whether Admin can search users by giving Email or Batch or Skill or program
    Given Admin is on LMS Admin User Page
    When Admin clicks on search button after entering Email or Batch or Skill or program
    Then Admin will be navigated to Manage users admin page and Registered User list will be displayed
   

  @tag2
 Scenario: Check whether Admin can edit registered user in Manage users admin page
    Given Admin is on Manage users admin page Registered User list and clicks on edit icon
    When  Admin will be navigated to Manage users admin page where User details will be displayed
    Then Admin will be able to edit User details like Time zone User role batch Program and click on save

 
  @tag3
 Scenario:Check whether Admin can delete particular registered user in Manage users admin page
    Given Admin is on Manage users admin page Registered Users list
    When  Admin clicks on trash icon of particular registered user
    Then Deleted registered user will be removed from Registered users list
    
     @tag4
   Scenario:Check whether Admin will be navigated to manage users admin page when clicked on eye icon
    Given Admin is on Manage users admin page Registered Users list
    When  Admin clicks on eye icon for particular user
    Then Admin will be navigated to Manage users admin page and view the User details only in read only format
    
     @tag5
   Scenario: Check  whether Admin can be able  to view New Unassigned user 
    Given Admin is on LMS Admin User Page
    When  Admin clicks on New Unassigned User hyperlink
    Then Admin will be navigated to Manage user admin page Unregistered User list will be displayed
    
     @tag6
  Scenario: Check whether Admin can be able to edit Unregistered user
    Given Admin is on Manage user admin page Unregistered User list
    When  Admin clicks on edit icon of particular unregistered user and admin will be navigated to manage users admin page
    Then Admin will be able to edit User details like Time zone User role batch Program and click on save
    
     @tag7
  Scenario: Check whether Admin can be able to delete Unregistered user
    Given Admin is on Manage user admin page Unregistered User list
    When  Admin clicks on trash icon of particular unregistered user
    Then Deleted unregistered user will be removed from Unregistered users list
