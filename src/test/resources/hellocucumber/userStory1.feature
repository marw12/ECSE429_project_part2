
Feature: Categorize tasks as HIGH, MEDIUM or LOW priority
  I want to better manage my time
  
 	Background: 
 		Given I am a student
 		
  Scenario: categorize task as HIGH
    When I categorize "task" as HIGH
    Then I can view the "task" priority in the description
    
  Scenario: categorize task as LOW
    When I categorize "task" as LOW
    Then I can view the "task" priority in the description

 	Scenario: Cannot catagorize nonexistent task
 		When I catagorize nonexistent task
 		Then I receive an error