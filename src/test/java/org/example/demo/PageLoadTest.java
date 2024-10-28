package org.example.demo;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class PageLoadTest extends TestBase {
		
		@Test
		public void shadowDOMTest() throws InterruptedException {
				getDriver().manage().window().maximize();
				getDriver().get(
						"https://www.lambdatest.com/selenium-playground/");
				Thread.sleep(10000);
				// Find and interact with elements on the page
				getDriver().findElement(By.xpath("//a[contains(text(),'Shadow DOM')]")).click();
				
				// Assert that the search results page is displayed
				String actualTitle = getDriver().getTitle();
				String expectedTitle = "Selenium Playground | LambdaTest";
				Thread.sleep(1000);
				assert actualTitle.contains(expectedTitle);
		}
		
		@Test
		public void nestedFramesTest() throws InterruptedException {
				getDriver().manage().window().maximize();
				getDriver().get(
						"https://www.lambdatest.com/selenium-playground/");
				Thread.sleep(10000);
				// Find and interact with elements on the page
				getDriver().findElement(By.xpath("//a[contains(text(),'Nested Frames')]")).click();
				
				// Assert that the search results page is displayed
				String actualTitle = getDriver().getTitle();
				String expectedTitle = "Selenium Playground | LambdaTest";
				Thread.sleep(1000);
				assert actualTitle.contains(expectedTitle);
		}
		
}
