package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WebDriverUtilities;

public class SearchPage {

	
	WebDriver driver;
	WebDriverWait wait;
	
	public SearchPage () {
		driver = WebDriverUtilities.getWebDriver();
		PageFactory.initElements(driver, this);
		wait= new WebDriverWait(driver,10);
	}
	
	@FindBy(xpath = "//div[@id='flight-listing-container']/ul/li[1]/div/div/div[2]/div/div/div/span")
	WebElement priceOfFirstFlight;
	
	@FindBy(xpath = "//fieldset[@id='airlines']")
	WebElement airLinesIncluded;
	
	@FindBy(xpath = "//footer/div[@id='site-footer-background']/div/div[6]")
	WebElement footerNote;
	
	public String flightPrice() {
		String price = priceOfFirstFlight.getText();
		return price;
	}
	
	public boolean visiblityAirLinesIncluded() {
		boolean flag = false;
		flag = airLinesIncluded.isDisplayed();
		return flag;
	}
	
	public String footerNote() {
		String note = null;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		note = footerNote.getText();
		return note;
	}
}
