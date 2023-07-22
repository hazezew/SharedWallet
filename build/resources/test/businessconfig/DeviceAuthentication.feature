#  Author: Walelign A.
#  Date: July 05,2023
#  Project name: Shared Wallet
#  Module: Business Configuration
#  Activity: Device Authentication Config
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@DeviceAuthenticationConfiguration

Feature: Device Authentication Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters "Walelign@123" into Username text field
    And web user enters "Walelign@123" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Business Config main menu

  Scenario Outline: Add Device Authentication with valid data
    And web user clicks on device authentication sub menu
    Then web system displays device authentication configuration page
    When web user clicks on add button for device authentication
    And web user add device authentication "<Name>" "<Description>" "<AllowedRadius>" "<AllowedDeviceStatus>" "<PacketField>" "<Parameter1>"
    And web user click save button for device authentication
    Then web user should see the "<Name>" device authentication is created
    And web user clicks on view icon for "<Name>" device authentication
    And web user delete the created device authentication
    Examples:
      | Name                  | Description | AllowedRadius | AllowedDeviceStatus | PacketField    | Parameter1 |
      | Device Authentication | Auto desc   | 5             | Active              | DeviceUniqueId | MPIN       |


  Scenario Outline: Edit Device Authentication Configuration
    And web user clicks on device authentication sub menu
    Then web system displays device authentication configuration page
    When web user clicks on add button for device authentication
    And web user add device authentication "<Name>" "<Description>" "<AllowedRadius>" "<AllowedDeviceStatus>" "<PacketField>" "<Parameter1>"
    And web user click save button for device authentication
    Then web user should see the "<Name>" device authentication is created
    And web user clicks on view icon for "<Name>" device authentication
    And web user click on edit button for device authentication
    And web user update device authentication config des "updated" radius "10" status "Inactive" parameter "Param"
    And web user click save button for device authentication
    Then web user should see the "<Name>" device authentication is created
    And web user clicks on view icon for "<Name>" device authentication
    And web user delete the created device authentication
    Examples:
      | Name                       | Description | AllowedRadius | AllowedDeviceStatus | PacketField    | Parameter1 |
      | Edit Device Authentication | Auto desc   | 5             | Active              | DeviceUniqueId | MPIN       |

  Scenario: Verify add device authentication without filling the required fields
    And web user clicks on device authentication sub menu
    Then web system displays device authentication configuration page
    When web user clicks on add button for device authentication
    And web user click save button for device authentication
    Then web system displays validation message for device authentication

  Scenario Outline: Add Device Authentication with duplicated data
    And web user clicks on device authentication sub menu
    Then web system displays device authentication configuration page
    When web user clicks on add button for device authentication
    And web user add device authentication "<Name>" "<Description>" "<AllowedRadius>" "<AllowedDeviceStatus>" "<PacketField>" "<Parameter1>"
    And web user click save button for device authentication
    Then web user should see the "<Name>" device authentication is created
    When web user clicks on add button for device authentication
    And web user add device authentication "<Name>" "<Description>" "<AllowedRadius>" "<AllowedDeviceStatus>" "<PacketField>" "<Parameter1>"
    And web user click save button for device authentication
    Then verify system displays "Name already exists" error message for device authentication
    And web user moves mouse over Business Config main menu
    And web user clicks on device authentication sub menu
    And web user clicks on view icon for "<Name>" device authentication
    And web user delete the created device authentication
    Examples:
      | Name                             | Description | AllowedRadius | AllowedDeviceStatus | PacketField    | Parameter1 |
      | Duplicated Device Authentication | Auto desc   | 5             | Active              | DeviceUniqueId | MPIN       |

  Scenario: verify search for device authentication
    And web user clicks on device authentication sub menu
    Then web system displays device authentication configuration page
    When web user click on filter icon for device authentication
    And web user select "Contains" for the search device authentication filter criteria
    And web user enters "Device Authentication" into device authentication search name field
    And web user clicks search device authentication button
    Then web system displays a list of device authentications with "Device Authentication" on the name
