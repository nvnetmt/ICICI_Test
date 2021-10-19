#####################################################
#Script Name: ABS_T012_ApplyLeaveByEmployeeApproveByLineManager
#Description/Action: Apply a Leave by Employee and Approve by Line Manager
#Manual Test Case used: T012 - Leave & Muster Approval notifications
#Track/Module: Absence
#Regions to be executed:
#Developed By: OFS
#Date Created: 17-06-2021
#Date Last Updated:
#Script Location:
#Databank Used: Yes/No: No
#Data Bank location:
#Data Bank parameters:
#Feature File Name/s used:
#Unique Data Required or Not: Yes
#Pre-Requisites (if Any):
#Automated Script to be executed as pre-req(if any):
#Status Of script(Dev/Review/Complete): Dev
#Comments (if any):
#####################################################
Feature: Absence

  Background: 
    Given Setup Reporting for ICICI

 @T012
  Scenario:T012_ApplyLeaveByEmployee
    #Databank parameters "DataBankSheetName", "RowNum"
    Then Input Data bank "T012","1"
    Given User logs into application "Username","Password"
    When Click on Home button
    Then Navigate to Leave and Muster Page
    And Click on Apply Leave and Muster
    Then Select Leave Type from list of Values "LeaveType"
    And Enter Start and End Date duration "StartDate","EndDate"
    Then Select Start Date Duration "LeaveStartDateDuration"
    Then Select Reason "LeaveReason"
    And Click on Save button
    Then Click on Existing Leave and Muster
    And Select the Saved leave request "LeaveType","StartDate","EndDate","LeaveStatus"
    And Click on Submit button
 
	
  @T012
  Scenario:T012_ApproveLeaveByLineManager
  	#Databank parameters "DataBankSheetName", "RowNum"
    Then Input Data bank "T012","2"
    Given User logs into application "Username","Password"
    When Click on Home button
    And Click on Notification Bell icon
    And Select Relevant Notification of Employee Leave Request and approve "LeaveType","EmpName","EmpLeaveStartDate","EmpLeaveEndDate"
 
   
  
    
