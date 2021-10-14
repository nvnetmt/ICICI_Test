package com.oracle.ICICI.HCM.steps;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oracle.ICICI.HCM.pages.CreateParticipantEligibilityProfilePage;
import com.oracle.ICICI.HCM.pages.ManageEligibilityProfilePage;
import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.ICICI.common.steps.DatabankInitialization;
import com.oracle.ICICI.common.steps.ReportingSteps;
import com.oracle.acs.util.BrowserDriverUtil;

import io.cucumber.java.en.Then;
import com.oracle.acs.util.report.ReportGeneration;
import com.oracle.acs.util.ExcelOperations;

public class ManageEligibilityProfileSteps extends BrowserDriverUtil {

	public static ReportGeneration rpt = ReportingSteps.getRpt();
	Common_Library cmnLib = ReportingSteps.cmnLib;
	DatabankInitialization data = new DatabankInitialization();
	ExcelOperations exl = DatabankInitialization.exl;
	private String strDataSheetName = DatabankInitialization.strDataSheetName;
	private int DataRow = DatabankInitialization.DataRow;
	static final Logger log = LoggerFactory.getLogger(ManageEligibilityProfileSteps.class);
	public String eligibilityProfileName;

	ManageEligibilityProfilePage eligiProfile = new ManageEligibilityProfilePage();
	CreateParticipantEligibilityProfilePage createEligibilityProfilePage = new CreateParticipantEligibilityProfilePage();

	@Then("^Click On Create Participant Profile icon$")
	public void click_Create_Participant_Profile() throws Throwable {
		if (!cmnLib.clickOnWebElement(eligiProfile.lnkCreate)
				&& cmnLib.waitForElementToBeVisible(eligiProfile.lnkCreateParticipantProfile)) {
			rpt.generateReport("", "Click Create icon", "", "", "Create Participant profile must be displayed",
					"Create Participant profile not displayed", "Failed", "", true);
			Assert.fail("Create Participant profile not displayed");
		}

		if (!cmnLib.clickOnWebElement(eligiProfile.lnkCreateParticipantProfile) && cmnLib
				.waitForElementToBeVisible(createEligibilityProfilePage.hdrCreateParticipantEligibilityProfile)) {
			rpt.generateReport("", "Click Create Participant profile link", "", "",
					"Create Participant profile page must be displayed",
					"Create Participant profile page not displayed", "Failed", "", true);
			Assert.fail("Create Participant profile page not displayed");
		} else {
			rpt.generateReport("", "Click Create Participant profile link", "", "",
					"Create Participant profile page must be displayed", "Create Participant profile page displayed",
					"Passed", "", true);
		}
	}

	@Then("^Enter Eligibility Profile Definition \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void enter_Eligibility_Profile_Definition(String name, String description, String profileUsage,
			String status) throws Throwable {

		name = cmnLib.randomNumber(exl.read(strDataSheetName, DataRow, "Name"));
		eligibilityProfileName = name;
		if (!cmnLib.enterDataInTextBox(createEligibilityProfilePage.txtName, name, true)) {
			rpt.generateReport("", "Enter Name", "", name, "Name must be entered", "Name not entered", "Failed", "",
					true);
			Assert.fail("Name not entered");
		}

		description = exl.read(strDataSheetName, DataRow, "Description");
		if (!cmnLib.enterDataInTextBox(createEligibilityProfilePage.txtDescription, description, true)) {
			rpt.generateReport("", "Enter Description", "", description, "Description must be entered",
					"Description not entered", "Failed", "", true);
			Assert.fail("Description not entered");
		}

		profileUsage = exl.read(strDataSheetName, DataRow, "ProfileUsage");
		if (!createEligibilityProfilePage.selectOptionFromComboBox("Profile Usage", profileUsage)) {
			rpt.generateReport("", "Select Profile Usage", "", profileUsage, "Profile Usage must be selected",
					"Profile Usage not selected", "Failed", "", true);
			Assert.fail("Profile Usage not entered");
		}

		status = exl.read(strDataSheetName, DataRow, "Status");
		if (!createEligibilityProfilePage.selectOptionFromComboBox("Status", status)) {
			rpt.generateReport("", "Enter Status", "", status, "Status must be entered", "Status not entered", "Failed",
					"", true);
			Assert.fail("Status not entered");
		}

		rpt.generateReport(
				"", "Enter Eligibility Profile Definition", "", "Name: " + name + "\nDescription: " + description
						+ "\nProfile Usage: " + profileUsage + "Status: " + status,
				"Required details must be entered", "Entered required details", "Passed", "", true);

	}

