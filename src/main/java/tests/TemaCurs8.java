package tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SearchPage;
import utils.BaseTest;

public class TemaCurs8 extends BaseTest {

	@DataProvider(name = "booksSearchData")
	public Object[][] booksSearchData() {

		Object data[][] = new Object[4][1];

		// books
		data[0][0] = "A banquet of mouse";
		data[1][0] = "Cooking with love";
		data[2][0] = "Let the sun shine";
		data[3][0] = "New galaxy";

		return data;

	}

	@Test(dataProvider = "booksSearchData")
	public void searchTests(String bookName) {

		SearchPage searchPage = new SearchPage(driver);
		searchPage.searchAction();
		searchPage.searchTitle(bookName);
		searchPage.searchActionSubmit();

		assertEquals(searchPage.searchImage(), true);

	}

}
