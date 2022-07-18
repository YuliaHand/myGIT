Feature: Put Employee Detail

  Background:
    Given url baseUrl
    * def empDetail = read('../testData/result_EmployeeDetail.json')
    * def authToken = call read('classpath:TM00_verifAuthentication/TF00_postOAuthClient.feature')
    * def accessToken = authToken.tokenID
    And print accessToken

  Scenario: TS22 - Update Employee Detail
    #* def employeID = call read('TF01_postSaveEmployee.feature')
    #* def employeeID = employeID.employID
    #* print employeeID
    * def employeeID = '686'
    Given path '/api/v1/employee/', employeeID
    And header Authorization = 'Bearer ' + accessToken
    And request empDetail[0]
    When method PUT
    Then status 200
    And print response
    And match response contains {"success": "Successfully Updated"}


