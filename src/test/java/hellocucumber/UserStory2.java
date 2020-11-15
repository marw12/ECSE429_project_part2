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

	
public class UserStory2 {
	

	
	@When("I create a task for a course with a title")
	public void i_create_a_task_for_a_course_with_a_title() {
	    // Write code here that turns the phrase above into concrete actions
		try {
			String request = "http://localhost:4567/todos";
			URL url = new URL (request);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			String jsonInputString = "{\"title\":" + "\"New Title\"" + "}";
			
			try(OutputStream os = con.getOutputStream()){
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);			
			}
			
			int code = con.getResponseCode();
			assertEquals(code, 201);

		} catch (Exception e) {
			
		}
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("I can view the task with the title in the to do list")
	public void i_can_view_the_task_with_the_title_in_the_to_do_list() {
		try {
			String request = "http://localhost:4567/todos/3";
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

	@When("I create a task for a course with a title and description")
	public void i_create_a_task_for_a_course_with_a_title_and_description() {
		try {
			String request = "http://localhost:4567/todos";
			URL url = new URL (request);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			String jsonInputString = "{\"title\":" + "\"Another Title\"" + ","+"\"description\":" + "\"Description here\"" + "}";
			
			try(OutputStream os = con.getOutputStream()){
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);			
			}
			
			int code = con.getResponseCode();
			assertEquals(code, 201);

		} catch (Exception e) {
			
		}
	}

	@Then("I can view the task with the title and description in the to do list")
	public void i_can_view_the_task_with_the_title_and_description_in_the_to_do_list() {
		try {
			String request = "http://localhost:4567/todos/3";
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

	@When("I create a task without a title")
	public void i_create_a_task_without_a_title() {
		try {
			String request = "http://localhost:4567/todos";
			URL url = new URL (request);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			String jsonInputString = "{\"description\":" + "\"No title here\"" + "}";
			
			try(OutputStream os = con.getOutputStream()){
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);			
			}
			
			int code = con.getResponseCode();
			assertEquals(code, 400);

		} catch (Exception e) {
			
		}
	}

	@When("I create a {string}")
	public void i_create_a(String string) {
		try {
			String request = "http://localhost:4567/todos";
			URL url = new URL (request);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			String jsonInputString = "{\"id\":" + string + "}";
			
			try(OutputStream os = con.getOutputStream()){
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);			
			}
			
			int code = con.getResponseCode();
			assertEquals(code, 400);

		} catch (Exception e) {
			
		}
	}

	@Then("I can view {string} in to do list")
	public void i_can_view_in_to_do_list(String string) {
		try {
			String request = "http://localhost:4567/todos/"+string;
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