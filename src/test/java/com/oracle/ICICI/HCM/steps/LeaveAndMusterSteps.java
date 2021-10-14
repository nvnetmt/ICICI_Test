package com.oracle.ICICI.HCM.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.oracle.ICICI.HCM.pages.LeaveAndMusterPage;
import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.ICICI.common.steps.DatabankInitialization;
import com.oracle.ICICI.common.steps.ReportingSteps;

import io.cucumber.java.en.Then;
import com.oracle.acs.util.report.ReportGeneration;
import com.oracle.acs.util.ExcelOperations;



public class LeaveAndMusterSteps {
	
	public static ReportGeneration rpt = ReportingSteps.getRpt();
	Common_Library cmnLib = ReportingSteps.cmnLib;
	
	ExcelOperations exl = DatabankInitialization.exl;
	private String strDataSheetName = DatabankInitialization.strDataSheetName;
	private int DataRow = DatabankInitialization.DataRow;
	
	LeaveAndMusterPage LMPage=new LeaveAndMusterPage();
	
	
	@Then("^Click on Apply Leave and Muster$")
	public void click_on_Apply_Leave_and_Muster() throws Throwable {
		
		rpt.enterStepHeader("Click on Apply Leave and Muster");
		
		if(cmnLib.waitForElementToBeVisible(LMPage.btnApplyLeaveAndMuster)&&!cmnLib.clickOnWebElement(LMPage.btnApplyLeaveAndMuster) && cmnLib
				.waitForElementToBeVisible(LMPage.hdrApplyLeaveAndMuster,30)) {
			rpt.generateReport("", "Click on Apply Leave and Muster", "", "",
					"Apply Leave and Muster page must be displayed",
					"Apply Leave and Muster page not displayed", "Failed", "", true);
			Assert.fail("Apply Leave and Muster page not displayed");
		} else {
			rpt.generateReport("", "Click on Apply Leave and Muster", "", "",
					"Apply Leave and Muster page must be displayed", "Apply Leave and Muster page displayed",
					"Passed", "", true);
		}
	}
	
	@Then("^Click on Existing Leave and Muster$")
	public void click_on_Existing_Leave_and_Muster() throws Throwable {
		
		TimeUnit.SECONDS.sleep(20);
		
		rpt.enterStepHeader("Click on Existing Leave and Muster");
		
		if(cmnLib.waitForElementToBeVisible(LMPage.btnExistingLeaveAndMuster,30)&&
				cmnLib.clickOnWebElement(LMPage.btnExistingLeaveAndMuster)){
			rpt.generateReport("", "Click on Existing Leave and Muster", "", "",
					"Existing Leave and Muster page must be displayed", "Existing Leave and Muster page displayed",
					"Passed", "", true);
		} else {
			rpt.generateReport("", "Click on Existing Leave and Muster", "", "",
					"Existing Leave and Muster page must be displayed",
					"Existing Leave and Muster page not displayed", "Failed", "", true);
			Assert.fail("Existing Leave and Muster page not displayed");
		}
		
	}
	
	
	@Then("^Click on Apply Leave and Muster from LM Adm page$")
	public void click_on_Apply_Leave_and_Muster_from_LM_Adm_page() throws Throwable {
		
		rpt.enterStepHeader("Click on Apply Leave and Muster");
		
		if(cmnLib.waitForElementToBeVisible(LMPage.btnApplyLeaveMusterAdm,30)&&
				cmnLib.clickOnWebElement(LMPage.btnApplyLeaveMusterAdm)){
			rpt.generateReport("", "Click on Apply Leave and Muster", "", "",
					"Apply Leave and Muster page must be displayed", "Apply Leave and Muster page displayed",
					"Passed", "", true);
		} else {
			rpt.generateReport("", "Click on Apply Leave and Muster", "", "",
					"Apply Leave and Muster page must be displayed",
					"Apply Leave and Muster page not displayed", "Failed", "", true);
			Assert.fail("Apply Leave and Muster page not displayed");
		}
	}
	
	@Then("^Search for Leave Type from list of Values \"([^\"]*)\"$")
	public void search_for_Leave_Type_from_list_of_Values(String leaveType) throws Throwable {
		
		rpt.enterStepHeader("Select Leave Type from list of Values");
		
		leaveType = exl.read(strDataSheetName, DataRow, "LeaveType");
		
		//Select Leave Type
		
		if(!LMPage.searchLeaveType(leaveType)) {
			rpt.generateReport("", "Leave Type present", "", leaveType, "Leave Type should be present", "Leave Type is not present", "Failed", "", true);
			Assert.fail("Leave Type not present");
		}
		else {
			rpt.generateReport("", "Leave Type present", "", leaveType, "Leave Type should be present",
				"Leave Type is present", "Passed", "", true);
		}
	}

