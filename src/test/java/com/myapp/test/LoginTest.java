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
	WebElement Username=driver.findElement(By.id("username"));
	WebElement password=driver.findElement(By.id("password"));
	WebElement login=driver.findElement(By.name("commit"));
	Username.sendKeys("Admin1234");
	password.sendKeys("Test12345");
	login.click();
	
	
	 String expectedTitle = "";
     String actualTitle = driver.getTitle();
     assertEquals(actualTitle, expectedTitle);
	
		
	
	}

	private void assertFalse(String string, boolean equals) {
		// TODO Auto-generated method stub
		
	}

}