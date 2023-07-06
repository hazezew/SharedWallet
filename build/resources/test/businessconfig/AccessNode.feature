#  Author: Walelign A.
#  Date: July 02,2023
#  Project name: Shared Wallet
#  Module: Business Configuration
#  Activity: Access Node Config
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@AccessNodeConfiguration

Feature: Access Node Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters "Walelign@123" into Username text field
    And web user enters "Walelign@123" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Business Config main menu

  Scenario: Add Access Node with valid data
    And web user clicks on access node sub menu
    Then web system displays access node configuration page
    When web user clicks on add button for access node