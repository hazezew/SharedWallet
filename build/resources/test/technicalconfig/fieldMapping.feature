#  Author: Habitamu Azezew
#  Date: May 06, 2023
#  Project name: Shared Wallet
#  Module: Technical Config
#  Activity: Field Mapping
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@FieldMapping

Feature: Field Mapping
  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters "Habtamu@eth" into Username text field
    And web user enters "Habtamu@748" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Technical Config main menu
    And web user clicks on Field Mapping sub menu
    Then web system displays Field Mapping page

  Scenario: Technical Config
#    Add the required steps when implementation is completed
    And web user clicks on settings link
    And web user clicks on Logout link