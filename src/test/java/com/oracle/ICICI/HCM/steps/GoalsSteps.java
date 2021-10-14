package com.oracle.ICICI.HCM.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import com.oracle.ICICI.HCM.pages.GoalsPage;
import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.ICICI.common.steps.ReportingSteps;
import com.oracle.acs.util.BrowserDriverUtil;


import io.cucumber.java.en.Then;
import com.oracle.acs.util.report.ReportGeneration;

public class GoalsSteps extends BrowserDriverUtil {
	public static ReportGeneration rpt = ReportingSteps.getRpt();
	Common_Library cmnLib = ReportingSteps.cmnLib;
	GoalsPage goal= new GoalsPage();
	
	@Then("^Click On Review Periods Menu$")
	public void ClickOnReviewPeriodsMenu() {
		
		
		try {
			rpt.enterStepHeader("Navigate to Review Period page");
			cmnLib.clickOnLinkText("Review Periods");
			
			TimeUnit.SECONDS.sleep(30);
			if (getDriver().getTitle().contains("Review Periods")) {
				rpt.generateReport("", "Navigate to Review Periods Page", "", "", "Review Periods Page must must be open",
						"Review Periods page is open", "Passed", "", true);

			} else {

				rpt.generateReport("", "Navigate to Review Periods Page", "", "", "Review Periods Page must must be open",
						"Failed to load Review Periods page", "Failed", "", true);

				Assert.fail("Failed to load Review Periods Page");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
