package com.appium.cricbuzz;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import appiumtest.appiumtest.AdbController;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Paytmdemotest {
	AppiumDriverLocalService service;
	TouchAction touchActions;
	
	AppiumDriver<MobileElement> driver;
	//AndroidDriver<MobileElement> driver;

	@BeforeClass
	public void setup() {
		service = AppiumDriverLocalService.buildDefaultService();
		service.stop();
		service.start();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Dinesh Babu");
		cap.setCapability("udid", "900b838a");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "6.0.1");
		cap.setCapability("appPackage", "net.one97.paytm");
		cap.setCapability("appActivity", "net.one97.paytm.landingpage.activity.AJRMainActivity");
		cap.setCapability("reset", "true");
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		} catch (MalformedURLException e) {
		
			e.printStackTrace();
		}
				
		
	}
	@Test(priority=0)
	public void paytmdemo() throws InterruptedException {
		
	driver.findElementByXPath("//android.widget.TextView[@text='English']").click();
	System.out.println("English language is selected");
	
	driver.findElementByClassName("android.widget.Button").click();
	
	System.out.println("clicked on continue button");
		Thread.sleep(8000);
	}
	
	@Test(priority=1)
	public void prepaidrechargetest() throws InterruptedException {
		
		//driver.findElementByTagName("//android.widget.TextView[@text='Do It Later']").click();
		List<MobileElement> d =	driver.findElementsByClassName("android.widget.TextView");
		Thread.sleep(8000);
		d.get(1).click();
		System.out.println("clicked on do it later");
		Thread.sleep(8000);		
		MobileElement element = driver.findElementByXPath("//android.widget.TextView[@text='Mobile Postpaid']");
        Point point = element.getLocation();
        int positionX = point.getX();
        int positionY = point.getY();
        //LOG.info("x value:" + positionX + " Y value:" + positionY);
		System.out.println("x value:" + positionX + " Y value:" + positionY);
		
		
		/*(new TouchAction(driver))
        .press(PointOption.point(262, 1340))
        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
        .moveTo(PointOption.point(262, 565))
        .release()
        .perform();

		(new TouchAction(driver))
        .press(PointOption.point(262, 1340))
        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
        .moveTo(PointOption.point(262, 565))
        .release()
        .perform();*/
		//scrollAndClick("");
			
		driver.findElementByXPath("//android.widget.TextView[@text='Mobile Postpaid']").click();
		
		System.out.println("selected mobile prepaid recharge");
		Thread.sleep(8000);
		List<MobileElement> prp = driver.findElementsByClassName("android.widget.EditText");
		System.out.println("click on mobile number");
		Thread.sleep(8000);
		prp.get(0).click();
		System.out.println("enter mobile number");
		Thread.sleep(8000);
		prp.get(0).sendKeys("8464837036");
		Thread.sleep(8000);
		prp.get(1).click();
		Thread.sleep(8000);
		System.out.println("click on operator");
		List<MobileElement> prp2 = driver.findElementsByClassName("android.widget.ImageView");
		
		System.out.println("select idea operator");
		Thread.sleep(8000);
		prp2.get(4).click();
		
		System.out.println("select andhra pradesh");
		Thread.sleep(8000);
		driver.findElementByXPath("//android.widget.TextView[@text='Andhra Pradesh']").click();
		System.out.println("enter amount rupees 10");
		Thread.sleep(8000);
		prp.get(2).sendKeys("10");
		Thread.sleep(3000);
		AdbController.executeAdbCommand("shell input keyevent 4");

		//((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		//driver.navigate().back();
		Thread.sleep(10000);
		driver.findElementByXPath("//android.widget.Button[@text='Proceed to Recharge']").click();
		
	}
	
	
	@AfterClass
	public void teardown() {
		
		System.out.println("success");
		driver.closeApp();
		AdbController.executeAdbCommand("shell settings put secure location_providers_allowed -network");
		service.stop();
	}
	
	
	
	
	
	
	
	

}
