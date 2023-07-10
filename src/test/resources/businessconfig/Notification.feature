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

  Scenario Outline: Add Notification with valid data
    And web user clicks on notification sub menu
    Then web system displays notification configuration page
    When web user clicks on add button for notification
    And web user add notification detail "<Name>" "<NotificationType>" "<Description>" "<NotificationCategory>" "<Vendor>" "<VendorService>" "<MobileNumber>" "<FromEmail>" "<Email>"
    And web user clicks on save button for notification
    Then web user should see the "<Name>" notification is created
    And web user clicks on view icon for "<Name>" notification
    And web user delete the created notification
    Examples:
      | Name                    | NotificationType | Description | NotificationCategory | Vendor              | VendorService | MobileNumber | FromEmail      | Email           |
      | Auto SMS Notification   | SMS              | Auto desc   | Success              | Notification Vendor | SMS Service   | 65254213652  |                |                 |
      | Auto Email Notification | EMAIL            | Auto desc   | Success              | Notification Vendor | SMS Service   | 65254213652  | user@gmail.com | email@gmail.com |


  Scenario Outline: Update Notification Configuration
    And web user clicks on notification sub menu
    Then web system displays notification configuration page
    When web user clicks on add button for notification
    And web user add notification detail "<Name>" "<NotificationType>" "<Description>" "<NotificationCategory>" "<Vendor>" "<VendorService>" "<MobileNumber>" "<FromEmail>" "<Email>"
    And web user clicks on save button for notification
    Then web user should see the "<Name>" notification is created
    And web user clicks on view icon for "<Name>" notification
    And web user clicks on edit button for notification
    And web user update notification with type "EMAIL" username "updated@gmail.com" category "Failure" Error code "Any (-1)" and email "email@gmail.com"
    And web user clicks on save button for notification
    Then web user should see the "<Name>" notification is created
    And web user clicks on view icon for "<Name>" notification
    And web user delete the created notification
    Examples:
      | Name                      | NotificationType | Description | NotificationCategory | Vendor              | VendorService | MobileNumber | FromEmail | Email |
      | Notification tobe updated | SMS              | Auto desc   | Success              | Notification Vendor | SMS Service   | 65254213652  |           |       |

  Scenario: Add Notification without the required fields
    And web user clicks on notification sub menu
    Then web system displays notification configuration page
    When web user clicks on add button for notification
    And web user clicks on save button for notification
    Then web system displays validation message for notification

  Scenario Outline: Add Notification with duplicated name
    And web user clicks on notification sub menu
    Then web system displays notification configuration page
    When web user clicks on add button for notification
    And web user add notification detail "<Name>" "<NotificationType>" "<Description>" "<NotificationCategory>" "<Vendor>" "<VendorService>" "<MobileNumber>" "<FromEmail>" "<Email>"
    And web user clicks on save button for notification
    Then web user should see the "<Name>" notification is created
    When web user clicks on add button for notification
    And web user add notification detail "<Name>" "<NotificationType>" "<Description>" "<NotificationCategory>" "<Vendor>" "<VendorService>" "<MobileNumber>" "<FromEmail>" "<Email>"
    And web user clicks on save button for notification
    Then verify system displays "Name already exists" error message for notification
    And web user moves mouse over Business Config main menu
    And web user clicks on notification sub menu
    And web user clicks on view icon for "<Name>" notification
    And web user delete the created notification
    Examples:
      | Name                        | NotificationType | Description | NotificationCategory | Vendor              | VendorService | MobileNumber | FromEmail | Email |
      | Notification for Duplicated | SMS              | Auto desc   | Success              | Notification Vendor | SMS Service   | 65254213652  |           |       |

  Scenario: verify search for notification functionality
    And web user clicks on notification sub menu
    Then web system displays notification configuration page
    When web user click on filter icon for notification
    And web user select "Contains" for the search notification filter criteria
    And web user enters "notification" into notification search name field
    And web user clicks search notification button
    Then web system displays a list of notifications with "notification" on the name