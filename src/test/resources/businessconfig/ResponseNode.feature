#  Author: Walelign A.
#  Date: July 05,2023
#  Project name: Shared Wallet
#  Module: Business Configuration
#  Activity: Response Node Config
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@ResponseNodeConfiguration

Feature: Response Node Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters "Walelign@123" into Username text field
    And web user enters "Walelign@123" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Business Config main menu

  Scenario Outline: Add Response Node with valid data
    And web user clicks on response node sub menu
    Then web system displays response node configuration page
    When web user clicks on add button for response node
    And web user add response node detail "<Name>" "<Description>" "<Message>" "<ResponseCode>"
    And web user click save button for response node
    Then web user should see the "<Name>" response node is created
    And web user clicks on view icon for "<Name>" response node
    And web user delete the created response node
    Examples:
      | Name               | Description | Message               | ResponseCode               |
      | Auto Response node | Auto desc   | Response code message | CashIn daily limit reached |

  Scenario: Verify add Response Node without filling the required fields
    And web user clicks on response node sub menu
    Then web system displays response node configuration page
    When web user clicks on add button for response node
    And web user click save button for response node
    Then web system displays validation message for response node

  Scenario Outline: Add Response Node with duplicated name
    And web user clicks on response node sub menu
    Then web system displays response node configuration page
    When web user clicks on add button for response node
    And web user add response node detail "<Name>" "<Description>" "<Message>" "<ResponseCode>"
    And web user click save button for response node
    Then web user should see the "<Name>" response node is created
    When web user clicks on add button for response node
    And web user add response node detail "<Name>" "<Description>" "<Message>" "<ResponseCode>"
    And web user click save button for response node
    Then verify system displays "Name already exists" error message for response node

    Examples:
      | Name                    | Description | Message               | ResponseCode               |
      | Duplicate Response node | Auto desc   | Response code message | CashIn daily limit reached |

  Scenario Outline: Update Response Node Configuration
    And web user clicks on response node sub menu
    Then web system displays response node configuration page
    When web user clicks on add button for response node
    And web user add response node detail "<Name>" "<Description>" "<Message>" "<ResponseCode>"
    And web user click save button for response node
    Then web user should see the "<Name>" response node is created
    And web user clicks on view icon for "<Name>" response node
    And web user clicks on edit button for response node
    And web user update response node "<UpdatedDescription>" "<UpdatedResponseCode>" "<UpdatedMessage>"
    And web user click save button for response node
    Then web user should see the "<Name>" response node is created
    And web user clicks on view icon for "<Name>" response node
    And web user delete the created response node
    Examples:
      | Name                     | Description | Message               | ResponseCode               | UpdatedDescription | UpdatedResponseCode         | UpdatedMessage  |
      | Response node for Update | Auto desc   | Response code message | CashIn daily limit reached | Updated desc       | CashOut daily limit reached | updated message |

  Scenario: verify search for response node functionality
    And web user clicks on response node sub menu
    Then web system displays response node configuration page
    When web user click on filter icon for response node
    And web user select "Contains" for the search response node filter criteria
    And web user enters "Cash in" into response node search name field
    And web user clicks search response node button
    Then web system displays a list of response nodes with "Cash in" on the name