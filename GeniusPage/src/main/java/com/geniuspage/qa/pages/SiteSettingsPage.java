package com.geniuspage.qa.pages;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByXPath;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.geniuspage.base.Base;
import com.geniuspage.dto.SiteSetting;
import com.geniuspage.dto.SmartPixel;
import com.geniuspage.qa.util.ExcelFileUtility;
import com.geniuspage.qa.util.GlobalUtility;

public class SiteSettingsPage extends Base {
	private static final Logger logger = LogManager.getLogger(SiteSettingsPage.class);
	ExcelFileUtility fileUtil = new ExcelFileUtility();
	GlobalUtility utility = new GlobalUtility();

	public SiteSettingsPage() {
		PageFactory.initElements(driver, this);
		logger.info("Dashboard landed. " + this.getClass().getName());
	}

	@FindBy(id = "s2id_smart_pixel_site")
	WebElement smartpixel;

	@FindBy(id = "saveSiteSettingsButton")
	WebElement siteSettingsSubmitBtn;

	public void ConfSiteSettings(SiteSetting siteSetting) throws Exception {
		try {
			WebElement element = driver.findElement(
					By.xpath("//*/div[@data-site-name='" + siteSetting.getSiteName() + "']/div[2]/div/a[2]"));
			element.click();
			logger.debug(element.getText());
			smartpixel.click();
			List<WebElement> siteSmartpixel = (driver.findElements(By.xpath("//*[@id='select2-drop']/ul/li")));
			for (WebElement element1 : siteSmartpixel) {
				logger.debug(element1.getText() + " " + element1.getTagName());
				if (element1.getText().equals(siteSetting.getSmartPixelName())) {
					logger.debug("Matched...");
					element1.click();
				}
			}

			
			Thread.sleep(3000);
			siteSettingsSubmitBtn.click();
		} catch (Exception e) {
			logger.error(e.getStackTrace());
		}
	}
}
