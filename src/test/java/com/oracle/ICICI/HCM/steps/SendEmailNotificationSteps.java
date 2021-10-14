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
import com.oracle.acs.util.BrowserDriverUtil;

import io.cucumber.java.en.Then;
import com.oracle.acs.util.report.ReportGeneration;

public class SendEmailNotificationSteps extends BrowserDriverUtil{
	
	public static ReportGeneration rpt = ReportingSteps.getRpt();
	Common_Library cmnLib = ReportingSteps.cmnLib;
	DatabankInitialization data= new DatabankInitialization();
	static final Logger log = LoggerFactory.getLogger(SendEmailNotificationSteps.class);

	PerformanceDocumentPage perfDoc=new PerformanceDocumentPage();


	@Then("^Navigate the Send Email Notification$")
	public void navigate_the_Send_Email_Notification() {
		try {
			cmnLib.waitForPageLoaded();
			cmnLib.clickOnWebElement(perfDoc.sendEmailNotificationBtn);
			cmnLib.waitForPageLoaded();
			System.out.println("Page Name :" +getDriver().getTitle());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	@Then("^Enter Required field and send email \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void enter_Required_field_and_send_email(String ReviewPeriod, String PerformanceDocument, String Department, String Subject, String Emailbody) {
	
		try {
			
			Robot rob= new Robot();
			ReviewPeriod=data.exl.read(data.strDataSheetName, data.DataRow, ReviewPeriod);
			Department=data.exl.read(data.strDataSheetName,data. DataRow, Department);
			PerformanceDocument=data.exl.read(data.strDataSheetName,data. DataRow, PerformanceDocument);
			Subject=data.exl.read(data.strDataSheetName,data. DataRow, Subject);
			Emailbody=data.exl.read(data.strDataSheetName,data. DataRow, Emailbody);

			rpt.enterStepHeader("Enter detail to retrive the Goals ");


			if(ReviewPeriod.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(perfDoc.ReviewPeriodText))
				{
					cmnLib.clickOnWebElement(perfDoc.ReviewPeriodText);
					cmnLib.enterDataInTextBox(perfDoc.ReviewPeriodText, "", false);

					cmnLib.enterDataInTextBox(perfDoc.ReviewPeriodText, ReviewPeriod, false);

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

			if(Department.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(perfDoc.departmentTxt))
				{
					cmnLib.clickOnWebElement(perfDoc.departmentTxt);
					cmnLib.enterDataInTextBox(perfDoc.departmentTxt, Department, false);
					TimeUnit.SECONDS.sleep(2);
					rob.keyPress(KeyEvent.VK_ENTER);
					rob.keyRelease(KeyEvent.VK_ENTER);


					log.info("Department entered");
					rpt.generateReport("", "Enter Department", "", "\nDepartment: " + Department,
							"Department field should exist",
							"Department value entered successfully", "Passed", "", true);			
				}
				else
				{
					rpt.generateReport("", "Department entered", "", "",
							"Department field should exist",
							"Department field does not exist", "Failed", "", true);
					Assert.fail("Department field does not exist");


				}
			}

			if(PerformanceDocument.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(perfDoc.performanceDocumentText))
				{
					cmnLib.clickOnWebElement(perfDoc.performanceDocumentText);
					cmnLib.enterDataInTextBox(perfDoc.performanceDocumentText, PerformanceDocument, false);
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
			
			//////
			
			if(Subject.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(perfDoc.emailSubjectTxt))
				{
					cmnLib.clickOnWebElement(perfDoc.emailSubjectTxt);
					cmnLib.enterDataInTextBox(perfDoc.emailSubjectTxt, Subject, false);
					TimeUnit.SECONDS.sleep(2);
				
					log.info("Email Subject entered");
					rpt.generateReport("", "Enter Email Subject", "", "\nEmail Subject: " + Subject,
							"Email Subject field should exist",
							"Email Subject value entered successfully", "Passed", "", true);			
				}
				else
				{
					rpt.generateReport("", "Email Subject entered", "", "",
							"Email Subject field should exist",
							"Email Subject field does not exist", "Failed", "", true);
					Assert.fail("Email Subject field does not exist");


				}
			}
			
			cmnLib.clickOnWebElement(perfDoc.submitEmailBtn);
			

			TimeUnit.SECONDS.sleep(10);
			
			String status=perfDoc.EmailConfirmationMsg.getText();
			
			System.out.println("Status :: " + status);
			
			if(status.contains("A process to send emails was submitted"))
			{
				log.info("Status Set as In progress");
				rpt.generateReport("", "Confirmation message should be display", "", "",
						"Confirmation message should be display",
						"Confirmation message display successfully", "Passed", "", true);	
				
				cmnLib.clickOnWebElement(perfDoc.EmailConfirmationOkBtn);
				rpt.generateReport("", "Email Sent", "", "",
						"Email should should be sent",
						"Email sent successfully", "Passed", "", true);	
				
			}
			else
			{
				rpt.generateReport("", "Confirmation message should be display", "", "",
						"Confirmation message should be display",
						"Confirmation message does not display", "Failed", "", true);
				Assert.fail("Confirmation message does not display");


			}
			TimeUnit.SECONDS.sleep(10);
			cmnLib.clickOnWebElement(perfDoc.backButton);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}


	
}
