#  Author: Walelign A.
#  Date: July 05,2023
#  Project name: Shared Wallet
#  Module: Business Configuration
#  Activity: Notification Config
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@NotificationConfiguration

Feature: Notification Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters "Walelign@123" into Username text field
    And web user enters "Walelign@123" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Business Config main menu

  Scenario Outline: Add Platform Access Profile with valid data
    And web user clicks on platform access profile sub menu
    Then web system displays platform access profile configuration page
    When web user clicks on add button for pap
    And web user add PAP config  "<Name>" "<Description>" "<APIGroup>" "<AccessChannel>" "<Authentication>"
    And web user click save button for pap
    Then web user should see the "<Name>" pap is created
    And web user clicks on view icon for "<Name>" pap
    And web user delete the created pap
    Examples:
      | Name     | Description | APIGroup      | AccessChannel       | Authentication |
      | Auto PAP | Auto desc   | API for login | Customer Mobile App | Password       |

  Scenario: Verify add PAP without filling the required fields
    And web user clicks on platform access profile sub menu
    Then web system displays platform access profile configuration page
    When web user clicks on add button for pap
    And web user click save button for pap
    Then web system displays validation message for pap

  Scenario Outline: Edit PAP
    And web user clicks on platform access profile sub menu
    Then web system displays platform access profile configuration page
    When web user clicks on add button for pap
    And web user add PAP config  "<Name>" "<Description>" "<APIGroup>" "<AccessChannel>" "<Authentication>"
    And web user click save button for pap
    Then web user should see the "<Name>" pap is created
    And web user clicks on view icon for "<Name>" pap
    And web user click on edit button for pap
    And web user update pap detail "<UpdatedDescription>" "<APIGroup>" "<AccessChannel>"
    And web user click save button for pap
    Then web user should see the "<Name>" pap is created
    And web user clicks on view icon for "<Name>" pap
    And web user delete the created pap
    Examples:
      | Name          | Description | APIGroup      | AccessChannel       | Authentication | UpdatedDescription |
      | Auto Edit PAP | Auto desc   | API for login | Customer Mobile App | Password       | Updated Desc       |

  Scenario Outline: Add Platform Access Profile with duplicated data
    And web user clicks on platform access profile sub menu
    Then web system displays platform access profile configuration page
    When web user clicks on add button for pap
    And web user add PAP config  "<Name>" "<Description>" "<APIGroup>" "<AccessChannel>" "<Authentication>"
    And web user click save button for pap
    Then web user should see the "<Name>" pap is created
    When web user clicks on add button for pap
    And web user add PAP config  "<Name>" "<Description>" "<APIGroup>" "<AccessChannel>" "<Authentication>"
    And web user click save button for pap
    Then verify system displays "Name already exists" error message for pap
    And web user clicks on view icon for "<Name>" pap
    And web user delete the created pap
    Examples:
      | Name     | Description | APIGroup      | AccessChannel       | Authentication |
      | Auto PAP | Auto desc   | API for login | Customer Mobile App | Password       |

  Scenario: verify search for pap
    And web user clicks on platform access profile sub menu
    Then web system displays platform access profile configuration page
    When web user click on filter icon for pap
    And web user select "Contains" for the search pap filter criteria
    And web user enters "PAP" into pap search name field
    And web user clicks search pap button
    Then web system displays a list of paps with "PAP" on the name
