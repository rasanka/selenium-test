package com.olympic.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OlympicTestMain {

	private static final String URL = "https://shop.countdown.co.nz/";
	private static final String EMAIL = "dilini2007@gmail.com";
	private static final String PASSWORD = "dilini123";
	private WebDriver driver;
	private List<String> productList = new ArrayList<>();

	@BeforeTest
	public void invokeBrowser() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/libs/geckodriver");
		driver = new FirefoxDriver();// Launching fire fox browser
		driver.manage().window().maximize();// Maximizing fire fox window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		productList.addAll(Arrays.asList("Apples", "Bread", "Milk"));
	}

	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}

	@Test(priority = 1)
	public void loginUserTest() {
		driver.get(URL);// Launching count down url
		String loginXPath = "/html/body/div[2]/div[1]/div[2]/div/div/div/div[2]/ul/li[5]/a";
		driver.findElement(By.xpath(loginXPath)).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("Email")).sendKeys(EMAIL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("Password")).sendKeys(PASSWORD);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[3]/div[7]/div/div/div[3]/div/div[4]/div/form/input[4]")).click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		clearTroly();
	}

	public void clearTroly() {

		driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div[2]/div/div[1]/a")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div/div/div[2]/div/div[1]/a")).click();
		driver.findElement(
				By.xpath("/html/body/div[3]/div[7]/div/div/div[3]/div/div[4]/div/div[4]/div/div[1]/div[1]/a")).click();
	}

	@Test(priority = 2)
	public void searchShopFromListTest() {

		driver.findElement(By.id("search")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// User selects 'Shop from list' option
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/div/div[1]/div[1]/form/div/a/span")).click();

	}

	@Test(priority = 3)
	public void enterItemListTest() {

		// User enters list of items he wants to shop
		driver.findElement(By.xpath("/html/body/div[3]/div[7]/div/div/div[3]/div/div[4]/div/form/div[1]/div/textarea"))
				.clear();
		for (String product : productList) {
			driver.findElement(
					By.xpath("/html/body/div[3]/div[7]/div/div/div[3]/div/div[4]/div/form/div[1]/div/textarea"))
					.sendKeys(product + Keys.ENTER);
		}

	}

	@Test(priority = 4)
	public void findFromSearchResultTest() {

		// Click on find
		driver.findElement(By.xpath("/html/body/div[3]/div[7]/div/div/div[3]/div/div[4]/div/form/div[2]/input[2]"))
				.click();

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		// Click on page 2
		driver.findElement(
				By.xpath("/html/body/div[3]/div[7]/div/div/div[3]/div/div[4]/div/div[2]/div[1]/div[1]/div/ul/li[3]/a"))
				.click();

	}

	@Test(priority = 5)
	public void selectTheProductTest() {

		// Select the product
		driver.findElement(
				By.xpath("/html/body/div[3]/div[7]/div/div/div[3]/div/div[4]/div/div[2]/div[2]/div[1]/div[1]/div/a/h3"))
				.click();

	}

	@Test(priority = 6)
	public void addToTrolyTest() {
		// Add to troly
		driver.findElement(By.xpath(
				"/html/body/div[3]/div[7]/div/div/div[3]/div/div[4]/div[2]/div[3]/div[1]/div[6]/div[2]/div[2]/div[2]/form/button"))
				.click();

	}

	@Test(priority = 7)
	public void selectTheTrolyTest() {

		// Select the troly
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/div/div[2]/div/div[1]/a")).click();
	}

	@Test(priority = 8)
	public void clickViewAllTest() {

		// Click view all button
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div/div/div[2]/div/div[1]/a")).click();
	}

	@Test(priority = 9)
	public void saveTrolyTest() {

		// Click Save troly
		driver.findElement(
				By.xpath("/html/body/div[3]/div[7]/div/div/div[3]/div/div[4]/div/div[4]/div/div[1]/div[2]/a")).click();

		// Enter list name
		driver.findElement(By.xpath("//*[@id=\"listName\"]")).sendKeys("MyList");

		// Click Save
		driver.findElement(By.xpath("/html/body/div[3]/div[7]/div/div/div[3]/div/div[4]/div/div[3]/form/div/input[2]"))
				.click();

	}

}
