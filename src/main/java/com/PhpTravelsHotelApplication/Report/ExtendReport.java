package com.PhpTravelsHotelApplication.Report;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.Exception;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.PhpTravelsHotelApplication.BaseClass.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReport extends BaseClass{
	ExtentHtmlReporter htmlReporter;
	protected ExtentReports extent;
	protected ExtentTest test;

	@BeforeMethod
	public void tearDown(ITestResult result) throws Exception {

		htmlReporter = new ExtentHtmlReporter("Extend.html");
		htmlReporter.config().setDocumentTitle("Automation Report-Php Travels");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "windows10");
		extent.setSystemInfo("browser", "chrome");

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName());
			test.log(Status.INFO, "TEST CASE FAILED IS " + result.getThrowable());

			String screenshotPath = ExtendReport.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "TEST CASE SKIPPED IS " + result.getName());
			test.log(Status.INFO, "TEST CASE SKIPPED IS " + result.getThrowable());
			String screenshotPath = ExtendReport.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "TEST CASE PASSED IS " + result.getName());
			test.log(Status.INFO, "TEST CASE PASSED IS " + result.getThrowable());
			String screenshotPath = ExtendReport.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
		}
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = "./screenshot" + screenshotName + date + ".png";
		File Destination = new File(destination);
		FileUtils.copyFile(source, Destination);
		return destination;
}

	@AfterMethod
	public void endReport() {
		extent.flush();
	}
}
