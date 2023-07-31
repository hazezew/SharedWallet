#  Author: Walelign Andargie
#  Date: July 10, 2023
#  Project name: Shared Wallet
#  Module: Technical Config
#  Activity: Process Configuration
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@ProcessConfiguration

Feature: Process Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters "Walelign@123" into Username text field
    And web user enters "Walelign@123" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Technical Config main menu

  Scenario: Technical Config
    And web user clicks on process config sub menu
    Then web system displays process config page