	@Then("^Select Leave Type from list of Values \"([^\"]*)\"$")
	public void select_Leave_Type_from_list_of_Values(String leaveType) throws Throwable {
		
		rpt.enterStepHeader("Select Leave Type from list of Values");
		
		leaveType = exl.read(strDataSheetName, DataRow, "LeaveType");
		
		//Select Leave Type
		
		if(!LMPage.selectLeaveType(leaveType)) {
		rpt.generateReport("", "Select Leave Type", "", leaveType, "Leave Type should be selected", "Leave Type is not selected", "Failed", "", true);
		Assert.fail("Leave Type not selected");
		}
		else {
		rpt.generateReport("", "Select Leave Type", "", leaveType, "Leave Type must be selected",
				"Selected Leave Type", "Passed", "", true);
		}
	}
	
	@Then("^Select Leave Type from list of Values from LM adminstration \"([^\"]*)\"$")
	public void select_Leave_Type_from_list_of_Values_from_LM_adminstration(String leaveType) throws Throwable {
		
		rpt.enterStepHeader("Select Leave Type from list of Values from LM adminstration");
		
		leaveType = exl.read(strDataSheetName, DataRow, "LeaveType");
		
		//Select Leave Type
		
		if(!LMPage.selectLeaveTypeLMAdm(leaveType)) {
		rpt.generateReport("", "Select Leave Type", "", leaveType, "Leave Type should be selected", "Leave Type is not selected", "Failed", "", true);
		Assert.fail("Leave Type not selected");
		}
		else {
		rpt.generateReport("", "Select Leave Type", "", leaveType, "Leave Type must be selected",
				"Selected Leave Type", "Passed", "", true);
		}

	}

	@Then("^Enter Start and End Date duration \"([^\"]*)\",\"([^\"]*)\"$")
	public void enter_Start_and_End_Date_duration(String startDate, String endDate) throws Throwable {
		
		rpt.enterStepHeader("Enter Start and End Date duration");
		
		// Start Date
				
		startDate = exl.read(strDataSheetName, DataRow, "startDate");
		if (cmnLib.enterDataInTextBox(LMPage.StartDate, startDate, true)) {
			rpt.generateReport("", "Select Start date", "", startDate, "Start date must be entered", "Selected Start date", "Passed", "",
					true);
		} else {
			rpt.generateReport("", "Select Start date", "", startDate, "Start date must be entered", "Start date not selected", "Failed",
					"", true);
			Assert.fail("Start date not selected");
		}

		// End Date
		
		endDate = exl.read(strDataSheetName, DataRow, "endDate");
		if (cmnLib.enterDataInTextBox(LMPage.EndDate, endDate, true)) {
			rpt.generateReport("", "Select End Date", "", endDate, "End Date must be entered",
					"Selected End Date", "Passed", "", true);
		} else {
			rpt.generateReport("", "Select End Date", "", endDate, "End Date must be entered",
					"End Date not selected", "Failed", "", true);
			Assert.fail("End Date not selected");
		}
	   
	}
	
	@Then("^Enter Start and End Date Time duration \"([^\"]*)\",\"([^\"]*)\"$")
	public void enter_Start_and_End_Date_Time_duration(String StartDateTime, String EndDateTime) throws Throwable {
		
		rpt.enterStepHeader("Enter Start and End Date Time duration");
		
		// Start Date And Time
				
		StartDateTime = exl.read(strDataSheetName, DataRow, "StartDateTime");
		if (cmnLib.enterDataInTextBox(LMPage.StartDateAndTime, StartDateTime, true)) {
			rpt.generateReport("", "Select Start date and Time", "", StartDateTime, "Start date and Time must be entered", "Selected Start date", "Passed", "",
					true);
		} else {
			rpt.generateReport("", "Select Start date and Time", "", StartDateTime, "Start date and Time must be entered", "Start date and Time not selected", "Failed",
					"", true);
			Assert.fail("Start date and Time not selected");
		}

		// End Date And Time
		
		EndDateTime = exl.read(strDataSheetName, DataRow, "EndDateTime");
		if (cmnLib.enterDataInTextBox(LMPage.EndDateAndTime, EndDateTime, true)) {
			rpt.generateReport("", "Select End Date and Time", "", EndDateTime, "End Date and Time must be entered",
					"Selected End Date and Time", "Passed", "", true);
		} else {
			rpt.generateReport("", "Select End Date and Time", "", EndDateTime, "End Date and Time be entered",
					"End Date and Time not selected", "Failed", "", true);
			Assert.fail("End Date and Time not selected");
		}
	   
	}
	
