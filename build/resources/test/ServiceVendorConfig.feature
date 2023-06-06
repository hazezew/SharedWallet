#  Author: Walelign A.
#  Date: April 02,2023
#  Project name: Shared Wallet
#  Module: Business Configuration
#  Activity: Service Vendor
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@ServiceVendorConfiguration

Feature: ServiceVendor Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters "Walelign@123" into Username text field
    And web user enters "Walelign@123" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Business Config main menu

  Scenario Outline: Add Service Vendor with valid data
    And web user clicks on service vendor sub menu
    Then web system displays service vendor configuration page
    When web user clicks on add button for service vendor config
    And web user fills service vendor details "<Name>" "<VendorType>" "<VendorService>" and "<Description>"
    And web user select "<Status>" for service vendor status
    And web user fills extra service vendor details "Service Vendor rule" "FCFS" "Min" and "Commission"
    And web user clicks on save button for service vendor
    Then web user should see the "<Name>" service vendor is created
    And web user clicks on view icon for "<Name>" service vendor
    And web user delete the created service vendor

    Examples:
      | Name                   | VendorType       | VendorService    | Description      | Status |
      | Auto_Service_Vendor2   | Service Vendor   | Payment to Agent | Auto_Description | Active |
      | Auto_Technical Vendor2 | Technical Vendor | SMS Service      | Auto_Description | Active |

  Scenario: Verify add service vendor without filling the required fields
    And web user clicks on service vendor sub menu
    Then web system displays service vendor configuration page
    When web user clicks on add button for service vendor config
    And web user clicks on save button for service vendor
    Then web system displays validation message for service vendor config

  Scenario: Verify add service vendor with duplicate name
    And web user clicks on service vendor sub menu
    Then web system displays service vendor configuration page
    When web user clicks on add button for service vendor config
    And web user fills service vendor details "Auto_Duplicate_Check" "Service Vendor" "Payment to Agent" and "Description"
    And web user select "Active" for service vendor status
    And web user fills extra service vendor details "Service Vendor rule" "FCFS" "Min" and "Commission"
    And web user clicks on save button for service vendor
    Then web user should see the "Auto_Duplicate_Check" service vendor is created

    When web user clicks on add button for service vendor config
    And web user fills service vendor details "Auto_Duplicate_Check" "Service Vendor" "Payment to Agent" and "Description"
    And web user select "Active" for service vendor status
    And web user fills extra service vendor details "Service Vendor rule" "FCFS" "Min" and "Commission"
    And web user clicks on save button for service vendor
    Then verify system displays "Name already exists" error message for service vendor

    And web user moves mouse over Business Config main menu
    And web user clicks on service vendor sub menu
    And web user clicks on view icon for "Auto_Duplicate_Check" service vendor
    And web user delete the created service vendor


  Scenario: Edit service vendor configuration
    When web user clicks on service vendor sub menu
    Then web system displays service vendor configuration page
    When web user clicks on add button for service vendor config
    And web user fills service vendor details "Auto_Vendor_Edit1" "Service Vendor" "Payment to Agent" and "Description"
    And web user select "Active" for service vendor status
    And web user fills extra service vendor details "Service Vendor rule" "FCFS" "Min" and "Commission"
    And web user clicks on save button for service vendor
    Then web user should see the "Auto_Vendor_Edit1" service vendor is created
    And web user clicks on view icon for "Auto_Vendor" service vendor
    And web user clicks edit button for service vendor
    When web user update service vendor "NR2NR transfer" and "Updated Description"
    And web user fills extra service vendor details "Service rule" "LCR" "Max" and "Fees"
    And web user clicks on save button for service vendor
    Then web user should see the "Auto_Vendor_Edit1" service vendor is created
    And web user clicks on view icon for "Auto_Vendor_Edit1" service vendor
    And web user delete the created service vendor

