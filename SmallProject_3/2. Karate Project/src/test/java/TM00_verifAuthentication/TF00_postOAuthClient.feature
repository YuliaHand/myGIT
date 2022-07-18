Feature: Post Oauth Client

  Background:
    Given url baseUrl

  Scenario: TS00 - Get Token With Input Valid Oauth Client
    Given path '/oauth/issueToken'
    And form field client_id = client_id
    And form field client_secret = client_secret
    And form field grant_type = grant_type
    When method POST
    Then status 200

    * def tokenID = response.access_token
    And print tokenID
