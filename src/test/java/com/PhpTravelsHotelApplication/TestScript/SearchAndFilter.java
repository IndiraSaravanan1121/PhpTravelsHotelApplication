package com.PhpTravelsHotelApplication.TestScript;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PhpTravelsHotelApplication.BaseClass.BaseClass;
import com.PhpTravelsHotelApplication.HelperClass.Enter;
import com.PhpTravelsHotelApplication.HelperClass.Scrolling;
import com.PhpTravelsHotelApplication.Report.Report;
import com.PhpTravelsHotelApplication.UtilsClass.ExcelUtils;
import com.PhpTravelsHotelApplication.pages.PhpTravelsHomePage;
import com.PhpTravelsHotelApplication.pages.PhpTravelsValidationPage;
import com.PhpTravelsHotelApplication.pages.ValidatePriceType;
import com.PhpTravelsHotelApplication.pages.ValidationPriceList;

/**
 * Purpose:Validate Price list sorted or not.
 * 
 * @author indira.saravanan
 *
 */

public class SearchAndFilter extends BaseClass {

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
		Enter.actionTab();
		Enter.actionTab();
		Enter.actionTab();
		Enter.actionTab();
		Actions action = new Actions(driver);
		action.sendKeys("chennai");// search by city
		action.sendKeys(Keys.ENTER).build().perform();
		Enter.actionTab();
		PhpTravelsHomePage.checkIn(driver).sendKeys(CheckIn);// sending checkin date from excel
		Enter.actionTab();
		PhpTravelsHomePage.checkOut(driver).sendKeys(CheckOut);// sending checkout date from excel
		Enter.actionTab();
		PhpTravelsHomePage.searchButton(driver).click();// To click search button
 
	}

	//To validate currency type updated or not
	@Test(priority = 1)
	public void verifyPriceTextUpdate() throws Exception {
		

		WebElement priceTxt = PhpTravelsValidationPage.clickPriceText(driver);
		Select priceText = new Select(priceTxt);
		priceText.selectByIndex(7);

		ValidatePriceType.validatePriceType(driver);
		log.LogReport("Currency type changed...");
	}
	
    //To validate price list sorted or not	
	@Test(priority = 2)
	public void ValidateDataFilteredorNot() throws Exception {

		//To click high to low button
		PhpTravelsValidationPage.clickHightoLow(driver).click();
		Scrolling.scroll(driver);
		ValidationPriceList.validationPriceList(driver);//validate price list sorted from high cost to low cost
		log.LogReport("Price List Filtered from High to Low");
		
        ////To click low to high button
		PhpTravelsValidationPage.clickLowtoHigh(driver).click();
		Scrolling.scroll(driver);
		ValidationPriceList.validationPriceList(driver);//validate price list sorted from low cost to high cost
		log.LogReport("Price List Filtered from Low to High");
	}
}
