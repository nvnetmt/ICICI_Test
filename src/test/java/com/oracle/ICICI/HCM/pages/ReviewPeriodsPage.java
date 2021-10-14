package com.oracle.ICICI.HCM.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.acs.util.BrowserDriverUtil;

public class ReviewPeriodsPage extends BrowserDriverUtil {

	Common_Library cmnLib = new Common_Library();
	private Logger log = Logger.getLogger(ReviewPeriodsPage.class.getName());

	@FindBy(linkText = "Review Periods")
	public WebElement ReviewPeriodsMenu;

	@FindBy(xpath = "//*[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:AP1:AT1:_ATp:ctb1::icon']")
	public WebElement CreateReviewPeriodButton;

	@FindBy(xpath = "//input[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:AP2:it2::content']")
	public WebElement ReviewPeriodName;

	@FindBy(xpath = "//textarea[contains(@name,'_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:AP2:it1')]")
	public WebElement Description;

	@FindBy(xpath = "//textarea[contains(@id,'_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:AP2:it1::content')]")
	public WebElement status;

	@FindBy(xpath = "//input[@name='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:AP2:id1']")
	public WebElement PeriodStartDate;

	@FindBy(xpath = "//input[@name='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:AP2:id2']")
	public WebElement PeriodEndDate;

	@FindBy(xpath = "//button[contains(.,'Save and Close')]")
	public WebElement SaveAndClose;

	@FindBy(xpath = "//*[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:AP2:d4::contentContainer']")
	public WebElement confirmationMessage;

	@FindBy(xpath = "//button[@accesskey='K']")
	public WebElement confirmationOkButton;
	// *[@id="_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:AP1:qryId1:value00::content"]
	@FindBy(xpath = "//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:AP1:qryId1:value00::content\"]")
	public WebElement createdReviewPeriodName;

	@FindBy(xpath = "//button[contains(.,'Search')]")
	public WebElement searchButton;

	@FindBy(xpath = "//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:AP1:AT1:_ATp:t1:0:commandLink1\"]")
	public WebElement ReviewPeriodList;

	@FindBy(xpath = "//*[@id='_FOpt1:_UIShome::icon']")
	public WebElement HomeButton;

	// **********************************
	@FindBy(xpath = "//h1[text()='Review Periods']")
	public WebElement hdrReviewPeriods;
	
	@FindBy(css="img[id$='ctb1::icon']")
	public WebElement lnkCreateReviewPeriod;
	
	@FindBy(xpath="//label[text()='Review Period Name']//ancestor::tr[1]//input")
	public WebElement txtReviewPeriodName;
	
	@FindBy(css="button[id$='::search']")
	public WebElement btnSearch;
	
	@FindBy(css="table[summary='Search Results']>tbody")
	public WebElement tblBdySearchResults;

	public ReviewPeriodsPage() {
		PageFactory.initElements(getDriver(), this);
		log.info("ReviewPeriodsPage is initialized...");
	}

}
