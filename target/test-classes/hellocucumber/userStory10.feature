Feature: Change the description of task
  I want to better represent the work I do
  
 	Background:
 		Given wait for server to start 
 		Given I am a student
 		
 	Scenario: Change the description of a task to a new description
    When I change the description of task to a new description
    Then I can view the task and its updated description
    
  Scenario: Change the description of a task to the same description
    When I change the description of task to the same description
    Then I can view the task and its unchanged description
    
  Scenario: Change the description of a non-existent task
    When I change the description of a non-existent task
    Then I get a Not Found error
    
  Scenario Outline: Change the description of <taskId> to <newDesc>
  	When I change the description of <taskId> to <newDesc>
    Then I can view the <taskId> with its updated <newDesc>
    
  Examples:
    | taskId |   newDesc   |
    |  "1"   | "scan paperwork" |
    |  "2"   | "file paperwork" |
  
   