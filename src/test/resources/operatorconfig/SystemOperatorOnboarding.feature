#  Author: Walelign A.
#  Date: July 22, 2023
#  Project name: Shared Wallet
#  Module: Operator Configuration
#  Activity: System Operator Onboarding
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@SystemOperatorOnboarding

Feature: System Operator Onboarding

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters username into username text field
    And web user enters password into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over operator config main menu

  Scenario Outline: System operator onboarding
    And web user clicks on system operator onboarding sub menu
    Then web system displays system operator onboarding page
    When web user click add button for system operator onboarding
    And web user add system operator "<SOE>" "<KYCLevel>" "<FullName>" "<MobileNumber>" "<Dob>" "<Email>"
    And web user click save button for system operator
    Then web user should see the "<Name>" system operator is created
    And web user clicks on view icon for "<Name>" system operator
    And web user delete the created system operator

    Examples:
      | SOE       | KYCLevel      | FullName  | Dob        | MobileNumber | Email           |
      | ETH Admin | Sub agent_KYC | Auto User | 2000-07-29 | 0911235654   | email@gmail.com |

