Feature: Get Employee Search

  Background:
    Given url baseUrl
    * def empDetail = read('../testData/result_EmployeeDetail.json')
    * def authToken = call read('classpath:TM00_verifAuthentication/TF00_postOAuthClient.feature')
    * def accessToken = authToken.tokenID
    And print accessToken

  Scenario Outline: TS23 - Search Employee With Valid Data
    Given path '/api/v1/employee/search'
    And header Authorization = 'Bearer ' + accessToken
    And form fields empDetail[1]
    When method GET
    Then status 200
    And print response
    And assert response.data != null
    And match response.data[0].firstName == <firstNm>
    And match response.data[0].middleName == <middleNm>
    And match response.data[0].lastName == <lastNm>

    Examples:
      | firstNm | middleNm |  lastNm  |
      | 'Mawar' | 'Melati' | 'Anggrek'|