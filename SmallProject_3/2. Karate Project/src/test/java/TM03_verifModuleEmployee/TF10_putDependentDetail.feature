Feature: Put Dependent Detail

  Background:
    Given url baseUrl
    * def authToken = call read('classpath:TM00_verifAuthentication/TF00_postOAuthClient.feature')
    * def accessToken = authToken.tokenID
    And print accessToken

  Scenario Outline: TS33 - Update Registered Employee Dependent
    #* def employeID = call read('TF08_postSaveDependent.feature')
    #* def localID2 = employeID.localID
    #* print localID2
    * def localID2 = '686'
    Given path '/api/v1/employee/', localID2, '/dependent'
    And header Authorization = 'Bearer ' + accessToken
    And form field id = <empid>
    And form field name = <empname>
    And form field relationship = <emprelationship>
    And form field dob = <empdob>
    And form field sequenceNumber = <sequenceID>
    When method PUT
    Then status 200
    And print response
    And match response contains {"success": "Successfully Updated"}

    Examples:
      |  empid  | empname |  emprelationship  |     empdob    |  sequenceID  |
      |  '686'  | 'Lilia' |       'LDR'       | '2000-07-31'  |      "2"     |