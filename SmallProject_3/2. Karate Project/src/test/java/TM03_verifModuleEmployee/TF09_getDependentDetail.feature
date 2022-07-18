Feature: Get Dependent Detail

  Background:
    Given url baseUrl
    * def authToken = call read('classpath:TM00_verifAuthentication/TF00_postOAuthClient.feature')
    * def accessToken = authToken.tokenID
    And print accessToken

  Scenario Outline: TS31 - Get Registered Employee Dependent
    #* def employeID = call read('TF08_postSaveDependent.feature')
    #* def localID2 = employeID.localID
    #* print localID2
    * def localID2 = '686'
    Given path '/api/v1/employee/', localID2, '/dependent'
    And header Authorization = 'Bearer ' + accessToken
    When method GET
    Then status 200
    And print response
    And match response.data[1].name == <empname>
    And match response.data[1].relationship == <emprelationship>
    And match response.data[1].dob == <empdob>

    Examples:
      | empname |  emprelationship  |     empdob    |
      | 'Tulip' |    'Complicated'  | '2000-07-31'  |

  Scenario: TS32 - Get Unregistered Employee Dependent
    * def localID = '0000'
    Given path '/api/v1/employee/', localID, '/dependent'
    And header Authorization = 'Bearer ' + accessToken
    When method GET
    Then status 404
    And print response
    And match response contains {"error": {"status": "404","text": "Employee Not Found"}}
