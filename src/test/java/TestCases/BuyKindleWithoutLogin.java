package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageObjects.AllNewKindlePage;
import PageObjects.SignInPage;
import TestUtil.BaseTest;
import TestUtil.TestNGListener;

public class BuyKindleWithoutLogin extends BaseTest {
	public ExtentTest testCase;


	@Test
	public void buyKindle() {
		testCase=TestNGListener.getTest();
		testCase.log(Status.INFO, "Click on hamburger menu (top left corner)");
		landingPage.clkOnHamburgeMenu();
		testCase.log(Status.INFO, "Select Kindle under Digital Content and Devices");
		landingPage.clkOnKindle();
		testCase.log(Status.INFO, "Click Kindle under Kindle E-Reader");
		AllNewKindlePage allnewKindlePage = landingPage.clkOnAllNewKindle();
		testCase.log(Status.INFO, "Click Buy Now");
		SignInPage signInPage = allnewKindlePage.clkOnBuyNow();
		testCase.log(Status.INFO, "Verify User is asked for email or mobile number");
		Assert.assertTrue(signInPage.isdisplayInpEmail());

	}

}
