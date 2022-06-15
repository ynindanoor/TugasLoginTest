package com.nexsoft.cicool;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	
	protected WebDriver driver;
	//tanpa page factory
	/*
	private By email = By.xpath("//input[@placeholder='Email']");
	private By password = By.xpath("//input[@placeholder='Password']");
	private By btnSignIn = By.xpath("//button[@type='submit']");
	*/
	
	@FindBy(xpath="//input[@placeholder='Email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']" )
	private WebElement btnSignIn;
	
	@FindBy(xpath = "//p[normalize-space()='E-mail Address and Password do not match.']" )
	private WebElement errorPassword;
	
	@FindBy(xpath = "//p[normalize-space()='User does not exist']" )
	private WebElement errorUsername;
	
	@FindBy(xpath = "//p[normalize-space()='The Username field is required.']" )
	private WebElement errorEmpty;
	
//	@FindBy(xpath = "//body/div[1]/div[2]/div/p" )
//	private List<WebElement> errorEmpty;
	
	
	public SignInPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public Dashboard loginValidUser(String username, String user_password) {
		email.clear();
		email.sendKeys(username);
		password.clear();
		password.sendKeys(user_password);
		btnSignIn.click();
		
		return PageFactory.initElements(driver, Dashboard.class);
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
	
//	public List<String> getErrorEmpty() {
//		List<String> errorText = new ArrayList<String>();
//		for (WebElement webElement : errorEmpty) {
//			errorText.add(webElement.getText());
//		}
//		return errorText;
//	}
	
	
}