	@Then("^Enter Start and End Date duration on LM Adm page \"([^\"]*)\",\"([^\"]*)\"$")
	public void enter_Start_and_End_Date_duration_on_LM_Adm_page(String startDate, String endDate) throws Throwable {
		
		rpt.enterStepHeader("Enter Start and End Date duration on LM Adm page");
		
		// Start Date
				
		startDate = exl.read(strDataSheetName, DataRow, "startDate");
		if (cmnLib.enterDataInTextBox(LMPage.StartDateLeaveMusterAdm, startDate, true)) {
			rpt.generateReport("", "Select Start date", "", startDate, "Start date must be entered", "Selected Start date", "Passed", "",
					true);
		} else {
			rpt.generateReport("", "Select Start date", "", startDate, "Start date must be entered", "Start date not selected", "Failed",
					"", true);
			Assert.fail("Start date not selected");
		}

		// End Date
		
		endDate = exl.read(strDataSheetName, DataRow, "endDate");
		if (cmnLib.enterDataInTextBox(LMPage.EndDateLeaveMusterAdm, endDate, true)) {
			rpt.generateReport("", "Select End Date", "", endDate, "End Date must be entered",
					"Selected End Date", "Passed", "", true);
		} else {
			rpt.generateReport("", "Select End Date", "", endDate, "End Date must be entered",
					"End Date not selected", "Failed", "", true);
			Assert.fail("End Date not selected");
		}
	   
	}

	@Then("^Select Reason \"([^\"]*)\"$")
	public void select_Reason(String leaveReason) throws Throwable {
		
        rpt.enterStepHeader("Select Leave Reason from list of Values");
		
		leaveReason = exl.read(strDataSheetName, DataRow, "LeaveReason");
		
		//Select Leave Reason
		
		if(!LMPage.selectLeaveReason(leaveReason)) {
		rpt.generateReport("", "Select Leave Reason", "", leaveReason, "Leave Reason should be selected", "Leave Reason is not selected", "Failed", "", true);
		Assert.fail("Leave Reason not selected");
		}
		
		rpt.generateReport("", "Select Leave Reason", "", leaveReason, "Leave Reason must be selected",
				"Selected Leave Reason", "Passed", "", true);
	}
	
	@Then("^Select Start Date Duration \"([^\"]*)\"$")
	public void select_Start_Date_Duration(String LeaveStartDateDuration) throws Throwable {
		
		rpt.enterStepHeader("Select Start Date Duration");
		
		LeaveStartDateDuration = exl.read(strDataSheetName, DataRow, "LeaveStartDateDuration");
		
		// Select Start date duration
		
		if(LMPage.selectLeaveDuration(LeaveStartDateDuration)) {
			rpt.generateReport("", "Select Leave Duration", "", "Leave Duration: " + LeaveStartDateDuration, "Leave Duration must be selected",
			"Leave Duration selected", "Passed", "", true);
			}
		
		else {
			rpt.generateReport("", "Select Leave Duration", "", "Leave Duration: " + LeaveStartDateDuration,
					"Leave Duration must be selected ", "Leave Duration not selected", "Failed", "", true);
			Assert.fail("Not Selected Leave Duration");
		}
	}
	
	@Then("^Select Child Name \"([^\"]*)\"$")
	public void select_Child_Name(String ChildName) throws Throwable {
		
		rpt.enterStepHeader("Select Start Date Duration");
		
		ChildName = exl.read(strDataSheetName, DataRow, "ChildName");
		
		// Select Start date duration
		
		if(LMPage.selectChildName(ChildName)) {
			rpt.generateReport("", "Select Child Name", "", "Child Name: " + ChildName, "Child Name must be selected",
			"Child Name selected", "Passed", "", true);
			}
		
		else {
			rpt.generateReport("", "Select Child Name", "", "Child Name: " + ChildName,
					"Child Name must be selected ", "Child Name not selected", "Failed", "", true);
			Assert.fail("Not Selected Child Name");
		}
	}
	
