#####################################################
#Script Name: ABS_T017_SubmitCCL
#Description/Action: Submit a CCL
#Manual Test Case used: T017 - Submit a CCL
#Track/Module: Absence
#Regions to be executed:
#Developed By: OFS
#Date Created: 28-07-2021
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

 @T017
  Scenario:T017_SubmitCCL
    #Databank parameters "DataBankSheetName", "RowNum"
    Then Input Data bank "T017","1"
    Given User logs into application "Username","Password"
    When Click on Home button
    Then Navigate to Leave and Muster Page
    And Click on Apply Leave and Muster
    Then Select Leave Type from list of Values "LeaveType"
    And Enter Start and End Date duration "StartDate","EndDate"
    Then Select Child Name "ChildName"
    Then Enter Comments and Reason "LeaveComment"
    And Click on Submit button
    Then Click on Existing Leave and Muster
    And Verify the Status of Submitted Leave Request "LeaveType","StartDate","EndDate","SubmittedLeaveStatus"
 
	
    
