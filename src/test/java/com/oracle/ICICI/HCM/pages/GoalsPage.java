package com.oracle.ICICI.HCM.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.acs.util.BrowserDriverUtil;

public class GoalsPage extends BrowserDriverUtil {

	Common_Library cmnLib = new Common_Library();
	private Logger log = Logger.getLogger(GoalsPage.class.getName());

	@FindBy(xpath = "//*[@id=\\\"_FOpt1:_FOr1:0:_FONSr2:0:_FOTsr1:0:cl01Upl:UPsp1:cl01Pce:cl01Lv:5:cl01Pse:cl01Cl\\\"]")
	public WebElement ReviewPeriodLink;

	@FindBy(xpath = "//h1[text()='Goals']")
	public WebElement hdrGoals;

	@FindBy(xpath = "//a[text()='Eligibility Profiles']")
	public WebElement lnkEligibilityProfiles;

	@FindBy(xpath = "//a[text()='Review Periods']")
	public WebElement lnkReviewPeriods;

	@FindBy(css = "div[id$='addBtn']")
	public WebElement btnAdd;

	@FindBy(css = "div[id$='ctb1']")
	public WebElement btnSubmit1;

	@FindBy(css = "div[id$='SPsb2']")
	public WebElement btnSubmit2;

	public GoalsPage() {
		PageFactory.initElements(getDriver(), this);
		log.info("Goals Page is initialized...");
	}
}
