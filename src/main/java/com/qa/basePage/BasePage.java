package com.qa.basePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {
	
	public static AppiumDriver<AndroidElement> driver;
	String currrntDirectory;
	
	public static void setUp() {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("AutomationName", "Appium");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("Version", "7.1.1");
			capabilities.setCapability("deviceName", "OPPO A 71");
			capabilities.setCapability("udid", "TO9P8PTGAM554HNB");
			capabilities.setCapability("appPackage", "com.application.zomato");
			capabilities.setCapability("appActivity", "com.application.zomato.activities.Splash");
			try {
				URL url = new URL("http://127.0.0.1:4725/wd/hub");

				driver = new AppiumDriver<AndroidElement>(url, capabilities);

			} catch (MalformedURLException e) {

				e.printStackTrace();
			}
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			System.out.println("Session is created");
			
	/*		if (browser.equalsIgnoreCase("Android Emulator")) {
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("AutomationName", "Appium");
				capabilities.setCapability("Version", "11");
				capabilities.setCapability("appPackage", "com.application.zomato");
				capabilities.setCapability("appActivity", "com.application.zomato.activities.Splash");
				capabilities.setCapability("udid", "emulator-5554");
				capabilities.setCapability("deviceName", "Nexus S API 30");
			}
			try {
				URL url = new URL("http://127.0.0.1:4723/wd/hub");

				driver = new AppiumDriver<AndroidElement>(url, capabilities);

			} catch (MalformedURLException e) {

				e.printStackTrace();
			}*/
			
		
	}

	public static MobileElement scrollTouchAction(String direction) {

		int startx = 215;
		int starty = 540;
		int endx = 205;
		int endy = 205;

		switch (direction) {
		case "Up":
			for (int i = 1; i <= 2; i++)
				startx = 215;
			starty = 540;
			endx = 205;
			endy = 205;
			break;
		case "down":
			startx = 95;
			starty = 145;
			endx = 87;
			endy = 450;
		}

		new TouchAction<>(driver).press(PointOption.point(startx, starty))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(endx, endy))
				.release().perform();
		return null;

	};

	public void scrollToElement(By e, String direction) {
		for (int i = 0; i < 27; i++) {
			if (isDisplayed(e)) {
				break;
			} else {
				if (direction.equalsIgnoreCase("Up")) {
					scrollTouchAction("Up");
				} else {
					scrollTouchAction("down");
				}
			}
		}
	}
	public static boolean isDisplayed(final By e) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			return wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					if (driver.findElement(e).isDisplayed()) {
						return true;
					}
					return false;
				}
			});
		} catch (Exception ex) {
			return false;
		}
	}

	public MobileElement horizontalScrollToElement() {
		int startx = 398;
		int starty = 322;
		int endx = 144;
		int endy = 322;

		try {
			for (int i = 1; i <= 6; i++) {
				new TouchAction<>(driver).press(PointOption.point(startx, starty))
						.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
						.moveTo(PointOption.point(endx, endy))

						.release().perform();
			}
		} catch (Exception e) {

		}

		return null;

	}

	public MobileElement verticalScroll() {

		int startx = 215;
		int starty = 540;
		int endx = 205;
		int endy = 205;

		try {
			for (int i = 1; i <= 1; i++) {
				new TouchAction<>(driver).press(PointOption.point(startx, starty))
						.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
						.moveTo(PointOption.point(endx, endy)).release().perform();

			}
		} catch (Exception e) {

		}
		return null;
	}

}
