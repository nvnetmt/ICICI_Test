package com.oracle.ICICI.HCM.steps;

import org.junit.Assert;

import com.oracle.ICICI.HCM.pages.PersonManagementPage;
import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.ICICI.common.steps.DatabankInitialization;
import com.oracle.ICICI.common.steps.ReportingSteps;
import com.oracle.acs.util.BrowserDriverUtil;

import io.cucumber.java.en.Then;
import com.oracle.acs.util.report.ReportGeneration;
import com.oracle.acs.util.ExcelOperations;

public class PersonManagementSteps extends BrowserDriverUtil{
	public static ReportGeneration rpt = ReportingSteps.getRpt();
	Common_Library cmnLib = ReportingSteps.cmnLib;
	
	ExcelOperations exl = DatabankInitialization.exl;
	private String strDataSheetName = DatabankInitialization.strDataSheetName;
	private int DataRow = DatabankInitialization.DataRow;
	
	PersonManagementPage personManagement= new PersonManagementPage();
	
	
	@Then("^Click on Person Management Menu$")
	public void click_on_Person_Management_Menu() throws Throwable {
		
		rpt.enterStepHeader("Click on Person Management Menu");
		
		if (cmnLib.clickOnWebElement(personManagement.MenuPersonManagement)) {
				rpt.generateReport("", "Person Management Menu", "", "", "Person Management Menu should be clicked",
						"Clicked on Person Management Menu", "Passed", "", true);
			}else {
				rpt.generateReport("", "Person Management Menu", "", "", "Person Management Menu should be clicked",
						"Could not click on Person Management Menu ", "Failed", "", true);
				Assert.fail("Failed to Click on Person Management Menu");
			}
		}
	