	@Then("^Verify the duration of the leaves$")
	public void verify_the_duration_of_the_leaves() throws Throwable {
		
		rpt.enterStepHeader("Verify the duration of the leaves");
		
		String LeaveDur=(LMPage.LeaveDuration).getText();
		int LeaveDuration=Double.valueOf(LeaveDur).intValue();
		System.out.println(LeaveDuration);
		
		if(LeaveDuration>0)
		{
			rpt.generateReport("", "Duration of Leave is greater than 0", "", LeaveDur, "Duration of Leave should be greater than 0",
					"Duration of Leave is greater than 0", "Passed", "", true);
		} else {
			rpt.generateReport("", "Duration of Leave is greater than 0", "", LeaveDur, "Duration of Leave should be greater than 0",
					"Duration of Leave is not greater than 0", "Failed", "", true);
			Assert.fail("Duration of Leave is not greater than 0");
		}  
	}
	
	@Then("^Verify the duration of the leaves \"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_duration_of_the_leaves(String StartDateTime, String EndDateTime) throws Throwable {
		
		rpt.enterStepHeader("Verify the duration of the leaves");
		
		StartDateTime = exl.read(strDataSheetName, DataRow, "StartDateTime");
		EndDateTime = exl.read(strDataSheetName, DataRow, "EndDateTime");
		
		Long durOfLeave=cmnLib.differenceBetweenDays(StartDateTime,EndDateTime);
		int durationOfLeave=Math.toIntExact(durOfLeave); 
		System.out.println(durationOfLeave);
		
		String LeaveDur=(LMPage.LeaveDuration).getText();
		int LeaveDuration=Double.valueOf(LeaveDur).intValue();
		System.out.println(LeaveDuration);
		
		if((LeaveDuration==durationOfLeave)&&(LeaveDuration>0))
		{
			rpt.generateReport("", "Duration of Leave is greater than 0", "", LeaveDur, "Duration of Leave should be greater than 0",
					"Duration of Leave is greater than 0", "Passed", "", true);
		} else {
			rpt.generateReport("", "Duration of Leave is greater than 0", "", LeaveDur, "Duration of Leave should be greater than 0",
					"Duration of Leave is not greater than 0", "Failed", "", true);
			Assert.fail("Duration of Leave is not greater than 0");
		}  
	}
	
	@Then("^Enter Comments and Reason \"([^\"]*)\"$")
	public void enter_Comments_and_Reason(String LeaveComment) throws Throwable {
		
		rpt.enterStepHeader("Enter Comments and Reason");
		
		LeaveComment = exl.read(strDataSheetName, DataRow, "LeaveComment");
		
		// leave comments
		
		if (cmnLib.waitForElementToBeVisible(LMPage.LeaveComment,30)&&
				cmnLib.enterDataInTextBox(LMPage.LeaveComment,LeaveComment, true)) {
			rpt.generateReport("", "Enter Comment or Reason", "", "Comment or Reason:" + LeaveComment,
					"Comment or Reason must be Entered ", "Entered Comment or Reason ", "Passed", "", true);
		} else {
			rpt.generateReport("", "Enter Comment or Reason", "", "Comment or Reason: " + LeaveComment,
					"Comment or Reason must be Entered ", "Not Entered Comment or Reason ", "Failed", "", true);
			Assert.fail("Not Entered Comment or Reason");
		}
	}
	
