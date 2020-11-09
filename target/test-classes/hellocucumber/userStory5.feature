Feature: Add todo list items to a class
  I want to create a todo list for a new class
  
 	Background: 
 		Given I am a student
 		
 	Scenario: Add an existing todo list to a new class
    When I create a todo list for a new class
    Then I can view todo list is linked to the new class
    
    
  Scenario: Add a new todo list to an existing class
    When I create a todo list for an existing class
    Then I can view todo list is linked to the existing class
    
    
  Scenario: Add a todo list to a nonexistent class
    When I create a todo list for a nonexistent class
    Then I get an error