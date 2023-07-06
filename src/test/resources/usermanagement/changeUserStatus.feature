#  Author: Habitamu Azezew
#  Date: May 06, 2023
#  Project name: Shared Wallet
#  Module: User Management
#  Activity: Change Status
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@UserManagement

Feature: Change Status
  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters "Habtamu@eth" into Username text field
    And web user enters "Habtamu@748" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over User Management main menu
    And web user clicks on Change Status sub menu
    Then web system displays Change Status page

  Scenario: Change Status with empty username
    And web user clicks on search button for Change Status
    Then Change Status page displays validation message "Enter username"
    And web user clicks on settings link
    And web user clicks on Logout link

  Scenario: Change Status with valid username
    And change Status user enters "Habtamu@eth" into username search textfield
    And web user clicks on search button for Change Status
    Then Change Status page displays user details
#    Add more steps when the implementation completes
    And web user clicks on settings link
    And web user clicks on Logout link

  Scenario: Change Status with invalid username
    And change Status user enters "Habtamu@eth12345" into username search textfield
    And web user clicks on search button for Change Status
    Then Change Status page displays an error message "Sorry! Username does not exist"
    And web user clicks on settings link
    And web user clicks on Logout link