package com.oracle.ICICI.HCM.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.acs.util.BrowserDriverUtil;

public class CreateReviewPeriodPage extends BrowserDriverUtil{
	
	Common_Library cmnLib = new Common_Library();
	private Logger log = Logger.getLogger(CreateReviewPeriodPage.class.getName());
	
	@FindBy(xpath="//h1[text()='Create Review Period']")
	public WebElement hdrCreateReviewPeriod;
	
	@FindBy(xpath="//label[text()='Review Period Name']//ancestor::tr[1]//input")
	public WebElement txtReviewPeriodName;
	
	@FindBy(xpath="//label[text()='Description']//ancestor::tr[1]//textarea")
	public WebElement txtDescription;
	
	@FindBy(xpath="//label[text()='Period Start Date']//ancestor::tr[1]//input")
	public WebElement txtPeriodStartDate;
	
	@FindBy(xpath="//label[text()='Period End Date']//ancestor::tr[1]//input")
	public WebElement txtPeriodEndDate;
	
	@FindBy(css = "button[id$='cb3']")
	public WebElement btnSaveAndClose;
	
	@FindBy(xpath = "//td[contains(text(),'review period has been created')]")
	public WebElement msgConfirmation;
	
	@FindBy(css = "button[id$='commandButton1']")
	public WebElement btnOK;
	
	public CreateReviewPeriodPage() {
		PageFactory.initElements(getDriver(), this);
		log.info("Create Review Period Page is initialized...");
	}

}
