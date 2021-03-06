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
Feature: Search
  I want to use this template for my feature file
  
   Background:: search
  	Given person is on yelp home page
  	When person searches for "restuarant"
  	Then The Results for "restuarant" are displayed
  	
  	@tag1
  	Scenario: Select
  	When person clicks the searched results "restuarant" 
  	Then "restuarant" page will open
  	
  	@tag1
  	Scenario: sort
  	When person sort the results for "Higest rated"
  	Then The results should sort as"Higest rated"
  	
  	@tag1
  	Scenario: Filter_Checkbox
  	When person click on reservations checkbox
  	Then It filter the based on reservations 

 