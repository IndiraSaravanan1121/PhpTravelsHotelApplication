package com.PhpTravelsHotelApplication.HelperClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	
		public static void explicitWait(WebDriver driver,String xpath)
		{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement element;
		element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		element.click();
		}
	}


