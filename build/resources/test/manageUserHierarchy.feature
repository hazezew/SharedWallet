#  Author: Habitamu Azezew
#  Date: May 12, 2023
#  Project name: Shared Wallet
#  Module: Manage User Hierarchy
#  Activity: System User Management
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@UserManagement

Feature: Manage User Hierarchy
  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
#    Use any one of the following login details by commenting and uncommenting either of them as needed
    When web user enters "Habtamu@eth" into Username text field
    And web user enters "Habtamu@748" into password text field
#    When web user enters "Walelign@123" into Username text field
#    And web user enters "Walelign@123" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over User Management main menu
    And web user clicks on Manage User Hierarchy sub menu
    Then web system displays Manage User Hierarchy page

  Scenario: Manage User Hierarchy with empty user
    And on Manage User Hierarchy page user clicks on search button
    Then Manage User Hierarchy page displays a mandatory validation message "Enter username"
    And web user clicks on settings link
    And web user clicks on Logout link

  Scenario: Manage User Hierarchy for an invalid user
    When on Manage User Hierarchy page user enters "0910988900" into Tree Identifier textfield
    And on Manage User Hierarchy page user clicks on search button
    Then Manage User Hierarchy page displays popup validation message "User not found"
    And on Manage User Hierarchy popup page user clicks on cancel button
    And Manage User Hierarchy page displays another validation message "User Not Found"
    And web user clicks on settings link
    And web user clicks on Logout link

  Scenario: Manage User Hierarchy for valid user
    When on Manage User Hierarchy page user enters "0910988905" into Tree Identifier textfield
    And on Manage User Hierarchy page user clicks on search button
    Then Manage User Hierarchy page user moves mouse over wallet owner mobile number
    And Manage User Hierarchy page user clicks on Edit option
    And Manage User Hierarchy page user clicks on Next button
    And Manage User Hierarchy page user clicks on Submit button
    And Manage User Hierarchy page user clicks on Confirm button
#    You may add more steps here if need be
    And web user clicks on settings link
    And web user clicks on Logout link