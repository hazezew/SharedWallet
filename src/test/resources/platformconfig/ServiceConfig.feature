#  Author: Walelign A.
#  Date: May 29, 2023
#  Project name: Shared Wallet
#  Module: Business Configuration
#  Activity: Service Configuraiton
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@ServiceConfiguration

Feature: Service Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters username into username text field
    And web user enters password into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Platform Config main menu

  Scenario Outline: Add Service with valid data
    And web user clicks on Service sub menu
    Then web system displays Service Configuration page
    When web user clicks on Add button for Service Config
    And web user enters service info "<Name>" "<DisplayName>" "<Description>" "<ServiceType>" and "<ServiceBehavior>"
    And web user select the "Active" of a service
    And web user navigates to parameters tab
    And web user add parameter details parameter as "Customer Name" default value "Customer"
    And web user click save button for service
    Then web user should see the "<Name>" service is created
    And web user clicks on view icon for "<Name>" service
    And web user delete the created service
    Examples:
      | Name         | DisplayName  | Description | ServiceType      | ServiceBehavior   |
      | Auto_SMS     | Auto_Service | Auto_desc   | Internal         | Transactional     |
      | Auto_TopUp   | Auto_Service | Auto_desc   | External         | Non-Transactional |
      | Auto_Service | Auto_Service | Auto_desc   | Service Category | Transactional     |

  Scenario: Verify add service without filling required fields
    And web user clicks on Service sub menu
    Then web system displays Service Configuration page
    When web user clicks on Add button for Service Config
    And web user click save button for service
    Then web system displays validation message for service config

  Scenario: Edit service configuration
    And web user clicks on Service sub menu
    Then web system displays Service Configuration page
    When web user clicks on Add button for Service Config
    And web user enters service info "Auto_SMS" "SMS" "Auto_desc" "Internal" and "Transactional"
    And web user select the "Active" of a service
    And web user navigates to parameters tab
    And web user add parameter details parameter as "Customer Name" default value "Customer"
    And web user click save button for service
    Then web user should see the "Auto_SMS" service is created
    And web user clicks on view icon for "Auto_SMS" service
    And web user update service display name "Auto_updated" service type "External" and service behavior "Non-Transactional"
    And web user click save button for service
    Then web user should see the "Auto_SMS" service is created
    And web user clicks on view icon for "Auto_SMS" service
    And web user delete the created service

  Scenario: Verify add service with duplicated service name
    And web user clicks on Service sub menu
    Then web system displays Service Configuration page
    When web user clicks on Add button for Service Config
    And web user enters service info "Auto_Duplicate_SMS" "SMS" "Auto_desc" "Internal" and "Transactional"
    And web user select the "Active" of a service
    And web user navigates to parameters tab
    And web user add parameter details parameter as "Customer Name" default value "Customer"
    And web user click save button for service
    Then web user should see the "Auto_Duplicate_SMS" service is created

    When web user clicks on Add button for Service Config
    And web user enters service info "Auto_Duplicate_SMS" "SMS" "Auto_desc" "Internal" and "Transactional"
    And web user select the "Active" of a service
    And web user click save button for service
    Then verify system displays "Name already exists" error message for service

    And web user moves mouse over Platform Config main menu
    And web user clicks on Service sub menu
    And web user clicks on view icon for "Auto_Duplicate_SMS" service
    And web user delete the created service

  Scenario: Verify search functionality for service
    And web user clicks on Service sub menu
    Then web system displays Service Configuration page
    When web user click on filter icon for service
    And web user select "Contains" for the search service filter criteria
    And web user enters "SMS" into service search name field
    And web user clicks search service button
    Then web system displays a list of services with "SMS" on the name





