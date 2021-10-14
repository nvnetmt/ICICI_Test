package com.oracle.ICICI.HCM.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.oracle.ICICI.HCM.pages.PrintExistingGoalsPage;
import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.ICICI.common.steps.DatabankInitialization;
import com.oracle.ICICI.common.steps.ReportingSteps;
import com.oracle.acs.util.BrowserDriverUtil;

import io.cucumber.java.en.Then;
import com.oracle.acs.util.report.ReportGeneration;

public class PrintExistingGoalsSteps extends BrowserDriverUtil{

	
	public static ReportGeneration rpt = ReportingSteps.getRpt();
	Common_Library cmnLib = ReportingSteps.cmnLib;
	DatabankInitialization data= new DatabankInitialization();
	

	PrintExistingGoalsPage printExtGoal= new PrintExistingGoalsPage();
	
	@Then("^Click on Worker's name$")
	public void click_on_Worker_s_name() throws Throwable {
		
		rpt.enterStepHeader("Click on Worker's name for opening Goal Page");
		
		TimeUnit.SECONDS.sleep(2);
		
		if (cmnLib.clickOnWebElement(printExtGoal.WorkerNameLink) && cmnLib.waitForElementToBeVisible(printExtGoal.hdrGoals)) {
			rpt.generateReport("", "Click on Worker's name", "", "",
					"Worker's name must be clicked and Goal Page for selected worker must be opened",
					"Clicked on Worker's name and Goal Page for selected worker is opened", "Passed", "", true);
		} else {
			rpt.generateReport("", "Click on Worker's name", "", "",
					"Worker's name must be clicked and Goal Page for selected worker must be opened",
					"Either not clicked on Worker's name or Goal Page for selected worker not opened", "Failed", "", true);
			Assert.fail("Either not clicked on Worker's name or Goal Page for selected worker not opened");
		}
		
	}


	@SuppressWarnings("static-access")
	@Then("^Select Review Period and Goal Plan for viewing the goal details \"([^\"]*)\" \"([^\"]*)\"$")
	public void perform_print_action_for_employee(String ReviewPeriod, String GoalSheet) {

		try {


			ReviewPeriod=data.exl.read(data.strDataSheetName,data. DataRow, ReviewPeriod);
			GoalSheet=data.exl.read(data.strDataSheetName,data. DataRow, GoalSheet);

			if(ReviewPeriod.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(printExtGoal.reviewPeriod))
				{
					cmnLib.clickOnWebElement(printExtGoal.reviewPeriod);

					getDriver().findElement(By.xpath("//li[contains(.,'"+ReviewPeriod+"')]"));

					getDriver().findElement(By.xpath("//li[contains(.,'"+ReviewPeriod+"')]")).click();
					
					rpt.generateReport("", "Enter Review Period", "", "\nReview period : " + ReviewPeriod,
							"Review period field should exist",
							"Review period entered successfully", "Passed", "", true);			
				}
				else
				{
					rpt.generateReport("", "Review period entered", "", "",
							"Review period field should exist",
							"Review period field does not exist", "Failed", "", true);
					Assert.fail("Review period field does not exist");

				}
			}


			if(GoalSheet.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(printExtGoal.goalSheet))
				{
					cmnLib.clickOnWebElement(printExtGoal.goalSheet);

					getDriver().findElement(By.xpath("//li[contains(.,'"+GoalSheet+"')]"));

					getDriver().findElement(By.xpath("//li[contains(.,'"+GoalSheet+"')]")).click();
					
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



			cmnLib.clickOnWebElement(printExtGoal.Goals);
			TimeUnit.SECONDS.sleep(5);
			
            cmnLib.clickOnWebElement(printExtGoal.actionButton);

			cmnLib.clickOnWebElement(printExtGoal.print);

			Thread.sleep(7000); 

			rpt.generateReport("", "Displays a new window with goal details printed", "", "",
					"New window with goal details should be displayed",
					"New window with goal details is displayed", "Passed", "", true);		

		    cmnLib.closeWindowTabsExcept("Goals - Oracle Applications");
			cmnLib.switchToWindowTab("Goals - Oracle Applications");
			
            cmnLib.clickOnWebElement(printExtGoal.btnDone);
			TimeUnit.SECONDS.sleep(5);

		} catch (Exception e) {
		}
	}

}
