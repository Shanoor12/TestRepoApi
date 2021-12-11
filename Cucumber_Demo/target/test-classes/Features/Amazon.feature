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
  	Given User is on Amazon home page
  	When User searches for "mobiles"
  	Then Results for "mobiles" are displayed
  	
  	@tag1
  	Scenario: Sort
  	When User sorts the results by "Price: High to Low"
  	Then Results are sorted by "Price: High to Low"
  	
  	@tag1
  	Scenario: Filter
  	When User filters the results "Smartphones"
  	Then Results are Filtered "Smartphones"
  	

