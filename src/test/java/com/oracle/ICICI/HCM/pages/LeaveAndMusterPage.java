package com.oracle.ICICI.HCM.pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.acs.util.BrowserDriverUtil;

public class LeaveAndMusterPage extends BrowserDriverUtil {
	
	Common_Library cmnLib = new Common_Library();
	private Logger log = Logger.getLogger(LeaveAndMusterPage.class.getName());
	
	@FindBy(xpath="//div[contains(@id,'0:tb1:TBpgl6')]")
	public WebElement btnApplyLeaveAndMuster;
	
	@FindBy(xpath="//div[contains(@id,'2:tb1:TBpgl6')]")
	public WebElement btnExistingLeaveAndMuster;
	
	@FindBy(xpath="//div[contains(@id,'r1:0:AT2:_ATp:ctb1')]")
	public WebElement btnApplyLeaveMusterAdm; 
	
	@FindBy(xpath = "//h1[contains(text(),'Apply Leave & Muster')]")
	public WebElement hdrApplyLeaveAndMuster;
	
	@FindBy(xpath="//h1[contains(text(),'Leave and Muster')]")
	public WebElement hdrLeaveAndMuster;
	
	@FindBy(xpath="//a[contains(@id,'typSrh::btn')]")
	public WebElement drpLeaveType;
	
	//*[@id="_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:adAbUpl:UPsp1:typSis:typSrh::content"]
	//a[contains(@id,'typSrh::btn')]
	
	@FindBy(xpath ="//*[contains(@id,'soc1::content')]")
	public WebElement drpLeaveTypeLeaveMusterAdm;	
	
	@FindBy(xpath="//input[contains(@id,'abSt1Dt::content')]")
	public WebElement StartDate;
	
	@FindBy(xpath="//input[contains(@id,'abSt2Dt::content')]")
	public WebElement StartDateAndTime;
	
	@FindBy(xpath="//*[contains(@id,'id7::content')]")
	public WebElement StartDateLeaveMusterAdm;
	
	@FindBy(xpath="//input[contains(@id,'abEd1Dt::content')]")
	public WebElement EndDate;
	
	@FindBy(xpath="//input[contains(@id,'abEd2Dt::content')]")
	public WebElement EndDateAndTime;
	
	@FindBy(xpath="//*[contains(@id,'id17::content')]")
	public WebElement EndDateLeaveMusterAdm;
	
	@FindBy(xpath ="//*[contains(@id,'stDuSel::drop')]")
	public WebElement drpLeaveStartDtDuration;
	
	@FindBy(xpath="//*[contains(@name,'cmntInp')]")
	public WebElement LeaveComment;
	
	@FindBy(xpath="//input[contains(@id,'UPsp1:DtlsSh:rsnSel::content')]")
	public WebElement drpLeaveReason;
	
	@FindBy(xpath="//*[contains(@id,'childName_Display__FLEX_EMPTY::lovIconId')]")
	public WebElement drpChildName;
	
	@FindBy(xpath="//*[contains(@id,'bsDtPce:durFrm')]")
	public WebElement LeaveDuration;
	
	@FindBy(xpath="//*[contains(text(),'click to add attachment')]")
	public WebElement lnkAddAttachment;
	
	@FindBy(xpath="//td[contains(text(),'Add File')]")
	public WebElement lnkAddFile;
	
	//@FindBy(xpath="//div[contains(@id,'adAbUpl:UPsp1:SPsb2')]")
	//public WebElement btnSubmit;
	
	@FindBy(xpath="//*[contains(@id,'SPsb2')]")
	public WebElement btnSubmit;
	
	@FindBy(xpath="//*[contains(@id,'AP1:APsv')]")
	public WebElement btnSave;
	
	@FindBy(xpath="//*[contains(@id,'UPsp1:APscl2')]")
	public WebElement btnSaveAndClose;
	
	@FindBy(xpath="//div[contains(@id,'errHm:dc_pgl91')]")
	public WebElement ErrMsg;
	
	@FindBy(xpath="//*[contains(@id,'AP1:pfl14')]")
	public WebElement MsgWarning;

	@FindBy(xpath="//*[contains(@id,'AP1:cb13')]") 
	public WebElement btnYesWarningMsgLeaveMusterAdm;
	
	@FindBy(xpath="//*[text()='The request was submitted.']")
	public WebElement SumittedMsgLeaveMusterAdm;
	
