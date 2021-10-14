package com.oracle.ICICI.HCM.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.acs.util.BrowserDriverUtil;

public class PerformanceDocumentPage extends BrowserDriverUtil{
	

	Common_Library cmnLib = new Common_Library();
	private Logger log = Logger.getLogger(PerformanceDocumentPage.class.getName());
	
	@FindBy(xpath = "//input[contains(@aria-describedby,'FONSr2:0:MAnt2:0:hr01Upl:UPsp1:hr01fs:hf01Sis:hf01Srh::desc')]")
	public WebElement reviewPeriodTxt;
	
	@FindBy(xpath = "(//div[contains(.,'Test Review-Period FY2020-21')])")
	public WebElement reviewPeriodVal;
	
	@FindBy(xpath = "//input[contains(@aria-controls,'_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:hr01Upl:UPsp1:hr01fs:hf01Sisj_id_1:hf01Srh::sgstnBdy')]")
	public WebElement performanceDocumnetTxt;
	
	@FindBy(xpath = "(//div[contains(.,'312131 TEST Performance Assessment FY20-21')])")
	public WebElement performanceDocumnetVal;
	
	@FindBy(xpath = "//input[contains(@aria-describedby,'_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:hr01Upl:UPsp1:hr01fs:hf01Sisj_id_2:hf01Srh::desc')]")
	public WebElement employeeTxt;
	
	@FindBy(xpath = "//label[contains(@for,'FONSr2:0:MAnt2:0:hr01Upl:UPsp1:hr01fs:hf04Sbv:hr01Pce:hr01Lv:')]")
	public WebElement performanceDocCheckBox;
	
	
	@FindBy(xpath = "//span[@class='xxb'][contains(.,'Actions')]")
	public WebElement ActionBtn;
	
	@FindBy(xpath = "//td[@class='xnv'][contains(.,'Change Due Date')]")
	public WebElement changeDueDateMenu;
	
	@FindBy(xpath = "//input[contains(@aria-describedby,'_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:hg01Upl:UPsp1:hg02Pce:hg02Lv:0:hg01Dt_afrdescBy')]")
	public WebElement changeDueDateTxt;
					 
	@FindBy(xpath = "//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:hg01Upl:UPsp1:SPsb2\"]/a")
	public WebElement submitChangeDueDateBtn;
	
	@FindBy(xpath = "//td[@class='xnv'][contains(.,'Cancel')]")
	public WebElement cancelMenu;
	
	@FindBy(xpath = "//td[@class='xnv'][contains(.,'Complete')]")
	public WebElement completeMenu;
	
	@FindBy(xpath = "//td[@class='xnv'][contains(.,'Transfer')]")
	public WebElement TransferMenu;
	
	@FindBy(xpath = "//td[@class='xnv'][contains(.,'Reopen')]")
	public WebElement ReopenMenu;
	
	@FindBy(xpath = "//td[@class='xnv'][contains(.,'Delete')]")
	public WebElement deleteMenu;
	
	
	@FindBy(xpath="//span[contains(.,'Canceled')]")
	public WebElement DocumentStatusCancel;
	
	
	@FindBy(xpath = "//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:hr01Upl:UPsp1:hr01fs:hf03Clj_id_8\"]")
	public WebElement docStatusclearLink;
	
	@FindBy(xpath = "(//div[contains(.,'Canceled')])")
	public WebElement cancelLink;

	@FindBy(xpath = "//div[@class='xuy xk6'][contains(.,'In progress')]")
	public WebElement DocumentStatusInProgress;
	
	@FindBy(xpath = "//span[contains(.,'Completed')]")
	public WebElement DocumentStatusCompleted;
	
	@FindBy(xpath = "//span[@class='x1mb'][contains(.,'Y')]")
	public WebElement warningMsgYesBtn;
	
	@FindBy(xpath = "//span[contains(@class,'x32a xnb x3ho')]")
	public WebElement warningMsg;
	
	@FindBy(xpath = "//input[contains(@aria-controls,'_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:ht01Upl:UPsp1:ht02Pse:ht01Sis:ht01Srh::sgstnBdy')]")
	public WebElement ManagerIDTxt;
	
	@FindBy(xpath = "//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:ht01Upl:UPsp1:SPsb2\"]/a")
	public WebElement SubmitTransferManager;
	
	// Email Notification
					 
	@FindBy(xpath = "//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:hr01Upl:UPsp1:hr03Bn\"]")
	public WebElement sendEmailNotificationBtn;
	
	@FindBy(xpath = "//input[contains(@aria-describedby,'FONSr2:0:MAnt2:1:hs01Upl:UPsp1:hs01Pse:hs01Sis:hs01Srh::desc')]")
	public WebElement departmentTxt;
	
	@FindBy(xpath = "//input[contains(@aria-describedby,'_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:hs01Upl:UPsp1:hs01Pse:hs02Sis:hs02Srh::desc')]")
	public WebElement ReviewPeriodText;
	
	@FindBy(xpath = "//input[contains(@aria-describedby,'FONSr2:0:MAnt2:1:hs01Upl:UPsp1:hs01Pse:hs03Sis:hs03Srh::desc')]")
	public WebElement performanceDocumentText;
	
	@FindBy(xpath = "//input[contains(@name,'FONSr2:0:MAnt2:1:hs01Upl:UPsp1:hs02Pse:hs01Inp')]")
	public WebElement emailSubjectTxt;
	
	@FindBy(xpath = "//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:hs01Upl:UPsp1:SPsb2\"]/a")
	public WebElement submitEmailBtn;
	
	@FindBy(xpath = "(//span[contains(@class,'x32a xnb x3ho')])")
	public WebElement EmailConfirmationMsg;
	
	@FindBy(xpath = "//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:hs01Upl:UPsp1:hs06Msg:PSEcil2\"]/a/span")
	public WebElement EmailConfirmationOkBtn;
	
	
	
	
	
	@FindBy(xpath="//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:hr01Upl:UPsp1:SPdonei::icon\"]")
	public WebElement backButton;
	
	
	public PerformanceDocumentPage() {
		PageFactory.initElements(getDriver(), this);
		log.info("Performance document Page is initialized...");
	}


}
