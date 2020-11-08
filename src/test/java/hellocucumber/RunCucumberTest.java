package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

class RunTest {
    static String isItFriday(String today) {
        return "Nope";
    }
    
    static String get_task() {
    	return "2";     
    }
    
    static String get_priority() {
    	return "HIGH";
    }
}

