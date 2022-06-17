package com.nexsoft.examweek4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	protected WebDriver driver;
	
	@FindBy(xpath = "//a[normalize-space()='Sign In']")
	private WebElement btnSignIn;
	
	@FindBy(xpath = "//input[@name='keyword']")
	private WebElement search;
	
	@FindBy(xpath = "//input[@name='searchProducts']")
	private WebElement btnSearch;
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public SignInPage clickbtnSignIn() {
		
		btnSignIn.click();
		
		SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);

		return signInPage;
	}
	
}

