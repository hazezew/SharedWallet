#  Author: Walelign A.
#  Date: July 22, 2023
#  Project name: Shared Wallet
#  Module: Operation Configuration
#  Activity: Resend Notification
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@ResendNotification

Feature: Resend Notification

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters "Walelign@123" into Username text field
    And web user enters "Walelign@123" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over operation main menu

  Scenario: Move System Operator
    And web user clicks on resend notification sub menu
    Then web system displays resend notification page