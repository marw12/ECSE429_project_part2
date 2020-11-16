Feature: Query all incomplete HIGH priority tasks
  I want to identify my short term goals
  
 	Background: 
 		Given I am a student
 		
 	Scenario: Query incomplete HIGH priority tasks from all classes
    When I enter query for incomplete HIGH priority tasks
    Then I can view all incomplete HIGH priority tasks

  Scenario: Query complete HIGH priority tasks from all classes
    When I enter query for complete HIGH priority tasks
    Then I can view all complete HIGH priority tasks
    
  Scenario: Query incomplete tasks from invalid priority label
    When I enter query for invalid priority label
    Then I get a query error for invalid priority
    
  Scenario Outline: Query <doneStatus> <description> priority tasks from all classes
  	When I enter query for <doneStatus> <description> priority tasks
  	Then I can view all <doneStatus> <description> priority tasks
  	
  Examples:
    | doneStatus | description |
    |  "true"    |	  "HIGH"	 |
    |  "false"   |	  "HIGH"	 |

  	