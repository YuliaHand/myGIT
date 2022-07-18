Feature: Get Employee Detail

  Background:
    Given url baseUrl
    * def authToken = call read('classpath:TM00_verifAuthentication/TF00_postOAuthClient.feature')
    * def accessToken = authToken.tokenID
    And print accessToken

  Scenario Outline: TS20 - Get Employee Detail With Valid ID
    #* def employeID = call read('TF01_postSaveEmployee.feature')
    #* def employeeID = employeID.employID
    #* print employeeID
    * def employeeID = '686'
    Given path '/api/v1/employee/', employeeID
    And header Authorization = 'Bearer ' + accessToken
    When method GET
    Then status 200
    And print response
    And assert response.data != null
    And assert response.rels != null
    And match response.data.firstName == <firstNm>
    And match response.data.middleName == <middleNm>
    And match response.data.lastName == <lastNm>
    #And match response.data.code == <codes>

    Examples:
      | firstNm | middleNm |  lastNm  |     codes    |
      | 'Mawar' | 'Melati' | 'Anggrek'| '111222010'  |

  Scenario: TS21 - Get UnExisting Employee Detail
    * def employeeID2 = '0'
    Given path '/api/v1/employee/', employeeID2
    And header Authorization = 'Bearer ' + accessToken
    When method GET
    Then status 404
    And print response
    And match response contains {"error": {"status": "404","text": "Employee Not Found"}}


