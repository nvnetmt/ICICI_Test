package com.oracle.ICICI.common.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;
import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.acs.util.BrowserDriverUtil;

public class HomePage extends BrowserDriverUtil {

	Common_Library cmnLib = new Common_Library();
	private Logger log = Logger.getLogger(HomePage.class.getName());

	@FindBy(xpath = "//*[contains(@id,'pt1:_UIShome::icon')]")
	public WebElement HomeButton;

	@FindBy(css = "a[id='groupNode_my_information']")
	public WebElement lnkMe;

	@FindBy(xpath = "//svg[@data-icon='navi_persontarget']")
	public WebElement MyClientGroupMenu;
	
	@FindBy(css = "a[id='groupNode_workforce_management']")
	public WebElement lnkMyClientGroups;
	
	@FindBy(css = "a[id='groupNode_manager_resources']")
	public WebElement lnkMyTeam;
		
	@FindBy(css = "a[id*='itemNode_my_team_CareerandPerformance']")
	public WebElement lnkCareerAndPerformance;
	
	@FindBy(css = "a[id^='itemNode_manager_resources_CareerandPerformance']")
	public WebElement lnkCareerAndPerformance_Me;
	
	@FindBy(css = "a[id*='workforce_management_career_goals']")
	public WebElement lnkGoals;

	@FindBy(xpath = "//*[@id='workforce_management_career_goals_responsive_0']")
	public WebElement GoalMenu;

	@FindBy(xpath = "//*[@id=\"groupNode_my_information\"]")
	public WebElement meMenu;

	@FindBy(xpath = "//*[@id=\"showmore_groupNode_my_information\"]")
	public WebElement showMoreLink;

	@FindBy(xpath = "//h4[contains(.,'Career and Performance')]")
	public WebElement careerAndPerformanceMenu;

	@FindBy(xpath="//a[contains(text(),'Career and Performance')]")
	public WebElement EmpCareerAndPerformance;
	
	@FindBy(xpath="//span[text()='Goals']")
	public WebElement EmpGoals;
	
	@FindBy(xpath = "(//div[@class='flat-quickactions-container'][contains(.,'Goals')])[2]")
	public WebElement goalsMenu;

	@FindBy(xpath = "//*[@id=\"groupNode_manager_resources\"]")
	public WebElement myTeamMenu;

	@FindBy(xpath = "//*[@id=\"all_quickactions_groupNode_manager_resources\"]/div[11]/div[2]/div/div/a")
	public WebElement QuickactionGoal;

	@FindBy(xpath = "(//div[@class='flat-quickactions-container'][contains(.,'Goals')])[3]")
    public WebElement goalMenu;

	@FindBy(xpath = "//*[@id='showmore_groupNode_workforce_management']")
	public WebElement showMoreLinkUnderMyClientGroupMenu;

	@FindBy(xpath = "//h4[contains(.,'Talent')]")
	public WebElement talentLink;

	@FindBy(xpath = "//div[contains(@target,'my_org_perf_PerformanceManagement_EligibilityProfiles_admin')]")
	public WebElement EligibilityProfileMenu;

	@FindBy(xpath = "//div[@class='flat-quickactions-container'][contains(.,'Goal Plans')]")
	public WebElement GoalPlanMenu;

	@FindBy(xpath = "//div[@class='flat-quickactions-container'][contains(.,'Setup of Performance Goals Mass Assignment')]")
	public WebElement SetupofPerformanceGoalsMassAssignmentMenu;

	@FindBy(xpath = "//div[@class='flat-quickactions-container'][contains(.,'Scheduled Processes for Performance Goals')]")
	public WebElement ScheduledProcessesforPerformanceGoals;

	@FindBy(xpath = "//div[@class='flat-quickactions-container'][contains(.,'Review Periods')]")
	public WebElement ReviewPeriodsMenu;

	@FindBy(xpath = "(//div[@class='flat-quickactions-container'][contains(.,'Performance Goals')])[1]")
	public WebElement performanceGoalMenu;

	@FindBy(xpath = "//div[contains(@target,'my_org_manage_performance_documents')]")
	public WebElement performanceDocumentMenu;
	
	@FindBy(css = "a[id='itemNode_my_information_absences1_0']")
	public WebElement lnkLeaveAndMuster_Me;

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
		log.info("HomePage is initialized...");

	}

}
