#  Author: Walelign A.
#  Date: May 23, 2023
#  Project name: Shared Wallet
#  Module: User Management
#  Activity: View User
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@UnitConfiguration

Feature: Unit Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters "Walelign@123" into Username text field
    And web user enters "Walelign@123" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Platform Config main menu

  Scenario Outline: Add Unit with valid data
    And web user clicks on Unit sub menu
    Then web system displays Unit Configuration page
    When web user clicks on Add button for Unit Config
    And web user fills unit config detail "<Name>" "<Description>" "<UnitType>" and "<SubUnitType>"
    And web user select the "<Status>" of a unit
    And web user clicks save button with "<Status>"
    Then web user should see the "<Name>" unit is created
    And web user clicks on view icon for "<Name>" unit
    And web user delete the created unit
    Examples:
      | Name                    | Description             | UnitType    | Status   | SubUnitType |
      | Auto_EMoney_Unit        | Auto_EMoney_Description | MONETARY    | Active   | General     |
      | Auto_EMoney_NonMonetary | Auto_EMoney_Description | NONMONETARY | Inactive | Stock Based |

  Scenario: Verify add unit without filling the required fields
    And web user clicks on Unit sub menu
    Then web system displays Unit Configuration page
    When web user clicks on Add button for Unit Config
    And web user select the "Active" of a unit
    And web user clicks save button with "Active"
    Then web system displays validation message for unit config

  Scenario: Edit unit configuration
    And web user clicks on Unit sub menu
    Then web system displays Unit Configuration page
    When web user clicks on Add button for Unit Config
    And web user fills unit config detail "Auto_EMoney_Unit" "Auto_Desc" "MONETARY" and "General"
    And web user select the "Active" of a unit
    And web user clicks save button with "Active"
    Then web user should see the "Auto_EMoney_Unit" unit is created
    And web user clicks on view icon for "Auto_EMoney_Unit" unit
    And web user clicks edit button
    And web user update description as "Auto_Updated_Desc" UnitType as "NONMONETARY" and "Stock Based"
    And web user clicks save button with "Active"
    Then web user should see the "Auto_EMoney_Unit" unit is created
    And web user clicks on view icon for "Auto_EMoney_Unit" unit
    And web user delete the created unit

  Scenario: verify search for unit functionality
    And web user clicks on Unit sub menu
    Then web system displays Unit Configuration page
    When web user click on filter icon for unit
    And web user select "Contains" for the search unit filter criteria
    And web user enters "EMoney" into unit search name field
    And web user clicks search unit button
    Then web system displays a list of units with "EMoney" on the name

  Scenario: Verify add Unit with duplicate unit name
    And web user clicks on Unit sub menu
    Then web system displays Unit Configuration page
    When web user clicks on Add button for Unit Config
    And web user fills unit config detail "Auto_Duplicate_Unit1" "Auto_desc" "MONETARY" and "General"
    And web user select the "Active" of a unit
    And web user clicks save button with "Active"
    Then web user should see the "Auto_Duplicate_Unit1" unit is created

    When web user clicks on Add button for Unit Config
    And web user fills unit config detail "Auto_Duplicate_Unit1" "Auto_desc" "MONETARY" and "General"
    And web user clicks save button with "Active"
    Then verify system displays "Name already exists" error message for unit
    And web user moves mouse over Platform Config main menu
    And web user clicks on Unit sub menu
    And web user clicks on view icon for "Auto_Duplicate_Unit1" unit
    And web user delete the created unit
