#####################################################
#Script Name:   Review Team Goals
#Description/Action: Manager can view the goal summary for each direct report.
#Manual Test Case used: Review Team Goals
#Track/Module: Goals Managements Employee
#Date Created:     04-Dec-2020
#Date Last Updated:
#Script Location:
#Parameters Available: Yes/No: Yes-Feature File(Refer Examples)
#Feature File Name/s used:    PrintExistingGoalsForEmployee
#Unique Data Required or Not:    Yes -
#Pre-Requisites (if Any)
#Automated Script to be executed as pre-req(if any): No
#Status Of script : (Dev/Review/Complete) - Dev
#Comments (if any):
#####################################################
Feature: Review_Team_Goals

  Background: 
    Given Setup Reporting for ICICI

  @HR_Review_Team_Goals

  Scenario: Review_Team_Goals
    Given User logs into application
    #Databank parameters "DataBankSheetName", "RowNum"
    Then Input Data bank "ReviewTeamGoals","1"
    When Click on Home button
    Then Navigate to Goals and Performance Overview page
    Then Select First Direct Reportee
    Then Go to Goals section
    Then Select Review Period and Goal Sheet "ReviewPeriod", "GoalSheet"
    Then Verify Goal List displayed
    Then User logs out of Fusion application

