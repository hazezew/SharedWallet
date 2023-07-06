#  Author: Habitamu Azezew
#  Date: May 11, 2023
#  Project name: Shared Wallet
#  Module: Wallet Management
#  Activity: System User Management
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@UserManagement

Feature: Wallet Management
  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
#    When web user enters "Walelign@123" into Username text field
#    And web user enters "Walelign@123" into password text field
    When web user enters "Habtamu@eth" into Username text field
    And web user enters "Habtamu@748" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over User Management main menu
    And web user clicks on Wallet Management sub menu
    Then web system displays Wallet Management page

  Scenario: Wallet Management for empty user
    And on Wallet Management user clicks search button
    Then Wallet Management page displays a mandatory validation message "Enter username"
    And Wallet Management page displays no wallet owner details
    And web user clicks on settings link
    And web user clicks on Logout link

  Scenario: Wallet Management for invalid user
    And on Wallet Management user enters "0910988905" into user textfield
    And on Wallet Management user clicks search button
    Then Wallet Management page displays a validation message "User account not found"
    And web user clicks on settings link
    And web user clicks on Logout link

  Scenario: Wallet Management for valid user
    And on Wallet Management user enters "0913911391" into user textfield
    And on Wallet Management user clicks search button
    Then Wallet Management page displays wallet owner details
#    Check the following step definition after issue fix
    And on Wallet Management page user enters "123456" into Wallet textfield
#    Add more steps after proper and complete implementation and not clear
    And web user clicks on settings link
    And web user clicks on Logout link