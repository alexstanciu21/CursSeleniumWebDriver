package curs4;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BaseTest;

public class TemaCurs4 extends BaseTest {

	@Test
	public void searchBook() throws InterruptedException {

		// click the search button
		WebElement searchAction = driver.findElement(By.cssSelector("button[data-content='search']"));
		searchAction.click();

		Thread.sleep(3000);

		// enter the search term and take the search action
		WebElement searchTitle = driver.findElement(By.cssSelector("input[placeholder='Search']"));
		searchTitle.sendKeys("The story about me");
		
		Thread.sleep(3000);

		WebElement searchActionSubmit = driver.findElement(By.cssSelector("button.search_submit"));
		searchActionSubmit.click();		
		
		Thread.sleep(3000);
		
		// click on load more
		WebElement loadMore = driver.findElement(By.cssSelector("#viewmore"));
		loadMore.click();

		Thread.sleep(3000);

		// click on the book
		WebElement bookTitle = driver.findElement(By.cssSelector("div[data-title=\"The story about me\"]"));
		bookTitle.click();

		// verificam ca url-ul este corect
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/the-story-about-me/");

		// apasam add to cart
		WebElement addToCart = driver.findElement(By.cssSelector("button[name='add-to-cart']"));
		addToCart.click();

		// verificam ca ne apare textul ca a fost adaugat in cos
		WebElement addToCartAlert = driver.findElement(By.cssSelector(".woocommerce-message"));
		assertTrue(addToCartAlert.getText().contains("“The story about me” has been added to your cart."));

		// apasam pe view cart
		WebElement viewCart = driver.findElement(By.cssSelector("div.woocommerce-message .wc-forward"));
		viewCart.click();

		// verificam ca url-ul este corect
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/cart/");

	}

	@Test
	public void updateCart() throws InterruptedException {

		// incrementam cantitatea din cart la 2
		WebElement incrementValue = driver.findElement(By.cssSelector(".q_inc"));
		incrementValue.click();

		// actualizam cart-ul
		WebElement updateCart = driver.findElement(By.cssSelector("button[name='update_cart']"));
		updateCart.click();

		Thread.sleep(3000);

		// verificam mesajul
		WebElement alertCart = driver.findElement(By.cssSelector(".woocommerce-message"));
		assertTrue(alertCart.getText().contains("Cart updated."));
		
		// luam actiunea de checkout
		WebElement proceedCheckout = driver.findElement(By.cssSelector(".checkout-button"));
		proceedCheckout.click();

		Thread.sleep(3000);
		
		// verificam ca url-ul este corect
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/checkout/");

		// verificam daca ne apare textul Biling details si Aditional information
		WebElement billingDetails = driver.findElement(By.cssSelector("div.woocommerce-billing-fields h3"));
		WebElement additionalInformation = driver.findElement(By.cssSelector("div.woocommerce-additional-fields h3"));

		assertTrue(billingDetails.getText().contains("Billing details"));
		assertTrue(additionalInformation.getText().contains("Additional information"));

	}

}
