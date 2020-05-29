//package com.geniuspage.qa.testcases;
//
//import java.io.IOException;
//
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
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
//
//	public class AddSmartPixelTest extends Base {
//		private final Logger logger = LogManager.getLogger(AddSmartPixelTest.class);
//		LogInPage loginpage;
//		SmartPixelPage smartPixelPage;
//		HomePage homePage;
//		ExcelFileUtility fileUtil = new ExcelFileUtility();
//		GlobalUtility utility = new GlobalUtility();
//	
//		public AddSmartPixelTest() {
//			super();
//			
//		}
//	
//		
//		public void setup() {
//			logger.debug("In Setup..");
//			initializeBrowser();
//			loginpage = new LogInPage();
//			smartPixelPage = new SmartPixelPage();
//			homePage = new HomePage();
//		}
//	
//		@Test(priority = 1)
//		public void TestLogIn() throws IOException, InterruptedException {
//			setup();
//			logger.debug("Logging in...");
//			Login cred = utility.GetLoginCreds().get(0);
//			homePage = loginpage.login(cred);
//			Thread.sleep(8000);
//	
//		}
//	
//		@Test(priority = 2)
//		public void OpenSmarPixelPage() throws Exception {
//	        
//			logger.debug("Open SmarPixel page");
//			smartPixelPage = homePage.clickOnSmartPixel();  
//			Thread.sleep(5000);
//	
//		}
//	
//		@Test(priority = 3)
//		public void AddSmartPxl() throws Exception {
//	
//			SmartPixel smartPixel = null;
//			Sheet smartPixelDataSheet = fileUtil.readExcel("AddSmartPixel");
//			int rowCount = smartPixelDataSheet.getLastRowNum() - smartPixelDataSheet.getFirstRowNum();
//	
//			for (int i = 1; i < rowCount + 1; i++) {
//				Row row = smartPixelDataSheet.getRow(i);
//				smartPixel = new SmartPixel();
//				smartPixel.setPxlName(utility.GetCellValue(row.getCell(0)));
//				smartPixel.setPxlID(utility.GetCellValue(row.getCell(1)));
//				smartPixelPage.addNewSmartPxl(smartPixel);
//				Thread.sleep(5000);
//				
//			}
//	       driver.quit();
//		}
//	}
//
//
