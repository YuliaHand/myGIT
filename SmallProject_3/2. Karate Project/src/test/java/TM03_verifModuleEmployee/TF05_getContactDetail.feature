Feature: Get Contact Detail

  Background:
    Given url baseUrl
    * def authToken = call read('classpath:TM00_verifAuthentication/TF00_postOAuthClient.feature')
    * def accessToken = authToken.tokenID
    And print accessToken

  Scenario: TS24 - Get Employee Contact Detail
    #* def employeID = call read('TF01_postSaveEmployee.feature')
    #* def employeeID = employeID.employID
    #* print employeeID
    * def employeeID = '686'
    Given path '/api/v1/employee/', employeeID , '/contact-detail'
    And header Authorization = 'Bearer ' + accessToken
    When method GET
    Then status 200
    And print response
    And assert response.data != null
    And match response.data.id == '686'

  Scenario: TS25 - Get Not Existing Employee Contact Detail
    * def employeeID = '10000'
    Given path '/api/v1/employee/', employeeID , '/contact-detail'
    And header Authorization = 'Bearer ' + accessToken
    When method GET
    Then status 404
    And print response
    And match response contains {"error": {"status": "404","text": "Employee Not Found"}}