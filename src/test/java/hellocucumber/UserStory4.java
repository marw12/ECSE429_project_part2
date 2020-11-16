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

	
public class UserStory4 {
	

	@When("I remove a task using the id")
	public void i_remove_a_task_using_the_id() {
		String id = "45";
		//Creating the task here now
		
		try {

	        
			String request = "http://localhost:4567/todos/"+id;
			URL url = new URL(request);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("DELETE");
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

	@Then("I can not view the task in the to do list")
	public void i_can_not_view_the_task_in_the_to_do_list() {
		String id = "45";
		try {
			String request = "http://localhost:4567/todos/"+id;
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

	@When("I remove a task using invalid id")
	public void i_remove_a_task_using_invalid_id() {
		try {
			String request = "http://localhost:4567/todos/90";
			URL url = new URL(request);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("DELETE");
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

	@Then("nothing is removed")
	public void nothing_is_removed() {
		try {
			String request = "http://localhost:4567/todos/90";
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

	@When("I remove a task without an id")
	public void i_remove_a_task_without_an_id() {
		try {
			String request = "http://localhost:4567/todos/";
			URL url = new URL(request);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("DELETE");
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
	
	@Then("I get a delete error")
	public void i_get_a_delete_error() {
		try {
			String request = "http://localhost:4567/todos/";
			URL url = new URL(request);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("DELETE");
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

	@When("I remove a task with {string}")
	public void i_remove_a_task_with(String string) {
		try {
			String request = "http://localhost:4567/todos/"+string;
			URL url = new URL(request);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("DELETE");
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
	

	@Then("I can not view task with {string}")
	public void i_can_not_view_task_with(String string) {
		try {
			String request = "http://localhost:4567/todos/"+string;
			URL url = new URL(request);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("DELETE");
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


}