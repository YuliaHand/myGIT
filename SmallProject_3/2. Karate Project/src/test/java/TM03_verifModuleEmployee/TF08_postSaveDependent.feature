Feature: Post Save Dependent

  Background:
    Given url baseUrl
    #* def employeID = call read('TF01_postSaveEmployee.feature')
    #* def employeeID = employeID.employID
    #* print employeeID
    * def localID = '686'
    * def authToken = call read('classpath:TM00_verifAuthentication/TF00_postOAuthClient.feature')
    * def accessToken = authToken.tokenID
    And print accessToken

  Scenario Outline: TS30 - Post Save Dependent with Valid Data
    Given path '/api/v1/employee/', localID, '/dependent'
    And header Authorization = 'Bearer ' + accessToken
    And form field id = <empid>
    And form field name = <empname>
    And form field relationship = <emprelationship>
    And form field dob = <empdob>
    When method POST
    Then status 200
    And print response
    And match response contains {"success": "Successfully Saved"}

    Examples:
      |  empid  | empname |  emprelationship  |     empdob    |
      |  '686'  | 'Tulip' |    'Complicated'  | '2000-07-31'  |