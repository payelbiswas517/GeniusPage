//package com.geniuspage.qa.util;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.concurrent.TimeUnit;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipInputStream;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//import com.geniuspage.qa.config.ConfigUtil;
//
//public class ExtensionUtility extends ConfigUtil {
//
//	static String extensionLocation = null;
//
//	static String unpackedExtensionLocation = null;
//
//	public static void main(String[] args) {
//		try {
//			File file = new File("E:/chromedriver_win32/chromedriver.exe");
//			// logger.debug("Web Driver Path: " + file.getAbsolutePath());
//			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//			WebDriver driver = new ChromeDriver();
//			driver = LoadExtension(driver);
//			driver.manage().window().maximize();
//			driver.manage().deleteAllCookies();
//			driver.manage().timeouts().implicitlyWait(GlobalUtility.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			driver.get("www.google.com");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public static WebDriver LoadExtension(WebDriver driver) throws Exception {
//		// extensionLocation = prop.getProperty("packedExtensionLocation");
//		// unpackedExtensionLocation = prop.getProperty("unpackedExtensionLocation");
//		extensionLocation = "E:/JavaWorkSpace/GeniusPage/Extension";
//
//		File extLoc = new File(extensionLocation);
//		System.out.println("Test " + extLoc.listFiles().length);
//		for (File ext : extLoc.listFiles()) {
//			if (!ext.isDirectory()) {
//				File nf = ext;
//				System.out.println(ext.getName());
//				File zippedExtension = new File(extensionLocation + "/zippedExtension/"
//						+ ext.getName().substring(0, ext.getName().lastIndexOf('.')) + ".zip");
//				System.out.println(zippedExtension.getPath());
//				// zippedExtension.mkdirs();
//				boolean success = nf.renameTo(zippedExtension);
//				if (success) {
//					System.out.println(ext.getName());
//					/*
//					 * ChromeOptions chromeoptions = new ChromeOptions();
//					 * chromeoptions.addArguments("load-extension=E:\\Momentum_v1.16.4"); driver =
//					 * new ChromeDriver(chromeoptions);
//					 */
//				}
//
//			}
//		}
//		return driver;
//	}
//
//	private void UnPackExtension(String CompressedExtentionName) throws Exception {
//		File destDir = new File(unpackedExtensionLocation);
//		byte[] buffer = new byte[1024];
//		ZipInputStream zis = new ZipInputStream(new FileInputStream(CompressedExtentionName));
//		ZipEntry zipEntry = zis.getNextEntry();
//		while (zipEntry != null) {
//			File newFile = newFile(destDir, zipEntry);
//			FileOutputStream fos = new FileOutputStream(newFile);
//			int len;
//			while ((len = zis.read(buffer)) > 0) {
//				fos.write(buffer, 0, len);
//			}
//			fos.close();
//			zipEntry = zis.getNextEntry();
//		}
//		zis.closeEntry();
//		zis.close();
//	}
//
//	private static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
//		File destFile = new File(destinationDir, zipEntry.getName());
//
//		String destDirPath = destinationDir.getCanonicalPath();
//		String destFilePath = destFile.getCanonicalPath();
//
//		if (!destFilePath.startsWith(destDirPath + File.separator)) {
//			throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
//		}
//
//		return destFile;
//	}
//
//	public void handleFiles(File file) {
//		
//		FileInputStream fileInputStream = new FileInputStream(file);
//		long byteLength = file.length(); // byte count of the file-content
//
//		byte[] filecontent = new byte[(int) byteLength];
//		fileInputStream.read(filecontent, 0, (int) byteLength);
//		ArrayList<Integer> buffer = new ArrayList<Integer>();
//		
//		for(int i = 0;i<byteLength;i++) {
//			buffer.add(filecontent[i] & 0xFF);
//		}
//		
//		Integer[] buf = buffer.toArray(new Integer[0]);
//
//		    // 43 72 32 34 (Cr24)
//		    if (buf[0] != 67 || buf[1] != 114 || buf[2] != 50 || buf[3] != 52) {
//		        throw new Error("Invalid header: Does not start with Cr24.");
//		    }
//
//		    // 02 00 00 00
//		    if (buf[4] != 2 || buf[5] != 0 || buf[6] != 0 || buf[7] != 0) {
//		        throw new Error("Unexpected crx format version number.");
//		    }
//
//		    int publicKeyLength = 0 + buf[8] + (buf[9] << 8) + (buf[10] << 16) + (buf[11] << 24);
//		    int signatureLength = 0 + buf[12] + (buf[13] << 8) + (buf[14] << 16) + (buf[15] << 24);
//
//		    // 16 = Magic number (4), CRX format version (4), lengths (2x4)
//		    int header = 16;
//		    int zipStartOffset = header + publicKeyLength + signatureLength;
//
//		    //var zip = buf.slice(zipStartOffset, buf.length);
//		   
//		    = buffer.subList(zipStartOffset, buf.length -1)
//		   
//		    downloadFile(file.name.replace(".crx", ".zip"), [zip]);
//		  }
//		  reader.readAsArrayBuffer(file);
//		}
//
//}
