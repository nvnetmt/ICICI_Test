#####################################################
#Script Name:   MassAssignGoals 
#Description/Action: HR Specialist can assign one goal or list goals to multiple workers.
#Manual Test Case used: Mass Assign Goals  
#Track/Module: Goals Managements Adminstrators
#Date Created:     02-Dec-2020
#Date Last Updated:
#Script Location:
#Parameters Available: Yes/No: Yes-Feature File(Refer Examples)
#Feature File Name/s used:    MassAssignGoals
#Unique Data Required or Not:    Yes - 
#Pre-Requisites (if Any)
#Automated Script to be executed as pre-req(if any): No
#Status Of script : (Dev/Review/Complete) - Dev
#Comments (if any):
#####################################################
Feature:  MassAssignGoals

Background: 
	Given Setup Reporting for ICICI

  @HR_MassAssignGoals
  Scenario:  MassAssignGoals

Given User logs into application

#Databank parameters "DataBankSheetName", "RowNum"
 Then Input Data bank "MassAssignGoals","1"
When Click on HomeButton
Then Navigate To My Client Group Menus
Then Navigate To Setup of Performance Goals Mass Assignment Page
Then Enter Process Details and validate"ProcessName" "ReviewProcess" "Worker" "GoalSheet" "CategoryGoalPlanName" "categoryMeasurements" "Perspective"
Then Navigate To My Client Group Menus
Then Navigate To Scheduled Processes for Performance Goals Page
Then Run the batch process and validate