#  Author: Habitamu Azezew
#  Date: May 12, 2023
#  Project name: Shared Wallet
#  Module: Search Business User By Template
#  Activity: System User Management
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@UserManagement

Feature: Search Business User By Template
  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
#    Use any one of the following login details by commenting and uncommenting either of them as needed
#    When web user enters "Habtamu@eth" into Username text field
#    And web user enters "Habtamu@748" into password text field
    When web user enters "Walelign@123" into Username text field
    And web user enters "Walelign@123" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over User Management main menu
    And web user clicks on Search Business User By Template sub menu
    Then web system displays Search Business User By Template page

  Scenario: Search Business User By Template without mandatory value
    And on Search Business User By Template page user clicks on search button
    Then Search Business User By Template page displays a mandatory validation message "Please select Operating Entity Template"
    And web user clicks on settings link
    And web user clicks on Logout link

  Scenario: Search Business User By Template with available search results
    And on Search Business User By Template page user selects "Agent Operating Entity Templet" from Operating Entity Template dropdown
    And on Search Business User By Template page user clicks on search button
    Then on Search Business User By Template page user clicks on show user info icon
    And on Search Business User By Template page user clicks on user info tab
    And on Search Business User By Template page user clicks on agent info tab
    And on Search Business User By Template page user clicks on login info tab
    And on Search Business User By Template page user clicks on user info ok button
    Then on Search Business User By Template page user clicks on view user hierarchy icon
    And on Search Business User By Template page user clicks on user hierarchy ok button
    And web user clicks on settings link
    And web user clicks on Logout link

  Scenario: Search Business User By Template with all search field values but unavailable search results
    And on Search Business User By Template page user selects "Agent Operating Entity Templet" from Operating Entity Template dropdown
    And on Search Business User By Template page user enters "07098765" into Tree Identifier textfield
    And on Search Business User By Template page user clicks on search button
    Then Search Business User By Template page displays "No records found" message
    And web user clicks on settings link
    And web user clicks on Logout link

  Scenario: Search Business User By Template with all search field values and available search results
    And on Search Business User By Template page user selects "Agent Operating Entity Templet" from Operating Entity Template dropdown
    And on Search Business User By Template page user enters "0910988905" into Tree Identifier textfield
    And on Search Business User By Template page user clicks on search button
    Then on Search Business User By Template page user clicks on show user info icon
    And on Search Business User By Template page user clicks on user info tab
    And on Search Business User By Template page user clicks on agent info tab
    And on Search Business User By Template page user clicks on login info tab
    And on Search Business User By Template page user clicks on user info ok button
    Then on Search Business User By Template page user clicks on view user hierarchy icon
    And on Search Business User By Template page user clicks on user hierarchy ok button
    And web user clicks on settings link
    And web user clicks on Logout link