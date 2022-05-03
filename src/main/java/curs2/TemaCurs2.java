package curs2;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class TemaCurs2 extends BaseTest {

	@Test()
	public void findElementsExample() throws InterruptedException {

		WebElement loginButton = driver.findElement(By.cssSelector(".menu_user_login"));
		assertEquals(loginButton.isDisplayed(), true);

		WebElement loginField = driver.findElement(By.id("log"));
		assertEquals(loginField.isDisplayed(), false);

		WebElement passwordField = driver.findElement(By.id("password"));
		assertEquals(passwordField.isDisplayed(), false);

		loginButton.click();

		Thread.sleep(4000);

		loginField = driver.findElement(By.id("log"));
		assertEquals(loginField.isDisplayed(), true);

		passwordField = driver.findElement(By.id("password"));
		assertEquals(passwordField.isDisplayed(), true);

	}

}
