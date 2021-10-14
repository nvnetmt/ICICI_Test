#####################################################
#Script Name: PrintExistingGoals
#Description/Action: Employee can print his goals. Line Manager can do the same for his Directs.
#Manual Test Case used: Print existing goals
#Track/Module: Goal Managements
#Regions to be executed:
#Developed By: OFS
#Date Created: 04-Dec-2020
#Date Last Updated:
#Script Location:
#Databank Used: Yes/No: Yes
#Data Bank location:src/test/java/com/oracle/ICICI/HCM/databank
#Data Bank parameters:
#Feature File Name/s: PrintExistingGoals
#Unique Data Required or Not: Yes
#Pre-Requisites (if Any):
#Automated Script to be executed as pre-req(if any):
#Status Of script(Dev/Review/Complete): Dev
#Comments (if any):
#####################################################

@PrintExistingGoals
Feature:  PrintExistingGoals

Background: 
	Given Setup Reporting for ICICI

@PrintExistingGoalsForEmployee
Scenario:  PrintExistingGoalsForEmployee
#Databank parameters "DataBankSheetName", "RowNum"
Then Input Data bank "PrintExistingGoals","1"
Given User logs into application "Username","Password"
When Click on Home button
Then Navigate To My Goals page
Then Select Review Period and Goal Plan for viewing the goal details "ReviewPeriod" "GoalSheet"
Then User logs out of Fusion application

@PrintExistingGoalsForLineManger
Scenario:  PrintExistingGoalsForLineManger
#Databank parameters "DataBankSheetName", "RowNum"
Then Input Data bank "PrintExistingGoalsForManager","1"
Given User logs into application "Username","Password"
When Click on Home button
Then Navigate To My Team Goals page
And Click on Worker's name
Then Select Review Period and Goal Plan for viewing the goal details "ReviewPeriod" "GoalSheet"
Then User logs out of Fusion application

@PrintExistingGoalsForLineManger
Scenario:  PrintExistingGoalsForLineManger
#Databank parameters "DataBankSheetName", "RowNum"
Then Input Data bank "PrintExistingGoalsForHRAdmin","1"
Given User logs into application "Username","Password"
When Click on Home button
Then Navigate to Performance Goals Page
And Enter Review Period and Employee Name "ReviewPeriod", "EmployeeName"
Then Click on Employee Name
Then Select Review Period and Goal Plan for viewing the goal details "ReviewPeriod" "GoalSheet"
Then User logs out of Fusion application




