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
Feature: Google Place API
  Various Tests to validate Google Place APIs

  @tag1
  Scenario: Add Place
    Given Payload for Add Place api with 
    |name    |Frontline house          |
    |address |29, side layout, cohen 09|
    |phoneno |(+91) 983 893 3937       |
    |website |http://www.google.com    |
    |language|French-IN                |
    When User calls "ADDPLACE" api using http "POST" request
    Then Status code is 200
    And "status" in response is "OK"
    And placeid is fetched
    
  @tag1
  Scenario: Get Place
    Given Payload for Get Place api
    When User calls "GETPLACE" api using http "GET" request
    Then Status code is 200
    And "name" in response is "Frontline house"
   
  @tag1
  Scenario: Update Place
    Given Payload for Update Place api
    When User calls "UPDATEPLACE" api using http "PUT" request
    Then Status code is 200
    And "msg" in response is "Address successfully updated"
    
  
  @tag2
  Scenario Outline: Add Place with Data
    Given Payload for Add Place api with "<name>", "<address>", "<phoneno>"
    When User calls "ADDPLACE" api using http "POST" request
    Then Status code is 200
    And "status" in response is "OK"
    And placeid is fetched

    Examples: 
      | name         | address                 | phoneno           |
      | Fulcrum Head |  23, MG Road, New Delhi | (+91) 934 893 393 |
      | Fulcrum Pune |  10, Baner, Pune				 | (+91) 973 893 393 |
