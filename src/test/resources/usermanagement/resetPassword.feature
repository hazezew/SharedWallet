#  Author: Habitamu Azezew
#  Date: May 04, 2023
#  Project name: Shared Wallet
#  Module: User Management
#  Activity: Reset Password
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@UserManagement

Feature: Reset Password
  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters username into username text field
    And web user enters password into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over User Management main menu
    And web user clicks on Reset Password sub menu
    Then web system displays Reset Password page

  Scenario: Reset Password with empty username
    And web user clicks on search user button for password reset
    Then Reset Password page displays validation message "Enter username"
    And web user clicks on settings link
    And web user clicks on Logout link

  Scenario: Reset Password with valid username
    And reset password user enters "Habtamu@eth" into username search textfield
    And web user clicks on search user button for password reset
#    Refine the following steps and/or add more steps needed as system was not working at time of developing this test scenario
    Then Reset Password page displays User details for password reset
    And web user clicks on settings link
    And web user clicks on Logout link

  Scenario: Reset Password with an invalid username
    And reset password user enters "Habtamu@eth1234" into username search textfield
    And web user clicks on search user button for password reset
#    Refine the following steps and/or add more steps needed as system was not working at time of developing this test scenario
    Then Reset Password page displays message "Sorry! User does not exist"
    And web user clicks on settings link
    And web user clicks on Logout link