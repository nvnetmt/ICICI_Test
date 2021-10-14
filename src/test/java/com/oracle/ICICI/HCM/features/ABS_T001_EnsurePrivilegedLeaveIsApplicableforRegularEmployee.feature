#####################################################
#Script Name: T001_EnsurePrivilegedLeaveIsApplicableforRegularEmployee
#Description/Action: Apply Privilege Leave by Employee
#Manual Test Case used: T001 - Ensure Privileged leave is applicable for Regular employee who is confirmed
#Track/Module: Absence
#Regions to be executed:
#Developed By: OFS
#Date Created: 15-06-2021
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

  @T001
  Scenario:T001_EnsurePrivilegedLeaveIsApplicableforRegularEmployee
    #Databank parameters "DataBankSheetName", "RowNum"
    Then Input Data bank "T001","1"
    Given User logs into application "Username","Password"
    When Click on Home button
    Then Navigate to Leave and Muster Page
    And Click on Apply Leave and Muster
    Then Select Leave Type from list of Values "LeaveType"
    And Enter Start and End Date duration "StartDate","EndDate"
    Then Select Reason "LeaveReason"
    And Click on Submit button

