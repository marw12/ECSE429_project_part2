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
import java.util.Scanner;


public class UserStory5 {
	
	
	private String classId;
	private String className;
	
	
	@When("I create a todo list for a new class")
	public void i_create_a_todo_list_for_a_new_class() {
	    //create new class
		className = "Biology";
		
		try {
			String request = "http://localhost:4567/projects";
			URL url = new URL (request);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			String jsonInputString = "{\"title\":" + className + "}";
			
			try(OutputStream os = con.getOutputStream()){
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);			
			}
			
			int code = con.getResponseCode();
			assertEquals(code, 201);

		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		//add todo list to new course
		classId = "2";
		
		try {
			String request = "http://localhost:4567/projects/" + classId + "/tasks";
			URL url = new URL (request);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			String jsonInputString = "{\"id\":\"1\"}";
			
			try(OutputStream os = con.getOutputStream()){
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);			
			}
			
			int code = con.getResponseCode();
			assertEquals(code, 201);

		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}

	@Then("I can view todo list is linked to the new class")
	public void i_can_view_todo_list_is_linked_to_the_new_class() {
		classId = "2";
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

	@When("I create a todo list for an existing class")
	public void i_create_a_todo_list_for_an_existing_class() {
		classId = "1";
		
		try {
			String request = "http://localhost:4567/projects/" + classId + "/tasks";
			URL url = new URL (request);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			String jsonInputString = "{\"id\":\"1\"}";
			
			try(OutputStream os = con.getOutputStream()){
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);			
			}
			
			int code = con.getResponseCode();
			assertEquals(code, 201);

		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Then("I can view todo list is linked to the existing class")
	public void i_can_view_todo_list_is_linked_to_the_existing_class() {
		classId = "1";
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

	@When("I create a todo list for a nonexistent class")
	public void i_create_a_todo_list_for_a_nonexistent_class() {
		classId = "699";
		
		try {
			String request = "http://localhost:4567/projects/" + classId + "/tasks";
			URL url = new URL (request);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			String jsonInputString = "{\"id\":\"2\"}";
			
			try(OutputStream os = con.getOutputStream()){
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);			
			}
			
			int code = con.getResponseCode();
			assertEquals(code, 404);

		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Then("I get an error")
	public void i_get_an_error() {
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
	

	@When("I create a {string} list for a {string}")
	public void i_create_a_list_for_a(String todoId, String classId) {
		
		try {
			String request = "http://localhost:4567/projects/" + classId + "/tasks";
			URL url = new URL (request);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			String jsonInputString = "{\"id\":\"" + todoId + "\"}";
			
			try(OutputStream os = con.getOutputStream()){
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);			
			}
			
			int code = con.getResponseCode();
			assertEquals(code, 201);

		} catch (Exception e) {
			e.printStackTrace();
		}	
	
	}

	@Then("I can view todo list is linked to the {string}")
	public void i_can_view_todo_list_is_linked_to_the(String classId) {
		
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

}