#####################################################
#Script Name: ABS_T009_EmployeeShouldNotAllowToApplyMedicalLeaveAndAnnualLeaveInSameDayAndTime(LDG-Singapore)
#Description/Action: Medical leave and annual leave should not over lap with any other leave types(LDG-Singapore)
#Manual Test Case used: T009 - Employee should not allow to apply medical leave and annual leave in same day and time(LDG-Singapore)
#Track/Module: Absence
#Regions to be executed:
#Developed By: OFS
#Date Created: 29-07-2021
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

 @T009
  Scenario:T009_EmployeeShouldNotAllowToApplyMedicalLeave(LDG-Singapore)
    #Databank parameters "DataBankSheetName", "RowNum"
    Then Input Data bank "T009","1"
    Given User logs into application "Username","Password"
    When Click on Home button
    Then Navigate to Leave and Muster Page
    And Click on Apply Leave and Muster
    Then Select Leave Type from list of Values "LeaveType"
    And Enter Start and End Date Time duration "StartDateTime","EndDateTime"
    And Click on Submit button
   
  @T009 
  Scenario:T009_EmployeeShouldNotAllowToApplyAnnualLeaveInSameDayAndTime(LDG-Singapore)
    #Databank parameters "DataBankSheetName", "RowNum"
    Then Input Data bank "T009","2"
    Given User logs into application "Username","Password"
    When Click on Home button
    Then Navigate to Leave and Muster Page
    And Click on Apply Leave and Muster
    Then Select Leave Type from list of Values "LeaveType"
    And Enter Start and End Date Time duration "StartDateTime","EndDateTime"
    Then Upload the Attachment "PathOfFile"
    And Click on Save button
    Then Verify the Error Message "ErrorMsg"
   
 
	
    
