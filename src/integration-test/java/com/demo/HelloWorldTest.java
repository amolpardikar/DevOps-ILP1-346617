/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :
 *
 * File Name       : HelloWorldTest.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :Mar 13, 2017
 * 
 */
package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;
import static org.junit.Assert.*;

import org.junit.experimental.categories.Category;
import com.demo.IntegrationTest;

@Category(IntegrationTest.class)
public class HelloWorldTest {

	static WebDriver driver;

	@BeforeClass
	public static void setup() {
		driver = new ChromeDriver();
		// new FirefoxDriver();
	}

	@AfterClass
	public static void cleanUp() {
		driver.quit();
	}

	@Test
	public void shouldSayHelloWorld() {
		driver.get("http://localhost:8080/MyWebUnInD");
		WebElement we = driver.findElement(By.xpath("html/body/h1[1]"));
		if (we.getText().contains("Welcome to Simple WebApp Demo...Login with patel/patel")) {
			System.out.println("### Home Page Successful ###");
		} else {
			System.out.println("Home Page Unsuccessful");
		}
		assertEquals("Welcome to Simple WebApp Demo...Login with patel/patel", we.getText());
	}
}