@pagination
Feature: Pagination
@tag1
  Scenario: Check functionality of Pagination at Manage user Admin page
    Given Admin is on Manage users admin page of User list Unregistered
    When  result is containing many  Student records
    Then Large number of Student records will be divided into smaller discrete pages

  @tag2
  Scenario: Check functionality of Pagination at Manage Attendance Admin and Class Staff page
    Given Admin is on  Manage Attendance Admin and Class Staff page ogf Manage Attendance admin
    When result is containing many  Student records
    Then Large number of Student records will be divided into smaller discrete pages