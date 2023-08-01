#  Author: Walelign A.
#  Date: July 22, 2023
#  Project name: Shared Wallet
#  Module: Operation Configuration
#  Activity: Add Money Configuration
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@Add MoneyConfiguration

Feature: Add Money Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters username into username text field
    And web user enters password into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over operation main menu

  Scenario: Move System Operator
    And web user clicks on add money sub menu
    Then web system displays add money page
    When web user input add money detail "<FromUser>" "<FromWallet>" "<FromPouch>" "<ToUser>" "<ToWallet>" "<ToPouch>" "<Amount>" "<Service>" "<Product>" "<Remark>"