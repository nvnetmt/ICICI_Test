package com.oracle.ICICI.common.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.oracle.ICICI.HCM.pages.CareerAndPerformancePage;
import com.oracle.ICICI.HCM.pages.GoalsAndPerformanceOverviewPage;
import com.oracle.ICICI.HCM.pages.GoalsPage;
import com.oracle.ICICI.HCM.pages.LeaveAndMusterPage;
import com.oracle.ICICI.HCM.pages.ManageEligibilityProfilePage;
import com.oracle.ICICI.HCM.pages.PrintExistingGoalsPage;
import com.oracle.ICICI.HCM.pages.ReviewPeriodsPage;
import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.ICICI.common.pages.HomePage;
import com.oracle.acs.util.BrowserDriverUtil;

import io.cucumber.java.en.Then;
import com.oracle.acs.util.report.ReportGeneration;

public class HomePageSteps extends BrowserDriverUtil {

	public static ReportGeneration rpt = ReportingSteps.getRpt();
	Common_Library cmnLib = ReportingSteps.cmnLib;

	HomePage homePage = new HomePage();
	GoalsPage goalsPage = new GoalsPage();
	ManageEligibilityProfilePage eligibilityProfilePage = new ManageEligibilityProfilePage();
	ReviewPeriodsPage reviewPeriodsPage = new ReviewPeriodsPage();

	PrintExistingGoalsPage pEpage=new PrintExistingGoalsPage();
	LeaveAndMusterPage LMPage=new LeaveAndMusterPage();
	
	String EmployeeDisplayedName;

	@Then("^Click on Home button$")
	public void ClickOnHomeButton() throws Throwable {
		
		TimeUnit.SECONDS.sleep(10);

		if (cmnLib.clickOnWebElement(homePage.HomeButton) && cmnLib.waitForElementToBeVisible(homePage.lnkMe)) {
			rpt.generateReport("", "Click Home icon", "", "", "Homepage must be displayed", "Homepage displayed",
					"Passed", "", true);
		} else {
			rpt.generateReport("", "Click Home icon", "", "", "Homepage must be displayed",
					"Either not clicked on Home icon or Homepage not displayed", "Failed", "", true);
			Assert.fail("Either not clicked on Home icon or Homepage not displayed");

		}

	}

