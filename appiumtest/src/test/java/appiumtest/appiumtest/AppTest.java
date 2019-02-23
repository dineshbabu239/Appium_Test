package appiumtest.appiumtest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * Unit test for simple App.
 */
/*
 * Changes made in branch feature/DA-123
 */
public class AppTest
{
	
@Test	
public void test1() {
		
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Dinesh Babu");
		caps.setCapability("udid", "900b838a"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "6.0.1");
		caps.setCapability("appPackage", "com.flipkart.android");
		caps.setCapability("appActivity", "com.flipkart.android.activity.HomeFragmentHolderActivity");
		caps.setCapability("noReset", "true");
		
		//Instantiate Appium Driver
		try {
				AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
				
				//driver.findElementById("com.flipkart.android:id/search_widget_textbox").sendKeys("back packs");
				driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open Drawer']").click();
				driver.findElementByXPath("//android.widget.TextView[@text='Electronics']").click();
				driver.findElementByXPath("//android.widget.TextView[@text='Laptops']").click();
				List<MobileElement> laptops = driver.findElementsById("com.flipkart.android:id/tv_card_view_holder");
				System.out.println(laptops.get(1));
				
				laptops.get(2).click();
				
				
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
	}
 
}
