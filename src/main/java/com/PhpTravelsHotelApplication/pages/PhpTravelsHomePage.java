package com.PhpTravelsHotelApplication.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.PhpTravelsHotelApplication.Constants.Constants;

public class PhpTravelsHomePage {
	
	static FileInputStream fis; 
	private static Properties property=new Properties();
	private static WebElement element;

	
	public static WebElement seacrhHotel(WebDriver driver) throws Exception {
		fis =new FileInputStream(Constants.location_path);
		property.load(fis);
		element = driver.findElement(By.xpath(property.getProperty("loc_hotel_btn")));
		return element;
	}

	public static WebElement checkIn(WebDriver driver) {

		element = driver.findElement(By.xpath(property.getProperty("loc_checkindate_txt")));
		return element;
	}

	public static WebElement checkOut(WebDriver driver) {

		element = driver.findElement(By.xpath(property.getProperty("loc_checkoutdate_txt")));
		return element;
	}

	public static WebElement searchButton(WebDriver driver) {

		element = driver.findElement(By.xpath(property.getProperty("loc_search_btn")));
		return element;
	}

}
