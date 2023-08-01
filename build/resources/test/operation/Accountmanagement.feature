#  Author: Walelign A.
#  Date: July 22, 2023
#  Project name: Shared Wallet
#  Module: Operation Configuration
#  Activity: Account Management
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@Account Management

Feature: Account Management

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters username into username text field
    And web user enters password into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over operation main menu

  Scenario: Manage account
    And web user clicks on account management sub menu
    Then web system displays account management page

  Scenario: verify search for account management
    And web user clicks on account management sub menu
    Then web system displays account management page
    When web user click on filter icon for account management
    And web user select "Contains" for the search account management filter criteria
    And web user enters "User" into account management search name field
    And web user clicks search account management button
    Then web system displays a list of account managements with "User" on the name