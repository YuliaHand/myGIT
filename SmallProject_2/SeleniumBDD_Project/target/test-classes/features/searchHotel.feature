Feature: SEARCH HOTEL
  As a User, I want to search hotel by search box

  Background: USER SIGNED IN TO WEBSITE
    Given User is in qa.cilsy.id Landing Page
    And User already signed in to website

  @SearchBox
  Scenario Outline: USER SUCCESSFULLY SEARCH HOTEL BY SEARCH BOX
    Given User onfocus to the searchbox
    When User Input <HotelLoc> on Hotel Location field
    And User Select hotel name on Select Hotel field
    And User Select check in and check out date
    And User Click Search Now button
    Then User directed to search rooms page

    Examples:
    | HotelLoc |
    |   Aceh   |
    |  Jakarta |


  @SearchBox
  Scenario: USER SEARCH HOTEL WITHOUT INPUT DATA
    Given User onfocus to the searchbox
    When User does not input hotel location on Hotel Location field
    And User does not select hotel name on Select Hotel field
    And User does not select check in and check out date
    And User Click Search Now button
    Then Show error, all fields color change to red