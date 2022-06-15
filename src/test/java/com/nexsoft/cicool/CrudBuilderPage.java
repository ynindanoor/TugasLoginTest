package com.nexsoft.cicool;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CrudBuilderPage {
	protected WebDriver driver;

	@FindBy(xpath="//tbody[@id='tbody_crud']/tr")
	List<WebElement> lstTable;
		
	public CrudBuilderPage(WebDriver driver)  {
			// TODO Auto-generated constructor stub
				
			this.driver = driver;
		
	}
	
	public void clickSeeButtonWithTitle(String title) {
		WebElement see = null;
		int counter =1;
		for (WebElement webElement : lstTable) {
			see = webElement.findElement(By.xpath("//tbody[@id='tbody_crud']/tr["+counter+"]/td/a[1]"));
			WebElement teks = webElement.findElement(By.xpath("//tbody[@id='tbody_crud']/tr["+counter+"]//td[2]"));
			
			if(teks.getText().equalsIgnoreCase(title) ) {
				see.click();
				break;
			}
			
//			see = webElement.findElement(By.xpath("//td/a[1]"));
//			WebElement teks = webElement.findElement(By.xpath("//td[2]"));
//			
//			if(teks.getText().equalsIgnoreCase(title) ) {
//				see.click();
//			}
		}
	}
	
//	private WebElement addcrudnew;
//	
//	@FindBy(xpath="//a[@id='btn_add_new']")
//	private WebElement addcrudnew;
//
//	@FindBy(xpath="//i[@class='fa fa-file-excel-o']")
//	private WebElement export;
	
	
	
//	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/a[1]")
//	private WebElement seeAbsen;
//	
//	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/a[2]")
//	private WebElement changeAbsen;
//	
//	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/a[3]")
//	private WebElement deleteAbsen;
	
	
	
	
	
	
	
}
