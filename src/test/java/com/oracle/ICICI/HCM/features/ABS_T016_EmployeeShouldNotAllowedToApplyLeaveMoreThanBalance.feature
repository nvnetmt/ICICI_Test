#####################################################
#Script Name: T016_EmployeeShouldNotAllowedToApplyLeaveMoreThanBalance
#Description/Action: Employee should not be allowed to apply leave more than his balance
#Manual Test Case used: T016 - Employee should not be allowed to apply leave more than his balance
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

  @T016
  Scenario:T016_EmployeeShouldNotAllowedToApplyLeaveMoreThanBalance
    #Databank parameters "DataBankSheetName", "RowNum"
    Then Input Data bank "T016","1"
    Given User logs into application "Username","Password"
    When Click on Home button
    Then Navigate to Leave and Muster Page
    And Click on Apply Leave and Muster
    Then Select Leave Type from list of Values "LeaveType"
    And Enter Start and End Date duration "StartDate","EndDate"
    Then Select Reason "LeaveReason"
    And Click on Submit button
    Then Verify the Error Message "ErrorMsg"

