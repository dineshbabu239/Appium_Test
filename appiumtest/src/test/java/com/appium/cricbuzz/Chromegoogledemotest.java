package com.appium.cricbuzz;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Chromegoogledemotest {

	public static AppiumDriver<MobileElement> driver;
	@BeforeClass
	public void setup() {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName","Dinesh Babu");
		cap.setCapability("udid","900b838a");
		cap.setCapability("platformName","Android");
		cap.setCapability("platformVersion","6.0.1");
		cap.setCapability("appPackage","com.android.chrome");
		cap.setCapability("appActivity","com.google.android.apps.chrome.Main");
		cap.setCapability("noReset","true");
		
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		} catch(MalformedURLException e){
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void chrometest() throws InterruptedException {
		
		//driver.findElementById("com.android.chrome:id/terms_accept").click();
		//Thread.sleep(5000);
		//driver.findElementByXPath("//android.widget.Button[@text='Next']").click();
		//Thread.sleep(5000);
		//driver.findElementById("com.android.chrome:id/negative_button").click();
		//Thread.sleep(5000);
		driver.findElementByXPath("//android.widget.EditText[@text='Search or type web address']").sendKeys("cricbuzz");
		//driver.findElementById("com.android.chrome:id/search_box_text").sendKeys("appium");
		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		System.out.println(driver.getContext());

		System.out.println(driver.getContextHandles());
		System.out.println(driver.getContextHandles());
		
		
		}
	@AfterClass
	public void teardown() {
		System.out.println("executed succesfully");
	}
}
