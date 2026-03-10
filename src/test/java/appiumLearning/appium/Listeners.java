package appiumLearning.appium;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners implements ITestListener
{
	ExtentReports extent = ExtendedReport.getreporterObject();
	ExtentTest test;
	
	@Override
	public void onTestStart (ITestResult result) {
		
//		TODO Auto-generated method stub
		 test = extent.createTest(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess (ITestResult result) {
		test.log(Status.PASS, "test passed");
	// TODO Auto-generated method stub
	}
	@Override
	public void onTestFailure (ITestResult result) {
	// TODO Auto-generated method stub
		test.fail(result.getThrowable());
	}
	
	@Override
	public void onTestSkipped (ITestResult result) {
	// TODO Auto-generated method stub
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
	}
	@Override
	public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	}
	
	@Override
	public void onFinish (ITestContext context) {
		extent.flush();
	// TODO Auto-generated method stub
}

}

