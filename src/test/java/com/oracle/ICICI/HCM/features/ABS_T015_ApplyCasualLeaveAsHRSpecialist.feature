#####################################################
#Script Name: ABS_T015_ApplyCasualLeaveAsHRSpecialist
#Description/Action: Apply a Casual leave as HR specialist for more than 35 days
#Manual Test Case used: T015 - Apply a Casual leave as HR specialist 
#Track/Module: Absence
#Regions to be executed:
#Developed By: OFS
#Date Created: 16-07-2021
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

  @T015
  Scenario:T015_ApplyCasualLeaveAsHRSpecialist
  	#Databank parameters "DataBankSheetName", "RowNum"
    Then Input Data bank "T015","1"
    Given User logs into application "Username","Password"
    When Click on Home button
    Then Navigate To My Client Group Menus
    And Click on Person Management Menu
    Then Perform search for employee in Person Management page "PmEmployeeName","PmEmployeeId","PmNationalId","PmKeyWords"
    Then Navigate to Manage Leave and Muster Records Page
    Then Expand Leave and Muster Records
    And Click on Apply Leave and Muster from LM Adm page
    Then Select Leave Type from list of Values from LM adminstration "LeaveType"
    Then Enter Start and End Date duration on LM Adm page "StartDate","EndDate"
    Then Click on Save button
    Then Click on Submit button
    Then Accepting the Warning "WrningMsg"
    And Verify system allows admin to apply leave and Click OK
    
    
    