	@Then("^Upload the Attachment \"([^\"]*)\"$")
	public void upload_the_Attachment(String PathOfFile) throws Throwable {
		
		rpt.enterStepHeader("Upload the Attachment");
		
		PathOfFile = exl.read(strDataSheetName, DataRow, "PathOfFile");
		
		TimeUnit.SECONDS.sleep(60);
		
		if (cmnLib.waitForElementToBeVisible(LMPage.lnkAddAttachment,60) && cmnLib.clickOnWebElement(LMPage.lnkAddAttachment)){
			rpt.generateReport("", "Click to add attachment", "", "", "Add attachment should be clicked",
					"Clicked to Add attachment", "Passed", "", true);
		}
		else {
			rpt.generateReport("", "Click to add attachment", "", "", "Add attachment should be clicked",
					"Not Clicked to Add attachment", "Failed", "", true);
			Assert.fail("Failed to click Add attachment");
		}	
		
		if (cmnLib.waitForElementToBeVisible(LMPage.lnkAddFile,30)){
	
			rpt.generateReport("", "Add File link", "", "", "Add File link should be visible",
					"Add File link is visible", "Passed", "", true);
		
			if(cmnLib.clickOnWebElement(LMPage.lnkAddFile)) {
				
				rpt.generateReport("", "Click Add File", "", "", "Add File should be clicked",
						"Clicked on Add File", "Passed", "", true);
			
				if(cmnLib.uploadFile(PathOfFile)) {
					rpt.generateReport("", "Add the attachment", "", "", "Attachment should be added",
					"Added the attachment", "Passed", "", true);
				}
				else {
					rpt.generateReport("", "Add the attachment", "", "", "Attachment should be added",
					"Not Added the attachment", "Failed", "", true);
					Assert.fail("Failed to Add attachment");
				}
			}
			else {
				rpt.generateReport("", "Click Add File", "", "", "Add File should be clicked",
						"Not Clicked on Add File", "Failed", "", true);
						Assert.fail("Failed to Click Add File");
			}
		}
		else {
			rpt.generateReport("", "Add File link", "", "", "Add File link should be visible",
					"Add File link is not visible", "Failed", "", true);
					Assert.fail("Add File link is not visible");
		}
		
	}
	
	
	@Then("^Click on Submit button$")
	public void click_on_Submit_button() throws Throwable {
		
		rpt.enterStepHeader("Click on Submit button");
		
		if (!cmnLib.clickOnWebElement(LMPage.btnSubmit) && cmnLib
				.waitForElementToBeVisible(LMPage.hdrLeaveAndMuster)) {
			rpt.generateReport("", "Click on Submit button", "", "",
					"Leave must be submitted.",
					"Leave is not submitted.", "Failed", "", true);
			Assert.fail("Leave is not submitted.");
		} else {
			rpt.generateReport("", "Click on Submit button", "", "",
					"Leave must be submitted", "Leave is submitted",
					"Passed", "", true);
		}
		
	}
	

	@Then("^Click on Save button$")
	public void click_on_Save_button() throws Throwable {
		
		rpt.enterStepHeader("Click on Save button");
		
		if (cmnLib.clickOnWebElement(LMPage.btnSave) || cmnLib
				.clickOnWebElement(LMPage.btnSaveAndClose)) {
			rpt.generateReport("", "Click on Save button", "", "",
					"Leave must be saved.",
					"Leave is saved.", "Passed", "", true);
		} else {
			rpt.generateReport("", "Click on Save button", "", "",
					"Leave must be saved", "Leave is not saved",
					"Failed", "", true);
			Assert.fail("Leave is not saved.");
		}
		
	}
	
	@Then("^Accepting the Warning \"([^\"]*)\"$")
	public void accepting_the_Warning(String WrningMsg) throws Throwable {
		
		rpt.enterStepHeader("Accepting the Warning");
		
		WrningMsg = exl.read(strDataSheetName, DataRow, "WrningMsg");
		
		String WarningMessage = null;
		
		if (cmnLib.waitForElementToBeVisible(LMPage.MsgWarning,60)) 
		{
			WarningMessage = LMPage.MsgWarning.getText();
			
			if (WarningMessage.equals(WrningMsg)) {
				
				rpt.generateReport("", "Warning message matches", "", "", "Warning message should be matched",
						"Warning message matched", "Passed", "", true);
				
				if (cmnLib.clickOnWebElement(LMPage.btnYesWarningMsgLeaveMusterAdm)){
					rpt.generateReport("", "Accept the warning", "", "", "Yes Button on Warning message should be clicked",
							"Accepted the warning", "Passed", "", true);
				}
				else {
					rpt.generateReport("", "Accept the warning", "", "", "Yes Button on Warning message should be clicked",
							"Not Accept the warning", "Failed", "", true);
					Assert.fail("Failed to Click on Yes Button");
				}	
			}
			
			else {
				rpt.generateReport("", "Warning message matches", "", "", "Warning message should be matched",
						"Warning message not matched", "Failed", "", true);
				Assert.fail("Warning message not matched");
			}
			
		}
	}
	
	
	@Then("^Verify system allows admin to apply leave and Click OK$")
	public void verify_system_allows_admin_to_apply_leave_and_Click_OK() throws Throwable {
		
		rpt.enterStepHeader("Verify system allows admin to apply leave and Click OK");
		
		if (cmnLib.waitForElementToBeVisible(LMPage.SumittedMsgLeaveMusterAdm)) {
			rpt.generateReport("", "Verify Leave submitted message", "", "",
					"The request submitted message must be displayed",
					"The request submitted message is displayed", "Passed", "", true);
		} else {
			rpt.generateReport("", "Verify Leave submitted message", "", "",
					"The request submitted message must be displayed",
					"The request submitted message is not displayed", "Failed", "", true);
			Assert.fail("The request submitted message is not displayed");
		}

		if (cmnLib.clickOnWebElement(LMPage.btnOkConfirmationLeaveMusterAdm)){
			rpt.generateReport("", "Click OK on confirmation popup window", "", "",
					"OK button must be clicked and the request submitted message window must be closed",
					"Clicked on OK button and the request submitted message window is closed", "Passed", "", true);
		} else {
			rpt.generateReport("", "Click OK on confirmation popup window", "", "",
					"OK button must be clicked and the request submitted message window must be closed",
					"Either not clicked on OK button or the request submitted message window is not closed", "Failed",
					"", true);
			Assert.fail("Either not Click OK on confirmation popup window or the request submitted message window is not closed");
		}
		
	}
	