	@Then("^Perform search for employee in Person Management page \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void perform_search_for_employee_in_Person_Management_page(String pmEmployeeName,String pmEmployeeId,
			String pmNationalId, String pmKeyWords) throws Throwable {
		
		rpt.enterStepHeader("Perform search for employee in Person Management page");
		
		//Employee Name
		
		pmEmployeeName = exl.read(strDataSheetName, DataRow, "PmEmployeeName");
		
		if (cmnLib.enterDataInTextBox(personManagement.PersonManagementName, pmEmployeeName, true)) {
			rpt.generateReport("", "Enter pmEmployeeName", "", "pmEmployeeName:" + pmEmployeeName,
					"pmEmployeeName must be Entered ", "Entered pmEmployeeName ", "Passed", "", true);
		} else {
			rpt.generateReport("", "Enter pmEmployeeName", "", "pmEmployeeName: " + pmEmployeeName,
					"pmEmployeeName must be Entered ", "Not Entered pmEmployeeName ", "Failed", "", true);
			Assert.fail("Not Entered pmEmployeeName");
		}
		
		//Employee ID
		
		pmEmployeeId = exl.read(strDataSheetName, DataRow, "pmEmployeeId");
		
		if (cmnLib.enterDataInTextBox(personManagement.PersonManagementEmployeeId, pmEmployeeId, true)) {
			rpt.generateReport("", "Enter pmEmployeeId", "", "pmEmployeeId:" + pmEmployeeId,
					"pmEmployeeId must be Entered ", "Entered pmEmployeeId ", "Passed", "", true);
		} else {
			rpt.generateReport("", "Enter pmEmployeeId", "", "pmEmployeeId: " + pmEmployeeId,
					"pmEmployeeId must be Entered ", "Not Entered pmEmployeeId ", "Failed", "", true);
			Assert.fail("Not Entered pmEmployeeId");
		}
		
		//National ID
		
		pmNationalId = exl.read(strDataSheetName, DataRow, "pmNationalId");
		
		if (cmnLib.enterDataInTextBox(personManagement.PersonManagementNationalId, pmNationalId, true)) {
			rpt.generateReport("", "Enter pmNationalId", "", "pmNationalId:" + pmNationalId,
					"pmNationalId must be Entered ", "Entered pmNationalId ", "Passed", "", true);
		} else {
			rpt.generateReport("", "Enter pmNationalId", "", "pmNationalId: " + pmNationalId,
					"pmNationalId must be Entered ", "Not Entered pmNationalId ", "Failed", "", true);
			Assert.fail("Not Entered pmNationalId");
		}
		
		// KeyWords
		
		pmKeyWords = exl.read(strDataSheetName, DataRow, "pmKeyWords");
		
		if (cmnLib.enterDataInTextBox(personManagement.PersonManagementKeyWords, pmKeyWords, true)) {
			rpt.generateReport("", "Enter pmKeyWords", "", "pmKeyWords:" + pmKeyWords,
					"pmKeyWords must be Entered ", "Entered pmKeyWords ", "Passed", "", true);
		} else {
			rpt.generateReport("", "Enter pmKeyWords", "", "pmKeyWords: " + pmKeyWords,
					"pmKeyWords must be Entered ", "Not Entered pmKeyWords ", "Failed", "", true);
			Assert.fail("Not Entered pmKeyWords");
		}
		
		
		if (cmnLib.clickOnWebElement(personManagement.btnSearchPersonManagement)
				&& cmnLib.waitForElementToBeVisible(personManagement.tblBodySearchResultsPM)) {
			rpt.generateReport("", "Click Search button", "", "",
					"Search button must be clicked and Results must be displayed",
					"Clicked on Search button and Results displayed", "Passed", "", true);
		} else {
			rpt.generateReport("", "Click Search button", "", "",
					"Search button must be clicked and Results must be displayed",
					"Either not clicked on Search button or Results not displayed", "Failed", "", true);
			Assert.fail("Either not clicked on Search button or Results not displayed");
		}
		
		if (cmnLib.clickOnWebElement(personManagement.btnActionPM)) {
			rpt.generateReport("", "Click Action button", "", "",
					"Action button must be clicked",
					"Clicked on Action button", "Passed", "", true);
		}else {
			rpt.generateReport("", "Click Action button", "", "",
					"Action button must be clicked",
					"Not Clicked on Action button", "Failed", "", true);
			Assert.fail("Either not clicked on Action button");
		}	
	}
	
	
	@Then("^Navigate to Manage Leave and Muster Records Page$")
	public void click_Manage_Leave_and_Muster_Records() throws Throwable {
		
		rpt.enterStepHeader("Navigate to Manage Leave and Muster Records Page");
		
		if (cmnLib.clickOnWebElement(personManagement.lnkLeaveMusterPM)) {
			rpt.generateReport("", "Click Leave and Muster Menu", "", "",
					"Leave and Muster Menu must be clicked",
					"Clicked on Leave and Muster Menu", "Passed", "", true);
		} else {
			rpt.generateReport("", "Click Leave and Muster Menu", "", "",
					"Leave and Muster Menu must be clicked",
					"Either not clicked on Leave and Muster Menu", "Failed", "", true);
			Assert.fail("Either not clicked on Leave and Muster Menu");
		}
		
		if (cmnLib.clickOnWebElement(personManagement.lnkManageLeaveMusterRecordPM)) {
			rpt.generateReport("", "Click Manage Leave and Muster Record Menu", "", "",
					"Manage Leave and Muster Record Menu must be clicked",
					"Clicked on Manage Leave and Muster Record Menu", "Passed", "", true);
		} else {
			rpt.generateReport("", "Click Manage Leave and Muster Record Menu", "", "",
					"Manage Leave and Muster Record Menu must be clicked",
					"Either not clicked on Manage Leave and Muster Record Menu", "Failed", "", true);
			Assert.fail("Either not clicked on Manage Leave and Muster Record Menu");
		}
	}
	
	
	@Then("^Expand Leave and Muster Records$")
	public void expand_Leave_and_Muster_Records() throws Throwable {
			
		rpt.enterStepHeader("Expand Leave and Muster Records");
			
		if (cmnLib.clickOnWebElement(personManagement.ArrowExpandPM)) {
			rpt.generateReport("", "Expand Leave and Muster Records", "", "",
						"Arrow button must be expanded",
						"Expanded leave and Muster Records", "Passed", "", true);
			} else {
				rpt.generateReport("", "Expand Leave and Muster Records", "", "",
						"Arrow button must be expanded",
						"Not Expanded Leave and Muster Records", "Failed", "", true);
				Assert.fail("Not Expanded Leave and Muster Records");
			}
	}
		
		
	
	
}