	@Then("^Enter Eligibility Criteria \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void enter_Eligibility_Criteria(String gender, String grade, String department) throws Throwable {

		// Gender
		createEligibilityProfilePage.selectTab("Personal");
		createEligibilityProfilePage.selectTab("Gender");
		cmnLib.clickOnWebElement(createEligibilityProfilePage.icnCreate);
		cmnLib.enterDataInTextBox(createEligibilityProfilePage.txtSequence, "1", true);
		gender = exl.read(strDataSheetName, DataRow, "Gender");
		if (createEligibilityProfilePage.selectOptionFromComboBoxInsideTable(createEligibilityProfilePage.lnkGender,
				gender)) {
			rpt.generateReport("", "Select Gender", "", gender, "Gender must be entered", "Selected Gender", "Passed",
					"", true);
		} else {
			rpt.generateReport("", "Select Gender", "", gender, "Gender must be entered", "Gender not selected",
					"Failed", "", true);
			Assert.fail("Gender not selected");
		}

		// Grade
		createEligibilityProfilePage.selectTab("Employment");
		createEligibilityProfilePage.selectTab("Grade");
		cmnLib.clickOnWebElement(createEligibilityProfilePage.icnCreate);
		cmnLib.enterDataInTextBox(createEligibilityProfilePage.txtSequence, "1", true);
		grade = exl.read(strDataSheetName, DataRow, "Grade");
		if (cmnLib.enterDataInTextBox(createEligibilityProfilePage.txtGrade, grade, true)) {
			rpt.generateReport("", "Select Grade", "", grade, "Grade must be entered", "Selected Grade", "Passed", "",
					true);
		} else {
			rpt.generateReport("", "Select Grade", "", grade, "Grade must be entered", "Grade not selected", "Failed",
					"", true);
			Assert.fail("Grade not selected");
		}

		// Department
		createEligibilityProfilePage.selectTab("Department");
		cmnLib.clickOnWebElement(createEligibilityProfilePage.icnCreate);
		cmnLib.enterDataInTextBox(createEligibilityProfilePage.txtSequence, "1", true);
		department = exl.read(strDataSheetName, DataRow, "Department");
		if (cmnLib.enterDataInTextBox(createEligibilityProfilePage.txtDepartment, department, true)) {
			rpt.generateReport("", "Select Department", "", department, "Department must be entered",
					"Selected Department", "Passed", "", true);
		} else {
			rpt.generateReport("", "Select Department", "", department, "Department must be entered",
					"Department not selected", "Failed", "", true);
			Assert.fail("Department not selected");
		}

	}

