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
    When web user enters "Walelign@123" into Username text field
    And web user enters "Walelign@123" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Technical Config main menu

  Scenario: Add Field Mapping
    And web user clicks on Field Mapping sub menu
    Then web system displays Field Mapping page
    And web user clicks on settings link
    And web user clicks on Logout link

  Scenario: Verify add field mapping without filling the required fields
    And web user clicks on Field Mapping sub menu
    Then web system displays Field Mapping page
    When web user click add button for field mapping
    And web user click save button for field mapping
    Then web system displays validation message for field mapping


  Scenario: verify search for role
    And web user clicks on Field Mapping sub menu
    Then web system displays Field Mapping page
    When web user click on filter icon for field mapping
    And web user select "Contains" for the search field mapping filter criteria
    And web user enters "Customer" into field mapping search name field
    And web user clicks search field mapping button
    Then web system displays a list of field mappings with "Customer" on the name