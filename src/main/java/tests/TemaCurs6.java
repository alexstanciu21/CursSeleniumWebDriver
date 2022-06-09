package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import pages.SingleAuthorPage;
import utils.BaseTest;

public class TemaCurs6 extends BaseTest{
	
	@Test
	public void navigateToAuthor() {
		
		SingleAuthorPage authorPage = navMenu.navtoSingleAuthor(); 
		authorPage.pageWaitTitle();
		
		String drama = authorPage.findProcents("Drama"); 
		String biography = authorPage.findProcents("Biography"); 
		String cookbooks = authorPage.findProcents("Cookbooks"); 

		assertEquals(drama, 95 + "%");
		assertEquals(biography, 75 + "%");
		assertEquals(cookbooks, 82 + "%");
			
	}
	
	

}