	@Then("^Navigate To My Client Group Menus$")
	public void clickOnMyClientGropMenu() {

		try {
			TimeUnit.SECONDS.sleep(10);
			cmnLib.clickOnLinkText("My Client Groups");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^Navigate To My Team Menus$")
	public void clickOnMyteam() {

		try {
			TimeUnit.SECONDS.sleep(10);
			cmnLib.clickOnLinkText("My Team");
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Then("^Navigate To Eligibility Profiles page$")
	public void navigateToEligibilityProfilesPage() throws Throwable {

		// Click My Client Groups
		if (!cmnLib.clickOnWebElement(homePage.lnkMyClientGroups)
				&& cmnLib.waitForElementToBeVisible(homePage.lnkGoals)) {
			rpt.generateReport("", "Click My Client Groups link", "", "", "Goals option must be displayed",
					"Either not clicked on My Client Groups link or Goals option not displayed", "Failed", "", true);
			Assert.fail("Either not clicked on My Client Groups link or Goals option not displayed");
		} else {
			rpt.generateReport("", "Click My Client Groups link", "", "", "Goals option must be displayed",
					"Goals option displayed", "Passed", "", true);
		}

		// Click Goals Link
		if (!cmnLib.clickOnWebElement(homePage.lnkGoals) && cmnLib.waitForElementToBeVisible(goalsPage.hdrGoals)) {
			rpt.generateReport("", "Click Goals link", "", "", "Goals page must be displayed",
					"Either not clicked on Goals link or Goals page not displayed", "Failed", "", true);
			Assert.fail("Either not clicked on Goals link or Goals page not displayed");
		} else {
			rpt.generateReport("", "Click Goals link", "", "", "Goals page must be displayed", "Goals page displayed",
					"Passed", "", true);
		}

		// Click Eligibility Profiles link
		cmnLib.waitForElementToBeVisible(goalsPage.lnkEligibilityProfiles);
		cmnLib.waitForPageLoaded();
		if (!cmnLib.clickOnWebElement(goalsPage.lnkEligibilityProfiles)
				&& cmnLib.waitForElementToBeVisible(eligibilityProfilePage.hdrEligibilityProfiles)) {
			rpt.generateReport("", "Click Eligibility Profiles link", "", "",
					"Eligibility Profiles page must be displayed",
					"Either not clicked on Eligibility Profiles link or Eligibility Profiles page not displayed",
					"Failed", "", true);
		} else {
			rpt.generateReport("", "Click Eligibility Profiles link", "", "",
					"Eligibility Profiles page must be displayed", "Eligibility Profiles page displayed", "Passed", "",
					true);
		}

	}

	@Then("^Navigate To Goals Menus$")
	public void clickOnGoalMenu() {

		try {
			TimeUnit.SECONDS.sleep(10);
			cmnLib.clickOnWebElement(homePage.GoalMenu);
			TimeUnit.SECONDS.sleep(10);
			if (getDriver().getTitle().contains("Goals")) {
				rpt.generateReport("", "Navigate to Goals Page", "", "", "Goals Page must must be open",
						"Goals page is open", "Passed", "", true);

			} else {

				rpt.generateReport("", "Navigate to Goals Page", "", "", "Goals Page must must be open",
						"Failed to load Goals page", "Failed", "", true);

				Assert.fail("Failed to load Goals Page");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^Navigate To My Team Goals page$")
	public void navigate_To_Goals_page() {
		try {

			rpt.enterStepHeader("Navigate to My Team goals page");
			// Click on Show more link

			cmnLib.clickOnLinkText("Show More");
			// Click in Talent link
			cmnLib.clickOnWebElement(homePage.careerAndPerformanceMenu);

			// Click on Goal icon
			cmnLib.clickOnWebElement(homePage.goalMenu);
			cmnLib.waitForPageLoaded();
			TimeUnit.SECONDS.sleep(15);
			if (getDriver().getTitle().contains("Goals")) {
				rpt.generateReport("", "Navigate to My Teams goals Page", "", "",
						"Goals link must be clicked and My Teams Goal page must be displayed",
						"Clicked on Goals link and My Team Goals page displayed", "Passed", "", true);

			} else {

				rpt.generateReport("", "Navigate to My Teams goals Page", "", "",
						"Goals link must be clicked and My Teams Goal page must be displayed",
						"Either not clicked on My goals link or My Team Goal page not displayed", "Failed", "", true);

				Assert.fail("Either not clicked on My goals link or My Team Goal page not displayed");

				TimeUnit.SECONDS.sleep(2);

				// Assert.fail("Failed to load my goals Page");

				Thread.sleep(5000);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^Navigate To My Goals page$")
	public void navigate_To_My_Goals_page() {

		try {

			rpt.enterStepHeader("Navigate to my goals page");
			// Click on Show more link
			cmnLib.clickOnLinkText("Show More");
			// Click in Talent link
			cmnLib.clickOnWebElement(homePage.careerAndPerformanceMenu);
			// Click on Goal menu
			cmnLib.clickOnWebElement(homePage.goalsMenu);
			cmnLib.waitForPageLoaded();
			TimeUnit.SECONDS.sleep(5);
			if (getDriver().getTitle().contains("Goals")) {
				rpt.generateReport("", "Navigate to My goals Page", "", "",
						"Goals link must be clicked and Goal page must be displayed",
						"Clicked on Goals link and Goal page displayed", "Passed", "", true);

			} else {

				rpt.generateReport("", "Navigate to My goals Page", "", "",
						"Goals link must be clicked and Goal page must be displayed",
						"Either not clicked on My goals link or Goal page not displayed", "Failed", "", true);

				Assert.fail("Either not clicked on My goals link or Goal page not displayed");

				TimeUnit.SECONDS.sleep(2);

				// Assert.fail("Failed to load my goals Page");

				Thread.sleep(5000);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("^Navigate To Eligiblity Profile page$")
	public void navigate_To_Eligiblity_Profile_page() {
		try {

			rpt.enterStepHeader("Navigate to Eligiblity profile page");
			// Click on Show more link
			cmnLib.clickOnLinkText("Show More");
			// Click in Talent link
			cmnLib.clickOnWebElement(homePage.talentLink);
			// Click on Eligibility Profile menu
			cmnLib.clickOnWebElement(homePage.EligibilityProfileMenu);
			cmnLib.waitForPageLoaded();
			if (getDriver().getTitle().contains("Eligibility Profiles")) {
				rpt.generateReport("", "Navigate to Eligiblity profile Page", "", "",
						"Eligiblity profile Page must must be open", "Eligiblity profile page is open", "Passed", "",
						true);

			} else {

				rpt.generateReport("", "Navigate to Eligiblity profile Page", "", "",
						"Eligiblity profile Page must must be open", "Failed to load Eligiblity profile page", "Failed",
						"", true);

				// Assert.fail("Failed to load Eligiblity profile Page");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("^Navigate To Goal Plan page$")
	public void navigate_To_Goal_Plan_page() {
		try {

			rpt.enterStepHeader("Navigate to Goal Plans page");
			// Click on Show more link
			cmnLib.clickOnLinkText("Show More");
			// Click in Talent link
			cmnLib.clickOnWebElement(homePage.talentLink);
			// Click on Eligibility Profile menu
			cmnLib.clickOnWebElement(homePage.GoalPlanMenu);
			cmnLib.waitForPageLoaded();
			TimeUnit.SECONDS.sleep(15);

			if (getDriver().getTitle().contains("Goal Plans")) {
				rpt.generateReport("", "Navigate to Goal Plan Page", "", "", "Goal Plan Page must must be open",
						"Goal Plan page is open", "Passed", "", true);

			} else {

				rpt.generateReport("", "Navigate to Goal Plan Page", "", "", "Goal Plan Page must must be open",
						"Failed to load Goal Plan page", "Failed", "", true);

				// Assert.fail("Failed to load Goal Plan Page");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("^Navigate To Setup of Performance Goals Mass Assignment Page$")
	public void navigate_To_Setup_of_Performance_Goals_Mass_Assignment_Page() throws Throwable {
		try {
			rpt.enterStepHeader("Navigate to Setup of Performance Goals Mass Assignment page");
			// Click on Show more link
			cmnLib.clickOnLinkText("Show More");
			// Click in Talent link
			cmnLib.clickOnWebElement(homePage.talentLink);
			// Click on Eligibility Profile menu
			cmnLib.clickOnWebElement(homePage.SetupofPerformanceGoalsMassAssignmentMenu);
			cmnLib.waitForPageLoaded();
			TimeUnit.SECONDS.sleep(15);

			if (getDriver().getTitle().contains("Setup of Performance Goals Mass Assignment")) {
				rpt.generateReport("", "Navigate to Setup of Performance Goals Mass Assignment Page", "", "",
						"Setup of Performance Goals Mass Assignment page must be open",
						"Goal PlanSetup of Performance Goals Mass Assignment page is open", "Passed", "", true);

			} else {

				rpt.generateReport("", "Navigate to Setup of Performance Goals Mass Assignment Page", "", "",
						"Setup of Performance Goals Mass Assignment Page must must be open",
						"Failed to load Setup of Performance Goals Mass Assignment page", "Failed", "", true);

				// Assert.fail("Failed to load Setup of Performance Goals Mass Assignment
				// Page");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("^Navigate To Scheduled Processes for Performance Goals Page$")
	public void Navigate_To_Scheduled_Processes_for_Performance_Goals_Page() throws Throwable {
		try {
			rpt.enterStepHeader("Navigate to Setup of Performance Goals Mass Assignment page");
			// Click on Show more link
			cmnLib.clickOnLinkText("Show More");
			// Click in Talent link
			cmnLib.clickOnWebElement(homePage.talentLink);
			// Click on Eligibility Profile menu
			cmnLib.clickOnWebElement(homePage.ScheduledProcessesforPerformanceGoals);
			cmnLib.waitForPageLoaded();
			TimeUnit.SECONDS.sleep(15);

			if (getDriver().getTitle().contains("Oracle")) {
				rpt.generateReport("", "Navigate to Scheduled Processes for Performance Goals Page", "", "",
						"Scheduled Processes for Performance Goals page must be open",
						"Scheduled Processes for Performance Goals page is open", "Passed", "", true);

			} else {

				rpt.generateReport("", "Navigate to Scheduled Processes for Performance Goals Page", "", "",
						"Scheduled Processes for Performance Goals Page must must be open",
						"Failed to load Scheduled Processes for Performance Goals page", "Failed", "", true);

				// Assert.fail("Failed to load Scheduled Processes for Performance Goals Page");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("^Navigate To Review Periods Page$")
	public void Navigate_To_Review_Period_Pages() throws Throwable {
		// Click My Client Groups
		rpt.enterStepHeader("Navigate to Review Periods page");
		if (!cmnLib.clickOnWebElement(homePage.lnkMyClientGroups)
				&& cmnLib.waitForElementToBeVisible(homePage.lnkGoals)) {
			rpt.generateReport("", "Click My Client Groups link", "", "", "Goals option must be displayed",
					"Either not clicked on My Client Groups link or Goals option not displayed", "Failed", "", true);
			Assert.fail("Either not clicked on My Client Groups link or Goals option not displayed");
		} else {
			rpt.generateReport("", "Click My Client Groups link", "", "", "Goals option must be displayed",
					"Goals option displayed", "Passed", "", true);
		}

		// Click Goals Link
		if (!cmnLib.clickOnWebElement(homePage.lnkGoals) && cmnLib.waitForElementToBeVisible(goalsPage.hdrGoals)) {
			rpt.generateReport("", "Click Goals link", "", "", "Goals page must be displayed",
					"Either not clicked on Goals link or Goals page not displayed", "Failed", "", true);
			Assert.fail("Either not clicked on Goals link or Goals page not displayed");
		} else {
			rpt.generateReport("", "Click Goals link", "", "", "Goals page must be displayed", "Goals page displayed",
					"Passed", "", true);
		}

		// Click Review Periods link
		cmnLib.waitForElementToBeVisible(goalsPage.lnkReviewPeriods);
		cmnLib.waitForPageLoaded();
		if (!cmnLib.clickOnWebElement(goalsPage.lnkReviewPeriods)
				&& cmnLib.waitForElementToBeVisible(reviewPeriodsPage.hdrReviewPeriods)) {
			rpt.generateReport("", "Click Review Periods link", "", "", "Review Periods page must be displayed",
					"Either not clicked on Review Periods link or Review Periods page not displayed", "Failed", "",
					true);
		} else {
			rpt.generateReport("", "Click Review Periods link", "", "", "Review Periods page must be displayed",
					"Review Periods page displayed", "Passed", "", true);
		}

	}
	
	
	@Then("^Navigate to Performance Goals Page$")
	public void navigate_to_Performance_Goals_Page() throws Throwable {
		
		// Click My Client Groups
			rpt.enterStepHeader("Navigate to Performance Goals Page");
			if (!cmnLib.clickOnWebElement(homePage.lnkMyClientGroups)
					&& cmnLib.waitForElementToBeVisible(homePage.showMoreLink)) {
				rpt.generateReport("", "Click My Client Groups link", "", "", "Show More option must be displayed",
						"Either not clicked on My Client Groups link or Show More option not displayed", "Failed", "", true);
				Assert.fail("Either not clicked on My Client Groups link or Show More option not displayed");
			} else {
				rpt.generateReport("", "Click My Client Groups link", "", "", "Show More option must be displayed",
						"Show More option displayed", "Passed", "", true);
			}

			// Click Show More Link
			if (!cmnLib.clickOnWebElement(homePage.showMoreLink) && cmnLib.waitForElementToBeVisible(pEpage.lnkPerformanceGoals)) {
				rpt.generateReport("", "Click Show More Link", "", "", "Performance Goals option must be displayed",
						"Either not clicked on Show More Link or Performance Goals option not displayed", "Failed", "", true);
				Assert.fail("Either not clicked on Show More Link or Performance Goals option not displayed");
			} else {
				rpt.generateReport("", "Click Show More Link", "", "", "Performance Goals option must be displayed", "Performance Goals option displayed",
						"Passed", "", true);
			}

			//Click Performance Goals link
			
			if (!cmnLib.clickOnWebElement(pEpage.lnkPerformanceGoals) && cmnLib.waitForElementToBeVisible(pEpage.hdrPerformanceGoals)) {
				rpt.generateReport("", "Click Performance Goals link", "", "", "Performance Goals page must be displayed",
						"Either not clicked on Performance Goals link or Performance Goals page not displayed", "Failed", "", true);
				Assert.fail("Either not clicked on Performance Goals link or Performance Goals page not displayed");
			} else {
				rpt.generateReport("", "Click Performance Goals link", "", "", "Performance Goals page must be displayed", "Performance Goals page displayed",
						"Passed", "", true);
			}
			
			
		
	    
	}

	@Then("^Navigate To Setup of Performance GoalsPage$")
	public void navigate_To_Setup_of_Performance_Goals_Page() throws Throwable {
		try {
			rpt.enterStepHeader("Navigate to Setup of Performance Goals page");
			// Click on Show more link
			cmnLib.clickOnLinkText("Show More");
			// Click in Talent link
			cmnLib.clickOnWebElement(homePage.talentLink);
			// Click on Eligibility Profile menu
			cmnLib.clickOnWebElement(homePage.performanceGoalMenu);
			cmnLib.waitForPageLoaded();
			TimeUnit.SECONDS.sleep(15);

			if (getDriver().getTitle().contains("Performance Goals")) {
				rpt.generateReport("", "Navigate to Performance Goals Page", "", "",
						"Performance Goals page must be open", "Performance Goals page is open", "Passed", "", true);

			} else {

				rpt.generateReport("", "Navigate to Performance Goals Page", "", "",
						"Performance Goals Page must must be open", "Failed to load Performance Goals page", "Failed",
						"", true);

				// Assert.fail("Failed to load Performance Goals Page");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("^Navigate To Performance Document page$")
	public void navigate_To_Performance_Documente_page() {
		try {

			rpt.enterStepHeader("Navigate to Performance Document page");
			// Click on Show more link
			cmnLib.clickOnLinkText("Show More");
			// Click in Talent link
			cmnLib.clickOnWebElement(homePage.talentLink);
			// Click on Eligibility Profile menu
			cmnLib.clickOnWebElement(homePage.performanceDocumentMenu);
			cmnLib.waitForPageLoaded();
			if (getDriver().getTitle().contains("Performance Documents")) {
				rpt.generateReport("", "Navigate to Performance Documents Page", "", "",
						"Performance Documents Page must must be open", "Performance Documents page is open", "Passed",
						"", true);

			} else {

				rpt.generateReport("", "Navigate to Performance Documents Page", "", "",
						"Performance Documents Page must must be open", "Failed to load Performance Documents page",
						"Failed", "", true);

				// Assert.fail("Failed to load Performance Documents Page");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("^Navigate To Performance Document Eligibility page$")
	public void navigate_To_Performance_Document_Eligibility_page() {
		try {

			rpt.enterStepHeader("Navigate to Performance Document Eligibility page");

			cmnLib.clickOnLinkText("Performance");

			cmnLib.clickOnLinkText("Performance Document Eligibility");

			cmnLib.waitForPageLoaded();

			if (getDriver().getTitle().contains("Performance Document")) {
				rpt.generateReport("", "Navigate to Performance Document Eligibility Page", "", "",
						"Performance Document Eligibility Page must must be open",
						"Performance Document Eligibility page is open", "Passed", "", true);

			} else {

				rpt.generateReport("", "Navigate to Performance Document Eligibility Page", "", "",
						"Performance Document Eligibility Page must must be open",
						"Failed to load Performance Document Eligibility page", "Failed", "", true);

				// Assert.fail("Failed to load Performance Document Eligibility Page");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("^Navigate to Goals and Performance Overview page$")
	public void Navigate_To_Goals_and_Performance_Overview_page() throws Throwable {
		// Click My Team
		rpt.enterStepHeader("Navigate to Goals and Performance Overview page");
		if (!cmnLib.clickOnWebElement(homePage.lnkMyTeam)
				&& cmnLib.waitForElementToBeVisible(homePage.lnkCareerAndPerformance)) {
			rpt.generateReport("", "Click My Team link", "", "", "Career and Performace option must be displayed",
					"Either not clicked on My Team link or Career and Performace option not displayed", "Failed", "",
					true);
			Assert.fail("Either not clicked on My Team link or Career and Performace option not displayed");
		} else {
			rpt.generateReport("", "Click My Team link", "", "", "Career and Performace option must be displayed",
					"Career and Performace option displayed", "Passed", "", true);
		}

		// Click Career And Performance Link
		GoalsAndPerformanceOverviewPage goalsAndPerformancePage = new GoalsAndPerformanceOverviewPage();
		if (!cmnLib.clickOnWebElement(homePage.lnkCareerAndPerformance)
				&& cmnLib.waitForElementToBeVisible(goalsAndPerformancePage.hdrGoalsAndPerformance)) {
			TimeUnit.SECONDS.sleep(3);
			rpt.generateReport("", "Click Career and Performance link", "", "",
					"Goals and Performance page must be displayed",
					"Either not clicked on Career and Performance link or Goals and Performance page not displayed",
					"Failed", "", true);
			Assert.fail(
					"Either not clicked on Career and Performance link or Goals and Performance page not displayed");
		} else {
			rpt.generateReport("", "Click Career and Performance link", "", "",
					"Goals and Performance page must be displayed", "Goals and Performance page displayed", "Passed",
					"", true);
		}

	}

	@Then("^Click Me and navigate to Goals page$")
	public void click_Me_and_navigate_to_Goals_page() throws Throwable {
		// Click Me
		rpt.enterStepHeader("Navigate to Goals page");
		if (!cmnLib.clickOnWebElement(homePage.lnkMe)
				&& cmnLib.waitForElementToBeVisible(homePage.lnkCareerAndPerformance_Me)) {
			rpt.generateReport("", "Click Me link", "", "", "Career and Performace option must be displayed",
					"Either not clicked on Me link or Career and Performace option not displayed", "Failed", "", true);
			Assert.fail("Either not clicked on Me link or Career and Performace option not displayed");
		} else {
			rpt.generateReport("", "Click Me link", "", "", "Career and Performace option must be displayed",
					"Career and Performace option displayed", "Passed", "", true);
		}

		// Click Career And Performance Link
		CareerAndPerformancePage capPage = new CareerAndPerformancePage();
		if (!cmnLib.clickOnWebElement(homePage.lnkCareerAndPerformance_Me)
				&& cmnLib.waitForElementToBeVisible(capPage.hdrCareerAndPerformance)) {
			rpt.generateReport("", "Click Career and Performance link", "", "",
					"Career and Performance page must be displayed",
					"Either not clicked on Career and Performance link or Career and Performance page not displayed",
					"Failed", "", true);
			Assert.fail(
					"Either not clicked on Career and Performance link or Career and Performance page not displayed");
		} else {
			rpt.generateReport("", "Click Career and Performance link", "", "",
					"Career and Performance page must be displayed", "Career and Performance page displayed", "Passed",
					"", true);
		}

		// Click Goals
		GoalsPage goalsPage = new GoalsPage();
		cmnLib.waitForElementToBeVisible(capPage.lnkGoals);
		if (!cmnLib.clickOnWebElement(capPage.lnkGoals) && cmnLib.waitForElementToBeVisible(goalsPage.hdrGoals)) {
			rpt.generateReport("", "Click Goals link", "", "", "Goals page must be displayed",
					"Either not clicked on Goals link or Goals page not displayed", "Failed", "", true);
			Assert.fail("Either not clicked on Goals link or Goals page not displayed");
		} else {
			rpt.generateReport("", "Click Goals link", "", "", "Goals page must be displayed", "Goals page displayed",
					"Passed", "", true);
		}
	}
	

    @Then("^Navigate to Leave and Muster Page$")
    public void navigate_to_Leave_and_Muster_Page() throws Throwable {
    
    	// Click Me
    			rpt.enterStepHeader("Navigate to Leave and Muster Page");
    			if (!cmnLib.clickOnWebElement(homePage.lnkMe)
    					&& cmnLib.waitForElementToBeVisible(homePage.lnkLeaveAndMuster_Me)) {
    				rpt.generateReport("", "Click Me link", "", "", "Leave and Muster option must be displayed",
    						"Either not clicked on Me link or Leave and Musteroption not displayed", "Failed", "", true);
    				Assert.fail("Either not clicked on Me link or Leave and Muster option not displayed");
    			} else {
    				rpt.generateReport("", "Click Me link", "", "", "Leave and Muster option must be displayed",
    						"Leave and Muster option displayed", "Passed", "", true);
    			}

    			// Click Leave and Muster Link
    			
    			if (!cmnLib.clickOnWebElement(homePage.lnkLeaveAndMuster_Me)
    					&& cmnLib.waitForElementToBeVisible(LMPage.hdrLeaveAndMuster,30)) {
    				rpt.generateReport("", "Click Leave and Muster link", "", "",
    						"Leave and Muster must be displayed",
    						"Either not clicked on Leave and Muster link or Leave and Muster page not displayed",
    						"Failed", "", true);
    				Assert.fail(
    						"Either not clicked on Leave and Muster link or Leave and Muster page not displayed");
    			} else {
    				rpt.generateReport("", "Click Leave and Muster link", "", "",
    						"Leave and Muster page must be displayed", "Leave and Muster page displayed", "Passed",
    						"", true);
    			}

    		
    		}
    
    @Then("^Retrieve_Text$")
	public String retrieve_Text() throws Throwable {
		try {
		String RetrievedText;
		WebElement GreetingMessage = cmnLib
				.getElement(By.xpath("//h1[contains(text(),'Good')]"));
		if (cmnLib.waitForElementToBeVisible(GreetingMessage)) {
			RetrievedText = GreetingMessage.getText();
			EmployeeDisplayedName=RetrievedText.split("[,!]")[1];
			rpt.generateReport("", "Employee name retrieved", "", "",
					"Employee name must be retrieved",
					"Retrieved Employee name", "Passed", "", true);
		} 
		else {
			rpt.generateReport("", "Employee name retrieved", "", "",
					"Employee name must be retrieved",
					"Not retrieved Employee name", "Failed",
					"", true);
			Assert.fail("Not retrieved Employee name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EmployeeDisplayedName;
	}
    @Then("^Navigate To Me Menu$")
	public void clickOnMeMenu() {

		try {
			TimeUnit.SECONDS.sleep(10);
			cmnLib.clickOnLinkText("Me");
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    @Then("^Navigate To Emp Goals page$")
	public void navigate_To_Emp_Goals_page()  {
		try {
			
			rpt.enterStepHeader("Navigate to my goals page");
			cmnLib.clickOnWebElement(homePage.EmpCareerAndPerformance);
			TimeUnit.SECONDS.sleep(15);			
			cmnLib.clickOnWebElement(homePage.EmpGoals);
			cmnLib.waitForPageLoaded();
			TimeUnit.SECONDS.sleep(15);
			if (getDriver().getTitle().contains("Goals")) {
				rpt.generateReport("", "Navigate to my goals Page", "", "", "My goals Page must must be open",
						"My goals page is open", "Passed", "", true);

			} else {

				rpt.generateReport("", "Navigate to my goals Page", "", "", "My goals Page must must be open",
						"Failed to load my goals page", "Failed", "", true);
				Assert.fail("Failed to load my goals Page");				
				Thread.sleep(5000);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @Then("^Navigate To Manager Goals page$")
	public void navigate_To_Manager_Goals_page()  {
		try {
			
			rpt.enterStepHeader("Navigate to Team goal page");
			cmnLib.clickOnLinkText("Show More");
			TimeUnit.SECONDS.sleep(15);
			cmnLib.clickOnWebElement(homePage.QuickactionGoal);
			TimeUnit.SECONDS.sleep(15);
			if (getDriver().getTitle().contains("Goals")) {
				rpt.generateReport("", "Navigate to my goals Page", "", "", "My goals Page must must be open",
						"My goals page is open", "Passed", "", true);

			} else {

				rpt.generateReport("", "Navigate to my goals Page", "", "", "My goals Page must must be open",
						"Failed to load my goals page", "Failed", "", true);
				Assert.fail("Failed to load my goals Page");				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
}
}

