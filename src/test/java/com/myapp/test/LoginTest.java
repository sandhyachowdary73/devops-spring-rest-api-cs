package com.myapp.test;


import org.junit.jupiter.api.Test;
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
	Username.sendKeys("username");
	password.sendKeys("$password");
	login.click();
	
	
	
	}

	

}