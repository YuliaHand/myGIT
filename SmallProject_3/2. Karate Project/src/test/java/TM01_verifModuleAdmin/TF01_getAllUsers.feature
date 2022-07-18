Feature: Get All Users

  Background:
    Given url baseUrl
    * def authToken = call read('classpath:TM00_verifAuthentication/TF00_postOAuthClient.feature')
    * def accessToken = authToken.tokenID
    And print accessToken

  Scenario: TS01 - Get All Users with Valid Authorization
    * def expectedResult = read('../testData/result_ListUsersDetails.json')
    Given path '/api/v1/user'
    And header Authorization = 'Bearer ' + accessToken
    When method GET
    Then status 200
    And print response
    And match response == expectedResult
    And match response.data != []
    And match response.rels == []
    And assert response.data.length == 6

  Scenario: TS02 - Get All Users with Invalid Authorization
    Given path '/api/v1/user'
    And header Authorization = 'Bearer ' + '123456789'
    When method GET
    Then status 401
    And print response
    And match response contains { "error": "invalid_token" }

  Scenario: TS03 - Get All Users without Input Token
    Given path '/api/v1/user'
    And header Authorization = 'Bearer ' + ' '
    When method GET
    Then status 401
    And print response
    And match response contains { "error": "invalid_request" }

