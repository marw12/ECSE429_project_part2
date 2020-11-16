Feature: remove todo list items from a class
  I want to remove a todo list from a class
  
 	Background: 
 		Given wait for server to start
 		Given I am a student
 		
 		
 	Scenario: Remove an existing todo list from a class
    When I remove a todo list from a class
    Then I can view todo list is not linked to the class
    
  Scenario: Remove a todo list from a new class
    When I remove a todo list from a new class
    Then I can view todo list is not linked to the new class
    
   Scenario: Remove a todo list from a nonexistent class
    When I remove a todo list from a nonexistent class
    Then I get an error for removing
    
   Scenario Outline: Remove a <todo> list from a <class>
    When I remove a <todo> list from a <class>
    Then I can view todo list is not linked to the <class>
    
    Examples:
    | class | todo |
    |  "1"  |	"1"	 |
    |  "1"  |	"2"	 |