	@Then("^Click on Submit button and Verify the Error Message$")
	public void click_on_Submit_button_and_Verify_the_Error_Message() throws Throwable {
		
		 rpt.enterStepHeader("Click on Submit button and Verify the Error Message");
		
		
	
	    
	}

	@Then("^Verify the Error Message \"([^\"]*)\"$")
	public void verify_the_Error_Message(String ErrorMsg) throws Throwable {
		
		 rpt.enterStepHeader("Verify the Error Message");
		 
		 String ErrorMessage=null;
		 
		 TimeUnit.SECONDS.sleep(60);
		 
		 ErrorMsg = exl.read(strDataSheetName, DataRow, "ErrorMsg");
	
		 WebElement ErrMsg = cmnLib
					.getElement(By.xpath("//*[contains(@id,'errHm:dc_pgl91')]"));
		 
		 if (cmnLib.waitForElementToBeVisible(ErrMsg,20)) {
			 
			 ErrorMessage=ErrMsg.getText();
			 
			 if (ErrorMessage.equals(ErrorMsg.trim())) {
				 
				 rpt.generateReport("", "Error Message displays", "", "",
							"Error message must be displayed",
							"Expected Error Messgae is displayed", "Passed", "", true);
				} else {
					rpt.generateReport("", "Error Message displays", "", "",
							"Error message must be displayed",
							"Expected Error Messgae is not displayed", "Failed",
							"", true);
					Assert.fail("Expected Error Messgae is not displayed");
				}
			
			}
	}

	@Then("^Select the Saved leave request \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void select_the_Saved_leave_request(String LeaveType,String StartDate,String EndDate,String LeaveStatus) throws Throwable {
		
		 rpt.enterStepHeader("Select the Saved leave request");
		 
		 
		 TimeUnit.SECONDS.sleep(20);
		 
		 LeaveType = exl.read(strDataSheetName, DataRow, "LeaveType");
		 StartDate = exl.read(strDataSheetName, DataRow, "StartDate");
		 EndDate = exl.read(strDataSheetName, DataRow, "EndDate");
		 LeaveStatus = exl.read(strDataSheetName, DataRow, "LeaveStatus");
		 String LeaveDates= ""+StartDate+"  -  "+EndDate+"";
		 
		 if (cmnLib.waitForElementToBeVisible(LMPage.searchLeaveTypeStatus,30) &&
					cmnLib.enterDataInTextBox(LMPage.searchLeaveTypeStatus,LeaveStatus, true) && 
					cmnLib.clickOnWebElement(LMPage.searchLeaveTypeStatusIcon))
		 {		
				rpt.generateReport("", "Search by Leave Type or Status", "", "",
						"Search by Leave Type or Status ", "Searched by Leave Type or Status ", "Passed", "", true);
		 } else 
		 {
				rpt.generateReport("", "Search by Leave Type or Status", "", "",
						"Search by Leave Type or Status", "Not Searched by Leave Type or Status ", "Failed", "", true);
				Assert.fail("Not Searched by Leave Type or Status");
		 }
		 
		 for(int i=0;i<=10;i++){	
			 
			 TimeUnit.SECONDS.sleep(20);
			 WebElement savedRequest = cmnLib
					.getElement(By.xpath("//*[contains(@id,'"+i+":hisPse:rootPgl')]"));
			 /*WebElement LeaveStatus=cmnLib
					.getElement(By.xpath("//*[contains(@id,'"+i+":hisPse:statPgl')]"));*/
			 WebElement btnEdit=cmnLib
					.getElement(By.xpath("//*[contains(@id,'"+i+":hisPse:penCil::icon')]"));
			
			 TimeUnit.SECONDS.sleep(60);
			
				if (cmnLib.waitForElementToBeVisible(savedRequest,40)) 
				{
					rpt.generateReport("", "Saved Leave Request is present", "", "", "Saved Leave Request should be there",
							"Saved Leave Request is there", "Passed", "", true);
					
					String SavedRequestDetails = savedRequest.getText();
					String[] request=SavedRequestDetails.split("Days",2);
					String[] request1=request[0].split(":",2);
					String[] request2=request[1].split("ICICI",2);
					String LeaveTypeReq=request1[0];
					String LveDateRequest=request[1];
					String LveDateRequest1=request2[0];
					
					if(LeaveType.equals(LeaveTypeReq.trim()) && (LeaveDates.equals(LveDateRequest.trim()) || LeaveDates.equals(LveDateRequest1.trim()))) {
						
						rpt.generateReport("", "Saved Leave Request matches", "", "", "Saved Leave Request should be matched",
								"Saved Leave Request is matched", "Passed", "", true);
							
						if(cmnLib.waitForElementToBeVisible(btnEdit,20)) 
						{
							if(cmnLib.clickOnWebElement(btnEdit)) {
								rpt.generateReport("", "Click on Edit Button", "", "", "Edit Button should be clicked",
									"Clicked on Edit Button", "Passed", "", true);
								break;
							}
							else
							{
								rpt.generateReport("", "Click on Edit Button", "", "", "Edit Button should be clicked",
									"Not Clicked on Edit Button", "Failed", "", true);
							}
						}	
					}
					else 
					{
						rpt.generateReport("", "Saved Leave Request matches", "", "", "Saved Leave Request should be matched",
								"Saved Leave Request is not matched", "Failed", "", true);
					}
				}
				else {
					rpt.generateReport("", "Saved Leave Request is present", "", "", "Saved Leave Request should be there",
							"Saved Leave Request is not there", "Failed", "", true);
				}
			}
		
	}
	
