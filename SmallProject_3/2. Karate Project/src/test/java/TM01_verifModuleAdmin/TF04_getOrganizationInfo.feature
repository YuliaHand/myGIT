Feature: Get Organization Information

  Background:
    Given url baseUrl
    * def authToken = call read('classpath:TM00_verifAuthentication/TF00_postOAuthClient.feature')
    * def accessToken = authToken.tokenID
    And print accessToken

  Scenario: TS10 - Get User Organization Information
    * def expectedResult = read('../testData/result_Organization.json')
    Given path '/api/v1/organization'
    And header Authorization = 'Bearer ' + accessToken
    When method GET
    Then status 200
    And print response
    And match response == expectedResult
    And assert response.data.note == ''