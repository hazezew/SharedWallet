#  Author: Habitamu Azezew
#  Date: April 22, 2023
#  Project name: Shared Wallet
#  Module: User Management
#  Activity: User Login
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@Login

Feature: User Login
  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL

  Scenario: login with valid username and password
    When web user enters "Habtamu@eth" into Username text field
    And web user enters "Habtamu@748" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user clicks on settings link
    And web user clicks on Logout link
    Then web system logs out and displays login page

  Scenario: login with valid username but password
    When web user enters "Habtamu@eth" into Username text field
    And web user enters "Habtamu@7489" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "Incorrect username or password" message

  Scenario: login with invalid username but password
    When web user enters "Habtamu@ethiopia" into Username text field
    And web user enters "Habtamu@748" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "Incorrect username or password" message

  Scenario: login with empty username but password
    And web user enters "Habtamu@748" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "Please insert valid Username" as mandatory username validation message

  Scenario: login with valid username but empty password
    When web user enters "Habtamu@ethiopia" into Username text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "Please insert valid Password" as mandatory password validation message

  Scenario: login with empty username and empty password
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "Please insert valid Username" as mandatory username validation message
    Then web system displays "Please insert valid Password" as mandatory password validation message