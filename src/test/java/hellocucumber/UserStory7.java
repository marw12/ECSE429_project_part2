package hellocucumber;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class UserStory7 {
	
	
	private ArrayList<Object> doneQuery;
	private ArrayList<Object> notDoneQuery;
	private String classId;
	
	@When("I enter query for incomplete tasks of a class")
	public void i_enter_query_for_incomplete_tasks_of_a_class() {
		
		classId = "1";
		notDoneQuery = new ArrayList<Object>();
		
		try {
			String request = "http://localhost:4567/projects/" + classId + "/tasks";
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
            	
            	if(obj.get("doneStatus").equals("false")) {
            		notDoneQuery.add(obj.get("title"));
            	}
            	
            }
                    
		} catch (Exception e) {
			
		}
	    
	}

	@Then("I can view the incomplete tasks")
	public void i_can_view_the_incomplete_tasks() {
		
		for(int i=0; i<notDoneQuery.size(); i++) {
			System.out.println(notDoneQuery.get(i));
		}
		
	}

	@When("I enter query for complete tasks of a class")
	public void i_enter_query_for_complete_tasks_of_a_class() {
		classId = "1";
		doneQuery = new ArrayList<Object>();
		
		try {
			String request = "http://localhost:4567/projects/" + classId + "/tasks";
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
            	
            	if(obj.get("doneStatus").equals("true")) {
            		doneQuery.add(obj.get("title"));
            	}
            	
            }
                    
		} catch (Exception e) {
			
		}
	}

	@Then("I can view the complete tasks")
	public void i_can_view_the_complete_tasks() {
		for(int i=0; i<doneQuery.size(); i++) {
			System.out.println(doneQuery.get(i));
		}
	}

	@When("I enter query for a nonexistent class")
	public void i_enter_query_for_a_nonexistent_class() {
		
		classId = "699";
		notDoneQuery = new ArrayList<Object>();
		
		try {
			String request = "http://localhost:4567/projects/" + classId + "/tasks";
			URL url = new URL(request);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.connect();
	        
	        int code = conn.getResponseCode();
			assertEquals(code, 200);
                    
		} catch (Exception e) {
			
		}
	}

	@Then("I get a query error")
	public void i_get_a_query_error() {
		String task = "699";

		try {
			String request = "http://localhost:4567/projects/" + classId + "/tasks";
			URL url = new URL(request);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			int code = conn.getResponseCode();
			assertEquals(code, 200);

			

		} catch (Exception e) {

		}
	}
	
	@When("I enter query for incomplete tasks of a {string}")
	public void i_enter_query_for_incomplete_tasks_of_a(String classId) {
		notDoneQuery = new ArrayList<Object>();
		
		try {
			String request = "http://localhost:4567/projects/" + classId + "/tasks";
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
            	
            	if(obj.get("doneStatus").equals("false")) {
            		notDoneQuery.add(obj.get("title"));
            	}
            	
            }
                    
		} catch (Exception e) {
			
		}
	}

	@When("I enter query for complete tasks of a {string}")
	public void i_enter_query_for_complete_tasks_of_a(String classId) {
		doneQuery = new ArrayList<Object>();
		
		try {
			String request = "http://localhost:4567/projects/" + classId + "/tasks";
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
            	
            	if(obj.get("doneStatus").equals("true")) {
            		doneQuery.add(obj.get("title"));
            	}
            	
            }
                    
		} catch (Exception e) {
			
		}
	}


}