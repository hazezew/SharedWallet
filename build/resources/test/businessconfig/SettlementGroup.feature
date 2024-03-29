#  Author: Walelign A.
#  Date: July 05,2023
#  Project name: Shared Wallet
#  Module: Business Configuration
#  Activity: Settlement Group Config
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@SettlementGroupConfiguration

Feature: Settlement Group Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters username into username text field
    And web user enters password into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Business Config main menu

  Scenario: Add Settlement Group with valid data
    And web user clicks on settlement group sub menu
    Then web system displays settlement group configuration page
    When web user clicks on add button for settlement group