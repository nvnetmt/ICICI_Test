#####################################################
#Script Name: Create Cancel Delete Goals
#Description/Action:  HR Specialist can create cancel and delete all the goals.			
#Manual Test Case used: Delete Goals
#Track/Module: Goal Managements
#Regions to be executed:
#Developed By: OFS
#Date Created: 14-Dec-2020
#Date Last Updated:
#Script Location:
#Databank Used: Yes/No: Yes
#Data Bank location:src/test/java/com/oracle/ICICI/HCM/databank
#Data Bank parameters:
#Feature File Name/s: Delete Goals
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

@DeleteGoalEmp
Scenario:  DeleteGoal_Emp

Given User logs into application

#Databank parameters "DataBankSheetName", "RowNum"
Then Input Data bank "DeleteGoalsEmp","1"
When Click on Home button
Then Navigate To Me Menu
Then Navigate To Emp Goals page
Then Perform delete goal by Employee "Review Period" "GoalPlan"
Then Validate the delete goal by nonadmin "GoalPlan"

@DeleteGoalManager
Scenario:  DeleteGoal_Manager

Given User logs into application

#Databank parameters "DataBankSheetName", "RowNum"
Then Input Data bank "DeleteGoalsMang","1"
When Click on Home button
Then Navigate To My Team Menus
Then Navigate To Manager Goals page
Then Select Emp from manager list "Employee"
Then Perform delete goal by Employee "Review Period" "GoalPlan"
Then Validate the delete goal by nonadmin "GoalPlan"

@DeleteGoal_HR
Scenario:  DeleteGoal_HR

Given User logs into application

#Databank parameters "DataBankSheetName", "RowNum"
Then Input Data bank "DeleteGoals","1"
When Click on Home button
Then Navigate To My Client Group Menus
Then Navigate To Setup of Performance GoalsPage
Then Perform Delete action "Review Period" "Employee" "GoalPlan"
