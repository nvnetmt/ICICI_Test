package com.oracle.ICICI.HCM.steps;

import org.junit.Assert;

import com.oracle.ICICI.HCM.pages.GoalsAndPerformanceOverviewPage;
import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.ICICI.common.steps.CommonAppSteps;
import com.oracle.ICICI.common.steps.DatabankInitialization;
import com.oracle.ICICI.common.steps.ReportingSteps;

import io.cucumber.java.en.Then;
import com.oracle.acs.util.report.ReportGeneration;
import com.oracle.acs.util.ExcelOperations;

public class ReviewTeamGoalsSteps {

	public static ReportGeneration rpt = ReportingSteps.getRpt();
	Common_Library cmnLib = ReportingSteps.cmnLib;
	DatabankInitialization data = new DatabankInitialization();
	ExcelOperations exl = DatabankInitialization.exl;
	private String strDataSheetName = DatabankInitialization.strDataSheetName;
	private int DataRow = DatabankInitialization.DataRow;
	GoalsAndPerformanceOverviewPage goalsAndPerformancePage = new GoalsAndPerformanceOverviewPage();
	CommonAppSteps appSteps = new CommonAppSteps();

	@Then("^Select First Direct Reportee$")
	public void select_First_Direct_Reportee() throws Throwable {
		cmnLib.waitForElementToBeVisible(goalsAndPerformancePage.lnkDirectReport1);
		if (cmnLib.clickByJSE(goalsAndPerformancePage.lnkDirectReport1)
				&& cmnLib.waitForElementToBeVisible(goalsAndPerformancePage.hdrPerformance)) {
			rpt.generateReport("", "Click Direct Report", "", "", "Performace page must be displayed",
					"Performance page displayed", "Passed", "", true);
		} else {
			rpt.generateReport("", "Click Direct Report", "", "", "Performace page must be displayed",
					"Either not clicked on Direct Reportee or Performance page not displayed", "Failed", "", true);
			Assert.fail("Either not clicked on Direct Reportee or Performance page not displayed");
		}
	}

	@Then("^Go to Goals section$")
	public void go_to_Goals_section() throws Throwable {
		if (!cmnLib.clickOnWebElement(goalsAndPerformancePage.lnkShowMore)
				&& cmnLib.waitForElementToBeVisible(goalsAndPerformancePage.lnkGoals)) {
			rpt.generateReport("", "Click Show More link", "", "", "Goals link must be displayed",
					"Either not clicked on Show More or Goals link not displayed", "Failed", "", true);
			Assert.fail("Either not clicked on Show More or Goals link not displayed");
		}

		if (cmnLib.clickOnWebElement(goalsAndPerformancePage.lnkGoals)
				&& cmnLib.waitForElementToBeVisible(goalsAndPerformancePage.hdrGoals)) {
			rpt.generateReport("", "Click Goals link", "", "", "Goals page must be displayed", "Goals page displayed",
					"Passed", "", true);
		} else {
			rpt.generateReport("", "Click Goals link", "", "", "Goals page must be displayed",
					"Either not clicked on Goals link or Goals page not displayed", "Failed", "", true);
			Assert.fail("Either not clicked on Goals link or Goals page not displayed");
		}
	}

	@Then("^Select Review Period and Goal Sheet \"([^\"]*)\", \"([^\"]*)\"$")
	public void select_Review_Period_and_Goal_Sheet(String reviewPeriod, String goalSheet) throws Throwable {
		reviewPeriod = exl.read(strDataSheetName, DataRow, "ReviewPeriod");
		if (appSteps.selectOptionFromComboBox("Review Period", reviewPeriod)) {
			rpt.generateReport("", "Select Review Period", "", reviewPeriod, "Review Period must be selected",
					"Review Period selected", "Passed", "", true);
		} else {
			rpt.generateReport("", "Select Review Period", "", reviewPeriod, "Review Period must be selected",
					"Review Period not selected", "Failed", "", true);
			Assert.fail("Review Period not selected");
		}

		goalSheet = exl.read(strDataSheetName, DataRow, "GoalSheet");
		if (appSteps.selectOptionFromComboBox("Goal Sheet", goalSheet)) {
			rpt.generateReport("", "Select Goal Sheet", "", goalSheet, "Goal Sheet must be selected",
					"Goal Sheet selected", "Passed", "", true);
		} else {
			rpt.generateReport("", "Select Goal Sheet", "", goalSheet, "Goal Sheet must be selected",
					"Goal Sheet not selected", "Failed", "", true);
			Assert.fail("Goal Sheet not selected");
		}
		
		goalsAndPerformancePage.verifyGoalSheetHeader(goalSheet);
	}

	@Then("^Verify Goal List displayed$")
	public void verify_Goal_List_displayed() throws Throwable {
		if (cmnLib.waitForElementToBeVisible(goalsAndPerformancePage.tblGoalList)) {
			rpt.generateReport("", "Verify Goal List displayed", "", "", "Goal List must be displayed",
					"Goal List displayed", "Passed", "", true);
		} else {
			rpt.generateReport("", "Verify Goal List displayed", "", "", "Goal List must be displayed",
					"Goal List not displayed", "Failed", "", true);
			Assert.fail("Goal List not displayed");
		}
	}

}
