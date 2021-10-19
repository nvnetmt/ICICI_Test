#####################################################
#Script Name: T020_EnsureCasualLeaveIsApplicableForRegularEmployeeWhoIsConfirmedIrrespectiveOfLOSGenderMaritalStatus
#Description/Action: Ensure Casual leave is applicable for Regular Employee who is confirmed irrespective of LOS , Gender and marital status
#Manual Test Case used: T020 - Ensure Casual leave is applicable for Regular Employee who is confirmed irrespective of LOS , Gender and marital status 
#Track/Module: Absence
#Regions to be executed:
#Developed By: OFS
#Date Created: 21-07-2021
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

  @T020
  Scenario:T020_EnsureCasualLeaveIsApplicableForRegularEmployeeWhoIsConfirmedIrrespectiveOfGender
    #Databank parameters "DataBankSheetName", "RowNum"
    Then Input Data bank "T020","1"
    Given User logs into application "Username","Password"
    When Click on Home button
    Then Navigate to Leave and Muster Page
    And Click on Apply Leave and Muster
    Then Select Leave Type from list of Values "LeaveType"
    And Enter Start and End Date duration "StartDate","EndDate"
    Then Enter Comments and Reason "LeaveComment"
    And Click on Submit button
    
   @T020
   Scenario:T020_EnsureCasualLeaveIsApplicableForRegularEmployeeWhoIsConfirmedIrrespectiveOfMaritalStatus
		#Databank parameters "DataBankSheetName", "RowNum"
    Then Input Data bank "T020","2"
    Given User logs into application "Username","Password"
    When Click on Home button
    Then Navigate to Leave and Muster Page
    And Click on Apply Leave and Muster
    Then Select Leave Type from list of Values "LeaveType"
    And Enter Start and End Date duration "StartDate","EndDate"
    Then Enter Comments and Reason "LeaveComment"
    And Click on Submit button
