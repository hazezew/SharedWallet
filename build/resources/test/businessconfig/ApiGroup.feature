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
    When web user enters username into username text field
    And web user enters password into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Business Config main menu

  Scenario Outline: Add Api Group with valid data
    And web user clicks on api group sub menu
    Then web system displays api group configuration page
    When web user clicks on add button for api group
    And web user add api group config "<Name>" "<Description>" "<AllowedApi>" and "<Status>"
    And web user click save button for api group
    Then web user should see the "<Name>" api group is created
    And web user clicks on view icon for "<Name>" api group
    And web user delete the created api group
    Examples:
      | Name            | Description | AllowedApi | Status |
      | Auto CashIn API | Auto desc   | Topup      | Active |

  Scenario Outline: Edit Api Group
    And web user clicks on api group sub menu
    Then web system displays api group configuration page
    When web user clicks on add button for api group
    And web user add api group config "<Name>" "<Description>" "<AllowedApi>" and "<Status>"
    And web user click save button for api group
    Then web user should see the "<Name>" api group is created
    When web user clicks on view icon for "<Name>" api group
    And web user click on edit button for api group
    And web user update api group descripiton "Updated desc" allowed api "CASHIN" "CASHOUT"
    And web user click save button for api group
    Then web user should see the "<Name>" api group is created
    And web user clicks on view icon for "<Name>" api group
    And web user delete the created api group
    Examples:
      | Name            | Description | AllowedApi | Status |
      | Auto CashIn API | Auto desc   | Topup      | Active |

  Scenario: Verify add api group without filling the required fields
    And web user clicks on api group sub menu
    Then web system displays api group configuration page
    When web user clicks on add button for api group
    And web user click save button for api group
    Then web system displays validation message for api group

  Scenario Outline: Verify add api group with duplicate data
    And web user clicks on api group sub menu
    Then web system displays api group configuration page
    When web user clicks on add button for api group
    And web user add api group config "<Name>" "<Description>" "<AllowedApi>" and "<Status>"
    And web user click save button for api group
    Then web user should see the "<Name>" api group is created
    When web user clicks on add button for api group
    And web user add api group config "<Name>" "<Description>" "<AllowedApi>" and "<Status>"
    And web user click save button for api group
    Then verify system displays "Name already exists" error message for api group
    And web user clicks on view icon for "<Name>" api group
    And web user delete the created api group
    Examples:
      | Name            | Description | AllowedApi | Status |
      | Auto CashIn API | Auto desc   | Topup      | Active |

  Scenario: verify search for api group
    And web user clicks on api group sub menu
    Then web system displays api group configuration page
    When web user click on filter icon for api group
    And web user select "Contains" for the search api group filter criteria
    And web user enters "Customer" into api group search name field
    And web user clicks search api group button
    Then web system displays a list of api groups with "Customer" on the name