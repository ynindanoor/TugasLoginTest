package com.nexsoft.examweek4;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	
	protected WebDriver driver;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@name='signon']" )
	private WebElement btnLogIn;
	
	@FindBy(xpath = "//a[normalize-space()='Register Now!']" )
	private WebElement btnRegisterNow;
	
	@FindBy(xpath = "//li[contains(text(),'Invalid username or password.')]" )
	private WebElement errorPassword;

	@FindBy(xpath = "//li[contains(text(),'Invalid username or password.')]" )
	private WebElement errorUsername;
	
	@FindBy(xpath = "//li[contains(text(),'Invalid username or password.')]" )
	private WebElement errorBoth;
	
	@FindBy(xpath = "//p[normalize-space()='Please enter your username and password.']" )
	private WebElement errorEmpty;
	
	@FindBy(xpath = "//p[normalize-space()='Please enter your username and password.']" )
	private WebElement errorEmptyUsername;
	
	@FindBy(xpath = "//p[normalize-space()='Please enter your username and password.']" )
	private WebElement errorEmptyPassword;
	
	public SignInPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public WelcomePage loginValidUser(String user_name, String user_password) {
		//username.click();
		username.sendKeys(user_name);
		password.clear();
		password.sendKeys(user_password);
		btnLogIn.click();
		
		return PageFactory.initElements(driver, WelcomePage.class);
	}
	
public RegisterPage clickbtnRegister() {
		
		btnRegisterNow.click();
		
		RegisterPage register = PageFactory.initElements(driver, RegisterPage.class);

		return register;
	}
	
	public String getErrorPassword() {
		return errorPassword.getText();
	}

	public String getErrorUsername() {
		return errorUsername.getText();
	}

	public String getErrorEmpty() {
		return errorEmpty.getText();
	}
	
	public String getErrorEmptyUser() {
		return errorEmptyUsername.getText();
	}
	
	public String getErrorEmptyPassw() {
		return errorEmptyPassword.getText();
	}
	
	public String getErrorBoth() {
		return errorBoth.getText();
	}
	
}
