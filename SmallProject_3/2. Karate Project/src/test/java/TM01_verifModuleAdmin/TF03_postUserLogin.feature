Feature: Post User Login

  Background:
    Given url baseUrl
    * def expectedResult = read('../testData/result_UserLogin.json')
    * def authToken = call read('classpath:TM00_verifAuthentication/TF00_postOAuthClient.feature')
    * def accessToken = authToken.tokenID
    And print accessToken

  Scenario: TS06 - User Login with Valid Credential Account
    Given path '/api/v1/login'
    And header Authorization = 'Bearer ' + accessToken
    And form field username = username
    And form field password = password
    When method POST
    Then status 200
    And print response
    And match response == expectedResult[0]

  Scenario: TS07 - User Login with Invalid Credential Account
    Given path '/api/v1/login'
    And header Authorization = 'Bearer ' + accessToken
    And form field username = 'Admin'
    And form field password = '123'
    When method POST
    Then status 202
    And print response
    And match response == expectedResult[1]

  Scenario: TS08 - User Login with Empty Username
    Given path '/api/v1/login'
    And header Authorization = 'Bearer ' + accessToken
    And form field username = ''
    And form field password = password
    When method POST
    Then status 202
    And print response
    And match response == expectedResult[2]

  Scenario: TS09 - User Login with Empty Password
    Given path '/api/v1/login'
    And header Authorization = 'Bearer ' + accessToken
    And form field username = username
    And form field password = ''
    When method POST
    Then status 202
    And print response
    And match response == expectedResult[3]