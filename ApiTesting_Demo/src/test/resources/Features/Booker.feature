#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Booker API
  Various Tests to validate Booker APIs

  @tag1
  Scenario: Add Place
    Given Payload for Add Booking api with 
    |firstname      |Jim          |
    |lastname       |Brown        |
    |additionalneeds|Breakfast    |
    When User calls "ADDBOOKING" api using http "POST" request
    Then Status code is 200
    And "firstname" in response is "Jim"
    
  @tag1
  Scenario: Get Booking By Id
    Given Payload for Get Booking By Id api
    When User calls "GETBOOKING" api using http "GET" request
    Then Status code is 200
   
  @tag1
  Scenario: Update Booking
    Given Payload for Update Booking api
    When User calls "UPDATEBOOKING" api using http "PUT" request
    Then Status code is 200
