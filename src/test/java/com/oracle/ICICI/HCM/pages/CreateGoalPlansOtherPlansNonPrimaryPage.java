package com.oracle.ICICI.HCM.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.acs.util.BrowserDriverUtil;

public class CreateGoalPlansOtherPlansNonPrimaryPage extends BrowserDriverUtil{
	
	Common_Library cmnLib = new Common_Library();
	private Logger log = Logger.getLogger(CreateGoalPlansOtherPlansNonPrimaryPage.class.getName());
	
	@FindBy(xpath="//*[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:upl:UPsp1:SOPce:SOBtn']")
	public WebElement otherPlanAddButton;
	
	@FindBy(xpath ="//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:gpUpl:UPsp1:d1sh:d1Inp::content\"]")
	public WebElement GoalPlanName;
	
	@FindBy(xpath="//textarea[contains(@name,'_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:gpUpl:UPsp1:d1sh:d2Inp')]")
	public WebElement measurements;
	
	@FindBy(xpath="//*[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:gpUpl:UPsp1:d1sh:d2Sel::content']")
	public WebElement reviewPeriod;
	@FindBy(xpath="//li[contains(.,'Test Review-Period FY2020-21')]")
	public WebElement reviewPeriodValue;
	
	@FindBy(xpath="//*[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:gpUpl:UPsp1:d1sh:smc1Sel::content']")
	public WebElement performanceDocType;
	
	@FindBy(xpath = "//*[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:gpUpl:UPsp1:d1sh:smc1Sel::pop']/li[4]/ul/li[2]/label")
	public WebElement PerformanceDocAnualEvaluation;
	
	
	@FindBy(xpath="//*[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:gpUpl:UPsp1:gp1Pce:PCEcil2::icon']")
	public WebElement expandGoalsPart;
	
	@FindBy(xpath="//div[contains(@title,'Collapse')]")
	public WebElement collapseGoalPart;
	
	// Enter Basic info of goal plan
	@FindBy(xpath="//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:gpUpl:UPsp1:gp1Pce:addGBtn\"]/a")
	public WebElement addGoalButton;
	
	@FindBy(xpath="//input[contains(@name,'FONSr2:0:MAnt2:2:gdUpl:UPsp1:sh:gn1Inp')]")
	public WebElement enterGoalName;
	
	@FindBy(xpath="//textarea[contains(@name,'FONSr2:0:MAnt2:2:gdUpl:UPsp1:sh:dsc1Inp')]")
	public WebElement EnterbasicInfoMeasurement;
	
	@FindBy(xpath="//input[contains(@aria-owns,'FONSr2:0:MAnt2:2:gdUpl:UPsp1:sh:ccSel::pop')]")
	public WebElement EnterPerspective;
	
	@FindBy(xpath="//li[contains(.,'Process Perspective')]")
	public WebElement perspectiveValue;
	
	@FindBy(xpath="//input[contains(@name,'FONSr2:0:MAnt2:2:gdUpl:UPsp1:sh:g17Inp')]")
	public WebElement enterWeight;
	
	@FindBy(xpath = "//td[@class='x1kj'][contains(.,'Save and Close')]")
	public WebElement SaveandClose;
	
	@FindBy(xpath="//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:gpUpl:UPsp1:gp1Pce:goalRgn:1:goalPce:goalLv:0:goalPse:g15Pgl\"]")
	public WebElement validatebasicInoGoalPlan;
	
	
	// Eligiblity Profile
	@FindBy(xpath="//*[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:gpUpl:UPsp1:elgPce:PCEcil2::icon']")
	public WebElement expandEligibility;
	
	
	@FindBy(xpath = "//*[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:gpUpl:UPsp1:elgPce:PCEcil1::icon']")
	public WebElement addeligbilityProfile;
	
	@FindBy(xpath="//input[contains(@aria-controls,'FONSr2:0:MAnt2:1:gpUpl:UPsp1:elgPce:elgRgn:1:j1Pce:lv1Lv:0:elpPse:jidSis:eligSrh::sgstnBdy')]")
	public WebElement enterEligiblityProfile;
	
	@FindBy(xpath = "(//div[contains(.,'HK_All Regular Employees')])[10]")
	public WebElement enterEligiblityProfileValue;
	
	
	@FindBy(xpath="//div[contains(@title,'Save Eligibility Profile')]")
	public WebElement saveEligiblityProfile;
	
	
	@FindBy(xpath="//span[contains(@id,'FONSr2:0:MAnt2:1:gpUpl:UPsp1:elgPce:elgRgn:1:j1Pce:lv1Lv:0:elpPse:soc2Sel::content')][@class='x2h']")
	public WebElement eligiblityProfileValue;
	
	@FindBy(xpath = "//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:gpUpl:UPsp1:APscl2\"]")
	public WebElement saveandClosebtn;
	
	
	
	@FindBy(xpath="//*[@id='_FOpt1:_UIShome::icon']")
	public WebElement HomeButton;
	
	@FindBy(xpath="//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAno\"]")
	public WebElement msgNo;
	
	@FindBy(xpath="//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:upl:UPsp1:SOPce:SO1Fs:hf04Sbv:SO1Pce:lv1Lv:4:SO1Pse:l2Lnk\"]/span")
	public WebElement generatedGoalPlan;
	
	@FindBy(xpath = "//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:upl:UPsp1:SOPce:SO1Fs:hf03Cl\"]")
	public WebElement clearFilter;
	
	@FindBy(xpath="//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:upl:UPsp1:SPdonei::icon\"]")
	public WebElement backButton;
	
	@FindBy(xpath="//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:upl:UPsp1:SOPce:SO1Fs:hf01Sis:hf01Srh::content\"]")
	public WebElement searchReviewPeriod;
	
	@FindBy(xpath = "//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:upl:UPsp1:SOPce:SO1Fs:hf01Sis:hf01Srh::item0\"]/td[1]/div")
	public WebElement selectValue;
	
	
	
	
	public CreateGoalPlansOtherPlansNonPrimaryPage() {
		PageFactory.initElements(getDriver(), this);
		log.info("Create Goal Plans Page is initialized...");
	}

	public boolean verifyGoalPlanInResults (String planName) throws Exception
	{
		boolean found = false;
		List<WebElement> goalplan = getDriver().findElements(By.xpath("//a[contains(@id,'_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:upl:UPsp1:SOPce:SO1Fs:hf04Sbv:SO1Pce:lv1Lv:')]/span"));
		for(WebElement plan : goalplan)
		{
			System.out.println("Goal plan Name : " + plan);
			if(plan.getText().equalsIgnoreCase(planName))
			{
				found = true;
			}
		}
		
		return found;
		
	}
}
