//package tests;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.*;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class SauceDemoLoginTest {
//
//	WebDriver driver;
//
//	@BeforeMethod
//	public void setup() {
//
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//
//		driver.manage().window().maximize();
//		driver.get("https://www.saucedemo.com/");
//	}
//
//	@Test
//	public void validLoginTest() {
//
//		driver.findElement(By.id("user-name")).sendKeys("standard_user");
//
//		driver.findElement(By.id("password")).sendKeys("secret_sauce");
//
//		driver.findElement(By.id("login-button")).click();
//
//		boolean inventoryPage = driver.getCurrentUrl().contains("inventory");
//
//		Assert.assertTrue(inventoryPage);
//	}
//
//	@Test
//	public void invalidLoginTest() {
//
//		driver.findElement(By.id("user-name")).sendKeys("invalid");
//
//		driver.findElement(By.id("password")).sendKeys("invalid");
//
//		driver.findElement(By.id("login-button")).click();
//
//		boolean errorDisplayed = driver.findElement(By.tagName("h3")).isDisplayed();
//
//		Assert.assertTrue(errorDisplayed);
//	}
//
//	@AfterMethod
//	public void teardown() {
//
//		driver.quit();
//
//	}
//
//}

// ----------------------------------------------  AWS Related Code ------------------------------------

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceDemoLoginTest {

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");

		driver = new ChromeDriver(options);

		driver.get("https://www.saucedemo.com/");
	}

	@Test
	public void validLoginTest() {

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
	}

	@Test
	public void invalidLoginTest() {

		driver.findElement(By.id("user-name")).sendKeys("locked_user");
		driver.findElement(By.id("password")).sendKeys("wrong");
		driver.findElement(By.id("login-button")).click();

		Assert.assertTrue(driver.getPageSource().contains("Epic sadface"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
