package com.PhpTravelsHotelApplication.TestScript;

import java.io.FileInputStream;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
	public void getSearchDetails(String City, String CheckIn, String CheckOut) throws Exception {
		fis = new FileInputStream(Constants.location_path);
		Properties property = new Properties();
		property.load(fis);
		driver.findElement(By.xpath(property.getProperty("loc_hotel_btn"))).click();
		driver.findElement(By.xpath(property.getProperty("loc_cookies_btn"))).click();
		/*
		 * Actions action=new Actions(driver);
		 * action.sendKeys(Keys.TAB).build().perform();
		 * action.sendKeys(Keys.TAB).build().perform();
		 * action.sendKeys(Keys.TAB).build().perform();
		 * action.sendKeys(Keys.TAB).build().perform();
		 * action.sendKeys("Hyderabad").build().perform(); Thread.sleep(3000);
		 * action.sendKeys(Keys.ENTER).build().perform();
		 */
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 20);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "loc_searchbycity_txt")));
		 */
		 
		//driver.findElement(By.xpath(property.getProperty("loc_searchbycity_txt"))).sendKeys(City);

		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver; WebElement btn =
		 * driver.findElement(By.xpath(property.getProperty("loc_searchbycity_txt")));
		 * js.executeScript("arguments[0].click();", btn);
		 */

		driver.findElement(By.xpath(property.getProperty("loc_searchbycity_txt"))).click();

		driver.findElement(By.xpath(property.getProperty("loc_searchbycity_txt"))).sendKeys(City);
		driver.findElement(By.xpath(property.getProperty("loc_searchbycity_txt"))).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(property.getProperty("loc_searchbycity_txt"))).sendKeys(Keys.TAB);
		driver.findElement(By.xpath(property.getProperty("loc_checkindate_txt"))).sendKeys(CheckIn);
		driver.findElement(By.xpath(property.getProperty("loc_checkindate_txt"))).sendKeys(Keys.TAB);
		driver.findElement(By.xpath(property.getProperty("loc_checkoutdate_txt"))).sendKeys(CheckOut);
		driver.findElement(By.xpath(property.getProperty("loc_checkindate_txt"))).sendKeys(Keys.TAB);
		driver.findElement(By.xpath(property.getProperty("loc_search_btn"))).click();
	}

	@Test(priority = 1)
	public void verifyPriceTextUpdate() {
		driver.findElement(By.xpath(property.getProperty("loc_pricetxt_btn"))).click();
		WebElement price = driver.findElement(By.xpath(property.getProperty("loc_pricetxt_btn")));
		Select priceText = new Select(price);
		priceText.selectByValue("INR");

	}
}
