package com.ebees.test;
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


public class EbeesCritical {
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

	// Test
	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}

	@Test(priority = 1)
	public void loginUserTest() throws InterruptedException {
		driver.get(URL);// Launching count down url
		//String loginXPath = "/html/body/div[2]/div[1]/div[2]/div/div/div/div[2]/ul/li[5]/a";
		String loginXPath = "//a[@href='/shop/securelogin']";
		driver.findElement(By.xpath(loginXPath)).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("Email")).sendKeys(EMAIL);
		Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("Password")).sendKeys(PASSWORD);

		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		//driver.findElement(By.xpath("/html/body/div[3]/div[7]/div/div/div[3]/div/div[4]/div/form/input[4]")).click();
		driver.findElement(By.xpath("//input[@value ='Login']")).click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		clearTroly();
	}

	public void clearTroly() throws InterruptedException {
		//user clicks on Trolley image
		//driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div[2]/div/div[1]/a")).click();
		driver.findElement(By.xpath("//img[@src ='/Images/MOR/SearchBar/icon-cart-green.png']")).click();
		Thread.sleep(3000);
		//user clicks on "view all" button
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div/div/div[2]/div/div[1]/a")).click();
		//driver.findElement(By.xpath("//a[@href='/shop/viewtrolley']")).click();
		Thread.sleep(3000);
		driver.findElement(
		By.xpath("/html/body/div[3]/div[7]/div/div/div[3]/div/div[4]/div/div[4]/div/div[1]/div[1]/a")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void searchShopFromListTest() throws InterruptedException {

		driver.findElement(By.id("search")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// User selects 'Shop from list' option
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/div/div[1]/div[1]/form/div/a/span")).click();
		Thread.sleep(3000);

	}

	@Test(priority = 3)
	public void enterItemListTest() throws InterruptedException {

		// User enters list of items he wants to shop
		driver.findElement(By.xpath("/html/body/div[3]/div[7]/div/div/div[3]/div/div[4]/div/form/div[1]/div/textarea"))
				.clear();
		Thread.sleep(3000);
		for (String product : productList) {
			driver.findElement(
					By.xpath("/html/body/div[3]/div[7]/div/div/div[3]/div/div[4]/div/form/div[1]/div/textarea"))
					.sendKeys(product + Keys.ENTER);
		}

	}

	@Test(priority = 4)
	public void findFromSearchResultTest() throws InterruptedException {

		// Click on find
		driver.findElement(By.xpath("/html/body/div[3]/div[7]/div/div/div[3]/div/div[4]/div/form/div[2]/input[2]"))
				.click();
		Thread.sleep(3000);

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		// Click on page 2
		driver.findElement(
				By.xpath("/html/body/div[3]/div[7]/div/div/div[3]/div/div[4]/div/div[2]/div[1]/div[1]/div/ul/li[3]/a"))
				.click();
		Thread.sleep(3000);

	}

	@Test(priority = 5)
	public void selectTheProductTest() throws InterruptedException {

		// Select the product
		driver.findElement(
				By.xpath("/html/body/div[3]/div[7]/div/div/div[3]/div/div[4]/div/div[2]/div[2]/div[1]/div[1]/div/a/h3"))
				.click();
		Thread.sleep(3000);

	}

	@Test(priority = 6)
	public void addToTrolyTest() throws InterruptedException {
		// Add to troly
		driver.findElement(By.xpath(
				"/html/body/div[3]/div[7]/div/div/div[3]/div/div[4]/div[2]/div[3]/div[1]/div[6]/div[2]/div[2]/div[2]/form/button"))
				.click();
		Thread.sleep(3000);

	}

	@Test(priority = 7)
	public void selectTheTrolyTest() throws InterruptedException {

		// Select the troly
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/div/div[2]/div/div[1]/a")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 8)
	public void clickViewAllTest() throws InterruptedException {

		// Click view all button
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div/div/div[2]/div/div[1]/a")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 9)
	public void saveTrolyTest() throws InterruptedException {

		// Click Save troly
		driver.findElement(
				By.xpath("/html/body/div[3]/div[7]/div/div/div[3]/div/div[4]/div/div[4]/div/div[1]/div[2]/a")).click();
		Thread.sleep(3000);
		// Enter list name
		driver.findElement(By.xpath("//*[@id=\"listName\"]")).sendKeys("MyList");

		// Click Save
		driver.findElement(By.xpath("/html/body/div[3]/div[7]/div/div/div[3]/div/div[4]/div/div[3]/form/div/input[2]"))
				.click();

	}

}


