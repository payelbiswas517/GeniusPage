package com.geniuspage.base;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.geniuspage.qa.config.ConfigUtil;
import com.geniuspage.qa.util.*;

public class Base extends ConfigUtil {

	public static WebDriver driver;
	//static ExtensionUtility extensionUtility;
	
	private static final Logger logger = LogManager.getLogger(Base.class);

	public Base() {
		try {
			
			// ******************************Logger_Configuration**********************************
			// BasicConfigurator.configure(); /*Uncomment this to log in console*/
			URL log4jPropertyFileResource = getClass().getResource("../config/log4j.properties");
			File log4jPropertyFile = Paths.get(log4jPropertyFileResource.toURI()).toFile();
			String log4jPropertyFilePath = log4jPropertyFile.getAbsolutePath();
			
			//logger.debug("Log4j Property File: " + log4jPropertyFilePath);
			PropertyConfigurator.configure(log4jPropertyFilePath);
			// *****************************************************************************
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
		}
	}

	public static void initializeBrowser() {
		try {
			String browserName = prop.getProperty("browser");
			logger.info("Selected Browser:" + browserName);
			if (browserName.equals("chrome") || browserName.equals("ie") || browserName.equals("mozila")) {
				logger.debug("Web Driver Location: " + prop.getProperty("webDriverLoc"));
				File file = new File(prop.getProperty("webDriverLoc"));
				logger.debug("Web Driver Path: " + file.getAbsolutePath());
				System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
				driver = new ChromeDriver();
				
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(GlobalUtility.IMPLICIT_WAIT, TimeUnit.SECONDS);
				driver.get(prop.getProperty("url"));
			} else {
				String msg = "Invalid Browser Name. Please check config.properties for the correct browser name";
				logger.info(msg);
				System.out.println(msg);
			}
		} catch (Exception e) {
			logger.error(e.getStackTrace());
			e.printStackTrace();
		}
	}
}
