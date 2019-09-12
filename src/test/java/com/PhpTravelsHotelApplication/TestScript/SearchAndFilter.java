package com.PhpTravelsHotelApplication.TestScript;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.PhpTravelsHotelApplication.BaseClass.BaseClass;
import com.PhpTravelsHotelApplication.Constants.Constants;
import com.PhpTravelsHotelApplication.UtilsClass.ExcelUtils;

public class SearchAndFilter extends BaseClass {
	static FileInputStream fis;

	@DataProvider
	public Object[][] searchDetails() {
		Object data[][] = ExcelUtils.ReadWriteExcel("Sheet1");
		return data;
	}

	@Test(dataProvider = "searchDetails", priority = 0)
	public void getSearchDetails(String CheckIn, String CheckOut) throws Exception {
		fis = new FileInputStream(Constants.location_path);
		Properties property = new Properties();
		property.load(fis);
		driver.findElement(By.xpath(property.getProperty("loc_hotel_btn"))).click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys("chennai").build().perform();
		Thread.sleep(3000);
		action.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath(property.getProperty("loc_checkindate_txt"))).sendKeys(CheckIn);
		action.sendKeys(Keys.TAB).build().perform();
		driver.findElement(By.xpath(property.getProperty("loc_checkoutdate_txt"))).sendKeys(CheckOut);
		action.sendKeys(Keys.TAB).build().perform();
		driver.findElement(By.xpath(property.getProperty("loc_search_btn"))).click();

	}

	@Test(priority = 1)
	public void verifyPriceTextUpdate() throws Exception {
		fis = new FileInputStream(Constants.location_path);
		Properties property = new Properties();
		property.load(fis);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(50,0)");
		WebElement pricetxt = driver.findElement(By.xpath(property.getProperty("loc_pricetxt_btn")));
		Select priceText = new Select(pricetxt);
		priceText.selectByValue("INR");
		
		WebElement currencytype=driver.findElement(By.xpath(property.getProperty("loc_currencytype_txt")));
		Assert.assertEquals("INR", currencytype);

	}

	@Test(priority=2)
	public void ValidateDataFilteredorNot() throws Exception {
		fis = new FileInputStream(Constants.location_path);
		Properties property = new Properties();
		property.load(fis);
		driver.findElement(By.xpath(property.getProperty("loc_hightolow_radio_btn"))).click();
		JavascriptExecutor firstScroll = (JavascriptExecutor)driver;
		firstScroll.executeScript("window.scrollBy(0,250)");
				
		List<WebElement> price = driver.findElements(By.xpath("loc_pricelist_txt"));
		List<String> prices = new ArrayList<String>();
		for (WebElement e : price)
		{
		    prices.add(e.getText());
		}
		List<String> sortedPrices = new ArrayList<String>(prices);
		Collections.sort(sortedPrices);
		System.out.println(sortedPrices.equals(prices));
		Assert.assertEquals(prices,sortedPrices);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(property.getProperty("loc_lowtohigh_radio_btn"))).click();
		JavascriptExecutor secondScroll = (JavascriptExecutor)driver;
		secondScroll.executeScript("window.scrollBy(0,250)");
				
		List<WebElement> price1 = driver.findElements(By.xpath("loc_pricelist_txt"));
		List<String> prices1 = new ArrayList<String>();
		for (WebElement e1 : price1)
		{
		    prices.add(e1.getText());
		}
		List<String> sortedPrices1 = new ArrayList<String>(prices1);
		Collections.sort(sortedPrices1);
		System.out.println(sortedPrices1.equals(prices1));
		Assert.assertEquals(prices1,sortedPrices1);
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		ArrayList<String> obtainedList = new ArrayList<>(); 
		List<WebElement> actualPrice= driver.findElements(By.xpath("loc_pricelist_txt"));
		for(WebElement price:actualPrice){
		   obtainedList.add(price.getAttribute(null));
		   System.out.println("ActualPrice"+obtainedList);
		}
		ArrayList<String> sortedList = new ArrayList<>();   
		for(String expectedPrice:obtainedList){
		sortedList.add(expectedPrice);
		System.out.println("ExpectedPrice"+sortedList);
		}
		Collections.sort(sortedList);
		Assert.assertTrue(sortedList.equals(obtainedList));
		//driver.findElement(By.xpath(property.getProperty("loc_lowtohigh_radio_btn"))).click();
		

	}
*/