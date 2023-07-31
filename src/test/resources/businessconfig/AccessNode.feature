#  Author: Walelign A.
#  Date: July 02,2023
#  Project name: Shared Wallet
#  Module: Business Configuration
#  Activity: Access Node Config
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@AccessNodeConfiguration

Feature: Access Node Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters "Walelign@123" into Username text field
    And web user enters "Walelign@123" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Business Config main menu

  Scenario Outline: Add Access Node with valid data
    And web user clicks on access node sub menu
    Then web system displays access node configuration page
    When web user clicks on add button for access node
    And web user add access node "<Name>" "<Description>" "<AccessType>" "<Message>" "<ResponseCode>"
    And web user click save button for access node
    Then web user should see the "<Name>" access node is created
    And web user clicks on view icon for "<Name>" access node
    And web user delete the created access node

    Examples:
      | Name              | Description | AccessType | Message        | ResponseCode          |
      | Auto Allow Access | Auto desc   | Allow      | Access granted |                       |
      | Auto Block Access | Auto desc   | Block      | Access blocked | Invalid MPIN(-150033) |

  Scenario: Verify add access node without filling the required fields
    And web user clicks on access node sub menu
    Then web system displays access node configuration page
    When web user clicks on add button for access node
    And web user click save button for access node
    Then web system displays validation message for access node

  Scenario Outline: Add Access Node with duplicated data
    And web user clicks on access node sub menu
    Then web system displays access node configuration page
    When web user clicks on add button for access node
    And web user add access node "<Name>" "<Description>" "<AccessType>" "<Message>" "<ResponseCode>"
    And web user click save button for access node
    Then web user should see the "<Name>" access node is created
    When web user clicks on add button for access node
    And web user add access node "<Name>" "<Description>" "<AccessType>" "<Message>" "<ResponseCode>"
    And web user click save button for access node
    Then verify system displays "Name already exists" error message for access node
    And web user clicks on view icon for "<Name>" access node
    And web user delete the created access node
    Examples:
      | Name                   | Description | AccessType | Message        | ResponseCode |
      | Duplicated Access Node | Auto desc   | Allow      | Access granted |              |

  Scenario Outline: Edit Access Node
    And web user clicks on access node sub menu
    Then web system displays access node configuration page
    When web user clicks on add button for access node
    And web user add access node "<Name>" "<Description>" "<AccessType>" "<Message>" "<ResponseCode>"
    And web user click save button for access node
    Then web user should see the "<Name>" access node is created
    When web user clicks on view icon for "<Name>" access node
    And web user click on edit button for access node
    And web user update access node config "<UpdatedDesc>" "<UpdatedAccessType>" "<UpdatedMessage>" "<UpdatedResponseCode>"
    And web user click save button for access node
    Then web user should see the "<Name>" access node is created
    When web user clicks on view icon for "<Name>" access node
    And web user delete the created access node
    Examples:
      | Name                  | Description | AccessType | Message        | UpdatedDesc  | UpdatedAccessType | UpdatedMessage | UpdatedResponseCode   |
      | Auto Edit Access Node | Auto desc   | Allow      | Access granted | updated desc | Block             | Access Blocked | Invalid MPIN(-150033) |

  Scenario: verify search for access node
    And web user clicks on access node sub menu
    Then web system displays access node configuration page
    When web user click on filter icon for access node
    And web user select "Contains" for the search access node filter criteria
    And web user enters "Blocked" into access node search name field
    And web user clicks search access node button
    Then web system displays a list of access nodes with "Blocked" on the name