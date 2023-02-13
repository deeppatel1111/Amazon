package TestUtil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	public static ExtentReports getExtendObject()
	{
		String reportPath = System.getProperty("user.dir")+"\\Reports\\TestResult.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		reporter.config().setReportName("Functional testing");
		reporter.config().setDocumentTitle("Amazon web automation");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Test By", "Automation Script");
		return extent;
	}
	
	
}
