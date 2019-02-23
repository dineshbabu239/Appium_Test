package appiumtest.appiumtest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class AppiumTest2 extends AdbController {
	AppiumDriver<MobileElement> driver;
	
	@BeforeClass
	public void flipkartBeforeClassSetup() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Dinesh Babu");
		caps.setCapability("udid", "900b838a"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "6.0.1");
		caps.setCapability("appPackage", "com.flipkart.android");
		caps.setCapability("appActivity", "com.flipkart.android.activity.HomeFragmentHolderActivity");
		caps.setCapability("unicodeKeyboard", "true");                                     
		caps.setCapability("resetKeyboard", "true");
		caps.setCapability("noReset", "true");
		
		//Instantiate Appium Driver
		try {
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
	}
		
		
}
	@Test
	public void flipkartLaptopSearch() {
		//driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open Drawer']").click();
		//driver.findElementByXPath("//android.widget.TextView[@text='Electronics']").click();
		//driver.findElementByXPath("//android.widget.TextView[@text='Laptops']").click();
		//List<MobileElement> laptops = driver.findElementsById("com.flipkart.android:id/tv_card_view_holder");
		//System.out.println(laptops.get(1));
		//laptops.get(2).click();
		System.out.println(driver.getContext());
		//driver.findElementById("com.flipkart.android:id/search_widget_textbox").click();
		//driver.findElementById("com.flipkart.android:id/search_widget_textbox").sendKeys("iphone se"+"/n");
		driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Search on flipkart\"]/android.widget.TextView").sendKeys("iphone se"+Keys.ENTER);
		System.out.println(driver.getContextHandles());
		driver.findElementByXPath("//android.widget.Button[@text = 'Accept & continue']").click();
		driver.findElementById("com.android.chrome:id/next_button").click();
		driver.findElementById("com.android.chrome:id/negative_button").click();
		System.out.println(driver.getContext());
		driver.findElementById("com.android.chrome:id/search_box_text").click();
		driver.findElementById("com.android.chrome:id/url_bar").sendKeys("cricbuzz"+"\n");
		//AdbController.executeAdbCommand("shell am start -n com.flipkart.android/com.flipkart.android.activity.HomeFragmentHolderActivity");
		
		
		
		//driver.executeScript("mobile: shell", am start -n com.flipkart.android/com.flipkart.android.activity.HomeFragmentHolderActivity);
//		Map<String, Object> EnterKeyEvent  = new HashMap<String, Object>();
//		EnterKeyEvent.put("key", "66");
//		driver.executeScript("mobile:key:event", EnterKeyEvent);
		
		System.out.println(driver.getContextHandles());

		/*public void scrollToElementVisible(WebElement ele) {

			HashMap<String, String> scrollObject = new HashMap<String, String>();
			RemoteWebElement element = (RemoteWebElement) (ele);
			// String elementId = element.getId();
			scrollObject.put("element", element.getId());
			scrollObject.put("toVisible", "not an empty string");
			driver.executeScript("mobile:scroll", scrollObject);
		}*/
		
	}
	
}

