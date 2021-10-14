package com.oracle.ICICI.HCM.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.acs.util.BrowserDriverUtil;

public class AddPerformanceGoalsByEmpAndMgrPage extends BrowserDriverUtil {

	Common_Library cmnLib = new Common_Library();
	private Logger log = Logger.getLogger(AddPerformanceGoalsByEmpAndMgrPage.class.getName());
	
	@FindBy(xpath = "//input[contains(@aria-owns,'FONSr2:0:MAnt2:0:r1:0:goalUpl:UPsp1:rpdSel::pop')]")
	public WebElement ReviewPeriodText;
	
	@FindBy(xpath = "//li[contains(.,'Test Review-Period FY2020-21')]")
	public WebElement ReviewPeriodValue;
	
	@FindBy(xpath = "//input[contains(@aria-owns,'FONSr2:0:MAnt2:0:r1:0:goalUpl:UPsp1:gpSel::pop')]")
	public WebElement GoalSheetText;
	
	@FindBy(xpath = "//li[contains(.,'FY21 Standard Template')]")
	public WebElement GoalSheetValue;
	
	@FindBy(xpath="//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:r1:0:goalUpl:UPsp1:sumRgn:0:gpPce:addBtn\"]")
	public WebElement AddButton;
	
	@FindBy(xpath="//input[contains(@name,'FONSr2:0:MAnt2:0:r1:1:gdUpl:UPsp1:sh:gn1Inp')]")
	public WebElement enterGoalName;
	
	@FindBy(xpath="//textarea[contains(@name,'FONSr2:0:MAnt2:0:r1:1:gdUpl:UPsp1:sh:dsc1Inp')]")
	public WebElement EnterMeasurement;
	
	@FindBy(xpath="//input[contains(@aria-owns,'FONSr2:0:MAnt2:0:r1:1:gdUpl:UPsp1:sh:ccSel::pop')]")
	public WebElement EnterPerspective;
	
	@FindBy(xpath="//li[contains(.,'Process Perspective')]")
	public WebElement perspectiveValue;
	
	@FindBy(xpath="//input[contains(@name,'FONSr2:0:MAnt2:0:r1:1:gdUpl:UPsp1:sh:g17Inp')]")
	public WebElement enterWeight;
	
	@FindBy(xpath = "(//div[contains(.,'Save')])")
	public WebElement Save;
	
	
	
	
	
	public AddPerformanceGoalsByEmpAndMgrPage() {
		PageFactory.initElements(getDriver(), this);
		log.info("Goals Page is initialized...");
	}
}
