package com.nexsoft.examweek4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

protected WebDriver driver;

	@FindBy(xpath = "//a[normalize-space()='Sign Out']" )
	private WebElement btnLogOut;

	@FindBy(xpath = "//div[@id='WelcomeContent']" )
	private WebElement welcomeContent;
	
	public WelcomePage (WebDriver driver)  {
		// TODO Auto-generated constructor stub

		this.driver = driver;

}
	
	public HomePage clickbtnLogOut() {
		
		btnLogOut.click();
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);

		return home;
	}
	
	
	public String getWelcomeContent() {
		
		return welcomeContent.getText();
}
}
