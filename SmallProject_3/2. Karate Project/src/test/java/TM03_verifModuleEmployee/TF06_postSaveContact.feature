Feature: Post Save Contact

  Background:
    Given url baseUrl
    #* def employeID = call read('TF01_postSaveEmployee.feature')
    #* def employeeID = employeID.employID
    #* print employeeID
    * def employeeID = '686'
    * def employeeContc = read('../testData/result_ContactDetail.json')
    * def authToken = call read('classpath:TM00_verifAuthentication/TF00_postOAuthClient.feature')
    * def accessToken = authToken.tokenID
    And print accessToken

  Scenario: TS26 - Save Employee Contact Detail with Valid Data
    Given path '/api/v1/employee/', employeeID , '/contact-detail'
    And header Authorization = 'Bearer ' + accessToken
    And request employeeContc[0]
    When method POST
    Then status 200
    And print response
    And match response contains {"success": "Successfully Saved"}

  Scenario: TS27 - Save Employee Contact Detail With Invalid Data
    Given path '/api/v1/employee/', employeeID , '/contact-detail'
    And header Authorization = 'Bearer ' + accessToken
    And request employeeContc[2]
    When method POST
    Then status 202
    And print response
    And match response contains {"error":{"status":"202","text":"homeTelephone must be a valid telephone number"}}