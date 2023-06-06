#  Author: Habitamu Azezew
#  Date: May 08, 2023
#  Project name: Shared Wallet
#  Module: User Management
#  Activity: System User Management
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@UserManagement

Feature: System User Management
  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters "Habtamu@eth" into Username text field
    And web user enters "Habtamu@748" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over User Management main menu
    And web user clicks on System User Management sub menu
    Then web system displays System User Management page

  Scenario: Add new System User Management
    And System User Management page user clicks on Add button
    And on System User Management page user selects "SIINQEE BANK OPERATOR ENTITY" from System Operator Entity dropdown
    And on System User Management page user selects "KYC Level 1 SIB" from KYC Level dropdown
    And on System User Management page user enters "G/Egeziabher" into First Name textfield
    And on System User Management page user enters "G/Mariam" into Middle Name SIB textfield
    And on System User Management page user enters "G/Kirstose" into Last Name SIB textfield
    And on System User Management page user enters "0910988905" into Mobile Number SIB textfield
    And on System User Management page user enters "Addis Ababa" into AddressOne SIB textfield
    And on System User Management page user enters "email@ethswitch.com" into Email SIB textfield
    And on System User Management page user clicks on Submit button
    Then System User Management page display a success message "New System User added successfully"
    And web user clicks on settings link
    And web user clicks on Logout link

  Scenario: Add new System User Management for another tenant
    And System User Management page user clicks on Add button
    And on System User Management page user selects "Amhara bank admin system operator entity" from System Operator Entity dropdown
    And on System User Management page user selects "Agent KYC Level 1" from KYC Level dropdown
    Then System User Management page displays message "User Identifier not found in User Category configuration"
    And web user clicks on settings link
    And web user clicks on Logout link

    Scenario: Add new System User Management without mandatory fields
      And System User Management page user clicks on Add button
      And on System User Management page user selects "SIINQEE BANK OPERATOR ENTITY" from System Operator Entity dropdown
      And on System User Management page user selects "KYC Level 1 SIB" from KYC Level dropdown
      And on System User Management page user clicks on Submit button
      Then System User Management page displays an error message "Please provide all the mandatory field values."