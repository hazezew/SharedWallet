#  Author: Walelign A.
#  Date: June 15, 2023
#  Project name: Shared Wallet
#  Module: Platform Configuration
#  Activity: Rule Configuration
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@RuleConfiguration

Feature: Rule Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters username into username text field
    And web user enters password into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Platform Config main menu

  Scenario Outline: Add Rule with valid data
    And web user clicks on rule sub menu
    Then web system displays rule configuration page
    When web user clicks on add button for rule config
    And web user fills rule config detail "<Name>" "<Description>" "<Expression>" "<Used By>" and "<Status>"
    And web user clicks save button for rule with "<Status>"
    Then web user should see the "<Name>" rule is created
    And web user clicks on view icon for "<Name>" rule
    And web user delete the created rule
    Examples:
      | Name               | Description    | Expression   | Used By         | Status   |
      | Auto_Customer_Rule | Auto_Rule_Desc | <1000, 10000 | Service Profile | Active   |
      | Auto_Agent_Rule    | Auto_Rule_Desc | <20, 10000   | Notification    | Inactive |

  Scenario Outline: Edit Rule Configuration
    And web user clicks on rule sub menu
    Then web system displays rule configuration page
    When web user clicks on add button for rule config
    And web user fills rule config detail "<Name>" "<Description>" "<Expression>" "<Used By>" and "<Status>"
    And web user clicks save button for rule with "<Status>"
    Then web user should see the "<Name>" rule is created
    And web user clicks on view icon for "<Name>" rule
    And web user clicks edit button for rule
    And web user update rule description as "Auto_updated" and expression as "<1000, 20000"
    And web user clicks save button for rule with "<Status>"
    And web user clicks on view icon for "<Name>" rule
    And web user delete the created rule
    Examples:
      | Name           | Description    | Expression   | Used By         | Status |
      | Auto_Rule_Edit | Auto_Rule_Desc | <1000, 10000 | Service Profile | Active |

  Scenario: Verify add rule without filling the required fields
    And web user clicks on rule sub menu
    Then web system displays rule configuration page
    When web user clicks on add button for rule config
    And web user clicks save button for rule with "<Status>"
    Then web system displays validation message for rule config

  Scenario Outline: Verify add rule with duplicate rule name
    And web user clicks on rule sub menu
    Then web system displays rule configuration page
    When web user clicks on add button for rule config
    And web user fills rule config detail "<Name>" "<Description>" "<Expression>" "<Used By>" and "<Status>"
    And web user clicks save button for rule with "<Status>"
    Then web user should see the "<Name>" rule is created

    When web user clicks on add button for rule config
    And web user fills rule config detail "<Name>" "<Description>" "<Expression>" "<Used By>" and "<Status>"
    And web user clicks save button for rule with "<Status>"
    Then verify system displays "Name already exists" error message for rule

    And web user moves mouse over Platform Config main menu
    And web user clicks on rule sub menu
    And web user clicks on view icon for "<Name>" rule
    And web user delete the created rule
    Examples:
      | Name                 | Description    | Expression   | Used By         | Status |
      | Auto_Duplicate_Check | Auto_Rule_Desc | <1000, 10000 | Service Profile | Active |

  Scenario: verify search for rule functionality
    And web user clicks on rule sub menu
    Then web system displays rule configuration page
    When web user click on filter icon for rule
    And web user select "Contains" for the search rule filter criteria
    And web user enters "Rule" into rule search name field
    And web user clicks search rule button
    Then web system displays a list of rules with "Rule" on the name