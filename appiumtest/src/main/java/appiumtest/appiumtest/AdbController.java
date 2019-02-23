package appiumtest.appiumtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AdbController {
	
	public static String adbLocation = System.getenv("ANDROID_HOME") + "/platform-tools/adb ";
	private static Process process;

	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(AdbController.class);
	
	/*public AdbController() {
		
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		//your test scripts logic...
		//service.stop();
		
	}*/


/**
	 * Execute any ADB commands
	 */
	public static String executeAdbCommand(String command) {
		String line = "";
		String output = "";
		LOG.info("Executing ADB Command " + adbLocation + command);
		try {
			process = Runtime.getRuntime().exec(adbLocation + command);
			process.waitFor(90, TimeUnit.SECONDS); //Max 90 Seconds to execute command

			if (process.isAlive()) {
				process.destroy();
			} else {
				BufferedReader buffer = new BufferedReader(new InputStreamReader(process.getInputStream()));
				while ((line = buffer.readLine()) != null) {
					LOG.info(line);
					output = output + " " + line;
				}
				buffer.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}


}
