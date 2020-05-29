
/*
 * package com.geniuspage.qa.testcases;
 * 
 * import java.io.IOException;
 * 
 * import org.apache.log4j.LogManager; import org.apache.log4j.Logger; import
 * org.apache.poi.ss.usermodel.Sheet; import org.testng.annotations.Test;
 * 
 * import com.geniuspage.base.Base; import com.geniuspage.dto.Login; import
 * com.geniuspage.dto.SiteSetting; import com.geniuspage.qa.pages.HomePage;
 * import com.geniuspage.qa.pages.LogInPage; import
 * com.geniuspage.qa.pages.SiteSettingsPage; import
 * com.geniuspage.qa.util.ExcelFileUtility; import
 * com.geniuspage.qa.util.GlobalUtility;
 * 
 * public class SiteSettingConfigurationTest extends Base { private final Logger
 * logger = LogManager.getLogger(SiteSettingConfigurationTest.class); LogInPage
 * loginpage; HomePage homePage; SiteSettingsPage siteSettingsPage;
 * ExcelFileUtility fileUtil = new ExcelFileUtility(); GlobalUtility utility =
 * new GlobalUtility();
 * 
 * public SiteSettingConfigurationTest() { super();
 * 
 * }
 * 
 * public void setup() { logger.debug("In Setup.."); initializeBrowser();
 * loginpage = new LogInPage(); siteSettingsPage = new SiteSettingsPage();
 * homePage = new HomePage(); }
 * 
 * @Test(priority = 1) public void TestLogIn() throws IOException,
 * InterruptedException { setup(); logger.debug("Logging in..."); Login cred =
 * utility.GetLoginCreds().get(0); homePage = loginpage.login(cred);
 * Thread.sleep(8000);
 * 
 * }
 * 
 * @Test(priority = 2) public void SiteSettings() throws Exception {
 * 
 * logger.debug("Open SiteSettings page"); SiteSetting siteSetting = null; Sheet
 * SiteSettingDataSheet = fileUtil.readExcel("SiteSetting"); int rowCount =
 * SiteSettingDataSheet.getLastRowNum() - SiteSettingDataSheet.getFirstRowNum();
 * for (int i = 1; i < rowCount + 1; i++) { siteSetting = new SiteSetting();
 * siteSetting.setSiteName(utility.GetCellValue(SiteSettingDataSheet.getRow(i).
 * getCell(0)));
 * siteSetting.setSmartPixelName(utility.GetCellValue(SiteSettingDataSheet.
 * getRow(i).getCell(1))); siteSettingsPage.ConfSiteSettings(siteSetting);
 * Thread.sleep(5000);
 * 
 * } driver.quit(); } }
 */