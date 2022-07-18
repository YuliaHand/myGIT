Feature: GUEST RATING
  As a User, I want to know what about user review
  So, I can choose to book a good room

  Background: USER SEARCH HOTEL BY SEARCH BOX
    Given User access to qa.cilsy.id website
    And User searched a hotel

  @guestRating
  Scenario Outline: VERIFY NO AVAILABLE ROOM BY GUEST RATING WITH 1-5 STARS
    Given User onfocus to the guest rating box
    When User select guest rating with 1-5 stars
    Then Show error <message>

    Examples:
      |           message                   |
      | 'No room available for this hotel!' |
