#  Author: Walelign A.
#  Date: July 22, 2023
#  Project name: Shared Wallet
#  Module: Operation Configuration
#  Activity: Transaction Reversal Configuration
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@TransactionReversal

Feature: Transaction Reversal

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters "Walelign@123" into Username text field
    And web user enters "Walelign@123" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over operation main menu

  Scenario Outline: Verify transaction reversal
    And web user clicks on transaction reversal sub menu
    Then web system displays transaction reversal page
    When web user enter transaction reversal detail "<TransactionID>" "<FromDate>" "<ToDate>"
    And web user click search button
    Examples:
      | TransactionID | FromDate            | ToDate              |
      | 0920777547    | 2023-06-01 13:29:11 | 2023-08-01 13:29:45 |

  Scenario: Verify transaction reversal without entering transaction Id
    And web user clicks on transaction reversal sub menu
    Then web system displays transaction reversal page
    And web user click search button
    Then web system displays validation message for transaction reversal
