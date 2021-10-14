package com.oracle.ICICI.HCM.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oracle.ICICI.HCM.pages.MassAssignGoalsPage;
import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.ICICI.common.steps.DatabankInitialization;
import com.oracle.ICICI.common.steps.ReportingSteps;
import com.oracle.acs.util.BrowserDriverUtil;

import io.cucumber.java.en.Then;
import com.oracle.acs.util.report.ReportGeneration;

public class MassAssignGoalsSteps extends BrowserDriverUtil {


	public static ReportGeneration rpt = ReportingSteps.getRpt();
	Common_Library cmnLib = ReportingSteps.cmnLib;
	DatabankInitialization data= new DatabankInitialization();
	static final Logger log = LoggerFactory.getLogger(CreateGoalPlansOtherPlansNonPrimarySteps.class);

	MassAssignGoalsPage massAsignGoal= new MassAssignGoalsPage();



	public static String ProcessNames;
	@SuppressWarnings("static-access")
	@Then("^Enter Process Details and validate\"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void enter_Process_Details_and_validate(String ProcessName, String ReviewProcess,String Worker, String GoalSheet, String CategoryGoalPlanName, String categoryMeasurements, String Perspective) {
		try {
			
			ProcessName=data.exl.read(data.strDataSheetName,data. DataRow, ProcessName);
			ReviewProcess=data.exl.read(data.strDataSheetName,data. DataRow, ReviewProcess);
			Worker=data.exl.read(data.strDataSheetName, data.DataRow, Worker);
			GoalSheet=data.exl.read(data.strDataSheetName, data.DataRow, GoalSheet);

			String random=cmnLib.randomNumber(ProcessName);
			ProcessNames=random;
			
			rpt.enterStepHeader("Enter Goal Plan Detial");

			cmnLib.waitForPageLoaded();

			cmnLib.clickOnWebElement(massAsignGoal.addGoalProcess);
			cmnLib.waitForPageLoaded();
			
			
			if(ProcessNames.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(massAsignGoal.enterProcessName)&&
						cmnLib.enterDataInTextBox(massAsignGoal.enterProcessName,ProcessNames,true))
				{

					log.info("Goal Plan entered");
					rpt.generateReport("", "Enter Process Name", "", "\nGoal Plan Name : " + ProcessNames,
							"Process Name field should exist",
							"Process Name entered successfully", "Passed", "", true);			
				}
				else
				{
					rpt.generateReport("", "Process name entered", "", "",
							"Process name field should exist",
							"Process name field does not exist", "Failed", "", true);
					Assert.fail("Process name field does not exist");

				}
			}
			
			if(ReviewProcess.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(massAsignGoal.reviewProcess))
				{
					cmnLib.clickOnWebElement(massAsignGoal.reviewProcess);

					getDriver().findElement(By.xpath("//li[contains(.,'"+ReviewProcess+"')]")).click();
					log.info("Review process entered");
					rpt.generateReport("", "Enter Review process", "", "\nReview process : " + ReviewProcess,
							"Review process field should exist",
							"Review process entered successfully", "Passed", "", true);			
				}
				else
				{
					rpt.generateReport("", "Review process entered", "", "",
							"Review process field should exist",
							"Review process field does not exist", "Failed", "", true);
					Assert.fail("Review process field does not exist");

				}
			}

			
			if(GoalSheet.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(massAsignGoal.enterGoalSheet))
				{
					cmnLib.clickOnWebElement(massAsignGoal.enterGoalSheet);

					getDriver().findElement(By.xpath("//li[contains(.,'"+GoalSheet+"')]")).click();
					log.info("Goal Sheet entered");
					rpt.generateReport("", "Enter Goal Sheet", "", "\nGoal Sheet : " + GoalSheet,
							"Goal Sheet field should exist",
							"Goal Sheet entered successfully", "Passed", "", true);			
				}
				else
				{
					rpt.generateReport("", "Goal Sheet entered", "", "",
							"Goal Sheet field should exist",
							"Goal Sheet field does not exist", "Failed", "", true);
					Assert.fail("Goal Sheet field does not exist");

				}
			}
			

			cmnLib.clickOnWebElement(massAsignGoal.expandIncludeWorker);

			cmnLib.clickOnWebElement(massAsignGoal.clickAddworker);
			
			
			if(Worker.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(massAsignGoal.enterWorker)&&
						cmnLib.enterDataInTextBox(massAsignGoal.enterWorker,Worker,true))
				{

					log.info("Worker entered");
					
					getDriver().findElement(By.xpath("(//div[contains(.,'"+Worker+"')])[10]")).click();
					rpt.generateReport("", "Worker entered", "", "\nWorker : " + Worker,
							"Worker field should exist",
							"Worker entered successfully", "Passed", "", true);			
				}
				else
				{
					rpt.generateReport("", "Worker entered", "", "",
							"Worker field should exist",
							"Worker field does not exist", "Failed", "", true);
					Assert.fail("Worker field does not exist");

				}
			}

			cmnLib.clickOnWebElement(massAsignGoal.saveWorker);

			CategoryGoalPlanName=data.exl.read(data.strDataSheetName,data. DataRow, CategoryGoalPlanName);
			categoryMeasurements=data.exl.read(data.strDataSheetName,data. DataRow, categoryMeasurements);
			Perspective=data.exl.read(data.strDataSheetName, data.DataRow, Perspective);

			rpt.enterStepHeader("Add Goal detail");
			// Enter Basic Goal plans
			cmnLib.clickOnWebElement(massAsignGoal.expandGoalPlan);

			cmnLib.clickOnWebElement(massAsignGoal.clickGoalPlan);
			cmnLib.waitForPageLoaded();

			// Enter Basic Goal plan details
			if(CategoryGoalPlanName.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(massAsignGoal.enterGoalName)&&
						cmnLib.enterDataInTextBox(massAsignGoal.enterGoalName,CategoryGoalPlanName,true))
				{

					log.info("Goal Plan entered");
					rpt.generateReport("", "Enter Goal Plan", "", "\nGoal Plan : " + CategoryGoalPlanName,
							"Goal Plan field should exist",
							"Goal Plan entered successfully", "Passed", "", true);			
				}
				else
				{
					rpt.generateReport("", "Goal Plan entered", "", "",
							"Goal Plan field should exist",
							"Goal Plan field does not exist", "Failed", "", true);
					Assert.fail("Goal Plan field does not exist");

				}
			}

			if(categoryMeasurements.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(massAsignGoal.EnterbasicInfoMeasurement)&&
						cmnLib.enterDataInTextBox(massAsignGoal.EnterbasicInfoMeasurement,categoryMeasurements,true))
				{

					log.info("Measurement entered");
					rpt.generateReport("", "Enter Measurement", "", "\nMeasurement : " + categoryMeasurements,
							"Measurement field should exist",
							"Measurement entered successfully", "Passed", "", true);			
				}
				else
				{
					rpt.generateReport("", "Measurement entered", "", "",
							"Measurement field should exist",
							"Measurement field does not exist", "Failed", "", true);
					Assert.fail("Measurement field does not exist");

				}
			}


			if(Perspective.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(massAsignGoal.EnterPerspective))
				{
					cmnLib.clickOnWebElement(massAsignGoal.EnterPerspective);

					//cmnLib.clickOnWebElement(createGP.perspectiveValue);

					getDriver().findElement(By.xpath("//li[contains(.,'"+Perspective+"')]")).click();
					log.info("Perspective entered");
					rpt.generateReport("", "Enter Perspective", "", "\nPerspective : " + Perspective,
							"Perspective field should exist",
							"Perspective entered successfully", "Passed", "", true);			
				}
				else
				{
					rpt.generateReport("", "Perspective entered", "", "",
							"Perspective field should exist",
							"Perspective field does not exist", "Failed", "", true);
					Assert.fail("Perspective field does not exist");

				}
			}


			cmnLib.enterDataInTextBox(massAsignGoal.enterWeight, "10", false);

			cmnLib.clickOnWebElement(massAsignGoal.SaveandClose);

			Thread.sleep(5000);
			cmnLib.clickOnWebElement(massAsignGoal.expandGoalPlan);
			Thread.sleep(5000);
			String goalPlan=massAsignGoal.validatebasicInoGoalPlan.getText();

			System.out.println("created goal plan :::"+ goalPlan);


			if (goalPlan.trim().contains(CategoryGoalPlanName)) {
				rpt.generateReport("", "Created Goal Plan display in the list", "", "\nGoal Plan : " + goalPlan,
						"Created Goal Plan  should be display in the list",
						"Goal Plan  display successfully", "Passed", "", true);
			}
			else
			{
				rpt.generateReport("", "Created Goal Plan display in the list", "", "",
						"Created Goal Plan should be display in the list",
						"Goal Plan does not display in the list", "Failed", "", true);
				Assert.fail("Goal Plan does not display in the list");
			}

			// Click on Save and close

			cmnLib.clickOnWebElement(massAsignGoal.saveandClosebtn);

			//////// Validate

			TimeUnit.SECONDS.sleep(15);

			rpt.enterStepHeader("Validate Created Goal Plan");
			if (massAsignGoal.clearFilter.isDisplayed()) {
				cmnLib.clickOnWebElement(massAsignGoal.clearFilter);
			}
			TimeUnit.SECONDS.sleep(2);
			cmnLib.enterDataInTextBox(massAsignGoal.searchReviewPeriod, "", true);

			String genProcessName=massAsignGoal.selectValue.getText();
			System.out.println("Generate Goal Plan: "+genProcessName);

			if (genProcessName.trim().contains(ProcessNames.trim())) {
				rpt.generateReport("", "Process Name display in the list", "", "\nProcess Name : " + ProcessNames,
						"Process name should be display in the list",
						"Process name display successfully", "Passed", "", true);
			}
			else { rpt.generateReport("", "Process Name display in the list", "", "",
					"Process Name should be display in the list",
					"Process Name does not display in the list", "Failed", "", true);
			Assert.fail("Process Name does not display in the list");
			}


			cmnLib.clickOnWebElement(massAsignGoal.backBtn);

			cmnLib.waitForPageLoaded();


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^Run the batch process and validate$")
	public void run_the_batch_process_and_validate() {


		try {
			cmnLib.clickOnWebElement(massAsignGoal.processType);

			cmnLib.clickOnWebElement(massAsignGoal.processTypeValue);

			cmnLib.enterDataInTextBox(massAsignGoal.processName, ProcessNames, true);

			cmnLib.clickOnWebElement(massAsignGoal.submitButton);

			String msg=massAsignGoal.ConfirmationMsg.getText();
			
			System.out.println("Confirmation Msg :: "+msg);
			
			if (msg.trim().contains("was submitted.")) {
				rpt.generateReport("", "Confirmation message display", "", "\nConfirmation message: " + msg,
						"Confirmation message should be display",
						"Confirmation message display successfully", "Passed", "", true);
			}
			else
			{
				rpt.generateReport("", "Confirmation message display", "", "",
						"Confirmation message should be display",
						"Confirmation message does not display", "Failed", "", true);
				Assert.fail("Confirmation message does not display");
			}
			

			cmnLib.clickOnWebElement(massAsignGoal.okbutton);

			Thread.sleep(5000);
			
			cmnLib.clickOnWebElement(massAsignGoal.moniterProcess);
			
			Thread.sleep(5000);

			cmnLib.clickOnWebElement(massAsignGoal.refereshbutton);

			String stat=massAsignGoal.status.getText();

			System.out.println("Status ::: "+ stat);
			
			if (stat.trim().contains("Succeeded")) {
				rpt.generateReport("", "Status should be succeeded", "", "\nStatus: " + stat,
						"Status should be succeeded",
						"Status display as succeeded", "Passed", "", true);
			}
			else
			{
				rpt.generateReport("", "Status should be succeeded", "", "",
						"Status should be succeeded",
						"Status should not be succeeded", "Failed", "", true);
				Assert.fail("Status should not be succeeded");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
