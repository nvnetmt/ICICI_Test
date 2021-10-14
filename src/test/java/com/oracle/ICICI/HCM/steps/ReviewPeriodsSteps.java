package com.oracle.ICICI.HCM.steps;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oracle.ICICI.HCM.pages.CreateReviewPeriodPage;
import com.oracle.ICICI.HCM.pages.ReviewPeriodsPage;
import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.ICICI.common.steps.CommonAppSteps;
import com.oracle.ICICI.common.steps.DatabankInitialization;
import com.oracle.ICICI.common.steps.ReportingSteps;
import com.oracle.acs.util.BrowserDriverUtil;

import io.cucumber.java.en.Then;
import com.oracle.acs.util.report.ReportGeneration;
import com.oracle.acs.util.ExcelOperations;

public class ReviewPeriodsSteps extends BrowserDriverUtil {

	public static ReportGeneration rpt = ReportingSteps.getRpt();
	Common_Library cmnLib = ReportingSteps.cmnLib;
	DatabankInitialization data = new DatabankInitialization();
	ExcelOperations exl = DatabankInitialization.exl;
	private String strDataSheetName = DatabankInitialization.strDataSheetName;
	private int DataRow = DatabankInitialization.DataRow;
	static final Logger log = LoggerFactory.getLogger(ReviewPeriodsSteps.class);
	CreateReviewPeriodPage createReviewPeriodsPage = new CreateReviewPeriodPage();
	ReviewPeriodsPage reviewPeriodsPage = new ReviewPeriodsPage();
	CommonAppSteps appSteps = new CommonAppSteps();
	public String reviewPeriodName;

	@Then("^Create Review Period \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\",  \"([^\"]*)\", \"([^\"]*)\"$")
	public void create_Review_Period(String name, String description, String status, String periodStartDate,
			String periodEndDate) throws Throwable {

		rpt.enterStepHeader("Create Review Period");
		if (cmnLib.clickOnWebElement(reviewPeriodsPage.lnkCreateReviewPeriod)
				&& cmnLib.waitForElementToBeVisible(createReviewPeriodsPage.hdrCreateReviewPeriod)) {
			rpt.generateReport("", "Click Create Review Period icon", "", "",
					"Create Review Period page must be displayed", "Create Review Period page displayed", "Passed", "",
					true);
		} else {
			rpt.generateReport("", "Click Create Review Period icon", "", "",
					"Create Review Period page must be displayed", "Create Review Period page not displayed", "Failed",
					"", true);
			Assert.fail("Create Review Period page not displayed");
		}

		// Enter Review Period details
		name = cmnLib.randomNumber(exl.read(strDataSheetName, DataRow, "ReviewPeriodName"));
		reviewPeriodName = name;
		if (!cmnLib.enterDataInTextBox(createReviewPeriodsPage.txtReviewPeriodName, name, true)) {
			rpt.generateReport("", "Enter Review Period Name", "", name, "Review Period Name must be entered",
					"Review Period Name not entered", "Failed", "", true);
			Assert.fail("Review Period Name not entered");
		}

		description = exl.read(strDataSheetName, DataRow, "Description");
		if (!cmnLib.enterDataInTextBox(createReviewPeriodsPage.txtDescription, description, true)) {
			rpt.generateReport("", "Enter Description", "", description, "Description must be entered",
					"Description not entered", "Failed", "", true);
			Assert.fail("Description not entered");
		}

		status = exl.read(strDataSheetName, DataRow, "Status");
		if (!appSteps.selectOptionFromComboBox("Status", status)) {
			rpt.generateReport("", "Select Status", "", status, "Status must be selected", "Status not selected",
					"Failed", "", true);
			Assert.fail("Status not selected");
		}

		periodStartDate = exl.read(strDataSheetName, DataRow, "PeriodStartDate");
		if (!cmnLib.enterDataInTextBox(createReviewPeriodsPage.txtPeriodStartDate, periodStartDate, true)) {
			rpt.generateReport("", "Enter Period Start Date", "", periodStartDate, "Period Start Date must be entered",
					"Period Start Date not entered", "Failed", "", true);
			Assert.fail("Period Start Date not entered");
		}

		periodEndDate = exl.read(strDataSheetName, DataRow, "PeriodEndDate");
		if (!cmnLib.enterDataInTextBox(createReviewPeriodsPage.txtPeriodEndDate, periodEndDate, true)) {
			rpt.generateReport("", "Enter Period End Date", "", periodEndDate, "Period End Date must be entered",
					"Period End Date not entered", "Failed", "", true);
			Assert.fail("Period End Date not entered");
		}

		rpt.generateReport("", "Enter Review Period details", "",
				"Review Period Name: " + reviewPeriodName + "\nDescription: " + description + "\nStatus: " + status
						+ "\nPeriod Start Date: " + periodStartDate + "\nPeriod End Date: " + periodEndDate,
				"Required details must be entered", "Entered Required details", "Passed", "", true);

		// Save
		if (cmnLib.clickOnWebElement(createReviewPeriodsPage.btnSaveAndClose)
				&& cmnLib.waitForElementToBeVisible(createReviewPeriodsPage.msgConfirmation)) {
			rpt.generateReport("", "Click Save and Close button", "", "", "Confirmation message must be displayed",
					"Confirmation message displayed", "Passed", "", true);
		} else {
			rpt.generateReport("", "Click Save and Close button", "", "", "Confirmation message must be displayed",
					"Either not clicked on Save and Close button or Confirmation message not displayed", "Failed", "",
					true);
			Assert.fail("Either not clicked on Save and Close button or Confirmation message not displayed");
		}

		if (cmnLib.clickOnWebElement(createReviewPeriodsPage.btnOK)
				&& cmnLib.waitForElementToBeVisible(reviewPeriodsPage.hdrReviewPeriods)) {
			rpt.generateReport("", "Click OK button", "", "", "Confirmation message must be closed",
					"Confirmation message closed", "Passed", "", true);
		} else {
			rpt.generateReport("", "Click OK button", "", "", "Confirmation message must be closed",
					"Confirmation message not closed", "Failed", "", true);
			Assert.fail("Confirmation message not closed");
		}

	}

	@Then("^Verifiy Review Period$")
	public void verifiy_Review_Period() throws Throwable {

		rpt.enterStepHeader("Verify Review Period");

		if (!cmnLib.enterDataInTextBox(reviewPeriodsPage.txtReviewPeriodName, reviewPeriodName, true)) {
			rpt.generateReport("", "Enter Review Period Name", "", reviewPeriodName,
					"Review Period Name must be entered", "Review Period Name not entered", "Failed", "", true);
			Assert.fail("Review Period Name not entered");
		} else {
			rpt.generateReport("", "Enter Review Period Name", "", reviewPeriodName,
					"Review Period Name must be entered", "Entered Review Period Name", "Passed", "", true);
		}

		if (!(cmnLib.clickOnWebElement(reviewPeriodsPage.btnSearch)
				&& cmnLib.waitForElementToBeVisible(reviewPeriodsPage.tblBdySearchResults))) {
			rpt.generateReport("", "Click Search button", "", "", "Review Period Name must appear in results",
					"Review Period name did not appear in results", "Failed", "", true);
			Assert.fail("Review Period name did not appear in results");
		} else {
			rpt.generateReport("", "Click Search button", "", "", "Review Period Name must appear in results",
					"Review Period name appears in results", "Passed", "", true);
		}

	}

}
