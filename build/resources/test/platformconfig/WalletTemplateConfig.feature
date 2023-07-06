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
    When web user enters "Walelign@123" into Username text field
    And web user enters "Walelign@123" into password text field
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
