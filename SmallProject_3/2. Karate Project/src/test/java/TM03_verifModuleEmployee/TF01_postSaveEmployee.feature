Feature: Post Save Employee

  Background:
    Given url baseUrl
    * def localID = '111222011'
    * def authToken = call read('classpath:TM00_verifAuthentication/TF00_postOAuthClient.feature')
    * def accessToken = authToken.tokenID
    And print accessToken

  Scenario Outline: TS18 - Post Save Employee with Valid Data
    Given path '/api/v1/employee/', localID
    And header Authorization = 'Bearer ' + accessToken
    And form field firstName = <firstNm>
    And form field middleName = <middleNm>
    And form field lastName = <lastNm>
    And form field code = <codes>
    When method POST
    Then status 200
    And print response
    And match response contains {"success": "Successfully Saved"}

    * def employID = response.id
    And print employID

    Examples:
      | firstNm | middleNm |  lastNm  |     codes    |
      | 'Mawar' | 'Melati' | 'Anggrek'| '111222011'  |

  Scenario Outline: TS19 - Post Save Employee with Existing ID
    Given path '/api/v1/employee/', localID
    And header Authorization = 'Bearer ' + accessToken
    And form field firstName = <firstNm>
    And form field middleName = <middleNm>
    And form field lastName = <lastNm>
    And form field code = <codes>
    When method POST
    Then status 400
    And print response
    And match response contains {"error": ["Failed To Save: Employee Code Exists"]}

    Examples:
      | firstNm | middleNm |  lastNm   |    codes    |
      | 'Mawar' | 'Melati' | 'Anggrek' | '111222011' |