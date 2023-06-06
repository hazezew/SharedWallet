#  Author: Walelign A.
#  Date: May 30, 2023
#  Project name: Shared Wallet
#  Module: User Management
#  Activity: View User
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@UnitConfiguration

Feature: KYC Management

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters "Walelign@123" into Username text field
    And web user enters "Walelign@123" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Platform Config main menu

  Scenario: Add Unit with valid data
    When web user clicks on KYC sub menu
    Then web system displays KYC Configuration page
    When web user clicks on Add button for KYC Config
    And web user fills kyc details name as "Auto_Customer_KYC" description as "KYC_Desc" and status "Active"
    And web user select kyc level as "Agent LKYC"
    And web user click add new step button
    And web user enters "Auto_Kyc_step" in to kyc step name field
    And web user add field group with name as "Auto_group" description as "Auto_descr" and display name as "Auto_Display"
    And web user selects parameters "Full Name" "MPIN" and "Email" in to field group

