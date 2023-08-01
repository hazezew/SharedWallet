#  Author: Walelign A.
#  Date: May 16, 2023
#  Project name: Shared Wallet
#  Module: Platform Configuration
#  Activity: User Category Config
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@UserCategoryConfiguration

Feature: User Category Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters username into username text field
    And web user enters password into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Platform Config main menu

  Scenario Outline: Add User Category with valid data
    And web user clicks on User Category sub menu
    Then web system displays User Category Configuration page
    When web user clicks on Add button for User Category
    And web user fills user category details for "<Name>", "<CategoryType>", "<Description>"
    And web user fills identifier "Full Name" and "Mobile Number" and credential "Agent Password" and "Password" fields
    And web user clicks add identifier field
    And web user click remove user identifier button
    And web user click save user category
    Then web user should see the "<Name>" user category is created
    Then web user click view icon for "<Name>" user category
    Then web user delete the created user category
    Examples:
      | Name          | CategoryType | Description               |
      | Auto_Customer | BusinessUser | Auto_Customer Description |
      | Auto_Agent    | Customer     | Auto_Agent Description    |

  Scenario Outline: Edit User Category
    And web user clicks on User Category sub menu
    Then web system displays User Category Configuration page
    When web user clicks on Add button for User Category
    And web user fills user category details for "<Name>", "<CategoryType>", "<Description>"
    And web user fills identifier "Full Name" and "Mobile Number" and credential "Agent Password" and "Password" fields
    And web user clicks add identifier field
    And web user click remove user identifier button
    And web user click save user category
    Then web user should see the "<Name>" user category is created
    Then web user click view icon for "<Name>" user category
    Then web user click edit icon for user category
    Then web user update category type to "Customer" and description to "Auto_updated_desc"
    And web user click save user category
    Then web user should see the "<Name>" user category is created
    Then web user click view icon for "<Name>" user category
    Then web user delete the created user category
    Examples:
      | Name          | CategoryType | Description               |
      | Auto_Customer | BusinessUser | Auto_Customer Description |
      | Auto_Agent    | Customer     | Auto_Agent Description    |

  Scenario: Verify add User Category with duplicate name
    And web user clicks on User Category sub menu
    Then web system displays User Category Configuration page
    When web user clicks on Add button for User Category
    And web user fills user category details for "Auto_Duplicate_Check", "BusinessUser", "Auto_desc"
    And web user fills identifier "Full Name" and "Mobile Number" and credential "Agent Password" and "Password" fields
    And web user clicks add identifier field
    And web user click remove user identifier button
    And web user click save user category
    Then web user should see the "Auto_Duplicate_Check" user category is created

    When web user clicks on Add button for User Category
    And web user fills user category details for "Auto_Duplicate_Check", "BusinessUser", "Auto_desc"
    And web user fills identifier "Full Name" and "Mobile Number" and credential "Agent Password" and "Password" fields

    And web user click save user category
    Then verify system displays "Name already Exists" error message for user category

    And web user moves mouse over Platform Config main menu
    And web user clicks on User Category sub menu
    Then web user click view icon for "Auto_Duplicate_Check" user category
    Then web user delete the created user category

  Scenario: Verify add category with empty required field
    And web user clicks on User Category sub menu
    Then web system displays User Category Configuration page
    When web user clicks on Add button for User Category
    And web user click save user category
    Then verify system displays validation message

  Scenario: Verify filter and search functionality for user category
    And web user clicks on User Category sub menu
    Then web system displays User Category Configuration page
    When web user click on filter icon on user category
    And web user select "Contains" for the search filter criteria
    And web user enters "Customer" into search name field
    And web user clicks search button
    Then web system displays a list of user categories contains "Customer" on the name