	@FindBy(xpath="//*[contains(@id,'cb33')]")
	public WebElement btnOkConfirmationLeaveMusterAdm;
	
	@FindBy(xpath="//*[contains(@id,'key2Inp::content')]")
	public WebElement searchLeaveTypeStatus;
	
	@FindBy(xpath="//*[contains(@id,'clr2Cil::icon')]")
	public WebElement searchLeaveTypeStatusIcon;

	public LeaveAndMusterPage() {
		PageFactory.initElements(getDriver(), this);
		log.info("Leave And Muster Page is initialized...");
	}
	
	public boolean searchLeaveType(String strleaveType) {
		boolean result = false;
		try {
		
			if(cmnLib.clickOnWebElement(drpLeaveType)) {
				
				TimeUnit.SECONDS.sleep(2);
			
				getDriver().findElement(By.xpath("//div[text()='" + strleaveType + "']")).isDisplayed();
			
				TimeUnit.SECONDS.sleep(3);
				cmnLib.waitForPageLoaded();
				result = true;
			}
			else {
				log.info("Could not click on the Leave Type dropdown");
			}
			
		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
			log.info("Exception: searchLeaveType");
		}
		return result;
	}
	
	public boolean selectLeaveType(String strleaveType) {
		boolean result = false;
		try {
		
			if(cmnLib.clickOnWebElement(drpLeaveType)) {
				
				TimeUnit.SECONDS.sleep(2);
			
				getDriver().findElement(By.xpath("//div[text()='" + strleaveType + "']")).click();
			
				TimeUnit.SECONDS.sleep(3);
				cmnLib.waitForPageLoaded();
				result = true;
			}
			else {
				log.info("Could not click on the Leave Type dropdown");
			}
			
		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
			log.info("Exception: selectType");
		}
		return result;
	}
	
	public boolean selectLeaveTypeLMAdm(String strleaveType) {
		boolean result = false;
		try {
			
			TimeUnit.SECONDS.sleep(20);
			
			if(cmnLib.clickOnWebElement(drpLeaveTypeLeaveMusterAdm)){ 
				
				TimeUnit.SECONDS.sleep(10);
				
				getDriver().findElement(By.xpath("//*[text()='"+strleaveType+"']")).click();
			
				TimeUnit.SECONDS.sleep(10);
				cmnLib.waitForPageLoaded();
				result = true;
			}
			else {
				log.info("Could not click on the Leave Type dropdown");
			}
			
		} catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
			log.info("Exception: selectLeaveTypeLMAdm");
		}
		return result;
	}
	
	public boolean selectLeaveReason(String strleaveReason) {
		boolean result = false;
		try {
			
			if(cmnLib.clickOnWebElement(drpLeaveReason)) {
			
				getDriver().findElement(By.xpath("//li[text()='" + strleaveReason + "']")).click();
			
				TimeUnit.SECONDS.sleep(3);
				cmnLib.waitForPageLoaded();
				result = true;
			}
			else {
				log.info("Could not click on the Leave Reason dropdown");
			}
			
		} catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
			log.info("Exception: selectLeaveReason");
		}
		return result;
	}

	
	public boolean selectLeaveDuration(String strleaveDuration) {
		boolean result = false;
		try {
			
			if(cmnLib.waitForElementToBeVisible(drpLeaveStartDtDuration,30)&&cmnLib.clickOnWebElement(drpLeaveStartDtDuration)) {
			
				getDriver().findElement(By.xpath("//li[contains(text(),'"+strleaveDuration+"')]")).click();
			
				TimeUnit.SECONDS.sleep(3);
				cmnLib.waitForPageLoaded();
				result = true;
			}
			else {
				log.info("Could not click on the Leave Duration dropdown");
			}
			
		} catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
			log.info("Exception: selectLeaveDuration");
		}
		return result;
	}
	
	public boolean selectChildName(String strChildName) {
		boolean result = false;
		try {
			
			if(cmnLib.waitForElementToBeVisible(drpChildName,30)&&cmnLib.clickOnWebElement(drpChildName)) {
			
				getDriver().findElement(By.xpath("//span[contains(text(),'"+strChildName+"')]")).click();
			
				TimeUnit.SECONDS.sleep(3);
				cmnLib.waitForPageLoaded();
				result = true;
			}
			else {
				log.info("Could not select Child Name dropdown");
			}
			
		} catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
			log.info("Exception: selectChildName");
		}
		return result;
	}
	
}
