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
Feature: Registration
  I want to use this template for my feature file

  @tag
  Scenario Outline: Registration
  Given User is on Rediff Registration page
  When User enters "<name>" "<email>" and "<password>"
  Then User is Registered successfully 

    Examples: 
      | name         | email            | password |
      | user user    | user@rediff.com  | user@123 |
      | admin admin  | user@rediff1.com | user@173 |

      
      @pri1 @reg
      Scenario:
      Given User is on Rediff Registration page
      When User enters registration data
      |name    |admin admin     |
      |email   |admin@rediff.com|
      |password|admin12         |
      |gender  |f               |
      |contry  |Ausralia        |
      Then User is registered successfully