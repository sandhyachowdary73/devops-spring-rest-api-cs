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
	public void login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\softwares\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	
	driver.get("http://127.0.0.1:8899");
	WebElement Username=driver.findElement(By.name("username"));
	WebElement password=driver.findElement(By.name("password"));
	WebElement login=driver.findElement(By.xpath("//button[text()='Log In']"));
	Username.sendKeys("Admin12345");
	password.sendKeys("Test12345");
	Thread.sleep(500);
	login.submit();
	//String actualUrl="http://127.0.0.1:8888";
//	String expectedUrl= driver.getCurrentUrl();
	//assertEquals(expectedUrl,actualUrl);
	
	 String expectedTitle = "Log in with your account";
   //  String actualTitle = driver.getTitle();
   //  assertEquals(actualTitle, expectedTitle);
	
	//Validate the actual page title with expected page title using assert equals method
	//System.out.println("Assert equals method validation");
	//assertEquals(expectedTitle, driver.getTitle());
	
	

	// Page title validation using assert false method
	System.out.println("Assert false method validation");
	assertFalse("Title does match", expectedTitle.equals(driver.getTitle()));
	
	
	

	
	
	}

	private void assertFalse(String string, boolean equals) {
		// TODO Auto-generated method stub
		
	}

}