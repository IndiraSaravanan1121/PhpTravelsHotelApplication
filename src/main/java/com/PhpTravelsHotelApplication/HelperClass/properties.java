package com.PhpTravelsHotelApplication.HelperClass;

import java.io.FileInputStream;
import java.util.Properties;


public class properties {
	
	public static void properties(String path) throws Exception {
		
		FileInputStream fis =new FileInputStream(path);
		
		Properties property = new Properties();
		
		property.load(fis);
	}

}