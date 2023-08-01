#  Author: Walelign A.
#  Date: May 30, 2023
#  Project name: Shared Wallet
#  Module: Platform Configuration
#  Activity: KYC Management
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@UnitConfiguration

Feature: KYC Management

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters username into username text field
    And web user enters password into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Platform Config main menu

  Scenario: Add Kyc with valid data
    When web user clicks on KYC sub menu
    Then web system displays KYC Configuration page
    When web user clicks on Add button for KYC Config
    And web user fills kyc details name as "Auto_Customer_KYC" description as "KYC_Desc" and status "Active"
    And web user select kyc level as "Agent LKYC"
    And web user click add new step button
    And web user enters "Auto_Kyc_step" in to kyc step name field
    And web user add field group with name as "Auto_Field_Group" description as "Auto_descr" and display name as "Auto_Display"
    And web user selects parameters "Full Name" "MPIN" and "Email" in to field group
    And web user clicks on save button for kyc
    Then web user should see the "Auto_Customer_KYC" kyc is created
    When web user clicks view icon for "Auto_Customer_KYC" kyc
    Then web user delete the created kyc

  Scenario: Edit Kyc Configuration
    When web user clicks on KYC sub menu
    Then web system displays KYC Configuration page
    When web user clicks on Add button for KYC Config
    And web user fills kyc details name as "Auto_Customer_KYC" description as "KYC_Desc" and status "Active"
    And web user select kyc level as "Agent LKYC"
    And web user click add new step button
    And web user enters "Auto_Kyc_step" in to kyc step name field
    And web user add field group with name "Auto_group" from library
    And web user clicks on save button for kyc
    Then web user should see the "Auto_Customer_KYC" kyc is created
    When web user clicks view icon for "Auto_Customer_KYC" kyc
    And web user clicks edit button for kyc
    And web user add field group with name as "Auto_Field_Group1" description as "Auto_descr" and display name as "Auto_Display"
    And web user selects parameters "Date of birth" "Mobile Number" and "Password" in to field group
    And web user clicks on save button for kyc
    Then web user should see the "Auto_Customer_KYC" kyc is created
    When web user clicks view icon for "Auto_Customer_KYC" kyc
    Then web user delete the created kyc

  Scenario: Verify add kyc without filling the required fields
    When web user clicks on KYC sub menu
    Then web system displays KYC Configuration page
    When web user clicks on Add button for KYC Config
    And web user clicks on save button for kyc
    Then web system displays validation message for kyc config

    Scenario: Verify add kyc with existing kyc name
      When web user clicks on KYC sub menu
      Then web system displays KYC Configuration page
      When web user clicks on Add button for KYC Config
      And web user fills kyc details name as "Auto_Customer_KYC" description as "KYC_Desc" and status "Active"
      And web user select kyc level as "Agent LKYC"
      And web user click add new step button
      And web user enters "Auto_Kyc_step" in to kyc step name field
      And web user add field group with name "Auto_group" from library
      And web user clicks on save button for kyc
      Then web user should see the "Auto_Customer_KYC" kyc is created
      When web user clicks on Add button for KYC Config
      And web user fills kyc details name as "Auto_Customer_KYC" description as "KYC_Desc" and status "Active"
      And web user select kyc level as "Agent LKYC"
      And web user clicks on save button for kyc
      Then verify system displays "Name already exists" error message for kyc
      And web user moves mouse over Platform Config main menu
      When web user clicks on KYC sub menu
      When web user clicks view icon for "Auto_Customer_KYC" kyc
      Then web user delete the created kyc

  Scenario: verify search functionality for kyc
    When web user clicks on KYC sub menu
    Then web system displays KYC Configuration page
    When web user click on filter icon for kyc
    And web user select "Contains" for the search kyc filter criteria
    And web user enters "Customer" into kyc search name field
    And web user clicks search kyc button
    Then web system displays a list of kyc's with "Customer" on the name