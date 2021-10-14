#####################################################
#Script Name:   DetermineEmployeeEligibilityforPerformanceDocument
#Description/Action: HR Can change the due dates of different tasks of performance document. 
#Manual Test Case used: DetermineEmployeeEligibilityforPerformanceDocument
#Track/Module: Performance Managements
#Date Created:     18-Dec-2020
#Date Last Updated:
#Script Location:
#Parameters Available: Yes/No: Yes-Feature File(Refer Examples)
#Feature File Name/s used:    DetermineEmployeeEligibilityforPerformanceDocument
#Unique Data Required or Not:    Yes - 
#Pre-Requisites (if Any)
#Automated Script to be executed as pre-req(if any): No
#Status Of script : (Dev/Review/Complete) - Dev
#Comments (if any):
#####################################################
Feature:  DetermineEmployeeEligibilityforPerformanceDocument

Background: 
	Given Setup Reporting for ICICI 

  @HR_DetermineEmployeeEligibilityforPerformanceDocument
  Scenario:  DetermineEmployeeEligibilityforPerformanceDocument


Given User logs into application
#Databank parameters "DataBankSheetName", "RowNum"
 Then Input Data bank "DetermineEmpEligiforPerfDoc","1"
 When Click on HomeButton
Then Navigate To My Client Group Menus
Then Navigate To Performance Document Eligibility page
Then Search for the desired employee and open "EmployeeId" "EmployeeName"
Then Add Eligibility and verify "ReviewPeriod" "PerformanceDocument"
Then Edit Eligibility Profile "EligiblityStatus"

