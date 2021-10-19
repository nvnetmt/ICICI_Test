#####################################################
#Script Name:   Manage_Eligibility_Profile
#Description/Action: HR creates manage eligibility profile.
#Manual Test Case used: Manage Eligibility Profile
#Track/Module: Goals Managements Adminatrators
#Date Created:     25-Nov-2020
#Date Last Updated:
#Script Location:
#Parameters Available: Yes/No: Yes-Feature File(Refer Examples)
#Feature File Name/s used:    Manage_Eligibility_Profile
#Unique Data Required or Not:    Yes -
#Pre-Requisites (if Any)
#Automated Script to be executed as pre-req(if any): No
#Status Of script : (Dev/Review/Complete) - Dev
#Comments (if any):
#####################################################
Feature: Manage_Eligibility_Profile

  Background: 
    Given Setup Reporting for ICICI

  @HR_creates_manage_eligibility_profile
  Scenario: Manage_Eligibility_Profile
    #Databank parameters "DataBankSheetName", "RowNum"
    Then Input Data bank "ManageEligibilityProfile","1"
    Given User logs into application
    When Click on Home button
    Then Navigate To Eligibility Profiles page
    Then Click On Create Participant Profile icon
    Then Enter Eligibility Profile Definition "Name", "Description", "ProfileUsage", "Status"
    Then Enter Eligibility Criteria "Gender", "Grade", "Department"
    And Save Eligiblity Profile
    Then Verifiy the generated Eligiblity Profile
    Then User logs out of Fusion application
