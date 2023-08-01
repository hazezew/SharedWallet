#  Author: Walelign Andargie
#  Date: July 10, 2023
#  Project name: Shared Wallet
#  Module: Technical Config
#  Activity: Scheduler Configuration
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@SchedulerConfiguration

Feature: Scheduler Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters username into username text field
    And web user enters password into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Technical Config main menu

  Scenario: Technical Config
    And web user clicks on scheduler sub menu
    Then web system displays scheduler page

  Scenario: verify search for scheduler
    And web user clicks on scheduler sub menu
    Then web system displays scheduler page
    When web user click on filter icon for scheduler
    And web user select "Contains" for the search scheduler filter criteria
    And web user enters "Scheduler" into scheduler search name field
    And web user clicks search scheduler button
    Then web system displays a list of schedulers with "Scheduler" on the name