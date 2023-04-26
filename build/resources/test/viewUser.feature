#  Author: Habitamu Azezew
#  Date: April 22, 2023
#  Project name: Shared Wallet
#  Module: User Management
#  Activity: View User
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@UserManagement

Feature: User Management
  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters "Habtamu@eth" into Username text field
    And web user enters "Habtamu@748" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over User Management main menu

  Scenario: Search with empty user value
    And web user clicks on View User sub menu
    Then web system displays View User page
    And web user clicks on search user button
    Then view user page displays user validation message "Enter username"

  Scenario: Search an existing web admin user
    And web user clicks on View User sub menu
    Then web system displays View User page
    And web user enters "Habtamu@eth" into username search textfield
    And web user clicks on search user button
    Then view user page displays the searched user details

  Scenario: Search a user which does not exist
    And web user clicks on View User sub menu
    Then web system displays View User page
    And web user enters "Habtamu12343321" into username search textfield
    And web user clicks on search user button
    Then view user page displays "User does not exist" message