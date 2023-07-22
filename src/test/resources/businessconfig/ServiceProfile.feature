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
    And web user click save button for service profile
    Then web user should see the "<Name>" service profile is created
    And web user clicks on view icon for "<Name>" service profile
    And web user delete the created service profile
    Examples:
      | Name                 | Description | Type     | Status | AccessChannel       | Service            | Product            | UcpGroup           |
      | Auto Service Profile | Auto desc   | Standard | Active | Customer Mobile App | Cash into customer | Cash into customer | Customer ucp group |

  Scenario: Verify add service provider without filling the required fields
    And web user clicks on service profile sub menu
    Then web system displays service profile configuration page
    When web user clicks on add button for service profile
    And web user click save button for service profile
    Then web system displays validation message for service profile

  Scenario Outline: Update Service Profile Configuration
    And web user clicks on service profile sub menu
    Then web system displays service profile configuration page
    When web user clicks on add button for service profile
    And web user add service profile detail "<Name>" "<Description>" "<Type>" "<Status>"
    And web user configure service profile tree "<AccessChannel>" "<Service>" "<Product>" "<UcpGroup>"
    And web user click save button for service profile
    Then web user should see the "<Name>" service profile is created
    And web user clicks on view icon for "<Name>" service profile
    When web user clicks on edit button for service profile
    And web user update service profile description "Updated Desc" and type "Service Directory"
    And web user click save button for service profile
    Then web user should see the "<Name>" service profile is created
    And web user clicks on view icon for "<Name>" service profile
    And web user delete the created service profile
    Examples:
      | Name                       | Description | Type     | Status | AccessChannel       | Service            | Product            | UcpGroup           |
      | Service Profile for Update | Auto desc   | Standard | Active | Customer Mobile App | Cash into customer | Cash into customer | Customer ucp group |

  Scenario Outline: Add Service Profile with duplicated name
    And web user clicks on service profile sub menu
    Then web system displays service profile configuration page
    When web user clicks on add button for service profile
    And web user add service profile detail "<Name>" "<Description>" "<Type>" "<Status>"
    And web user configure service profile tree "<AccessChannel>" "<Service>" "<Product>" "<UcpGroup>"
    And web user click save button for service profile
    Then web user should see the "<Name>" service profile is created
    When web user clicks on add button for service profile
    And web user add service profile detail "<Name>" "<Description>" "<Type>" "<Status>"
    And web user click save button for service profile
    Then verify system displays "Name already exists" error message for service profile
    And web user moves mouse over Business Config main menu
    And web user clicks on service profile sub menu
    And web user clicks on view icon for "<Name>" service profile
    And web user delete the created service profile
    Examples:
      | Name                 | Description | Type     | Status | AccessChannel       | Service            | Product            | UcpGroup           |
      | Duplicate Service Profile | Auto desc   | Standard | Active | Customer Mobile App | Cash into customer | Cash into customer | Customer ucp group |

  Scenario: verify search for service profile functionality
    And web user clicks on service profile sub menu
    Then web system displays service profile configuration page
    When web user click on filter icon for service profile
    And web user select "Contains" for the search service profile filter criteria
    And web user enters "Customer" into service profile search name field
    And web user clicks search service profile button
    Then web system displays a list of service profiles with "Customer" on the name