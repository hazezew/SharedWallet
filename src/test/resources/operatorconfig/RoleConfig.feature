#  Author: Walelign A.
#  Date: July 22, 2023
#  Project name: Shared Wallet
#  Module: Operator Configuration
#  Activity: Role Configuration
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@RoleConfiguration

Feature: Role Configuration6

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters username into username text field
    And web user enters password into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over operator config main menu

  Scenario Outline: Add Role with valid data
    And web user clicks on role config sub menu
    Then web system displays role config page
    When web user click add button for role
    And web user add role config "<RoleName>" "<Description>" "<UserCategory>"
    And web user click save button for role
    Then web user should see the "<Name>" role is created
    And web user clicks on view icon for "<Name>" role
    And web user delete the created role

    Examples:
      | RoleName  | Description | UserCategory |
      | Auto Role | Auto Desc   | Customer     |

  Scenario: Verify add role without filling the required fields
    And web user clicks on role config sub menu
    Then web system displays role config page
    When web user click add button for role
    And web user click save button for role
    Then web system displays validation message for role

  Scenario Outline: Add Role with duplicated data
    And web user clicks on role config sub menu
    Then web system displays role config page
    When web user click add button for role
    And web user add role config "<RoleName>" "<Description>" "<UserCategory>"
    And web user click save button for role
    Then web user should see the "<Name>" role is created
    When web user click add button for role
    And web user add role config "<RoleName>" "<Description>" "<UserCategory>"
    And web user click save button for role
    Then verify system displays "Name already exists" error message for role
    And web user clicks on view icon for "<Name>" role
    And web user delete the created role

    Examples:
      | RoleName  | Description | UserCategory |
      | Auto Role | Auto Desc   | Customer     |

  Scenario: verify search for role
    And web user clicks on role config sub menu
    Then web system displays role config page
    When web user click on filter icon for role
    And web user select "Contains" for the search role filter criteria
    And web user enters "Role" into role search name field
    And web user clicks search role button
    Then web system displays a list of roles with "Role" on the name