Feature: SEARCH ROOMS
  As a User, I want to book a room by search rooms feature
  I check in just for 2 days
  and I choose pay by Bank Wire payment

  Background: USER SEARCH HOTEL BY SEARCH BOX
    Given User navigate to Landing Page
    And User signed in to website
    And User already searched a hotel

  @searchRooms
  Scenario Outline: USER SUCCESSFULLY BOOK A GENERAL ROOM For 2 DAYS BY SEARCH BOX
    Given User onfocus to the search rooms box
    When User Choose <RoomName> and Input Qty of Rooms
    And User Click Book Now button
    And User Click Proceed to checkout button
    And User Click Proceed button on Rooms & Price Summary
    And User Click Proceed button on Guest Information
    And User Check The Terms of Service checkbox
    And User Select pay by bank wire
    And User Click I confirm my order
    Then User Successfully book a general room

    Examples:
      |        RoomName         |
      |      General Rooms      |


