package curs3;

import static org.testng.Assert.assertEquals;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class TemaCurs3 extends BaseTest {

	@Test
	public void findTheForrest() throws InterruptedException {

		List<WebElement> menuList = driver.findElements(By.cssSelector("li[class*='sc_tabs_title']"));

		for (WebElement menu : menuList) {
			menu.click();
			Thread.sleep(3000);
			WebElement theForestBook = driver.findElement(By.linkText("The forest"));
			assertEquals(theForestBook.isDisplayed(), true);

			if (menuList.lastIndexOf(menu) == menuList.size() - 1) {
				theForestBook.click();
				assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/the-forest/");
			}

		}

	}

}
