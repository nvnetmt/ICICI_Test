#####################################################
#Script Name: PerformanceDocument
#Description/Action: HR Can change the due dates of different tasks of performance document
#Manual Test Case used: PerformanceDocument-Complete,Cancel,Reopen,Transfer,Delete,Restore
#Track/Module: Performance Managements
#Regions to be executed:
#Developed By: OFS
#Date Created: 17-Dec-2020
#Date Last Updated:
#Script Location:
#Databank Used: Yes/No: Yes
#Data Bank location:src/test/java/com/oracle/ICICI/HCM/databank
#Data Bank parameters:
#Feature File Name/s used:PerformanceDocument
#Unique Data Required or Not: Yes
#Pre-Requisites (if Any): Need to use HR Specialist crediential
#Automated Script to be executed as pre-req(if any):
#Status Of script(Dev/Review/Complete): Dev
#Comments (if any):
#####################################################

@PerformanceDocument
Feature:PerformanceDocument

Background: 
	
Given Setup Reporting for ICICI
		
@CompletePerformanceDocuments
Scenario:  CompletePerformanceDocuments

Given User logs into application
#Databank parameters "DataBankSheetName", "RowNum"
Then Input Data bank "CompletePerformanceDocuments","1"
When Click on HomeButton
Then Navigate To My Client Group Menus
Then Navigate To Performance Document page
Then Enter Required field and search the Performance Document "ReviewPeriod" "PerformanceDocument" "EmployeeNumber"
Then Complete document and verify

 @CancelPerformanceDocument
 Scenario:  CancelPerformanceDocument

Given User logs into application

#Databank parameters "DataBankSheetName", "RowNum"
 Then Input Data bank "CancelPerformanceDocument","1"
When Click on HomeButton
Then Navigate To My Client Group Menus
Then Navigate To Performance Document page
Then Enter Required field and search the Performance Document "ReviewPeriod" "PerformanceDocument" "EmployeeNumber"
Then Cancel the document and verify


@ReopenPerformanceDocuments
Scenario:  ReopenPerformanceDocuments

Given User logs into application

#Databank parameters "DataBankSheetName", "RowNum"
 Then Input Data bank "RestorePerformanceDocuments","1"
When Click on HomeButton
Then Navigate To My Client Group Menus
Then Navigate To Performance Document page
Then Enter Required field and search the Performance Document "ReviewPeriod" "PerformanceDocument" "EmployeeNumber"
Then Restore the document and verify


@TransferPerformanceDocument
Scenario:  TransferPerformanceDocument

Given User logs into application

#Databank parameters "DataBankSheetName", "RowNum"
 Then Input Data bank "TransferPerformanceDocument","1"
When Click on HomeButton
Then Navigate To My Client Group Menus
Then Navigate To Performance Document page
Then Enter Required field and search the Performance Document "ReviewPeriod" "PerformanceDocument" "EmployeeNumber"
Then Transfer Manager of document and verify "ManagerName" "ManagerEmpId"

@DeletePerformanceDocuments
Scenario:  DeletePerformanceDocuments

Given User logs into application

#Databank parameters "DataBankSheetName", "RowNum"

Then Input Data bank "DeletePerformanceDocuments","1"
When Click on HomeButton
Then Navigate To My Client Group Menus
Then Navigate To Performance Document page
Then Enter Required field and search the Performance Document "ReviewPeriod" "PerformanceDocument" "EmployeeNumber"
Then Delete the document and verify


@RestorePerformanceDocuments
Scenario:  RestorePerformanceDocuments

Given User logs into application

#Databank parameters "DataBankSheetName", "RowNum"
 Then Input Data bank "RestorePerformanceDocuments","1"
When Click on HomeButton
Then Navigate To My Client Group Menus
Then Navigate To Performance Document page
Then Enter Required field and search the Performance Document "ReviewPeriod" "PerformanceDocument" "EmployeeNumber"
Then Restore the document and verify

