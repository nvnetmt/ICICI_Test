package com.oracle.ICICI.HCM.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.acs.util.BrowserDriverUtil;

public class CareerAndPerformancePage extends BrowserDriverUtil{
	
	Common_Library cmnLib = new Common_Library();
	private Logger log = Logger.getLogger(CareerAndPerformancePage.class.getName());
	
	@FindBy(xpath="//h1[text()='Career and Performance']")
	public WebElement hdrCareerAndPerformance;
	
	@FindBy(css="a[title='Goals']")
	public WebElement lnkGoals;
	
	public CareerAndPerformancePage() {
		PageFactory.initElements(getDriver(), this);
		log.info("Career And PerformancePage is initialized...");

	}

}
