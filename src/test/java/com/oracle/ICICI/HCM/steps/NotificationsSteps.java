package com.oracle.ICICI.HCM.steps;

import com.oracle.ICICI.HCM.pages.NotificationsPage;
import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.ICICI.common.pages.HomePage;
import com.oracle.ICICI.common.steps.DatabankInitialization;
import com.oracle.ICICI.common.steps.HomePageSteps;
import com.oracle.ICICI.common.steps.ReportingSteps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import com.oracle.acs.util.report.ReportGeneration;
import com.oracle.acs.util.ExcelOperations;

public class NotificationsSteps {
	public static ReportGeneration rpt = ReportingSteps.getRpt();
	Common_Library cmnLib = ReportingSteps.cmnLib;
	HomePage hmPage=new HomePage();
	HomePageSteps hmPageSteps=new HomePageSteps();
	NotificationsPage notificationsPg= new NotificationsPage();
	
	ExcelOperations exl = DatabankInitialization.exl;
	private String strDataSheetName = DatabankInitialization.strDataSheetName;
	private int DataRow = DatabankInitialization.DataRow;
	//ApplyLeaveAndMusterPage applyLeaveAndMusterPage=new ApplyLeaveAndMusterPage();
	
	@Then("^Click on Notification Bell icon$")
	public void click_on_Notification_Bell_icon() throws Throwable {
		
		rpt.enterStepHeader("Click on Notification Bell icon");
		
		if (cmnLib.waitForElementToBeVisible(notificationsPg.NotificationBellIcon,30)&& cmnLib.clickOnWebElement(notificationsPg.NotificationBellIcon)) {
				rpt.generateReport("", "Notification Bell icon", "", "", "Notification Bell should be clicked",
						"Clicked on Notification Bell icon", "Passed", "", true);
			}else {
				rpt.generateReport("", "Notification Bell", "", "", "Notification Bell should be clicked",
						"Could not click on Notification Bell icon ", "Failed", "", true);
				Assert.fail("Failed to Click on Notification Bell icon");
			}
		
		if (cmnLib.waitForElementToBeVisible(notificationsPg.lnkShowAllNotification,30)&& cmnLib.clickOnWebElement(notificationsPg.lnkShowAllNotification)) {
			rpt.generateReport("", "Show all notification", "", "", "Show all notification should be clicked",
					"Clicked on Show all notification", "Passed", "", true);
			}else {
			rpt.generateReport("", "Show all notification", "", "", "Show all notification should be clicked",
					"Could not click on Show all notification ", "Failed", "", true);
			Assert.fail("Failed to Click on Show all notification");
			}
		
		}
	
	@Then("^Select Relevant Notification of Employee Leave Request and approve \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void select_Relevant_Notification_of_Employee_Leave_Request_and_approve(String LeaveType,String EmpName,String EmpLeaveStartDate, String EmpLeaveEndDate ) 
			throws Throwable {
		
		rpt.enterStepHeader("Select Relevant Notification of Employee Leave Request and approve");
		
		if (cmnLib.waitForElementToBeVisible(notificationsPg.lnkAssignedToMe,30)&& cmnLib.clickOnWebElement(notificationsPg.lnkAssignedToMe)) {
			rpt.generateReport("", "Assigned To Me", "", "", "Assigned To Me should be clicked",
					"Clicked on Assigned To Me", "Passed", "", true);
			}else {
			rpt.generateReport("", "Assigned To Me", "", "", "Assigned To Me should be clicked",
					"Could not click on Assigned To Me ", "Failed", "", true);
			Assert.fail("Failed to Click on Assigned To Me");
			}
		
		
		LeaveType = exl.read(strDataSheetName, DataRow, "LeaveType");
		EmpName = exl.read(strDataSheetName, DataRow, "EmpName");
		EmpLeaveStartDate = exl.read(strDataSheetName, DataRow, "EmpLeaveStartDate");
		EmpLeaveEndDate = exl.read(strDataSheetName, DataRow, "EmpLeaveEndDate");
		
		String ReqNotifications = null;
		
		TimeUnit.SECONDS.sleep(20);
	
		String NotificationsDetails="Approval of "+LeaveType+" Absence Request for "+EmpName+" from "+EmpLeaveStartDate+" to "+EmpLeaveEndDate;
		
		System.out.println(NotificationsDetails);
		
		for(int i=0;i<=20;i++)
		{
			
		WebElement LeaveRequestDetail = cmnLib
				.getElement(By.xpath("//*[contains(@id,'lv4:"+i+":cl4')]"));
		
		WebElement ApproveButton=cmnLib
				.getElement(By.xpath("//*[contains(@id,'lv4:"+i+":cb2')]"));

		
			if (cmnLib.waitForElementToBeVisible(LeaveRequestDetail,20)) 
			{
				ReqNotifications = LeaveRequestDetail.getText();
				System.out.println(ReqNotifications);
				
				if (NotificationsDetails.equals(ReqNotifications.trim())) 
				{
					
					rpt.generateReport("", "Relevent Entry is there", "", "", "Relevant Entry should be there",
						"Could see Relevent Entry", "Passed", "", true);
					if (cmnLib.clickOnWebElement(ApproveButton))
					{
						rpt.generateReport("", "Approve Button", "", "", "Approve Button should be clicked",
								"Clicked on Approve Button", "Passed", "", true);
						break;
					}
					else {
						rpt.generateReport("", "Approve Button", "", "", "Approve Button should be clicked",
								"Could not click on Approve Button", "Failed", "", true);
						Assert.fail("Failed to Click on Approve Button");
					}
					
				}
				else {
					rpt.generateReport("", "Relevent Entry is there", "", "", "Relevent Entry should be selected",
						"Could not find on Relevent Entry ", "Failed", "", true);
					Assert.fail("No relevant");
				}
				
			}
		}
		
		
	}

	
	@Then("^Approve Leave$")
	public void approve_Leave() throws Throwable {
		
		rpt.enterStepHeader("Approve Leave");
		
		if (cmnLib.clickOnWebElement(notificationsPg.btnApproveLeave)) {
			rpt.generateReport("", "Approve Button", "", "", "Approve Button should be clicked",
					"Clicked on Approve Button", "Passed", "", true);
		}else {
			rpt.generateReport("", "Approve Button", "", "", "Approve Button should be clicked",
					"Could not click on Approve Button", "Failed", "", true);
			Assert.fail("Failed to Click on Approve Button");
			}
		}
			
	}

