package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingleAuthorPage {

	public WebDriver driver;

	public SingleAuthorPage(WebDriver driver) {
		this.driver = driver;
	}

	public By skillProcents = By.xpath(
			"//div[@class='sc_skills_label'][contains(text(),'Drama')]/parent::div[@class='sc_skills_info']/following-sibling::div[contains(@class,'sc_skills_item')][1]/div[@class='sc_skills_count']/div[@class='sc_skills_total']");

	public void pageWaitTitle() {
		WebElement dramaProcents = driver.findElement(skillProcents);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(dramaProcents, "95%"));
	}

	public String findProcents(String searchCategory) {
		return driver.findElement(By.xpath("//div[@class='sc_skills_label'][contains(text(),'" + searchCategory
				+ "')]/parent::div[@class='sc_skills_info']/following-sibling::div[contains(@class,'sc_skills_item')][1]/div[@class='sc_skills_count']/div[@class='sc_skills_total']"))
				.getText();
	}

}
