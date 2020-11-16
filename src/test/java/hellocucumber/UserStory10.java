package hellocucumber;

import static org.junit.Assert.assertEquals;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserStory10 {
	
	private String taskId;
	private String oldDesc;
	private String newDesc;
	
	@When("I change the description of task to a new description")
	public void i_change_the_description_of_task_to_a_new_description() {
		
		taskId = "1";
		oldDesc = "scan paperwork";
		newDesc = "file paperwork";
		
		try {
			String request = "http://localhost:4567/todos/" + taskId;
			URL url = new URL (request);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("PUT");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			String jsonInputString = "{\"title\":\"" + oldDesc + "\"}";
			
			try(OutputStream os = con.getOutputStream()) {
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);			
			}
			
			int code = con.getResponseCode();
			assertEquals(code, 200);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			String request = "http://localhost:4567/todos/" + taskId;
			URL url = new URL (request);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("PUT");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			String jsonInputString = "{\"title\":\"" + newDesc + "\"}";
			
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
	
	@Then("I can view the task and its updated description")
	public void i_can_view_the_task_and_its_updated_description() {
		
		taskId = "1";
		try {
			String request = "http://localhost:4567/todos/" + taskId;
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
            
            System.out.println(inline);

            //Close the scanner
            scanner.close();
	        
		} catch (Exception e) {
			
		}
	    
	}

	@When("I change the description of task to the same description")
	public void i_change_the_description_of_task_to_the_same_description() {
		
		taskId = "1";
		oldDesc = "scan paperwork";
		newDesc = "scan paperwork";
		
		try {
			String request = "http://localhost:4567/todos/" + taskId;
			URL url = new URL (request);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("PUT");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			String jsonInputString = "{\"title\":\"" + oldDesc + "\"}";
			
			try(OutputStream os = con.getOutputStream()){
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);			
			}
			
			int code = con.getResponseCode();
			assertEquals(code, 200);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			String request = "http://localhost:4567/todos/" + taskId;
			URL url = new URL (request);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("PUT");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			String jsonInputString = "{\"title\":\"" + newDesc + "\"}";
			
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

	@Then("I can view the task and its unchanged description")
	public void i_can_view_the_task_and_its_unchanged_description() {
		
		taskId = "1";
		try {
			String request = "http://localhost:4567/todos/" + taskId;
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
            
            System.out.println(inline);

            //Close the scanner
            scanner.close();
	        
		} catch (Exception e) {
			
		}
	    
	}
	
	@When("I change the description of a non-existent task")
	public void i_change_the_description_of_a_non_existent_task() {
	    
		taskId = "92";
		newDesc = "scan paperwork";
		
		try {
			String request = "http://localhost:4567/todos/" + taskId;
			URL url = new URL (request);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("PUT");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			String jsonInputString = "{\"title\":\"" + newDesc + "\"}";
			
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
	
	@When("I change the description of {string} to {string}")
	public void i_change_the_description_of_to(String taskId, String description) {
		
		try {
			String request = "http://localhost:4567/todos/" + taskId;
			URL url = new URL (request);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("PUT");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			String jsonInputString = "{\"title\":\"" + description + "\"}";
			
			try(OutputStream os = con.getOutputStream()) {
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);			
			}
			
			int code = con.getResponseCode();
			assertEquals(code, 200);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Then("I can view the {string} with its updated {string}")
	public void i_can_view_the_with_its_updated(String taskId, String description) {
	    
		try {
			String request = "http://localhost:4567/todos/" + taskId;
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
            
            System.out.println(inline);

            //Close the scanner
            scanner.close();
	        
		} catch (Exception e) {
			
		}
		
	}

}
