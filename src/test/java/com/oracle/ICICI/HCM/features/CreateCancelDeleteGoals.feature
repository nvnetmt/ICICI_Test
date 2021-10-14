#####################################################
#Script Name: Create Cancel Delete Goals
#Description/Action:  HR Specialist can create cancel and delete all the goals.			
#Manual Test Case used: Create Cancel Delete Goals
#Track/Module: Goal Managements
#Regions to be executed:
#Developed By: OFS
#Date Created: 14-Dec-2020
#Date Last Updated:
#Script Location:
#Databank Used: Yes/No: Yes
#Data Bank location:src/test/java/com/oracle/ICICI/HCM/databank
#Data Bank parameters:
#Feature File Name/s: CreateCancelDeleteGoals
#Unique Data Required or Not: Yes
#Pre-Requisites (if Any):
#Automated Script to be executed as pre-req(if any):
#Status Of script(Dev/Review/Complete): Dev
#Comments (if any):
#####################################################

@Goals

Feature:  CreateGoalPlansOtherPlansNonPrimary

Background: 
	Given Setup Reporting for ICICI 

@CreateGoalPlansOtherPlansNonPrimary
Scenario:  CreateGoalPlansOtherPlansNonPrimary

Given User logs into application

#Databank parameters "DataBankSheetName", "RowNum"
Then Input Data bank "CreateGoalPlansOtherPlanNP","1"
When Click on HomeButton
Then Navigate To My Client Group Menus
Then Navigate To Goal Plan page
Then Click on Other Plan add button
Then Enter Goal plans details "GoalPlanName" "Measurements" "ReviewPeriod"
Then Enter Basic info Goal Plan details and Validate "CategoryGoalPlanName" "categoryMeasurements" "Perspective"
Then Enter eligilility Profile and validate "EligiblityProfile"
Then Save goal plan
Then Navigate To Goal Plan page
Then Validate goal plan

@CancelGoals
Scenario:  CancelGoals

Given User logs into application

#Databank parameters "DataBankSheetName", "RowNum"
 Then Input Data bank "CancelGoals","1"
When Click on HomeButton
Then Navigate To My Client Group Menus
Then Navigate To Setup of Performance GoalsPage
Then Perform Cancel action "Review Period" "Employee" "GoalPlan"
Then Validate the cancel goal

@DeleteGoal
Scenario:  DeleteGoal

Given User logs into application

#Databank parameters "DataBankSheetName", "RowNum"
 Then Input Data bank "DeleteGoals","1"
When Click on HomeButton
Then Navigate To My Client Group Menus
Then Navigate To Setup of Performance GoalsPage
Then Perform Delete action "Review Period" "Employee" "GoalPlan"
