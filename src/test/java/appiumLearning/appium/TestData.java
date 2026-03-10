package appiumLearning.appium;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name = "phoneData")
	
	public Object[][] phoneData() {
		
	    return new Object[][]{
	        {"", false, "Please enter the username and password."},
	        {"12345",false, "Invalid credentials"},
	        {"1234567890",false, "Invalid credentials"},
	        {"abcdef", false, "Invalid credentials"},
	        {"9876543210",false, "Invalid credentials"},
	        {"demo",true, "login sucessfull!"}
	    };
	}

}
