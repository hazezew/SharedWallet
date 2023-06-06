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

  Scenario Outline: Add Pouch with valid data
    When web user clicks on Pouch sub menu
    Then web system displays Pouch Configuration page
    When web user clicks on Add button for Pouch Config
    And web user fills pouch config detail "<Name>" "<Description>" "<PouchType>" "<Currency>" "<PouchAllocation>"and"<ProvisionType>"
    When web user clicks add parameter
    And web user add extra parameter "Pouch Parameter" as parameter and "Mobile Number" as default value
    And web user click "Active" status
    And web user clicks save button
    Then web user should see the "<Name>" pouch is created
    When web user clicks view icon for "<Name>" pouch
    Then web user delete the created pouch
    Examples:
      | Name                | Description            | PouchType | Currency | PouchAllocation | ProvisionType |
      | Auto_EMoney_Pouch   | Auto_Pouch_Description | Monetary  | ETB      | Balance         | Default Pouch |
      | Auto_Customer_Pouch | Auto_Pouch_Description | Monetary  | ETB      | Credit          | Ondemand      |

    Scenario: Edit Pouch configuration
      When web user clicks on Pouch sub menu
      Then web system displays Pouch Configuration page
      When web user clicks on Add button for Pouch Config
      And web user fills pouch config detail "Aut_Pouch" "Auto_Description" "Monetary" "ETB" "Balance"and"Default Pouch"
      When web user clicks add parameter
      And web user add extra parameter "Pouch Parameter" as parameter and "Mobile Number" as default value
      And web user click "Active" status
      And web user clicks save button
      Then web user should see the "Aut_Pouch" pouch is created
      When web user clicks view icon for "Aut_Pouch" pouch
      And web user clicks edit button for pouch
      And web user update pouch description as "Updated_description" status as "Inactive"
      And web user allows transaction for pouch
      And web user clicks save button
      Then web user should see the "Aut_Pouch" pouch is created
      When web user clicks view icon for "Aut_Pouch" pouch
      Then web user delete the created pouch

  Scenario: Verify add pouch without filling the required fields
    When web user clicks on Pouch sub menu
    Then web system displays Pouch Configuration page
    When web user clicks on Add button for Pouch Config
    And web user click "Inactive" status
    And web user clicks save button
    Then web system displays validation message for pouch config

  Scenario: Verify add pouch with duplicate pouch name
    When web user clicks on Pouch sub menu
    Then web system displays Pouch Configuration page
    When web user clicks on Add button for Pouch Config
    And web user fills pouch config detail "Aut_Pouch_Duplicate" "Auto_Description" "Monetary" "ETB" "Balance"and"Default Pouch"
    When web user clicks add parameter
    And web user add extra parameter "Pouch Parameter" as parameter and "Mobile Number" as default value
    And web user click "Active" status
    And web user clicks save button
    Then web user should see the "Aut_Pouch" pouch is created

    When web user clicks on Add button for Pouch Config
    And web user fills pouch config detail "Aut_Pouch_Duplicate" "Auto_Description" "Monetary" "ETB" "Balance"and"Default Pouch"
    And web user clicks save button
    Then verify system displays "Name already exists" error message for pouch

    And web user moves mouse over Platform Config main menu
    When web user clicks on Pouch sub menu
    When web user clicks view icon for "Aut_Pouch_Duplicate" pouch
    Then web user delete the created pouch

  Scenario: verify search for pouch functionality
    When web user clicks on Pouch sub menu
    Then web system displays Pouch Configuration page
    When web user click on filter icon for pouch
    And web user select "Contains" for the search pouch filter criteria
    And web user enters "Customer" into pouch search name field
    And web user clicks search pouch button
    Then web system displays a list of pouchs with "Customer" on the name