package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllNewKindlePage {

	
	WebDriver driver;
	public SignInPage signInPage;
	public AllNewKindlePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='buy-now-button']")
	WebElement btn_BuyNow;
	
	public SignInPage clkOnBuyNow()
	{
		btn_BuyNow.click();
		signInPage = new SignInPage(driver);
		return signInPage;
	}

	  
}
