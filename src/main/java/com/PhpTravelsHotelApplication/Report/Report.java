package com.PhpTravelsHotelApplication.Report;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.lf5.LogRecordFilter;

import com.PhpTravelsHotelApplication.Constants.Constants;

public class Report {
	Logger logger = null;

	public void LogReport(String message) {
		PropertyConfigurator.configure(Constants.log_path);
		logger = Logger.getLogger(LogRecordFilter.class.getName());
		logger.info(message);
	}

}
