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
Feature: Employee
  I want to use this template for my feature file
  
   @tag1
  Scenario: CreateEmp
  Given Payload for CreateEmp api 
  When User calls Create api using http POST request
  Then Status2 code is 201
	And  "name" in the response is like "morpheus"
	
	
	@tag1
	Scenario: UpdateEmp
	Given Payload for UpdateEmp api
	When User calls Update api using http PUT request
	Then Status2 code is 200
	And  "job" in the response is like "zion resident"
	
	@tag1
	Scenario: SingleUserEmp
	Given Payload for SingleUserEmp api
	When User calls SingleUserEmp api using http GET request
	Then Status2 code is 200
	And  "first_name" in the response is "Janet"
	
	@tag1
	Scenario: DeleteEmp
	Given Payload for DeleteEmp api
	When User calls DeleteE api using http DELETE request
	Then Status2 code is 204
	
	
	

  
