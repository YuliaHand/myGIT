Feature: REGISTER FORM
  As a User, I want to register an account
  So, I can book a room

  Background: USER REDIRECTED TO ACCOUNT AUTHENTICATION PAGE
    Given User is in qa.cilsy.id Landing Page
    When User click Sign In button
    Then User is directed to account Authentication page

  @CreateAcc
  Scenario: USER CREATE AN ACCOUNT WITH VALID EMAIL
    When User input valid email address on Create an Account authentication
    And User click Create an Account button
    Then User directed to Create an Account form

  @CreateAcc
  Scenario: USER CREATE AN ACCOUNT WITH EXISTING EMAIL
    When User input existing email address on Create an Account authentication
    And User click Create an Account button
    Then Show error message "An account using this email address has already been registered. Please enter a valid password or request a new one."

  @Register
  Scenario: USER DOES NOT INPUT DATA TO ALL REGISTER FORM FIELDS
    When User input valid email address on Create an Account authentication
    And User click Create an Account button
    And User leave First Name and Last Name field blank
    And User leave Email field blank
    And User leave Password field blank
    And User click Register button
    Then Show error message firstname is required.
    And Show error message lastname is required.
    And Show error message email is required.
    And Show error message passwd is required.

  @Register
  Scenario Outline: USER REGISTER WITH VALID DATA
    When User input valid <EmailAddress> on Create an Account authentication
    And User click Create an Account button
    And User Select Title
    And User Input <FirstName> and <LastName> field blank
    And User Input <Password> field
    And User Input Date of Birth field
    And User Check Sign up for our newsletter! and Receive special offers from our partners!
    And User Click Register button
    Then User Successfully registered and auto signed in to website by Sistem

    Examples:
      | FirstName | LastName | Password |    EmailAddress   |
      |    Lia    |  Yulia   |  asd123  | mewmew3r@times.com |


