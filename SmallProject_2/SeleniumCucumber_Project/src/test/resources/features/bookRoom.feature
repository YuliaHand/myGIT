Feature: BOOK A ROOM
  As a User, I want to book a room by search box
  I already signed in
  I book a general room and check in just for 1 day
  I choose pay by Bank Wire payment

  Background: USER SIGNED IN TO SITE
    Given User is in qa.cilsy.id Landing Page
    And User already signed in to website

  @SearchHotel
  Scenario Outline: USER SEARCH HOTEL BY SEARCH BOX
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

  @SearchRoom
  Scenario Outline: USER BOOK A GENERAL ROOM AND SELECT PAY BY BANK WIRE
    Given User already search hotel by search box
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