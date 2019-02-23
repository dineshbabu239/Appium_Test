package com.appium.cricbuzz;

import java.net.MalformedURLException;
import java.net.URL;//------>from this library we import URL 
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;//------>for AndroidDriver we use this library
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Cricbuzzdemotest {
	
	AppiumDriverLocalService service;

	public AppiumDriver<MobileElement> driver;   //------This is to be invoked from the libraries of----> {java_client.AppiumDriverlicst ,java_client.MobileElement}
	@BeforeClass
	public void demotest1() {
	
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
	//set the desired capabilities
		DesiredCapabilities cap = new DesiredCapabilities();//---this is from library---->org.openqa.selenium.remote.DesiredCapabilities
		cap.setCapability("deviceName","Dinesh Babu");
		cap.setCapability("udid", "900b838a");
		cap.setCapability("platformName","Android");
		cap.setCapability("platformVersion", "6.0.1");
		cap.setCapability("appPackage","com.cricbuzz.android");
		cap.setCapability("appActivity","com.cricbuzz.android.lithium.app.view.activity.NyitoActivity");
		cap.setCapability("noReset","true");
		
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		}catch(MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("app launched successfully");

}
	@Test(priority=0)
	public void elementtap() {
		int i;
		driver.findElementById("com.cricbuzz.android:id/txt_schedule").click();
		List<MobileElement> cric = driver.findElementsByClassName("android.widget.TextView");
		cric.get(3).click();
		System.out.println(cric.get(3).getText());    
		System.out.println(cric.size()); 
		for(i=0;i<cric.size();i++) {
			System.out.println(cric.get(i).getText());
		}
	}
	@Test(priority=1)
	public void test2() {
		driver.findElementByAccessibilityId("Navigate up").click();
		driver.findElementById("com.cricbuzz.android:id/img_action_settings").click();
		driver.findElementByClassName("android.widget.RelativeLayout").click();
		
	}
	

	
	@AfterClass
	public void teardown() {
		service.stop();
		driver.findElementByClassName("android.widget.RelativeLayout").click();
		System.out.println("executed succesfully");
		
		
		
		
	}
	
	
}