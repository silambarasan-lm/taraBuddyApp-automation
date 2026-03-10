package appiumLearning.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Configuration {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	public String _serviceLocationName = "C:\\Users\\silam\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
	static String _mobileName = "silambuPhone";

	static String _wifiName = "silambarasanwifi";
	static String _appPath = "D:\\Appium_learning\\appium\\src\\test\\java\\resource\\app-debug.apk";
	static String _chromeDriver = "D:\\Apps\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe";

	@BeforeTest
	public void __launchAppiumServer() throws MalformedURLException {
		
	service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File(_serviceLocationName))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();	

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(_mobileName);
		options.setChromedriverExecutable(_chromeDriver);
		options.setApp(_appPath);

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	}

	@AfterTest
	public void __closeAppiumServer() {
		driver.quit();
		service.stop();
	}
	
	public void __waitTime(int aSeconds)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(aSeconds));
		}
	
	
	public String __getToastMessage() 
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	    WebElement toast = wait.until(
	        ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Toast"))
	    );
	    return toast.getAttribute("name");
	}
	
	
}