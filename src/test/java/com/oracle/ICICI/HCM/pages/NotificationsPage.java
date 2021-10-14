package com.oracle.ICICI.HCM.pages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.acs.util.BrowserDriverUtil;

public class NotificationsPage extends BrowserDriverUtil {
	private Logger log = Logger.getLogger(NotificationsPage.class.getName());
	Common_Library cmnLib = new Common_Library();
	
	@FindBy(xpath ="//*[contains(@id,'0:cil1::icon')]")
	public WebElement NotificationBellIcon;
	
	@FindBy(xpath ="//*[contains(@id,'cl3')]")
	public WebElement lnkShowAllNotification;
	
	@FindBy(xpath ="//*[@id=\"pt1:atkfr1:0:rQuick:1:up1:UPsp1:np1:ni1::disclosureAnchor\"]")
	public WebElement lnkAssignedToMe;
	
	@FindBy(xpath ="//*[contains(@id,'pt1:_UISatr:0:lv4:0:cl4')]")
	public WebElement lnkApprovalRequest;
	
	@FindBy(xpath ="//*[contains(text(),'Approve')]")
	public WebElement btnApproveLeave;
	
	//*[@id="pt1:atkfr1:0:grid:0:r1j_id_2:0:r1:0:i1:1:itCa:0:clCa"] 
	//*[@id="pt1:atkfr1:0:grid:0:r1j_id_2:0:r1:0:i1:0:itCa:0:clCa"]
	
	
	public NotificationsPage() {
		PageFactory.initElements(getDriver(), this);
		log.info("Notification Page is initialized...");
	}

}