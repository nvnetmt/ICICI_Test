#####################################################
#Script Name: T022_EmployeeAppliesForFertilityLeaveWithSomeotherAttachmentAndNotDoctorsCertificate
#Description/Action: Employee applies for fertility Leave without doctors certificate
#Manual Test Case used: T021 - Employee applies for fertility Leave without doctors certificate
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

  @T022
  Scenario:T022_EmployeeAppliesForFertilityLeaveWithSomeotherAttachmentAndNotDoctorsCertificate
    #Databank parameters "DataBankSheetName", "RowNum"
    Then Input Data bank "T022","1"
    Given User logs into application "Username","Password"
    When Click on Home button
    Then Navigate to Leave and Muster Page
    And Click on Apply Leave and Muster
    Then Select Leave Type from list of Values "LeaveType"
    And Enter Start and End Date duration "StartDate","EndDate"
    Then Upload the Attachment "PathOfFile"
    And Click on Submit button
    

