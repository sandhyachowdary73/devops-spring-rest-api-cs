package com.myapp.registration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class RegistrationTestTest {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1:8899");

		 WebElement email = driver.findElement(By.id("email"));
		 email.sendKeys("test6.test@gmail.com");
		 
		 WebElement phone = driver.findElement(By.id("phoneNumber"));
		 phone.sendKeys("9876543210");
		 
		 WebElement username = driver.findElement(By.id("username"));
		 username.sendKeys("Abce12324@");

		 WebElement password = driver.findElement(By.id("password"));
		 password.sendKeys("Test@12345");
		 

		 WebElement confirmpassword = driver.findElement(By.id("passwordconfirm"));
		 confirmpassword.sendKeys("Test@12345");

		 WebElement signUp = driver.findElement(By.xpath("//button[contains(@class,'btn sign-up-btn-2 btn-block')]"));
		 signUp.click();

		 String expectedURL = "http://127.0.0.1:8899";
		 String actualURL = driver.getCurrentUrl();
		 assertEquals(actualURL, expectedURL);
		 
		 String expectedTitle = "Welcome";
	        String actualTitle = driver.getTitle();
	        assertEquals(actualTitle, expectedTitle);
	        

		 }
	

}
