package com.PhpTravelsHotelApplication.HelperClass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Scrolling {

	public static void scroll(WebDriver driver) {
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("window.scrollBy(0,250)");
	}

}
