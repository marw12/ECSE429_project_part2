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
Feature: Add a task in course to do list so I can remember it

	Background: 
			Given I am a student

  @tag1
  Scenario: Add a new task with a title
    When I create a task for a course with a title
    Then I can view the task with the title in the to do list
    
   @tag1
  Scenario: Add a new task with a title and description
    When I create a task for a course with a title and description
    Then I can view the task with the title and description in the to do list
    
    @tag1
  Scenario: Add a new task without a title
    When I create a task without a title
    Then I get an error
    
  @tag2
  Scenario Outline: Add a <task> to the course list
    When I create a <task> 
    Then I can view <task> in to do list

    Examples: 
      | task  | 
      | "2" |
 
