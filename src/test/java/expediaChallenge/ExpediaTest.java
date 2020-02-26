package expediaChallenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchPage;
import utilities.WebDriverUtilities;



public class ExpediaTest {
	
	WebDriver driver =null;
	HomePage homePage = null;
	SearchPage searchPage = null;
	WebDriverWait wait = null;
	
	@BeforeSuite
	public void beforeClass() {
		driver = WebDriverUtilities.getWebDriver();
		homePage = new HomePage();
		searchPage = new SearchPage();
		wait = new WebDriverWait(driver, 20);
	}
	
	@BeforeTest
	public void beforeTest() {
		homePage.clickFlights();
		homePage.flyFrom();
		homePage.flyTo();
		homePage.setDepartureDate();
		homePage.setReturnDate();
		homePage.setTravelers();
		homePage.clickSearchButton();
		
	}
	
	@Test(priority = 1, testName = "Check if the price is $154")
	public void doesPriceMatch() {
		Assert.assertEquals(searchPage.flightPrice(), "$154");
		
	}
	@Test(priority = 2, testName = "Check if the price is $100")
	public void doesNotPriceMatch() {
		Assert.assertNotEquals(searchPage.flightPrice(), "$100");
		
	}
	
	@Test(priority =3, testName ="Visiblity of Airlines Included")
	public void visiblityOfAirLines() {
		Assert.assertTrue(searchPage.visiblityAirLinesIncluded());
	}
	
	@Test(priority =4, testName ="Footer Note Text")
	public void footerNoteText() {
		System.out.println(searchPage.footerNote());
		Assert.assertEquals(searchPage.footerNote(),"Expedia, Inc. is not responsible for content on external Web sites. © 2020 Expedia, Inc, an Expedia Group Company. All rights reserved.");
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.quit();
	}
	

}
