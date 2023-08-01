#  Author: Walelign A.
#  Date: July 22, 2023
#  Project name: Shared Wallet
#  Module: Operator Configuration
#  Activity: System Operator Entity Configuration
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@SystemOperatorConfiguration

Feature: System Operator Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters username into username text field
    And web user enters password into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over operator config main menu

  Scenario: Add system operator entity with valid data
    And web user clicks on system operator config sub menu
    Then web system displays system operator config page
    When web user click add button for system operator entity
    And web user add SOE "<Name>" "<Description>" "<UserCategory>" "<BusinessZone>" "<PAP>" "<KYC>" "<KYCLevel>" "<Role>" "<TimeZone>"
    And web user click save button for SOE
    Then web user should see the "<Name>" SOE is created
    And web user clicks on view icon for "<Name>" SOE
    And web user delete the created SOE


  Scenario: Verify add SOE without filling the required fields
    And web user clicks on system operator config sub menu
    Then web system displays system operator config page
    When web user click add button for system operator entity
    And web user click save button for SOE
    Then web system displays validation message for SOE

  Scenario: Verify add SOE with duplicated name
    And web user clicks on system operator config sub menu
    Then web system displays system operator config page
    When web user click add button for system operator entity
    And web user add SOE "<Name>" "<Description>" "<UserCategory>" "<BusinessZone>" "<PAP>" "<KYC>" "<KYCLevel>" "<Role>" "<TimeZone>"
    And web user click save button for SOE
    Then web user should see the "<Name>" SOE is created
    When web user click add button for system operator entity
    And web user add SOE "<Name>" "<Description>" "<UserCategory>" "<BusinessZone>" "<PAP>" "<KYC>" "<KYCLevel>" "<Role>" "<TimeZone>"
    And web user click save button for SOE
    Then verify system displays "Name already exists" error message for SOE
    And web user clicks on view icon for "<Name>" SOE
    And web user delete the created SOE

  Scenario: verify search for authentication
    And web user clicks on system operator config sub menu
    Then web system displays system operator config page
    When web user click on filter icon for SOE
    And web user select "Contains" for the search SOE filter criteria
    And web user enters "Customer" into SOE search name field
    And web user clicks search SOE button
    Then web system displays a list of SOEs with "Customer" on the name