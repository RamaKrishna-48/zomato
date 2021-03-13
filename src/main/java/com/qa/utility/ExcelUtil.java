package com.qa.utility;

import java.util.ArrayList;

public class ExcelUtil {
	static Xls_Reader reader;
	public static String currrntDirectory;

	public static ArrayList<Object[]> getDataFromExcel() {

		currrntDirectory = System.getProperty("user.dir");
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader(currrntDirectory + "/ZomatoExcell/zomato (14).xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int rowNum = 2; rowNum <= reader.getRowCount("zomatoLogin"); rowNum++) {

			System.out.println("=====");

			String MobileNumber = reader.getCellData("zomatoLogin", "MobileNumber", rowNum);
			String RestaurantName = reader.getCellData("zomatoLogin", "RestaurantName", rowNum);

			Object ob[] = { MobileNumber, RestaurantName };
			myData.add(ob);		}
		return myData;
	}
}
