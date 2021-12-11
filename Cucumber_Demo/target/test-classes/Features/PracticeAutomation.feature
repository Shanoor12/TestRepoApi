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
Feature: Online Booking
  I want to use this template for my feature file

 @tag
  Scenario: Home page
  Given User3 is on practice automation page
  When User3 clicks on any listed image item and click on add basket button
  Then The product will add to cart

   
      @tag1
      Scenario: cart page
      Given User3 is on cart page
      When User3 click on Increase quantity and click on update button 
      Then User3 proceed to payment page
      
      @tag 
      
     Scenario: payment page
     
    Given User3 is on payment page
     When User enters registration data
      |fistname    |admin admin     |
      |Lastname    |golandaz|
      |company     |fulcrum|
      |email       |admin@rediff.com|
      |phonenumber |9089876554         |
      |country     |India|
      |address     |f jghjgjh              |
      |state       |andrapradesh|
      |city        |Dharwad        |
      |postcode    |9879798|
      Then User process to payment
     
