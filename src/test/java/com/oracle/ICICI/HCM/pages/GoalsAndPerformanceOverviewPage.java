package com.oracle.ICICI.HCM.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.acs.util.BrowserDriverUtil;

public class GoalsAndPerformanceOverviewPage extends BrowserDriverUtil {

	Common_Library cmnLib = new Common_Library();
	private Logger log = Logger.getLogger(GoalsAndPerformanceOverviewPage.class.getName());

	@FindBy(xpath = "//h1[contains(text(),'Goals and Performance Overview')]")
	public WebElement hdrGoalsAndPerformance;

	@FindBy(xpath = "(//a[contains(@id,'Mt4Cl')])[1]")
	public WebElement lnkDirectReport1;

	@FindBy(xpath = "//h1[contains(text(),'Performance')]")
	public WebElement hdrPerformance;

	@FindBy(xpath = "//div[text()='Show More']")
	public WebElement lnkShowMore;

	@FindBy(xpath = "//div[text()='Goals']")
	public WebElement lnkGoals;

	@FindBy(xpath = "//h1[contains(text(),'Goals')]")
	public WebElement hdrGoals;

	@FindBy(css = "div[id$='goalLv::db']")
	public WebElement tblGoalList;

	public GoalsAndPerformanceOverviewPage() {
		PageFactory.initElements(getDriver(), this);
		log.info("Goals And Performance Overview Page is initialized...");

	}

	public boolean verifyGoalSheetHeader(String goalSheetName) {

		try {
			WebElement element = getDriver().findElement(By.xpath("//h2[normalize-space(text())='" + goalSheetName + "']"));
			return cmnLib.waitForElementToBeVisible(element);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
