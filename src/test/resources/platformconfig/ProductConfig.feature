#  Author: Walelign A.
#  Date: June 18, 2023
#  Project name: Shared Wallet
#  Module: Platform Configuration
#  Activity: Product Configuration
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@ProductConfiguration

Feature: Product Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters username into username text field
    And web user enters password into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Platform Config main menu

  Scenario Outline: Add Product with valid data
    And web user clicks on product sub menu
    Then web system displays product configuration page
    When web user clicks on add button for product config
    And web user adds product config detail "<Name>" "<Display Name>" "<Description>" "<Used By>" "<Service>" "<Product Type>" "<Product Subtype>" "<Denomination>" "<Product Value>" and "<Display Order>"
    And web user clicks on save button for product
    Then web user should see the "<Name>" product is created
    And web user clicks on view icon for "<Name>" product
    And web user delete the created product

    Examples:
      | Name          | Display Name      | Description | Used By         | Service  | Product Type      | Product Subtype | Denomination | Product Value | Display Order |
      | Auto_Cash_In  | Agent Cash In     | Cash In     | Service Profile | Cash_Out | Transactional     | General         | Fix          | 20            | 1             |
      | Auto_Cash_Out | Customer Cash Out | Cash out    | Service Profile | Cash_Out | Non Transactional |                 |              |               | 2             |

  Scenario Outline: Verify add Product with duplicate Product name
    And web user clicks on product sub menu
    Then web system displays product configuration page
    When web user clicks on add button for product config
    And web user adds product config detail "<Name>" "<Display Name>" "<Description>" "<Used By>" "<Service>" "<Product Type>" "<Product Subtype>" "<Denomination>" "<Product Value>" and "<Display Order>"
    And web user clicks on save button for product
    Then web user should see the "<Name>" product is created
    When web user clicks on add button for product config
    And web user adds product config detail "<Name>" "<Display Name>" "<Description>" "<Used By>" "<Service>" "<Product Type>" "<Product Subtype>" "<Denomination>" "<Product Value>" and "<Display Order>"
    And web user clicks on save button for product
    Then verify system displays "Name already exists" error message for product
    And web user moves mouse over Platform Config main menu
    And web user clicks on product sub menu
    And web user clicks on view icon for "<Name>" product
    And web user delete the created product

    Examples:
      | Name                 | Display Name  | Description | Used By         | Service  | Product Type  | Product Subtype | Denomination | Product Value | Display Order |
      | Auto_Duplicate_Check | Agent Cash In | Cash In     | Service Profile | Cash_Out | Transactional | General         | Fix          | 20            | 1             |

  Scenario: Verify add product without filling the required fields
    And web user clicks on product sub menu
    Then web system displays product configuration page
    When web user clicks on add button for product config
    And web user clicks on save button for product
    Then web system displays validation message for product config

  Scenario Outline: Verify Edit Product Config
    And web user clicks on product sub menu
    Then web system displays product configuration page
    When web user clicks on add button for product config
    And web user adds product config detail "<Name>" "<Display Name>" "<Description>" "<Used By>" "<Service>" "<Product Type>" "<Product Subtype>" "<Denomination>" "<Product Value>" and "<Display Order>"
    And web user clicks on save button for product
    Then web user should see the "<Name>" product is created
    And web user clicks on view icon for "<Name>" product
    And web user clicks  edit button for product

    Examples:
      | Name              | Display Name  | Description | Used By         | Service  | Product Type  | Product Subtype | Denomination | Product Value | Display Order |
      | Auto_Product_Edit | Agent Cash In | Cash In     | Service Profile | Cash_Out | Transactional | General         | Fix          | 20            | 1             |
