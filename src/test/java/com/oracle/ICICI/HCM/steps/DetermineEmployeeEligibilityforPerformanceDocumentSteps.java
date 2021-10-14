package com.oracle.ICICI.HCM.steps;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oracle.ICICI.HCM.pages.DetermineEmployeeEligibilityforPerformanceDocumentPage;
import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.ICICI.common.steps.DatabankInitialization;
import com.oracle.ICICI.common.steps.ReportingSteps;
import com.oracle.acs.util.BrowserDriverUtil;

import io.cucumber.java.en.Then;
import com.oracle.acs.util.report.ReportGeneration;

public class DetermineEmployeeEligibilityforPerformanceDocumentSteps extends BrowserDriverUtil{
	
	public static ReportGeneration rpt = ReportingSteps.getRpt();
	Common_Library cmnLib = ReportingSteps.cmnLib;

	
	DatabankInitialization data= new DatabankInitialization();
	static final Logger log = LoggerFactory.getLogger(DetermineEmployeeEligibilityforPerformanceDocumentSteps.class);

	DetermineEmployeeEligibilityforPerformanceDocumentPage perfDoc=new DetermineEmployeeEligibilityforPerformanceDocumentPage();

	@SuppressWarnings("static-access")
	@Then("^Search for the desired employee and open \"([^\"]*)\" \"([^\"]*)\"$")
	public void search_for_the_desired_employee_and_open(String EmployeeId, String EmployeeName) {

		try {

			Robot rob= new Robot();
			EmployeeId=data.exl.read(data.strDataSheetName, data.DataRow, EmployeeId);
			EmployeeName=data.exl.read(data.strDataSheetName,data. DataRow, EmployeeName);

			rpt.enterStepHeader("Enter detail to retrive the Performance document eligibility ");

			if(EmployeeId.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(perfDoc.EmployeeTxt))
				{
					cmnLib.clickOnWebElement(perfDoc.EmployeeTxt);
					cmnLib.enterDataInTextBox(perfDoc.EmployeeTxt, EmployeeId, false);
					TimeUnit.SECONDS.sleep(2);
					rob.keyPress(KeyEvent.VK_ENTER);
					rob.keyRelease(KeyEvent.VK_ENTER);


					log.info("Employee entered");
					rpt.generateReport("", "Enter Employee", "", "\nEmployee: " + EmployeeId,
							"Employee field should exist",
							"Employee value entered successfully", "Passed", "", true);			
				}
				else
				{
					rpt.generateReport("", "Employee entered", "", "",
							"Employee field should exist",
							"Employee field does not exist", "Failed", "", true);
					Assert.fail("Employee field does not exist");


				}
			}

			if(EmployeeName.length()>0)
			{
				cmnLib.clickOnLinkText(EmployeeName);

				if (getDriver().getTitle().contains("Performance Document")) {
					rpt.generateReport("", "Navigate to Performance Document Eligibility Page", "", "", "Performance Document Eligibility Page must must be open",
							"Performance Document Eligibility page is open", "Passed", "", true);

				} else {

					rpt.generateReport("", "Navigate to Performance Document Eligibility Page", "", "", "Performance Document Eligibility Page must must be open",
							"Failed to load Performance Document Eligibility page", "Failed", "", true);

					Assert.fail("Failed to load Performance Document Eligibility Page");

				}
			}
			else {

				rpt.generateReport("", "Add Employee name in data bank", "", "", "Add Employee name in data bank",
						"Employee name must be worng or empty", "Failed", "", true);

				Assert.fail("Failed to load Performance Document Eligibility Page");


			}

		} catch (Exception e) {

		}


	}

	@SuppressWarnings("static-access")
	@Then("^Add Eligibility and verify \"([^\"]*)\" \"([^\"]*)\"$")
	public void add_Eligibility_and_verify(String ReviewPeriod, String PerformanceDocument) throws Throwable {
		try {
			Robot rob= new Robot();
			ReviewPeriod=data.exl.read(data.strDataSheetName, data.DataRow, ReviewPeriod);
			PerformanceDocument=data.exl.read(data.strDataSheetName,data. DataRow, PerformanceDocument);

			if(ReviewPeriod.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(perfDoc.ReviewPeriodTxt))
				{
					cmnLib.clickOnWebElement(perfDoc.ReviewPeriodTxt);
					cmnLib.enterDataInTextBox(perfDoc.ReviewPeriodTxt, "", false);

					cmnLib.enterDataInTextBox(perfDoc.ReviewPeriodTxt, ReviewPeriod, false);

					rob.keyPress(KeyEvent.VK_ENTER);
					rob.keyRelease(KeyEvent.VK_ENTER);


					log.info("Review Period entered");
					rpt.generateReport("", "Enter Review Period", "", "\nReview Period: " + ReviewPeriod,
							"Review Period field should exist",
							"Review Period value entered successfully", "Passed", "", true);			
				}
				else
				{
					rpt.generateReport("", "Review Period entered", "", "",
							"Review Period field should exist",
							"Review Period field does not exist", "Failed", "", true);
					Assert.fail("Review Period field does not exist");


				}
			}


			cmnLib.clickOnWebElement(perfDoc.addEligibilityBtn);

			if(PerformanceDocument.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(perfDoc.performanceDocumentTxt))
				{
					cmnLib.clickOnWebElement(perfDoc.performanceDocumentTxt);
					cmnLib.enterDataInTextBox(perfDoc.performanceDocumentTxt, PerformanceDocument, false);
					TimeUnit.SECONDS.sleep(5);
					getDriver().findElement(By.xpath("//li[contains(.,'"+PerformanceDocument+"')]"));
					
					rob.keyPress(KeyEvent.VK_ENTER);
					rob.keyRelease(KeyEvent.VK_ENTER);


					log.info("Performance Document entered");
					rpt.generateReport("", "Enter Performance Document", "", "\nPerformance Document: " + PerformanceDocument,
							"Performance Document field should exist",
							"Performance Document value entered successfully", "Passed", "", true);			
				}
				else
				{
					rpt.generateReport("", "Performance Document entered", "", "",
							"Performance Document field should exist",
							"Performance Document field does not exist", "Failed", "", true);
					Assert.fail("Performance Document field does not exist");


				}
			}
			
			cmnLib.clickOnWebElement(perfDoc.saveEligiblityBtn);
			
			Thread.sleep(100000);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Then("^Edit Eligibility Profile \"([^\"]*)\"$")
	public void edit_Eligibility_Profile(String arg1) {
	}

}
