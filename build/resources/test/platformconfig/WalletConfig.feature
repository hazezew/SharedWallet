#  Author: Walelign A.
#  Date: May 26, 2023
#  Project name: Shared Wallet
#  Module: Platform Configuration
#  Activity: Wallet Configuration
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@WalletConfiguration

Feature: Wallet Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters "Walelign@123" into Username text field
    And web user enters "Walelign@123" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Platform Config main menu

  Scenario Outline: Add Wallet with valid data
    And web user clicks on wallet sub menu
    Then web system displays Wallet Configuration page
    When web user clicks on Add button for Wallet Config
    And web user fills wallet config detail "<Name>" "<Description>" and "<WalletType>"
    And web user select the status "<Status>" for wallet
    And web user clicks save button with "<Status>" for wallet
    Then web user should see the "<Name>" wallet is created
    And web user clicks on view icon for "<Name>" wallet
    And web user delete the created wallet

    Examples:
      | Name                 | Description     | WalletType     | Status |
      | Auto_Customer Wallet | Customer Wallet | Trust Account  | Active |
      | Auto_Trust Wallet    | Trust Wallet    | Regular Wallet | Active |

  Scenario: Edit wallet configuration
    When web user clicks on wallet sub menu
    Then web system displays Wallet Configuration page
    When web user clicks on Add button for Wallet Config
    And web user fills wallet config detail "Auto_Customer Wallet" "Customer Wallet" and "Trust Account"
    And web user select the status "Active" for wallet
    And web user clicks save button with "Active" for wallet
    Then web user should see the "Auto_Customer Wallet" wallet is created
    And web user clicks on view icon for "Auto_Customer Wallet" wallet
    When web user clicks edit button for wallet
    And web user update wallet "Updated description" and status to "Inactive"
    And web user clicks save button with "Inactive" for wallet
    Then web user should see the "Auto_Customer Wallet" wallet is created
    And web user clicks on view icon for "Auto_Customer Wallet" wallet
    And web user delete the created wallet

  Scenario: Verify add wallet with duplicate name
    And web user clicks on wallet sub menu
    Then web system displays Wallet Configuration page
    When web user clicks on Add button for Wallet Config
    And web user fills wallet config detail "Auto_Wallet_duplicate" "Auto_Description" and "Regular Wallet"
    And web user select the status "Active" for wallet
    And web user clicks save button with "Active" for wallet
    Then web user should see the "Auto_Wallet_duplicate" wallet is created
    When web user clicks on Add button for Wallet Config
    And web user fills wallet config detail "Auto_Wallet_duplicate" "Auto_Description" and "Regular Wallet"
    And web user clicks save button with "Active" for wallet
    Then verify system displays "Name already exists" error message
    And web user moves mouse over Platform Config main menu
    When web user clicks on wallet sub menu
    And web user clicks on view icon for "Auto_Wallet_duplicate" wallet
    And web user delete the created wallet


  Scenario: verify search for wallet functionality
    And web user clicks on wallet sub menu
    Then web system displays Wallet Configuration page
    When web user click on filter icon for Wallet
    And web user select "Contains" for the search wallet filter criteria
    And web user enters "Agent" into wallet search name field
    And web user clicks search wallet button
    Then web system displays a list of wallet with "Agent" on the name

  Scenario: Verify add wallet without filling the required fields
    And web user clicks on wallet sub menu
    Then web system displays Wallet Configuration page
    When web user clicks on Add button for Wallet Config
    And web user select the status "Active" for wallet
    And web user clicks save button with "Active" for wallet
    Then web system displays validation message for wallet config

  Scenario: Verify export functionality
    When web user clicks on wallet sub menu
    And web user clicks on export button
    And web user enters "Auto Export Wallet" and "Auto_Description" into wallet export fields
    And web user clicks save export history button for wallet
    Then web user verify "Auto Export Wallet" record created in export history
