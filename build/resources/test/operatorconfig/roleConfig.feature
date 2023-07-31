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
    When web user enters "Walelign@123" into Username text field
    And web user enters "Walelign@123" into password text field
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
    Examples:
      | RoleName  | Description | UserCategory |
      | Auto Role | Auto Desc   | Customer     |