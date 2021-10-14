package com.oracle.ICICI.HCM.steps;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oracle.ICICI.HCM.pages.CreateGoalPlansOtherPlansNonPrimaryPage;
import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.ICICI.common.steps.DatabankInitialization;
import com.oracle.ICICI.common.steps.ReportingSteps;
import com.oracle.acs.util.BrowserDriverUtil;

import io.cucumber.java.en.Then;
import com.oracle.acs.util.report.ReportGeneration;

public class CreateGoalPlansOtherPlansNonPrimarySteps extends BrowserDriverUtil {

	public static ReportGeneration rpt = ReportingSteps.getRpt();
	Common_Library cmnLib = ReportingSteps.cmnLib;
	
	DatabankInitialization data= new DatabankInitialization();
	static final Logger log = LoggerFactory.getLogger(CreateGoalPlansOtherPlansNonPrimarySteps.class);

	CreateGoalPlansOtherPlansNonPrimaryPage createGP= new CreateGoalPlansOtherPlansNonPrimaryPage();

	@Then("^Click on Other Plan add button$")
	public void click_on_Other_Plan_add_button() {
		try {
			cmnLib.waitForPageLoaded();

			cmnLib.clickOnWebElement(createGP.otherPlanAddButton);
			cmnLib.waitForPageLoaded();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String GoalPlanNames;
	@SuppressWarnings("static-access")
	@Then("^Enter Goal plans details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void enter_Goal_plans_details( String GoalPlanName, String Measurements, String ReviewPeriod) {
		try {
			TimeUnit.SECONDS.sleep(10);
			GoalPlanName=data.exl.read(data.strDataSheetName,data. DataRow, GoalPlanName);
			Measurements=data.exl.read(data.strDataSheetName,data. DataRow, Measurements);
			ReviewPeriod=data.exl.read(data.strDataSheetName, data.DataRow, ReviewPeriod);

			String random=cmnLib.randomNumber(GoalPlanName);
			GoalPlanNames=random;
			rpt.enterStepHeader("Enter Goal Plan Detial");
			if(GoalPlanName.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(createGP.GoalPlanName)&&
						cmnLib.enterDataInTextBox(createGP.GoalPlanName,GoalPlanNames,true))
				{
					log.info("Goal Plan Name entered");
					rpt.generateReport("", "Enter Goal Plan Name", "", "\nGoal Plan Name : " + GoalPlanNames,
							"Goal Plan Name field should exist",
							"Goal Plan Name entered successfully", "Passed", "", true);			
				}
				else
				{
					rpt.generateReport("", "Goal Plan Name entered", "", "",
							"Goal Plan Name field should exist",
							"Goal Plan Name field does not exist", "Failed", "", true);
					Assert.fail("Goal Plan Name field does not exist");

				}
			}



			if(Measurements.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(createGP.measurements)&&
						cmnLib.enterDataInTextBox(createGP.measurements,Measurements,true))
				{
					log.info("Measurements entered");
					rpt.generateReport("", "Enter Measurements", "", "\nMeasurements : " + Measurements,
							"Measurements field should exist",
							"Measurements entered successfully", "Passed", "", true);			
				}
				else
				{
					rpt.generateReport("", "Measurements entered", "", "",
							"Measurements field should exist",
							"Measurements field does not exist", "Failed", "", true);
					Assert.fail("Measurements field does not exist");

				}
			}


			if(ReviewPeriod.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(createGP.reviewPeriod))
				{
					cmnLib.clickOnWebElement(createGP.reviewPeriod);
					
					getDriver().findElement(By.xpath("//li[contains(.,'"+ReviewPeriod+"')]")).click();
					log.info("Review Period entered");
					rpt.generateReport("", "Enter Review Period", "", "\nReview Period : " + ReviewPeriod,
							"Review Period field should exist",
							"Review Period entered successfully", "Passed", "", true);			
				}
				else
				{
					rpt.generateReport("", "Review Period entered", "", "",
							"Review Period field should exist",
							"Review Period field does not exist", "Failed", "", true);
					Assert.fail("Review Period field does not exist");

				}
			}


			cmnLib.clickOnWebElement(createGP.performanceDocType);
			cmnLib.clickOnWebElement(createGP.PerformanceDocAnualEvaluation);

			TimeUnit.SECONDS.sleep(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	@Then("^Enter Basic info Goal Plan details and Validate \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void enter_Basic_info_Goal_Plan_details_and_Validate(String CategoryGoalPlanName, String categoryMeasurements, String Perspective)  {
		CategoryGoalPlanName=data.exl.read(data.strDataSheetName,data. DataRow, CategoryGoalPlanName);
		categoryMeasurements=data.exl.read(data.strDataSheetName,data. DataRow, categoryMeasurements);
		Perspective=data.exl.read(data.strDataSheetName, data.DataRow, Perspective);
		try {
			rpt.enterStepHeader("Add Goal detail");
			// Enter Basic Goal plans
			cmnLib.clickOnWebElement(createGP.expandGoalsPart);
			for (int i = 1; i <= 3; i++) {

				cmnLib.clickOnWebElement(createGP.addGoalButton);
				cmnLib.waitForPageLoaded();
				
				// Enter Basic Goal plan details
				if(CategoryGoalPlanName.length()>0)
				{
					if(cmnLib.waitForElementToBeVisible(createGP.enterGoalName)&&
							cmnLib.enterDataInTextBox(createGP.enterGoalName,CategoryGoalPlanName+"_"+i,true))
					{

						log.info("Goal Plan entered");
						rpt.generateReport("", "Enter Goal Plan", "", "\nGoal Plan : " + CategoryGoalPlanName+"_"+i,
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
					if(cmnLib.waitForElementToBeVisible(createGP.EnterbasicInfoMeasurement)&&
							cmnLib.enterDataInTextBox(createGP.EnterbasicInfoMeasurement,categoryMeasurements+"_"+i,true))
					{

						log.info("Measurement entered");
						rpt.generateReport("", "Enter Measurement", "", "\nMeasurement : " + categoryMeasurements+"_"+i,
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
					if(cmnLib.waitForElementToBeVisible(createGP.EnterPerspective))
					{
						cmnLib.clickOnWebElement(createGP.EnterPerspective);

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


				cmnLib.enterDataInTextBox(createGP.enterWeight, "10", false);

				cmnLib.clickOnWebElement(createGP.SaveandClose);

				cmnLib.clickOnWebElement(createGP.expandGoalsPart);
				TimeUnit.SECONDS.sleep(10);
				
				String goalPlan=createGP.validatebasicInoGoalPlan.getText();

				System.out.println("created goal plan :::"+ goalPlan);


				if (goalPlan.trim().contains(CategoryGoalPlanName+"_"+i)) {
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
			}

			cmnLib.clickOnWebElement(createGP.collapseGoalPart);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@SuppressWarnings("static-access")
	@Then("^Enter eligilility Profile and validate \"([^\"]*)\"$")
	public void enter_eligilility_Profile_and_validate(String EligiblityProfile) {
		try {
			EligiblityProfile=data.exl.read(data.strDataSheetName,data. DataRow, EligiblityProfile);

			rpt.enterStepHeader("Add Eligibility Profile");
			cmnLib.clickOnWebElement(createGP.expandEligibility);

			cmnLib.clickOnWebElement(createGP.addeligbilityProfile);


			if(EligiblityProfile.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(createGP.enterEligiblityProfile))
				{
					cmnLib.clickOnWebElement(createGP.enterEligiblityProfile);

					//cmnLib.clickOnWebElement(createGP.enterEligiblityProfileValue);
					getDriver().findElement(By.xpath("(//div[contains(.,'"+EligiblityProfile+"')])[10]")).click();
					log.info("Eligiblity Profile entered");
					rpt.generateReport("", "Enter Eligiblity Profile", "", "\nPerspective : " + EligiblityProfile,
							"Eligiblity Profile field should exist",
							"Eligiblity Profile entered successfully", "Passed", "", true);			
				}
				else
				{
					rpt.generateReport("", "Eligiblity Profile entered", "", "",
							"Eligiblity Profile field should exist",
							"Eligiblity Profile field does not exist", "Failed", "", true);
					Assert.fail("Eligiblity Profile field does not exist");

				}
			}

			cmnLib.clickOnWebElement(createGP.saveEligiblityProfile);

			TimeUnit.SECONDS.sleep(2);
			String eligProf=createGP.eligiblityProfileValue.getText();

			System.out.println("Eligibility Profile Value : "+ eligProf);

			if (eligProf.trim().contains(EligiblityProfile.trim())) {
				rpt.generateReport("", "Eligiblity Profile display in the list", "", "\nEligiblity Profile : " + eligProf,
						"Eligiblity Profile  should be display in the list",
						"Eligiblity Profile  display successfully", "Passed", "", true);
			}
			else
			{
				rpt.generateReport("", "Eligiblity Profile display in the list", "", "",
						"Eligiblity Profile should be display in the list",
						"Eligiblity Profile does not display in the list", "Failed", "", true);
				Assert.fail("Eligiblity Profile does not display in the list");
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("^Save goal plan$")
	public void Save_goal_plan()  {


		try {
			TimeUnit.SECONDS.sleep(10);
			cmnLib.clickOnWebElement(createGP.saveandClosebtn);
			cmnLib.waitForPageLoaded();
			TimeUnit.SECONDS.sleep(10);

			cmnLib.clickOnWebElement(createGP.HomeButton);
			TimeUnit.SECONDS.sleep(15);
			if (createGP.msgNo.isDisplayed()) {
				cmnLib.clickOnWebElement(createGP.msgNo);

			}
			TimeUnit.SECONDS.sleep(15);
			cmnLib.clickOnWebElement(createGP.backButton);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Save and Closed ");


	}

	@Then("^Validate goal plan \"([^\"]*)\"$")
	public void validate_goal_plan(String ReviewPeriod)  throws Exception{
		Robot rob= new Robot();
		try {
			TimeUnit.SECONDS.sleep(15);
			rpt.enterStepHeader("Validate Created Goal Plan");
			ReviewPeriod=data.exl.read(data.strDataSheetName, data.DataRow, ReviewPeriod);

			cmnLib.enterDataInTextBox(createGP.searchReviewPeriod, "", false);
			cmnLib.enterDataInTextBox(createGP.searchReviewPeriod, ReviewPeriod, false);			 
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.keyRelease(KeyEvent.VK_ENTER);

			if(createGP.verifyGoalPlanInResults(GoalPlanNames)){
				rpt.generateReport("", "Goal Plan Name display in the list", "", "\nGoal Plan Name : " + GoalPlanNames,
						"Goal Plan Name should be display in the list",
						"Goal Plan Name display successfully", "Passed", "", true);
			}
			else { rpt.generateReport("", "Goal Plan Name display in the list", "", "",
					"Goal Plan Name should be display in the list",
					"Goal Plan Name does not display in the list", "Failed", "", true);
			Assert.fail("Goal Plan Name does not display in the list");
			}

			cmnLib.clickOnWebElement(createGP.HomeButton);
			cmnLib.waitForPageLoaded();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}


	}



}
