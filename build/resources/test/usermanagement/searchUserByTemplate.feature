#  Author: Habitamu Azezew
#  Date: May 04, 2023
#  Project name: Shared Wallet
#  Module: User Management
#  Activity: Search User By Template
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@UserManagement

Feature: Search User By Template
  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters username into username text field
    And web user enters password into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over User Management main menu
    And web user clicks on Search User By Template sub menu
    Then web system displays Search User By Template page

  Scenario: Search User By Template with empty username
    And web user clicks on search button for Search User By Template
    Then Search User By Template page displays validation message "Please select System Operator entity"
    And web user clicks on settings link
    And web user clicks on Logout link

  Scenario: Search User By Template with valid System Operator Entity
    And web user selects "Ethswitch" from System Operator Entity dropdown
    And web user clicks on search button for Search User By Template
    Then Search User By Template displays all users of selected template
#    Add more steps here after implementation is completed
    And web user clicks on settings link
    And web user clicks on Logout link