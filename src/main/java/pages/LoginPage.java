package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By usernameField = By.id("log");
	public By passwordField = By.id("password");
	public By submitButton = By.cssSelector("input[class='submit_button']");
	public By settingsLink = By.xpath("//a[contains(text(), 'Settings')]"); 
	public By userName = By.xpath("//span[@class='user_name']");
	public By addressesLink = By.xpath("//a[contains(text(), 'Addresses')]"); 
	public By shippingAddressEdit = By.xpath("//h3[contains(text(), 'Shipping address')]/following-sibling::a[contains(text(), 'Edit')]"); 

	public By logoutButton = By.cssSelector("li[class='menu_user_logout']"); 
	
	//driver.findEelement(By.id("log"))
	//driver.findElement(usernameField)
	
	public void logoutFromApp() {
		WebDriverWait wait = new WebDriverWait(driver, 10); 
		wait.until(ExpectedConditions.elementToBeClickable(logoutButton)); 
		driver.findElement(logoutButton); 
	}
			
	public void setUsername(String user) {
		driver.findElement(usernameField).sendKeys(user);
	}
	
	public void setPassword(String pass) {
		driver.findElement(passwordField).sendKeys(pass);
	}
	
	public void clickSubmit() {
		driver.findElement(submitButton).click();
	}
	
	public void clickUserName() {
		driver.findElement(userName).click();
	}	
	
	public void clickSettings() {
		driver.findElement(settingsLink).click();
	}	
	
	public void clickAddresses() {
		driver.findElement(addressesLink).click();
	}
	
	public void clickEditShippingAddress() {
		driver.findElement(shippingAddressEdit).click();
	}
	
	public void loginInApp(String user, String pass) {
		driver.findElement(usernameField).sendKeys(user);
		driver.findElement(passwordField).sendKeys(pass);
		driver.findElement(submitButton).click();

	}
	
}
