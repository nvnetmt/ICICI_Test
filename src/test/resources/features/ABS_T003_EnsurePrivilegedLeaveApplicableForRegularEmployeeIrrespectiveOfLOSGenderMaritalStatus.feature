#####################################################
#Script Name: T003_EnsurePrivilegedLeaveApplicableForRegularEmployeeIrrespectiveOfLOSGenderMaritalStatus
#Description/Action: Apply Privilege Leave by Employee
#Manual Test Case used: T003 - Ensure Privileged leave is applicable for Regular employee who is confirmed irrespective of LOS , Gender and marital status 
#Track/Module: Absence
#Regions to be executed:
#Developed By: OFS
#Date Created: 19-07-2021
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

  @T003
  Scenario:T003_EnsurePrivilegedLeaveApplicableForRegularEmployeeIrrespectiveOfGenderMaritalStatus
    #Databank parameters "DataBankSheetName", "RowNum"
    Then Input Data bank "T003","1"
    Given User logs into application "Username","Password"
    When Click on Home button
    Then Navigate to Leave and Muster Page
    And Click on Apply Leave and Muster
    Then Select Leave Type from list of Values "LeaveType"
    And Enter Start and End Date duration "StartDate","EndDate"
    Then Select Reason "LeaveReason"
    And Click on Submit button
    
    
