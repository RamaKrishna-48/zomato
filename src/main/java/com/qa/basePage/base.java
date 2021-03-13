package com.qa.basePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class base {
	ExtentHtmlReporter htmlReporter;

	public static ExtentReports extent;
	// helps to generate the logs in test report.
	public static ExtentTest test;
	public static Calendar cal = Calendar.getInstance();

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
	}
			@Parameters({ "deviceName_", "url" })
			@BeforeTest
			public void startReport(String deviceName_, String OPPOA71) {
				SimpleDateFormat emailDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
				// initialize the HtmlReporter
				htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/reports" + "/Reports_" + "_"
						+ emailDateFormat.format(cal.getTime()) + "/testReport.html");

				// initialize ExtentReports and attach the HtmlReporter
				extent = new ExtentReports();
				extent.attachReporter(htmlReporter);

				// To add system or environment info by using the setSystemInfo method.
				extent.setSystemInfo("OS", deviceName_);
				extent.setSystemInfo("Browser", OPPOA71);

				// configuration items to change the look and feel
				// add content, manage tests etc
				htmlReporter.config().setDocumentTitle("Extent Report ");
				htmlReporter.config().setReportName("Test Report");
				htmlReporter.config().setTheme(Theme.STANDARD);
				htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
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
	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
			test.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
		} else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
	}
	@AfterTest
	public void tearDown() {
		// to write or update test information to reporter
		extent.flush();
		driver.close();
	}

}