	@Then("^Verify the Status of Submitted Leave Request \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_Status_of_Submitted_Leave_Request(String LeaveType,String StartDate,String EndDate,String SubmittedLeaveStatus) throws Throwable {
		
		 rpt.enterStepHeader("Verify the Status of Submitted Leave Request");
		 
		 
		 TimeUnit.SECONDS.sleep(40);
		 
		 LeaveType = exl.read(strDataSheetName, DataRow, "LeaveType");
		 StartDate = exl.read(strDataSheetName, DataRow, "StartDate");
		 EndDate = exl.read(strDataSheetName, DataRow, "EndDate");
		 SubmittedLeaveStatus = exl.read(strDataSheetName, DataRow, "SubmittedLeaveStatus");
		 String LeaveDates= ""+StartDate+"  -  "+EndDate+"";
		 System.out.println(LeaveDates);
		 
		 if (cmnLib.waitForElementToBeVisible(LMPage.searchLeaveTypeStatus,30) &&
					cmnLib.enterDataInTextBox(LMPage.searchLeaveTypeStatus,SubmittedLeaveStatus, true) && cmnLib.clickOnWebElement(LMPage.searchLeaveTypeStatusIcon))
		 {
			    
				rpt.generateReport("", "Search by Leave Type or Status", "", "",
						"Search by Leave Type or Status ", "Searched by Leave Type or Status ", "Passed", "", true);
		} else 
		{
				rpt.generateReport("", "Search by Leave Type or Status", "", "",
						"Search by Leave Type or Status", "Not Searched by Leave Type or Status ", "Failed", "", true);
				Assert.fail("Not Searched by Leave Type or Status");
		}
		 
		 TimeUnit.SECONDS.sleep(60);
		 
		 for(int i=0;i<=10;i++)
		 {	
			TimeUnit.SECONDS.sleep(20);
			WebElement SubmittedRequest = cmnLib
					.getElement(By.xpath("//*[contains(@id,'"+i+":hisPse:rootPgl')]"));
			/*WebElement LeaveStatus=cmnLib
					.getElement(By.xpath("//*[contains(@id,'"+i+":hisPse:statPgl')]"));*/
			
			System.out.println(SubmittedRequest);
			
				if (cmnLib.waitForElementToBeVisible(SubmittedRequest,40)) 
				{
					rpt.generateReport("", "Submitted Leave Request is present", "", "", "Submitted Leave Request should be there",
							"Submitted Leave Request is there", "Passed", "", true);
					
					TimeUnit.SECONDS.sleep(60);
				
					String SubmittedRequestDetails = SubmittedRequest.getText();
					System.out.println(SubmittedRequestDetails);
					String[] request=SubmittedRequestDetails.split("Days",2);
					String[] request1=request[0].split(":",2);
					String LeaveTypeReq=request1[0];
					String LeaveDateReq=request[1];
					System.out.println(LeaveTypeReq);
					System.out.println(LeaveDateReq);
					
					if(LeaveType.equals(LeaveTypeReq.trim()) && LeaveDates.equals(LeaveDateReq.trim())) {
						
						rpt.generateReport("", "Submitted Leave Request matches", "", "Leave Status:"+SubmittedLeaveStatus, "Submitted Leave Request should be matched",
								"Submitted Leave Request is matched", "Passed", "", true);
						
						break;
						
						
					}
					else {
						rpt.generateReport("", "Submitted Leave Request matches", "", "Leave Status:"+SubmittedLeaveStatus, "Submitted Leave Request should be matched",
								"Saved Leave Request is not matched", "Failed", "", true);
					}
				}
				else {
					rpt.generateReport("", "Submitted Leave Request is present", "", "", "Submitted Leave Request should be there",
							"Submitted Leave Request is not there", "Failed", "", true);
				}
			}
		}
	
