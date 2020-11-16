Feature: Adjust the priority of a task
  I want to better manage my time
  
 	Background: 
 		Given I am a student
 		
 	Scenario: Adjust the priority of a task to a new priority
    When I adjust the priority of a task to a new priority
    Then I can view the task and its updated priority
    
  Scenario: Adjust the priority of a task to the same priority
    When I adjust the priority of a task to the same priority
    Then I can view the task and its unchanged priority
    
  Scenario: Adjust the priority of a non-existent task
    When I adjust the priority of a non-existent task
    Then I get a Not Found error
    
  Scenario Outline: Adjust the priority of <taskId> <title> to <priority>
  	When I adjust the priority of a <taskId> <title> to <priority>
    Then I can view the <taskId> <title> and its updated <priority>
    
  Examples:
    | taskId | title | priority |
    |  "1" | "scan paperwork" |	 "LOW"	 |
    |  "2" | "file paperwork" |	 "HIGH"	 |
   