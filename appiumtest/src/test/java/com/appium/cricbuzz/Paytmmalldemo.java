package com.appium.cricbuzz;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.MobileDriver;
import appiumtest.appiumtest.AdbController;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class Paytmmalldemo extends AdbController{
	
	Dimension size;
	
	AppiumDriverLocalService service;
	public AppiumDriver<MobileElement> driver;
	@BeforeClass
	public void setup() {
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		DesiredCapabilities cap = new DesiredCapabilities(); 
		cap.setCapability("deviceName", "Dinesh Babu");
		cap.setCapability("udid", "900b838a");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "6.0.1");
		cap.setCapability("appPackage", "com.paytmmall");
		cap.setCapability("appActivity", "net.one97.paytm.landingpage.activity.AJRMainActivity");
		cap.setCapability("reset", "true");
		
	try {
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
	}catch(MalformedURLException e) {
		System.out.println(e.getMessage());
	}
		
	}
	@Test(priority=0)
	public void searchforproducttest() {
		
		driver.findElementById("com.paytmmall:id/btn_language_continue_button").click();
		System.out.println("clicked on continue button");
		driver.findElementByAccessibilityId("Search Paytm Mall").click();
		System.out.println("enter text for product");
		driver.findElementByClassName("android.widget.EditText").sendKeys("sparks sandals");
		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		
		List<MobileElement> pyt = driver.findElementsByClassName("android.widget.ImageView");
		pyt.get(0).click();
		System.out.println("this is sparks sandals displayed on screen");
	
		List<MobileElement> pyt1 = driver.findElementsByClassName("android.widget.ImageView");
		pyt1.get(0).click();
		boolean a = driver.findElementById("com.paytmmall:id/zoomable_image_product").isDisplayed();
		System.out.println("sparks sandal image is displayed : " +a);
		
	}
		
	public void swipemethod() {	
		
		/*//to get the size of the screen
		size = driver.manage().window().getSize();
		System.out.println(size);
		
		int x1 = (int) (size.width*20);
		
		int x2 = (int) (size.width*0.80);
		
		TouchAction action = new TouchAction((MobileDriver)driver);
		
		WebElement wb = (WebElement) driver.findElementById("com.paytmmall:id/zoomable_image_product");
		action.longPress(wb).moveTo(x1,580).release().perfporm();
		
		
		*/
		
		
		
		
		
		
		/*Dimension d = driver.manage().window().getSize();
		int height = d.getHeight();
		int width = d.getWidth();
		int y = (int)(height*20);
		int startx = (int)(width*0.75);
		int endx = (int)(width*0.35);
		(() driver).swipe(startx,y,endx,y,500);
		*/
		
		
		//swipe right method
		
		/*WebElement wb = driver.findElementById("com.paytmmall:id/zoomable_image_product");
		Dimension d = wb.getSize();
		int anchor = wb.getSize().getHeight()/2;
		
		Double Screenwidthstart = d.getWidth()*0.8;
		int scrollstart =Screenwidthstart.intValue();
		
		Double Screenwidthend = d.getWidth()*0.8;
		int scrollend =Screenwidthend.intValue();
		
		new TouchAction((PerformsTouchActions) ((Object) driver).getDriver());
		*/
	
		//AdbController.executeAdbCommand("shell am start -n com.flipkart.android/com.flipkart.android.activity.HomeFragmentHolderActivity");
		//AdbController.executeAdbCommand("shell settings put secure location_providers_allowed -network");
		service.stop();
	}
	
	}
