Feature: Get Single User

  Background:
    Given url baseUrl
    * def authToken = call read('classpath:TM00_verifAuthentication/TF00_postOAuthClient.feature')
    * def accessToken = authToken.tokenID
    And print accessToken

  Scenario Outline: TS04 - Verify Single User With Valid Data
    * def expectedResult = read('../testData/result_ListUsersDetails.json')
    Given path '/api/v1/user'
    And header Authorization = 'Bearer ' + accessToken
    And multipart field userName = <usernm>
    And multipart field userRole = <userole>
    And multipart field status = <statuss>
    And multipart field employeeName = <employeenm>
    And multipart field employeeId = <employeid>
    When method GET
    Then status 200
    And print response
    And match response == expectedResult

    Examples:
    |   usernm   |   userole  |  statuss   |      employeenm      |  employeid |
    | 'nurindah' |   'Admin'  | 'Enabled'  |  'nur indah vaili'   |     377    |
    | 'rizqi'    |   'Admin'  | 'Enabled'  | 'Rizqi Ahmad Fauzan' |      97    |


  Scenario: TS05 - Verify Single User With Invalid Data
    * def params =
    """
    {
    'employeeId': '500'
    }
    """
    Given path '/api/v1/user'
    And header Authorization = 'Bearer ' + accessToken
    And form fields params
    When method GET
    Then status 404
    And print response
    And match response contains {"error": {"status": "404","text": "No Users Found"}}