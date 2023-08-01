#  Author: Walelign A.
#  Date: July 22, 2023
#  Project name: Shared Wallet
#  Module: Operation Configuration
#  Activity: Resend Notification
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@ResendNotification

Feature: Resend Notification

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters username into username text field
    And web user enters password into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over operation main menu

  Scenario Outline: Resend Notification
    And web user clicks on resend notification sub menu
    Then web system displays resend notification page
    When web user click send icon for "<Receiver>" address
    And web user click send button

    Examples:
      | Receiver   |
      | 3100223305 |

  Scenario: verify search for role
    And web user clicks on resend notification sub menu
    Then web system displays resend notification page
    When web user click on filter icon for resend notification
    And web user select "Contains" for the search resend notification filter criteria
    And web user enters "3100223305" into resend notification search receiver field
    And web user clicks search resend notification button
    Then web system displays a list of resend notifications with "3100223305" on the receiver
