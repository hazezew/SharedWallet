#  Author: Walelign Andargie
#  Date: July 10, 2023
#  Project name: Shared Wallet
#  Module: Technical Config
#  Activity: Process Configuration
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@ProcessConfiguration

Feature: Process Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters username into username text field
    And web user enters password into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Technical Config main menu

  Scenario: Add Process
    And web user clicks on process config sub menu
    Then web system displays process config page

  Scenario: verify search for process
    And web user clicks on process config sub menu
    Then web system displays process config page
    When web user click on filter icon for process
    And web user select "Contains" for the search process filter criteria
    And web user enters "Process" into process search name field
    And web user clicks search process button
    Then web system displays a list of processes with "Process" on the name