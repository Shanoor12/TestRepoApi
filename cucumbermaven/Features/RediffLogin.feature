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
Feature: Rediff Login 
 As a registred user
 I want to be able to login
 So I can access my inbox 
 This file contains various scenarios for Login feature

  @tag1
  Scenario: Valid Login
    Given User is on Rediff Login page
    When User enters a valid username and password
    And User clicks on login button
    Then User is logged in
 
  @tag1
  Scenario: Invalid Login
    Given User is on Rediff Login page
    When User enters an invalid username and password
    And User clicks on login button
    Then An error is displayed
  
  @tag1
  Scenario: Reset Password
		Given User is on Rediff Login page
		When User enters username
		And User clicks on Forgot password link
		Then User is navigated to reset password page

