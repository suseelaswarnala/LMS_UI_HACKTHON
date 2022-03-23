
@Programs
Feature: Different Program functions Performed by Admin
 

  @tag1
  Scenario: Check whether Newly Added program details are visible to Admin
    Given Admin is on Manage Programs Page(admin) by clicking on Programs Tab
    When Admin Add a program to Existing programs list
    Then Newly Added program details will be displayed in Manage Programs Page(admin)
  @tag2
  Scenario: Check Edited program details are  visible to Admin
    Given Admin is on Manage Programs Page(admin) by clicking on Programs Tab
    When Admin Edits an existing program
    Then Updated program details will be displayed in Manage Programs Page(admin)
    
    
    Scenario: Check Deleted program details is removed from Admin view
    Given Admin is on Manage Programs Page(admin) by clicking on Programs Tab
    When Admin Delete an existing program
    Then Deleted program details will be removed from Manage Programs Page(admin)

    
Scenario: Check Admin can able to see all existing program details
    Given Admin is on Manage Programs Page(admin) by clicking on Programs Tab
    When Admin tries to view exisiting program  details
    Then All the existing program details will be displayed in Manage Programs Page(admin)
    
    Scenario: Check whether Admin can  Add Program details
    Given Admin is on Add tab in Add/Edit Programs page by clicking Add Program in Manage Programs Page(admin)
    When Admin clicks on submit button after entering the Program Name ,Program Description,Program Status
    Then All the program details will be added to Programs List in Manage Programs Page(admin) with auto generated same ProgramCreationtime and ProgramModifiedtime in MM/DD/YY HH:MM format
    
    
    Scenario: Check whether Admin can Edit Program details for Program
    Given Admin is on Edit tab in Add/Edit Programs page by clicking Edit icon in Manage Programs Page(admin)
    When Admin clicks on submit button after updating the required fields like Program Name ,Program Description,Program Status
    Then All the updated program details will be added to Programs List in Manage Programs Page(admin) with auto generated same ProgramCreationtime and modified Programtime MM/DD/YY HH:MM format
    
    
    Scenario:  Check whether Admin can Delete the program
    Given Admin is on Manage Programs Page(admin) by clicking on Programs Tab
    When Admin clicks on Trash icon for any program in Programs List
    Then Program will be deleted from the Programs List in Manage Programs Page(admin)