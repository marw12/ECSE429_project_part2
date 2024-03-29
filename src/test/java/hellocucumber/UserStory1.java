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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

	
public class UserStory1 {
	
	@Given("wait for server to start")
    public void wait_for_server_to_start() throws ConnectException {
		
		Runtime rt = Runtime.getRuntime();
		
    	try {
    		Process p1 = rt.exec("java -jar runTodoManagerRestAPI-1.5.5.jar");
			Process p2 = Runtime.getRuntime().exec("sleep 3s");
			
		} catch (Exception e) {
			throw new java.net.ConnectException();
		}
    }
	
	
	private boolean student;
	
	@Given("I am a student")
	public void i_am_a_student() throws ConnectException {
		
		student = true;
	    
	}	
	
	@When("I categorize {string} as {string}")
	public void i_categorize_as(String task, String priority) {

		try {
			String request = "http://localhost:4567/todos/" + task;
			URL url = new URL (request);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			String jsonInputString = "{\"description\":" + priority + "}";
			
			try(OutputStream os = con.getOutputStream()){
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);			
			}
			
			int code = con.getResponseCode();
			assertEquals(code, 200);

		} catch (Exception e) {
			e.printStackTrace();
		}	

	}
	
	@When("I categorize {string} as HIGH")
	public void i_categorize_as_high(String task) {
		String priority = "HIGH";
		try {
			String request = "http://localhost:4567/todos/" + task;
			URL url = new URL (request);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			String jsonInputString = "{\"description\":" + priority + "}";
			
			try(OutputStream os = con.getOutputStream()){
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);			
			}
			
			int code = con.getResponseCode();
			assertEquals(code, 200);

		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@When("I categorize {string} as MEDIUM")
	public void i_categorize_as_medium(String task) {
		String priority = "MEDIUM";
		try {
			String request = "http://localhost:4567/todos/" + task;
			URL url = new URL (request);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			String jsonInputString = "{\"description\":" + priority + "}";
			
			try(OutputStream os = con.getOutputStream()){
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);			
			}
			
			int code = con.getResponseCode();
			assertEquals(code, 200);

		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@When("I categorize {string} as LOW")
	public void i_categorize_as_low(String task) {
		
		String priority = "LOW";
		try {
			String request = "http://localhost:4567/todos/" + task;
			URL url = new URL (request);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			String jsonInputString = "{\"description\":" + priority + "}";
			
			try(OutputStream os = con.getOutputStream()){
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);			
			}
			
			int code = con.getResponseCode();
			assertEquals(code, 200);

		} catch (Exception e) {
			
		}	
	}
	
	@When("I catagorize nonexistent task")
	public void i_catagorize_nonexistent_task() {
		String task = "699";
		String priority = "HIGH";
		try {
			String request = "http://localhost:4567/todos/" + task;
			URL url = new URL (request);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			String jsonInputString = "{\"description\":" + priority + "}";
			
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

	@Then("I receive an error")
	public void i_receive_an_error() {
		String task = "699";
		try {
			String request = "http://localhost:4567/todos/" + task;
			URL url = new URL(request);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.connect();
	        
	        int code = conn.getResponseCode();
			assertEquals(code, 404);
	        
		} catch (Exception e) {
			
		}
	}




	@Then("I can view the {string} priority in the description")
	public void i_can_view_the_priority_in_the_description(String task) {

		try {
			String request = "http://localhost:4567/todos/" + task;
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