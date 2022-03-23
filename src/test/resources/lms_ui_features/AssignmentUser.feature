@AssignmentUser
Feature: Assignment functions performed by User

  Background: Admin is logged in,Batches and Classes were created already

  @PositiveScenario
  Scenario: Check whether user can submit assignment
    Given User is on Manage Submissions user page
    When User clicks on submit button after selecting Batch,Assignment Name,Assignment Date ,add comments
    Then Assignment will be submitted succesfully

  @PositiveScenario
  Scenario: Check whether user can edit a particular assignment
    Given User is on Manage Submissions(user) page
    When User clicks on submit button after clicking on Edit icon to edit the required details
    Then Updated Assignment will be submitted successfully

  @PositiveScenario
  Scenario: Check whether user can delete  a particular assignment
    Given User is on Manage Submissions(user) page
    When User clicks on Trash icon after the assignment
    Then Assignment will be deleted successfully
