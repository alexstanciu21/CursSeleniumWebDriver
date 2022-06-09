package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShippingAddressPage {
	
	public WebDriver driver;
	public WebElement dropdown; 
	public Select selectDropdown; 
	
		
	public ShippingAddressPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By orderDropDownCountry = By.name("shipping_country"); 
	public By orderDropDownProvince = By.name("shipping_state"); 

	
	public void filterByIndex(int index) {
		dropdown = driver.findElement(orderDropDownCountry); 
		selectDropdown = new Select(dropdown); 
		selectDropdown.selectByIndex(index);	
	}
	
	public void filterByValue(String value) {
		dropdown = driver.findElement(orderDropDownProvince); 
		selectDropdown = new Select(dropdown); 
		selectDropdown.selectByValue(value); 	
	}
	
	public String getCurrentSelectedOptionCountry() {
		dropdown = driver.findElement(orderDropDownCountry); 
		selectDropdown = new Select(dropdown); 
		return selectDropdown.getFirstSelectedOption().getText(); 
	}

	public String getCurrentSelectedOptionProvince() {
		dropdown = driver.findElement(orderDropDownProvince); 
		selectDropdown = new Select(dropdown); 
		return selectDropdown.getFirstSelectedOption().getText(); 
	}
}
