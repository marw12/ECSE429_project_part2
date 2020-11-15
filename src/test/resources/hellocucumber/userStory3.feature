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
Feature: Mark a task as done on the course to do list, so I can track the accomplishments.

 	Background: 
 		Given I am a student
 		
  @tag1
  Scenario: Mark task with doneStatus of false as done
    When I set doneStatus of task to true
    Then I can view that task as done
   
    @tag1
  Scenario: Mark the task with doneStatus of true as done
    When I set the doneStatus of task to true
    Then I can still view the task as done
   
     @tag1
  Scenario: Mark task incorrectly
    When I set the doneStatus of the task as a non boolean
    Then I get an error

  @tag2
  Scenario Outline: Mark task doneStatus as <status>
    When I set the <status> of task doneStatus
    Then I verify the <status> of that task

    Examples: 
      | status|
      | True  |
      | False |
