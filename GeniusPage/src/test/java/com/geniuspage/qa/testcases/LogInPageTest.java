//package com.geniuspage.qa.testcases;
//
//
//import java.io.IOException;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import com.geniuspage.base.Base;
//import com.geniuspage.dto.Login;
//import com.geniuspage.qa.pages.LogInPage;
//import com.geniuspage.qa.util.*;
//
//public class LogInPageTest extends Base {
//
//	LogInPage loginpage;
//	ExcelFileUtility fileUtility = new ExcelFileUtility();
//	GlobalUtility utility = new GlobalUtility();
//
//	public LogInPageTest() {
//		super();
//	}
//
//	@BeforeMethod
//	public void setup() {
//		initializeBrowser();
//		loginpage = new LogInPage();
//	}
//
//	@Test(priority = 1)
//	public void TestLogIn() throws IOException {
//		Login cred = utility.GetLoginCreds().get(0);
//		loginpage.login(cred);
//
//	}
//
//	@AfterMethod
//	public void Shut() {
//
//		driver.quit();
//
//	}
//
//}
