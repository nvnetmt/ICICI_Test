package com.oracle.ICICI.HCM.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oracle.ICICI.HCM.pages.AddGoalPage;
import com.oracle.ICICI.HCM.pages.AddPerformanceGoalsByEmpAndMgrPage;
import com.oracle.ICICI.HCM.pages.GoalsPage;
import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.ICICI.common.steps.CommonAppSteps;
import com.oracle.ICICI.common.steps.DatabankInitialization;
import com.oracle.ICICI.common.steps.ReportingSteps;
import com.oracle.acs.util.BrowserDriverUtil;

import io.cucumber.java.en.Then;
import com.oracle.acs.util.report.ReportGeneration;
import com.oracle.acs.util.ExcelOperations;

public class AddPerformanceGoalsByEmpAndMgrSteps extends BrowserDriverUtil {

	public static ReportGeneration rpt = ReportingSteps.getRpt();
	Common_Library cmnLib = ReportingSteps.cmnLib;
	DatabankInitialization data = new DatabankInitialization();
	static final Logger log = LoggerFactory.getLogger(CreateGoalPlansOtherPlansNonPrimarySteps.class);
	ExcelOperations exl = DatabankInitialization.exl;
	private String strDataSheetName = DatabankInitialization.strDataSheetName;
	private int DataRow = DatabankInitialization.DataRow;
	AddPerformanceGoalsByEmpAndMgrPage addPerfGoal = new AddPerformanceGoalsByEmpAndMgrPage();
	GoalsPage goalsPage = new GoalsPage();
	AddGoalPage addGoalPage = new AddGoalPage();
	CommonAppSteps appSteps = new CommonAppSteps();
	public String strGoalName;
	public static String GoalPlanNames;

