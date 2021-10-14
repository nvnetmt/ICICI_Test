#####################################################
#Script Name:   AddPerformanceGoalsByEmp
#Description/Action: Manager and Employee agrees on a set of goals on which an employee supposed to work during the appraisal year. Both (Employee and Line Manager) can add these goals.
#Manual Test Case used: Add Performance Goals (By Employee)
#Track/Module: Goals Managements Employee
#Date Created:     15-Dec-2020
#Date Last Updated:
#Script Location:
#Parameters Available: Yes/No: Yes-Feature File(Refer Examples)
#Feature File Name/s used:    AddPerformanceGoalsByEmpAndMgr
#Unique Data Required or Not:    Yes -
#Pre-Requisites (if Any)
#Automated Script to be executed as pre-req(if any): No
#Status Of script : (Dev/Review/Complete) - Dev
#Comments (if any):
#####################################################
Feature: AddPerformanceGoals

  Background: 
    Given Setup Reporting for ICICI

  @AddPerformanceGoalsByEmployee
  Scenario: AddPerformanceGoals_ByEmployee
    Given User logs into application
    #Databank parameters "DataBankSheetName", "RowNum"
    Then Input Data bank "AddPerformanceGoalsByEmployee","1"
    When Click on Home button
    Then Click Me and navigate to Goals page
    Then Select Review Period and Goal Sheet "ReviewPeriod", "GoalSheet"
    Then Click Add button to Add Goal
    Then Ener Basic Info "GoalName", "Measurement", "StartDate", "TargetCompletionDate", "Perspective", "Weight"
    Then Save Goal
    Then Submit Goal
    Then User logs out of Fusion application
