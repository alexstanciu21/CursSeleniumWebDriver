package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ShippingAddressPage;
import utils.BaseTest;

public class TemaCurs7 extends BaseTest{
	
	@Test
	public void shippingAddress() {
		
		LoginPage loginPage = navMenu.navToLogin();
		loginPage.loginInApp("TestUser", "12345@67890");
		assertEquals(navMenu.getLoggedUser(), "Test User");
		loginPage.clickUserName();
		loginPage.clickSettings();
		loginPage.clickAddresses();
		loginPage.clickEditShippingAddress();

		ShippingAddressPage shippingAddressPage = new ShippingAddressPage(driver);
		shippingAddressPage.filterByIndex(41);
		assertEquals(shippingAddressPage.getCurrentSelectedOptionCountry(), "Canada");
		shippingAddressPage.filterByValue("NL");
		assertEquals(shippingAddressPage.getCurrentSelectedOptionProvince(), "Newfoundland and Labrador");
		
	}
	


}
