package hellocucumber;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

	
public class UserStory1 {
	
	private boolean student;
	
	@Given("I am a student")
	public void i_am_a_student() throws ConnectException {
	    // Write code here that turns the phrase above into concrete actions
		try {
			String request = "http://localhost:4567/";
			URL url = new URL(request);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
	        conn.connect();
			this.student = true;
		} catch (Exception e) {
			throw new java.net.ConnectException();
		}	
	}	

	@When("I categorize {string} as {string}")
	public void i_categorize_as(String task, String priority) {
		task = RunTest.get_task();
		priority = RunTest.get_priority();
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
	
	@When("I categorize {string} as HIGH")
	public void i_categorize_as_high(String task) {
		task = RunTest.get_task();
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
			
		}	
	}
	
	@When("I categorize {string} as LOW")
	public void i_categorize_as_low(String task) {
		task = RunTest.get_task();
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
	        
	        String inline = "";
            Scanner scanner = new Scanner(url.openStream());

            //Write all the JSON data into a string using a scanner
            while (scanner.hasNext()) {
                inline += scanner.nextLine();
            }

            //Close the scanner
            scanner.close();
	        
		} catch (Exception e) {
			
		}
	}




	@Then("I can view the {string} priority in the description")
	public void i_can_view_the_priority_in_the_description(String task) {
		task = RunTest.get_task();
		try {
			String request = "http://localhost:4567/todos/" + task;
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
	        
		} catch (Exception e) {
			
		}   
	}


}