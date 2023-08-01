#  Author: Walelign A.
#  Date: June 10, 2023
#  Project name: Shared Wallet
#  Module: Platform Configuration
#  Activity: Counter Configuration
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@CounterConfiguration

Feature: Counter Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters username into username text field
    And web user enters password into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Platform Config main menu

  Scenario: Add Counter with valid data
    And web user clicks on counter sub menu
    Then web system displays counter configuration page
    When web user clicks on add button for counter config