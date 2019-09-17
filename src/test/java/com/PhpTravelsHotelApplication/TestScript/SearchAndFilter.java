package com.PhpTravelsHotelApplication.TestScript;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PhpTravelsHotelApplication.Constants.Constants;
import com.PhpTravelsHotelApplication.HelperClass.ActionClass;
import com.PhpTravelsHotelApplication.HelperClass.Scrolling;
import com.PhpTravelsHotelApplication.Report.Report;
import com.PhpTravelsHotelApplication.UtilsClass.ExcelUtils;
import com.PhpTravelsHotelApplication.pages.PhpTravelsHomePage;
import com.PhpTravelsHotelApplication.pages.PhpTravelsValidationPage;
import com.PhpTravelsHotelApplication.pages.ValidatePriceType;
import com.PhpTravelsHotelApplication.pages.ValidationPriceList;
import com.PhpTravelsHotelApplication.Report.ExtendReport;

/**
 * Purpose:Validate Price list sorted or not.
 * 
 * @author indira.saravanan
 */

public class SearchAndFilter extends ExtendReport {

	Report log = new Report();

	// It read test data from excel sheet.
	@DataProvider
	public Object[][] searchDetails() {
		Object data[][] = ExcelUtils.ReadWriteExcel("Sheet1");
		return data;
	}

	// To search hotel
	@Test(dataProvider = "searchDetails", priority = 0)
	public void getSearchDetails(String CheckIn, String CheckOut) throws Exception {
		PhpTravelsHomePage.seacrhHotel(driver).click();
		ActionClass.actionTab();
		ActionClass.actionTab();
		ActionClass.actionTab();
		ActionClass.actionTab();
		ActionClass.sendKeys("chennai");
	    Thread.sleep(2000);
	    ActionClass.actionTab();
		PhpTravelsHomePage.checkIn(driver).sendKeys(CheckIn);// sending checkin date from excel
		ActionClass.actionTab();
		PhpTravelsHomePage.checkOut(driver).sendKeys(CheckOut);// sending checkout date from excel
		ActionClass.actionTab();
		PhpTravelsHomePage.searchButton(driver).click();// To click search button
		test=extent.createTest("getSearchDetails");

	}

	// To validate currency type updated or not
	@Test(priority = 1)
	public void verifyPriceTextUpdate() throws Exception {
		test=extent.createTest("verifyPriceTextUpdate");
		fis = new FileInputStream(Constants.location_path);
		property.load(fis);
		WebElement currency = PhpTravelsValidationPage.clickCurrency(driver);
		ActionClass.mouseOver(currency);
		driver.findElement(By.xpath(property.getProperty("loc_clickinr_btn"))).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ValidatePriceType.validatePriceType(driver);
		log.LogReport("Currency type changed...");
	}

	// To validate price list sorted or not
	@Test(priority = 2)
	public void validateDataFilteredorNot() throws Exception {
		test=extent.createTest("validateDataFilteredorNot");

		// To click high to low button
		PhpTravelsValidationPage.clickHightoLow(driver).click();
		Scrolling.scroll(driver);
		ValidationPriceList.validationPriceList(driver);// validate price list sorted from high cost to low cost
		log.LogReport("Price List Filtered from High to Low");

		// To click low to high button
		PhpTravelsValidationPage.clickLowtoHigh(driver).click();
		Scrolling.scroll(driver);
		ValidationPriceList.validationPriceList(driver);// validate price list sorted from low cost to high cost
		log.LogReport("Price List Filtered from Low to High");
	}
}
