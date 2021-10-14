#####################################################
#Script Name: T014_LeaveSubmittedByGrade300AndAboveShouldBeAutoApproved
#Description/Action: Leave submitted by Grade 300 and above should be auto approved
#Manual Test Case used: T014 - Leave submitted by Grade 300 and above
#Track/Module: Absence
#Regions to be executed:
#Developed By: OFS
#Date Created: 27-07-2021
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

  @T014
  Scenario:T014_LeaveSubmittedByGrade300AndAboveShouldBeAutoApproved
    #Databank parameters "DataBankSheetName", "RowNum"
    Then Input Data bank "T014","1"
    Given User logs into application "Username","Password"
    When Click on Home button
    Then Navigate to Leave and Muster Page
    And Click on Apply Leave and Muster
    Then Select Leave Type from list of Values "LeaveType"
    And Enter Start and End Date duration "StartDate","EndDate"
    Then Select Start Date Duration "LeaveStartDateDuration"
    And Verify the duration of the leaves
    Then Enter Comments and Reason "LeaveComment"
    And Click on Save button
    Then Click on Existing Leave and Muster
    And Select the Saved leave request "LeaveType","StartDate","EndDate","LeaveStatus"
    And Click on Submit button
    Then Click on Home button
    Then Navigate to Leave and Muster Page
    Then Click on Existing Leave and Muster
    And Verify Whether Submitted Leave Request got Approved "LeaveType","StartDate","EndDate"
    
