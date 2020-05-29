package com.geniuspage.qa.pages;

import java.io.IOException;
import java.util.List;

import javax.swing.text.TabExpander;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.geniuspage.base.Base;
import com.geniuspage.dto.SmartPixel;
import com.geniuspage.qa.util.ExcelFileUtility;
import com.geniuspage.qa.util.GlobalUtility;

public class SmartPixelPage extends Base {
	private static final Logger logger = LogManager.getLogger(SmartPixelPage.class);
	ExcelFileUtility fileUtil = new ExcelFileUtility();
	GlobalUtility utility = new GlobalUtility();

	public SmartPixelPage() {
		PageFactory.initElements(driver, this);
		logger.info("Dashboard landed. " + this.getClass().getName());
	}

	@FindBy(id = "openCreatePixelModal")
	WebElement addSmartPxlBtn;

	@FindBy(id = "pixelProviderId")
	WebElement pixelProvider;

	@FindBy(id = "pixelName")
	WebElement pixelName;

	@FindBy(id = "pixelId")
	WebElement pixelId;

	@FindBy(id = "buttonCreateSmartPixel")
	WebElement btnCreateSmartPxl;

	@FindBy(xpath = "//*[@id='smartPixelsTable']/tbody")
	WebElement pxlTable;

	@FindBy(id = "deleteSmartPixelButton")
	WebElement btnDltSmartPxl;

	public void addNewSmartPxl(SmartPixel smartPixel) throws Exception {
		addSmartPxlBtn.click();
		Select SmartpixelProvider = new Select(pixelProvider);
		SmartpixelProvider.selectByVisibleText("Facebook");
		pixelName.sendKeys(smartPixel.getPxlName());
		pixelId.sendKeys(smartPixel.getPxlID());
		Thread.sleep(3000);
		btnCreateSmartPxl.click();

	}

	public void DeleteSmartPxl(SmartPixel smartPixel) {
		try {
			logger.debug("Pixel Name: " + smartPixel.getPxlName() + "\n");
			List<WebElement> tableRows = pxlTable.findElements(By.tagName("tr"));
			for (WebElement tableRow : tableRows) {
				logger.debug("Row Name: " + tableRow.getText() + "\n");
				List<WebElement> columns = tableRow.findElements(By.tagName("td"));
				for (WebElement column : columns) {
					logger.debug("Column Name: " + column.getText());
					if ((column.getText()).equals(smartPixel.getPxlName())) {
						logger.debug("Pixel Matched");
						WebElement element = tableRow.findElement(By.xpath(
								"//*/i[@data-id='" + columns.get(0).getText() + "'][@data-original-title='Delete']"));
						element.click();
						btnDltSmartPxl.click();
					} else {
						logger.debug("Not Matched");
					}
				}
			}
		} catch (Exception ex) {
			logger.error(ex.toString());
		}
	}

	public void EditSmartPxl(SmartPixel oldSmartPixel, SmartPixel newSmartPixel) {
		try {
			logger.debug("Pixel Name: " + oldSmartPixel.getPxlName() + "\n");

			List<WebElement> tableRows = pxlTable.findElements(By.tagName("tr"));
			for (WebElement tableRow : tableRows) {
				logger.debug("Row Name: " + tableRow.getText() + "\n");
				List<WebElement> columns = tableRow.findElements(By.tagName("td"));
				for (WebElement column : columns) {
					logger.debug("Coumn Name: " + column.getText());
					if ((column.getText()).equals(oldSmartPixel.getPxlName())) {
						logger.debug("Pixel Matched");
						WebElement element = tableRow.findElement(By.xpath(
								"//*/i[@data-id='" + columns.get(0).getText() + "'][@data-original-title='Edit']"));
						// logger.debug("Element Name: " + element.getAttribute("data-id"));
						element.click();
						Thread.sleep(2000);
						if (newSmartPixel.getPxlName() != ""
								&& newSmartPixel.getPxlName() != oldSmartPixel.getPxlName()) {
							pixelName.clear();
							pixelName.sendKeys(newSmartPixel.getPxlName());
						}
							
						if (newSmartPixel.getPxlID() != "" && newSmartPixel.getPxlID() != oldSmartPixel.getPxlID()) {
							pixelId.clear();
							pixelId.sendKeys(newSmartPixel.getPxlID());
						}
							
						btnCreateSmartPxl.click();
						// btnDltSmartPxl.click();
					} else {
						logger.debug("Not Matched");
					}
				}
				// logger.debug(pixelName + "Deleted. Waiting...\n\n");
				// Thread.sleep(5000);
			}

		} catch (

		Exception ex) {
			logger.error(ex.toString());
		}
	}

}
