package com.myapp.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class LoginTest {
	
	@Test
	public void login() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\drivers\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	
	driver.get("http://127.0.0.1:8899");
	WebElement Username=driver.findElement(By.id("Username"));
	WebElement password=driver.findElement(By.id("userpassword"));
	WebElement login=driver.findElement(By.name("commit"));
	Username.sendKeys("your_username");
	password.sendKeys("your_password");
	login.click();
	String actualUrl="http://127.0.0.1:8899";
	String expectedUrl= driver.getCurrentUrl();
	assertEquals(expectedUrl,actualUrl);
	
	 String expectedTitle = "Welcome";
     String actualTitle = driver.getTitle();
     assertEquals(actualTitle, expectedTitle);
	
	//Validate the actual page title with expected page title using assert equals method
	System.out.println("Assert equals method validation");
	assertEquals(expectedTitle, driver.getTitle());
	
	

	// Page title validation using assert false method
	System.out.println("Assert false method validation");
	assertFalse("Title does match", expectedTitle.equals(driver.getTitle()));
	
	
	

	// Validation that Alert comes with WELCOME as text on it
			Alert alert=driver.switchTo().alert();
			assertEquals("WELCOME", alert.getText());
			
			// Validation username and password is wrong that Alert comes with your username and 
		    // password is invalid as text on it
			
			assertEquals("UserName And Password Is Invalid", alert.getText());
			alert.accept();
	
	}

	private void assertFalse(String string, boolean equals) {
		// TODO Auto-generated method stub
		
	}

}
