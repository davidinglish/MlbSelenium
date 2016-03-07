//****************************
//David Inglish
//MLB Assessment 3/5/2016
//Flow 2
//****************************
//- Navigate to ebay.com page
//- Search for "Electric Guitar"
//- Open first result and output item price (to console)
//****************************


package com.mlb.Assesment.MlbProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class FlowTwoPrice {
	
	//WebDriver Instance
	WebDriver driver;
	//Driver URL
	String driverUrl = "http://ebay.com";
		
	//Search Word
	String searchWord = "Electric Guitar";
	
	@BeforeTest
	public void setUp() throws Exception {
		
		//Getting Price of Item on Ebay
		System.out.println("T2 Starting Getting Price of Item on Ebay Test");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();	
	}
	
	@Test
	public void price(){
		
		//Navigation - to ebay.com page
		System.out.println("T2 *Navigation - to ebay.com page*");
		driver.get(driverUrl);
		
		//Data Entry - Electric Guitar, Search Field
		System.out.println("T2  Data Entry - Electric Guitar, Search Field");
		driver.findElement(By.id("gh-ac")).sendKeys(searchWord);
		
		//CTA -Press Search Btn
		System.out.println("T2  CTA -Press Search Btn");
		driver.findElement(By.id("gh-btn")).click();
	
		//Open first result
		System.out.println("T2 *Open first result*");
		List<WebElement> list_price=driver.findElements(By.xpath("//ul[@id='ListViewInner']/li"));
		
		//Get size of array
		int size=list_price.size();
		
		//Compare position vars
		String part1="//ul[@id='ListViewInner']/li[";
		String part2="]/ul[1]/li[1]/span";

		System.out.println("T2 Price:");
		
		//Transverse array for wanted position
		for(int i=1;i<size;i++){
			
			if(i==1){
			
				WebElement item_price=driver.findElement(By.xpath(part1+i+part2));
				System.out.println("T2 " + item_price.getText());
			
			}
		}
		
		
	}
	
	@AfterTest
	public void tearDown(){
		System.out.println("T2 CLose Browser");
		driver.quit();
	}

}
