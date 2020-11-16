package hellocucumber;

import static org.junit.Assert.assertEquals;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserStory9 {
	
	private String taskId;
	private String title;
	private String firstUpdate;
	private String secondUpdate;
	
	@When("I adjust the priority of a task to a new priority")
	public void i_adjust_the_priority_of_a_task_to_a_new_priority() {
		
		taskId = "1";
		title = "scan paperwork";
		firstUpdate = "HIGH";
		secondUpdate = "LOW";
		
		try {
			String request = "http://localhost:4567/todos/" + taskId;
			URL url = new URL (request);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("PUT");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			String jsonInputString = 	" {\"title\":\"" +  title + 
										"\", \"description\":" + firstUpdate + "}";
			
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
			
			String jsonInputString = 	" {\"title\":\"" +  title + 
										"\", \"description\":" + secondUpdate + "}";
			
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

	@Then("I can view the task and its updated priority")
	public void i_can_view_the_task_and_its_updated_priority() {
		
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

	@When("I adjust the priority of a task to the same priority")
	public void i_adjust_the_priority_of_a_task_to_the_same_priority() {
		
		taskId = "1";
		title = "scan paperwork";
		firstUpdate = "MEDIUM";
		secondUpdate = "MEDIUM";
		
		try {
			String request = "http://localhost:4567/todos/" + taskId;
			URL url = new URL (request);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("PUT");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			String jsonInputString = 	" {\"title\":\"" +  title + 
										"\", \"description\":" + firstUpdate + "}";
			
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
			
			String jsonInputString = 	" {\"title\":\"" +  title + 
										"\", \"description\":" + secondUpdate + "}";
			
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

	@Then("I can view the task and its unchanged priority")
	public void i_can_view_the_task_and_its_unchanged_priority() {
		
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

	@When("I adjust the priority of a non-existent task")
	public void i_adjust_the_priority_of_a_non_existent_task() {
		
		taskId = "92";
		title = "scan paperwork";
		firstUpdate = "MEDIUM";
		secondUpdate = "MEDIUM";
		
		try {
			String request = "http://localhost:4567/todos/" + taskId;
			URL url = new URL (request);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("PUT");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			String jsonInputString = 	" {\"title\":\"" +  title + 
										"\", \"description\":" + firstUpdate + "}";
			
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

	@Then("I get a Not Found error")
	public void i_get_a_not_found_error() {
		
		taskId = "92";
		title = "scan paperwork";
		firstUpdate = "MEDIUM";
		secondUpdate = "MEDIUM";
		
		try {
			String request = "http://localhost:4567/todos/" + taskId;
			URL url = new URL (request);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("PUT");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			String jsonInputString = 	" {\"title\":\"" +  title + 
										"\", \"description\":" + firstUpdate + "}";
			
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
	
	@When("I adjust the priority of a {string} {string} to {string}")
	public void i_adjust_the_priority_of_a_to(String taskId, String title, String priority) {
		
		try {
			String request = "http://localhost:4567/todos/" + taskId;
			URL url = new URL (request);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("PUT");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			String jsonInputString = 	" {\"title\":\"" +  title + 
										"\", \"description\":" + priority + "}";
			
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

	@Then("I can view the {string} {string} and its updated {string}")
	public void i_can_view_the_and_its_updated(String taskId, String title, String priority) {
	    
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
