package com.vtiger.genericutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mysql.cj.xdevapi.JsonParser;

public class JsonFile {

	public String getDataFromJsonFile(String key) throws IOException, ParseException {

		FileReader fr = new FileReader("./configdata/commondata.json");
		JSONParser jparser = new JSONParser();
		Object obj = jparser.parse(fr);
		JSONObject jobj = (JSONObject) obj;
		String data = jobj.get(key).toString();
		return data;

	}
}
