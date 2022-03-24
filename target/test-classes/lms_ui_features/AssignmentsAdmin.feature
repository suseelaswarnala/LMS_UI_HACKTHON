@AssignmentAdmin
Feature: Assignment functions performed by Admin

  Background: Admin is logged in,Batches and Classes were created already

  @PositiveScenario
  Scenario: Check whether Newly Added assignments details are visible to Admin
    Given Admin is on Manage Assignments Page admin by clicking on Manage Assignments tab
    When Admin Add an Assignment to Existing Batch
    Then Newly Added assignment Details will be displayed in Manage Assignments Page Admin

  @PositiveScenario
  Scenario: Check whether Edited assignments details are visible to Admin
    Given Admin is on Manage Assignments Page admin by clicking on Manage Assignments tab
    When Admin Edit an existing assignment
    Then Updated assignment details will be displayed in Manage Assignments Page Admin

  @PositiveScenario
  Scenario: Check whether Deleted assignments details are removed from Admin view
    Given Admin is on Manage Assignments Page admin by clicking on Manage Assignments tab
    When Admin Delete an existing assignment
    Then Deleted assignment details will be removed from Manage Assignments Page Admin

  @PositiveScenario
  Scenario: Check whether Admin can able to see all existing assignment details
    Given Admin is on Manage Assignments Page admin by clicking on Manage Assignments tab
    When Admin tries to view exisiting assignment details
    Then All the existing assignment details will be displayed in Manage Assignments Page Admin

  @PositiveScenario
  Scenario: Check whether Admin can add New assignments for particular Batch
    Given Admin is on Add tab of manage Assignments page admin view by clicking on Add Assignment in Manage Assignments Page admin
    When Admin clicks on submit button after selecting Batch and enters Assignment name, Assignment Description , Assignment Due, Upload assignments
    Then Created assignments will be displayed in Manage Assignments Page admin  and Manage Assignment page User View

  @PositiveScenario
  Scenario: Check whether Admin can Edit existing assignments for particular Batch
    Given Admin is on Edit tab of manage Assignments page admin view by clicking on Add Assignment in Manage Assignments Page admin
    When Admin clicks on submit button after updating one or more assignment details
    Then Updated assignment details will be displayed in Manage Assignments Page admin and Manage Assignment page User View

  @PositiveScenario
  Scenario: Check whether Admin can Delete existing assignments for particular Batch
    Given Admin is on Manage Assignments Page admin
    When Admin clicks on Trash icon after selecting existing assignments
    Then Deleted assignment will be removed from Admin View in Manage Assignments Page admin and Manage Assignment page User View

  @PositiveScenario
  Scenario: Check whether Admin can manage students submission by selecting Make Grade Visible
    Given Admin is on Manage Submissions Admin  page by clicking on Manage button in Manage assignments page admin
    When Admin clicks on submit button after selecting all th details like Batch,Assignment Name,Assignment Date ,Grade By ,Grade ,Make Garde Visible and add comments
    Then Grade Details will be visible to both Admin and User View

  @PositiveScenario
  Scenario: Check whether Admin can manage students submission by unselecting Make Grade Viisble
    Given Admin is on Manage Submissions Admin page by clicking on Manage button in Manage assignments page admin
    When Admin clicks on Submit button after selecting all the details like Batch,Assignment Name,Assignment Date ,Grade By ,Grade ,add comments
    Then Grade Details will be visible only to Admin
