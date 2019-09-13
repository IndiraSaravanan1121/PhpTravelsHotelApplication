package com.PhpTravelsHotelApplication.HelperClass;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.PhpTravelsHotelApplication.BaseClass.BaseClass;

public class Enter extends BaseClass {
	
	static Actions action = new Actions(driver);

	public static void actionTab() {

		action.sendKeys(Keys.TAB).build().perform();
	}
	
	public static void actionEnter() {
		
		action.sendKeys(Keys.ENTER).build().perform();
		
	}
}
