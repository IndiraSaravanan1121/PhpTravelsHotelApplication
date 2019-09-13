package com.PhpTravelsHotelApplication.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ValidationPriceList {

	public static void validationPriceList(WebDriver driver) {

		List<WebElement> price = driver.findElements(By.xpath("loc_pricelist_txt"));
		List<String> prices = new ArrayList<String>();
		for (WebElement e : price) {
			prices.add(e.getText());
		}
		List<String> sortedPrices = new ArrayList<String>(prices);
		Collections.sort(sortedPrices);
		System.out.println(sortedPrices.equals(prices));
		Assert.assertEquals(prices, sortedPrices);

	}

}
