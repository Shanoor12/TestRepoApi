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
Feature: Google Place Api
Various Tests to validate Google Place Apis

		@tag1
		Scenario: Add Place
			Given Payload for Add Place api
			When User calls Add Place api using http POST request
			Then Status code is 200
			And "status" in response is "OK"
			And placeid is fetched
			
		@tag1
		Scenario: Get Place
			Given Payload for Get place api
			When User calls Get Place api using http GET request
			Then Status code is 200
			And "name" in response is "Frontline house"
			
			@tag1
		Scenario: Update Place
			Given Payload for Update place api
			When User calls Get Place api using http PUT request
			Then Status code is 200
			And "msg" in response is "Address successfully updated"
			
			@tag1
		Scenario: Deletet Place
			Given Payload for Delete place api
			When User calls Get Place api using http DELETE request
			Then Status code is 200
			And "status" in response is "OK"
			
			
			
  
