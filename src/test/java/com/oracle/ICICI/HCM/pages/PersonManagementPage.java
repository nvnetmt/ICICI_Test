package com.oracle.ICICI.HCM.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oracle.acs.util.BrowserDriverUtil;
import com.oracle.ICICI.common.actions.Common_Library;

public class PersonManagementPage extends BrowserDriverUtil {
	private Logger log = Logger.getLogger(PersonManagementPage.class.getName());
	Common_Library cmnLib = new Common_Library();
	
	@FindBy(xpath="//*[@id=\"itemNode_workforce_management_person_management_0\"]")
	public WebElement MenuPersonManagement;
	
	@FindBy(xpath="//*[contains(@id,'value00::content')]")
	public WebElement PersonManagementName;
	
	@FindBy(xpath="//*[contains(@id,'value10::content')]")
	public WebElement PersonManagementEmployeeId;
	
	@FindBy(xpath="//*[contains(@id,'value20::content')]")
	public WebElement PersonManagementNationalId;
	
	@FindBy(xpath="//*[contains(@id,'value30::content')]")
	public WebElement PersonManagementKeyWords;
	
	@FindBy(xpath="//*[contains(@id,'search')]")
	public WebElement btnSearchPersonManagement;
	
	@FindBy(xpath="//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAt1:0:pt1:Perso1:0:SP3:ph1\"]")
	public WebElement tblBodySearchResultsPM;
	
	@FindBy(xpath="//img[@title='Actions']")
	public WebElement btnActionPM;
	
	@FindBy(xpath="//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAt1:0:pt1:Perso1:0:SP3:table1:am2:dc_i1:0:dcm1\"]/td[2]")
	public WebElement lnkLeaveMusterPM;
	
	@FindBy(xpath="//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAt1:0:pt1:Perso1:0:SP3:table1:am2:dc_i1:0:dci1:1:dccmi1\"]/td[2]")
	public WebElement lnkManageLeaveMusterRecordPM; 
	
	@FindBy(xpath="//*[contains(@id,'AP1:r1:0:AT2:_ATp:ATtb1::eoi')]")
	public WebElement ArrowExpandPM;
	
	public PersonManagementPage() {
		PageFactory.initElements(getDriver(), this);
		log.info("Person Management Page is initialized...");
	}

}
