#  Author: Walelign A.
#  Date: May 23, 2023
#  Project name: Shared Wallet
#  Module: Platform Configuration
#  Activity: Access channel config
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@AccessChannelConfiguration

Feature: Access Channel Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters "Walelign@123" into Username text field
    And web user enters "Walelign@123" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Platform Config main menu

  Scenario: Add Access Channel with valid data
    And web user clicks on access channel sub menu
    Then web system displays access channel configuration page
    When web user clicks on Add button for access channel
    And web user fills access channel config detail "Auto_MobileApp" "Auto_AccessChannel" "Password" and "Password12"