	@Then("^Verify Whether Submitted Leave Request got Approved \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void Verify_Whether_Submitted_Leave_Request_got_Approved(String LeaveType,String StartDate,String EndDate) throws Throwable {
		
		 rpt.enterStepHeader("Verify Whether Submitted Leave Request got Approved");
		 
		 TimeUnit.SECONDS.sleep(40);
		 
		 LeaveType = exl.read(strDataSheetName, DataRow, "LeaveType");
		 StartDate = exl.read(strDataSheetName, DataRow, "StartDate");
		 EndDate = exl.read(strDataSheetName, DataRow, "EndDate");
		 String LeaveDates= ""+StartDate+"  -  "+EndDate+"";
		 System.out.println(LeaveDates);
		 
		 String SubmittedLeaveStatus=cmnLib.CompareDates(EndDate);
		 
		 if (cmnLib.waitForElementToBeVisible(LMPage.searchLeaveTypeStatus,30) &&
					cmnLib.enterDataInTextBox(LMPage.searchLeaveTypeStatus,SubmittedLeaveStatus, true) && cmnLib.clickOnWebElement(LMPage.searchLeaveTypeStatusIcon))
		 {
			    
				rpt.generateReport("", "Search by Leave Status", "", "",
						"Search by Leave Status ", "Searched by Leave Status ", "Passed", "", true);
		} else 
		{
				rpt.generateReport("", "Search by Leave Status", "", "",
						"Search by Leave Status", "Not Searched by Leave Status ", "Failed", "", true);
				Assert.fail("Not Searched by Leave Status");
		}
		 
		 TimeUnit.SECONDS.sleep(60);
		 
		 for(int i=0;i<=30;i++)
		 {	
			TimeUnit.SECONDS.sleep(20);
			WebElement SubmittedRequest = cmnLib
					.getElement(By.xpath("//*[contains(@id,'"+i+":hisPse:rootPgl')]"));
			//WebElement LeaveStatus=cmnLib
					//.getElement(By.xpath("//*[contains(@id,'"+i+":hisPse:statPgl')]"));
			
			System.out.println(SubmittedRequest);
			
				if (cmnLib.waitForElementToBeVisible(SubmittedRequest,40)) 
				{
					rpt.generateReport("", "Submitted Leave Request is present", "", "", "Submitted Leave Request should be there",
							"Submitted Leave Request is there", "Passed", "", true);
					
					TimeUnit.SECONDS.sleep(60);
				
					String SubmittedRequestDetails = SubmittedRequest.getText();
					System.out.println(SubmittedRequestDetails);
					String[] request=SubmittedRequestDetails.split("Days",2);
					String[] request1=request[0].split(":",2);
					String LeaveTypeReq=request1[0];
					String LeaveDateReq=request[1];
					System.out.println(LeaveTypeReq);
					System.out.println(LeaveDateReq);
					
					if(LeaveType.equals(LeaveTypeReq.trim()) && LeaveDates.equals(LeaveDateReq.trim())) {
						
						rpt.generateReport("", "Submitted Leave Request matches", "", "", "Submitted Leave Request should be matched",
								"Submitted Leave Request is matched", "Passed", "", true);
						break;
						
					}
					else {
						rpt.generateReport("", "Submitted Leave Request matches", "", "", "Submitted Leave Request should be matched",
								"Saved Leave Request is not matched", "Failed", "", true);
					}
				}
				else {
					rpt.generateReport("", "Submitted Leave Request is present", "", "", "Submitted Leave Request should be there",
							"Submitted Leave Request is not there", "Failed", "", true);
				}
			}
		}
	
}

