package appiumLearning.appium;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtendedReport
{

	static ExtentReports extent;
	
	@BeforeTest
	public static ExtentReports getreporterObject() {
		String path =System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter =  new ExtentSparkReporter(path);
		reporter.config().setReportName ("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		
		extent = new ExtentReports();
		extent.attachReporter (reporter);
		extent.setSystemInfo("Tester", "Silambu");
		return extent;
	}
}
