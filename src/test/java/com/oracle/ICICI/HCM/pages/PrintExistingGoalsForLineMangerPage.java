package com.oracle.ICICI.HCM.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.acs.util.BrowserDriverUtil;

public class PrintExistingGoalsForLineMangerPage  extends BrowserDriverUtil{
	
	
	Common_Library cmnLib = new Common_Library();
	private Logger log = Logger.getLogger(PrintExistingGoalsForLineMangerPage.class.getName());
	
	@FindBy(xpath = "//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:hp01Upl:UPsp1:hp01Pce:hp01Lv:0:hp01Pse:hp02Cl\"]")
	public WebElement employeeLink;
	
	@FindBy(xpath = "//input[contains(@aria-owns,'_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:goalUpl:UPsp1:rpdSel::pop')]")
	public WebElement reviewPeriod;
	
	@FindBy(xpath="//li[contains(.,'Test Review-Period FY2020-21')]")
	public WebElement reviewPeriodVal;
	
	@FindBy(xpath = "//input[@role='combobox'][contains(@id,'FONSr2:0:MAnt2:1:goalUpl:UPsp1:gpSel::content')]")
	public WebElement goalSheet;
	
	@FindBy(xpath="//li[contains(.,'RUI test category 2')]")
	public WebElement goalSheetVal;
	
	@FindBy(xpath="//label[contains(@for,'_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:goalUpl:UPsp1:sumRgn:0:gpPce:goalLv:0:golPse:sel4Chk::content')]")
	public WebElement selectGoal;
	
	@FindBy(xpath = "//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:goalUpl:UPsp1:sumRgn:0:gpPce:goalLv:0:golPse:l1Lnk\"]/span")
	public WebElement goalsList;
	
	@FindBy(xpath = "//td[@class='x1kj'][contains(.,'Actions')]")
	public WebElement actionButton;
	
	@FindBy(xpath = "//td[@class='xnw'][contains(.,'Print')]")
	public WebElement print;
	
	@FindBy(xpath = "//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:goalUpl:UPsp1:SPdonei::icon\"]")
	public WebElement bckButton;
	
	
	public PrintExistingGoalsForLineMangerPage() {
		PageFactory.initElements(getDriver(), this);
		log.info("Create Goal Plans Page is initialized...");
	}

}
