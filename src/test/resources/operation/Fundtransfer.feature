#  Author: Walelign A.
#  Date: July 22, 2023
#  Project name: Shared Wallet
#  Module: Operation Configuration
#  Activity: Fund Transfer Configuration
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@FundTransfer

Feature: FundTransfer

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters "Walelign@123" into Username text field
    And web user enters "Walelign@123" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over operation main menu

  Scenario: Transfer fund
    And web user clicks on fund transfer sub menu
    Then web system displays fund transfer page
    When web user enters fund detail "<FromAccount>" "<ToAccount>" "<Service>" "<Product>" "<Amount>" "<Remark>" "<Password>"