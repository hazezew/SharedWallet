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
    When web user enters username into username text field
    And web user enters password into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Platform Config main menu

  Scenario: Add Access Channel with valid data
    And web user clicks on access channel sub menu
    Then web system displays access channel configuration page
    When web user clicks on Add button for access channel
#    And web user fills access channel config detail "Auto_MobileApp" "Auto_MobileApp" "Password" and "Password12"
#    Then web system displays "Confirm Sercet not match with secret field" validation message
    And web user fills access channel config detail "Auto_MobileApp" "Auto_AccessChannel" "Password" and "Password"
    And web user set Expiry enable with "5" access token validity and "5" as access token Idle expiry
    And web user select the "Active" of a access token
    And web user clicks save button for access channel
    Then web user should see the "Auto_MobileApp" access channel is created
    And web user clicks on view icon for "Auto_MobileApp" service channel
    And web user delete the created service channel

  Scenario: Edit Access Channel
    And web user clicks on access channel sub menu
    Then web system displays access channel configuration page
    When web user clicks on Add button for access channel
    And web user fills access channel config detail "Auto_MobileApp" "Auto_AccessChannel" "Password" and "Password"
    And web user set Expiry enable with "5" access token validity and "5" as access token Idle expiry
    And web user select the "Active" of a access token
    And web user clicks save button for access channel
    Then web user should see the "Auto_MobileApp" access channel is created
    And web user clicks on view icon for "Auto_MobileApp" service channel
    And web user clicks on Edit button
    And web user update access channel description as "" token validity as "" and token expiry as ""
    And web user clicks save button for access channel
    Then web user should see the "Auto_MobileApp" access channel is created
    And web user clicks on view icon for "Auto_MobileApp" service channel
    And web user delete the created service channel

  Scenario: Verify add access channel without filling the required fields
    And web user clicks on access channel sub menu
    Then web system displays access channel configuration page
    When web user clicks on Add button for access channel
    And web user clicks save button for access channel
    Then web system displays validation message for access channel config

    Scenario: Add access channel with duplicate name
      And web user clicks on access channel sub menu
      Then web system displays access channel configuration page
      When web user clicks on Add button for access channel
      And web user fills access channel config detail "Auto_MobileApp" "Auto_AccessChannel" "Password" and "Password"
      And web user set Expiry enable with "5" access token validity and "5" as access token Idle expiry
      And web user select the "Active" of a access token
      And web user clicks save button for access channel
      Then web user should see the "Auto_MobileApp" access channel is created

      When web user clicks on Add button for access channel
      And web user fills access channel config detail "Auto_MobileApp" "Auto_AccessChannel" "Password" and "Password"
      And web user set Expiry enable with "5" access token validity and "5" as access token Idle expiry
      And web user clicks save button for access channel

      Then verify system displays "Name already exists" error message for access channel
      And web user moves mouse over Platform Config main menu
      And web user clicks on access channel sub menu
      And web user clicks on view icon for "Auto_MobileApp" service channel
      And web user delete the created service channel

  Scenario: verify search for access channel functionality
    And web user clicks on access channel sub menu
    Then web system displays access channel configuration page
    When web user click on filter icon for access channel
    And web user select "Contains" for the search access channel filter criteria
    And web user enters "Mobile" into access channel search name field
    And web user clicks search for access channel button
    Then web system displays a list of access channel with "Mobile" on the name