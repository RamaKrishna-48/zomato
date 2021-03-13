package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.qa.basePage.AndroidNativeParallelTests;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class homePage extends AndroidNativeParallelTests {
//public class homePage extends BasePage {

	AppiumDriver<AndroidElement> driver;

	public homePage() {
		super();
	}

	
	@AndroidFindBy(xpath = "//*['com.application.zomato:id/edittext']")
	AndroidElement searchRestaurent;
	
	
	@AndroidFindBy(id = "com.application.zomato:id/rating_snippet_child_text")
	AndroidElement selectTheRestaurent;

	@AndroidFindBy(xpath = "//*[@text='Amba Bhawani Hotel']")
	AndroidElement TheRestaurent;

	@AndroidFindBy(xpath = "//*[@text='Order food online']")
	AndroidElement clickOnOrderFoodOnline;

	@AndroidFindBy(xpath = "//*[@text='Menu']")
	AndroidElement clickOnMenu;

	@AndroidFindBy(xpath = "//*[@text='Breads']")
	AndroidElement clickOnBreads;

	@AndroidFindBy(xpath = "//*[@text='Tiffin']")
	AndroidElement clickOnTiffin;

	@AndroidFindBy(xpath = "//*[@text='Dosa']")
	AndroidElement selectTheItem;

	@AndroidFindBy(xpath = "//*[@text='Onion']")
	AndroidElement tocheckOnoinItem;

	@AndroidFindBy(xpath = "//*[@text='Pizza']")
	AndroidElement tocheckPizzaItem;

	@AndroidFindBy(xpath = "//*[@text='Divyasree Tiffins']")
	By clickOnBhawaniTiffins;

	@AndroidFindBy(id = "[@resource-id='com.application.zomato:id/image_view' and @text='ADD']")
	AndroidElement clickOnAddButton;
	@AndroidFindBy(xpath = "//*[@text='Paratha']")
	AndroidElement tocheckParathaItem;
	
	

	/**
	 * 
	 * initialize HomePage Elements
	 * 
	 *
	 */

	public homePage(AppiumDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	/**
	 * select the current location allow the permission search the item select the
	 * item vertically scroll check the item finally click on add Button
	 * 
	 */

	public void searchTheItemAndAddToCart(String searchElement) throws InterruptedException {
		searchRestaurent.sendKeys(searchElement);
		Thread.sleep(5000);
		selectTheRestaurent.click();
		Thread.sleep(5000);
		verticalScroll();
		clickOnOrderFoodOnline.click();
		Thread.sleep(2000);
		clickOnMenu.click();
		clickOnTiffin.click();
		//clickOnBreads.click();
		/*
		 * if (clickOnTiffin.getText().equals("Tiffin")) { clickOnTiffin.click(); } else
		 * { clickOnBreads.click(); }
		 
		System.out.println("To Check the Paratha");
		if (tocheckParathaItem.getText().equals("Paratha")) {
			tocheckParathaItem.click();
		} else {
			System.out.println("item is not available");
		}
		clickOnAddButton.click();*/
		try {
			// To select the dosaItem
			By selectTheStartingFoodItem = By.xpath("//*[@text='Tiffin']");
			By end = By.xpath("//*[@text='Uttapam']");
			scrollToElement(selectTheStartingFoodItem, "down");
			driver.findElement(selectTheStartingFoodItem).isDisplayed();
			scrollToElement(end, "Up");
			driver.findElement(end).isDisplayed();
			Thread.sleep(3000);
			verticalScroll();
			clickOnAddButton.click();
		} catch (Exception e) {
			System.out.println("item is not availbale");
		}
		
		/*
		 * try { // To select the dosaItem By selectTheStartingFoodItem =
		 * By.xpath("//*[@text=Breads']"); By end =
		 * By.xpath("//*[@text='Cocktali Dosa']");
		 * scrollToElement(selectTheStartingFoodItem, "down");
		 * driver.findElement(selectTheStartingFoodItem).isDisplayed(); //
		 * scrollToElement(end, "Up"); driver.findElement(end).isDisplayed();
		 * driver.findElement(end).click(); clickOnAddButton.click(); } catch (Exception
		 * e) { System.out.println("item is not availbale"); }
		 */
	}
}
