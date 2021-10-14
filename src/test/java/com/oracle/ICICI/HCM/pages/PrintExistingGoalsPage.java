package com.oracle.ICICI.HCM.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.acs.util.BrowserDriverUtil;

public class PrintExistingGoalsPage extends BrowserDriverUtil{
	
	Common_Library cmnLib = new Common_Library();
	private Logger log = Logger.getLogger(PrintExistingGoalsPage.class.getName());
	
    @FindBy(xpath="//a[contains(@id,'goalUpl:UPsp1:rpdSel::drop')]")
	public WebElement reviewPeriod;
	
	@FindBy(xpath="//li[contains(.,'Test Review-Period FY2020-21')]")
	public WebElement reviewPeriodVal;
	
	@FindBy(xpath="//a[contains(@id,'gpSel::drop')]")
	public WebElement goalSheet;
	
	@FindBy(xpath="//li[contains(.,'RUI test category 2')]")
	public WebElement goalSheetVal;
	
	@FindBy(xpath = "//label[@for='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:r1:0:goalUpl:UPsp1:sumRgn:0:gpPce:goalLv:1:golPse:sel4Chk::content'][contains(@id,'FONSr2:0:MAnt2:0:r1:0:goalUpl:UPsp1:sumRgn:0:gpPce:goalLv:1:golPse:sel4Chk::Label0')]")
	public WebElement selectGoal;
	
	@FindBy(xpath="//label[contains(@id,'gpPce:goalLv:2:golPse:sel4Chk::Label0')]")
	public WebElement Goals;
	
	@FindBy(xpath="//div[contains(@title,'Actions')]")
	public WebElement actionButton;
	
	@FindBy(xpath="//tr[contains(@id,'gpPce:Gmi')]")
	public WebElement print;
	
	@FindBy(xpath="//*[contains(@id,'goalUpl:UPsp1:SPdonei::icon')]")
	public WebElement btnDone;
	
	@FindBy(xpath="//a[contains(@id,'hp01Pce:hp01Lv:0:hp01Pse:hp02Cl')]")
	public WebElement WorkerNameLink;
	
	@FindBy(xpath="//div[@title='Goals']")
	public WebElement hdrGoals;
	
	@FindBy(xpath="//*[contains(@id,'groupNode_workforce_management')]/div[17]/div[1]/div/div/a")
	public WebElement lnkPerformanceGoals;
	
	@FindBy(xpath="//h1[text()='Performance Goals']")
	public WebElement hdrPerformanceGoals;
	
	public PrintExistingGoalsPage() {
		PageFactory.initElements(getDriver(), this);
		log.info("Create Goal Plans Page is initialized...");
	}

}
