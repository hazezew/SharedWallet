#  Author: Walelign A.
#  Date: July 05,2023
#  Project name: Shared Wallet
#  Module: Business Configuration
#  Activity: Authentication Config
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@AuthenticationConfiguration

Feature: Authentication Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters username into username text field
    And web user enters password into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Business Config main menu

  Scenario Outline: Add Authentication with valid data
    And web user clicks on authentication sub menu
    Then web system displays authentication configuration page
    When web user clicks on add button for authentication
    When web user add authentication detail "<Name>" "<Description>" "<PAPNodeType>" "<AuthenticationType>" "<CredentialParameter>" "<2FAType>" "<Length>" "<PacketField>"
    And web user click save button for authentication
    Then web user should see the "<Name>" authentication is created
    And web user clicks on view icon for "<Name>" authentication
    And web user delete the created authentication

    Examples:
      | Name                | Description | PAPNodeType          | AuthenticationType | CredentialParameter | 2FAType | Length | PacketField |
      | MPIN Authentication | Auto desc   | Credential Evaluator | Local              | MPIN                |         |        | Auth packet |
      | Authe with 2FA      | Auto desc   | 2FA Evaluator        |                    |                     | OTP     | 5      | Auth packet |

  Scenario: Verify add authentication without filling the required fields
    And web user clicks on authentication sub menu
    Then web system displays authentication configuration page
    When web user clicks on add button for authentication
    And web user click save button for authentication
    Then web system displays validation message for authentication

  Scenario Outline: Edit Authentication Config
    And web user clicks on authentication sub menu
    Then web system displays authentication configuration page
    When web user clicks on add button for authentication
    When web user add authentication detail "<Name>" "<Description>" "<PAPNodeType>" "<AuthenticationType>" "<CredentialParameter>" "<2FAType>" "<Length>" "<PacketField>"
    And web user click save button for authentication
    Then web user should see the "<Name>" authentication is created
    And web user clicks on view icon for "<Name>" authentication
    And web user click on edit button for authentication
    And web user update authentication with pap node "2FA Evaluator" fa type "OTP" length "6" packet field "Updated packet"
    And web user click save button for authentication
    Then web user should see the "<Name>" authentication is created
    And web user clicks on view icon for "<Name>" authentication
    And web user delete the created authentication

    Examples:
      | Name                      | Description | PAPNodeType          | AuthenticationType | CredentialParameter | 2FAType | Length | PacketField |
      | Authentication for Update | Auto desc   | Credential Evaluator | Local              | MPIN                |         |        | Auth packet |

  Scenario Outline: Verify add Authentication with duplicate data
    And web user clicks on authentication sub menu
    Then web system displays authentication configuration page
    When web user clicks on add button for authentication
    When web user add authentication detail "<Name>" "<Description>" "<PAPNodeType>" "<AuthenticationType>" "<CredentialParameter>" "<2FAType>" "<Length>" "<PacketField>"
    And web user click save button for authentication
    Then web user should see the "<Name>" authentication is created
    When web user clicks on add button for authentication
    When web user add authentication detail "<Name>" "<Description>" "<PAPNodeType>" "<AuthenticationType>" "<CredentialParameter>" "<2FAType>" "<Length>" "<PacketField>"
    And web user click save button for authentication
    Then verify system displays "Name already exists" error message for authentication
    And web user clicks on view icon for "<Name>" authentication
    And web user delete the created authentication

    Examples:
      | Name                | Description | PAPNodeType          | AuthenticationType | CredentialParameter | 2FAType | Length | PacketField |
      | MPIN Authentication | Auto desc   | Credential Evaluator | Local              | MPIN                |         |        | Auth packet |

  Scenario: verify search for authentication
    And web user clicks on authentication sub menu
    Then web system displays authentication configuration page
    When web user click on filter icon for authentication
    And web user select "Contains" for the search authentication filter criteria
    And web user enters "authentication" into authentication search name field
    And web user clicks search authentication button
    Then web system displays a list of authentications with "authentication" on the name