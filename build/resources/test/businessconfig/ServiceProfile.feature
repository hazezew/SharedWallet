#  Author: Walelign A.
#  Date: July 05,2023
#  Project name: Shared Wallet
#  Module: Business Configuration
#  Activity: Service Profile Config
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@ServiceProfileConfiguration

Feature: Service Profile Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters "Walelign@123" into Username text field
    And web user enters "Walelign@123" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Business Config main menu

  Scenario Outline: Add Service Profile with valid data
    And web user clicks on service profile sub menu
    Then web system displays service profile configuration page
    When web user clicks on add button for service profile
    And web user add service profile detail "<Name>" "<Description>" "<Type>" "<Status>"
    And web user configure service profile tree "<AccessChannel>" "<Service>" "<Product>" "<UcpGroup>"
    Examples:
      | Name                 | Description | Type     | Status | AccessChannel       | Service            | Product            | UcpGroup           |
      | Auto Service Profile | Auto desc   | Standard | Active | Customer Mobile App | Cash into customer | Cash into customer | Customer ucp group |