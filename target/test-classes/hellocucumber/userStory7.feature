Feature: query the incomplete tasks for a class
  	I want to view the tasks that are incomplete
  
 	Background: 
 		Given wait for server to start
 		Given I am a student
 		
 		
 	Scenario: Query tasks for a class that are incomplete
    When I enter query for incomplete tasks of a class
    Then I can view the incomplete tasks
    
  Scenario: Query tasks for a class that are complete
    When I enter query for complete tasks of a class
    Then I can view the complete tasks
    
  Scenario: Query tasks for a nonexistent class
    When I enter query for a nonexistent class
    Then I get a query error
    
  Scenario Outline: Query tasks for a <class>
    When I enter query for incomplete tasks of a <class>
    And I enter query for complete tasks of a <class>
    Then I can view the incomplete tasks
    And I can view the complete tasks
    
  Examples:
    | class |
    |  "1"  |
    |  "1"  |