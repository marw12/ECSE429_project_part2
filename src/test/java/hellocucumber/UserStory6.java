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


public class UserStory6 {
	

    private String classId;
    private String className;
    private String todoId;
    
    
    @When("I remove a todo list from a class")
    public void i_remove_a_todo_list_from_a_class() {
    	classId = "1";
		todoId = "1";
		
		try {
			String request = "http://localhost:4567/projects/" + classId + "/tasks/" + todoId;
			URL url = new URL(request);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("DELETE");
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

    @Then("I can view todo list is not linked to the class")
    public void i_can_view_todo_list_is_not_linked_to_the_class() {
    	classId = "1";
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
            
            System.out.println(inline);

            //Close the scanner
            scanner.close();
	        
		} catch (Exception e) {
		}
    }

    @When("I remove a todo list from a new class")
    public void i_remove_a_todo_list_from_a_new_class() {
    	//create new class
    	className = "Physics";

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

    		String jsonInputString = "{\"id\":\"2\"}";

    		try(OutputStream os = con.getOutputStream()){
    			byte[] input = jsonInputString.getBytes("utf-8");
    			os.write(input, 0, input.length);			
    		}

    		int code = con.getResponseCode();
    		assertEquals(code, 201);

    	} catch (Exception e) {
    	}	
    	
    	//remove todo from new class
    	todoId = "2";
    	try {
			String request = "http://localhost:4567/projects/" + classId + "/tasks/" + todoId;
			URL url = new URL(request);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("DELETE");
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
    
    @Then("I can view todo list is not linked to the new class")
    public void i_can_view_todo_list_is_not_linked_to_the_new_class() {
    	classId = "2";
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
	        
		} catch (Exception e) {
    		e.printStackTrace();
		}
    }


	
    @When("I remove a todo list from a nonexistent class")
    public void i_remove_a_todo_list_from_a_nonexistent_class() {
    	classId = "699";
    	todoId = "1";

    	try {
    		String request = "http://localhost:4567/projects/" + classId + "/tasks/" + todoId;
    		URL url = new URL (request);
    		HttpURLConnection con = (HttpURLConnection)url.openConnection();
    		con.setRequestMethod("DELETE");
    		con.setRequestProperty("Content-Type", "application/json; utf-8");
    		con.setRequestProperty("Accept", "application/json");
    		con.setDoOutput(true);
    		
    		int code = con.getResponseCode();
    		assertEquals(code, 400);

    	} catch (Exception e) {
    		e.printStackTrace();
    	}	
    }

	@Then("I get an error for removing")
	public void i_get_an_error_for_removing() {
		String task = "699";
		
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
	        
		} catch (Exception e) {
			
		}
	}

	@When("I remove a {string} list from a {string}")
	public void i_remove_a_list_from_a(String taskId, String classId) {
		
		Runtime rt = Runtime.getRuntime();
		
    	try {
			Process p3 = rt.exec("curl --request GET http://localhost:4567/shutdown");
			Process p1 = rt.exec("java -jar runTodoManagerRestAPI-1.5.5.jar");
			Process p2 = Runtime.getRuntime().exec("sleep 5s");
			
		} catch (Exception e) {
			
		}
		
		try {
			String request = "http://localhost:4567/projects/" + classId + "/tasks/" + todoId;
			URL url = new URL(request);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("DELETE");
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

	
	@Then("I can view todo list is not linked to the {string}")
	public void i_can_view_todo_list_is_not_linked_to_the(String classId) {
		
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
            
            System.out.println(inline);

            //Close the scanner
            scanner.close();
	        
		} catch (Exception e) {
			
		}
	}



	
}