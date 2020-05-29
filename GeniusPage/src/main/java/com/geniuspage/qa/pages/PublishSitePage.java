package com.geniuspage.qa.pages;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.geniuspage.base.Base;
import com.geniuspage.dto.PublishSite;
import com.geniuspage.dto.SiteSetting;
import com.geniuspage.qa.util.ExcelFileUtility;
import com.geniuspage.qa.util.GlobalUtility;

public class PublishSitePage extends Base {
	private static final Logger logger = LogManager.getLogger(PublishSitePage.class);
	ExcelFileUtility fileUtil = new ExcelFileUtility();
	GlobalUtility utility = new GlobalUtility();

	public PublishSitePage() {
		PageFactory.initElements(driver, this);
		logger.info("Dashboard landed. " + this.getClass().getName());
	}

	@FindBy(id = "s2id_smart_pixel_site")
	WebElement smartpixel;

	@FindBy(id = "saveSiteSettingsButton")
	WebElement siteSettingsSubmitBtn;
	
	@FindBy(id ="s2id_select_hostingOptions")
	WebElement chooseOption;
	
	public void PublishSiteConf(PublishSite publishSite) throws Exception {
		try {
			WebElement element = driver.findElement(
					By.xpath("//*/div[@data-site-name='" + publishSite.getSiteName() + "']/div[2]/div/a[2]"));
			element.click();
			Thread.sleep(8000);
			logger.debug(chooseOption.getText());
			chooseOption.click();		
		    List<WebElement> optionList= (driver.findElements(By.xpath("//*[@id='select2-drop']/ul/li")));
		    //String xx = null;
	        for(WebElement element2:optionList) {
	        	logger.debug("Options: "+element2.getText());
	        	if(element2.getText().equals(publishSite.getPublishingOption())) {
	        		//logger.debug("Selected Option: "+element2.getText());
	        		//element2.getText();
	        		element2.click();
	        		break;
	        	}
	        	
	        	Thread.sleep(500);
        		//logger.debug("Textbox Id: "+"section_"+xx.toLowerCase().replace(" ", ""));
        		//WebElement element3 = driver.findElement(By.id("section_"+xx.toLowerCase().replace(" ", "")));
        		//element3.sendKeys(publishSite.getSitePublishName());
	        }
			Thread.sleep(3000);
			//siteSettingsSubmitBtn.click();
		} catch (Exception e) {
			logger.error(e.toString());
		}
	}
}
