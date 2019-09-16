package com.PhpTravelsHotelApplication.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.PhpTravelsHotelApplication.Constants.Constants;

public class ValidatePriceType {

	static FileInputStream fis;
	private static Properties property = new Properties();
	private static WebElement element;

	public static void validatePriceType(WebDriver driver) throws Exception {
		fis = new FileInputStream(Constants.location_path);
		property.load(fis);
		WebElement element = driver.findElement(By.xpath(property.getProperty("loc_currencytypecheck_txt")));
        Assert.assertTrue(((Properties) element).contains("INR"),"Not Matched..");
	}
}
