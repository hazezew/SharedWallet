#  Author: Walelign A.
#  Date: May 23, 2023
#  Project name: Shared Wallet
#  Module: Platform Configuration
#  Activity: View User
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@UcpConfiguration

Feature: Ucp Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters "Walelign@123" into Username text field
    And web user enters "Walelign@123" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Platform Config main menu

  Scenario Outline: Add Ucp with valid data
    And web user clicks on ucp sub menu
    Then web system displays ucp configuration page
    When web user clicks on add button for ucp config
    And web user fills UCP config detail "<Name>" "<Description>" "<Unit>" "<UCP Type>" "<Slab Type>" "<Credit Type>" "<Calculation Type>" "<Credit On>" and "<Value Type>"


    Examples:
      | Name                  | Description          | Unit            | UCP Type   | Slab Type | Credit Type | Calculation Type | Credit On | Value Type |
      | Auto_UCP_Commission   | Auto_UCP_Description | Abay Agent Unit | Fixed      |           | Absolute    |                  |           | Static     |
      | Auto_UCP_Agent_Policy | Auto_UCP_Description | E-money         | Slab Based | Flat      | Percentage  | Inclusive        | Amount    | Dynamic    |
