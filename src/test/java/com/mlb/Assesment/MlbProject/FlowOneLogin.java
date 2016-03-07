//****************************
//David Inglish
//MLB Assessment 3/5/2016
//Flow 1
//****************************
//- Create Gmail test account
//- Navigate to gmail.com page
//- Login using valid credentials
//- Verify success login by user profile icon in top right corner
//****************************


package com.mlb.Assesment.MlbProject;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class FlowOneLogin {
		
	//WebDriver Instance 
	WebDriver driver;
	//Driver URL
	String driverUrl ="http://google.com";
		
	//Dynamic Successful Login Credentials Vars
	String testMail = "autokoufax@gmail.com";
	String testPassword = "Dodgers32";
	//Dynamic Successful Login Credentials Vars
	String testMailFail = "autokoufax999aaafail@gmail.com";
	String testPasswordFail = "passwordFail";
	//Logged in Image Name for Verification
	String expectedTitle = "autokoufax@gmail.com";
	String actualTitle = "";
	//Negative Test Error MSG Vars
	String passWordError = "";
	
	@BeforeTest
	public void setUp() throws Exception {
		
		//Logging into Google
		System.out.println("T1 Starting Logging into Google Test");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();	
	}
	
	@Test
	public void Login(){
		
		//Navigation - to gmail.com page
		System.out.println("T1 *Navigation - to gmail.com page*");
		driver.get(driverUrl);
		
		//CTA - Pressing Login Btn
		System.out.println("T1  CTA - Pressing Login Btn");
		driver.findElement(By.id("gb_70")).click();
		
		//Login using valid credentials
		System.out.println("T1 *Login using valid credentials*");
		System.out.println("T1  Data Entry - User Email");
		driver.findElement(By.id("Email")).sendKeys(testMail);
		
		// Transversal -From User Email to User Passwrod
		System.out.println("T1  Transversal -From User Email to User Passwrod");
		driver.findElement(By.id("next")).click();
		
		//Timer - Waiting for Password Text Field to Load Wait 10ms
		System.out.println("T1  Timer - Waiting for Password Text Field to Load Wait 10");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Data Entry - User Password
		System.out.println("T1  Data Entry - User Password");
		driver.findElement(By.id("Passwd")).sendKeys(testPassword);
		
		//CTA - Pressing Credential Sign In Btn
		System.out.println("T1  CTA - Pressing Credential Sign In Btn");
		driver.findElement(By.id("signIn")).click();
		
		//Verify success login by user profile icon in top right corner
		System.out.println("T1 *Verify success login by user profile icon in top right corner*");
		actualTitle = driver.findElement(By.xpath("//div[@id='gbw']/div/div/div[2]/div[4]/div[1]/a")).getAttribute("title");
		
		//check if expected account name matches what account name is showing
		if (actualTitle.contains(expectedTitle))
		{
			System.out.println("T1 ************** Test Successful - User Logged In **************");	
			
		}else{
			
			System.out.println("T1 @@@@@@@@@@@@@@@ Test Failed - User Not Logged In @@@@@@@@@@@@@@@@@");
			
		}
				
	}

	@Test
	public void IncorectUsername(){
		
		//Navigation - to gmail.com page
		System.out.println("T1N1 *Navigation - to gmail.com page*");
		driver.get(driverUrl);
		
		//CTA - Pressing Login Btn
		System.out.println("T1N1  CTA - Pressing Login Btn");
		driver.findElement(By.id("gb_70")).click();
		
		//Login using Wrong Username 
		System.out.println("T1N1 *Login using Invalid Username*");
		System.out.println("T1N1  Data Entry - User Email");
		driver.findElement(By.id("Email")).sendKeys(testMailFail);
		
		// Transversal -From User Email to User Passwrod
		System.out.println("T1N1  Transversal -From User Email to User Passwrod");
		driver.findElement(By.id("next")).click();
		
		//Timer - Waiting for Password Text Field to Load Wait 10ms
		System.out.println("T1N1  Timer - Waiting for Password Text Field to Load Wait 10");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//Check if login error message exist		
		if (driver.findElements(By.id("errormsg_0_Email")).size() != 0) {  
             
            System.out.println("T1N1 **Pass** - User Name was Incorrect");     
        } else{
        	
        	System.out.println("T1N1 **Fail** - Login was Succesfull"); 
        }
			
		
	}
	
	@Test
	public void IncorectPassword(){
		
		//Navigation - to gmail.com page
		System.out.println("T1N1 *Navigation - to gmail.com page*");
		driver.get(driverUrl);
		
		//CTA - Pressing Login Btn
		System.out.println("T1N2  CTA - Pressing Login Btn");
		driver.findElement(By.id("gb_70")).click();
		
		//Login using Wrong Username 
		System.out.println("T1N2 *Login using Invalid Username*");
		System.out.println("T1N2  Data Entry - User Email");
		driver.findElement(By.id("Email")).sendKeys(testMail);
		
		// Transversal -From User Email to User Passwrod
		System.out.println("T1N1  Transversal -From User Email to User Passwrod");
		driver.findElement(By.id("next")).click();
		
		//Timer - Waiting for Password Text Field to Load Wait 10ms
		System.out.println("T1N2  Timer - Waiting for Password Text Field to Load Wait 10");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Data Entry - User Password
		System.out.println("T1N2  Data Entry - User Password");
		driver.findElement(By.id("Passwd")).sendKeys(testPasswordFail);
				
		//CTA - Pressing Credential Sign In Btn
		System.out.println("T1N2  CTA - Pressing Credential Sign In Btn");
		driver.findElement(By.id("signIn")).click();
		
		if (driver.findElements(By.id("errormsg_0_Passwd")).size() != 0) {  
            
            System.out.println("T1N2 Pass - Password Failed");     
        } else{
        	
        	System.out.println("T1N2 Fail - Password Worked"); 
        }
		
	}
	
	
	@AfterTest
	public void tearDown(){
		System.out.println("T1 CLose Browser");
		driver.quit();
	}
	
         
}
