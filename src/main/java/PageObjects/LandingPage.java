package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	
	
	WebDriver driver;
	public AllNewKindlePage allNewKindle;
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='nav-hamburger-menu']")
	WebElement lnk_humburgerMenu;
	
	@FindBy(xpath="//div[contains(text(),'Kindle')]")
	WebElement lnk_Kindle;
	
	@FindBy(xpath="//a[contains(text(),'All-new Kindle')]")
	WebElement lnk_AllNewKindle;
	
	
	public void clkOnHamburgeMenu()
	{
		lnk_humburgerMenu.click();
	}
	public void clkOnKindle()
	{
		lnk_Kindle.click();
	}
	public AllNewKindlePage clkOnAllNewKindle()
	{
		lnk_AllNewKindle.click();
		allNewKindle = new AllNewKindlePage(driver);
		return allNewKindle;
	}
	public void waitForElementToAppear() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(lnk_humburgerMenu));

	}
}
