//package com.geniuspage.qa.testcases;
//
//import java.io.IOException;
//import java.sql.Driver;
//
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.openqa.selenium.WebElement;
//import org.testng.annotations.Test;
//
//import com.geniuspage.base.Base;
//import com.geniuspage.dto.Login;
//import com.geniuspage.dto.SmartPixel;
//import com.geniuspage.qa.pages.HomePage;
//import com.geniuspage.qa.pages.LogInPage;
//import com.geniuspage.qa.pages.SmartPixelPage;
//import com.geniuspage.qa.util.ExcelFileUtility;
//import com.geniuspage.qa.util.GlobalUtility;
//
//public class EditSmartPixelTest extends Base {
//
//	private final Logger logger = LogManager.getLogger(EditSmartPixelTest.class);
//	LogInPage loginpage;
//	SmartPixelPage smartPixelPage;
//	HomePage homePage;
//	ExcelFileUtility fileUtil = new ExcelFileUtility();
//	GlobalUtility utility = new GlobalUtility();
//
//	public EditSmartPixelTest() {
//		super();
//
//	}
//
//	public void setup() {
//		logger.debug("In Setup..");
//		initializeBrowser();
//		loginpage = new LogInPage();
//		smartPixelPage = new SmartPixelPage();
//		homePage = new HomePage();
//	}
//
//	@Test(priority = 1)
//	public void TestLogIn() throws IOException, InterruptedException {
//		setup();
//		logger.debug("Logging in...");
//		Login cred = utility.GetLoginCreds().get(0);
//		homePage = loginpage.login(cred);
//		Thread.sleep(8000);
//
//	}
//
//	@Test(priority = 2)
//	public void OpenSmarPixelPage() throws Exception {
//
//		logger.debug("Open SmarPixel page");
//		smartPixelPage = homePage.clickOnSmartPixel();
//		Thread.sleep(5000);
//
//	}
//
//	@Test(priority = 3)
//	public void EditSmlartPxl() throws Exception {
//		SmartPixel oldSmartPixel = null, newSmartPixel = null;
//		Sheet smartPixelDataSheet = fileUtil.readExcel("EditSmartPixel");
//		int rowCount = smartPixelDataSheet.getLastRowNum() - smartPixelDataSheet.getFirstRowNum();
//
//		for (int i = 1; i < rowCount + 1; i++) {
//			oldSmartPixel = new SmartPixel();
//			oldSmartPixel.setPxlName(utility.GetCellValue(smartPixelDataSheet.getRow(i).getCell(0)));
//			oldSmartPixel.setPxlID(utility.GetCellValue(smartPixelDataSheet.getRow(i).getCell(1)));
//			
//			newSmartPixel = new SmartPixel();
//			newSmartPixel.setPxlName(utility.GetCellValue(smartPixelDataSheet.getRow(i).getCell(2)));
//			newSmartPixel.setPxlID(utility.GetCellValue(smartPixelDataSheet.getRow(i).getCell(3)));
//			
//			smartPixelPage.EditSmartPxl(oldSmartPixel, newSmartPixel);
//			Thread.sleep(5000);
//		}
//		driver.quit();
//	}
//}
