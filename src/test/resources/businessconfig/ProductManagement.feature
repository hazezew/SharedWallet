#  Author: Walelign A.
#  Date: July 05,2023
#  Project name: Shared Wallet
#  Module: Business Configuration
#  Activity: Product Management Config
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@ProductManagementConfiguration

Feature: Product Management Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters username into username text field
    And web user enters password into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Business Config main menu

  Scenario: Add Product Management with valid data
    And web user clicks on product management sub menu
    Then web system displays product management configuration page
    When web user clicks on add button for product management

  Scenario: verify search for product management functionality
    And web user clicks on product management sub menu
    Then web system displays product management configuration page
    When web user click on filter icon for product management
    And web user select "Contains" for the search product management filter criteria
    And web user enters "Ethio" into product management search name field
    And web user clicks search product management button
    Then web system displays a list of product managements with "Ethio" on the name