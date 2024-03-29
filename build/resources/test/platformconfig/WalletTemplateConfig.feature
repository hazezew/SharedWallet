#  Author: Walelign A.
#  Date: May July4, 2023
#  Project name: Shared Wallet
#  Module: Platform Configuration
#  Activity: Wallet Template Configuration
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@WalletTemplateConfiguration

Feature: Wallet Template Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters username into username text field
    And web user enters password into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Platform Config main menu

  Scenario Outline: Add Wallet Template with valid data
    And web user clicks on wallet template sub menu
    Then web system displays wallet template Configuration page
    When web user clicks on Add button for wallet template Config
    And web user fills wallet template detail "<Name>" "<Description>" "<Wallet>" and "<Pouch>"
    And web user clicks on save button for wallet template
    Then web user should see the "<Name>" wallet template is created
    And web user clicks on view icon for "<Name>" wallet template
    And web user delete the created wallet template
    Examples:
      | Name                   | Description          | Wallet               | Pouch        |
      | Auto_Customer_Template | Wallet Template desc | Customer Wallet      | Aut_Pouch    |
      | Auto_Agent_Template    | Wallet Template desc | Agent Regular Wallet | EMoney Pouch |

  Scenario: Verify add wallet template without filling the required fields
    And web user clicks on wallet template sub menu
    Then web system displays wallet template Configuration page
    When web user clicks on Add button for wallet template Config
    And web user clicks on save button for wallet template
    Then web system displays validation message for wallet template config

  Scenario: Edit wallet template configuration
    And web user clicks on wallet template sub menu
    Then web system displays wallet template Configuration page
    When web user clicks on Add button for wallet template Config
    And web user fills wallet template detail "Edit_Wallet_Template" "Template desc" "Customer Wallet" and "EMoney Pouch"
    And web user clicks on save button for wallet template
    Then web user should see the "Edit_Wallet_Template" wallet template is created
    And web user clicks on view icon for "Edit_Wallet_Template" wallet template
    When web user clicks edit button for wallet template
    And web user update wallet template "Updated description" "Agent Regular Wallet" and "Aut_Pouch"
    And web user clicks on save button for wallet template
    Then web user should see the "Edit_Wallet_Template" wallet template is created
    And web user clicks on view icon for "Edit_Wallet_Template" wallet template
    And web user delete the created wallet template

  Scenario: Verify add wallet template with duplicated name
    And web user clicks on wallet template sub menu
    Then web system displays wallet template Configuration page
    When web user clicks on Add button for wallet template Config
    And web user fills wallet template detail "Duplicate_Wallet_Template" "Template desc" "Customer Wallet" and "EMoney Pouch"
    And web user clicks on save button for wallet template
    Then web user should see the "Duplicate_Wallet_Template" wallet template is created
    When web user clicks on Add button for wallet template Config
    And web user fills wallet template detail "Duplicate_Wallet_Template" "Template desc" "Customer Wallet" and "EMoney Pouch"
    And web user clicks on save button for wallet template
    Then verify system displays "Name is already in use!" error message for wallet template
    And web user moves mouse over Platform Config main menu
    And web user clicks on wallet template sub menu
    And web user clicks on view icon for "Duplicate_Wallet_Template" wallet template
    And web user delete the created wallet template

  Scenario: verify search for wallet template functionality
    And web user clicks on wallet template sub menu
    Then web system displays wallet template Configuration page
    When web user click on filter icon for Wallet template
    And web user select "Contains" for the search wallet template filter criteria
    And web user enters "Agent" into wallet template search name field
    And web user clicks search wallet template button
    Then web system displays a list of wallet template with "Agent" on the name