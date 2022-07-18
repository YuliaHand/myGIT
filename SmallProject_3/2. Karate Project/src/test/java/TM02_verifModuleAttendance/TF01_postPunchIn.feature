Feature: Post Punch In

  Background:
    Given url baseUrl
    * def authToken = call read('classpath:TM00_verifAuthentication/TF00_postOAuthClient.feature')
    * def accessToken = authToken.tokenID
    And print accessToken

  Scenario Outline: TS11 - User Punch In with Valid Data
    * def localID = '55'
    Given path '/api/v1/employee/', localID, '/punch-in'
    And header Authorization = 'Bearer ' + accessToken
    And form field id = <employeeid>
    And form field timezone = <timezone>
    And form field note = <notes>
    And form field datetime = <datetime>
    When method POST
    Then status 200
    And print response
    And match response contains { "success": "Successfully Punched In" }

    Examples:
      | employeeid |     timezone   |     notes     |       datetime      |
      |    '55'    | 'Asia/Jakarta' |  'Aku Datang' |  '2022-07-15 07:00' |

  Scenario Outline: TS12 - User Punch In With Invalid Timezone
    * def localID = '56'
    Given path '/api/v1/employee/', localID, '/punch-in'
    And header Authorization = 'Bearer ' + accessToken
    And form field id = <employeeid>
    And form field timezone = <timezone>
    And form field note = <notes>
    And form field datetime = <datetime>
    When method POST
    Then status 202
    And print response
    And match response contains {"error": {"status": "202","text": "Invalid Time Zone"}}

    Examples:
      | employeeid |     timezone   |     notes     |       datetime      |
      |    '56'    |      'asd'     | 'No Comment'  |  '2022-07-15 07:00' |

  Scenario Outline: TS13 - User Punch In With Invalid Datetime
    * def localID = '56'
    Given path '/api/v1/employee/', localID, '/punch-in'
    And header Authorization = 'Bearer ' + accessToken
    And form field id = <employeeid>
    And form field timezone = <timezone>
    And form field note = <notes>
    And form field datetime = <datetime>
    When method POST
    Then status 202
    And print response
    And match response contains {"error": {"status": "202","text": "datetime must be a valid date. Sample format: \"2005-12-30 01:02\""}}

    Examples:
      | employeeid |     timezone   |     notes     |       datetime      |
      |    '56'    | 'Asia/Jakarta' | 'No Comment'  | '2022-07-15 07:000' |

  Scenario Outline: TS14 - User Punch In When Already Punch In
    * def localID = '55'
    Given path '/api/v1/employee/', localID, '/punch-in'
    And header Authorization = 'Bearer ' + accessToken
    And form field id = <employeeid>
    And form field timezone = <timezone>
    And form field note = <notes>
    And form field datetime = <datetime>
    When method POST
    Then status 202
    And print response
    And match response contains {"error": {"status": "202","text": "Cannot Proceed Punch In Employee Already Punched In"}}

    Examples:
      | employeeid |     timezone   |     notes     |       datetime      |
      |    '55'    | 'Asia/Jakarta' | 'No Comment'  |  '2022-07-15 07:00' |
