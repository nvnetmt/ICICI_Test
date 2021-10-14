package com.oracle.ICICI.HCM.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.acs.util.BrowserDriverUtil;

public class AddGoalPage extends BrowserDriverUtil{
	
	Common_Library cmnLib = new Common_Library();
	private Logger log = Logger.getLogger(AddGoalPage.class.getName());
	
	@FindBy(xpath = "//h1[text()='Add Goal']")
	public WebElement hdrAddGoal;
	
	@FindBy(xpath = "//label[text()='Goal Name']/parent::div/following-sibling::div/input")
	public WebElement txtGoalName;
	
	@FindBy(xpath = "//label[text()='Measurement']/parent::div/following-sibling::div/textarea")
	public WebElement txtMeasurement;
	
	@FindBy(xpath = "//label[text()='Start Date']/parent::div/following-sibling::div/input")
	public WebElement txtStartDate;
	
	@FindBy(xpath = "//label[text()='Target Completion Date']/parent::div/following-sibling::div/input")
	public WebElement txtTargetCompletionDate;
	
	@FindBy(xpath = "//label[text()='Weight']/parent::div/following-sibling::div/input")
	public WebElement txtWeight;
	
	@FindBy(xpath = "//label[text()='Perspective']//ancestor::div[2]//a")
	public WebElement lnkArrowPerspective;
	
	@FindBy(css = "div[id$='APscl2']")
	public WebElement btnSaveAndClose;
	
	public AddGoalPage() {
		PageFactory.initElements(getDriver(), this);
		log.info("Add Goal Page is initialized...");
	}

}
