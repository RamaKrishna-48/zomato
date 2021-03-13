package zomatoApp;

import java.util.ArrayList;
import java.util.Iterator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.basePage.BasePage;
import com.qa.basePage.base;
import com.qa.pages.homePage;
import com.qa.pages.loginPage;
import com.qa.utility.ExcelUtil;

//public class zomatoLoginTest extends AndroidNativeParallelTests {
public class zomatoLoginTest extends base  {
	public static String currrntDirectory;
	loginPage loginPage;
	homePage HomePage;
	public zomatoLoginTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		setUp();
		loginPage = new loginPage(driver);
		HomePage = new homePage(driver);
	}

	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = ExcelUtil.getDataFromExcel();
		return testData.iterator();
	}

	@Test(dataProvider = "getTestData")
	public void registrationAndSelectTheItemFinallyAddToCartTest(String MobileNumber,String RestaurantName) throws InterruptedException  {
		
		try {
			loginPage.loginTest(MobileNumber, RestaurantName);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		
	
		/*
		
		// click on none of the Above button
		Thread.sleep(5000);
		driver.findElement(By.id("com.google.android.gms:id/cancel")).click();
		// click on skip button
		Thread.sleep(5000);
		driver.findElement(By.id("com.application.zomato:id/skip_button")).click();
		driver.hideKeyboard();
		Thread.sleep(5000);
		// select the current location allow the permission
		driver.findElement(By.id("com.application.zomato:id/use_location_button")).click();
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		Thread.sleep(5000);
		// click on search bar
		driver.findElement(By.id("com.application.zomato:id/edittext")).click();
		Thread.sleep(5000);
		// send the Amba restaurant name
		// To get the data from excell
		driver.findElement(By.id("com.application.zomato:id/edittext")).sendKeys(searchElement);
		Thread.sleep(5000);
		// Select the restaurant
		driver.findElement(By.id("com.application.zomato:id/rating_snippet_child_text")).click();
		Thread.sleep(5000);
		 //Vertical scrolling
		verticalScroll();
		// swipping
		Thread.sleep(5000);
		// click on order food online
		driver.findElement(By.xpath("//*[@text='Order food online']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@text='Menu']")).click();

		AndroidElement tiffin = driver.findElement(By.xpath("//*[@text='Tiffin']"));
		if (tiffin.getText().equals("Tiffin")) {
			tiffin.click();
		} else {
			System.out.println("Food item is not available  :" + tiffin);
		}

		// scroll And check the item finally click on add Button
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
			driver.findElement(
					By.xpath("//*[@text='Uttapam' AND @resource-id='com.application.zomato:id/text_view_title']"))
					.click();
		} catch (Exception e) {
			System.out.println("item is not availbale");
		}
*/
	}

	
}
