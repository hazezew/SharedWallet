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
    And web user enters 10 for ucp value
    And web user clicks on save button for ucp
    Then web user should see the "<Name>" ucp is created
    And web user clicks on view icon for "<Name>" ucp
    And web user delete the created ucp
    Examples:
      | Name                  | Description          | Unit   | UCP Type   | Slab Type | Credit Type | Calculation Type | Credit On | Value Type |
      | Auto_UCP_Commission   | Auto_UCP_Description | EMoney | Fixed      |           | Absolute    |                  |           | Static     |
      | Auto_UCP_Agent_Policy | Auto_UCP_Description | EMoney | Slab Based | Flat      | Percentage  | Inclusive        | Amount    | Dynamic    |

  Scenario: Verify add UCP without filling the required fields
    And web user clicks on ucp sub menu
    Then web system displays ucp configuration page
    When web user clicks on add button for ucp config
    And web user clicks on save button for ucp
    Then web system displays validation message for ucp config

  Scenario Outline: Edit UCP configuration
    And web user clicks on ucp sub menu
    Then web system displays ucp configuration page
    When web user clicks on add button for ucp config
    And web user fills UCP config detail "<Name>" "<Description>" "<Unit>" "<UCP Type>" "<Slab Type>" "<Credit Type>" "<Calculation Type>" "<Credit On>" and "<Value Type>"
    And web user enters 10 for ucp value
    And web user clicks on save button for ucp
    Then web user should see the "<Name>" ucp is created
    And web user clicks on view icon for "<Name>" ucp
    And web user clicks edit button for ucp
    And web user update ucp config Unit as "Merchant Unit" Unit Type as "Slab Based" Slab Type as "Flat" and Value Type as "Dynamic"
    And web user add slab detail min as 10 maximum as 100 and value as 1000
    And web user clicks on save button for ucp
    Then web user verify "<Name>" ucp is updated with "Merchant Unit" "Slab Based" "Flat" and "Dynamic"
    And web user moves mouse over Platform Config main menu
    And web user clicks on ucp sub menu
    And web user clicks on view icon for "<Name>" ucp
    And web user delete the created ucp
    Examples:
      | Name          | Description          | Unit   | UCP Type | Slab Type | Credit Type | Calculation Type | Credit On | Value Type |
      | Auto_UCP_Edit | Auto_UCP_Description | EMoney | Fixed    |           | Absolute    |                  |           | Static     |

  Scenario: verify search for ucp functionality
    And web user clicks on ucp sub menu
    Then web system displays ucp configuration page
    When web user click on filter icon for ucp
    And web user select "Contains" for the search ucp filter criteria
    And web user enters "Customer" into ucp search name field
    And web user clicks search ucp button
    Then web system displays a list of ucps with "Customer" on the name

  Scenario Outline: Verify add UCP with duplicate UCP name
    And web user clicks on ucp sub menu
    Then web system displays ucp configuration page
    When web user clicks on add button for ucp config
    And web user fills UCP config detail "<Name>" "<Description>" "<Unit>" "<UCP Type>" "<Slab Type>" "<Credit Type>" "<Calculation Type>" "<Credit On>" and "<Value Type>"
    And web user enters 10 for ucp value
    And web user clicks on save button for ucp
    Then web user should see the "<Name>" ucp is created
    When web user clicks on add button for ucp config
    And web user fills UCP config detail "<Name>" "<Description>" "<Unit>" "<UCP Type>" "<Slab Type>" "<Credit Type>" "<Calculation Type>" "<Credit On>" and "<Value Type>"
    And web user enters 50 for ucp value
    And web user clicks on save button for ucp
    Then verify system displays "Name already exists" error message for ucp
    And web user moves mouse over Platform Config main menu
    And web user clicks on ucp sub menu
    And web user clicks on view icon for "<Name>" ucp
    And web user delete the created ucp
    Examples:
      | Name                     | Description          | Unit   | UCP Type | Slab Type | Credit Type | Calculation Type | Credit On | Value Type |
      | Auto_UCP_Duplicate_Check | Auto_UCP_Description | EMoney | Fixed    |           | Absolute    |                  |           | Static     |

