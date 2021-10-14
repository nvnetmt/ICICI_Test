package com.oracle.ICICI.HCM.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.acs.util.BrowserDriverUtil;

public class ManageEligibilityProfilePage extends BrowserDriverUtil {

	Common_Library cmnLib = new Common_Library();
	private Logger log = Logger.getLogger(ManageEligibilityProfilePage.class.getName());
	
	@FindBy(xpath = "//td[contains(@id,'ATp:ctb1::popArea')]")
	public WebElement createButton;
	
	@FindBy(xpath="//td[@class='xnv'][contains(.,'Create Participant Profile')]")
	public WebElement CreateParticipantProfileLink;
	
	@FindBy(xpath = "//input[contains(@name,'_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:AP2:Eligi1:0:it1')]")
	public WebElement EnterName;
	
	@FindBy(xpath= "//input[contains(@name,'FONSr2:0:MAnt2:1:AP2:Eligi1:0:it3')]")
	public WebElement EnterDescription;
	
	@FindBy(xpath = "//a[@tabindex='-1'][contains(@id,'FONSr2:0:MAnt2:1:AP2:Eligi1:0:soc1::drop')]")
	public WebElement profileUses;
	
	@FindBy(xpath="//li[@class='x1n8'][contains(.,'Goals Management')]")
	public WebElement GoalMangementValue;
	
	@FindBy(xpath="//*[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:AP2:Gende1:0:AT1:_ATp:create::icon']")
	public WebElement createPersonalBtn;
	
	@FindBy(xpath="//input[contains(@name,'ATp:table1:0:it1')]")
	public WebElement personalSequence;
	
	@FindBy(xpath="//input[@role='combobox'][contains(@id,'ATp:table1:0:soc1::content')]")
	public WebElement genderField;
	
	@FindBy(xpath="//li[contains(.,'Male')]")
	public WebElement gender;
	
	@FindBy(xpath="//div[@class='x1il'][contains(.,'Employment')]")
	public WebElement employmentLink;
	
	@FindBy(xpath = "//div[@class='x1il'][contains(.,'Grade')]")
	public WebElement gradeLink;
	
	@FindBy(xpath = "//*[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:AP2:Grade1:0:AT1:_ATp:create::icon']")
	public WebElement createGradeButton;
	
	@FindBy(xpath="//input[contains(@name,'ATp:table1:0:it1')]")
	public WebElement gradeSequence;
	
	@FindBy(xpath= "//input[contains(@name,'ATp:table1:0:gradeNameId')]")
	public WebElement grade;
	
	@FindBy(xpath="//input[contains(@name,'ATp:table1:0:gradeNameId')]")
	public WebElement gradeName;
	
	
	@FindBy(xpath="//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:AP2:Grade1:0:AT1:_ATp:table1:0:gradeNameId_afrLovInternalTableId::ch::t\"]")
	public WebElement gradeTable;
	
	@FindBy(xpath = "//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:AP2:Grade1:0:AT1:_ATp:table1:0:gradeNameId_afrLovInternalTableId::db\"]/table/tbody/tr[1]/td[1]")
	public WebElement selectGrade;
	
	@FindBy(xpath = "//div[@class='x1il'][contains(.,'Department')]")
	public WebElement departmentLink;
	
	@FindBy(xpath = "//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:AP2:Organ1:0:AT1:_ATp:create::icon\"]")
	public WebElement createDepartmentButton;
	
	@FindBy(xpath="//input[contains(@name,'ATp:table1:0:it1')]")
	public WebElement departmentSequence;
	
	@FindBy(xpath = "//input[contains(@name,'ATp:table1:0:deptNameId')]")
	public WebElement departmentName;
	
	@FindBy(xpath = "(//div[contains(.,'Save and Close')])[59]")
	public WebElement SaveAndClose;
	
	@FindBy(xpath="//input[contains(@name,'FONSr2:0:MAnt2:0:AP1:q1:value00')]")
	public WebElement createdEligibilityName;
	
	
	@FindBy(xpath="//button[contains(.,'Search')]")
	public WebElement searchButton;
	
	@FindBy(xpath="//*[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:AP1:AT2:_ATp:t1::db']/table/tbody/tr/td[2]/div/table/tbody/tr/td[1]")
	public WebElement EligiblityProfileList;
	
	@FindBy(xpath="//*[@id='_FOpt1:_UIShome::icon']")
	public WebElement HomeButton;
	
	
	//*******************
	@FindBy(xpath="//h1[text()='Eligibility Profiles']")
	public WebElement hdrEligibilityProfiles;
	
	@FindBy(css="a[title='Create']")
	public WebElement lnkCreate;
	
	@FindBy(xpath="//td[text()='Create Participant Profile']")
	public WebElement lnkCreateParticipantProfile;
	
	@FindBy(xpath="//label[text()='Name']//ancestor::tr[1]//input")
	public WebElement txtName;
	
	@FindBy(css="button[id$='q1::search']")
	public WebElement btnSearch;
	
	@FindBy(css="table[summary='Eligibility Profiles']>tbody")
	public WebElement tblBdySearchResults;
	
	public ManageEligibilityProfilePage() {
		PageFactory.initElements(getDriver(), this);
		log.info("Manage Eligibility Profile Page is initialized...");
	}
}
