#  Author: Walelign A.
#  Date: July 06,2023
#  Project name: Shared Wallet
#  Module: Business Configuration
#  Activity: Api Group Config
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@ApiGroupConfiguration

Feature: API Group Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters "Walelign@123" into Username text field
    And web user enters "Walelign@123" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Business Config main menu

  Scenario: Add Api Group with valid data
    And web user clicks on api group sub menu
    Then web system displays api group configuration page
    When web user clicks on add button for api group