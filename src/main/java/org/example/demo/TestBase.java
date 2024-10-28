package org.example.demo;

import static org.example.demo.Constants.CONNECTION_TIMEOUT;
import static org.example.demo.Constants.HUB_URL;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.http.ClientConfig;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class TestBase {
		
		
		private static ThreadLocal<RemoteWebDriver> threadLocalDriver = new ThreadLocal<>();
		
		
		@BeforeMethod(alwaysRun = true)
		public void setDriver() throws MalformedURLException {
				System.out.println("Test Running " + this.getClass().toString());
				ChromeOptions options = new ChromeOptions();
				options.setCapability("networkname:applicationName", "web");
				options.setCapability("platformName", "linux");
//				options.addArguments("--headless"); // Run Chrome in headless mode
				options.addArguments("--disable-gpu");
				options.addArguments("--no-sandbox");
//				threadLocalDriver.set(new RemoteWebDriver(new URL(HUB_URL), options));
//				threadLocalDriver.set(new ChromeDriver());
				threadLocalDriver.set((RemoteWebDriver) RemoteWebDriver.builder().address(HUB_URL).oneOf(options).config(
				ClientConfig.defaultConfig().readTimeout(Duration.ofSeconds(CONNECTION_TIMEOUT))).build());
				
		}
		
		public WebDriver getDriver() {
				return threadLocalDriver.get();
		}
		
		@AfterMethod(alwaysRun = true)
		public void closeBrowser() {
				System.out.println("Browser closed by Thread : " + Thread.currentThread().getId()
						+ " and Closing driver reference is :" + getDriver());
				threadLocalDriver.get().quit();
				threadLocalDriver.remove();
		}
		
}
