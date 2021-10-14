#####################################################
#Script Name: T002_EnsurePrivilegedLeaveApplicableForContractEmployeeWhoIsConfirmed
#Description/Action: Apply Contract Privilege Leave by Contingent worker
#Manual Test Case used: T002 - Ensure Privileged leave is applicable for Contract employee who is confirmed 
#Track/Module: Absence
#Regions to be executed:
#Developed By: OFS
#Date Created: 30-07-2021
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

  @T002
  Scenario:T002_EnsurePrivilegedLeaveApplicableForContractEmployeeWhoIsConfirmed
    #Databank parameters "DataBankSheetName", "RowNum"
    Then Input Data bank "T002","1"
    Given User logs into application "Username","Password"
    When Click on Home button
    Then Navigate to Leave and Muster Page
    And Click on Apply Leave and Muster
    Then Select Leave Type from list of Values "LeaveType"
    And Enter Start and End Date duration "StartDate","EndDate"
    And Click on Submit button

