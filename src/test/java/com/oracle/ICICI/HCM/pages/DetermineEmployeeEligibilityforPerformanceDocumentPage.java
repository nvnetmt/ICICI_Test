package com.oracle.ICICI.HCM.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.acs.util.BrowserDriverUtil;

public class DetermineEmployeeEligibilityforPerformanceDocumentPage extends BrowserDriverUtil {
	
	Common_Library cmnLib = new Common_Library();
	private Logger log = Logger.getLogger(DetermineEmployeeEligibilityforPerformanceDocumentPage.class.getName());
	
	
	@FindBy(xpath = "//input[contains(@aria-controls,'FONSr2:0:MAnt2:1:hy01Upl:UPsp1:hy01Fs:hf01Sis:hf01Srh::sgstnBdy')]")
	public WebElement EmployeeTxt;
	
	@FindBy(xpath = "//input[contains(@aria-describedby,'FONSr2:0:MAnt2:2:hd01Upl:UPsp1:hd01Sis:hd01Srh::desc')]")
	public WebElement ReviewPeriodTxt;
	
	@FindBy(xpath ="//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:2:hd01Upl:UPsp1:hd01Pce:PCEcil1\"]")
	public WebElement addEligibilityBtn;
	
	@FindBy(xpath = "//input[contains(@aria-owns,'FONSr2:0:MAnt2:2:hd01Upl:UPsp1:hd01Pce:hd01Lv:0:hd01Pse:hd04Sel::pop')]")
	public WebElement performanceDocumentTxt;
	
	@FindBy(xpath = "//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:2:hd01Upl:UPsp1:hd01Pce:hd01Lv:0:hd01Pse:PSEcb2\"]")
	public WebElement saveEligiblityBtn;
	
	
	
	public DetermineEmployeeEligibilityforPerformanceDocumentPage() {
		PageFactory.initElements(getDriver(), this);
		log.info("Performance document eligibility Page is initialized...");
	}


}
