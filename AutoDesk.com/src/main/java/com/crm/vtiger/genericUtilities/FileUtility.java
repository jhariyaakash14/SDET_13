package com.crm.vtiger.genericUtilities;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 * methdos to read data from property file and json file
 * @author Akash Jhariya
 *
 */
public class FileUtility {

	 /**
	  * This method used to read data from properties and return the value based on key specified
	  * @param key
	  * @return value
	  * @throws Throwable
	  */
	 public String getPropertyKeyValue(String key) throws Throwable {
	  FileInputStream pfile=new FileInputStream(IPathConstant.PROPERTY_FILEPATH);
	  Properties prop=new Properties();
	  prop.load(pfile);
	  return prop.getProperty(key);
	 }
	 
	 /**
	  * this method is to read date form json file and return the value based on key provided
	  * @param jsonKey
	  * @return value
	  * @throws Throwable
	  */
	 public String getDataFromJson(String jsonKey) throws Throwable {
	  FileReader reader=new FileReader(IPathConstant.JSONFILEPATH);
	  JSONParser parser=new JSONParser();
	  Object object = parser.parse(reader);
	  JSONObject jsonObject = (JSONObject)object;
	  String value=jsonObject.get(jsonKey).toString();
	  return value;
	 }

	}


