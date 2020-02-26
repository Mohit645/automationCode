package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.input.Input;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Inputs;
import utilities.WebDriverUtilities;

public class HomePage {
	
	Inputs in = new Inputs();	
	WebDriver driver;
	WebDriverWait wait;
	
	
	public HomePage() {
		driver = WebDriverUtilities.getWebDriver();
		PageFactory.initElements(driver, this);
		wait= new WebDriverWait(driver,10);
	}
	
	@FindBy(xpath = "//button[@id='tab-flight-tab-hp']")
	WebElement flightButton;
	
	@FindBy(xpath = "//input[@id='flight-origin-hp-flight']")
	WebElement flyingFromTab;
	
	@FindBy(xpath ="//input[@id='flight-destination-hp-flight']")
	WebElement goingToTab;
	
	@FindBy(xpath = "//input[@id='flight-departing-hp-flight']")
	WebElement departingDate;
	
	@FindBy(xpath ="//input[@id='flight-returning-hp-flight']")
	WebElement returnDate;
	
	@FindBy(xpath="//div[@id='traveler-selector-hp-flight']/div/ul/li/button")
	WebElement travelerButton;
	
	@FindBy(xpath="//div[@id='traveler-selector-hp-flight']/div/ul/li/div/div/div/div/div[4]/button")
	WebElement addAdultsButton;
	
//	@FindBy(xpath ="//button[@id='search-button-hp-package']")
	@FindBy(xpath ="//div[@class='cols-nested ab25184-submit']/label/button")
	WebElement searchButton;
	
	@FindBy(xpath = "//ul[@id='typeaheadDataPlain']/div/li/a[@data-value='London, England, UK (LHR-Heathrow)']")
	WebElement fromAirport;
	
	@FindBy(xpath = "//ul[@id='typeaheadDataPlain']/div/li/a[@data-value='Dublin, Ireland (DUB)']")
	WebElement toAirport;
	
	public void clickFlights() {
		flightButton.click();
	}
	
	public void flyFrom() {
		
		
		flyingFromTab.sendKeys(in.flyingCity);
		fromAirport.click();		
		
	}
	
	public void flyTo( ) {
		
		goingToTab.sendKeys(in.goingCity);	
		toAirport.click(); 
	}
	
	public void  setDepartureDate() {
		departingDate.sendKeys(in.departingDate);
	}
	
	public void setReturnDate() {
		
		int i=10;
		while(i>0)
		{
			returnDate.sendKeys(Keys.BACK_SPACE);
			i--;
		}
		
		returnDate.sendKeys(in.returnDate);
	}
	
	public void setTravelers() {
		travelerButton.click();
		
		for(int i=1; i<=in.numberOfAdults; i++)
		{
			addAdultsButton.click();
		}
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}

}
