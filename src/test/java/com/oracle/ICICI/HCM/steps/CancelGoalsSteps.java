package com.oracle.ICICI.HCM.steps;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oracle.ICICI.HCM.pages.CancelGoalsPage;
import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.ICICI.common.steps.DatabankInitialization;
import com.oracle.ICICI.common.steps.ReportingSteps;
import com.oracle.acs.util.BrowserDriverUtil;

import io.cucumber.java.en.Then;
import com.oracle.acs.util.report.ReportGeneration;

public class CancelGoalsSteps extends BrowserDriverUtil{

	
	public static ReportGeneration rpt = ReportingSteps.getRpt();
	Common_Library cmnLib = ReportingSteps.cmnLib;
	DatabankInitialization data= new DatabankInitialization();
	CancelGoalsPage cancelGoal= new CancelGoalsPage();
	static final Logger log = LoggerFactory.getLogger(CancelGoalsSteps.class);


	@SuppressWarnings("static-access")
	@Then("^Perform Cancel action \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void perform_Cancel_action(String ReviewPeriod, String Employee, String GoalPlan) {

		try {

			Robot rob= new Robot();
			ReviewPeriod=data.exl.read(data.strDataSheetName, data.DataRow, ReviewPeriod);
			Employee=data.exl.read(data.strDataSheetName,data. DataRow, Employee);
			GoalPlan=data.exl.read(data.strDataSheetName,data. DataRow, GoalPlan);

			rpt.enterStepHeader("Enter detail to retrive the Goals ");


			if(ReviewPeriod.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(cancelGoal.ReviewPeriod))
				{
					cmnLib.clickOnWebElement(cancelGoal.ReviewPeriod);
					cmnLib.enterDataInTextBox(cancelGoal.ReviewPeriod, "", false);

					cmnLib.enterDataInTextBox(cancelGoal.ReviewPeriod, ReviewPeriod, false);

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

			if(Employee.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(cancelGoal.employee))
				{
					cmnLib.clickOnWebElement(cancelGoal.employee);
					cmnLib.enterDataInTextBox(cancelGoal.employee, Employee, false);
					TimeUnit.SECONDS.sleep(2);
					rob.keyPress(KeyEvent.VK_ENTER);
					rob.keyRelease(KeyEvent.VK_ENTER);


					log.info("Employee entered");
					rpt.generateReport("", "Enter Employee", "", "\nEmployee: " + Employee,
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

			TimeUnit.SECONDS.sleep(4);

			if(GoalPlan.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(cancelGoal.employee))
				{
					cmnLib.clickOnWebElement(cancelGoal.goalStatusCheckBox);
					cmnLib.enterDataInTextBox(cancelGoal.goalNameSearchTextBox, GoalPlan, true);
					
					cmnLib.clickOnWebElement(cancelGoal.searchGoalPlan);
					TimeUnit.SECONDS.sleep(10);

					log.info("Employee Goal Plan");
					rpt.generateReport("", "Enter Goal Plan", "", "\nGoal Plan: " + GoalPlan,
							"Goal Plan field should exist",
							"Goal Plan value entered successfully", "Passed", "", true);			
				}
				else
				{
					rpt.generateReport("", "Goal Plan entered", "", "",
							"Goal Plan field should exist",
							"Goal Plan field does not exist", "Failed", "", true);
					Assert.fail("Goal Plan field does not exist");


				}
			}

			TimeUnit.SECONDS.sleep(10);
			cmnLib.clickOnWebElement(cancelGoal.goalPlanCheckBox);

			
			 cmnLib.clickOnWebElement(cancelGoal.action);
			 
			cmnLib.clickOnWebElement(cancelGoal.cancel);
			


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("^Validate the cancel goal \"([^\"]*)\"$")
	public void validate_the_cancel_goal(String Goalplan) {

		try {
			
			String Goal = data.exl.read(data.strDataSheetName,data. DataRow, Goalplan);

			TimeUnit.SECONDS.sleep(10);
			cancelGoal.ClearGoal.click();
			TimeUnit.SECONDS.sleep(5);
			cancelGoal.ChkBox_Canceled.click();
			TimeUnit.SECONDS.sleep(10);

			if(cancelGoal.verifyCanceledGoal(Goal)){
				cmnLib.clickOnWebElement(cancelGoal.goalNameSearchTextBox);
				rpt.generateReport("", "Verify Canceled goals", "", "\nGoal Plan Name : " + Goal,
						"Goal should be in canceled list",
						"Goal Plan is canceled successfully", "Passed", "", true);
			}
			else {
				cmnLib.clickOnWebElement(cancelGoal.goalNameSearchTextBox);
				rpt.generateReport("", "Verify Canceled goals", "", "",
						"Goal should be in canceled list",
						"Goal Plan Name does not canceled", "Failed", "", true);
				Assert.fail("Goal Plan Name does not display in canceled list");
			}



			//String status=cancelGoal.status.getText();
			/*
			System.out.println("Status :::: " + status);

			if(status.equalsIgnoreCase("Canceled"))
			{
				log.info("Goal status set as canceled");
				rpt.generateReport("", "Goal status set as canceled", "", "\nGoal: " + status,
						"Goal status should be canceled",
						"Goal status set as canceled", "Passed", "", true);			
			}
			else
			{
				rpt.generateReport("", "Goal status set as canceled", "", "",
						"Goal status should be canceled",
						"Goal status does not set as canceled", "Failed", "", true);
				Assert.fail("Goal status does not set as canceled");


			}*/

			cmnLib.clickOnWebElement(cancelGoal.backbutton);



		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Then("^Perform cancel goal by Employee \"([^\"]*)\" \"([^\"]*)\"$")
	public void Perform_cancel_goal_by_Employee(String ReviewPeriod, String GoalPlan) {

		try 
		{
			ReviewPeriod=data.exl.read(data.strDataSheetName, data.DataRow, ReviewPeriod);
			GoalPlan=data.exl.read(data.strDataSheetName,data. DataRow, GoalPlan);

			if(cancelGoal.SelectEmpReviewPeriod(ReviewPeriod))
			{
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


			if(cancelGoal.SelectEmpGoalPlan(GoalPlan))
			{
				log.info("Employee Goal Plan");
				rpt.generateReport("", "Enter Goal Plan", "", "\nGoal Plan: " + GoalPlan,
						"Goal Plan field should exist",
						"Goal Plan value entered successfully", "Passed", "", true);			
			}
			else
			{
				rpt.generateReport("", "Goal Plan entered", "", "",
						"Goal Plan field should exist",
						"Goal Plan field does not exist", "Failed", "", true);
				Assert.fail("Goal Plan field does not exist");


			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Then("^Validate the cancel goal by nonadmin \"([^\"]*)\"$")
	public void validate_the_cancel_goal_by_nonadmin(String Goalplan) {

		try 
		{
			cmnLib.clickOnWebElement(cancelGoal.action);

			if(cmnLib.waitForElementToBeVisible(cancelGoal.cancel))
			{
				rpt.generateReport("", "Verify Goal Option", "", "",
						"Cancel Goal option should not be exist for non admin users",
						"Cancel Goal option is existing", "Failed", "", true);
				Assert.fail("Cancel Goal option is existing for non admin  users");

			}
			else
			{
				rpt.generateReport("", "Verify Goal Option", "", "",
						"Cancel Goal option should not be exist for non admin users",
						"Cancel Goal option does not exist", "Passed", "", true);



			}
			//cmnLib.clickOnWebElement(cancelGoal.backbutton);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Then("^Select Emp from manager list \"([^\"]*)\"$")
	public void Select_Emp_from_manager_list(String Employee) {

		try 
		{
			Employee=data.exl.read(data.strDataSheetName,data. DataRow, Employee);
			//cmnLib.enterDataInTextBox(cancelGoal.Input_Emp, Employee, true);
			cmnLib.clickOnWebElement(cancelGoal.Input_Emp);
			TimeUnit.SECONDS.sleep(10);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
