package org.example.demo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ExampleTest extends TestBase {
		
		@Test
		public void getStartTest() throws InterruptedException {
				getDriver().manage().window().maximize();
				getDriver().get(
						"https://www.lambdatest.com/selenium-playground/"); // Replace with your desired URL
				Thread.sleep(10000);
				// Find and interact with elements on the page
				getDriver().findElement(By.xpath("//a[contains(text(),'Get Started Free')]")).click();
				
				// Assert that the search results page is displayed
				String actualTitle = getDriver().getTitle();
				String expectedTitle = "Sign up for free | Cross Browser Testing Tool | LambdaTest"; // Replace with the expected title
				Thread.sleep(1000);
				assert actualTitle.contains(expectedTitle);
		}
		
		@Test
		public void bookDemTest() throws InterruptedException {
				getDriver().manage().window().maximize();
				getDriver().get(
						"https://www.lambdatest.com/selenium-playground/");
				Thread.sleep(10000);
				// Find and interact with elements on the page
				getDriver().findElement(By.xpath("//button[contains(text(),'Book a Demo')]")).click();
				
				// Assert that the search results page is displayed
				String actualTitle = getDriver().getTitle();
				Thread.sleep(1000);
				String expectedTitle = "Selenium Grid Online | Run Selenium Test On Cloud";
				assert actualTitle.contains(expectedTitle);
		}
		
		@Test
		public void hoverDemoTest() throws InterruptedException {
				getDriver().manage().window().maximize();
				getDriver().get(
						"https://www.lambdatest.com/selenium-playground/");
				Thread.sleep(10000);
				// Find and interact with elements on the page
				getDriver().findElement(By.xpath("//a[contains(text(),'Hover Demo')]")).click();
				
				// Assert that the search results page is displayed
				String actualTitle = getDriver().getTitle();
				String expectedTitle = "Selenium Playground | LambdaTest";
				Thread.sleep(1000);
				assert actualTitle.contains(expectedTitle);
		}
		
}
