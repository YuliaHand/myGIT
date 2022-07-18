Feature: Delete Employee Detail

  Background:
    Given url baseUrl
    * def employeeID = '680'
    * def authToken = call read('classpath:TM00_verifAuthentication/TF00_postOAuthClient.feature')
    * def accessToken = authToken.tokenID
    And print accessToken

  Scenario: TS35 - Delete Employee Detail
    Given path '/api/v1/employee/', employeeID
    And header Authorization = 'Bearer ' + accessToken
    When method DELETE
    Then status 501
    And print response
    And match response contains {"error":{"status":"501","text":"Not Implemented"}}