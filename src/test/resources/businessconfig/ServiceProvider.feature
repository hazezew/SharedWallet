#  Author: Walelign A.
#  Date: July 05,2023
#  Project name: Shared Wallet
#  Module: Business Configuration
#  Activity: Service Provider Config
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@ServiceProviderConfiguration

Feature: Service Provider Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters username into username text field
    And web user enters password into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Business Config main menu

  Scenario Outline: Add Service Provider with valid data
    And web user clicks on service provider sub menu
    Then web system displays service provider configuration page
    When web user clicks on add button for service provider
    And web user adds service provider detail "<Name>" "<ProviderService>" "<OETemplate>" "<Description>"
    And web user adds provider api detail "<ProviderApiName>" "<Protocol>" "<SuccessCode>" "<FailureCode>"
    And web user adds api details Api url "Auto_url" "<HttpType>" http protocol as "HTTPS" request type as "Json" response type "XML"
    And web user adds Header Mapping details Api field "header API" Packet field "Packet" default value "Default"
    And web user adds Request Mapping details with "<HttpType>" Api field "request API" Packet field "Packet" default value "Default" api template "API template"
    And web user adds Response Mapping details Api field "response API" Packet field "Packet" default value "Default"
    And web user click submit button
    Then web user should see the "<Name>" service provider is created
    And web user clicks on view icon for "<Name>" service provider
    And web user delete the created service provider

    Examples:
      | Name               | ProviderService | OETemplate             | HttpType | Description | ProviderApiName | Protocol | SuccessCode | FailureCode |
      | Auto_Provider Get  | Cash_Out        | Sub agent template OET | Get      | Auto_Desc   | Auto_SMS        | Rest     | 200         | 400         |
      | Auto_Provider Post | Cash_Out        | Sub agent template OET | Post     | Auto_Desc   | Auto_SMS        | Rest     | 200         | 400         |


  Scenario Outline: Add Service to the "<Name>" service provider
    And web user clicks on service provider sub menu
    Then web system displays service provider configuration page
    When web user clicks on add button for service provider
    And web user adds service provider detail "<Name>" "<ProviderService>" "<OETemplate>" "<Description>"
    And web user adds provider api detail "<ProviderApiName>" "<Protocol>" "<SuccessCode>" "<FailureCode>"
    And web user adds api details Api url "Auto_url" "<HttpType>" http protocol as "HTTPS" request type as "Json" response type "XML"
    And web user adds Header Mapping details Api field "header API" Packet field "Packet" default value "Default"
    And web user adds Request Mapping details with "<HttpType>" Api field "request API" Packet field "Packet" default value "Default" api template "API template"
    And web user adds Response Mapping details Api field "response API" Packet field "Packet" default value "Default"
    And web user click submit button
    Then web user should see the "<Name>" service provider is created
    And web user clicks on view icon for "<Name>" service provider
    And web user clicks on add service button
    And web user add provider service as "Cash into customer"
    And web user adds provider api detail "<ProviderApiName>" "<Protocol>" "<SuccessCode>" "<FailureCode>"
    And web user adds api details Api url "Service_url" "<HttpType>" http protocol as "HTTP" request type as "Json" response type "XML"
    And web user adds Header Mapping details Api field "header API" Packet field "Packet" default value "Default"
    And web user adds Request Mapping details with "<HttpType>" Api field "request API" Packet field "Packet" default value "Default" api template "API template"
    And web user adds Response Mapping details Api field "response API" Packet field "Packet" default value "Default"
    And web user click submit button
    Then web user should see the "<Name>" service provider is created
    And web user clicks on view icon for "<Name>" service provider
    And web user delete the created service provider

    Examples:
      | Name                      | ProviderService | OETemplate             | HttpType | Description | ProviderApiName | Protocol | SuccessCode | FailureCode |
      | Provider with Add Service | Cash_Out        | Sub agent template OET | Get      | Auto_Desc   | Auto_SMS        | Rest     | 200         | 400         |

  Scenario: Verify add service provider without filling the required fields
    And web user clicks on service provider sub menu
    Then web system displays service provider configuration page
    When web user clicks on add button for service provider
    And web user clicks on next button
    Then web system displays validation message for service provider

  Scenario Outline: Update service provider
    And web user clicks on service provider sub menu
    Then web system displays service provider configuration page
    When web user clicks on add button for service provider
    And web user adds service provider detail "<Name>" "<ProviderService>" "<OETemplate>" "<Description>"
    And web user adds provider api detail "<ProviderApiName>" "<Protocol>" "<SuccessCode>" "<FailureCode>"
    And web user adds api details Api url "Auto_url" "<HttpType>" http protocol as "HTTPS" request type as "Json" response type "XML"
    And web user adds Header Mapping details Api field "header API" Packet field "Packet" default value "Default"
    And web user adds Request Mapping details with "<HttpType>" Api field "request API" Packet field "Packet" default value "Default" api template "API template"
    And web user adds Response Mapping details Api field "response API" Packet field "Packet" default value "Default"
    And web user click submit button
    Then web user should see the "<Name>" service provider is created
    And web user clicks on view icon for "<Name>" service provider
    And web user clicks on edit button
    And web user update provider OE as "merchant1 OET" api "API" url "updated url" http type "Post" template "API template"
    And web user click submit button
    Then web user should see the "<Name>" service provider is created
    And web user clicks on view icon for "<Name>" service provider
    And web user delete the created service provider

    Examples:
      | Name                | ProviderService | OETemplate             | HttpType | Description | ProviderApiName | Protocol | SuccessCode | FailureCode |
      | Provider for Update | Cash_Out        | Sub agent template OET | Get      | Auto_Desc   | Auto_SMS        | Rest     | 200         | 400         |


  Scenario Outline: Add service provider with duplicated name
    And web user clicks on service provider sub menu
    Then web system displays service provider configuration page
    When web user clicks on add button for service provider
    And web user adds service provider detail "<Name>" "<ProviderService>" "<OETemplate>" "<Description>"
    And web user adds provider api detail "<ProviderApiName>" "<Protocol>" "<SuccessCode>" "<FailureCode>"
    And web user adds api details Api url "Auto_url" "<HttpType>" http protocol as "HTTPS" request type as "Json" response type "XML"
    And web user adds Header Mapping details Api field "header API" Packet field "Packet" default value "Default"
    And web user adds Request Mapping details with "<HttpType>" Api field "request API" Packet field "Packet" default value "Default" api template "API template"
    And web user adds Response Mapping details Api field "response API" Packet field "Packet" default value "Default"
    And web user click submit button
    Then web user should see the "<Name>" service provider is created
    When web user clicks on add button for service provider
    And web user adds service provider detail "<Name>" "<ProviderService>" "<OETemplate>" "<Description>"
    And web user adds provider api detail "<ProviderApiName>" "<Protocol>" "<SuccessCode>" "<FailureCode>"
    And web user adds api details Api url "Auto_url" "<HttpType>" http protocol as "HTTPS" request type as "Json" response type "XML"
    And web user adds Header Mapping details Api field "header API" Packet field "Packet" default value "Default"
    And web user adds Request Mapping details with "<HttpType>" Api field "request API" Packet field "Packet" default value "Default" api template "API template"
    And web user adds Response Mapping details Api field "response API" Packet field "Packet" default value "Default"
    And web user click submit button
    # waiting for the issue to be resolved
#    Then verify system displays "Name already exists" error message for service provider
    And web user moves mouse over Business Config main menu
    And web user clicks on service provider sub menu
    And web user clicks on view icon for "<Name>" service provider
    And web user delete the created service provider

    Examples:
      | Name                   | ProviderService | OETemplate             | HttpType | Description | ProviderApiName | Protocol | SuccessCode | FailureCode |
      | Duplicated Name Check2 | Cash_Out        | Sub agent template OET | Get      | Auto_Desc   | Auto_SMS        | Rest     | 200         | 400         |

  Scenario: verify search for service provider functionality
    And web user clicks on service provider sub menu
    Then web system displays service provider configuration page
    When web user click on filter icon for service provider
    And web user select "Contains" for the search service provider filter criteria
    And web user enters "SMS" into service provider search name field
    And web user clicks search service provider button
    Then web system displays a list of service providers with "SMS" on the name

  Scenario: Verify export functionality
    And web user clicks on service provider sub menu
    Then web system displays service provider configuration page
    And web user clicks on export button for service provider
    And web user enters "Auto_Export_Service_Provider1" and "Auto_Description" into service provider export fields
    And web user clicks save export history button for service provider
    Then web user verify "Auto_Export_Service_Provider1" record created in service provider export history