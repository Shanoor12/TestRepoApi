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
Feature: RediffLogin
  I want to use this template for my feature file

  @pri1 @login
  Scenario: Valid Login
    Given User is on Rediff Login page
    When User enters "admin" and "admin12" 
    Then The User is logged in
    
 
  @pri2 @login
  Scenario: Invalid Login
    Given User is on Rediff Login page
    When User enters "testuser" and "testuser12"
    Then "Wrong username and password combination." message is displayed
    
    
  @reg @pri1
  Scenario: Registration with data
   Given User is on Rediff Login page
   And User is navigated to registration page
   When User enters registration data
   |name      |admin admin     |
   |email     |admin@rediff.com|
   |password  |admin12         |
   |gender    |f               |
   |country   |Australia       |
   Then User is registred successfully 
