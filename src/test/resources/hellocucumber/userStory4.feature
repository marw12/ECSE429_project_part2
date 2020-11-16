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
Feature: I remove an unnecessary task from my course to do list, so I can forget about it.

 	Background: 
 		Given I am a student
 		
  @tag1
  Scenario: Remove a task with id 
    When I remove a task using the id 
    Then I can not view the task in the to do list
    
    @tag2
  Scenario: Remove a task with invalid id
    When I remove a task using invalid id
    Then nothing is removed
  
    @tag3
  Scenario: Remove a task without an id
    When I remove a task without an id
    Then I get a delete error

  @tag4
  Scenario Outline: Remove a task with <id>
    When I remove a task with <id>
    Then I can not view task with <id>

    Examples: 
      | id|
      | "200" | 
      | "200" |
