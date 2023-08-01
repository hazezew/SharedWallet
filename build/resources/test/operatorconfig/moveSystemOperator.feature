#  Author: Walelign A.
#  Date: July 22, 2023
#  Project name: Shared Wallet
#  Module: Operator Configuration
#  Activity: System Operator Configuration
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@MoveSystemOperator

Feature: System Operator Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters "Walelign@123" into Username text field
    And web user enters "Walelign@123" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over operator config main menu

  Scenario: Move System Operator
    And web user clicks on move system operator config sub menu
    Then web system displays move system operator config page
    When web user select "asdfasdf" system operator to move
    And web user select "asdfasf" new system operator entity
    And web user select "asdfasdf" to kyc level
    And web user click move button

  Scenario: Move system operator without entering new system operator
    And web user clicks on move system operator config sub menu
    Then web system displays move system operator config page
    And web user click move button
    Then web system displays validation message for move system operator