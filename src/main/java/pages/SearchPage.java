package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
	
	public WebDriver driver; 
	
	public SearchPage(WebDriver driver) {
		this.driver = driver; 
	}
	
	//form elements
	public By searchAction = By.cssSelector("button[data-content='search']"); 
	public By searchTitle = By.cssSelector("input[placeholder='Search']"); 
	public By searchActionSubmit = By.cssSelector("button.search_submit"); 
	public By searchImage = By.cssSelector("img[class='wp-post-image']"); 

	
	public void searchAction() {
		driver.findElement(searchAction).click();
	}
	
	public void searchTitle(String name) {
		driver.findElement(searchTitle).clear();
		driver.findElement(searchTitle).sendKeys(name);
	}
	
	public void searchActionSubmit() {
		driver.findElement(searchActionSubmit).click();
	}
	
	public boolean searchImage() {
		String src = driver.findElement(searchImage).getAttribute("src");
		return src.endsWith(".jpg"); 
	}

}
