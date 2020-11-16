package hellocucumber;

import static org.junit.Assert.assertEquals;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserStory8 {
	
	private ArrayList<Object> incompleteHighQuery;
	private ArrayList<Object> completeHighQuery;
	private ArrayList<Object> statusPriorityTasks;
	
	@When("I enter query for incomplete HIGH priority tasks")
	public void i_enter_query_for_incomplete_high_priority_tasks() {
		
		String complete = "false";
		String priority = "HIGH";
		incompleteHighQuery = new ArrayList<Object>();
		
		try {
			String request = "http://localhost:4567/todos?doneStatus=" + complete + "&description=" + priority;
			URL url = new URL(request);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.connect();
	        
	        int code = conn.getResponseCode();
			assertEquals(code, 200);
			
			String inline = "";
            Scanner scanner = new Scanner(url.openStream());

            //Write all the JSON data into a string using a scanner
            while (scanner.hasNext()) {
                inline += scanner.nextLine();
            }

            //Close the scanner
            scanner.close();
            
            JSONParser parse = new JSONParser();
            JSONObject jobj = (JSONObject)parse.parse(inline);
            JSONArray jsonarr_1 = (JSONArray) jobj.get("todos");
            
            
            for(int i=0; i<jsonarr_1.size() ;i++) {
            	JSONObject obj = (JSONObject)jsonarr_1.get(i);
            		incompleteHighQuery.add(obj.get("title"));
            }
                    
		} catch (Exception e) {
			
		}
	}

	@Then("I can view all incomplete HIGH priority tasks")
	public void i_can_view_all_incomplete_high_priority_tasks() {
		for(int i=0; i < incompleteHighQuery.size(); i++) {
			System.out.println(incompleteHighQuery.get(i));
		}
	}

	@When("I enter query for complete HIGH priority tasks")
	public void i_enter_query_for_complete_high_priority_tasks() {
		
		String complete = "true";
		String priority = "HIGH";
		completeHighQuery = new ArrayList<Object>();
		
		try {
			String request = "http://localhost:4567/todos?doneStatus=" + complete + "&description=" + priority;
			URL url = new URL(request);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.connect();
	        
	        int code = conn.getResponseCode();
			assertEquals(code, 200);
			
			String inline = "";
            Scanner scanner = new Scanner(url.openStream());

            //Write all the JSON data into a string using a scanner
            while (scanner.hasNext()) {
                inline += scanner.nextLine();
            }

            //Close the scanner
            scanner.close();
            
            JSONParser parse = new JSONParser();
            JSONObject jobj = (JSONObject)parse.parse(inline);
            JSONArray jsonarr_1 = (JSONArray) jobj.get("todos");
            
            
            for(int i=0; i<jsonarr_1.size() ;i++) {
            	JSONObject obj = (JSONObject)jsonarr_1.get(i);
            		completeHighQuery.add(obj.get("title"));	
            }
                    
		} catch (Exception e) {
			
		}
	}

	@Then("I can view all complete HIGH priority tasks")
	public void i_can_view_all_complete_high_priority_tasks() {
		for(int i=0; i < completeHighQuery.size(); i++) {
			System.out.println(completeHighQuery.get(i));
		}
	}

	@When("I enter query for invalid priority label")
	public void i_enter_query_for_invalid_priority_label() {
		
		String invalidPriority = "MID";
	
		try {
			String request = "http://localhost:4567/todos?doneStatus=true&description=" + invalidPriority;
			URL url = new URL(request);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.connect();
	        
	        int code = conn.getResponseCode();
			assertEquals(code, 200);
                    
		} catch (Exception e) {
			
		}
	}
	
	@Then("I get a query error for invalid priority")
	public void i_get_a_query_error_for_invalid_priority() {
		
		String invalidPriority = "MID";
		
		try {
			String request = "http://localhost:4567/todos?doneStatus=true&description=" + invalidPriority;
			URL url = new URL(request);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.connect();
	        
	        int code = conn.getResponseCode();
			assertEquals(code, 200);
                    
		} catch (Exception e) {
			
		}
	}
	
	@When("I enter query for {string} {string} priority tasks")
	public void i_enter_query_for_priority_tasks(String doneStatus, String description) {
		
		statusPriorityTasks = new ArrayList<Object>();
		
		try {
			String request = "http://localhost:4567/todos?doneStatus=" + doneStatus + "&description=" + description;
			URL url = new URL(request);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.connect();
	        
	        int code = conn.getResponseCode();
			assertEquals(code, 200);
			
			String inline = "";
            Scanner scanner = new Scanner(url.openStream());

            //Write all the JSON data into a string using a scanner
            while (scanner.hasNext()) {
                inline += scanner.nextLine();
            }

            //Close the scanner
            scanner.close();
            
            JSONParser parse = new JSONParser();
            JSONObject jobj = (JSONObject)parse.parse(inline);
            JSONArray jsonarr_1 = (JSONArray) jobj.get("todos");
            
            
            for(int i=0; i<jsonarr_1.size() ;i++) {
            	JSONObject obj = (JSONObject)jsonarr_1.get(i);
            		statusPriorityTasks.add(obj.get("title"));
            }
                    
		} catch (Exception e) {
			
		}
   
	}

	@Then("I can view all {string} {string} priority tasks")
	public void i_can_view_all_priority_tasks(String doneStatus, String description) {
		for(int i=0; i < statusPriorityTasks.size(); i++) {
			System.out.println(statusPriorityTasks.get(i));
		}   
	}

}
