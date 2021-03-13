package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.qa.basePage.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class loginPage extends BasePage {

	AppiumDriver<AndroidElement> driver;

	public loginPage() {
		super();
	}

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")
	AndroidElement MobileNumber;

	@AndroidFindBy(id = "com.google.android.gms:id/cancel")
	AndroidElement noneOfTheAbove;
	@AndroidFindBy(id = "com.application.zomato:id/fw_mobile_edit_text")
	AndroidElement EnterMobileNumber;

	@AndroidFindBy(id = "com.application.zomato:id/send_otp_button")
	AndroidElement clickOnOTP;

	@AndroidFindBy(id = "com.application.zomato:id/skip_button")
	AndroidElement clickOnSkipButton;

	@AndroidFindBy(id = "com.application.zomato:id/use_location_button")
	AndroidElement toSelectcurrentLocation;

	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	AndroidElement allowThePermission;

	@AndroidFindBy(id = "com.application.zomato:id/edittext")
	AndroidElement searchRestaurent;

	@AndroidFindBy(id = "com.application.zomato:id/edittext")
	AndroidElement searchLocation;

	@AndroidFindBy(xpath = "//*[@text='Gajularamaram']")
	AndroidElement selectTheLocation;

	@AndroidFindBy(xpath = "//*[@text='Confirm location']")
	AndroidElement confirmLocation;

	@AndroidFindBy(xpath = "//*[@text='Raja Rani Ruchulu']")
	AndroidElement selectTheRestaurent;

	@AndroidFindBy(xpath = "//*[@text='CakeZone']")
	AndroidElement bhavani;

	@AndroidFindBy(id = "com.application.zomato:id/rating_snippet_child_text")
	AndroidElement godawari;

	@AndroidFindBy(xpath = "//*[@text='Order food online']")
	AndroidElement clickOnOrderFoodOnline;

	@AndroidFindBy(xpath = "//*[@text='Today's Exclusive Dishes']")
	AndroidElement clickOnOrderFood;

	@AndroidFindBy(xpath = "//*[@text='Menu']")
	AndroidElement clickOnMenu;

	@AndroidFindBy(xpath = "//*[@text='Biryani']")
	AndroidElement clickOnBiryani;

	@AndroidFindBy(xpath = "//*[@text='Tiffin']")
	AndroidElement clickOnTiffin;

	@AndroidFindBy(xpath = "//*[@text='Recommended']")
	AndroidElement cakes;

	@AndroidFindBy(xpath = "//*[@text='Tandoori Roti']")
	AndroidElement selectTheTandooriRotiItem;

	@AndroidFindBy(xpath = "//*[@text='Onion']")
	AndroidElement tocheckOnoinItem;

	@AndroidFindBy(xpath = "//*[@text='Pizza']")
	AndroidElement tocheckPizzaItem;

	@AndroidFindBy(xpath = "//*[@text='Divyasree Tiffins']")
	By clickOnBhawaniTiffins;

	@AndroidFindBy(xpath = "//*[@text='ADD'][5]")
	AndroidElement clickOnAddButton;

	@AndroidFindBy(xpath = "//*[@text='Uttapam']")
	AndroidElement tocheckUthapamItem;

	@AndroidFindBy(id = "com.application.zomato:id/text_view_title")
	AndroidElement clickOnADDButton;

	@AndroidFindBy(id = "com.application.zomato:id/button")
	AndroidElement clickADDButton;

	public loginPage(AppiumDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	/**
	 * open the App and enter the mobileNumber Click on tap select the current
	 * location allow the permission search the item select the item vertically
	 * scroll check the item finally click on add Button
	 * 
	 */

	public void loginTest(String login, String searchElement) throws InterruptedException {

		Thread.sleep(5000);
		if (noneOfTheAbove.isDisplayed()) {
			noneOfTheAbove.click();
			// clickOnSkipButton.click();
			MobileNumber.sendKeys(login);
			clickOnOTP.click();
		} else {
			System.out.println("not registerd");
		}

		try {
			driver.hideKeyboard();
		} finally {
			System.out.println(" Hide the key board");
		}
		Thread.sleep(3000);
		// select the current location
		toSelectcurrentLocation.click();
		Thread.sleep(5000);
		// allow permission
		allowThePermission.click();
		Thread.sleep(5000);
		//click on allow
		//searchLocation.click();
		//Thread.sleep(3000);
		//enter location
	//	searchLocation.sendKeys("Gajularam");
		//Thread.sleep(5000);
		//selectTheLocation.click();
		Thread.sleep(5000);
		searchRestaurent.click();
		Thread.sleep(3000);
		searchRestaurent.sendKeys(searchElement);
		Thread.sleep(5000);
		bhavani.click();
		Thread.sleep(5000);
		clickOnMenu.click();
		cakes.click();
		int x = 440;
		int y = 961;
		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).release()
				.perform();
		Thread.sleep(1000);
		clickADDButton.click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * int x=584; int y=620; new TouchAction<>(driver).press(PointOption.point(x,
		 * y)) .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		 * .moveTo(PointOption.point(x, y)).perform(); TouchAction action=new
		 * TouchAction(driver); action.press(PointOption.point(x,
		 * y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).release().
		 * perform();
		 * 
		 * 
		 * /* // TouchActions action=new TouchAction(driver).tap(595, 608).perform();
		 * action.tap(595, 608).perform(); action.scroll(clickOnADDButton, 584, 620);
		 * action.perform(); clickOnADDButton.click();
		 * 
		 * /* try { // To select the dosaItem By selectTheStartingFoodItem =
		 * By.xpath("//*[@text='Tiffin']"); By end = By.xpath("//*[@text='Uttapam']");
		 * scrollToElement(selectTheStartingFoodItem, "down");
		 * driver.findElement(selectTheStartingFoodItem).isDisplayed();
		 * scrollToElement(end, "Up"); driver.findElement(end).isDisplayed();
		 * Thread.sleep(3000); verticalScroll();
		 * 
		 * 
		 * clickOnAddButton.click(); } catch (Exception e) {
		 * System.out.println("item is not availbale"); }
		 */
	}

}
