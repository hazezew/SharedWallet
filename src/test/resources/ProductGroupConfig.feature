#  Author: Walelign A.
#  Date: June 18, 2023
#  Project name: Shared Wallet
#  Module: Platform Configuration
#  Activity: Product Group Configuration
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@ProductGroupConfiguration

Feature: Product Group Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters "Walelign@123" into Username text field
    And web user enters "Walelign@123" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Platform Config main menu

  Scenario: Add Product Group with valid data
    And web user clicks on product group sub menu
    Then web system displays product group configuration page
    When web user clicks on add button for product group config