package com.geniuspage.qa.testcases;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.Test;

import com.geniuspage.base.Base;
import com.geniuspage.dto.Login;
import com.geniuspage.dto.PublishSite;
import com.geniuspage.dto.SiteSetting;
import com.geniuspage.qa.pages.HomePage;
import com.geniuspage.qa.pages.LogInPage;
import com.geniuspage.qa.pages.PublishSitePage;
import com.geniuspage.qa.pages.SiteSettingsPage;
import com.geniuspage.qa.util.ExcelFileUtility;
import com.geniuspage.qa.util.GlobalUtility;

public class PublishSiteTest extends Base {
	private final Logger logger = LogManager.getLogger(PublishSiteTest.class);
	LogInPage loginpage;
	HomePage homePage;
	SiteSettingsPage siteSettingsPage;
	PublishSitePage publishSitePage;
	ExcelFileUtility fileUtil = new ExcelFileUtility();
	GlobalUtility utility = new GlobalUtility();

	public PublishSiteTest() {
		super();

	}

	public void setup() {
		logger.debug("In Setup..");
		initializeBrowser();
		loginpage = new LogInPage();
		siteSettingsPage = new SiteSettingsPage();
		publishSitePage= new PublishSitePage();
		homePage = new HomePage();
	}

	@Test(priority = 1)
	public void TestLogIn() throws IOException, InterruptedException {
		setup();
		logger.debug("Logging in...");
		Login cred = utility.GetLoginCreds().get(0);
		homePage = loginpage.login(cred);
		Thread.sleep(5000);

	}

	@Test(priority = 2)
	public void SiteSettings() throws Exception {

		logger.debug("Open SiteSettings page");
		PublishSite publishSite = null;
		Sheet PublishSiteDataSheet = fileUtil.readExcel("PublishSite");
		int rowCount = PublishSiteDataSheet.getLastRowNum() - PublishSiteDataSheet.getFirstRowNum();
		for (int i = 1; i < rowCount + 1; i++) {
			publishSite = new PublishSite();
			publishSite.setSiteName(utility.GetCellValue(PublishSiteDataSheet.getRow(i).getCell(0)));
			publishSite.setPublishingOption(utility.GetCellValue(PublishSiteDataSheet.getRow(i).getCell(1)));
			publishSite.setSitePublishName(utility.GetCellValue(PublishSiteDataSheet.getRow(i).getCell(2)));
			publishSitePage.PublishSiteConf(publishSite);
			Thread.sleep(5000);

		}
		//driver.quit();
	}
}

