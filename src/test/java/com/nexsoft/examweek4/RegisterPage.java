package com.nexsoft.examweek4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
protected WebDriver driver;


		@FindBy(xpath = "//input[@name='username']" )
		private WebElement inputUserId;
		
		@FindBy(xpath = "//input[@name='password']" )
		private WebElement inputNewPassword;
		
		@FindBy(xpath = "//input[@name='repeatedPassword']" )
		private WebElement inputRepeatPassword;
		
		@FindBy(xpath = "//input[@name='account.firstName']" )
		private WebElement inputFirstName;
		
		@FindBy(xpath = "//input[@name='account.lastName']" )
		private WebElement inputLastName;
		
		@FindBy(xpath = "//input[@name='account.email']" )
		private WebElement inputEmail;
		
		@FindBy(xpath = "//input[@name='account.phone']" )
		private WebElement inputPhone;
		
		@FindBy(xpath = "//input[@name='account.address1']" )
		private WebElement inputAddress1;
		
		@FindBy(xpath = "//input[@name='account.address2']" )
		private WebElement inputAddress2;
		
		@FindBy(xpath = "//input[@name='account.city']" )
		private WebElement inputCity;
		
		@FindBy(xpath = "//input[@name='account.state']" )
		private WebElement inputState;
		
		@FindBy(xpath = "//input[@name='account.zip']" )
		private WebElement inputZip;
		
		@FindBy(xpath = "//input[@name='account.country']" )
		private WebElement inputCountry;

		@FindBy(xpath = "//input[@name='newAccount']" )
		private WebElement btnSaveAccount;
		
		@FindBy(xpath = "//a[normalize-space()='My Account']" )
		private WebElement btnMyAccount;
		
		public RegisterPage(WebDriver driver)  {
				// TODO Auto-generated constructor stub
		
		this.driver = driver;
	
	}
		
		public MyAccount validRegister (String userId, String newPassword, String repeatPassword, String uFirstName,String uLastName, String uEmail, 
				String phone, String address1, String address2, String city, String state, String zip, String country) {
//User Information
			inputUserId.clear();
			inputUserId.sendKeys(userId);
			inputNewPassword.clear();
			inputNewPassword.sendKeys(newPassword);
			inputRepeatPassword.clear();
			inputRepeatPassword.sendKeys(repeatPassword);
			
//Account Information
			inputFirstName.clear();
			inputFirstName.sendKeys(uFirstName);
			inputLastName.clear();
			inputLastName.sendKeys(uLastName);
			inputEmail.clear();
			inputEmail.sendKeys(uEmail);
			inputPhone.clear();
			inputPhone.sendKeys(phone);
			inputAddress1.clear();
			inputAddress1.sendKeys(address1);
			inputAddress2.clear();
			inputAddress2.sendKeys(address2);
			inputCity.clear();
			inputCity.sendKeys(city);
			inputState.clear();
			inputState.sendKeys(state);
			inputZip.clear();
			inputZip.sendKeys(zip);
			inputCountry.clear();
			inputCountry.sendKeys(country);
//			Check profile information
			//select[@name='account.favouriteCategoryId']//
			btnSaveAccount.click();

			return PageFactory.initElements(driver, MyAccount.class);
			
		}

		public HomePage clickbtnSaveAccount() {
			
			btnSaveAccount.click();
	
			HomePage home = PageFactory.initElements(driver, HomePage.class);
	
			return home;
	
	}

		public MyAccount clickbtnMyAccount() {
	
			btnMyAccount.click();
	
			MyAccount myAccount = PageFactory.initElements(driver, MyAccount.class);
	
			return myAccount;
	
	}


}
