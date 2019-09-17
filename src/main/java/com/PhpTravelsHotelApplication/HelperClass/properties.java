package com.PhpTravelsHotelApplication.HelperClass;

import java.io.FileInputStream;
import java.util.Properties;

public class properties {
	static FileInputStream fis;
	static Properties property = new Properties();

	public static FileInputStream property(String path) throws Exception {
		fis = new FileInputStream(path);
		property.load(fis);
		return fis;
	}

}
