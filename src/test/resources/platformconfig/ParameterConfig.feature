#  Author: Walelign A.
#  Date: April 22, 2023
#  Project name: Shared Wallet
#  Module: Platform Configuration
#  Activity: Parameter Configuration
#  Project owner: EthSwitch
#  Vendor: Panamax
#  language: en
#  Test Environment: EthSwitch Test

@Regression
@ParameterConfiguration

Feature: Parameter Configuration

  Background: user opened web browser and maximizes it
    When user has entered Shared Wallet system URL
    When web user enters "Walelign@123" into Username text field
    And web user enters "Walelign@123" into password text field
    And web user selects "Africa/Nairobi" from timezone dropdown
    And web user clicks on Login button
    Then web system displays "You have successfully logged in!" message
    And web system displays Admin dashboard
    And web user moves mouse over Platform Config main menu

  Scenario Outline: Add Parameter with valid data
    And web user clicks on Parameter sub menu
    Then web system displays Parameter Configuration page
    When web user click on Add button
    And web user fills in the parameter details for "<Name>", "<DisplayName>", "<Description>", "<UsedBy>", "<FieldType>","<ComponentType>", and "<DataType>"
    And web user enters "Please enter valid field" into Validation Message Field
    And web user click Add Field button on the Extra Details
    And web user enters "Auto_Key" and "Auto_Value"
    When web user click Add Field button on the Extra Details
    And web user click Remove Button for Extra Field
    When web user click save button
    Then web user should see the "<Name>" parameter is created
    Then web user click view icon for "<Name>" parameter
    Then web user delete the created parameter
    Examples:
      | Name                 | DisplayName       | Description | UsedBy         | FieldType | ComponentType | DataType |
      | Auto_Parameter_Name  | Auto_Display_Name | Auto_Desc   | KYC            | Base      | TextBox       | String   |
      | Auto_Service_Profile | Auto_SP_Name      | Auto_Desc   | ServiceProfile | Base      | TextBox       | String   |

  Scenario Outline: Add parameter with Aggregator field type
    When web user clicks on Parameter sub menu
    Then web system displays Parameter Configuration page
    When web user click on Add button
    And web user fills in the parameter details for "<Name>", "<DisplayName>", "<Description>", "<UsedBy>" and "<FieldType>"
    And web user selects "<AllowMultiple>" for allow multiple option
    And web user enters "2" into Allowed Limit text field
    And web user add child fields for the aggregator parameter
    When web user click Add Field button on the Extra Details
    And web user enters "Auto_Key" and "Auto_Value"
    When web user click save button
    Then web user should see the "<Name>" parameter is created
    Then web user click view icon for "<Name>" parameter
    Then web user delete the created parameter
    Examples:
      | Name                | DisplayName       | Description | UsedBy | FieldType  | AllowMultiple |
      | Auto_Parameter_Name | Auto_Display_Name | Auto_Desc   | KYC    | Aggregator | Yes           |

  Scenario Outline: Verify Add parameter with empty required fields
    When web user clicks on Parameter sub menu
    Then web system displays Parameter Configuration page
    When web user click on Add button
    When web user click save button
    Then web system displays validation message "<expectedErrorMessage>"
    Examples:
      | expectedErrorMessage           |
      | Please enter valid name        |
      | This field is required         |
      | Please enter valid description |

  Scenario Outline: Edit Parameter
    And web user clicks on Parameter sub menu
    Then web system displays Parameter Configuration page
    When web user click on Add button
    And web user fills in the parameter details for "<Name>", "<DisplayName>", "<Description>", "<UsedBy>", "<FieldType>","<ComponentType>", and "<DataType>"
    And web user enters "Please enter valid field" into Validation Message Field
    And web user click Add Field button on the Extra Details
    And web user enters "Auto_Key" and "Auto_Value"
    When web user click Add Field button on the Extra Details
    And web user click Remove Button for Extra Field
    When web user click save button
    Then web user should see the "<Name>" parameter is created
    Then web user click view icon for "<Name>" parameter
    Then web user click edit icon for parameter
    Then web user update Display name "Auto_Updated" and Data Type "Number"
    Then web user click save button
    Then web user should see the "<Name>" parameter is created
    Then web user click view icon for "<Name>" parameter
    Then web user delete the created parameter
    Examples:
      | Name                | DisplayName       | Description | UsedBy | FieldType | ComponentType | DataType |
      | Auto_Parameter_Name | Auto_Display_Name | Auto_Desc   | KYC    | Base      | TextBox       | String   |

  Scenario: Verify Add parameter with existing parameter name
    And web user clicks on Parameter sub menu
    Then web system displays Parameter Configuration page
    When web user click on Add button
    And web user fills in the parameter details for "Auto_Parameter_Name", "Auto_Display_Name", "Auto_Desc", "KYC", "Base","TextBox", and "String"
    And web user enters "Please enter valid field" into Validation Message Field
    And web user click Add Field button on the Extra Details
    And web user enters "Auto_Key" and "Auto_Value"
    When web user click save button
    Then web user should see the "Auto_Parameter_Name" parameter is created
    Then web user click view icon for "Auto_Parameter_Name" parameter
    Then web user click edit icon for parameter
    Then web user update Display name "Auto_Updated" and Data Type "Number"
    Then web user click save button
    Then web user should see the "Auto_Parameter_Name" parameter is created

    When web user click on Add button
    And web user fills in the parameter details for "Auto_Parameter_Name", "Auto_Display_Name", "Auto_Desc", "KYC", "Base","TextBox", and "String"
    And web user enters "Please enter valid field" into Validation Message Field
    Then web user click save button
    Then verify system displays "Name already exists" error message for parameter

    And web user moves mouse over Platform Config main menu
    And web user clicks on Parameter sub menu
    Then web user click view icon for "Auto_Parameter_Name" parameter
    Then web user delete the created parameter
    Then web user delete the created parameter


  Scenario: Verify filter and search functionality for parameter
    And web user clicks on Parameter sub menu
    Then web system displays Parameter Configuration page
    When web user click on filter icon on parameter
    And web user select "Contains" for the search parameter filter criteria
    And web user enters "Customer" into parameter search name field
    And web user clicks search parameter button
    Then web system displays a list of parameters contains "Customer" on the name

  Scenario: Verify export functionality
    And web user clicks on Parameter sub menu
    Then web system displays Parameter Configuration page
    And web user clicks on export button for parameter
    And web user enters "Auto_Export_Parameter" and "Auto_Description" into parameter export fields
    And web user clicks save export history button for parameter
    Then web user verify "Auto_Export_Parameter" record created in parameter export history