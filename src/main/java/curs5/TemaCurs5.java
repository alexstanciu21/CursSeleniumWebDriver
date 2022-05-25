package curs5;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class TemaCurs5 extends BaseTest {

	@Test
	public void reviewBook() throws InterruptedException {

		WebElement openBook = driver.findElement(By.xpath("//a[@href='life-in-the-garden']"));
		openBook.click();

		WebElement accessReviews = driver
				.findElement(By.xpath("//li[@id='tab-title-reviews']/a[contains(text(), 'Review')]"));
		accessReviews.click();

		WebElement saveCheckbox = driver.findElement(By.xpath("//input[@id='wp-comment-cookies-consent']"));
		assertFalse(saveCheckbox.isSelected());

		Thread.sleep(2000);

		WebElement reviewStar = driver.findElement(By.xpath("//a[@class='star-3']"));
		reviewStar.click();

		WebElement commentReview = driver.findElement(By.xpath("//textarea[@id='comment']"));
		String review = "Text review comment " + Math.random();
		commentReview.sendKeys(review);

		WebElement reviewName = driver.findElement(By.xpath("//input[@name='author']"));
		reviewName.sendKeys("TestUser");

		WebElement reviewEmail = driver.findElement(By.xpath("//input[@name='email']"));
		reviewEmail.sendKeys("TestUser@testEmail.com");

		saveCheckbox.click();
		assertTrue(saveCheckbox.isSelected());

		WebElement submitReview = driver.findElement(By.xpath("//input[@class='submit']"));
		submitReview.click();

		WebElement reviewDescription = driver.findElement(By.xpath("//div[@class='description']"));

		if (reviewDescription.getText().equals(review)) {
			WebElement reviewApproval = driver
					.findElement(By.xpath("//em[@class='woocommerce-review__awaiting-approval']"));
			assertEquals(reviewApproval.getText(), "Your review is awaiting approval");
		}

	}

}