	@SuppressWarnings("static-access")
	@Then("^Enter Eligiblity Profile Details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void enter_Eligiblity_Profile_Details(String description, String gender, String userProfile, String grade,
			String gradeSetName, String Department) {
		try {

			description = data.exl.read(data.strDataSheetName, data.DataRow, description);
			gender = data.exl.read(data.strDataSheetName, data.DataRow, gender);
			userProfile = data.exl.read(data.strDataSheetName, data.DataRow, userProfile);
			grade = data.exl.read(data.strDataSheetName, data.DataRow, grade);
			gradeSetName = data.exl.read(data.strDataSheetName, data.DataRow, gradeSetName);
			Department = data.exl.read(data.strDataSheetName, data.DataRow, Department);

			String random = cmnLib.randomNumber("Eligibility Profile Test");
			eligibilityProfileName = random;

			System.out.println("Eligibility Profile Name :::: " + eligibilityProfileName);

			rpt.enterStepHeader("Enter detail to create the Review Period ");
			if (eligibilityProfileName.length() > 0) {
				if (cmnLib.waitForElementToBeVisible(eligiProfile.EnterName)
						&& cmnLib.enterDataInTextBox(eligiProfile.EnterName, eligibilityProfileName, false)) {
					log.info("Eligibility profile name entered");
					rpt.generateReport("", "Enter eligibility profile name", "",
							"\nEligibility Profile Name: " + eligibilityProfileName,
							"Eligibility profile field should exist", "Eligibility profile value entered successfully",
							"Passed", "", true);
				} else {
					rpt.generateReport("", "Eligibility profile name entered", "", "",
							"Eligibility profile field should exist", "Eligibility profile field does not exist",
							"Failed", "", true);
					Assert.fail("Eligibility profile field does not exist");

				}
			}

			if (description.length() > 0) {
				if (cmnLib.waitForElementToBeVisible(eligiProfile.EnterDescription)
						&& cmnLib.enterDataInTextBox(eligiProfile.EnterDescription, description, true)) {
					log.info("Eligibility profile description name entered");
					rpt.generateReport("", "Enter Eligibility profile description", "",
							"\nEligibility Profile description: " + description,
							"Eligibility profile description field should exist",
							"Eligibility profile description entered successfully", "Passed", "", true);
				} else {
					rpt.generateReport("", "Eligibility profile description entered", "", "",
							"Eligibility profile description field should exist",
							"Eligibility profile description field does not exist", "Failed", "", true);
					Assert.fail("Eligibility profile description field does not exist");
				}
			}

			if (userProfile.length() > 0) {
				if (cmnLib.waitForElementToBeVisible(eligiProfile.profileUses)
						&& cmnLib.clickOnWebElement(eligiProfile.profileUses)) {
					log.info("User Profile entered");
					rpt.generateReport("", "Enter User Profile", "", "\nUser Profile: " + userProfile,
							"User Profile field should exist", "User Profile entered successfully", "Passed", "", true);
				} else {
					rpt.generateReport("", "User Profile entered", "", "", "User Profile field should exist",
							"User Profile field does not exist", "Failed", "", true);
					Assert.fail("User Profile field does not exist");
				}
			}

			cmnLib.clickOnWebElement(eligiProfile.GoalMangementValue);

			cmnLib.clickOnWebElement(eligiProfile.createPersonalBtn);

			cmnLib.enterDataInTextBox(eligiProfile.personalSequence, "1", true);

			cmnLib.clickOnWebElement(eligiProfile.genderField);

			if (gender.length() > 0) {
				if (cmnLib.waitForElementToBeVisible(eligiProfile.gender)
						&& cmnLib.clickOnWebElement(eligiProfile.gender)) {
					log.info("Gender entered");
					rpt.generateReport("", "Enter Gender", "", "\nUser Profile: " + gender, "Gender field should exist",
							"Gender entered successfully", "Passed", "", true);
				} else {
					rpt.generateReport("", "Gender entered", "", "", "Gender field should exist",
							"Gender field does not exist", "Failed", "", true);
					Assert.fail("Gender field does not exist");
				}
			}

			cmnLib.clickOnWebElement(eligiProfile.employmentLink);

			cmnLib.clickOnLinkText("Grade");

			cmnLib.clickOnWebElement(eligiProfile.createGradeButton);

			cmnLib.enterDataInTextBox(eligiProfile.personalSequence, "1", true);

			if (grade.length() > 0) {
				if (cmnLib.waitForElementToBeVisible(eligiProfile.gradeName)
						&& cmnLib.enterDataInTextBox(eligiProfile.gradeName, grade, true)) {
					Thread.sleep(5000);

					getDriver().findElement(By.xpath("(//td[@class='xen'][contains(.,'" + gradeSetName + "')])"))
							.click();
					Thread.sleep(5000);

					Robot rob = new Robot();
					rob.keyPress(KeyEvent.VK_ENTER);
					rob.keyRelease(KeyEvent.VK_ENTER);

					log.info("Grade entered");
					rpt.generateReport("", "Enter Grade", "", "\nUser Profile: " + grade, "Grade field should exist",
							"Grade entered successfully", "Passed", "", true);
				} else {
					rpt.generateReport("", "Grade entered", "", "", "Grade field should exist",
							"Grade field does not exist", "Failed", "", true);
					Assert.fail("Grade field does not exist");
				}
			}

			cmnLib.clickOnLinkText("Department");

			cmnLib.clickOnWebElement(eligiProfile.createDepartmentButton);

			cmnLib.enterDataInTextBox(eligiProfile.departmentSequence, "1", false);

			if (Department.length() > 0) {
				if (cmnLib.waitForElementToBeVisible(eligiProfile.departmentName)
						&& cmnLib.enterDataInTextBox(eligiProfile.departmentName, Department, true)) {
					log.info("Department entered");
					rpt.generateReport("", "Enter Department", "", "\nDepartment : " + grade,
							"Department field should exist", "Department entered successfully", "Passed", "", true);
				} else {
					rpt.generateReport("", "Department entered", "", "", "Department field should exist",
							"Department field does not exist", "Failed", "", true);
					Assert.fail("Department field does not exist");

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^Save Eligiblity Profile$")
	public void save_Eligiblity_Profile() throws Throwable {
		if (cmnLib.clickOnWebElement(createEligibilityProfilePage.btnSaveAndClose)
				&& cmnLib.waitForElementToBeVisible(eligiProfile.hdrEligibilityProfiles)) {
			rpt.generateReport("", "Click Save button", "", "", "Participant Profile must be saved",
					"Participant Profile saved", "Passed", "", true);
		} else {
			rpt.generateReport("", "Click Save button", "", "", "Participant Profile must be saved",
					"Participant Profile not saved", "Failed", "", true);
			Assert.fail("Participant Profile not saved");
		}

	}

	@Then("^Verifiy the generated Eligiblity Profile$")
	public void verifiy_the_generated_Eligiblity_Profile() throws Throwable {

		if (!cmnLib.enterDataInTextBox(eligiProfile.txtName, eligibilityProfileName, true)) {
			rpt.generateReport("", "Enter Name", "", eligibilityProfileName, "Name must be entered", "Name not entered",
					"Failed", "", true);
			Assert.fail("Name not entered");
		} else {
			rpt.generateReport("", "Enter Name", "", eligibilityProfileName, "Name must be entered", "Entered Name",
					"Passed", "", true);
		}

		if (!(cmnLib.clickOnWebElement(eligiProfile.btnSearch)
				&& cmnLib.waitForElementToBeVisible(eligiProfile.tblBdySearchResults))) {
			rpt.generateReport("", "Click Search button", "", "", "Profile Name must appear in results",
					"Profile name did not appear in results", "Failed", "", true);
			Assert.fail("Profile name did not appear in results");
		} else {
			rpt.generateReport("", "Click Search button", "", "", "Profile Name must appear in results",
					"Profile name appears in results", "Passed", "", true);
		}

	}

}
