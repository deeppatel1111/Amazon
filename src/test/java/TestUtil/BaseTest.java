package TestUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;

import PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	Properties pro;
	public LandingPage landingPage;

	public WebDriver initDriver() throws IOException {
		pro = new Properties();
		pro.load(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\Data.properties"));

		String browser = pro.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}

	@BeforeMethod
	public void startApp() throws IOException {
		driver = initDriver();
		String url = pro.getProperty("url");
		driver.get(url);
		landingPage = new LandingPage(driver);
		landingPage.waitForElementToAppear();

	}

	@AfterMethod
	public void closeApp() {
		driver.quit();
	}

}
