#####################################################
#Script Name: T010_EmployeeShouldAbleToApplyCasualLeaveOnFinancialYearEndDate(LDGIndia)
#Description/Action: Employee should able to apply Casual leave on financial year end date(LDG-India) 31-March
#Manual Test Case used: T010 - Employee should able to apply Casual leave on financial year end date(LDG-India)
#Track/Module: Absence
#Regions to be executed:
#Developed By: OFS
#Date Created: 22-07-2021
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

  @T010
  Scenario:T010_EmployeeShouldAbleToApplyCasualLeaveOnFinancialYearEndDate(LDGIndia)
    #Databank parameters "DataBankSheetName", "RowNum"
    Then Input Data bank "T010","1"
    Given User logs into application "Username","Password"
    When Click on Home button
    Then Navigate to Leave and Muster Page
    And Click on Apply Leave and Muster
    Then Select Leave Type from list of Values "LeaveType"
    And Enter Start and End Date duration "StartDate","EndDate"
    Then Enter Comments and Reason "LeaveComment"
    And Click on Submit button
