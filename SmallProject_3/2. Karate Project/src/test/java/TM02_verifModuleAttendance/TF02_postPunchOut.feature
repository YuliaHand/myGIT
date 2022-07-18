Feature: Post Punch Out

  Background:
    Given url baseUrl
    * def authToken = call read('classpath:TM00_verifAuthentication/TF00_postOAuthClient.feature')
    * def accessToken = authToken.tokenID
    And print accessToken

  Scenario Outline: TS15 - User Punch Out with Valid Data
    #* def punchinID2 = call read('TF01_postPunchIn.feature')
    #* def localID2 = punchinID2.localID
    #* print localID2
    * def localID2 = '55'
    Given path '/api/v1/employee/', localID2, '/punch-out'
    And header Authorization = 'Bearer ' + accessToken
    And form field id = <employeeid>
    And form field timezone = <timezone>
    And form field note = <notes>
    And form field datetime = <datetime>
    When method POST
    Then status 200
    And print response
    And match response contains { "success": "Successfully Punched Out" }

    Examples:
      | employeeid |     timezone   |     notes     |       datetime      |
      |    '55'    | 'Asia/Jakarta' |  'Aku Pulang' |  '2022-07-15 07:00' |

  Scenario Outline: TS16 - User Punch Out When Already Punch Out
    * def localID = '55'
    Given path '/api/v1/employee/', localID, '/punch-out'
    And header Authorization = 'Bearer ' + accessToken
    And form field id = <employeeid>
    And form field timezone = <timezone>
    And form field note = <notes>
    And form field datetime = <datetime>
    When method POST
    Then status 202
    And print response
    And match response contains {"error": {"status": "202","text": "Cannot Proceed Punch Out Employee Already Punched Out"}}

    Examples:
      | employeeid |     timezone   |     notes     |       datetime      |
      |    '55'    | 'Asia/Jakarta' | 'No Comment'  |  '2022-07-15 07:00' |

  Scenario Outline: TS17 - User Punch Out When User is not Punch In
    * def localID = '0'
    Given path '/api/v1/employee/', localID, '/punch-out'
    And header Authorization = 'Bearer ' + accessToken
    And form field id = <employeeid>
    And form field timezone = <timezone>
    And form field note = <notes>
    And form field datetime = <datetime>
    When method POST
    Then status 404
    And print response

    Examples:
      | employeeid |     timezone   |     notes     |       datetime      |
      |    '0'     | 'Asia/Jakarta' | 'No Comment'  |  '2022-07-15 07:00' |