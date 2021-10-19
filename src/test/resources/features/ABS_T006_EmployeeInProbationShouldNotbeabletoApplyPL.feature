#####################################################
#Script Name: T006_EmployeeInProbationShouldNotBeabletoapplyPL
#Description/Action: Confirmed/Regular Employee should get Error message when he/she trying to apply PL and balance is  0			
#Manual Test Case used: Probated Employee should get Error message when he/she trying to apply PL and balance is  0			
#Track/Module: Absence
#Regions to be executed:
#Developed By: OFS
#Date Created: 05-07-2021
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

  @T005
  Scenario:T006_EmployeeInProbationShouldNotBeabletoapplyPL
    #Databank parameters "DataBankSheetName", "RowNum"
    Then Input Data bank "T006","1"
    Given User logs into application "Username","Password"
    When Click on Home button
    Then Navigate to Leave and Muster Page
    And Click on Apply Leave and Muster
    Then Select Leave Type from list of Values "LeaveType"
    And Enter Start and End Date duration "StartDate","EndDate"
    Then Select Reason "Reason"
    And Click on Submit button

