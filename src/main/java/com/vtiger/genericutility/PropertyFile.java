package com.vtiger.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {

	public String getFileFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./configdata/common.properties");
		Properties obj = new Properties();
		obj.load(fis);
		String data = obj.getProperty(key);
		return data;
	}

}
