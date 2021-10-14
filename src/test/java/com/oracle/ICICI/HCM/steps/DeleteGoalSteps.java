package com.oracle.ICICI.HCM.steps;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oracle.ICICI.HCM.pages.DeleteGoalPage;
import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.ICICI.common.steps.DatabankInitialization;
import com.oracle.ICICI.common.steps.ReportingSteps;
import com.oracle.acs.util.BrowserDriverUtil;

import io.cucumber.java.en.Then;
import com.oracle.acs.util.report.ReportGeneration;

public class DeleteGoalSteps extends BrowserDriverUtil {
	
	public static ReportGeneration rpt = ReportingSteps.getRpt();
	Common_Library cmnLib = ReportingSteps.cmnLib;
	
	DatabankInitialization data= new DatabankInitialization();
	DeleteGoalPage deleteGoal= new DeleteGoalPage();
	static final Logger log = LoggerFactory.getLogger(DeleteGoalSteps.class);


	@SuppressWarnings("static-access")
	@Then("^Perform Delete action \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void perform_Delete_action(String ReviewPeriod, String Employee, String GoalPlan) {

		try {

			Robot rob= new Robot();
			ReviewPeriod=data.exl.read(data.strDataSheetName, data.DataRow, ReviewPeriod);
			Employee=data.exl.read(data.strDataSheetName,data. DataRow, Employee);
			GoalPlan=data.exl.read(data.strDataSheetName,data. DataRow, GoalPlan);

			rpt.enterStepHeader("Enter detail to retrive the Goals ");


			if(ReviewPeriod.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(deleteGoal.ReviewPeriod))
				{
					cmnLib.clickOnWebElement(deleteGoal.ReviewPeriod);
					cmnLib.enterDataInTextBox(deleteGoal.ReviewPeriod, "", false);

					cmnLib.enterDataInTextBox(deleteGoal.ReviewPeriod, ReviewPeriod, false);

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

			if(ReviewPeriod.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(deleteGoal.employee))
				{
					cmnLib.clickOnWebElement(deleteGoal.employee);
					cmnLib.enterDataInTextBox(deleteGoal.employee, Employee, false);
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
				if(cmnLib.waitForElementToBeVisible(deleteGoal.employee))
				{
					cmnLib.clickOnWebElement(deleteGoal.goalStatusCheckBox);
					cmnLib.enterDataInTextBox(deleteGoal.goalNameSearchTextBox, GoalPlan, true);
					
					cmnLib.clickOnWebElement(deleteGoal.searchGoalPlan);
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
			cmnLib.clickOnWebElement(deleteGoal.goalPlanCheckBox);

			 cmnLib.clickOnWebElement(deleteGoal.action);
			 
			cmnLib.clickOnWebElement(deleteGoal.delete);
			
			cmnLib.clickOnWebElement(deleteGoal.backbutton);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("^Perform delete goal by Employee \"([^\"]*)\" \"([^\"]*)\"$")
	public void Perform_delete_goal_by_Employee(String ReviewPeriod, String GoalPlan) {

		try 
		{
			ReviewPeriod=data.exl.read(data.strDataSheetName, data.DataRow, ReviewPeriod);
			//Employee=data.exl.read(data.strDataSheetName,data. DataRow, Employee);
			GoalPlan=data.exl.read(data.strDataSheetName,data. DataRow, GoalPlan);

			if(deleteGoal.SelectEmpReviewPeriod(ReviewPeriod))
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

			if(deleteGoal.SelectEmpGoalPlan(GoalPlan))
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
	
	@Then("^Validate the delete goal by nonadmin \"([^\"]*)\"$")
	public void validate_the_delete_goal_by_nonadmin(String Goalplan) {

		try 
		{
			cmnLib.clickOnWebElement(deleteGoal.action);

			if(cmnLib.waitForElementToBeVisible(deleteGoal.delete))
			{
				rpt.generateReport("", "Verify Goal Option", "", "",
						"Delete Goal option should not be exist for non admin users",
						"Delete Goal option is existing", "Failed", "", true);
				Assert.fail("Cancel Goal option is existing for non admin  users");

			}
			else
			{
				rpt.generateReport("", "Verify Goal Option", "", "",
						"Delete Goal option should not be exist for non admin users",
						"Delete Goal option does not exist", "Passed", "", true);



			}
			//cmnLib.clickOnWebElement(cancelGoal.backbutton);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
