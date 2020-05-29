package com.geniuspage.qa.config;

import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {

	public static Properties prop;
	public ConfigUtil() {
		prop = new Properties();
		try {
			prop.load(getClass().getResourceAsStream("../config/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
