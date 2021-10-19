#####################################################
#Script Name: T019_EnsureCasualLeaveIsNotApplicableForEmployeeWhoIsOnProbation
#Description/Action: Ensure Casual leave is not applicable for Employee who is on probation
#Manual Test Case used: T019 - Ensure Casual leave is not applicable for Employee who is on probation
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

  @T019
  Scenario:T019_EnsureCasualLeaveIsNotApplicableForEmployeeWhoIsOnProbation
    #Databank parameters "DataBankSheetName", "RowNum"
    Then Input Data bank "T019","1"
    Given User logs into application "Username","Password"
    When Click on Home button
    Then Navigate to Leave and Muster Page
    And Click on Apply Leave and Muster
    Then Search for Leave Type from list of Values "LeaveType"
    
