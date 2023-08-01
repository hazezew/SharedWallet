#  Author: Walelign A.
#  Date: June 18, 2023
#  Project name: Shared Wallet
#  Module: Platform Configuration
#  Activity: Product Group Configuration
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@ProductGroupConfiguration

Feature: Product Group Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters username into username text field
    And web user enters password into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Platform Config main menu

  Scenario Outline: Add Product Group with valid data
    And web user clicks on product group sub menu
    Then web system displays product group configuration page
    When web user clicks on add button for product group config
    And web user add product group details "<Name>" "<Description>" "<Product>" and "<Status>"
    And web user add settlement detail "<Rule>" and "<SettlementGroup>"
    And web user clicks on save button for product group
    Then web user should see the "<Name>" product group is created
    When web user clicks view icon for "<Name>" product group
    Then web user delete the created product group
    Examples:
      | Name               | Description         | Product             | Status | Rule          | SettlementGroup    |
      | Auto_Product_Group | Auto_PG_Description | Cash in to customer | Active | Cash in limit | Cash in settlement |

  Scenario: Verify add product group without filling the required fields
    And web user clicks on product group sub menu
    Then web system displays product group configuration page
    When web user clicks on add button for product group config
    And web user clicks on save button for product group
    Then web system displays validation message for product group config

  Scenario Outline: Edit Product Group Configuration
    And web user clicks on product group sub menu
    Then web system displays product group configuration page
    When web user clicks on add button for product group config
    And web user add product group details "<Name>" "<Description>" "<Product>" and "<Status>"
    And web user add settlement detail "<Rule>" and "<SettlementGroup>"
    And web user clicks on save button for product group
    Then web user should see the "<Name>" product group is created
    When web user clicks view icon for "<Name>" product group
    And web user clicks edit button for product group
    And web user update product group details "Updated Description" "Cash out from customer" and "Active"
    And web user clicks on save button for product group
    Then web user should see the "<Name>" product group is created
    When web user clicks view icon for "<Name>" product group
    Then web user delete the created product group
    Examples:
      | Name                    | Description         | Product             | Status | Rule          | SettlementGroup    |
      | Auto_Edit_Product_Group | Auto_PG_Description | Cash in to customer | Active | Cash in limit | Cash in settlement |

  Scenario: verify search for product group functionality
    And web user clicks on product group sub menu
    Then web system displays product group configuration page
    When web user click on filter icon for product group
    And web user select "Contains" for the search product group filter criteria
    And web user enters "Product Group" into product group search name field
    And web user clicks search product group button
    Then web system displays a list of product groups with "Product Group" on the name


  Scenario Outline: Verify add product group with duplicate product group name
    And web user clicks on product group sub menu
    Then web system displays product group configuration page
    When web user clicks on add button for product group config
    And web user add product group details "<Name>" "<Description>" "<Product>" and "<Status>"
    And web user add settlement detail "<Rule>" and "<SettlementGroup>"
    And web user clicks on save button for product group
    Then web user should see the "<Name>" product group is created

    When web user clicks on add button for product group config
    And web user add product group details "<Name>" "<Description>" "<Product>" and "<Status>"
    And web user clicks on save button for product group
    Then verify system displays "Name already exists" error message for product group

    And web user moves mouse over Platform Config main menu
    And web user clicks on product group sub menu
    When web user clicks view icon for "<Name>" product group
    Then web user delete the created product group
    Examples:
      | Name               | Description         | Product             | Status | Rule          | SettlementGroup    |
      | Auto_Product_Group | Auto_PG_Description | Cash in to customer | Active | Cash in limit | Cash in settlement |