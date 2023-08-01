#  Author: Walelign Andargie
#  Date: July 10, 2023
#  Project name: Shared Wallet
#  Module: Technical Config
#  Activity: Standard Master Config
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@StandardMasterConfig

Feature: Standard Master Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters username into username text field
    And web user enters password into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Technical Config main menu

  Scenario: Technical Config
    And web user clicks on standard master sub menu
    Then web system displays standard master page


  Scenario: verify search for standard master
    And web user clicks on standard master sub menu
    Then web system displays standard master page
    When web user click on filter icon for standard master
    And web user select "Contains" for the search standard master filter criteria
    And web user enters "Standard" into standard master search name field
    And web user clicks search standard master button
    Then web system displays a list of standard masters with "Standard" on the name