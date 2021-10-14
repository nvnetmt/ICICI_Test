#####################################################
#Script Name: T013_VerifyTheDurationOfMusterRegularizationAE
#Description/Action: Verify the Duration of Muster Regularization -AE 
#Manual Test Case used: T013 - Verify the Duration of Muster Regularization -AE
#Track/Module: Absence
#Regions to be executed:
#Developed By: OFS
#Date Created: 23-07-2021
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

  @T013
  Scenario:T013_VerifyTheDurationOfMusterRegularizationAE
    #Databank parameters "DataBankSheetName", "RowNum"
    Then Input Data bank "T013","1"
    Given User logs into application "Username","Password"
    When Click on Home button
    Then Navigate to Leave and Muster Page
    And Click on Apply Leave and Muster
    Then Select Leave Type from list of Values "LeaveType"
    And Enter Start and End Date Time duration "StartDateTime","EndDateTime"
    And Verify the duration of the leaves "StartDateTime","EndDateTime"
    Then Select Reason "LeaveReason"
    And Click on Save button
    Then Click on Existing Leave and Muster
    And Select the Saved leave request "LeaveType","StartDate","EndDate","LeaveStatus"
    And Click on Submit button
