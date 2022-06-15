package com.nexsoft.cicool;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.SystemProperties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLoginFunction {
	
protected WebDriver driver;
private JavascriptExecutor jsExe;

	public void delayMS(int inInt) {
		try {
			Thread.sleep(inInt);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String screenShot() {
	File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String waktu = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	String fileName = "D:\\TugasLogin\\Screenshot\\" + waktu + ".png";
	File screenshot = new File(fileName);
	try {
		FileUtils.copyFile(srcFile, screenshot);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return fileName;
}
	
	@BeforeTest
	public void init() {
		System.setProperty("url", "http://localhost/cicool/");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(System.getProperty("url"));
		driver.manage().window().maximize();
		jsExe = (JavascriptExecutor) driver;

	}
	
	@BeforeMethod
	public void cekSession() {
		driver.get(System.getProperty("url"));
		
		//cek session user sudah login atau belum
	
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		
//		home.clickSignIn().loginValidUser("yunindanin@gmail.com", "123456");
//			
//		driver.get(System.getProperty("url"));
//
//		home.logout();
	}
	
	@Test (priority = 1)
	public void testLoginWithValidUserAndPassword() {
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		
		Dashboard dash =home.clickSignIn().loginValidUser("yunindanin@gmail.com", "123456");
		
		delayMS(500);
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);
		
		Assert.assertEquals(dash.getUsername(), "Yunindanin");
	}
	
	@Test (priority = 2)
	public void testLoginWithValidUserAndInvalidPassword() {
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.logout();
		SignInPage signin = home.clickSignIn();
		
		Dashboard dashboard = signin.loginValidUser("yunindanin@gmail.com", "123");
		
		delayMS(500);
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);
		
		Assert.assertEquals(signin.getErrorPassword(), "E-mail Address and Password do not match.");


		try {
		dashboard.getUsername();
		}catch (Exception e) {
			assertTrue(true,"Text Tidak ditemukan " + e.getMessage());
		}
			
	}
	
	@Test (priority = 3)
	public void testLoginWithInvalidUserAndValidPassword() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);

		SignInPage signin = home.clickSignIn();
		
		Dashboard dashboard = signin.loginValidUser("yunindaaaa@gmail.com", "123456");
		
		delayMS(500);
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);
		
		Assert.assertEquals(signin.getErrorUsername(), "User does not exist");


		try {
		dashboard.getUsername();
		}catch (Exception e) {
			assertTrue(true,"Text Tidak ditemukan " + e.getMessage());
		}
		
		
	}
	
	@Test (priority = 4)
	public void testLoginWithEmptyUserAndPassword() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);

		SignInPage signin = home.clickSignIn();
		
		Dashboard dashboard = signin.loginValidUser("", "");
		
		delayMS(500);
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);
		
		Assert.assertEquals(signin.getErrorEmpty(), "The Username field is required.");

		try {
		dashboard.getUsername();
		}catch (Exception e) {
			assertTrue(true,"Text Tidak ditemukan " + e.getMessage());
		}
		
		
	}

	
	@Test (priority = 5)
	public void testLoginForgotPassword() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);

		SignInPage signin = home.clickSignIn();	
		
		home.forgotPassword();
		
		delayMS(500);
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);
			
	}
}
