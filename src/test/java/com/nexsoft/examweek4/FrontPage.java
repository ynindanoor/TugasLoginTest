package com.nexsoft.examweek4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrontPage {

	protected WebDriver driver;
	
	@FindBy(xpath = "//a[normalize-space()='Enter the Store']" )
	private WebElement btnEnterTheStore;

	public FrontPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePage clickbtnEnterTheStore() {
		
		btnEnterTheStore.click();
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);

		return homePage;
	}
	
}

