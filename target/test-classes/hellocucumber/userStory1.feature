Feature: Categorize tasks as HIGH, MEDIUM or LOW priority
  I want to better manage my time
  
 	Background: 
 		Given I am a student
 		
 	Scenario: Cannot catagorize nonexistent task
 		When I catagorize nonexistent task
 		Then I receive an error
 		
 	Scenario Outline: categorize <task> as <priority>
  When I categorize <task> as <priority>
  Then I can view the <task> priority in the description

  Examples:
    | task  | priority |
    |  "1"  | HIGH		 |
    |  "1"  | MEDIUM   |
    |  "2"  | LOW      |