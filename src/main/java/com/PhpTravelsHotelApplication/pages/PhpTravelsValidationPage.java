package com.PhpTravelsHotelApplication.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.PhpTravelsHotelApplication.BaseClass.BaseClass;
import com.PhpTravelsHotelApplication.Constants.Constants;
import com.PhpTravelsHotelApplication.HelperClass.properties;

/**
 * Php travels Validation page
 * @author indira.saravanan
 *
 */

public class PhpTravelsValidationPage extends BaseClass {

	static FileInputStream fis;
	static Properties property = new Properties();
	
	public static WebElement clickCurrency(WebDriver driver) throws Exception {

		fis = new FileInputStream(Constants.location_path);
		property.load(fis);
		WebElement element = driver.findElement(By.xpath(property.getProperty("loc_currencytxt_btn")));
		return element;

	}

	public static WebElement clickHightoLow(WebDriver driver) throws Exception {

		fis = new FileInputStream(Constants.location_path);
		property.load(fis);

		WebElement element = driver.findElement(By.xpath(property.getProperty("loc_hightolow_radio_btn")));
		return element;

	}

	public static WebElement clickLowtoHigh(WebDriver driver) throws Exception {
		fis = new FileInputStream(Constants.location_path);
		property.load(fis);
		WebElement element = driver.findElement(By.xpath(property.getProperty("loc_lowtohigh_radio_btn")));
		return element;

	}

	public static WebElement clickPriceText(WebDriver driver) throws Exception {
		fis = new FileInputStream(Constants.location_path);
		property.load(fis);
		WebElement element = driver.findElement(By.xpath(property.getProperty("loc_currencytxt_btn")));
		return element;

	}

}
