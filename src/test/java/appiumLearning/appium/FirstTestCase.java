package appiumLearning.appium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class FirstTestCase extends Configuration
{

	@BeforeMethod 
	public void beforementod() throws InterruptedException {
		driver.activateApp("com.tara_app_mvp.activities");
		Thread.sleep(3000);
	}
	
	
	@Test
	public void appiumFirstCode() throws InterruptedException
	{
		
		
		
		__waitTime(60);
		driver.findElement(By.id("com.tara_app_mvp.activities:id/loginBtn")).click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.tara_app_mvp.activities:id/subjectName\" and @text=\"ENGLISH\"]")).click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.tara_app_mvp.activities:id/lessonContainer\"]/android.widget.LinearLayout[1]/android.widget.LinearLayout\r\n")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.tara_app_mvp.activities:id/lessonContainer\"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout")).click();
		
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
		Thread.sleep(10000);
		driver.pressKey(new KeyEvent (AndroidKey.BACK));

		
	}
	
	@Test(dataProvider = "phoneData", dataProviderClass = TestData.class)
	public void phoneNumberValidation(String aPhoneNumer ,Boolean aShouldLogin, String aexpectedResult ) throws InterruptedException 
	{
		
		__waitTime(30);

		WebElement phoneField = driver.findElement(By.id("com.tara_app_mvp.activities:id/username"));
	    WebElement submitBtn = driver.findElement(By.id("com.tara_app_mvp.activities:id/loginBtn"));
		
		phoneField.click();
	    phoneField.clear();
	    phoneField.sendKeys(aPhoneNumer);
	    submitBtn.click();
//	    String toastMessaage = __getToastMessage();
	    
	    if (!aShouldLogin) 
	    {

	    	String toastMessage = __getToastMessage();
	        System.out.println("Toast: " + toastMessage);

	        Assert.assertEquals(toastMessage, aexpectedResult);
	        Assert.assertTrue(phoneField.isDisplayed());

	    } 
	    else {

	        // 🔹 VALID CASE → Verify Login Success
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        WebElement homeScreen = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                By.id("com.tara_app_mvp.activities:id/greeting_text") 
	            )
	        );

	        Assert.assertTrue(homeScreen.isDisplayed());
	    }
	    
	}
	
}
