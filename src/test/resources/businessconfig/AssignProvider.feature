#  Author: Walelign A.
#  Date: July 07,2023
#  Project name: Shared Wallet
#  Module: Business Configuration
#  Activity: Assign Provider Config
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@AssignProviderConfiguration

Feature: Assign Provider Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters "Walelign@123" into Username text field
    And web user enters "Walelign@123" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Business Config main menu

  Scenario: Add Assign Provider with valid data
    And web user clicks on assign provider sub menu
    Then web system displays assign provider configuration page


  Scenario: verify search for Assign Provider functionality
    And web user clicks on assign provider sub menu
    Then web system displays assign provider configuration page
    When web user click on filter icon for assign provider
    And web user select "Contains" for the search assign provider filter criteria
    And web user enters "Tele" into assign provider search name field
    And web user clicks search assign provider button
    Then web system displays a list of assign providers with "Tele" on the name
