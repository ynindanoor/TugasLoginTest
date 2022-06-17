package com.nexsoft.examweek4;

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

public class TestRegisterAndLogin {
	
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
	String fileName = "D:\\ExamWeek4\\Screenshot\\" + waktu + ".png";
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
		System.setProperty("url", "https://petstore.octoperf.com/");
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
			
	}
	
	@Test (priority = 0)
	public void testButtonEnterTheStore() {
		FrontPage front = PageFactory.initElements(driver, FrontPage.class);
		
		HomePage home =front.clickbtnEnterTheStore();
		
		delayMS(2000);
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);
	}
	
	@Test (priority = 1)
	public void testButtonSignIn() {
		FrontPage front = PageFactory.initElements(driver, FrontPage.class);
		
		HomePage home =front.clickbtnEnterTheStore();
		
		SignInPage signin = home.clickbtnSignIn();
		
		delayMS(2000);
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);
	}
	
	@Test (priority = 2)
	public void testButtonRegisterNow() {
		FrontPage front = PageFactory.initElements(driver, FrontPage.class);	

		HomePage home =front.clickbtnEnterTheStore();
		
		SignInPage signin = home.clickbtnSignIn();
		
		RegisterPage register = signin.clickbtnRegister();
		
		delayMS(2000);
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);
		
	}
	
	@Test (priority = 3)
	public void testRegisterWithValidUserInformation() {
		FrontPage front = PageFactory.initElements(driver, FrontPage.class);	

		HomePage home =front.clickbtnEnterTheStore();
		
		SignInPage signin = home.clickbtnSignIn();
		
		RegisterPage register = signin.clickbtnRegister();

		register.validRegister("yuninda.i", "12345","12345","Yuninda","Indahsari","yuninda@gmail.com","089999999","Wisma","Kantor","Tangerang","Banten","1234","Indonesia");
		
		delayMS(2000);
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);
		
	}
	
	@Test (priority = 4)
	public void testRegisterUserIdYangSudahTerdaftar() {
		FrontPage front = PageFactory.initElements(driver, FrontPage.class);	

		HomePage home =front.clickbtnEnterTheStore();
		
		SignInPage signin = home.clickbtnSignIn();
		
		RegisterPage register = signin.clickbtnRegister();

		register.validRegister("yuninda.i", "12345","12345","Yuninda","Indahsari","yuninda@gmail.com","089999999","Wisma","Kantor","Tangerang","Banten","1234","Indonesia");
		
		delayMS(2000);
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);
		
	}
	
	@Test (priority = 4)
	public void testRegisterEmailYangSudahTerdaftar() {
		FrontPage front = PageFactory.initElements(driver, FrontPage.class);	

		HomePage home =front.clickbtnEnterTheStore();
		
		SignInPage signin = home.clickbtnSignIn();
		
		RegisterPage register = signin.clickbtnRegister();

		register.validRegister("yuninda.in", "12345","12345","Yuninda","Indahsari","yuninda@gmail.com","089999999","Wisma","Kantor","Tangerang","Banten","1234","Indonesia");
		
		delayMS(2000);
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);
		
	}
	
	@Test (priority = 5)
	public void testLoginWithValidUserAndPassword() {
		FrontPage front = PageFactory.initElements(driver, FrontPage.class);	

		HomePage home =front.clickbtnEnterTheStore();
		
		SignInPage signin = home.clickbtnSignIn();
		
		WelcomePage welcome =signin.loginValidUser("yuninda.indahsari", "12345");
		
		delayMS(2000);
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);
		
		Assert.assertEquals(welcome.getWelcomeContent(), "Welcome Yuninda!");
		
		welcome.clickbtnLogOut();

	}
	
	
	@Test (priority = 6)
	public void testLoginWithValidUserAndInvalidPassword() {
		FrontPage front = PageFactory.initElements(driver, FrontPage.class);	

		WelcomePage welcome = PageFactory.initElements(driver, WelcomePage.class);
		
		HomePage home =front.clickbtnEnterTheStore();
		
		SignInPage signin = home.clickbtnSignIn();
		
		signin.loginValidUser("yuninda.indahsari", "123");
		
		delayMS(500);
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);
		
		Assert.assertEquals(signin.getErrorPassword(), "Invalid username or password. Signon failed.");


		try {
			signin.getErrorPassword();
		}catch (Exception e) {
			assertTrue(true,"Text Tidak ditemukan " + e.getMessage());
		}
			
	}
	
	@Test (priority = 7)
	public void testLoginWithInvalidUserAndValidPassword() {
		FrontPage front = PageFactory.initElements(driver, FrontPage.class);	

		WelcomePage welcome = PageFactory.initElements(driver, WelcomePage.class);
		
		HomePage home =front.clickbtnEnterTheStore();
		
		SignInPage signin = home.clickbtnSignIn();
		
		signin.loginValidUser("yunind44444@", "12345");
		
		delayMS(500);
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);
		
		Assert.assertEquals(signin.getErrorUsername(), "Invalid username or password. Signon failed.");


		try {
			signin.getErrorUsername();
		}catch (Exception e) {
			assertTrue(true,"Text Tidak ditemukan " + e.getMessage());
		}
			
	}
	
	@Test (priority = 8)
	public void testLoginWithInvalidUserAndInvalidPassword() {
		FrontPage front = PageFactory.initElements(driver, FrontPage.class);	

		WelcomePage welcome = PageFactory.initElements(driver, WelcomePage.class);
		
		HomePage home =front.clickbtnEnterTheStore();
		
		SignInPage signin = home.clickbtnSignIn();
		
		signin.loginValidUser("yunind44444@", "123456789000000");
		
		delayMS(500);
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);
		
		Assert.assertEquals(signin.getErrorBoth(), "Invalid username or password. Signon failed.");


		try {
			signin.getErrorBoth();
		}catch (Exception e) {
			assertTrue(true,"Text Tidak ditemukan " + e.getMessage());
		}
			
	}
	
	@Test (priority = 9)
	public void testLoginWithEmptyUserAndEmptyPassword() {
		FrontPage front = PageFactory.initElements(driver, FrontPage.class);	

		WelcomePage welcome = PageFactory.initElements(driver, WelcomePage.class);
		
		HomePage home =front.clickbtnEnterTheStore();
		
		SignInPage signin = home.clickbtnSignIn();
		
		signin.loginValidUser("", "");
		
		delayMS(500);
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);
		
		Assert.assertEquals(signin.getErrorEmpty(), "Please enter your username and password.");


		try {
			signin.getErrorEmpty();
		}catch (Exception e) {
			assertTrue(true,"Text Tidak ditemukan " + e.getMessage());
		}
			
	}
	
	@Test (priority = 10)
	public void testLoginWithValidUserAndEmptyPassword() {
		FrontPage front = PageFactory.initElements(driver, FrontPage.class);	

		WelcomePage welcome = PageFactory.initElements(driver, WelcomePage.class);
		
		HomePage home =front.clickbtnEnterTheStore();
		
		SignInPage signin = home.clickbtnSignIn();
		
		signin.loginValidUser("yuninda.indahsari", "");
		
		delayMS(500);
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);
		
		Assert.assertEquals(signin.getErrorEmptyPassw(), "Please enter your username and password.");


		try {
			signin.getErrorEmptyPassw();
		}catch (Exception e) {
			assertTrue(true,"Text Tidak ditemukan " + e.getMessage());
		}
			
	}
	
	@Test (priority = 10)
	public void testLoginWithEmptyUserAndValidPassword() {
		FrontPage front = PageFactory.initElements(driver, FrontPage.class);	

		WelcomePage welcome = PageFactory.initElements(driver, WelcomePage.class);
		
		HomePage home =front.clickbtnEnterTheStore();
		
		SignInPage signin = home.clickbtnSignIn();
		
		signin.loginValidUser("", "12345");
		
		delayMS(500);
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);
		
		Assert.assertEquals(signin.getErrorEmptyUser(), "Please enter your username and password.");


		try {
			signin.getErrorEmptyUser();
		}catch (Exception e) {
			assertTrue(true,"Text Tidak ditemukan " + e.getMessage());
		}
			
	}
	
	
	
}
