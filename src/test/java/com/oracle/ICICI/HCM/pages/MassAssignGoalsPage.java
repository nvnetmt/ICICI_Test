package com.oracle.ICICI.HCM.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.acs.util.BrowserDriverUtil;

public class MassAssignGoalsPage extends BrowserDriverUtil{

	Common_Library cmnLib = new Common_Library();
	private Logger log = Logger.getLogger(MassAssignGoalsPage.class.getName());

	//*[@id="_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:upl:UPsp1:SOPce:SOBtn"]
	@FindBy(xpath = "//div[contains(@title,'Add')]")
	public WebElement addGoalProcess;

	@FindBy(xpath="//input[contains(@name,'FONSr2:0:MAnt2:1:pdUpl:UPsp1:d1sh:d1Inp')]")
	public WebElement enterProcessName;

	@FindBy(xpath="//input[contains(@aria-owns,'_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pdUpl:UPsp1:d1sh:d1Sel::pop')]")
	public WebElement reviewProcess;

	@FindBy(xpath = "//li[contains(.,'Test Review-Period FY2020-21')]")
	public WebElement reviewProcessValue;

	@FindBy(xpath = "//input[contains(@aria-owns,'_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pdUpl:UPsp1:d1sh:d2Sel::pop')]")
	public WebElement enterGoalSheet;

	@FindBy(xpath="//li[contains(.,'test_27/11/2020')]")
	public WebElement enterGoalSheetValue;

	@FindBy(xpath="//input[contains(@aria-controls,'_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pdUpl:UPsp1:d1sh:d1Sis:d1Srh::sgstnBdy')]")
	public WebElement enterRequester;

	@FindBy(xpath="//input[contains(@_afov,'2')]")
	public WebElement enterAssignees;

	@FindBy(xpath="(//li[contains(.,'All direct reports and indirect reports')]")
	public WebElement enterAssigneesValue;

	@FindBy(xpath="//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pdUpl:UPsp1:elgPce:PCEcil2::icon\"]")
	public WebElement expandEligiblityProfile;

	@FindBy(xpath="//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pdUpl:UPsp1:wkrPce:PCEcil2::icon\"]")
	public WebElement expandIncludeWorker;

	@FindBy(xpath="//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pdUpl:UPsp1:wkrPce:PCEcil1\"]")
	public WebElement clickAddworker;

	@FindBy(xpath = "//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pdUpl:UPsp1:wkrPce:wrkRgn:1:j1Pce:lv1Lv:0:pse1Pse:jidSis:perSrh::content\"]")
	public WebElement enterWorker;

	@FindBy(xpath="/(//div[contains(.,'373095')])[10]")
	public WebElement selectWorkerValue;

	@FindBy(xpath="//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pdUpl:UPsp1:wkrPce:wrkRgn:1:j1Pce:lv1Lv:0:pse1Pse:PSEcb2\"]")	
	public WebElement saveWorker;

	@FindBy(xpath="//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pdUpl:UPsp1:d1Pce:PCEcil2::icon\"]")
	public WebElement expandGoalPlan;

	@FindBy(xpath="//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pdUpl:UPsp1:d1Pce:addGBtn\"]")
	public WebElement clickGoalPlan;

	@FindBy(xpath="//input[contains(@name,'FONSr2:0:MAnt2:2:gdUpl:UPsp1:sh:gn1Inp')]")
	public WebElement enterGoalName;

	@FindBy(xpath="//textarea[contains(@name,'FONSr2:0:MAnt2:2:gdUpl:UPsp1:sh:dsc1Inp')]")
	public WebElement EnterbasicInfoMeasurement;

	@FindBy(xpath="//input[contains(@aria-owns,'FONSr2:0:MAnt2:2:gdUpl:UPsp1:sh:ccSel::pop')]")
	public WebElement EnterPerspective;

	@FindBy(xpath="//li[contains(.,'Process Perspective')]")
	public WebElement perspectiveValue;

	@FindBy(xpath="//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:2:gdUpl:UPsp1:sh:g10Inp::content\"]")
	public WebElement enterWeight;


	@FindBy(xpath = "//td[@class='x1kj'][contains(.,'Save and Close')]")
	public WebElement SaveandClose;

	@FindBy(xpath="//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pdUpl:UPsp1:d1Pce:goalRgn:1:goalPce:goalLv:0:goalPse:g1Lnk\"]/span")
	public WebElement validatebasicInoGoalPlan;

	@FindBy(xpath = "//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pdUpl:UPsp1:APscl2\"]/a")
	public WebElement saveandClosebtn;
	
	@FindBy(xpath = "//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:upl:UPsp1:SOPce:SO1Fs:hf03Cl\"]")
	public WebElement clearFilter;
	
	@FindBy(xpath="//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:upl:UPsp1:SOPce:SO1Fs:hf01Sis:hf01Srh::content\"]")
	public WebElement searchReviewPeriod;
	
	
	@FindBy(xpath = "//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:upl:UPsp1:SOPce:SO1Fs:hf04Sbv:SO1Pce:lv1Lv:1:SO1Pse:jgLnk\"]/span")
	public WebElement selectValue;
	///g[5]/path
	@FindBy(xpath = "//*[@id=\"_FOpt1:_UIShome::icon\"]")
	public WebElement homebtn;
	
	@FindBy(xpath = "//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:upl:UPsp1:SPdonei::icon\"]")
	public WebElement backBtn;
	
	
	// Schedule batch process
	@FindBy(xpath="//input[contains(@aria-owns,'_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:AP1:r1:basicReqBody:dynam1:0:soc1::pop')]")
	public WebElement processType;
	
	@FindBy(xpath="//li[contains(.,'Mass assign goals')]")
	public WebElement processTypeValue;
	
	@FindBy(xpath="//input[contains(@name,'FONSr2:0:MAnt2:0:AP1:r1:basicReqBody:dynam1:0:aTTRIBUTE3Id')]")
	public WebElement processName;
	
	@FindBy(xpath="//td[contains(.,'Submit')]")
	public WebElement submitButton;
	
	@FindBy(xpath="//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:AP1:r1:requestBtns:confirmationPopup:pt_ol1\"]/label")
	public WebElement ConfirmationMsg;
	
	@FindBy(xpath="//button[@type='button'][contains(@id,'FONSr2:0:MAnt2:0:AP1:r1:requestBtns:confirmationPopup:confirmSubmitDialog::ok')][contains(.,'OK')]")
	public WebElement okbutton;
	
	@FindBy(xpath="//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:AP1:cb1\"]")
	public WebElement moniterProcess;
	
	@FindBy(xpath="//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:AP1:r1:0:pt1:panel:processRefreshId::icon\"]")
	public WebElement refereshbutton;
	
	@FindBy(xpath = "//td[@class='xen'][contains(.,'Succeeded')]")
	public WebElement status;
	
	
	public MassAssignGoalsPage() {
		PageFactory.initElements(getDriver(), this);
		log.info("Create Goal Plans Page is initialized...");
	}


}
