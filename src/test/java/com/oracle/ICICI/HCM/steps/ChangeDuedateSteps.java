package com.oracle.ICICI.HCM.steps;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oracle.ICICI.HCM.pages.PerformanceDocumentPage;
import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.ICICI.common.steps.DatabankInitialization;
import com.oracle.ICICI.common.steps.ReportingSteps;

import io.cucumber.java.en.Then;
import com.oracle.acs.util.report.ReportGeneration;

public class ChangeDuedateSteps {

	public static ReportGeneration rpt = ReportingSteps.getRpt();
	Common_Library cmnLib = ReportingSteps.cmnLib;
	
	DatabankInitialization data= new DatabankInitialization();
	static final Logger log = LoggerFactory.getLogger(ChangeDuedateSteps.class);

	PerformanceDocumentPage perfDoc=new PerformanceDocumentPage();



	@SuppressWarnings("static-access")
	@Then("^Enter Required field and search the Performance Document \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void enter_Required_field_and_search_the_Performance_Document(String ReviewPeriod, String PerformanceDocument, String EmployeeNumber) {


		try {

			Robot rob= new Robot();
			ReviewPeriod=data.exl.read(data.strDataSheetName, data.DataRow, ReviewPeriod);
			EmployeeNumber=data.exl.read(data.strDataSheetName,data. DataRow, EmployeeNumber);
			PerformanceDocument=data.exl.read(data.strDataSheetName,data. DataRow, PerformanceDocument);

			rpt.enterStepHeader("Enter detail to retrive the Performance document ");


			if(ReviewPeriod.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(perfDoc.reviewPeriodTxt))
				{
					cmnLib.clickOnWebElement(perfDoc.reviewPeriodTxt);
					cmnLib.enterDataInTextBox(perfDoc.reviewPeriodTxt, "", false);

					cmnLib.enterDataInTextBox(perfDoc.reviewPeriodTxt, ReviewPeriod, false);

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

			if(EmployeeNumber.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(perfDoc.employeeTxt))
				{
					cmnLib.clickOnWebElement(perfDoc.employeeTxt);
					cmnLib.enterDataInTextBox(perfDoc.employeeTxt, EmployeeNumber, false);
					TimeUnit.SECONDS.sleep(2);
					rob.keyPress(KeyEvent.VK_ENTER);
					rob.keyRelease(KeyEvent.VK_ENTER);


					log.info("Employee entered");
					rpt.generateReport("", "Enter Employee", "", "\nEmployee: " + EmployeeNumber,
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

			if(PerformanceDocument.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(perfDoc.performanceDocumnetTxt))
				{
					cmnLib.clickOnWebElement(perfDoc.performanceDocumnetTxt);
					cmnLib.enterDataInTextBox(perfDoc.performanceDocumnetTxt, PerformanceDocument, false);
					TimeUnit.SECONDS.sleep(2);
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



		}
		catch (Exception e) {
			// TODO: handle exception
		}


	}

	@SuppressWarnings("static-access")
	@Then("^Change Due date and verify \"([^\"]*)\"$")
	public void change_Due_date_and_verify(String DueDate)  {

		try {

			DueDate=data.exl.read(data.strDataSheetName, data.DataRow, DueDate);

			cmnLib.clickOnWebElement(perfDoc.performanceDocCheckBox);

			cmnLib.clickOnWebElement(perfDoc.ActionBtn);

			cmnLib.clickOnWebElement(perfDoc.changeDueDateMenu);


			if(DueDate.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(perfDoc.changeDueDateTxt))
				{
					cmnLib.clickOnWebElement(perfDoc.changeDueDateTxt);
					cmnLib.enterDataInTextBox(perfDoc.changeDueDateTxt, DueDate, false);

					log.info("DueDate entered");
					rpt.generateReport("", "Enter Due Date", "", "\nDueDate: " + DueDate,
							"Due Date field should exist",
							"Due Date value entered successfully", "Passed", "", true);			
				}
				else
				{
					rpt.generateReport("", "Due Date entered", "", "",
							"Due Date field should exist",
							"Due Date field does not exist", "Failed", "", true);
					Assert.fail("Due Date field does not exist");


				}
			}

			cmnLib.clickOnWebElement(perfDoc.submitChangeDueDateBtn);

			cmnLib.clickOnWebElement(perfDoc.backButton);

		}
		catch (Exception e) {
			// TODO: handle exception
		}

	}
}
