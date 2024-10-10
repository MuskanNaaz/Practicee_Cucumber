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
Feature: Login functionality for Opencart e-comm website
  I want to use this template for my feature file

  Background: 
    Given I am on the Opencart login page

  Scenario: Successfully login with valid credentials
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully

  Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given I have entered invalid "<userId>" and "<password>"
    When I click on the login button
    Then I should see erroe messgae indicating "<error_message>"

    Examples: 
      | userId            | password | error_message                                         |
      | invalid@email.com |   123456 | Warning: No match for E-Mail Address and/or Password. |
      | abcc              |    78905 | Warning: No match for E-Mail Address and/or Password. |
      
   
