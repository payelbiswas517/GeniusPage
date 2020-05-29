package com.geniuspage.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.geniuspage.base.Base;

public class ExcelFileUtility extends Base {
	private static final Logger logger = LogManager.getLogger(ExcelFileUtility.class);

	public Sheet readExcel(String sheetName) throws IOException {
		Sheet sheet = null;
		try {
			String filePath = prop.getProperty("testDataLocation") + prop.getProperty("testDataFileName");
			logger.info("Test Data File Path: " + filePath);
			File file = new File(filePath);
			logger.debug("File Size: "+ file.length());
			FileInputStream inputStream = new FileInputStream(file);
			Workbook workBook = null;
			String fileName = prop.getProperty("testDataFileName");
			String fileExtensionName = fileName.substring(fileName.indexOf("."));
			if (fileExtensionName.equals(".xlsx")) {
				workBook = new XSSFWorkbook(inputStream);
			} else if (fileExtensionName.equals(".xls")) {
				workBook = new HSSFWorkbook(inputStream);
			}
			sheet = workBook.getSheet(sheetName);
			logger.info("Sheet Name:" + sheetName);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
		}
		return sheet;
	}
}
