#  Author: Habitamu Azezew
#  Date: April 22, 2023
#  Project name: Shared Wallet
#  Module: User Management
#  Activity: Update User Profile
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@UserManagement

Feature: Update User Profile
  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters username into username text field
    And web user enters password into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over User Management main menu

  Scenario: Update User Profile with empty user value
    And web user clicks on Update User Profile sub menu
    Then web system displays Update User Profile page
    And web user clicks on search user button for update
    Then Update User Profile page displays validation message "Enter username"
    And web user clicks on settings link
    And web user clicks on Logout link

  Scenario: Update an Existing User Profile with valid data
    And web user clicks on Update User Profile sub menu
    Then web system displays Update User Profile page
    And web user enters "Walelign@bank3" into username search textfield for update
    And web user clicks on search user button for update
    Then Update User Profile page displays the searched user details
    And for User Profile update user selects "English" from Language dropdown
    And for User Profile update user clicks on Next button
    And for User Profile update user enters "Walelign Andargie123" into Fullname textfield
    And for User Profile update user enters "waleligndbu@gmail.com123" into Email textfield
    And for User Profile update user clicks on Next button again
    And for User Profile update user enters "Walelign@627" into Password textfield
    And for User Profile update user enters "Walelign@bank3" into Username textfield
    And User Profile update user clicks on Submit button
    And User Profile update user clicks on Ok popup alert button for confirmation
    And web user clicks on settings link
    And web user clicks on Logout link

  Scenario: Update User Profile with invalid user
    And web user clicks on Update User Profile sub menu
    Then web system displays Update User Profile page
    And web user enters "Habtamu@eth12321" into username search textfield for update
    And web user clicks on search user button for update
    Then Update User Profile page displays "User not found" message
    And web user clicks on settings link
    And web user clicks on Logout link