	@SuppressWarnings("static-access")
	@Then("^Enter Goal Plan Details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void enter_Goal_Plan_Details(String ReviewPeriod, String GoalPlanName, String GoalSheet, String Measurements,
			String Perspective) {

		try {
			ReviewPeriod = data.exl.read(data.strDataSheetName, data.DataRow, ReviewPeriod);
			GoalSheet = data.exl.read(data.strDataSheetName, data.DataRow, GoalSheet);
			Measurements = data.exl.read(data.strDataSheetName, data.DataRow, Measurements);
			Perspective = data.exl.read(data.strDataSheetName, data.DataRow, Perspective);

			String random = cmnLib.randomNumber(GoalPlanName);
			GoalPlanNames = random;

			if (ReviewPeriod.length() > 0) {
				if (cmnLib.waitForElementToBeVisible(addPerfGoal.ReviewPeriodText)) {
					cmnLib.clickOnWebElement(addPerfGoal.ReviewPeriodText);

					getDriver().findElement(By.xpath("//li[contains(.,'" + ReviewPeriod + "')]")).click();
					log.info("Review Period entered");
					rpt.generateReport("", "Enter Review Period", "", "\nReview Period : " + ReviewPeriod,
							"Review Period field should exist", "Review Period entered successfully", "Passed", "",
							true);
				} else {
					rpt.generateReport("", "Review Period entered", "", "", "Review Period field should exist",
							"Review Period field does not exist", "Failed", "", true);
					Assert.fail("Review Period field does not exist");

				}
			}

			if (GoalSheet.length() > 0) {
				if (cmnLib.waitForElementToBeVisible(addPerfGoal.GoalSheetText)) {
					cmnLib.clickOnWebElement(addPerfGoal.GoalSheetText);

					getDriver().findElement(By.xpath("//li[contains(.,'FY21 Standard Template')]")).click();
					log.info("Goal Sheet entered");
					rpt.generateReport("", "Enter Goal Sheet ", "", "\nGoal Sheet : " + GoalSheet,
							"Goal Sheet field should exist", "Goal Sheet entered successfully", "Passed", "", true);
				} else {
					rpt.generateReport("", "Goal Sheet entered", "", "", "Goal Sheet field should exist",
							"Goal Sheet field does not exist", "Failed", "", true);
					Assert.fail("Goal Sheet field does not exist");

				}
			}

			// cmnLib.clickOnWebElement(addPerfGoal.ReviewPeriodText);
			// cmnLib.clickOnWebElement(addPerfGoal.ReviewPeriodValue);

			/// cmnLib.clickOnWebElement(addPerfGoal.GoalSheetText);
			// cmnLib.clickOnWebElement(addPerfGoal.GoalSheetValue);

			cmnLib.clickOnWebElement(addPerfGoal.AddButton);

			rpt.enterStepHeader("Enter Goal Plan Detial");
			if (GoalPlanNames.length() > 0) {
				if (cmnLib.waitForElementToBeVisible(addPerfGoal.enterGoalName)
						&& cmnLib.enterDataInTextBox(addPerfGoal.enterGoalName, GoalPlanNames, true)) {

					log.info("Goal Plan entered");
					rpt.generateReport("", "Enter Goal Plan", "", "\nGoal Plan : " + GoalPlanNames,
							"Goal Plan field should exist", "Goal Plan entered successfully", "Passed", "", true);
				} else {
					rpt.generateReport("", "Goal Plan entered", "", "", "Goal Plan field should exist",
							"Goal Plan field does not exist", "Failed", "", true);
					Assert.fail("Goal Plan field does not exist");

				}
			}

			if (Measurements.length() > 0) {
				if (cmnLib.waitForElementToBeVisible(addPerfGoal.EnterMeasurement)
						&& cmnLib.enterDataInTextBox(addPerfGoal.EnterMeasurement, Measurements, true)) {

					log.info("Measurement entered");
					rpt.generateReport("", "Enter Measurement", "", "\nMeasurement : " + Measurements,
							"Measurement field should exist", "Measurement entered successfully", "Passed", "", true);
				} else {
					rpt.generateReport("", "Measurement entered", "", "", "Measurement field should exist",
							"Measurement field does not exist", "Failed", "", true);
					Assert.fail("Measurement field does not exist");

				}
			}

			if (Perspective.length() > 0) {
				if (cmnLib.waitForElementToBeVisible(addPerfGoal.EnterPerspective)) {
					cmnLib.clickOnWebElement(addPerfGoal.EnterPerspective);

					// cmnLib.clickOnWebElement(createGP.perspectiveValue);

					getDriver().findElement(By.xpath("//li[contains(.,'" + Perspective + "')]")).click();
					log.info("Perspective entered");
					rpt.generateReport("", "Enter Perspective", "", "\nPerspective : " + Perspective,
							"Perspective field should exist", "Perspective entered successfully", "Passed", "", true);
				} else {
					rpt.generateReport("", "Perspective entered", "", "", "Perspective field should exist",
							"Perspective field does not exist", "Failed", "", true);
					Assert.fail("Perspective field does not exist");

				}
			}

			cmnLib.enterDataInTextBox(addPerfGoal.enterWeight, "10", false);

			cmnLib.clickOnWebElement(addPerfGoal.Save);

			Thread.sleep(100000);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Then("^Validate the created goal plan$")
	public void validate_the_created_goal_plan() {

	}

	@Then("^Click Add button to Add Goal$")
	public void click_Add_button_to_Add_Goal() throws Throwable {
		//Click Add
		if (cmnLib.clickOnWebElement(goalsPage.btnAdd) && cmnLib.waitForElementToBeVisible(addGoalPage.hdrAddGoal)) {
			rpt.generateReport("", "Click Add button", "", "", "Add Goal page must be displayed",
					"Add Goal page displayed", "Passed", "", true);
		} else {
			rpt.generateReport("", "Click Add button", "", "", "Add Goal page must be displayed",
					"Either not clicked Add button or Add Goal page not displayed", "Failed", "", true);
			Assert.fail("Either not clicked Add button or Add Goal page not displayed");
		}
	}

	@Then("^Ener Basic Info \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void ener_Basic_Info(String goalName, String measurement, String startDate, String targetCompletionDate,
			String perspective, String weight) throws Throwable {

		// Goal Name
		goalName = cmnLib.randomNumber(exl.read(strDataSheetName, DataRow, "GoalName"));
		strGoalName = goalName;
		if (!cmnLib.enterDataInTextBox(addGoalPage.txtGoalName, goalName, false)) {
			rpt.generateReport("", "Enter Goal Name", "", goalName, "Goal Name must be entered",
					"Goal Name not entered", "Failed", "", true);
			Assert.fail("Goal Name not entered");
		}

		// Measurement
		measurement = exl.read(strDataSheetName, DataRow, "Measurement");
		if (!cmnLib.enterDataInTextBox(addGoalPage.txtMeasurement, measurement, false)) {
			rpt.generateReport("", "Enter Measurement", "", measurement, "Measurement must be entered",
					"Measurement not entered", "Failed", "", true);
			Assert.fail("Measurement not entered");
		}

		// Start Date
		startDate = exl.read(strDataSheetName, DataRow, "StartDate");
		if (!cmnLib.enterDataInTextBox(addGoalPage.txtStartDate, startDate, false)) {
			rpt.generateReport("", "Enter Start Date", "", startDate, "Start Date must be entered",
					"Start Date not entered", "Failed", "", true);
			Assert.fail("Start Date not entered");
		}

		// Target Completion Date
		targetCompletionDate = exl.read(strDataSheetName, DataRow, "TargetCompletionDate");
		if (!cmnLib.enterDataInTextBox(addGoalPage.txtTargetCompletionDate, targetCompletionDate, false)) {
			rpt.generateReport("", "Enter Target Completion Date", "", targetCompletionDate,
					"Target Completion Date must be entered", "Target Completion Date not entered", "Failed", "", true);
			Assert.fail("Target Completion Date not entered");
		}

		// Perspective
		perspective = exl.read(strDataSheetName, DataRow, "Perspective");
		if (!appSteps.selectOptionFromComboBox(addGoalPage.lnkArrowPerspective, perspective)) {
			rpt.generateReport("", "Enter Perspective", "", perspective, "Perspective must be entered",
					"Perspective not entered", "Failed", "", true);
			Assert.fail("Perspective not entered");
		}

		// Weight
		weight = exl.read(strDataSheetName, DataRow, "Weight");
		if (!cmnLib.enterDataInTextBox(addGoalPage.txtWeight, weight, false)) {
			rpt.generateReport("", "Enter Weight", "", weight, "Weight must be entered", "Weight not entered", "Failed",
					"", true);
			Assert.fail("Weight not entered");
		}

		rpt.generateReport("", "Enter Goal Details", "",
				"Goal Name: " + goalName + "\nMeasurement: " + measurement + "\nStart Date: " + startDate
						+ "\nTarget Completion Date: " + targetCompletionDate + "\nPerspective: " + perspective
						+ "\nWeight: " + weight,
				"Required details must be entered", "Required details entered", "Failed", "", true);
	}

	@Then("^Save Goal$")
	public void save_Goal() throws Throwable {
		// Click Save and Close
		if (cmnLib.clickOnWebElement(addGoalPage.btnSaveAndClose)
				&& cmnLib.waitForElementToBeVisible(goalsPage.hdrGoals)) {
			rpt.generateReport("", "Click Save and Close button", "", "", "Goals page must be displayed",
					"Goals page displayed", "Passed", "", true);
		} else {
			rpt.generateReport("", "Click Save and Close button", "", "", "Goals page must be displayed",
					"Either not clicked on Save and Close or Goals page not displayed", "Failed", "", true);
			Assert.fail("Either not clicked on Save and Close or Goals page not displayed");
		}
	}

	@Then("^Submit Goal$")
	public void submit_Goal() throws Throwable {
		// Click Submit
		if (cmnLib.clickOnWebElement(goalsPage.btnSubmit1) && cmnLib.waitForElementToBeVisible(goalsPage.btnSubmit2)) {
			rpt.generateReport("", "Click Submit button", "", "", "Add Additional Info page must be displayed",
					"Add Additional Info page displayed", "Passed", "", true);
		} else {
			rpt.generateReport("", "Click Submit button", "", "", "Add Additional Info page must be displayed",
					"Either not clicked on Submit button or Add Additional Info page not displayed", "Failed", "",
					true);
			Assert.fail("Either not clicked on Submit button or Add Additional Info page not displayed");
		}

		// Click Submit
		if (cmnLib.clickOnWebElement(goalsPage.btnSubmit2) && cmnLib.waitForElementToBeVisible(goalsPage.hdrGoals)) {
			rpt.generateReport("", "Click Submit button", "", "", "Goals page must be displayed",
					"Goals page displayed", "Passed", "", true);
		} else {
			rpt.generateReport("", "Click Submit button", "", "", "Goals page must be displayed",
					"Either not clicked on Submit button or Goals page not displayed", "Failed", "", true);
			Assert.fail("Either not clicked on Submit button or Goals page not displayed");
		}
	}

}
