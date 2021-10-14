#####################################################
#Script Name:   Review_Periods
#Description/Action: HR creates a new review period.
#Manual Test Case used: Review_Periods
#Track/Module: Goals Managements Adminatrators
#Date Created:     17-Nov-2020
#Date Last Updated:
#Script Location:
#Parameters Available: Yes/No: Yes-Feature File(Refer Examples)
#Feature File Name/s used:   Review_Periods
#Unique Data Required or Not:    Yes -
#Pre-Requisites (if Any)
#Automated Script to be executed as pre-req(if any): No
#Status Of script : (Dev/Review/Complete) - Dev
#Comments (if any):
#####################################################
Feature: Review_Periods

  Background: 
    Given Setup Reporting for ICICI

  @HR_creates_a_new_review_period
  Scenario: ReviewPeriod_HR
    Given User logs into application
    #Databank parameters "DataBankSheetName", "RowNum"
    Then Input Data bank "ReviewPeriod","1"
    When Click on Home button
    Then Navigate To Review Periods Page
    Then Create Review Period "ReviewPeriodName", "Description", "Status",  "PeriodStartDate", "PeriodEndDate"
    Then Verifiy Review Period
    Then User logs out of Fusion application
