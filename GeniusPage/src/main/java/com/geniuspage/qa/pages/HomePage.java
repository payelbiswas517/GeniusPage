package com.geniuspage.qa.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.geniuspage.base.Base;

public class HomePage extends Base {
	
	private static final Logger logger = LogManager.getLogger(HomePage.class);
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		logger.debug("Dashboard landed. " + this.getClass().getName());
	}
	
	@FindBy(xpath="//*[@id='navbar-collapse-01']/ul[1]/li[2]/a")
	WebElement smartPixelLink;
	
	public SmartPixelPage clickOnSmartPixel() {
		smartPixelLink.click();
		return new SmartPixelPage();
	}
}
