#####################################################
#Script Name: T007_EmployeesShouldNotApplyCasualLeaveMoreThanFourDays
#Description/Action: Employees should not apply casual leave more than 4 Days if any holiday and weekoff's in between also
#Manual Test Case used: T007 - Employees should not apply casual leave more than 4 Days
#Track/Module: Absence
#Regions to be executed:
#Developed By: OFS
#Date Created: 20-07-2021
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

  @T007
  Scenario:T007_EmployeesShouldNotApplyCasualLeaveforFourDays
    #Databank parameters "DataBankSheetName", "RowNum"
    Then Input Data bank "T007","1"
    Given User logs into application "Username","Password"
    When Click on Home button
    Then Navigate to Leave and Muster Page
    And Click on Apply Leave and Muster
    Then Select Leave Type from list of Values "LeaveType"
    And Enter Start and End Date duration "StartDate","EndDate"
    And Click on Submit button
    
    @T007
  Scenario:T007_EmployeesShouldNotApplyCasualLeaveMoreThanFourDays
    #Databank parameters "DataBankSheetName", "RowNum"
    Then Input Data bank "T007","2"
    Given User logs into application "Username","Password"
    When Click on Home button
    Then Navigate to Leave and Muster Page
    And Click on Apply Leave and Muster
    Then Select Leave Type from list of Values "LeaveType"
    And Enter Start and End Date duration "StartDate","EndDate"
    And Click on Submit button and Verify the Error Message
    
    