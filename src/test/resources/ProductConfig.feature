#  Author: Walelign A.
#  Date: June 18, 2023
#  Project name: Shared Wallet
#  Module: Platform Configuration
#  Activity: Product Configuration
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@ProductConfiguration

Feature: Product Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters "Walelign@123" into Username text field
    And web user enters "Walelign@123" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Platform Config main menu

  Scenario: Add Product with valid data
    And web user clicks on product sub menu
    Then web system displays product configuration page
    When web user clicks on add button for product config